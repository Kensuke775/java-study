# thisを省略できる条件／継承したprivateフィールドにはthisを付けても届かない（問題1）

## 検証コード（問題1のパターン）

```java
class Parent {
    String name;   // privateではない
}
public class Child extends Parent {
    Child() {
        name = "java";   // thisなしでOK
    }
    void hello() {
        System.out.println("hello, " + name);
    }
}
```
→ コンパイル・実行成功、`hello, java`。

`Child`自身は`name`フィールドを持っていないが、`Parent`から継承した`name`をそのまま使っている。この問題が聞いているのは「`Child`のコードが成立するために、`Parent`は`name`フィールドを（アクセス可能な形で）持っていなければならない」という点（正解：Parentクラスにはnameフィールドを定義しなければいけない）。

## `this`を省略できるかどうかは「同名の引数・ローカル変数が無いか」で決まる

```java
class Child extends Parent {
    Child() {
        name = "java";        // OK（同名の引数・ローカル変数が無いので、暗黙にthis.nameとして解釈される）
        this.name = "java";   // これも同じ意味でOK
    }
}
```

一方、コンストラクタの引数にも`name`がある場合は、区別のために`this`が必須になる。

```java
Child2(String name) {
    this.name = name;   // this.name＝フィールド、右辺のname＝引数
}
```
→ 検証済み。`this`を付けないと、`name = name;`は「引数のnameに、引数のname自身を代入する」だけの無意味な文になってしまう（フィールドには何も代入されない）。

## 継承したフィールドが`private`だと、`this`を付けても届かない

```java
class Parent {
    private String name;
}
class Child extends Parent {
    Child() {
        name = "java";        // ← エラー
        this.name = "java";   // ← これもエラー
    }
}
```
```
エラー: nameはParentでprivateアクセスされます
```
→ 両方とも検証済み。**`this`を付けるかどうかは「名前の衝突を解決する」ためのものであって、アクセス制御（`private`かどうか）を突破する力は無い**。`private`な`name`は、`Child`から見た時点で`this.name`と書いても`name`と書いても、そもそも見えない。

## `private`な親フィールドを子から扱いたい場合：protectedなセッター経由

```java
class Parent {
    private String name;
    protected void setName(String name) {
        this.name = name;   // Parent自身の中なので、privateでも普通にアクセスできる
    }
    void hello() { System.out.println("hello, " + name); }
}
class Child extends Parent {
    Child() {
        setName("java");   // ✅ 継承したprotectedメソッド経由ならOK
    }
}
```
→ コンパイル・実行成功、`hello, java`（検証済み）。

`private`なフィールド自体には子クラスから直接触れないが、**親クラスが用意した`protected`（または`public`）なメソッドを経由すれば、間接的に操作できる**。これはカプセル化の基本パターン（フィールドは`private`で隠し、操作用のメソッドだけを公開する）そのもの。

## まとめ

| 状況 | `this`は省略できるか | アクセスできるか |
|---|---|---|
| 同名の引数・ローカル変数が無い | 省略可（書いても書かなくても同じ意味） | 継承元フィールドが`private`でなければアクセス可 |
| 同名の引数・ローカル変数がある | 省略不可（`this`が無いと引数の方だけが使われる） | 同上 |
| 継承元フィールドが`private` | `this`の有無に関わらず、そもそもアクセス不可 | ❌（`protected`/`public`なメソッド経由で間接的に操作するしかない） |

「`this`を付けるかどうか」の問題と「`private`でアクセスできるかどうか」の問題は、**完全に別レイヤーの話**。`this`は名前の衝突を解決するだけの道具であり、アクセス修飾子による制限には一切関与しない。
