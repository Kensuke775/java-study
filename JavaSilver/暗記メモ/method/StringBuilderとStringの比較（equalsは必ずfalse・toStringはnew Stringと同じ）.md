# StringBuilderとStringの比較：`equals`は必ず`false`／`toString()`は`new String`と同じ

## 検証コード

```java
String s = "java";
StringBuilder sb = new StringBuilder("java");

System.out.println(sb.toString().equals(s));         // true
System.out.println(s == sb.toString().intern());     // true
System.out.println(sb.equals(s));                    // false
```
→ 検証済み（`_play/Main.java`のうち、関係する行だけ）。

## ① `sb.equals(String)`は、型が違うので必ず`false`

- `StringBuilder`は`equals()`をオーバーライドしていない（宣言元は`java.lang.Object`。検証済み）＝**参照比較のまま**（→[[equals]]）
- `StringBuilder`のインスタンスと`String`のインスタンスは、そもそも同じオブジェクトにはなりえない
- だから中身が同じ`"java"`でも、`sb.equals(s)`は**必ず`false`**（コンパイルは通り、結果が`false`になる）

| 式 | 結果 | 理由 |
|---|---|---|
| `sb.equals(s)` | `false` | `Object.equals`（参照比較）。別オブジェクト |
| `s.equals(sb)` | `false` | `String.equals`は、相手が`String`でないと`false` |
| `sb.equals(sb)` | `true` | 同じ参照 |
| `sb.toString().equals(s)` | `true` | `String`同士の中身の比較 |
| `s.contentEquals(sb)` | `true` | `String`と`StringBuilder`の中身を直接比較するメソッド |

→ すべて検証済み。中身を比べたいときは、`toString()`で`String`に直してから`equals`を使う。

## ② `sb.toString()`は`new String(...)`と同じ（新しい`String`を作る）

| 式 | 結果 | 理由 |
|---|---|---|
| `s == sb.toString()` | `false` | 新しい`String`オブジェクトなので、`s`とは別の参照 |
| `s == new String("java")` | `false` | 同じ（`new`で別オブジェクト） |
| `s == sb.toString().intern()` | `true` | `intern()`でプール内の`"java"`の参照に置き換わる |
| `s == new String("java").intern()` | `true` | 同じ |
| `sb.toString() == sb.toString()` | `false` | 呼ぶたびに別のオブジェクトを作る |

→ すべて検証済み。

`javap`で確認（Java 17）：`StringBuilder.toString()`は`StringLatin1.newString(...)`を呼び、その中に`new String(...)`がある。

例外（Java 17の実装）：中身が**空**のときだけ、`new String`を通らずリテラルの`""`をそのまま返す。

```java
new StringBuilder().toString() == ""      // true（空のときだけ）
new StringBuilder("a").toString() == "a"  // false
```
→ 検証済み。試験では「`toString()`は新しい`String`を作る」という理解で十分。

## 覚え方

- `sb.equals(String)`は**必ず`false`**（型違い＋参照比較）。中身を比べるなら`sb.toString().equals(s)`
- `sb.toString()`は`new String(...)`と同じ。`==`では`false`。`.intern()`を付けるとプールの参照になり、リテラルと`==`で`true`

関連：[[equals]]（オーバーライドしているクラス・していないクラスの一覧）、[[Stringの定数プールとintern・実行時連結で作られるオブジェクト数]]
