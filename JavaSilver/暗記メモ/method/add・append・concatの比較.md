# add / append / concat の比較

## 比較表

| | 属するクラス/型 | シグネチャ | 戻り値 | 何に使うか |
|---|---|---|---|---|
| `List.add` | `List`（コレクション） | `boolean add(E e)` | `boolean`（追加できたかどうか） | リストに要素を1つ追加する（中身を書き換える） |
| `StringBuilder.append` | `StringBuilder`/`StringBuffer` | `StringBuilder append(...)` | 呼び出し元自身（`StringBuilder`） | 可変な文字列の末尾に追加する（中身を書き換える） |
| `String.concat` | `String` | `String concat(String str)` | 新しい`String` | 不変な文字列同士を連結する（元の文字列は変化しない） |

## 検証コード

```java
// List.add
List<String> list = new ArrayList<>();
boolean addRet = list.add("x");
// addRet=true, list=[x]

// StringBuilder.append
StringBuilder sb = new StringBuilder("A");
StringBuilder appendRet = sb.append("B");
// sb == appendRet → true（自分自身を返す）, sb="AB"

// String.concat
String s1 = "Hello";
String s2 = s1.concat(" World");
// s2="Hello World", s1は"Hello"のまま変化なし, s1==s2 → false（新しいインスタンス）
```
→ すべて検証済み。

## それぞれの個性

- **`List.add`**：戻り値は成否を表す`boolean`。チェーンはできない（`list.add(a).add(b)`は不可）
- **`StringBuilder.append`**：戻り値は自分自身。チェーンができる（`.append(a).append(b)`）。**可変**なので、この操作自体が呼び出し元の中身を書き換える
- **`String.concat`**：戻り値は新しい`String`。`String`は**不変**なので、呼び出し元の文字列自体は変化しない

## concatならではの注意点：nullを渡すとNullPointerException

```java
"Hello".concat(null);   // → NullPointerException（nullは渡せない）
"Hello".concat("");     // → 呼び出し元と同じインスタンスを返す（新規作成しない最適化、検証済み）
```
→ 検証済み。

## まとめ

- 3つとも「何かを後ろに足す／繋げる」という目的は似ているが、**属するクラス・戻り値・可変か不変かが全部バラバラ**
- 「戻り値が自分自身か（チェーン可能か）」「元のオブジェクトが変化するか（可変/不変）」の2点を軸に区別すると整理しやすい
