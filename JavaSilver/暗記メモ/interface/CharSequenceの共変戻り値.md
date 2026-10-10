# CharSequenceを返すインターフェースメソッドと共変戻り値（問題44）

## 検証コード

```java
interface X {
    CharSequence x();
}
class Foo implements X {
    String name = "Foo";
    public StringBuilder x() {   // ← CharSequenceではなくStringBuilderで返す
        return new StringBuilder(name);
    }
}
public class T {
    public static void main(String[] args) {
        X f = new Foo();
        System.out.println(f.x());   // → Foo
    }
}
```
→ コンパイル・実行成功（検証済み）。

## `CharSequence`を実装している代表クラス

| クラス | `CharSequence`実装 |
|---|---|
| `String` | ✅ |
| `StringBuilder` | ✅ |
| `StringBuffer` | ✅ |
| `CharBuffer` | ✅ |
| `Character` | ❌（1文字のスカラー値であり「並び」ではないため対象外） |
| `char`（プリミティブ） | ❌（プリミティブなのでそもそもインターフェースを実装するという概念が成り立たない） |

## なぜ戻り値を`CharSequence`から`StringBuilder`に変えてよいのか：共変戻り値

インターフェースが`CharSequence x();`と宣言していても、実装クラス側でオーバーライドする時の戻り値は**「元の型と同じ、またはそのサブタイプ」であればよい**（共変戻り値のルール）。`StringBuilder`は`CharSequence`を実装しているので、`CharSequence`のサブタイプにあたる。したがって`public StringBuilder x() {...}`という形でオーバーライドしても合法。

これは以前確認した「`Number`を返すはずのメソッドを`Integer`で返す」（[[../interface/オーバーロード]]参照）のと全く同じ理屈で、インターフェース／抽象メソッド特有の話ではなく、**オーバーライド全般に共通する共変戻り値のルール**がそのまま当てはまっているだけ。

## まとめ

- `CharSequence`を実装しているのは`String`・`StringBuilder`・`StringBuffer`・`CharBuffer`（`Character`・`char`は対象外）
- インターフェースが`CharSequence`を戻り値として要求していても、実装側は`CharSequence`のサブタイプ（`String`・`StringBuilder`など）を返すオーバーライドで問題ない（共変戻り値）
- 「インターフェースが指定した型そのままでしか返せない」は誤り。サブタイプへの変更は常に許される
