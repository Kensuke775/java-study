# 1章 1. 基本データ型と参照型の型変換 問題集(2周目・別バージョン)

`1-基本データ型と参照型の型変換/problem.md`と同じ概念を、別のクラス・値・型で出題し直したもの。全問`javac`/`java`で検証済み。ラムダ式は使用していません。

## 目次

- [問題1-1](#問題1-1)
- [問題1-2](#問題1-2)
- [問題1-3](#問題1-3)
- [問題1-4](#問題1-4)
- [問題1-5](#問題1-5)
- [問題2-1](#問題2-1)
- [問題2-2](#問題2-2)
- [問題3-1](#問題3-1)
- [問題3-2](#問題3-2)
- [問題3-3](#問題3-3)
- [問題4-1](#問題4-1)

<br><br>

<a id="問題1-1"></a>
### 問題1-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double wrap = null;
4          double dValue = wrap.doubleValue();
5          System.out.println(dValue);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `0.0`と出力される

B. 4行目で`NullPointerException`がスローされる

C. 3行目でコンパイルエラーになる(`Double`に`null`は代入できない)

D. `null`と出力される

あなたの回答: 

<a id="問題1-2"></a>
### 問題1-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer i1 = 50;
4          Integer i2 = new Integer(50);
5          Integer i3 = 300;
6          Integer i4 = 300;
7          System.out.println((i1 == i2) + " " + (i3 == i4));
8      }
9  }
```

7行目を実行するとどうなるか。

A. `true true`

B. `true false`

C. `false true`

D. `false false`

あなたの回答: 

<a id="問題1-3"></a>
### 問題1-3

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double d = 20;
4          System.out.println(d);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `20.0`と出力される

B. 3行目でコンパイルエラーになる

C. 実行時に`ClassCastException`がスローされる

D. 実行時に`NumberFormatException`がスローされる

あなたの回答: 

<a id="問題1-4"></a>
### 問題1-4

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer i = Integer.valueOf("42xyz");
4          System.out.println(i);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `42`と出力される

B. 3行目で`NumberFormatException`がスローされる

C. 3行目でコンパイルエラーになる

D. `null`と出力される

あなたの回答: 

<a id="問題1-5"></a>
### 問題1-5

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double d = Double.valueOf(7.77);
4          long x = d.longValue();
5          System.out.println(x);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `7`と出力される

B. `8`と出力される

C. `7.77`と出力される

D. 4行目でコンパイルエラーになる

E. 実行時に`ClassCastException`がスローされる

あなたの回答: 

<a id="問題2-1"></a>
### 問題2-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          Double a = null;
4          double b = a + 1.0;
5          System.out.println(b);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `1.0`と出力される

B. 4行目で`NullPointerException`がスローされる

C. 3行目でコンパイルエラーになる

D. `0.0`と出力される

あなたの回答: 

<a id="問題2-2"></a>
### 問題2-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          Integer i = 130;
4          byte b = i.byteValue();
5          System.out.println(b);
6      }
7  }
```

4行目を実行するとどうなるか。

A. `130`と出力される

B. 4行目でコンパイルエラーになる(`130`は`byte`の範囲外)

C. `-126`と出力される

D. 実行時に`ArithmeticException`がスローされる

あなたの回答: 

<a id="問題3-1"></a>
### 問題3-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          int x = Integer.valueOf('b');
4          System.out.println(x);
5      }
6  }
```

3行目・4行目を実行するとどうなるか。

A. `b`と出力される

B. `98`と出力される

C. `0`と出力される

D. 3行目でコンパイルエラーになる(`char`は`Integer.valueOf()`に渡せない)

あなたの回答: 

<a id="問題3-2"></a>
### 問題3-2

```java
1  public class Main {
2      public static void main(String[] args) {
3          long x = Integer.valueOf("42");
4          System.out.println(x);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `42`と出力される

B. 3行目でコンパイルエラーになる

C. 実行時に`ClassCastException`がスローされる

D. 実行時に`NumberFormatException`がスローされる

あなたの回答: 

<a id="問題3-3"></a>
### 問題3-3

```java
1  public class Main {
2      public static void main(String[] args) {
3          System.out.println(Integer.valueOf("42").intValue().getClass().getSimpleName());
4      }
5  }
```

3行目を実行するとどうなるか。

A. `Integer`と出力される

B. `int`と出力される

C. 3行目でコンパイルエラーになる

D. 3行目で`NullPointerException`がスローされる

あなたの回答: 

<a id="問題4-1"></a>
### 問題4-1

```java
1  public class Main {
2      public static void main(String[] args) {
3          long lValue = Long.parseLong("42.5");
4          System.out.println(lValue);
5      }
6  }
```

3行目を実行するとどうなるか。

A. `42`と出力される

B. `43`と出力される

C. 3行目でコンパイルエラーになる

D. 3行目で`NumberFormatException`がスローされる

あなたの回答: 
