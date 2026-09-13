# substring

## substringを持つクラスと使い方

| クラス | `substring(int)` | `substring(int, int)` | 戻り値の型 |
|---|---|---|---|
| `String` | ✅ | ✅ | `String` |
| `StringBuilder` | ✅ | ✅ | `String` |
| `StringBuffer` | ✅ | ✅ | `String` |

**どのクラスの`substring`も、戻り値は必ず`String`**（`StringBuilder`や`StringBuffer`自身を返すわけではない）。

## 検証

```java
String s = "Java SE 17";
s.substring(8);          // "17"（8文字目から末尾まで）
s.substring(2, 6);       // "va S"（2文字目から6文字目の手前まで）
s.substring(8).getClass();  // class java.lang.String

StringBuilder sb = new StringBuilder("Java17");
sb.substring(4);         // "17"
sb.substring(4, 6);      // "17"
sb.substring(4).getClass();  // class java.lang.String

StringBuffer sf = new StringBuffer("Java17");
sf.substring(4);         // "17"
sf.substring(4, 6);      // "17"
sf.substring(4).getClass();  // class java.lang.String
```

## 引数の意味

| 引数の形 | 意味 |
|---|---|
| `substring(begin)` | `begin`番目の文字から**末尾まで**を切り出す |
| `substring(begin, end)` | `begin`番目から`end`番目の**手前まで**を切り出す（`end`番目自体は含まない） |

## ポイント

- `String`・`StringBuilder`・`StringBuffer`のいずれも、1引数・2引数の両方のオーバーロードを持っている
- 呼び出し元のクラスが何であっても、**返ってくるのは常に`String`**（`StringBuilder.substring(...)`を呼んでも`StringBuilder`には戻らない）
- `String`と`StringBuilder`を`.equals(...)`で比較する場合、`String.equals(Object)`は相手が`String`でなければ即座に`false`を返すため、`substring`の結果同士（どちらも`String`）を比較するときは問題なく中身を比較できる
