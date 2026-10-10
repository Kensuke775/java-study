# 拡張for文の変数は「参照のコピー」。書き換えても元の配列には反映されない

## お題（問題5-17）

```java
public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = { new Fruit("Lemon"), new Fruit("Kiwi"), new Fruit("Lime")};
        method(fruits);
        fruits[1] = null;
        for (var f : fruits)
            if(f != null) System.out.print(f.name + " ");
    }
    public static void method(Fruit[] x) {
        for (var f : x)
            if(f.name.length() == 5) f = null;
    }
}
class Fruit {
    String name;
    Fruit(String name) { this.name = name; }
}
```
```
Lemon Lime
```
→ 検証済み。`"Lemon"`は5文字なので`method`内で`f = null`が実行されるが、出力には`"Lemon"`が残っている。

## なぜ`f = null`が配列に反映されないのか

拡張for文（`for (var f : x)`）の`f`は、配列の要素そのもの（`x[0]`という箱）ではなく、**その回だけ使い捨てで用意される、別のローカル変数**。ループが1周するたびに、その時点の要素の参照が`f`に**コピー**される。

```
x[0] ──参照──→ Fruitオブジェクト（"Lemon"）
                     ↑
f ──コピーされた同じ参照──┘
```

`f = null`は、`f`という**コピー先の変数**の中身を`null`に書き換えているだけで、コピー元の`x[0]`の中身（参照）には一切触れていない。だから`x[0]`は元のFruitオブジェクトを指したまま。

## 配列の要素を実際にnullにするには：添字（インデックス）でアクセスする

`x[i] = null`のように、**配列そのものに対して代入**すれば、今度こそ元の配列が書き換わる。

```java
public static void method(Fruit[] x) {
    for (int i = 0; i < x.length; i++) {
        if (x[i].name.length() == 5) x[i] = null;   // 配列そのものに書き戻す
    }
}
```
```
null Kiwi Lime
```
→ 検証済み。今度は`x[0]`（`fruits[0]`）が本当に`null`になった。

## まとめ

| 書き方 | 何を書き換えているか | 元の配列への影響 |
|---|---|---|
| `for (var f : x) { f = null; }` | ループ用の一時変数`f`（参照のコピー） | なし |
| `for (int i = 0; i < x.length; i++) { x[i] = null; }` | 配列`x`の`i`番目の箱そのもの | あり |

- 拡張for文は「配列の中身を読むだけの専用ループ」。要素の**内容**（例：`f.name`をフィールドごと書き換える等）を変えることはできる（同じオブジェクトを指しているため）が、**どのオブジェクトを指すか自体（参照そのもの）を配列側で変える**ことはできない
- 配列の要素の参照そのものを付け替えたい（`null`を入れる、別のオブジェクトに差し替える等）ときは、添字を使った普通の`for`文にする必要がある
