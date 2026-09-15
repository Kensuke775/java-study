# 配列とObjectの関係（オーバーロード解決）

## 配列は「1つのObjectのインスタンス」である

**どんな配列（`int[]`のようなプリミティブ配列も含む）も、`Object`のサブクラス**。なので配列丸ごと1つを`Object`型の変数に代入できる。

```java
Object o = new int[3];   // OK（配列自体がObjectのサブクラス）
```

## しかし「`Object[]`（Object型要素の配列）」とは全くの別物

```java
Object[] arr = new int[3];   // ← エラー
```

配列の共変性（例：`String[]`は`Object[]`として扱える）は、**要素が参照型同士の場合にだけ成立するルール**。`int[]`のようなプリミティブ配列は、`Object[]`の仲間には入らない。あくまで`int[]`は「`int`の集まりという独立した1つの型」であり、それが結果的に`Object`のサブクラスというだけ。

## 検証：オーバーロード解決での実例

```java
public class Sample {
    public void test(Object[] val) { System.out.println("A"); }
    public void test(long[] val)   { System.out.println("B"); }
    public void test(Object val)   { System.out.println("C"); }
}

new Sample().test(new int[3]);
```
```
C
```
→ 検証済み。

| オーバーロード | `int[]`は合うか |
|---|---|
| `test(Object[] val)` | ❌ `int[]`は`Object[]`ではない |
| `test(long[] val)` | ❌ `int[]`は`long[]`ではない（`int→long`のワイドニングは**プリミティブ単体**の話。配列自体が自動で`int[]→long[]`になるわけではない） |
| `test(Object val)` | ✅ `int[]`は配列全体として`Object`のサブクラスなので、アップキャストで渡せる |

## まとめ

- 配列は「要素の型が何であれ」、配列自体は必ず`Object`のサブクラス → `Object`型の引数にはそのまま渡せる
- ただし「`Object[]`（要素がObject型の配列）」に対応できるのは、**要素が参照型の配列同士**の場合だけ（プリミティブ配列は対象外）
- 「配列だから配列用のオーバーロードに対応するはず」ではなく、「**配列を1つのオブジェクトそのものとして見た時に、どの引数型に一致するか**」で考える
