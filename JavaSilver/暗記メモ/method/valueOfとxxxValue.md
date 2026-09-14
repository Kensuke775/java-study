# valueOf と xxxValue

## valueOf：プリミティブ（またはString）→ ラッパークラス

`静的メソッド`。プリミティブ値（や数値の`String`）を受け取って、対応するラッパークラスのオブジェクトを返す。

```java
Integer i = Integer.valueOf(10);
Long l = Long.valueOf(100L);
Double d = Double.valueOf(3.14);
Integer i2 = Integer.valueOf("20");   // Stringからも作れる
```

## xxxValue：ラッパークラス → プリミティブ

`インスタンスメソッド`。ラッパークラスのオブジェクトに対して呼び出し、中身をプリミティブ値として取り出す。`intValue()`・`longValue()`・`doubleValue()`・`floatValue()`など、取り出したい型ごとにメソッドが用意されている。

```java
int a = i.intValue();
long b = l.longValue();
double c = d.doubleValue();
double e = l.doubleValue();   // Long型からdoubleへ、異なるプリミティブへの変換も可能
```

`Number`クラスのサブクラス（`Integer`・`Long`・`Double`・`Float`・`Short`・`Byte`）は、自分の本来の型だけでなく**他の数値プリミティブへの変換メソッドも全部持っている**（`Long`なのに`doubleValue()`が呼べる、など）。

## 使い分けが問われる典型パターン：ワイドニング＋ボクシングの2段階変換

```java
Math.round(3.14)   // 戻り値：long（プリミティブ）
Double d = Math.round(3.14);   // ← エラー（long→double→Doubleの2段階変換は暗黙にはできない）
```

このような場合、`valueOf`と`xxxValue`を使って明示的に橋渡しする。

```java
// 方法1：明示的にキャストしてワイドニングだけ先に済ませる（あとはボクシングだけなので自動でOK）
Double d1 = (double) Math.round(3.14);

// 方法2：Long.valueOf(...)で先にボクシングしてから、doubleValue()でdoubleに変換
double d2 = Long.valueOf(Math.round(3.14)).doubleValue();
```

`Math.round(3.14).doubleValue()`のように、**プリミティブの`long`に直接`.doubleValue()`を呼ぶことはできない**（プリミティブはオブジェクトではないのでメソッドを持たない）。`Long.valueOf(...)`で一度ラッパークラスにしてからでないと`xxxValue()`系のメソッドは使えない、という点に注意。

## まとめ

| メソッド | 向き | 種別 |
|---|---|---|
| `valueOf(プリミティブ or String)` | プリミティブ/String → ラッパー | 静的メソッド |
| `xxxValue()`（`intValue()`・`doubleValue()`など） | ラッパー → プリミティブ | インスタンスメソッド |

`valueOf`は「箱に入れる」、`xxxValue`は「箱から取り出す」というイメージ。取り出す時は`Number`系ラッパーなら本来の型以外のプリミティブにも変換できる、という柔軟さがある。
