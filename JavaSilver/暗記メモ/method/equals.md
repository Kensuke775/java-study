# equals()をオーバーライドしているか・していないか

## 検証コード

```java
StringBuilder sb1 = new StringBuilder("abc");
StringBuilder sb2 = new StringBuilder("abc");
System.out.println("StringBuilder.equals : " + sb1.equals(sb2));   // false

StringBuffer bf1 = new StringBuffer("abc");
StringBuffer bf2 = new StringBuffer("abc");
System.out.println("StringBuffer.equals  : " + bf1.equals(bf2));   // false

String s1 = new String("abc");
String s2 = new String("abc");
System.out.println("String.equals        : " + s1.equals(s2));     // true

int[] arr1 = {1,2,3};
int[] arr2 = {1,2,3};
System.out.println("array.equals         : " + arr1.equals(arr2)); // false
```
→ 検証済み。

## 一覧表

| クラス | `equals()`の挙動 |
|---|---|
| **配列**（`int[]`、`char[][]`など） | ❌オーバーライドなし（`Object`のデフォルト＝参照比較のまま） |
| **`StringBuilder`** | ❌オーバーライドなし |
| **`StringBuffer`** | ❌オーバーライドなし |
| `String` | ✅オーバーライド済み（中身の文字列が同じかどうかを比較） |
| `Integer`・`Long`などのラッパークラス | ✅オーバーライド済み（中身の値が同じかどうかを比較） |
| `record` | ✅**自動生成**される（コンポーネントの値が全部同じかどうかを比較） |

## なぜ`StringBuilder`・`StringBuffer`・配列は`equals()`をオーバーライドしていないのか

これらは全て**可変（ミュータブル）**なクラス。中身がコロコロ変わる可能性があるオブジェクトに対して「中身が同じなら同じインスタンスとみなす」という`equals()`を持たせると、`HashMap`のキーなどに使った時に**中身が変わった瞬間にハッシュの整合性が壊れる**という危険がある。そのため意図的に`Object`のデフォルト（参照比較）のままにしてある。

対照的に`String`は**不変（イミュータブル）**なので、中身が変わる心配が無く、安心して「中身の比較」で`equals()`を定義できている。

## 覚え方

**「可変（ミュータブル）なクラスは、基本的に`equals()`をオーバーライドしない」**という傾向で覚えておくと、初見のクラスでも判断の予測がつく。

- ❌オーバーライドなし（可変）：配列、`StringBuilder`、`StringBuffer`
- ✅オーバーライドあり（不変 or 値そのものを表す型）：`String`、ラッパークラス、`record`
