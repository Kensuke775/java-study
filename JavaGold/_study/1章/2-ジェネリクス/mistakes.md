# ジェネリクス 間違えた問題まとめ

`problem2.md`を解いた際に間違えた問題をピックアップしたもの。再挑戦用。

## 目次

- [問題8(元problem2.md 問題8)](#問題8元problem2md-問題8)
- [問題9(元problem2.md 問題9)](#問題9元problem2md-問題9)

## 問題8(元problem2.md 問題8)

```java
1  public class Main {
2      static <T extends Comparable<T>> T max(T a, T b) {
3          return a.compareTo(b) >= 0 ? a : b;
4      }
5      public static void main(String[] args) {
6          System.out.println(max(3, 7));
7          System.out.println(max("banana", "apple"));
8          System.out.println(max(3, "7"));
9      }
10 }
```

このコードをコンパイルするとどうなるか。

A. `7`、`banana`、`7` の順に出力される

B. `7`、`banana` が出力された後、8行目で実行時に `ClassCastException` がスローされる

C. 8行目でコンパイルエラーになる

D. すべての行でコンパイルエラーになる

あなたの回答(1回目): A(不正解)

迷ったポイント: `max(3, "7")`が実行時に`"3".compareTo("7")`のような文字列比較として動くと誤解していた。実際は`T a, T b`が**同一の型`T`**を要求しており、`Integer`と`String`という2つの異なる型を渡した時点で、コンパイラが`T`を一意に決められず**コンパイル時**に失敗する。実行時の比較にすら到達しない。

あなたの回答(再挑戦): 

## 問題9(元problem2.md 問題9)

```java
1  public class Main {
2      static void addObject(Object[] arr) {
3          arr[0] = "changed";
4      }
5      public static void main(String[] args) {
6          Integer[] iArr = {1, 2, 3};
7          addObject(iArr);
8          System.out.println(iArr[0]);
9      }
10 }
```

このコードを実行するとどうなるか。

A. `changed` が出力される

B. `1` が出力される

C. 7行目でコンパイルエラーになる

D. 3行目で `ArrayStoreException` がスローされる

あなたの回答(1回目): C(不正解)

迷ったポイント: 配列は**共変**(`Integer[]`は`Object[]`の一種として渡せる)という特別ルールを見落とし、7行目の`addObject(iArr)`自体がコンパイルエラーになると誤解していた。実際は7行目のコンパイルは通り、実体が`Integer[]`のままの配列に`String`を格納しようとした3行目で、実行時に`ArrayStoreException`がスローされる。`List<Integer>`のようなジェネリクスコレクションではこの共変自体が起きない(そもそも`List<Object>`への代入がコンパイルエラー)点との対比が重要。

あなたの回答(再挑戦): 
