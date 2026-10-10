# sealedのpermits先は、final・sealed・non-sealedのいずれかが必須（問題26）

## 検証コード：修飾子なしはエラー

```java
sealed interface Test permits A {
    void sample();
}
abstract class A implements Test {   // ← ここでエラー
    abstract void hello();
}
final class B extends A { ... }
```
```
エラー: sealed、non-sealedまたはfinal修飾子が必要です
```
→ 検証済み。

## ルール：sealed型の直接の許可先は、3択のどれかを必ず持つ

`sealed interface`（または`sealed class`）の`permits`に書かれた**直接のサブタイプ**は、次の3つのうちいずれかを必ず持たなければならない。

| 選べる修飾子 | 意味 |
|---|---|
| `final` | それ以上継承できない。階層はここで完全に終わる |
| `sealed` | さらに階層を制限しながら続ける。自分の`permits`で許可した相手だけが継承できる |
| `non-sealed` | ここで制限を解除する。以降は誰でも自由に継承してよい |

## `abstract class`の場合、`final`は選べない

`abstract`は「サブクラスに実装させる前提」、`final`は「継承禁止」で**意味が矛盾**するため、`abstract final`という組み合わせ自体が成立しない。したがって`abstract class`がsealed階層の直接の許可先になる場合、選択肢は実質**`sealed`か`non-sealed`の二択**になる。

## `non-sealed`にする場合：以降は誰でも自由に継承できる

```java
abstract non-sealed class A implements Test {
    abstract void hello();
}
final class B extends A { ... }
```
→ コンパイル成功（検証済み）。`non-sealed`は「ここで許可の連鎖を打ち切って、以降は自由に継承してよい」という意味なので、追加の指定は一切不要。

## `sealed`にする場合：さらに下（B）にも同じ制約が伝播する

```java
abstract sealed class A implements Test {   // permitsは省略可（下記参照）
    abstract void hello();
}
final class B extends A { ... }
```
→ コンパイル成功（検証済み）。`A`を`sealed`にすると、**`A`を直接継承する`B`にも同じルールが適用され、`B`自身も`final`・`sealed`・`non-sealed`のいずれかを持たなければならない**。今回は`B`がすでに`final`なので、この条件は自動的に満たされている。

## `permits`句は、直接のサブタイプが同じソースファイル内にあれば省略できる

```java
sealed interface Test permits A {
    void sample();
}
abstract sealed class A implements Test {   // ← permits Bを書いていない
    abstract void hello();
}
final class B extends A { ... }
```
→ コンパイル成功（検証済み）。`B`が`A`と同じソースファイル（コンパイル単位）内にあるため、コンパイラが自動的に`B`を許可済みのサブタイプとして認識する。省略しても書いても、どちらでも正解になる。

## `interface`が許可先の場合、`final`はそもそも選択肢に無い

```java
sealed interface Test permits Sub {
}
interface Sub extends Test {   // ← ここでエラー
}
```
```
エラー: sealedまたはnon-sealed修飾子が必要です
```
→ 検証済み。エラーメッセージに`final`が含まれていない点に注目。**interfaceはそもそも`final`にできない**ため、interfaceがsealedの直接の許可先になる場合、選択肢は最初から**`sealed`か`non-sealed`の二択**しかない（`class`が`abstract`の場合に「実質二択になる」のとは違い、interfaceの場合は「そもそも最初から二択」という点が異なる）。

## まとめ

| 許可先の種類 | 選べる修飾子 |
|---|---|
| 普通の`class` | `final`・`sealed`・`non-sealed`の3択すべて |
| `abstract class` | `sealed`・`non-sealed`の実質二択（`final`は矛盾するため事実上不可） |
| `interface` | `sealed`・`non-sealed`の二択（`final`はそもそもinterfaceに付けられない） |

`sealed`にした場合、その制約はさらに下の階層にも伝播する（下の直接のサブタイプも同じ3択ルールを守る必要がある）が、`non-sealed`にした時点でその制約は打ち切られ、以降は自由になる。
