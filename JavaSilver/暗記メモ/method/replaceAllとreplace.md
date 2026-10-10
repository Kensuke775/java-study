# replaceAll と replace（正規表現かリテラルか）

## どちらもStringクラスのメソッド、戻り値は両方とも`String`

| メソッド | シグネチャ | 戻り値の型 |
|---|---|---|
| `replaceAll` | `String replaceAll(String regex, String replacement)` | `String` |
| `replace` | `String replace(CharSequence target, CharSequence replacement)` | `String` |

`String`は不変（イミュータブル）なので、どちらのメソッドも**呼び出し元の文字列自体を書き換えるのではなく、置換後の新しい`String`インスタンスを返す**。戻り値を受け取らずに呼び出すだけでは、元の文字列は一切変化しない。

## 検証コード

```java
String s = "a1b2c3";
s.replaceAll("[0-9]", "-");   // → "a-b-c-"（正規表現：数字を全部置換）
s.replaceAll("a", "X");       // → "X1b2c3"（普通の文字も正規表現として扱われる）
s.replace("1", "-");          // → "a-b2c3"（リテラル置換）

String dot = "a.b.c";
dot.replace(".", "-");        // → "a-b-c"（"."をただの文字として置換）
dot.replaceAll(".", "-");     // → "-----"（"."が正規表現の「任意の1文字」として扱われる！）
```
→ 検証済み。

## 誤解しやすい点：「All」の有無は「全部か最初だけか」の違いではない

```java
String s = "aXbXcX";
s.replace("X", "-");        // → "a-b-c-"（全部置換される）
s.replaceAll("X", "-");     // → "a-b-c-"（全部置換される）
s.replaceFirst("X", "-");   // → "a-bXcX"（最初の1つだけ置換される）
```
→ 検証済み。

`replace`も`replaceAll`も、**どちらも見つかった箇所を全部置換する**。名前に「All」が付いているかどうかで「全部か最初だけか」が決まるわけではない。「最初の1つだけ」を置換したい場合は、別に用意されている`replaceFirst(String regex, String replacement)`（こちらも正規表現扱い）を使う。

## 決定的な違い：第1引数を正規表現として解釈するかどうか

| メソッド | 第1引数の扱い |
|---|---|
| `replaceAll(String regex, String replacement)` | **正規表現**として解釈される |
| `replace(CharSequence target, CharSequence replacement)` | **リテラル文字列**そのまま（正規表現ではない） |

`replaceAll("[0-9]", "-")`のように、正規表現のパターン（文字クラス`[0-9]`など）を使って一括置換したい時は`replaceAll`を使う。

## 落とし穴：`.`や`+`など正規表現の特殊文字を含む文字列を置換したい時

```java
"a.b.c".replace(".", "-");       // → "a-b-c"（意図通り、ドットだけを置換）
"a.b.c".replaceAll(".", "-");    // → "-----"（.が「任意の1文字」を意味してしまい、全文字が置換される）
```

`.`は正規表現において「改行以外の任意の1文字」を意味する特殊文字。**「ドットという文字そのものを置換したい」場合に`replaceAll`を使うと、意図とは全く違う結果になる**、という典型的な引っかけポイント。正規表現の特殊文字（`.` `*` `+` `?` `[` `]` `(` `)`など）を含む文字列を**そのままの文字**として置換したいなら`replace`を使うべき（`replaceAll`を使うなら`\\.`のようにエスケープが必要）。

## まとめ

- `replaceAll`：第1引数は**正規表現**。パターンマッチで一括置換したい時に使う
- `replace`：第1引数・第2引数とも**ただの文字列（リテラル）**。特殊文字を気にせず単純な文字列置換をしたい時に使う
