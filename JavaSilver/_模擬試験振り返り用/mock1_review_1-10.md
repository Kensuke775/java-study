# mock1 復習用問題集(1〜10)

## 目次

- [問題1](#問題1)
- [問題1 EX](#問題1-ex)
- [問題1 EX2](#問題1-ex2)
- [問題1 EX3](#問題1-ex3)
- [問題2](#問題2)
- [問題2 EX](#問題2-ex)
- [問題2 EX2](#問題2-ex2)
- [問題2 EX3](#問題2-ex3)
- [問題3](#問題3)
- [問題3 EX](#問題3-ex)
- [問題3 EX2](#問題3-ex2)
- [問題4](#問題4)
- [問題4 EX](#問題4-ex)
- [問題4 EX2](#問題4-ex2)
- [問題4 EX3](#問題4-ex3)
- [問題5](#問題5)
- [問題6](#問題6)
- [問題7](#問題7)
- [問題7 EX](#q7-ex)
- [問題7 EX2](#q7-ex2)
- [問題8](#問題8)
- [問題8 EX](#q8-ex)
- [問題9](#問題9)
- [問題10](#問題10)

## 問題1

```
  次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                  （1つ選択）
```

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           String s1 = "Java";
 4           String s2 = new String("Java");
 5           String s3 = "Java";
 6           String s4 = new String("Java").intern();
 7           String s5 = "java";
 8           String s6 = """
 9                   java
10                   """;
11           System.out.println((s1 == s2) + ":" + (s1 == s3)
12                     + ":" + (s3 == s4) + ":" + (s3 == s5)
13                     + ":" + (s5 == s6) +":" + (s5.equals(s6)));
14       }
15   }
```

```
       A. true:true:true:false:false:falseが出力される
       B. true:true:true:false:false:trueが出力される
       C. false:true:true:false:false:falseが出力される
       D. false:true:true:false:false:trueが出力される
       E. false:true:false:false:false:true が出力される
       F. false:true:true:false:true:trueが出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題1 EX



### TB-1

次の6つの独立したコード（それぞれ別々のプログラムの一部）について、`System.out.println(s.length());`の結果が**4になるものをすべて選んでください**。（4つ選択）

```
// A
String s = """
        java  """;
System.out.println(s.length());
```

```
// B
String s = """
        java\
        """;
System.out.println(s.length());
```

```
// C
String s = """
        java\s""";
System.out.println(s.length());
```

```
// D
String s = """
        java
        """;
System.out.println(s.length());
```

```
// E
String s = """
        java""";
System.out.println(s.length());
```

```
// F
String s = """
        java\
        \
        """;
System.out.println(s.length());
```

A. Aの`s.length()`は4になる
B. Bの`s.length()`は4になる
C. Cの`s.length()`は4になる
D. Dの`s.length()`は4になる
E. Eの`s.length()`は4になる
F. Fの`s.length()`は4になる

**実施記録**

回答：
正解：
迷ったポイント：

---



### TB-2

次の記述のうち、正しいものをすべて選んでください。（4つ選択）

A. `String s = """java""";`（開始の`"""`の直後に改行を挟まず、同じ行に本文を書く）はコンパイルエラーになる

B. テキストブロックの各行の**末尾の空白**は、`\s`のようなエスケープで明示的に保護しない限り、自動的に取り除かれる

C. テキストブロックの行末に`\`（バックスラッシュ）を1つ書くと、その行と次の行の間に改行が挿入されなくなる（2つの行の内容がそのまま連結される）

D. テキストブロックの行末の`\`は、2行連続で使うことはできず、必ず1回までしか改行を抑制できない

E. 閉じデリミタ（`"""`）を本文の最後の行と同じ行に書いた場合と、本文の後に改行してから独立した行に書いた場合とでは、生成される文字列の内容（および長さ）が異なることがある

**実施記録**

回答：B C E
正解：A B C E
迷ったポイント：Aを見落とした（開始`"""`直後の改行必須ルールが、コンパイルエラーになる要因として頭から抜けていた）

---



### TB-3

次の記述のうち、**誤っているものを3つ**選んでください。

A. 閉じデリミタ（`"""`）を本文の最後の行と同じ行に書いた場合と、本文の後に改行してから独立した行に書いた場合とでは、生成される文字列の内容は常に完全に同じになる（違いが生まれることはない）

B. テキストブロックの各行の末尾の空白は、`\s`のようなエスケープで明示的に保護しない限り、自動的に取り除かれる

C. テキストブロックの行末に`\`（バックスラッシュ）を1つ書くと、その行と次の行の間に改行が挿入されなくなる（2つの行の内容がそのまま連結される）

D. テキストブロックの行末の`\`は、2行連続で使うことはできず、必ず1回までしか改行を抑制できない

E. `String s = """java""";`（開始の`"""`の直後に改行を挟まず、同じ行に本文を書く）は、問題なくコンパイルが成功する

F. 閉じデリミタ（`"""`）が本文の各行よりも浅いインデント（左寄り）で書かれている場合、共通インデントとして取り除かれる空白の量が変わり、本文側に余分な空白が残ることがある

G. テキストブロック内でダブルクォート（`"`）を1つだけ、または2つ連続で書く場合はエスケープ不要で、`\"""`のようなエスケープが必要になるのは3つ連続で書く場合だけである

**実施記録**

回答：A E F
正解：A D E
迷ったポイント：Dを見落とし、代わりにFを選んでしまった。バックスラッシュ継続は複数回連続で使える（1回までという制約はない）ことと、閉じデリミタのインデントが浅いと余分な空白が本文に残る（Fは正しい記述）ことの区別がついていなかった。

---



## 問題1 EX2

```
  次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                  （1つ選択）
```

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           final String a = "Java\n";
 4           String b = """
 5                   Java
 6                   """;
 7           String c = """
 8                   Java\
 9                   """;
10           String d = """
11                   Java\s
12                   """;
13           String e = """
14                   Java\n
15                   """;
16           String f = new String("Java\n");
17           StringBuilder sb = new StringBuilder("Java\n");
18           System.out.println((a == b) + ":" + (b == c) + ":" + (b == d)
19                     + ":" + (a == f) + ":" + (a.equals(f)) + ":" + (a.contentEquals(sb)));
20       }
21   }
```

```
       A. true:false:false:false:true:trueが出力される
       B. true:true:false:false:true:trueが出力される
       C. true:false:true:false:true:trueが出力される
       D. true:false:false:true:true:trueが出力される
       E. false:false:false:false:true:trueが出力される
       F. true:false:false:false:false:trueが出力される
```

**実施記録**

回答：  
正解：  
迷ったポイント：

- `b` = `"Java\n"` (スペース無し、改行のみ)
- `d` = `"Java \n"` (末尾に半角スペース1つ + 改行)
- `a == b` → **true**: テキストブロックも中身が確定した内容(コンパイル時定数)なので、通常の文字列リテラルと同じ文字列プールにインターンされ、同じ参照になる。
- `b == c` → **false**: `c`は最終行末に`\`を置いて改行を抑制しているため中身が`"Java"`(改行なし)になり、`b`の`"Java\n"`とは別内容の別オブジェクト。
- `b == d` → **false**: `d`は`\s`で末尾の空白を保護しているため中身が`"Java \n"`(末尾に半角スペース)になり、これも別内容。
- `a == f` → **false**: `new String(...)`は内容が同じでもヒープ上に新規生成されるため、プール上の`a`とは別オブジェクト。
- `a.equals(f)` → **true**: 内容比較なので一致。
- `a.contentEquals(sb)` → **true**: `StringBuilder`でも文字列の内容比較なら一致。

---



<a id="問題1-ex3"></a>
## 問題1 EX3　復習用

```
  次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                  （1つ選択）
```

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           String s6 = """
 4                   \sjava
 5                   """;
 6           String s7 = """
 7                    java
 8                   """;
 9           String s8 = """
10                   java    \s
11                   """;
12           System.out.println(s6.length() + ":" + s7.length() + ":" + s8.length()
13                     + ":" + (s6.equals(s7)) + ":" + (s6 == s7));
14       }
15   }
```

```
       A. 6:6:10:true:trueが出力される
       B. 5:6:9:true:trueが出力される
       C. 6:5:10:false:falseが出力される
       D. 6:6:10:true:falseが出力される
       E. 6:6:9:false:trueが出力される
       F. 5:5:10:true:trueが出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題2

```
次のプログラムがあります。
```

```
1   public class Test {
2       public static void main(String[] args) {
3           System.out.println(method(args));         // (A)
4       }
5       // insert code here
6   }
```

```
（A）の行を実行するために 5 行目に記述するメソッド宣言として正しいものはど
れですか。
    （1 つ選択）

 A. static int method(String... s) { return s.length;}
 B. int method(String... s) { return s.length;}

 C. private static void method(String... s) {}
 D. public void method(String... s) {}
 E. protected String method() { return "hi";}
 F. static String method() { return "hi";}
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題2 EX

```
次のプログラムがあります。
```

```
1   public class Runner {
2       public static void main(String[] args) {
3           System.out.println(compute(10, 20, 30));   // (A)
4       }
5       // insert code here
6   }
```

```
（A）の行を実行するために 5 行目に記述するメソッド宣言として正しいものは
どれですか。
    （1 つ選択）

 A. static int compute(int... nums) { return nums.length; }
 B. abstract int compute(int... nums);
 C. non-sealed int compute(int... nums) { return nums.length; }
 D. static void compute(int... nums) { System.out.println(nums.length); }
 E. int compute(int... nums) { return nums.length; }
 F. static int compute() { return 0; }
 G. sealed static int compute(int... nums) { return nums.length; }
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題2 EX2

```
次のプログラムがあります。
```

```
1   public class Runner {
2       public static void main(String[] args) {
3           System.out.println(compute(10, 20, 30));   // (A)
4       }
5       // insert code here
6   }
```

```
（A）の行を実行するために 5 行目に記述するメソッド宣言として、誤ってい
るものはどれですか。
    （1 つ選択）

 A. static int compute(int... nums) { return nums.length; }
 B. static int compute(int[] nums) { return nums.length; }
 C. static long compute(int... nums) { return nums.length; }
 D. static Integer compute(int... nums) { return nums.length; }
 E. static int compute(Integer... nums) { return nums.length; }
 F. private static int compute(int... nums) { return nums.length; }
 G. static int compute(int a, int b, int c) { return a + b + c; }
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題2 EX3

```
次のプログラムがあります。
```

```
1   public class Runner {
2       public static void main(String[] args) {
3           System.out.println(compute(10, 20, 30));   // (A)
4       }
5       // insert code here
6   }
```

```
（A）の行を実行するために 5 行目に記述するメソッド宣言として正しいもの
はどれですか。
    （2 つ選択）

 A. static int compute(int... nums) { return nums.length; }
 B. abstract int compute(int... nums);
 C. non-sealed int compute(int... nums) { return nums.length; }
 D. static void compute(int... nums) { System.out.println(nums.length); }
 E. int compute(int... nums) { return nums.length; }
 F. static int compute() { return 0; }
 G. sealed static int compute(int... nums) { return nums.length; }
 H. private static int compute(int... nums) { return nums.length; }
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題3

```
次の記述のうちコンパイルエラーが発生するものはどれですか。
                            （3 つ選択）

 A. ArrayList<Integer> list = new ArrayList<>();
 B. ArrayList<String> list = new ArrayList<String>();
 C. ArrayList<double> list = new ArrayList<>();
 D. List<Item> list = new ArrayList<>();
 E. List<String> list = new List<String>();
 F. List list = new ArrayList();
 G. List<Integer> list = List.of(1, 2, 3);
 H. ArrayList<Integer> list = Arrays.asList("1", "2", "3");
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題3 EX

```
次の記述のうちコンパイルエラーになるものはどれですか。
                            （3 つ選択）
```

```
1   import java.util.*;
2
3   public class Main {
4       public static void main(String[] args) {
5           List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
6           List<Object> list2 = new ArrayList<String>();
7           ArrayList<Integer> list3 = Arrays.asList(1, 2, 3);
8           List<Integer> list4 = List.of(1, 2, 3);
9           List<double> list5 = new ArrayList<>();
10          List<String> list6 = new ArrayList<>(List.of("a", "b"));
11          List<String> list7 = Arrays.asList("a", "b");
12      }
13  }
```

```
 A. 5 行目
 B. 6 行目
 C. 7 行目
 D. 8 行目
 E. 9 行目
 F. 10 行目
 G. 11 行目
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題3 EX2

```
次の記述のうちコンパイルが成功するものはどれですか。
                            （3 つ選択）
```

```
1   import java.util.*;
2
3   public class Main {
4       public static void main(String[] args) {
5           List<Integer> list1 = new List<>();
6           List<Object> list2 = new ArrayList<String>();
7           List<String> list3 = new ArrayList();
8           List list4 = new ArrayList<String>();
9           ArrayList<Integer> list5 = List.of(1, 2, 3);
10          List<String> list6 = new ArrayList<>(List.of("a", "b"));
11          List<Integer> list7 = new ArrayList<String>();
12      }
13  }
```

```
 A. 5 行目
 B. 6 行目
 C. 7 行目
 D. 8 行目
 E. 9 行目
 F. 10 行目
 G. 11 行目
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題4

```
次のプログラムがあります。

● ex4¥Main.java
```

```
 1    package com.x;
 2    import com.y.Test;
 3    public class Main {
 4        public static void main(String[] args) {
 5            Test.print();
 6        }
 7    }

● ex4¥Test.java

 1    package com.y;
 2    public class Test {
 3        public static void print() {
 4            System.out.println("Test");
 5        }
 6    }
```

```
コンパイル、実行を行うと Testが出力されるものはどれですか。
                               （2 つ選択）
なおコマンドは ex4 ディレクトリで実行し、OS にはCLASSPATH環境変数の指
定がないものとします。

  A. >javac -d . Main.java Test.java
      >java -classpath . com.x.Main
  B. >javac -d *.java
      >java -cp com.x.Main
  C. >javac *.java
      >java com.x.Main
  D. >javac -d classes *.java
      >java -cp classes com.x.Main

 E. >javac -d classes *.java
    >java -cp classes Main
 F. >javac classes Main.java Test.java
    >java -p classes Main
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題4 EX

```
次のプログラムがあります。

● ex4ex\Main.java

 1    package com.x;
 2    import com.y.Test;
 3    public class Main {
 4        public static void main(String[] args) {
 5            Test.print();
 6        }
 7    }

● ex4ex\Test.java

 1    package com.y;
 2    public class Test {
 3        public static void print() {
 4            System.out.println("Test");
 5        }
 6    }
```

```
コンパイル、実行を行うとTestが出力されるものはどれですか。
                               （2 つ選択）
なおコマンドはex4exディレクトリで実行し、OSにはCLASSPATH環境変数の指
定がないものとします。
```

A. `>javac -d bin *.java`
   `>java -cp bin com.x.Main`

B. `>javac -d bin Main.java Test.java`
   `>java -cp . com.x.Main`

C. `>javac -d . Main.java Test.java`
   `>java -classpath . com.x.Main`

D. `>javac -d bin *.java`
   `>java -cp bin Main`

E. `>javac *.java`
   `>java -cp . com.x.Main`

F. `>javac -d *.java`
   `>java -cp Main.java com.x.Main`

**実施記録**

---



## 問題4 EX2

```
次のプログラムがあります。

● ex4ex2\Main.java

 1    package com.x;
 2    import com.y.Test;
 3    public class Main {
 4        public static void main(String[] args) {
 5            Test.print();
 6        }
 7    }

● ex4ex2\Test.java

 1    package com.y;
 2    public class Test {
 3        public static void print() {
 4            System.out.println("Test");
 5        }
 6    }
```

```
次のA〜Hのコンパイル・実行手順のうち、Testが出力されない（誤っている）
ものはどれですか。
                               （4 つ選択）
なおコマンドはex4ex2ディレクトリで実行し、OSにはCLASSPATH環境変数の指
定がないものとします。
```

A. `>javac -d classes *.java`
   `>java -cp classes com.x.Main`

B. `>javac -d classes *.java`
   `>java -cp classes Main`

C. `>javac -d . *.java`
   `>java -cp . com.x.Main`

D. `>javac *.java`
   `>java -cp classes com.x.Main`

E. `>javac -d classes Main.java`
   `>java -cp classes com.x.Main`

F. `>javac -d classes *.java`
   `>java -classpath classes com.x.Main`

G. `>javac -d classes *.java`
   `>java -cp classes com.y.Main`

H. `>javac -d classes Test.java Main.java`
   `>java -cp classes com.x.Main`

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題4 EX3

```
次のプログラムがあります。

● ex4ex3\Main.java

 1    package com.x;
 2    import com.y.Test;
 3    public class Main {
 4        public static void main(String[] args) {
 5            Test.print();
 6        }
 7    }

● ex4ex3\Test.java

 1    package com.y;
 2    public class Test {
 3        public static void print() {
 4            System.out.println("Test");
 5        }
 6    }
```

```
次のA〜Fのコンパイル・実行手順のうち、Testが出力されない（誤っている）
ものはどれですか。
                               （3 つ選択）
なおコマンドはex4ex3ディレクトリで実行し、OSにはCLASSPATH環境変数の指
定がないものとします。
```

A. `>javac -d out *.java`
   `>java -cp out com.x.Main`

B. `>javac -d ./out *.java`
   `>java -cp out/ com.x.Main`

C. `>javac -d out *.java`
   `>java -cp out/com com.x.Main`

D. `>javac -d out/com *.java`
   `>java -cp out com.x.Main`

E. `>javac -d out *.java`
   `>java -classpath out com.x.Main`

F. `>javac -d out *.java`
   `>java -cp out Main`

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題5

```
次のプログラムのコンパイルが完了しています。
```

```
1   class Main {
2       public static void main(String[] args) {
3           main(new Main(), args);
4       }
5       static void main(Main m, String... s) {
6           System.out.println(m + ", " + s);
7       }

8   }
```

```
以下の方法で実行するとどのような結果になりますか。
                        （1 つ選択）

>java Main Java S E 17

 A. Main, [ Java, S, E, 17]が出力される
 B. Main@13221655, [Java, S, E, 17]が出力される
 C. Main, { Java S E 17}が出力される
 D. Main@13221655, [Ljava.lang.String;@2f2c9b19 が出力される
 E. [LMain@13221655, JavaSE17 が出力される
 F. [LMain;@13221655, java.lang.String@2f2c9b19 が出力される
 G. この中にはない
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題6

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1    class FirstExeption extends Exception {}
 2    class SubFirstException extends FirstExeption {}
 3    class SecondException extends RuntimeException {}
 4    public class Main {
 5        public static void main(String[] args) {
 6            try {
 7                execute(5 % 2);
 8            } catch (SubFirstException | SecondException e) {   // (A)
 9                System.out.println("SubFirst | Second");
10            } catch (FirstExeption e) {                         // (B)
11                System.out.println("First");
12            } catch (Exception e) {
13                System.out.println("Ex");
14            }
15        }
16        public static void execute(int value) throws Exception {
17            switch (value) {
18                case 1 -> throw new FirstExeption();
19                case 2 -> throw new SubFirstException();
20                case 3 -> throw new SecondException();
21                default -> throw new RuntimeException();        // (C)
22            }
23        }
24    }
```

```
 A. A でコンパイルエラーが発生する
 B. Bでコンパイルエラーが発生する
 C. C でコンパイルエラーが発生する
 D. 正常にコンパイル、実行でき、SubFirst | Second が出力される
 E. 正常にコンパイル、実行でき、Firstが出力される

 F. 正常にコンパイル、実行でき、Exが出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題7

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   import java.util.*;
 2   public class Main {
 3       static int x = 1;
 4       public static void main(String[] args) {
 5           int[][] a = new int[2][];                        // (A)
 6           a[0] = new int[1];
 7           a[1] = new int[3];
 8           a[0][0] += ++x;                                  // (B)
 9           a[1][1] = a[0].length;
10           a[1][2] = x++;

11           System.out.println(Arrays.toString(a[0])
12                             + ":" + Arrays.toString(a[1])); // (C)
13       }
14   }
```

```
 A. A でコンパイルエラーが発生する
 B. Bでコンパイルエラーが発生する
 C. C で ArrayIndexOutOfBoundsExceptionがスローされる
 D. [2, 0]:[0, 2, 2] が出力される
 E. [2]:[0, 1, 2] が出力される
 F. [1]:[2, 2, 2] が出力される
 G. [3, 0]:[0, 2] が出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



<a id="q7-ex"></a>
## 問題7 EX　復習用

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   import java.util.*;
 2   public class Main {
 3       int x = 1;
 4       public static void main(String[] args) {
 5           int[][] a = new int[2][];                        // (A)
 6           a[0] = new int[1];
 7           a[1] = new int[3];
 8           a[0][0] += ++x;                                   // (B)
 9           a[1][1] = a[0].length;
10           a[1][2] = x++;
11           System.out.println(Arrays.toString(a[0])
12                             + ":" + Arrays.toString(a[1])); // (C)
13       }
14   }
```

```
 A. A でコンパイルエラーが発生する
 B. Bでコンパイルエラーが発生する
 C. C で ArrayIndexOutOfBoundsExceptionがスローされる
 D. [2, 0]:[0, 2, 2] が出力される
 E. [2]:[0, 1, 2] が出力される
 F. [1]:[2, 2, 2] が出力される
 G. [3, 0]:[0, 2] が出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



<a id="q7-ex2"></a>
## 問題7 EX2　復習用

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   import java.util.*;
 2   public class Main {
 3       int x = 1;
 4       public static void main(String[] args) {
 5           int[][] a = new int[2][];
 6           a[0] = new int[1];
 7           a[1] = new int[3];
 8           a[0][0] += ++new Main().x;
 9           a[1][1] = a[0].length;
10           a[1][2] = ++new Main().x;
11           System.out.println(Arrays.toString(a[0])
12                             + ":" + Arrays.toString(a[1]));
13       }
14   }
```

```
 A. コンパイルエラーが発生する
 B. [2]:[0, 1, 2] が出力される
 C. [2]:[0, 1, 3] が出力される
 D. [1]:[0, 1, 2] が出力される
 E. [2]:[0, 1, 1] が出力される
 F. NullPointerExceptionがスローされる
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題8

```
次のプログラムはTest.java というファイルに記述されています。このプログラ
ムを正しく説明しているものはどれですか。
                   （1 つ選択）
```

```
1    public class A {
2        public static void main(String... args) {
3            System.out.println(0b0100 | 3);
4        }
5    }
```

```
 A. >javac Test.java でコンパイルが成功し、>java A を実行すると 3 が出力さ
      れる
 B. >javac Test.java でコンパイルが成功し、>java A を実行すると 4 が出力さ
      れる
 C. >java Test.java でプログラムを実行するためには、ソースファイル名を
      A.java にする必要がある
 D. >javac Test.java でコンパイルが成功するためには、クラス名をMainにす
      る必要がある
 E. >java Test.java でプログラムの実行ができ、false が出力される
 F. >java Test.java でプログラムの実行ができるが、何も出力されない
 G. 正しい説明はない
```

**実施記録**

回答：
正解：
迷ったポイント：

---



<a id="q8-ex"></a>
## 問題8 EX　復習用

```
次のプログラムはSample.java というファイルに記述されています。このプロ
グラムを正しく説明しているものはどれですか。
                   （2 つ選択）
```

```
1    public class C {
2        public static void main(String[] args) {
3            System.out.println(023 ^ 6);
4        }
5    }
```

```
 A. >javac Sample.java でコンパイルが成功し、>java C を実行すると 17 が出力さ
      れる
 B. >javac Sample.java でコンパイルが成功し、>java C を実行すると 21 が出力さ
      れる
 C. >java Sample.java でプログラムを実行するためには、ソースファイル名を
      C.java にする必要がある
 D. >javac Sample.java がコンパイルエラーになるのは、publicクラスCの名前が
      ファイル名Sampleと一致していないためである
 E. >java Sample.java でプログラムの実行ができ、21 が出力される
 F. >java Sample.java でプログラムの実行ができ、false が出力される
 G. >java Sample.java でプログラムの実行ができるが、何も出力されない
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題8 EX2

次の記述のうち、**誤っているものを3つ**選んでください。

A. 8進数リテラル`017`は、10進数の15を表す

B. 16進数リテラルは`0x`または`0X`で始めることができ、続く16進数字（0-9, a-f, A-F）は大文字小文字を自由に混在させて書ける（例：`0x1A`と`0X1a`はどちらも正しい）

C. 2進数リテラルは`0b`または`0B`で始めることができる

D. ビット単位OR演算子`|`は、両方のオペランドの対応するビットがともに1である場合にのみ、結果のビットが1になる

E. ビット単位XOR演算子`^`は、対応するビット同士が異なる場合に1、同じ場合に0になる

F. 数値リテラルの桁区切り用アンダースコア`_`は先頭・末尾には置けないが、桁の途中であれば`1__000`のようにアンダースコアを連続して複数個並べることもできる

G. ビット単位AND演算子`&`は、対応するビットの少なくとも一方が1であれば、結果のビットが1になる

H. ビット演算子（`|`, `&`, `^`）による計算は、まず両オペランドをいったん10進数に変換してから行われる

**実施記録**

回答： 正解：

---



## 問題9

```
次のプログラムがあります。
```

```
1    sealed class Base {}
2    // insert code here
```

```
2 行目に記述できるクラス宣言として正しいものはどれですか。
                             （4 つ選択）

 A. public class Derived {}

 B. private class Derived {}
 C. final class Derived {}
 D. static class Derived extends Base{}
 E. abstract class Derived{}
 F. abstract final class Derived {}
 G. sealed final class Derived {}
 H. non-sealed class Derived extends Base {}
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題9 EX

```
次のプログラムがあります。
```

```
1    sealed class Base {}
2    final class SubBase extends Base {}
3    // insert code here
```

```
3 行目に記述できるクラス宣言として、誤っているものはどれですか。
                             （4 つ選択）

 A. public final class Derived extends Base {}
 B. protected class Derived {}
 C. static final class Derived extends Base {}
 D. abstract final class Derived {}
 E. final class Derived {}
 F. non-sealed class Derived extends Base {}
 G. sealed class Derived extends Base {}
```

**実施記録**

回答：B C D G
正解：B C D G
迷ったポイント：なし（一発正解）

## 問題10

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   public class Item {
 2       private String name;
 3       void Item() {
 4           name = "Something";

 5       }
 6       public Item(String name) {
 7           name = name;
 8       }
 9       public String toString() {
10           return " Item:" + name;
11       }
12       public static void main(String...args) {
13           System.out.print(new Item());
14           System.out.println(new Item("Coffee"));
15       }
16   }
```

```
 A. Item:null が出力される
 B. Item:Something Item:Coffee が出力される
 C. Item:Something が出力される

 D. Item:Coffee が出力される
 E. Item@27fe3806 が出力される

 F. コンパイルエラーが発生する
```

**実施記録**

回答：
正解：
迷ったポイント：

---

