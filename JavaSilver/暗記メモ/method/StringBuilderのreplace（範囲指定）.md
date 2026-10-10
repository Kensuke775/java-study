# StringBuilder/StringBufferのreplace（範囲指定の3引数版）

## Stringのreplace/replaceAllとは別物

`String`の`replace`・`replaceAll`は「特定の文字列（またはパターン）を探して置換する」メソッドだったが、`StringBuilder`・`StringBuffer`には**インデックス（範囲）を直接指定して置換する**、全く別の3引数メソッドが存在する。

シグネチャ：`StringBuilder replace(int start, int end, String str)`（`StringBuffer`も同名・同シグネチャ）

戻り値の型は**呼び出し元自身（`StringBuilder`/`StringBuffer`）**。中身を書き換えた上で、自分自身への参照を返す（`append`と同じ設計）。

## 検証コード

```java
StringBuilder sb = new StringBuilder("Hello World");
StringBuilder ret = sb.replace(6, 11, "Java");
System.out.println(sb);          // → "Hello Java"
System.out.println(sb == ret);   // → true（自分自身を返している）

StringBuffer bf = new StringBuffer("Hello World");
bf.replace(0, 5, "Hi");
System.out.println(bf);          // → "Hi World"
```
→ 検証済み。

## `String`には3引数版の`replace`は存在しない

```java
String s = "Hello World";
s.replace(6, 11, "Java");   // ← コンパイルエラー
```
```
エラー: replaceに適切なメソッドが見つかりません(int,int,String)
```
→ 検証済み。`String`が持っているのは`replace(char, char)`と`replace(CharSequence, CharSequence)`の2つだけで、範囲（インデックス）を指定する版は`StringBuilder`・`StringBuffer`専用。

## 引数の意味：substringと同じ「endは含まない」ルール

| 引数 | 意味 |
|---|---|
| `start` | 置換したい範囲の開始位置（この位置を含む） |
| `end` | 置換したい範囲の終了位置（**この位置は含まない**、その手前まで） |
| `str` | `start`〜`end`の範囲を丸ごと差し替える新しい文字列 |

`substring(begin, end)`と同じ「`end`は含まない」という考え方がそのまま当てはまる。

## まとめ

| メソッド | 対象 | 何を指定するか | 戻り値 |
|---|---|---|---|
| `String.replace(target, replacement)` | `String` | 文字列そのもの（リテラル） | `String`（新しいインスタンス） |
| `String.replaceAll(regex, replacement)` | `String` | 正規表現パターン | `String`（新しいインスタンス） |
| `StringBuilder/StringBuffer.replace(start, end, str)` | `StringBuilder`/`StringBuffer` | インデックス範囲 | 呼び出し元自身（自分を書き換えて返す） |
