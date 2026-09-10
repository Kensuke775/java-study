# mock1 復習用問題集(21〜30)

## 目次

- [問題21](#問題21)
- [問題22](#問題22)
- [問題23](#問題23)
- [問題24](#問題24)
- [問題25](#問題25)
- [問題26](#問題26)
- [問題27](#問題27)
- [問題28](#問題28)
- [問題29](#問題29)
- [問題30](#問題30)

<a id="q21"></a>
## 問題21

       次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                       （1つ選択）

```
   1   public class Main {
   2         public static void main(String... args) {
   3             Top[] array = { new Top(), new Bottom()};

   4             for (Top t: array) {

 5                  t.showInfo();
 6                  t.print();
 7                  System.out.print(t.value + ": ");
 8            }
 9        }
10    }
11    class Top {
12        int value = 10;
13        String name = " top ";
14        static void showInfo() { System.out.print("T"); }
15        void print() { System.out.print(name); }
16    }
17    class Bottom extends Top {
18        int value = 90;
19        String name = " bottom ";
20        static void showInfo() { System.out.print("B"); }
21        void print() { System.out.print(name); }
22    }
```

     A. T top 10: B bottom 90: が出力される
     B. T top 10: T bottom 10: が出力される
     C. T top 10: B bottom 10: が出力される
     D. T top 10: B top 10: が出力される
     E. T top 10: T top 90: が出力される
     F. ClassCastExceptionがスローされる
     G. ArrayIndexOutOfBoundsExceptionがスローされる

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q22"></a>
## 問題22

    次のプログラム（抜粋）の 9 行目までの処理が完了したタイミングで、ガベージコ
    レクタの対象となるオブジェクトはいくつありますか。
                            （1 つ選択）

```
3           Item i1 = new Item();
4           Item i2 = new Item();
5           Item i3 = new Item();
6           Item i4 = i1;
7           i1 = null;
8           i2 = new Item();
9           i4 = i3;
```

     A. 0
     B. 1
     C. 2
     D. 3
     E. 4

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q23"></a>
## 問題23

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           int i = 2;
 4           do {
 5               i++;
 6               if(i % 2 == 0) continue;
 7               System.out.print(++i);
 8           }while(i++ < 10);
 9       }
10   }
```

     A. 3 が出力される
     B. 4 が出力される
     C. 6 が出力される

      D. 468 が出力される
      E. 46810 が出力される
      F. 何も出力されずにプログラムが終了する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q24"></a>
## 問題24

    次のプログラム（抜粋）をコンパイル、実行するとどのような結果になりますか。
    （1 つ選択）

```
 2    public class Main {
 3        public static void main(String[] args) {
 4            List list = List.of("A", "B", "C", "D", "E", "F", "G", "H");
 5            for (int index = 0; index < list.size(); index++) {
 6                System.out.print(list.get(index));
 7                if(index > 2) {
 8                    if( index % 2 == 1)    index++;
 9                }
10            }
11        }
12    }
```

      A. CDFG が出力される
      B. CDFGH が出力される
      C. CDEFGHが出力される
      D. ABCEG が出力される
      E. ABDFHが出力される
      F. ABCDFHが出力される
      G. ABCDEGが出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q25"></a>
## 問題25

    次のプログラムがあります。

```
 1   public class Main {
 2       public static void main(String... args) {
 3           System.out.println( [      (1)      ] );
 4       }
 5   }
 6   class MyClass {
 7       static double a;
 8       private int b;
 9       static { a = 100.0; }
10       private static double getA() { return a; }
11       int getB() { return b; }
12       public String toString() { return "MyClass:" + a + "," + b; }
13   }
```

    100.0:0 と出力するために（1）に記述できるものはどれですか。
                                     （2 つ選択）

     A. MyClass.a + ":" + MyClass.b
     B. MyClass.a + ":" + new MyClass().b
     C. MyClass.a + ":" + new MyClass().getB()
     D. new MyClass()
     E. new MyClass().a + ":" + new MyClass().getB()
     F. new MyClass().getA() + ":" + new MyClass().getB()

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q26"></a>
## 問題26

    次のプログラムを正しく説明しているものはどれですか。
                             （3 つ選択）

```
 1   class InvalidDataException extends Exception {
 2       public InvalidDataException(String message, Throwable cause) {
 3           super(message, cause);
 4       }
 5   }

 6    public class Main {
 7        public static void main(String[] args) {
 8            String[] text = {null, "17", "Duke"};
 9            for (String s : text) {
10                try {
11                    if(validate(s)) System.out.println(s);       // (A)
12                } catch (Exception e) {                          // (B)
13                    System.out.println(e.getCause());
14                }
15            }
16        }
17        public static boolean validate(String s) throws Exception {
18            try {
19                char c = s.charAt(0);
20                int a = Integer.parseInt(s);
21            } catch(NullPointerException | NumberFormatException e) {
22                throw new InvalidDataException(e.getMessage(), e); // (C)
23            }
24            return true;
25        }
26    }
```

     A. A の validate() は 3 回呼ばれるが、11 行目からの出力は 1 度だけ行われる
     B. Bの catchブロックに制御が移るとプログラムが終了するため、13 行目の
          出力は 1 度だけ行われる
     C. C は例外オブジェクトの生成方法が適切でないため、コンパイルエラーが
          発生する
     D. プログラムを実行すると、java.lang.Exceptionが出力される
     E. プログラムを実行すると、java.lang.NullPointerExceptionが出力される
     F. プログラムを実行すると、java.lang.NumberFormatExceptionが出力さ
          れる
     G. プログラムを実行すると、InvalidDataExceptionが出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q27"></a>
## 問題27

    次のプログラム（抜粋）をコンパイル、実行するとどのような結果になりますか。
    （1 つ選択）

```
3           String s1 = null;
4           String s2 = "";
5           String text = """
6                                               """;
7           System.out.print(text != s1);
8           System.out.print(text == s2);
9           System.out.print(!(s1 == s2));
```

     A. falsefalsefalse が出力される
     B. truetruetrueが出力される
     C. truefalsetrueが出力される

     D. falsetruetrueが出力される
     E. falsetruefalse が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q28"></a>
## 問題28

    次のプログラムはMain.javaというファイルに記述されています。

```
1   public class Main {
2       public static void main(String[] args) {
3           System.out.println(args[1] + " " + args[2]);
4       }
5   }
```

    以下の方法で実行するとどのような結果になりますか。
                            （1 つ選択）

     >java Main.java "00 01" 0010 0011

     A. 1 2 が出力される
     B. 2 3 が出力される
     C. 0010 0011 が出力される
     D. "00 01 0010"が出力される
     E. ファイルの拡張子を指定しているため実行に失敗する
     F. コマンドライン引数の指定が正しくないため実行に失敗する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q29"></a>
## 問題29

    次のプログラムでコンパイルエラーが発生する記述はどれですか。
                                 （1 つ選択）

```
 1    public class Main {
 2        public static void main(String... args) {
 3            try {
 4                String text = args[0].trim();
 5                int length = text.length();
 6            } catch (NullPointerException                       // (A)
 7                     | NumberFormatException                    // (B)
 8                     | ArrayIndexOutOfBoundsException e) {      // (C)
 9                e = new NullPointerException("Wrong operation"); // (D)
10            } catch (Exception exception) {
11                exception = new Exception("Unknown error");     // (E)
12            }
13        }
14    }
```

     A. A
     B. B
     C. C
     D. D
     E. E

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q30"></a>
## 問題30

    次のプログラム（抜粋）があります。

```
3            double[][] dArr = {{0.1, 0.2, 0.3},{4, 5, 6}};
4            for( [      (1)     ] ) {
5                   for( [     (2)   ] ) {
6                       System.out.print(d + " ");
7                   }
8            }
```

    0.1 0.2 0.3 4.0 5.0 6.0 と出力するために（1）、
                                       （2）に記述できる組み合わせはど
    れですか。
        （2 つ選択）

     A. (1) double[] arr : dArr
         (2) double d : arr

     B. (1) double d : arr
         (2) double arr : dArr[]
     C. (1) var x : dArr
         (2) var d : x
     D. (1) var dArr : double[]
         (2) var d : dArr[]
     E. (1) int i = 0; i < dArr.length; i++
         (2) int j = 0; j <dArr[i].length ; j++
     F. (1) int i = 0; i < dArr.size(); i++
         (2) int j = 0; j < dArr[i] ; j++

**実施記録**

回答：
正解：
迷ったポイント：

---

