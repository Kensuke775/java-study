# 1章 1. 基本データ型と参照型の型変換 問題集

`chap1/1`(ラッパークラス)の教科書内容を題材にした難問5問。全問`javac`/`java`で検証済み。教科書にあるメソッド(`valueOf`, `intValue`, `doubleValue`, `equals`など)のみ使用。ラムダ式は使用していません。答えは書かず、問題のみ記載。

## 目次

- [問題1-1](#問題1-1)
- [問題1-2](#問題1-2)
- [問題1-3](#問題1-3)
- [問題1-4](#問題1-4)
- [問題1-5](#問題1-5)
- [問題2-1](#問題2-1)
- [問題2-2](#問題2-2)
- [復習問題2-1](#復習問題2-1)
- [問題3-1](#問題3-1)
- [問題3-2](#問題3-2)
- [問題3-3](#問題3-3)
- [問題4-1](#問題4-1)
- [問題5-1](#問題5-1)

### 問題1-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer wrap = null;
4          int iValue = wrap.intValue();
5          System.out.println(iValue);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `0`と出力される

B. 4行目で`NullPointerException`がスローされる

C. 3行目でコンパイルエラーになる(`Integer`に`null`は代入できない)

D. `null`と出力される

あなたの回答: B / 正解: B

### 問題1-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          Long l1 = 100L;
4          Long l2 = new Long(100L);
5          Long l3 = 200L;
6          Long l4 = 200L;
7          System.out.println((l1 == l2) + " " + (l3 == l4));
8      }
9  }
```

7行目を実行するとどうなるか。

A. `true true`

B. `true false`

C. `false true`

D. `false false`

あなたの回答: D / 正解: D

### 問題1-3

```java
1  public class Main {
2      public static void main(String[] args) {
3          Long l = 100;
4          System.out.println(l);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `100`と出力される

B. 3行目でコンパイルエラーになる

C. 実行時に`ClassCastException`がスローされる

D. 実行時に`NumberFormatException`がスローされる

あなたの回答: B / 正解: B

### 問題1-4

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double d = Double.valueOf("12.5abc");
4          System.out.println(d);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `12.5`と出力される

B. 3行目で`NumberFormatException`がスローされる

C. 3行目でコンパイルエラーになる

D. `null`と出力される

### 問題1-5

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double d = Double.valueOf(9.99);
4          int x = d.intValue();
5          System.out.println(x);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `9`と出力される

B. `10`と出力される

C. `9.99`と出力される

D. 4行目でコンパイルエラーになる

E. 実行時に`ClassCastException`がスローされる

### 問題2-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer a = null;
4          int b = a + 1;
5          System.out.println(b);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `1`と出力される

B. 4行目で`NullPointerException`がスローされる

C. 3行目でコンパイルエラーになる

D. `0`と出力される

### 問題2-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer i = 200;
4          byte b = i.byteValue();
5          System.out.println(b);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `200`と出力される

B. 4行目でコンパイルエラーになる(`200`は`byte`の範囲外)

C. `-56`と出力される

D. 実行時に`ArithmeticException`がスローされる

### 復習問題2-1(問題2-1の再挑戦・別バージョン)

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer count = null;
4          System.out.println(count);
5          if (count > 0) {
6              System.out.println("positive");
7          }
8      }
9  }
```

4行目・5行目を実行するとどうなるか。

A. `null` → 5行目で`NullPointerException`がスローされる

B. `null` → 5行目は何も起きず(条件がfalse扱いになり)そのまま正常終了する

C. 3行目でコンパイルエラーになる(`Integer`に`null`は代入できない)

D. 5行目でコンパイルエラーになる(`Integer`同士は`>`で比較できない)

### 問題3-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          double dValue = Double.valueOf('a');
4          System.out.println(dValue);
5      }
6  }
```

3行目・4行目を実行するとどうなるか。

A. `a`と出力される

B. `97.0`と出力される

C. `0.0`と出力される

D. 3行目でコンパイルエラーになる(`char`は`Double.valueOf()`に渡せない)

### 問題3-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          double d1 = Double.valueOf("12.5");
4          int d2 = Double.valueOf("12.5");
5          System.out.println(d1 + " " + d2);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `12.5 12`と出力される

B. `12.5 13`と出力される

C. 4行目でコンパイルエラーになる

D. 4行目で`NumberFormatException`がスローされる

### 問題3-3

```java
1  public class Main {
2      public static void main(String[] args) {
3          System.out.println(Double.parseDouble("12.5").getClass().getSimpleName());
4      }
5  }
```

3行目を実行するとどうなるか。

A. `Double`と出力される

B. `double`と出力される

C. 3行目でコンパイルエラーになる

D. 3行目で`NullPointerException`がスローされる

### 問題4-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          int iValue = Integer.parseInt("12.5");
4          System.out.println(iValue);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `12`と出力される

B. `13`と出力される

C. 3行目でコンパイルエラーになる

D. 3行目で`NumberFormatException`がスローされる

### 問題5-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer x = 1;
4          Integer y = x;
5          x += 1;
6          System.out.println(x + " " + y + " " + (x == y));
7      }
8  }
```

6行目を実行するとどうなるか。

A. `2 2 true`

B. `2 1 false`

C. `1 1 true`

D. `2 1 true`