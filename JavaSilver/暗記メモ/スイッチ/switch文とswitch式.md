# switch文とswitch式

## 2つの書き方：コロン形式とアロー形式

| | コロン形式（従来） | アロー形式（新しい） |
|---|---|---|
| 書き方 | `case 1: ...` | `case 1 -> ...` |
| フォールスルー（貫通） | する（`break`が無いと次のcaseに進む） | しない（1つのcaseだけ実行して終わる） |
| switch式で値を返す方法 | `yield`文が必要 | 式をそのまま書けばOK（`yield`不要） |

## switch式で`yield`を使う（コロン形式）

```java
int result = switch (day) {
    case 1:
    case 2:
        yield 10;
    case 3:
        yield 20;
    default:
        yield 0;
};
```
→ コンパイル成功（検証済み）。コロン形式をswitch**式**として使う場合は、各分岐で必ず`yield`（`return`ではない）を使って値を返す必要がある。

## switch式は「値を持つ式」なので、値が使える場所ならどこでも直接埋め込める

「switch式の結果は、一度変数に代入しないと使えない」というのは誤解。switch式そのものが値を持つ式である以上、**代入・`return`・引数渡しなど、値が使えるあらゆる場所にそのまま書ける**。

```java
// パターン1：変数に代入
int result = switch (x) { case 1 -> 10; default -> 0; };

// パターン2：そのままreturn
public static String test(int value) {
    return switch (value) {
        case 10, 20 -> "D";
        case 30, 40 -> "C";
        default -> "E";
    };
}

// パターン3：メソッドの引数としてそのまま渡す
System.out.println(switch (x) { case 1 -> "A"; default -> "B"; });
```
→ いずれも検証済み。すべてコンパイル・実行成功。

コロン形式（`yield`を使う書き方）でも同様に、代入・`return`・引数渡しのどこでも使える。

```java
public static String test(int value) {
    return switch (value) {
        case 10:
        case 20:
            yield "D";
        case 60:
            yield "B";
        default:
            yield "E";
    };
}
```
→ 検証済み。コンパイル・実行成功。

**まとめ**：アロー形式でもコロン形式（`yield`）でも、「値をどうやって作るか（書き方）」が違うだけで、「その式全体をどこで使えるか」には差が無い。switch式は代入専用のものではなく、`return`や引数など値が要求されるあらゆる場所に直接埋め込める、という理解が正確。

## アロー（`->`）の右側に置けるのは「式・ブロック・throw文」の3つだけ。`return`は書けない

### 「式」と「文」の違い

- **式（expression）**：評価すると1個の「値」になるもの（例：`"ok"`、`1 + 2`、`total++`）
- **文（statement）**：「〜しなさい」という1つの完結した動作・命令（例：`return "ok";`、`if (...) {...}`）

`return "ok";`は「メソッドを終了して値を呼び出し元に渡しなさい」という**動作の命令（文）**であって、それ自体は「値」ではない。だから「式が要求される場所」には置けない。

### 検証1：switch式のcase内でreturnを直接書く → NG

```java
String result = switch(str){
    case "Java" -> return "ok";   // ← NG
    default -> "no";
};
```
```
エラー: 式の開始が不正です
```
→ 検証済み。

### 検証2：switch文であっても、アロー構文でreturnを直接書く → NG

```java
switch(str){
    case "Java" -> return "ok";   // ← switch文でもNG
    default -> return "no";
}
```
```
エラー: caseの予期しない文です。予期されるのは、式、ブロックまたはthrow文です
```
→ 検証済み。switch式か switch文かに関わらず、**アロー構文の右側**に置けるのは「式・ブロック・`throw`文」の3種類だけという制約がある。

### 検証3：ブロック`{ }`で包めばOK

```java
switch(str){
    case "Java" -> {
        return "ok";
    }
    default -> {
        return "no";
    }
}
```
→ `ok`と表示され成功。検証済み。ブロック`{ }`の中はただの通常の文の並びになるので、制約が外れて`return`も書ける。

### 検証4：コロン形式なら制約なくreturnを書ける

```java
switch(str){
    case "Java": return "ok";
    default: return "no";
}
```
→ コンパイル・実行成功。コロン形式は昔ながらの「複数の文をただ並べる」スタイルなので、`return`をそのまま書いても何の制約もない。

### まとめ

| 書き方 | `return`を直接書けるか |
|---|---|
| `case "X": return "ok";`（コロン形式） | ✅ 書ける（文の並びなので制約なし） |
| `case "X" -> return "ok";`（アロー形式・裸） | ❌ 書けない（式・ブロック・throw文しか置けない） |
| `case "X" -> { return "ok"; }`（アロー形式・ブロック） | ✅ 書ける（ブロックの中は普通の文なので制約が外れる） |

**アロー構文だけが「右側に置けるものの種類」を限定している**、という点がコロン形式との決定的な違い。

## アロー構文はswitch式専用ではない。switch文でも使える（問題25）

```java
int execute(String str) {
    int total = 0;
    switch (str) {
        case "A" -> total++;
        case "B", "C" -> total++;
        case "D", "E" -> total++;
        default -> total++;
    };
    return total;
}
```
→ `new Test().execute("A")`は`1`を返す。コンパイル・実行とも成功。検証済み。

このコードは`switch`全体が何にも代入されておらず（`return total;`は別の行）、**switch文**として使われている。それでいて各`case`の書き方には**アロー構文**を採用している。「`->`（アロー）かどうか」と「switch文かswitch式か」は独立した軸であり、「アロー＝switch式」という理解は誤り。

| | colon形式（`case X:`） | arrow形式（`case X ->`） |
|---|---|---|
| switch文（値を返さない） | 従来からある書き方（`break`が必要） | ✅ 今回のような書き方も可能 |
| switch式（値を返す） | `yield`が必要 | よく見る書き方 |

### アロー構文のswitch文でも、defaultは不要

```java
switch (str) {
    case "A" -> total++;
    case "B", "C" -> total++;
}
return total;
```
→ `"Z"`のようにどのcaseにも一致しない値を渡しても、コンパイル・実行とも成功し`0`が返る（何も実行されずスルーされる）。検証済み。アロー構文であっても、**switch文である限りdefaultは不要**（下記の「switch文とswitch式でdefaultの必須/不要が違う」ルールがそのまま適用される）。

## switch「文」とswitch「式」で、defaultの必須/不要が違う

### switch文（値を返さない、従来の使い方）→ defaultは不要

```java
switch (x) {
    case 1:
        System.out.println("one");
        break;
}
System.out.println("done");
```
→ コンパイル成功（検証済み）。該当するcaseが無ければ何もせず素通りするだけなので、`default`が無くても問題ない。

### switch式（値を返す）→ 原則defaultが必須

```java
int result = switch (x) {   // xはint
    case 1 -> 10;
    case 2 -> 20;
};
```
```
エラー: switch式がすべての可能な入力値をカバーしていません
```
→ コンパイルエラー（検証済み）。switch式は**必ずどこかの分岐で値を返せることが保証されていないといけない**。`int`のような値は無数の可能性があるので、全部を`case`で網羅することはできず、`default`で「その他すべて」を受け止める必要がある。

### 例外：enum・sealed型などで全パターンを`case`で網羅していればdefault不要

```java
enum Color { RED, BLUE }
...
String result = switch (c) {   // cはColor型
    case RED -> "赤";
    case BLUE -> "青";
};
```
→ コンパイル成功（検証済み）。`enum`は取りうる値が`RED`と`BLUE`だけと決まっているため、両方を`case`で書けば「網羅済み」と判定され、`default`が無くてもOK。

**まとめ**：
- switch文（値を返さない） → defaultはいつでも任意
- switch式（値を返す） → 原則default必須。ただし`enum`・`sealed`型などで全ケースを`case`で網羅していれば省略可能

## switchに`null`を渡すと実行時に`NullPointerException`

```java
static String str;   // フィールドなのでデフォルト値null
switch (str) {
    case "10": ...
}
```
```
Exception in thread "main" java.lang.NullPointerException:
Cannot invoke "String.hashCode()" because "<local1>" is null
```

switch式でも同様。

```java
String s = null;
String result = switch (s) {
    case "a" -> "A";
    default -> "D";
};
```
→ 実行時に`NullPointerException`（検証済み）。

`switch(対象)`は内部的に対象の`equals()`/`hashCode()`を呼び出して各`case`と比較する動きをするため、対象がそもそも`null`だと、比較する前に`null`に対してメソッドを呼ぼうとして例外が発生する。**`default`があっても`null`は救われない**（`default`はあくまで「該当するcaseが無かった値」用で、「そもそも比較できない`null`」とは別の扱い）という点に注意。

（Java 21以降ではプレビュー機能として`case null ->`で明示的にnullを処理できるようになったが、Java 17ベースのSilver試験の標準的な範囲では対象外。今回の検証環境（Java 17）でも`case null`はプレビュー機能扱いでデフォルト無効だった）

## `continue`と`break`は、switchの中では効き先が違う

```java
List<String> words = Arrays.asList(new String[]{"A","B","C","D","E"});
for (String word : words) {
    switch (word) {
        case "B" : continue;
        case "D" : break;
        default : System.out.print(word);
    }
    System.out.print(":");
}
```
```
A:C::E:
```
→ 検証済み。

- **`continue`**：switchではなく、**外側の`for`ループ**に効く。「そのループの残り（switch以降の処理も含めて全部）をスキップして、次の周回に進む」
- **`break`**：**switch文だけ**を抜ける。`for`ループには一切影響しない。switchを抜けた後の処理（switchの外にある文）はそのまま続けて実行される

### 1周ずつ追う

| word | switchの分岐 | 動作 | 出力 |
|---|---|---|---|
| A | どこにもマッチせず`default` | `print("A")` → switch終了 → `print(":")` | `A:` |
| B | `case "B"` | `continue` → **forループの次の周へ即ジャンプ**（switch以降の`print(":")`すら実行されない） | （何も出ない） |
| C | どこにもマッチせず`default` | `print("C")` → switch終了 → `print(":")` | `C:` |
| D | `case "D"` | `break` → **switchだけ抜ける** → 続けて`print(":")`が実行される（`default`は実行されないので文字は出ない） | `:` |
| E | どこにもマッチせず`default` | `print("E")` → switch終了 → `print(":")` | `E:` |

繋げると：`A:` + （何も無し） + `C:` + `:` + `E:` = **`A:C::E:`**

**ポイント**：「`break`はswitchしか抜けない」ため、switchの外側にある処理（今回の`print(":")`）は`break`後も普通に実行される。一方`continue`は「switchの外」まで含めてループの残り全部を吹き飛ばす、という**影響範囲の広さの違い**がこの問題の核心。
