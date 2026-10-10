# StringBuilder.append() と List.add() の対比

## 検証コード

```java
StringBuilder sb = new StringBuilder("A");
StringBuilder ret = sb.append("B");
sb == ret;              // true
sb.toString();          // "AB"

List<String> list = new ArrayList<>();
boolean addRet = list.add("x");
addRet;                 // true
list;                   // [x]

sb.append("C").append("D");
sb.toString();          // "ABCD"
```
→ 検証済み。

## 似ている点：どちらも「自分自身の中身を書き換える（ミュータブル）」

`append(...)`も`add(...)`も、**新しいオブジェクトを作るのではなく、呼び出したインスタンス自身の中身を直接変更する**という点は共通している。`StringBuilder`にとっての`append`は、`List`にとっての`add`とほぼ同じ役割（「後ろに追加していく」）を果たしている、というイメージは合っている。

## 決定的に違う点：戻り値の型

| メソッド | 戻り値 | チェーンできるか |
|---|---|---|
| `StringBuilder.append(...)` | **自分自身（`StringBuilder`）への参照** | ✅ `.append(a).append(b)`のように連続で書ける |
| `List.add(...)` | **`boolean`**（追加に成功したかどうか） | ❌ `.add(a).add(b)`とは書けない（`boolean`に`.add`は無い） |

```java
sb.append("C").append("D");   // OK。append()がStringBuilder自身を返すのでチェーンできる
list.add("y").add("z");       // ← エラー（add()の戻り値はbooleanなので、その後に.addは呼べない）
```

`StringBuilder`は「自分自身を返す」ことでメソッドチェーン（流れるように書けるAPI、いわゆるfluent interface）を実現しているが、`List.add(...)`は「追加できたかどうか」という**成否の情報**を返すことを優先した設計になっている。どちらも「中身を追加する」という目的は同じだが、**戻り値の設計思想が違う**ため、書き方（チェーンできるかどうか）に差が出る。

## まとめ

- `append`と`add`は「自分の中身に追加する、ミュータブルな操作」という意味では同じ仲間
- ただし`append`は**自分自身を返す**（チェーン可能）、`add`は**booleanを返す**（チェーン不可）という違いがあり、この違いは丸暗記するしかない設計上の差
