# チャプター1(3〜10) 問題集2

chap1/3〜chap1/10のサンプルをベースにした難問8問。ラムダ式は未使用。

## 目次

- [問題3](#問題3)
- [問題4](#問題4)
- [問題5](#問題5)
- [問題6](#問題6)
- [問題7](#問題7)
- [問題8](#問題8)
- [問題9](#問題9)
- [問題10](#問題10)

## 問題3

```java
// Box.java
1  public class Box {
2      private Object obj;
3      public void set(Object obj) { this.obj = obj; }
4      public Object get() { return obj; }
5  }
```

```java
// Main.java
1  public class Main {
2      public static void main(String[] args) {
3          Box box = new Box();
4          box.set(100);
5          Object o = box.get();
6          box.set("Gold");
7          Integer i = (Integer) o;
8          System.out.println(i + 1);
9      }
10 }
```

このコードを実行するとどうなるか。

A. `101` が出力される
B. `Gold1` が出力される
C. 7行目で `ClassCastException` がスローされる
D. コンパイルエラーになる

**実施記録**

あなたの回答: 

## 問題4

```java
// Box.java
1  class Box<T> {
2      private T obj;
3      public void set(T obj) { this.obj = obj; }
4      public T get() { return obj; }
5  }
```

```java
// Main.java
1  public class Main {
2      public static void main(String[] args) {
3          Box<Integer> box1 = new Box<>();
4          box1.set(10);
5          Box box2 = box1;
6          box2.set("Gold");
7          int x = box1.get();
8          System.out.println(x);
9      }
10 }
```

このコードをコンパイル・実行するとどうなるか。

A. `10` が出力される
B. `Gold` が出力される
C. 7行目で `ClassCastException` がスローされる
D. 6行目でコンパイルエラーになる

**実施記録**

あなたの回答: 

## 問題5

```java
// Box.java
1  class Box<T> {
2      private T obj;
3      public void set(T obj) { this.obj = obj; }
4      public T get() { return obj; }
5  }
```

```java
// Main.java
1  import java.util.ArrayList;
2  import java.util.List;
3
4  public class Main {
5      static <T> List<T> wrap(T item) {
6          List<T> list = new ArrayList<>();
7          list.add(item);
8          return list;
9      }
10     public static void main(String[] args) {
11         List<String> list1 = wrap("A");
12         List<Box<String>> list2 = new ArrayList<>();
13         list2.add(new Box<>());
14         list2.get(0).set("Hello");
15         System.out.println(list1.get(0) + list2.get(0).get());
16     }
17 }
```

このコードを実行するとどうなるか。

A. `AHello` が出力される
B. 13行目でコンパイルエラーになる(ネストしたジェネリクスにはダイヤモンド演算子`<>`が使えないため)
C. 14行目で `ClassCastException` がスローされる
D. コンパイルは通るが、実行時に `NullPointerException` がスローされる

**実施記録**

あなたの回答: 

## 問題6

```java
1  import java.util.ArrayList;
2  import java.util.List;
3
4  public class Main {
5      static <T> List<T> empty() {
6          return new ArrayList<T>();
7      }
8      public static void main(String[] args) {
9          List<String> list = Main.<String>empty();
10         list.add("A");
11         System.out.println(list);
12         <String>empty().add("B");
13     }
14 }
```

このコードをコンパイルするとどうなるか。

A. すべて問題なくコンパイルできる。`[A]`の後に何も出力されず終了する
B. 12行目でコンパイルエラーになる
C. 9行目でコンパイルエラーになる
D. コンパイルは通るが、12行目で実行時に例外がスローされる

**実施記録**

あなたの回答: 

## 問題7

```java
1  class Pair<K, V extends K> {}
2  public class Main {
3      public static void main(String[] args) {
4          Pair<Number, Integer> p1 = new Pair<>();
5          Pair<Object, String> p2 = new Pair<>();
6          Pair<Integer, Number> p3 = new Pair<>();
7          System.out.println("ok");
8      }
9  }
```

このコードをコンパイルするとどうなるか。

A. すべて問題なくコンパイルできる
B. 4行目のみコンパイルエラーになる
C. 6行目のみコンパイルエラーになる
D. 5行目と6行目でコンパイルエラーになる

**実施記録**

あなたの回答: 

## 問題8

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

**実施記録**

あなたの回答: 

## 問題9

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

**実施記録**

あなたの回答: 

## 問題10

```java
1  import java.util.ArrayList;
2  import java.util.List;
3
4  public class Main {
5      static void fill(List<? super Integer> dest) {
6          dest.add(10);
7          dest.add(20);
8      }
9      static int sumFirstTwo(List<? extends Number> src) {
10         return src.get(0).intValue() + src.get(1).intValue();
11     }
12     public static void main(String[] args) {
13         List<Number> numList = new ArrayList<>();
14         fill(numList);
15         System.out.println(sumFirstTwo(numList));
16
17         List<Integer> intList = new ArrayList<>();
18         fill(intList);
19
20         List<Object> objList = new ArrayList<>();
21         sumFirstTwo(objList);
22     }
23 }
```

このコードをコンパイルするとどうなるか。

A. `30` が出力された後、すべて問題なく実行が終了する
B. `30` が出力された後、21行目でコンパイルエラーになる
C. 18行目でコンパイルエラーになる
D. `30` が出力された後、21行目で実行時に `ClassCastException` がスローされる

**実施記録**

あなたの回答: 
