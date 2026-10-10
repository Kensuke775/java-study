# interfaceのメソッドには暗黙で`public abstract`が付く

## 何が暗黙で付くか（`javap -v`で確認済み）

```java
interface Sample {
    void doWork();
    abstract void doWorkExplicit();
}
```
```
interface Sample
  flags: (0x0600) ACC_INTERFACE, ACC_ABSTRACT

  public abstract void doWork();
    flags: (0x0401) ACC_PUBLIC, ACC_ABSTRACT

  public abstract void doWorkExplicit();
    flags: (0x0401) ACC_PUBLIC, ACC_ABSTRACT
```

| 対象 | 暗黙で付くもの |
|---|---|
| interface**自体** | `abstract`（クラスファイルに`ACC_ABSTRACT`） |
| 抽象メソッド（`default`/`static`/`private`でない普通のメソッド宣言） | `public abstract` |
| フィールド（定数） | `public static final`（→[[インターフェースのフィールド]]） |

- `void doWork();`と書いても`abstract void doWork();`と書いても、コンパイル後は同じ`public abstract`になる。
- `public abstract interface Explicit {}`のように`abstract`を明示しても、冗長なだけでコンパイルは通る（検証済み）。

## 実装クラス側は`public`を書かないとエラー

interfaceのメソッドが暗黙で`public`なので、実装側で公開範囲を狭めることはできない。

```java
interface Runnable2 { void go(); }
abstract class Core implements Runnable2 { abstract void teardown(); }

class ImplA extends Core {
    void go() {}          // ❌ package-privateにしてしまった
    void teardown() {}
}
```
```
エラー: ImplAのgo()はRunnable2のgo()を実装できません
  ((public)より弱いアクセス権限を割り当てようとしました)
```
→ 検証済み。`public void go() {}`と書く必要がある。

なお`abstract class Core`側の`abstract void teardown();`は**自分で書いた宣言そのまま**（`public`は暗黙で付かない）なので、`void teardown() {}`（package-private）で実装しても通る。「interfaceの抽象メソッドは暗黙`public`」「abstractクラスの抽象メソッドは書いた通り」という違いが、紫本6-13の分かれ目。

## 注意：「interfaceのメソッドはprivate/static/finalにできない」は不正確

正確には、**本体のない（＝抽象メソッドの）宣言に`private`/`static`/`final`は付けられない**、というだけ。本体があれば`static`と`private`は書ける（Java 9以降）。

```java
interface I1 { private void m(); }        // ❌ メソッド本体がないか、abstractとして宣言されています
interface I2 { final void m(); }          // ❌ 修飾子finalをここで使用することはできません
interface I3 { static void m(); }         // ❌ メソッド本体がないか、abstractとして宣言されています
interface I4 { static void m() {} private void p() {} }   // ✅ OK（本体あり）
```
→ すべて検証済み。抽象メソッドは`abstract`が暗黙で付くので、`abstract`と併存できない`private`/`static`/`final`と組み合わせられない、という理屈（→[[../Abstract/abstractメソッドを持つならクラス自身もabstract必須・組み合わせ禁止の修飾子]]）。

関連：[[defaultメソッドをabstractで再宣言すると継承を強制できる]]
