# mock1 復習用問題集(41〜50)

## 目次

- [問題41](#問題41)
- [問題42](#問題42)
- [問題43](#問題43)
- [問題44](#問題44)
- [問題45](#問題45)
- [問題46](#問題46)
- [問題47](#問題47)
- [問題48](#問題48)
- [問題49](#問題49)
- [問題50](#問題50)

<a id="q41"></a>
## 問題41

    次のプログラムがあります。

    ● ex41¥Super.java

```
 1    package com;
 2    public class Super {
 3        protected int no = 100;
 4        private String name = "Super";
 5        protected void display() { System.out.print(no +":" + name); }
 6    }

● ex41¥Sub.java

 1    package com.sub;
 2    import com.Super;
 3    public class Sub extends Super {
 4        private String name = "Sub";
 5        public void display() {                       // (A)
 6            super.display();                          // (B)
 7            System.out.print(no + ":");               // (C)
 8            System.out.print(super.name + ":");       // (D)
 9            System.out.print(Sub.name + ":");         // (E)
10        }
11        public static void main(String[] args) {
12            new Sub().display();                      // (F)
13        }
14    }
```

    コンパイルエラーが発生する記述はどれですか。
                         （2 つ選択）

      A. A
      B. B
      C. C
      D. D
      E. E
      F. F

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q42"></a>
## 問題42

    次のプログラムがあります。

```
 1    class Book {
 2        private String genre = "N/A";
 3        private String title ="A Book";

 4        Book() {}
 5        Book(String genre, String title) {
 6              this.genre = genre;
 7              this.title = title;
 8        }
 9        public String getGenre() { return genre; }
10        public String getTitle() { return title; }
11    }
12    record Music(String genre,String composer) {}
13    class Main {
14        public static void main(String... args) {
15            /*
16              insert code here
17            */
18        }
19    }
```

    N/A:A Book と Waltz:Francois を出力するために 15-17 行目の範囲に必要な記
    述はどれですか。
           （2 つ選択）

     A. Book book = new Book();
          System.out.println(book.getGenre() + ":" + book.getTitle());
     B. Book book = new Book();
          System.out.println(book.toString());
     C. Book book = new Book("History", "History of Japan");
          System.out.println(book);
     D. Music music = new Music();
          System.out.println(music.getGenre() + ":" + music.getComposer());
     E. Music music = new Music("Waltz", "Francois");
          System.out.println(music);
     F. Music music = new Music("Waltz", "Francois");
          System.out.println(music.genre() + ":" + music.composer());

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q43"></a>
## 問題43

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           Bar bar = new Bar();
 4           Base base = new Foo();
 5           Foo foo = (Foo)base;
 6           print(bar);
 7           print(bar, base, foo);
 8           print();
 9       }
10       static void print(Base... obj) {
11           for (Base b : obj) {
12               System.out.print("Base:" + b.type);
13           }

14       }
15       static void print(Bar obj) {
16           System.out.print("Bar:" + obj.type);
17       }
18   }
19   abstract class Base { String type = "abstract "; }
20   class Foo extends Base { String type = "class "; }
21   class Bar extends Foo { String type = "class "; }
```

     A. Bar:class Base:abstract Base:abstract Base:abstract が出力される
     B. Bar:class Base:abstract Base:abstract Base:abstract Base: が出力される
     C. Bar:class Base:class Base:abstract Base:class Base: が出力される
     D. Bar:class Base:class Base:abstract Base:class が出力される
     E. Bar:class Base:abstract Base:abstract Base:abstract Base:abstract が出
         力される
     F. ClassCastExceptionがスローされる
     G. NullPointerExceptionがスローされる

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q44"></a>
## 問題44

    次のプログラムがあります。

```
1    interface X {
2        CharSequence x();
3    }
4    class Foo implements X {
5        String name = "Foo";
6        // insert code here
7    }
```

    コンパイルを成功させるために 6 行目に必要な記述はどれですか。
                                   （1 つ選択）

     A. CharSequence x() { return null; }
     B. String x() { return "Foo"; }
     C. public String x(int v) { return String.valueOf(v); }
     D. public Object x() { return new Foo(); }
     E. protected StringBuilder x(int v) { return new StringBuilder(name); }
     F. public StringBuilder x() { return new StringBuilder(name); }
     G. この中にはないため、Foo クラスをabstract にする

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q45"></a>
## 問題45

    次のプログラムを正しく説明しているものはどれですか。
                             （3 つ選択）

```
1    interface X {
2        double POINT_RATE = 0.05;
3        default Number calculate (int price) {
4            return (int)(price * POINT_RATE);
5        }
6    }
7    interface Y {                                          // (A)

       8           double TAX_RATE = 0.1;
       9           default Number calculate (int price) {
      10               return (int)(price * TAX_RATE);
      11           }
      12   }
      13   class One implements X,       Y {}                      // (A)
      14   class Two extends One {}
```

            A. A の 2 行について次のとおり変更するとコンパイルが成功する
                interface Y extends X {
                class One implements Y {
            B. インタフェース Y の default メソッドを削除し、次のprivateメソッドを定
                義するとコンパイルが成功する
                private Number calculate(int price) {
                    return X.super.calculate(price);
                }

            C. クラスOneで次のオーバーライドを行うとコンパイルが成功する
                    public Number calculate(int price) {
                        return X.super.calculate(price);
                    }
            D. クラスOneで次のオーバーライドを行うとコンパイルが成功する
                    public Integer calculate(int price) {
                        return price - 100;
                    }
            E. クラス One を abstract とし、クラス Twoで次のオーバーライドを行うとコ
                ンパイルに成功する
                    public Number calculate(int price) {
                        return Y.super.calculate(price);
                    }
            F. クラス Oneを finalとし、クラス Twoから extends Oneを削除するとコン
                パイルに成功する

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q46"></a>
## 問題46

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    public class Main {
 2        public static void main(String[] args) {
 3            int a = 1, b = 1, x = 0, y = 0;
 4            String[] dayOfWeek = {"Sun", "Mon", "Wed", "Fri", "Sat"};
 5            for (String s : dayOfWeek) {
 6                switch(s) {
 7                    case "Mon", "Tue":
 8                          x += a++;
 9                    case "Wed":
10                          ++a;
11                          continue;
12                    case "Thu", "Fri":
13                          y = --b;
14                          break;
15                    case "Sat", "Sun":
16                          x += 2;
17                }
18            }
19            System.out.println("x:" + x + " y:" + y);
20        }
21    }
```

     A. x:3, y:0 が出力される
     B. x:3, y:-1 が出力される
     C. x:5, y:0 が出力される
     D. x:5, y:-1 が出力される
     E. x:0, y:-1 が出力される
     F. x:0, y:0 が出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q47"></a>
## 問題47

    次のプログラムのコンパイルが完了しています。

```
 1   public class Main {
 2       public static void main(String[] args) {
 3           new Main().method(args);
 4       }
 5       void method(String... args) {
 6           for (var i = 0; i < 3; i++) {
 7                 try {
 8                     System.out.print("A");
 9                     String s = args[i];
10                 } catch (RuntimeException ex) {
11                     System.out.print("B");
12                 } finally {
13                     System.out.print("C");

14                 }
15           }
16       }
17   }
```

    以下の方法で実行するとどのような結果になりますか。
                            （1 つ選択）

     >java Main Duke

     A. ADukeCが出力される
     B. AC が出力される
     C. DukeACABCABC が出力される
     D. DukeCBCBCが出力される
     E. ACABCABC が出力される
     F. ACBCBCが出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q48"></a>
## 問題48

    次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                    （1つ選択）

```
 1    public class Main {
 2        public static void main(String... args) {
 3            Base b = new Derived();
 4            One o = (One)b;                               // (A)
 5            System.out.print(o.NAME);
 6            Derived d = (Derived)o;                       // (B)
 7            System.out.print(d.name);
 8            o = (One)new Base();                          // (C)
 9            System.out.print(o.NAME);                     // (D)
10        }
11    }
12    sealed interface One permits Derived {
13        String NAME = "ONE";
14    }
15    sealed class Base permits Derived {
16        protected String name = "Base";
17    }
18    final class Derived extends Base implements One {}
```

     A. A で ClassCastExceptionがスローされる
     B. Bで ClassCastExceptionがスローされる
     C. C で ClassCastExceptionがスローされる
     D. Dでコンパイルエラーが発生する
     E. 正常にコンパイル、実行でき、ONEONEONEが出力される
     F. 正常にコンパイル、実行でき、ONEBaseONEが出力される

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q49"></a>
## 問題49

       次のプログラム（抜粋）があります。

```
 2   sealed interface Product permits Music, Food {}
 3   record Music(String genre) implements Product {}
 4   record Food(String name) implements Product {}
 5   class Main {
 6         public static void main(String[] args) {
 7             ArrayList<Product> list = new ArrayList<>();
 8             list.add(new Food("Waffle"));
 9             list.add(new Food("Orange"));
10             list.add(new Music("Waltz"));
11             list.add(new Music("Opera"));
12             list.set(0, new Food("Snack"));
13             for (Product p : list) execute(p);
14         }

15         static void execute(Product p) {
16             if(p instanceof Food obj) {
17                 System.out.print(obj.name());
18             }
19         }
20   }
```

       16-17 行目の処理と同じ結果になるものはどれですか。
                                  （1 つ選択）

        A. if(!(p instanceof Food)) {
                Food f = (Food)p;
                System.out.print(f.toString());
            }
        B. if(!(p instanceof Music)) {
                Food f = (Food)p;
                System.out.print(f );
            }

        C. if(p instanceof Food) {
                 Food f = (Food)p;
                 System.out.print(p.name());
             }
        D. if(p instanceof Food) {
                 Food f = (Food)p;
                 System.out.print(f.name());
             }
        E. if(p == (Food)p) {
                 Food f = (Food)p;
                 System.out.print(f.name());
             }
        F. if(p.contains("Snack")
                 || p.contains("Orange")) {
                 System.out.print(((Food)p).name());
             }

**実施記録**

回答：
正解：
迷ったポイント：

---

<a id="q50"></a>
## 問題50

       次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                       （1つ選択）

```
    1    class MyReader implements AutoCloseable {
    2         private int id;
    3         public MyReader(int id) { this.id = id; }
    4         public void close() {
    5             System.out.print("Reader-" + id + ":");
    6         }
    7    }
    8    public class Main {
    9         public static void main(String[] args) {
   10             MyReader f1 = new MyReader(1);
   11             MyReader f2 = new MyReader(2);
   12             try (f1; f2;) {

13                 System.out.print("A:");
14                 try (var s1 = new MyReader(3);) {
15                     System.out.print("B:");
16                 }
17             } finally {
18                 System.out.print("C:");
19             }
20        }
21   }
```

     A. A:B:Reader-3:Reader-2:Reader-1:C:が出力される
     B. A:B:C:Reader-3:Reader-2:Reader-1:が出力される
     C. A:B:Reader-1:Reader-2:Reader-3:C:が出力される
     D. A:B:C:Reader-1:Reader-2:Reader-3:が出力される
     E. A:B:C: が出力される
     F. コンパイルエラーが発生する

**実施記録**

回答：
正解：
迷ったポイント：

---

