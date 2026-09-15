# extendsとimplementsの使い分け

## キーワードの対応表

| | 継承のキーワード | 継承できる数 |
|---|---|---|
| `class` が `class` を継承する | `extends` | **1つだけ** |
| `class` が `interface` を実装する | `implements` | **いくつでも** |
| `interface` が `interface` を継承する | `extends`（`implements`は使えない） | **いくつでも** |

## クラスの`extends`は1つだけ（構文エラー）

```java
class A {}
class B {}
class C extends A, B {}   // ← エラー
```
```
エラー: '{'がありません
```
→ 検証済み。クラスの多重継承はJavaでは許されていない。

## インターフェースの`extends`はいくつでもOK

```java
interface A { void x(); }
interface B { void y(); }
interface C extends A, B {   // 複数OK
    void z();
}
```
→ コンパイル成功。

## インターフェース同士は`implements`が使えない

```java
interface B implements A {   // ← エラー
```
```
エラー: '{'がありません
```
→ 検証済み。`interface`が他の`interface`を継承する時は、必ず`extends`を使う（`implements`は`class`がインターフェースを実装する時専用）。

## まとめ

- 「クラス同士のつながり」は`extends`、**1つだけ**
- 「クラスがインターフェースを実装する」のは`implements`、**いくつでも**
- 「インターフェース同士のつながり」も`extends`、**いくつでも**（`class`と違って複数OK）

Javaが**クラスの多重継承を禁止**している代わりに、**インターフェースの複数実装・複数継承は許可**している、という設計思想がこの表の背景にある（詳細は[[ひし形継承問題]]参照：複数のインターフェースから同じメソッドが降ってくることで起きる衝突の話）。
