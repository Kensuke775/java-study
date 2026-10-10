# interfaceのdefaultメソッドを、実装クラス側でabstractとして再宣言すると何が起きるか

## 検証コード

```java
interface A {
    default void sample() { System.out.println("A"); }
}
```

### パターン1：Bで何も書かない（Aのdefaultをそのまま継承）

```java
abstract sealed class B implements A permits C {
}
final class C extends B {
    // sample()を書かない
}

new C().sample();
```
→ `A`と表示され成功。検証済み。`C`は`sample()`を実装しなくても、`A`のdefault実装がそのまま使われる。

### パターン2：Bで`public abstract void sample();`と再宣言

```java
abstract sealed class B implements A permits C {
    public abstract void sample();
}
final class C extends B {
    // sample()を書かない
}
```
```
エラー: Cはabstractでなく、B内のabstractメソッドsample()をオーバーライドしません
```
→ 検証済み。`C`に`sample()`の実装が無いとコンパイルエラーになる。

## なぜ違うのか

`interface A`の`default void sample()`は、それ自体で「実装済み」の状態。`B`が何も書かなければ、`A`のdefault実装をそのまま黙って継承するだけで、`B`にとっても`C`にとっても「実装済みの契約」として扱われる。

しかし`B`側で改めて`public abstract void sample();`と**抽象メソッドとして再宣言**すると、そこで一度「未実装の状態」に巻き戻される。`B`は`abstract`クラスなので自分自身は実装しなくても許されるが、`B`を継承する具象クラス（`final class C`）は、abstractメソッドが残っている以上、自分で必ず実装しなければならない（[[abstractメソッドを持つならクラス自身もabstract必須・組み合わせ禁止の修飾子]]の「abstractメソッドを持つクラスはabstract必須」ルールがここでも効いている）。

## まとめ

| Bの書き方 | Cがsample()を書かなかった場合 |
|---|---|
| 何も書かない（Aのdefaultを黙って継承） | ✅ コンパイル通る。Aのdefault実装が使われる |
| `public abstract void sample();`と再宣言 | ❌ コンパイルエラー。Cに実装が必須になる |

「defaultメソッドで一度実装済みになった契約」を、サブクラス側の都合で「あえてもう一度未実装扱いに戻し、下の階層に実装を強制する」というテクニック。書いても書かなくても同じ（冗長）ではなく、明確に意味が変わる。
