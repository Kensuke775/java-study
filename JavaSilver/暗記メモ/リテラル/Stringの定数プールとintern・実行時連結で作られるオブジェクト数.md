# Stringの定数プールとintern()・実行時連結で作られるオブジェクトの数え方

## 前提：3種類のStringオブジェクトの生まれ方

| 書き方 | 生まれる場所 | 既存と同じ内容なら再利用するか |
|---|---|---|
| `"java"`（リテラル） | 定数プール | 同じ内容が既にプールにあれば**再利用**（新規生成なし） |
| `new String("java")` | ヒープ | 常に**新規生成**（プールに同じ内容があっても無関係） |
| `a + b`（変数同士の実行時連結） | ヒープ | 常に**新規生成**（結果の内容がプールと一致していても無関係） |
| `"a" + "b"`（リテラル同士の連結） | 定数プール | コンパイル時に`"ab"`へ畳み込まれるので、リテラルと同じ扱い（再利用される） |

## 検証1：`new String(...)`とintern()

```java
String string = "java";
String string1 = new String("java");
String string2 = new String("java");
String newString = string2.intern();

// string == newString → true
// string == string1, string == string2, string1 == string2 → すべてfalse
```
→ 検証済み。合計3個（①プールの`"java"`、②`string1`の実体、③`string2`の実体）。`newString`は新規オブジェクトではなく①への参照。

## 検証2：実行時連結は中身が一致していても別オブジェクト

```java
String literal = "java";
String runtimeConcat = ja.toLowerCase().substring(0,2) + va;   // 中身は"java"
String compileTimeConcat = "ja" + "va";                         // リテラル同士

// literal == runtimeConcat → false（別オブジェクト）
// literal == compileTimeConcat → true（コンパイル時に畳み込まれ同一視される）
```
→ 検証済み。「いつ連結するか（コンパイル時 or 実行時）」で結果が変わる。変数を経由する限り、中身が一致していてもコンパイラは値を確定できないため、実行時に新しいオブジェクトを作る。

## 検証3：大文字小文字は完全に別の文字列（一致判定に無関係）

```java
String ja = "Ja";   // 大文字J
String va = "va";
String concatResult = ja + va;   // → "Java"（大文字J）

// "java"(小文字)とはequalsでもfalse
```
→ 検証済み。`String`は大文字小文字を区別するので、`"Java"`と`"java"`はそもそも中身が違う別の文字列。「同じ`java`を作ろうとしている」という前提自体が崩れる点に注意。

## 検証4：`intern()`は「呼ばれた後に新規生成しない」だけで、呼ぶ前の一時オブジェクトは既に生成済み

```java
String string = "java";
String ja = "ja";
String va = "va";

String concatBeforeIntern = ja + va;         // ④ 実行時連結で新規生成（一時オブジェクト）
String java = concatBeforeIntern.intern();   // 新規生成なし、①への参照を返す

// string == java → true
// string == concatBeforeIntern → false（④は別実体）
```
→ 検証済み。合計は①`"java"`（プール）＋②`"ja"`（プール）＋③`"va"`（プール）＋④`ja+va`の一時オブジェクト（ヒープ）＝**4個**。`java`変数自体は①を指すだけで、5個目にはならない。

`intern()`は「その内容が既にプールにあれば、新しいオブジェクトを追加せず既存の参照を返す」という動作。しかし`intern()`を呼ぶ**前**に、`ja + va`という実行時連結によって一時オブジェクトが既に作られてしまっている点は変わらない（GC対象になるだけで、生成された事実は消えない）。

## 検証5：intern()を呼ばなければ、実行時連結の結果はプールの既存文字列と別物のまま

```java
String string = "java";
String ja = "ja";
String va = "va";

String java = ja + va;   // internなし

// string == java → false（別実体のまま）
```
→ 検証済み。合計は①`"java"`＋②`"ja"`＋③`"va"`＋④`ja+va`の実体＝**4個**。ただし`java`変数はここでは④を指すので、`string`とは別物になる（`intern()`を呼んだ場合との違い）。

## まとめ

| コード | `string == java`（結果の文字列）| 生成される総オブジェクト数（string, ja, va込み） |
|---|---|---|
| `String java = ja + va;`（internなし） | `false`（④という別実体） | 4個 |
| `String java = (ja + va).intern();`（internあり） | `true`（①と同一） | 4個（④は生成されるがjavaは①を指す） |

- 定数プールへの登録は「リテラルが最初に登場した時」に発生する。中身が同じでも、変数同士の実行時連結・`new String(...)`は毎回新しいヒープオブジェクトを作る
- `intern()`は「呼んだ後に、その内容と同じものが既にプールにあれば、新規生成せず既存の参照を返す」動作。ただし呼ぶ前段階で既に作られた一時オブジェクトの存在は無かったことにならない
- 大文字小文字は区別されるので、"Java"と"java"のような違いは「同じ文字列を作ろうとしている」という前提自体を崩す
