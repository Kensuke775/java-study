# abstractメソッドを持つクラスは自身もabstract必須／abstractメソッドに付けられない修飾子

## ルール1：abstractメソッドを1つでも持つクラスは、そのクラス自身もabstractでなければならない

```java
class NonAbstract {
    public abstract void sample();
}
```
```
エラー: NonAbstractはabstractでなく、NonAbstract内のabstractメソッドsample()をオーバーライドしません
```
→ 検証済み。

### なぜか

`abstract`メソッドは「呼び出せるが実装が無い」メソッド。もしそのクラスが`abstract`でなければ、普通に`new`でインスタンス化できてしまうが、その状態で`sample()`を呼んでも実装が存在せず動かしようがない。これを防ぐため、「未実装のメソッドを持つクラスは、それ自体もインスタンス化できない（`abstract`）ものとして宣言せよ」というルールが強制される。

逆に、`abstract`クラスが`abstract`メソッドを1つも持たなくてもよい（単に直接インスタンス化させたくないだけの意図でも`abstract`にできる）。関係は一方向。

## ルール2：abstractクラス自身はprivateメソッドを普通に持てる

```java
abstract class Sample1 {
    private void helper() { System.out.println("helper"); }
    abstract void sample();
}
```
→ コンパイル成功。検証済み。`abstract`クラスは「abstractメソッドを持てる／持たなくてもよい」クラスというだけで、通常のクラスと同様に`private`な通常メソッドも自由に持てる。

## ルール3：abstractメソッド自身にはprivate・final・staticを付けられない

```java
private abstract void sample();
```
```
エラー: 修飾子abstractとprivateの組合せは不正です
```

```java
final abstract void sample();
```
```
エラー: 修飾子abstractとfinalの組合せは不正です
```

```java
static abstract void sample();
```
```
エラー: 修飾子abstractとstaticの組合せは不正です
```
→ すべて検証済み。

### なぜ禁止なのか（それぞれの矛盾）

- **`private`**：`private`メソッドはサブクラスから見えず、オーバーライドの対象にならない。`abstract`は「サブクラスに実装させる」ことが前提なので、そもそも見えない`private`とは両立しない。
- **`final`**：`final`は「オーバーライド禁止」を意味する。`abstract`は「サブクラスに実装（＝オーバーライド）させる」ことが前提なので、正反対の指示になり矛盾する。
- **`static`**：`static`メソッドは特定のインスタンスに紐づかず、オーバーライド（動的束縛）の対象にならない（隠蔽にしかならない）。`abstract`は動的束縛前提の仕組みなので両立しない。

## まとめ

| 対象 | 制約 |
|---|---|
| abstractメソッドを持つクラス | そのクラス自身もabstract必須 |
| abstractクラス自身 | private・通常のメソッドを普通に持てる（制限なし） |
| abstractメソッド自身 | `private`・`final`・`static`のいずれも付けられない（すべてabstractの前提＝オーバーライド可能性と矛盾するため） |
