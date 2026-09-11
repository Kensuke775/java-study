## 問題49：instanceof＋手動キャスト vs パターンマッチング

```java
sealed interface Product permits Music, Food {}
record Music(String genre) implements Product {}
record Food(String name) implements Product {}

static void execute(Product p) {
    if (p instanceof Food obj) {
        System.out.print(obj.name());
    }
}
```

`Food`の要素だけ`name()`の値を出力、`Music`の要素は何もしない。この処理と同じ結果になる書き方を選ぶ問題。

### 手動キャストは省略できない

```java
if (p instanceof Food) {
    System.out.print(p.name());   // ← コンパイルエラー
}
```

```
エラー: シンボルを見つけられません
メソッド name()、場所: タイプProductの変数 p
```

`instanceof`だけで型を判定しても、`p`**という変数の宣言型（**`Product`**）はコンパイラ上変化しない**。`Product`には`name()`が無いのでエラーになる。`Food`の`name()`を使うには`Food f = (Food)p;`のように明示的にキャストし直す必要がある。


| 書き方                                                | キャスト        | 導入時期               |
| -------------------------------------------------- | ----------- | ------------------ |
| `if (p instanceof Food) { Food f = (Food)p; ... }` | 必要（自分で書く）   | 従来の書き方             |
| `if (p instanceof Food obj) { ...obj... }`         | 不要（自動で絞り込み） | Java 16〜のパターンマッチング |




### 「同じ条件」でも出力方法で結果が変わる例（B案とD案の比較）

```java
// B（誤り）
if (!(p instanceof Music)) {       // 条件はFoodの場合と実質同じ
    Food f = (Food)p;
    System.out.print(f);           // f自体を渡す → f.toString()が呼ばれる
}
// → "Food[name=Snack]"（recordの自動生成toString形式）

// D（正解）
if (p instanceof Food) {
    Food f = (Food)p;
    System.out.print(f.name());    // アクセサの戻り値（文字列）を渡す
}
// → "Snack"
```

`System.out.print(オブジェクト)`は内部で`String.valueOf(...)`→`toString()`を呼ぶため、`record`の自動生成`toString()`（`Food[name=Snack]`のような形式）が出てきてしまう。**「同じ条件で同じ要素を拾えているか」だけでなく「何を**`print`**に渡しているか」も一致しているか**を確認する必要がある。

### `contains(...)`が使えない理由

```java
if (p.contains("Snack") || p.contains("Orange")) { ... }
```

```
エラー: シンボルを見つけられません
メソッド contains(String)、場所: タイプProductの変数 p
```

`contains(...)`は`List`（コレクション）が持つメソッドであり、`Product`**という型自体に**`contains`**は定義されていない**。「`p`がリストの中の1要素だから使えない」のではなく、「`p`が何であっても`Product`型に`contains`というメソッドが存在しないから使えない」という点が正確な理由（`List`が持つ機能を`Product`が自動的に持つことはない）。