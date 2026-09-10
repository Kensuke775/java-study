# mock1 復習用問題集(31〜40)

## 目次

- [問題31](#問題31)
- [問題32](#問題32)
- [問題33](#問題33)
- [問題34](#問題34)
- [問題35](#問題35)
- [問題36](#問題36)
- [問題37](#問題37)
- [問題38](#問題38)
- [問題39](#問題39)
- [問題40](#問題40)

<a id="q31"></a>
## 問題31

    次のプログラムのコンパイルが完了しています。

```
 1   public class Main {
 2       public static void main(String... args) {

 3            double d = Double.parseDouble(args[0]);
 4            int i = Integer.parseInt(args[1]);
 5            new Main().method(d, i);
 6        }
 7        public void method(double x, double y) {
 8            System.out.println("A");
 9        }
10        public void method(Double x, float y) {
11            System.out.println("B");
12        }
13        public void method(int... x) {
14            System.out.println("C");
15        }
16        public void method(Double... d) {
17            System.out.println("D");
18        }
19        public void method(long x, int y) {
20            System.out.println("E");
21        }
22    }
```

    以下の方法で実行するとどのような結果になりますか。
                            （1 つ選択）

     >java Main 1 1

     A. A が出力される
     B. Bが出力される
     C. C が出力される
     D. Dが出力される
     E. Eが出力される
     F. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q32"></a>
## 問題32

     次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                     （1つ選択）

```
 1    public class Product {
 2        private double price;
 3        private Product() {
 4            this(100.0);                               // (A)
 5            System.out.print(" 1:" + price);
 6        }
 7        Product(double price) {
 8            price = price;
 9            System.out.print(" 2:" + price);
10        }
11        public void print() {
12            System.out.println(" 3:" + this.price);
13        }

14        public static void main(String[] args) {
15            new Product().print();                     // (B)
16        }
17    }
```

      A. A でコンパイルエラーが発生する
      B. Bでコンパイルエラーが発生する
      C. 1:0.0 2:0.0 3:0.0 が出力される
      D. 1:0.0 2:100.0 3:0.0 が出力される
      E. 2:0.0 1:0.0 3:0.0 が出力される
      F.   2:100.0 1:0.0 3:0.0 が出力される
      G. 2:100.0 1:0.0 3:100.0 が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q33"></a>
## 問題33

    次のプログラム（抜粋）の説明として正しくないものはどれですか。
                                  （2 つ選択）

```
2        public void a(String s1, String... s2) {}       // (A)
3        public void b(String... s, int i) {}            // (B)
4        public void c(var x, var... y) {}               // (C)
5        public void d(int... i, int... j) {}            // (D)
6        public void e(String... s) {}                   // (E)
7        public void f(double[] d1, double... d2) {}     // (F)
```

     A. A のように同じデータ型のみの引数リストの場合も、そのうち 1 つを可変長
          にすることができる
     B. Bのように複数の引数がある場合、可変長引数は引数リストの最後に記述
          する必要がある
     C. C の varは可変長引数にすることができないため、第 2 引数をvar yと通常
          の変数にすることでコンパイルが成功する
     D. Dのように 2 つ以上の引数を可変長にすることはできず、コンパイルエ
          ラーが発生する
     E. Eのように引数リストが可変長引数のみの場合、引数を渡さずにメソッド
          呼び出しを行うことができる
     F. F のように同じデータ型で配列と可変長引数の両方を指定することはでき
          ず、コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q34"></a>
## 問題34

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    public class Person {
 2        public String name;
 3        { name = "N/A"; }
 4        public Person() {}
 5        public Person(String name) { this.name = name; }

 6   }
 7   class Main {
 8       public static void main(String[] args) {
 9           Person one = new Person("Duke");
10           Person two = one;
11           two.name = "James";
12           System.out.print(one.name + ":" + two.name + ":");
13           Person three = new Person();
14           System.out.print(three.name);
15       }
16   }
```

     A. Duke:James:N/Aが出力される
     B. James:James:N/A が出力される
     C. Duke:Duke:が出力される
     D. James:James: が出力される

     E. Duke:Duke:N/A が出力される
     F. N/A:N/A:N/Aが出力される
     G. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q35"></a>
## 問題35

    次の記述のうち例外処理が必須のものはどれですか。
                           （2 つ選択）

     A. java.io.IOException
     B. java.lang.StackOverflowError
     C. java.lang.ArithmeticException
     D. java.lang.ArrayIndexOutOfBoundsException
     E. java.io.FileNotFoundException
     F. java.lang.ClassCastException
     G. java.lang.RuntimeException

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q36"></a>
## 問題36

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    public class Main {
 2        public static void main(String[] args) {
 3            int value = 0x000B;
 4            if(value <= 0)
 5                System.out.print("value: " + value + 2 + 10);
 6            else if(value > 0 && value < 10)
 7                System.out.print("value: " + value * 2 + 10);
 8            else if(value >= 10 & value <20)
 9                System.out.println("value: " + value - value);
10            else
11                System.out.println("value: " + value + value);
12        }
13    }
```

     A. value: 11210 が出力される
     B. value: 1110 が出力される
     C. value: 2210 が出力される
     D. value: 1111 が出力される
     E. value: 0 が出力される
     F. value: 0x000B が出力される
     G. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q37"></a>
## 問題37

    次のプログラム（抜粋）でコンパイルエラーが発生する行はどこですか。
                                    （3 つ選択）

```
 2    public class Main {
 3        var a = "Main";                                  // (A)
 4        var b = null;                                    // (B)

 5       void test(int a) {
 6           var x1 = 1, x2 = 2;                         // (C)
 7           final var x3 = 3.14f;                       // (D)
 8           var arr = new int[]{1, 2, 3};               // (E)
 9           for (var i : arr) System.out.print(i);      // (F)
10           var list = new ArrayList<>();               // (G)
11           list.add(' ');
12           list.add("LIST");                           // (H)
13       }
14   }
```

     A. A
     B. B
     C. C
     D. D
     E. E

     F. F
     G. G
     H. H

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q38"></a>
## 問題38

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   record Country(String name) {}
 2   public class Customer {
 3       String name;
 4       Country country;
 5       Customer(String name, Country country) {
 6           this.name = name; this.country = country;
 7       }
 8   }
 9   class Main {

10        public static void main(String[] args) {
11            Customer c1 = new Customer("Duke", new Country("US"));
12            Customer c2 = c1;
13            Customer c3 = new Customer("Carol", new Country("US"));
14            Customer c4 = new Customer("Johann", new Country("Germany"));
15            String result = "";
16            result += c1 == c2 ?   "Y:" : "N:";
17            result += !(c2.country == c3.country) ?       "Y:" : "N:";
18            result += c2.country.name() == c3.country.name() ?       "Y:" :
      "N:";
19            result += c3.name == c4.name ?       "Y:" : "N:";
20            System.out.println(result);
21        }
22    }
```

     A. Y:Y:Y:Y:が出力される
     B. Y:N:N:Y: が出力される
     C. Y:N:Y:N:が出力される
     D. Y:Y:Y:N:が出力される
     E. Y:Y:N:N:が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q39"></a>
## 問題39

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）
    なお実行の際はコマンドライン引数を渡さないものとします。

```
 1    public class Main {
 2        public static void main(String... args) {
 3            try {
 4                args[0].charAt(0);
 5                System.out.print("A");
 6            } catch (Exception e) {
 7                System.out.print("B");

 8           } catch (NullPointerException
 9                  | IndexOutOfBoundsException e) {
10               System.out.print("C");
11           } finally {
12               System.out.print("E");
13           }
14       }
15   }
```

     A. ABE が出力される
     B. BEが出力される
     C. ACE が出力される
     D. CE が出力される
     E. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q40"></a>
## 問題40

    次のプログラムを正しく説明しているものはどれですか。
                             （1 つ選択）

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           new C();                                  // (A)
 4       }
 5   }
 6   class A {
 7       A() { System.out.print("A"); }
 8       A(int i) { System.out.print("A" + i); }
 9   }
10   class B extends A {
11       public B() {
12           super(1);
13           System.out.print("B");
14       }

15    }
16    class C extends B {
17        public C() {
18            this(2);
19            System.out.print("C");
20        }
21        public C(int i) { System.out.print("C" + i); }
22    }
```

      A. A（3 行目）の記述が適切でないため、コンパイルエラーが発生する
      B. A クラスでは別コンストラクタを呼び出す記述がないため、コンパイルエ
          ラーが発生する
      C. A クラスのコンストラクタを他のクラスから呼び出すためには、アクセス
          修飾子をpublic にする必要がある
      D. 正常にコンパイル、実行でき、C2CBA1Aが出力される
      E. 正常にコンパイル、実行でき、A1BC2Cが出力される
      F. 正常にコンパイル、実行でき、C2C が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

