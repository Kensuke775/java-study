# `args[0].length()`は配列の`.length`ではなくStringの`.length()`（問題13）

## お題

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(args[0].length());
    }
}
```
コマンド：`java Main`（引数なし）で実行すると？

→ 答えは **`ArrayIndexOutOfBoundsException`が発生する**。

## 混同しやすいポイント：配列の`.length`とStringの`.length()`は別物

| 対象 | 書き方 | 種類 |
|---|---|---|
| 配列（`array.length`） | `.length` | プロパティ（フィールド、丸括弧なし） |
| `String`（`str.length()`） | `.length()` | メソッド（丸括弧あり） |

`args`は`String[]`なので、`args[0]`は**1個のString**。`String`クラスは`length()`という**メソッド**（丸括弧あり）を持っており、文字列の文字数を返す。`args[0].length()`は「配列の0番目の要素（＝1個のString）」に対して「Stringのlength()メソッド」を呼んでいるだけで、構文として何も間違っていない。

## なぜArrayIndexOutOfBoundsExceptionになるのか

```java
System.out.println(args.length);   // → 0（引数なしで実行した場合）
```
→ 検証済み。

`java Main`（引数なし）で実行した場合、`args`は`null`ではなく**要素数0の配列**になる（Javaの仕様上、`main`の`args`は引数が無くても`null`にはならず必ず「空の配列」になる）。

[[空の配列リテラル{}は長さ0（0番目は存在しない）]]と同じ構造で、`args[0]`という時点で「存在しないインデックスへのアクセス」となり、`.length()`を呼ぶ前段階で例外が発生する。

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	at Main.main(Main.java:4)
```
→ 検証済み。

## もし「要素はあるが中身がnull」だったら

`args[0]`自体は存在するが、その中身（String実体）が`null`だった場合、`args[0].length()`を呼ぶと**`NullPointerException`**になる（[[nullの配列にlengthでNPE]]と同じ理屈：`null`に対して`.`でアクセスしようとした場合の話）。

## まとめ

| 状況 | 結果 |
|---|---|
| `args`が要素数0（引数なしで実行） | `args[0]`の時点で`ArrayIndexOutOfBoundsException` |
| `args[0]`は存在するが中身が`null` | `.length()`呼び出しで`NullPointerException` |
| `args[0]`が存在し中身も正常な文字列 | 正常に文字数が返る |

「配列の`.length`（プロパティ）」と「Stringの`.length()`（メソッド）」は名前が似ているだけの別物。今回のコードはStringのメソッドを正しく呼んでいるが、その手前の配列アクセス自体が範囲外だった、という話。
