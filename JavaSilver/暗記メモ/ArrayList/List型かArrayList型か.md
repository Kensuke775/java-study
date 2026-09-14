# List型かArrayList型か

## 実体は同じ、違うのは「宣言した型（静的型）」だけ

```java
List<String> list = new ArrayList<>();
ArrayList<String> list2 = new ArrayList<>();

list.getClass();   // class java.util.ArrayList
list2.getClass();  // class java.util.ArrayList
list.getClass() == list2.getClass();  // true
```

どちらも`new ArrayList<>()`で作っているので、実行時の中身は**全く同じ`ArrayList`のインスタンス**。違うのはコンパイラから見える「型」だけ。

## `List`型で宣言すると、`ArrayList`固有のメソッドは呼べない

```java
List<String> list = new ArrayList<>();
list.ensureCapacity(100);   // ← エラー
```
```
エラー: シンボルを見つけられません
シンボル: メソッド ensureCapacity(int)
場所: タイプList<String>の変数 list
```

`ensureCapacity(int)`は`ArrayList`**独自**のメソッド（`List`インターフェースには定義されていない）。

| | 実体（実行時） | コンパイラが許可する操作 |
|---|---|---|
| `List<String> list = new ArrayList<>();` | `ArrayList` | `List`インターフェースのメソッドのみ |
| `ArrayList<String> list2 = new ArrayList<>();` | `ArrayList` | `ArrayList`固有のメソッドも含めて全部 |

`List`型で受けると、将来`ArrayList`から`LinkedList`など別の`List`実装に差し替えやすくなる（実務でよく`List`型で宣言する理由）反面、`ArrayList`固有の機能は使えなくなる、というトレードオフ。

## 本物の`java.util.ArrayList`を作れるのは`new ArrayList<>()`だけ

`List`型の変数を作る方法は複数あるが（`List.of(...)`、`Arrays.asList(...)`、`new ArrayList<>()`）、実体が本物の`java.util.ArrayList`になるのは`new ArrayList<>()`だけ。

```java
List<String> a = List.of("x", "y");
List<String> b = Arrays.asList("x", "y");
List<String> c = new ArrayList<>();

a.getClass();   // class java.util.ImmutableCollections$List12
b.getClass();   // class java.util.Arrays$ArrayList
c.getClass();   // class java.util.ArrayList
```

| 作り方 | 実体クラス | 本物の`java.util.ArrayList`か |
|---|---|---|
| `List.of(...)` | `ImmutableCollections$List12` | ❌ |
| `Arrays.asList(...)` | `Arrays$ArrayList`（名前が紛らわしいだけの別物） | ❌ |
| `new ArrayList<>()` | `java.util.ArrayList` | ✅ |

### 落とし穴：`Arrays.asList`の"ArrayList"は別物

`Arrays.asList(...)`の戻り値クラス名にも「`ArrayList`」という文字が入っている（`Arrays$ArrayList`）が、これは**`java.util.ArrayList`とは全くの別クラス**（`Arrays`クラスの内部にひっそり定義された、名前が同じなだけの非公開クラス）。名前が似ているせいで「`Arrays.asList`も内部的に`ArrayList`を作っている」と誤解しやすいので注意。
