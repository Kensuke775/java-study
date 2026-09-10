# mock1 復習用問題集(51〜60)

## 目次

- [問題51](#問題51)
- [問題52](#問題52)
- [問題53](#問題53)
- [問題54](#問題54)
- [問題55](#問題55)
- [問題56](#問題56)
- [問題57](#問題57)
- [問題58](#問題58)
- [問題59](#問題59)
- [問題60](#問題60)

<a id="q51"></a>
## 問題51

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   interface A {
 2        default void operate() {
 3             System.out.print("Start... ");
 4        }
 5   }
 6   class Super {
 7       static void print() {
 8            System.out.print("SUPER ");
 9       }
10   }
11   class Sub extends Super implements A {
12        public void operate() {

13            A.super.operate();
14            System.out.print("Sub#Start... ");
15        }
16        public void print() {
17            super.print();
18            System.out.print("SUB ");
19        }
20    }
21    public class Main {
22        public static void main(String[] args) {
23            A a = new Sub();
24            Super su = new Super();
25            a.operate();
26            Sub sub = (Sub)a;
27            sub.print();
28            su.print();
29        }
30    }
```

     A. Sub#Start... Sub#Start... SUPER SUB SUPER が出力される
     B. Sub#Start... Sub#Start... SUPER SUB が出力される
     C. Start... Sub#Start... SUPER SUB SUPER が出力される
     D. Start... Sub#Start... SUPER SUB が出力される
     E. Start... が出力された後、ClassCastExceptionがスローされる
     F. Start... Sub#Start... が出力された後、ClassCastExceptionがスローされる
     G. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q52"></a>
## 問題52

    次のローカル変数の宣言のうち、コンパイルエラーが発生するものはどれですか。
    （3 つ選択）

     A. String $_1 = "100";
     B. public var x = "1_000_000".length();

     C. final var y = Math.random();
     D. int var = Integer.parseInt("100");
     E. static final Integer INTVALUE = 1_000;
     F. char VALUE = (char)100.0F;
     G. boolean true = true;

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q53"></a>
## 問題53

    次のプログラムを正しく説明しているものはどれですか。
                             （3 つ選択）

```
 1   abstract class A {
 2        public A() {}                                   // (A)
 3        public abstract void methodX();                 // (B)
 4        final void methodY() {}                         // (C)
 5   }
 6   final class B extends A {

 7        public void methodX() {}                        // (D)
 8   }
 9   sealed interface Foo {                               // (E)
10        void methodZ();
11   }
12   non-sealed interface Bar extends Foo {}              // (F)
13   non-sealed record Product(int id) implements Foo {   // (G)
14        public void methodZ(){}
15   }
```

     A. クラス A はインスタンス化ができないため、A のコンストラクタも記述でき
         ない
     B. Bの methodX()は、public abstract を記述しなくてもコンパイラにより暗
         黙的に指定される
     C. C のようにfinalクラスでなくてもfinalメソッドを宣言することはできる
     D. Dのようにクラス Bを finalにする場合はmethodX() のオーバーライドが

         必須となる

     E. インタフェースも sealed を指定できるが、Eのような permits の省略はで
          きない
     F. インタフェースにシールされたインタフェースを継承する場合、F のように
          final以外を指定する必要がある
     G. レ コ ー ド に シ ー ル さ れ た イ ン タ フ ェ ー ス を 実 装 す る 場 合、G の よ う に
          sealed 以外を指定する必要がある

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q54"></a>
## 問題54

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    public class Main {
 2        public static void main(String[] args) {
 3            StringBuilder sb1 = new StringBuilder("hello");
 4            StringBuilder sb2 = new StringBuilder("bonjour");
 5            sb2.append("!");
 6            String hello = sb1.toString();
 7            String s1 = "HELLO";
 8            String s2 = "BONJOUR!";
 9            if(sb1.equals(hello)) System.out.print("A");
10            if(hello.equalsIgnoreCase(s1)) System.out.print("B");
11            if(s2.equals(sb2.toString())) System.out.print("C");
12            if(s1.length() == 4 || sb2.lastIndexOf("o") == 4)
13                System.out.println("D");
14            if(s2.charAt(6) =='!' && sb2.charAt(6) == '!')
15                System.out.print("E");
16        }
17    }
```

     A. ABCDEが出力される
     B. ABCEが出力される
     C. ABD が出力される

     D. AD が出力される

     E. BDが出力される
     F. BEが出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q55"></a>
## 問題55

    次のプログラム（抜粋）があります。

```
 2   class MyIOException extends IOException {}
 3   class MyException extends Exception {}
 4   class Base {
 5       public void calc(double d) throws IOException {}
 6   }
 7   class Sub extends Base {
 8       @Override
 9       // insert code here
10   }
```

    9 行目に記述するとコンパイルエラーが発生するものはどれですか。
                                   （2 つ選択）

     A. public void calc(double d) throws RuntimeException {}
     B. public void calc(double d) {}
     C. public void calc(double d) throws Exception {}
     D. public void calc(double d) throws FileNotFoundException {}
     E. public void calc(double d) throws MyIOException {}
     F. public void calc(double d) throws MyException {}

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q56"></a>
## 問題56

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   public class Main {
 2       public static void main(String... args) {

 3            new Other(); new Other(); new Other();
 4            new Other().print();
 5        }
 6    }
 7    class Other {
 8        private static int x;
 9        private int y;
10        public Other() { ++x; ++y; }
11        public void print() {
12            System.out.print("x:" + x-- + ", y:" + y--);
13        }
14    }
```

     A. x:1, y:1 が出力される
     B. x:3, y:1 が出力される
     C. x:3, y:0 が出力される
     D. x:4, y:1 が出力される
     E. x:1, y:4 が出力される
     F. x:4, y:4 が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q57"></a>
## 問題57

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    class OneClass { double value = 25.0; }
 2    class Main {
 3        public static void main(String[] args) {
 4            OneClass one = new OneClass();                // (A)
 5            OneClass another = one;
 6            float x = 25.0F;
 7            float y = x;
 8            one.value -= 10;                              // (B)
 9            x *= 2;                                       // (C)

10           System.out.println(x + ":" + y + ":"
11                   + one.value + ":" + another.value);
12       }
13   }
```

     A. A でコンパイルエラーが発生する
     B. Bでコンパイルエラーが発生する
     C. C でコンパイルエラーが発生する
     D. 25.0:50.0:15.0:25.0 が出力される
     E. 50.0:25.0:25.0:15.0 が出力される
     F. 50.0:50.0:15.0:25.0 が出力される
     G. 50.0:25.0:-10.0:-10.0 が出力される
     H. 50.0:25.0:15.0:15.0 が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q58"></a>
## 問題58

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   class MyResource implements AutoCloseable {
 2       private String name;
 3       public MyResource(String name) {
 4           this.name = name;
 5       }
 6       public void close() throws Exception {
 7           System.out.print("close:" + name);
 8           throw new Exception("Exception! ");
 9       }
10   }
11   public class Main {
12       public static void main(String[] args) {
13           try (var r1 = new MyResource("Resource1: ");
14                var r2 = new MyResource("Resource2: ");) {
15               System.out.print("try: ");

16            } catch (Exception e) {
17                  System.out.print("catch:" + e.getMessage());
18            } finally {
19                  System.out.print("finally:");
20            }
21        }
22    }
```

      A. try: close:Resource1: close:Resource2: catch:Exception! finally:が 出 力
          される
      B. try: close:Resource2: close:Resource1: catch:Exception! finally:が 出 力
          される
      C. try: catch:Exception! close:Resource1: close:Resource2: finally:が 出 力
          される
      D. try: catch:Exception! close:Resource2: close:Resource1: finally:が 出 力
          される
      E. try: catch:Exception! finally: close:Resource2: close:Resource1:が 出 力
          される
      F. try: finally: catch:Exception! close:Resource2: close:Resource1:が 出 力
          される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q59"></a>
## 問題59

    次のプログラムを正しく説明しているものはどれですか。
                             （2 つ選択）

    ● ex6¥Main.java

```
 1    package ex;
 2    import ex.a.Foo;                                       // (A)
 3    import ex.b.*;                                         // (B)
 4    public class Main {
 5        public static void main(String[] args) {
 6            new Foo(); new Bar();                          // (C)
 7        }

 8    }

● ex6¥Foo.java

 1    package ex.a;
 2    public class Foo {}

● ex6¥Bar.java

1     package ex.b;
2     class Bar {}
```

        A. A の行をimport ex.*.*; と記述しても Main.javaのコンパイルが成功する
        B. Main.javaのコンパイルにおいて Bの行が原因でコンパイルエラーが発生
          する
        C. Main.javaのコンパイルにおいて Cの行が原因でコンパイルエラーが発生

          する
        D. Foo.java と Bar.javaのコンパイルが成功するためには、両方のクラスに
          import static ex.Main.main; を宣言する必要がある
        E. Foo.java と Bar.javaのコンパイルが成功するためには、クラスパス上で
          ex.Main.classが見つかる必要がある
        F. Foo.java と Bar.javaはそれぞれ単体でコンパイルが成功する
        G. このプログラムはコンパイル、実行ができるが何も出力されない

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q60"></a>
## 問題60

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    record Book(int id, String title, String genre) {
 2         Book {
 3               genre = genre.toUpperCase();
 4         }
 5         public int id() {

 6            return id + 100;
 7        }
 8        public String getTitle() {
 9            return title.trim();
10        }
11    }
12    class Main {
13        public static void main(String[] args) {
14            Book b1 = new Book(1, " Java for Beginners ", "Technology ");
15            Book b2 = new Book(2, " History of Japan", "History ");
16            Book b3 = new Book(3, " Breakfast recipes ", "Food ");
17            b1.genre = " Computer";
18            System.out.print(b1.id() + b1.title() + b1.genre());
19            b2 = b3;
20            System.out.print(b2.id()+ b2.title() + b2.genre());
21        }
22    }
```

     A. 101 Java for Beginners COMPUTER 103 Breakfast recipes FOODが出
          力される
     B. 101 Java for Beginners Computer 103 Breakfast recipes FOODが出力
          される
     C. 101Java for BeginnersComputer 103Breakfast recipesFOODが出力さ
          れる
     D. 101 Java for Beginners Computer 103 Breakfast recipes foodが出力さ
          れる
     E. 1 Java for Beginners Computer 3 Breakfast recipes FOODが出力され
          る
     F. 1Java for BeginnersTECHNOLOGY 3Breakfast recipesFOODが出力さ
          れる
     G. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

