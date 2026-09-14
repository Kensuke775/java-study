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
