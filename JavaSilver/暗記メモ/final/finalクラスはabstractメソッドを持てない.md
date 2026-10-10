# finalクラスはabstractメソッドを持てない

## 検証コード

```java
final class Sample {
    abstract void sample();
}
```
```
エラー: Sampleはabstractでなく、Sample内のabstractメソッドsample()をオーバーライドしません
```

```java
final abstract class Sample2 {
    abstract void sample();
}
```
```
エラー: 修飾子abstractとfinalの組合せは不正です
```
→ 両方検証済み。

## なぜこうなるのか（2つの理由が合流する）

1. **クラス修飾子同士の矛盾**：[[abstractメソッドを持つならクラス自身もabstract必須・組み合わせ禁止の修飾子]]の通り、`abstract`メソッドを1つでも持つクラスは、そのクラス自身も`abstract`でなければならない。つまり`final abstract class`という組み合わせが必要になる。しかし`final`（オーバーライド禁止）と`abstract`（サブクラスに実装させる前提）はクラスの修飾子として正反対の指示であり、併用が禁止されている。
2. **先送りの余地が無い**：`final`クラスは`interface`を`implements`する場合も、`final`である以上サブクラスを作れない（継承禁止）。未実装のメソッドを下の階層に先送りする余地自体が存在しないため、`final`クラスは実装済みでなければならない。

どちらの角度から見ても、「`final`クラスは未実装の`abstract`メソッドを持てない」という結論に一致する。

## まとめ

- `abstract`メソッドを持つ → クラス自身も`abstract`が必要 → でも`final`と`abstract`は併用不可 → よって`final`クラスは`abstract`メソッドを持てない
- `final`クラスがインターフェースを実装する場合も、抽象メソッド・未実装のdefaultメソッドはすべてその場で実装済みでなければならない（サブクラスへの先送りができないため）
