# 模擬試験1 リメイク問題（41〜60）

元の模擬試験1（問題1〜60）と同じ出題テーマ・同じ強さのひっかけのまま、コード・値・選択肢をすべて作り直した問題集。書式・ルールは `JavaSilver/sample/mock-remake-template.md` に準拠。

---

## 問題41

次のプログラムがあります。

● remake41¥pkg1¥Base.java
```
1: package pkg1;
2: public class Base {
3:     protected int score = 100;
4:     private String tag = "Base";
5:     protected void show() { System.out.print(score +":" + tag); }
6: }
```

● remake41¥pkg1¥sub¥Child.java
```
 1: package pkg1.sub;
 2: import pkg1.Base;
 3: public class Child extends Base {
 4:     private String tag = "Child";
 5:     public void show() {                    // (A)
 6:         super.show();                        // (C)
 7:         System.out.print(score +":");        // (D)
 8:         System.out.print(super.tag + ":");   // (B)
 9:         System.out.print(Child.tag + ":");   // (E)
10:     }
11:     public static void main(String[] args) {
12:         new Child().show();                  // (F)
13:     }
14: }
```

コンパイルエラーが発生する記述はどれですか。（2つ選択）

- A. A
- B. B
- C. C
- D. D
- E. E
- F. F

---

## 問題42

次のプログラムがあります。

```
 1: class Item {
 2:     private String category = "N/A";
 3:     private String label ="An Item";
 4:     Item() {}
 5:     Item(String category, String label) {
 6:         this.category = category;
 7:         this.label = label;
 8:     }
 9:     public String getCategory() { return category; }
10:     public String getLabel() { return label; }
11: }
12: record Song(String genre,String artist) {}
13: class Main {
14:     public static void main(String... args) {
15:         /*
16:          insert code here
17:         */
18:     }
19: }
```

N/A:An Item と Waltz:Francois を出力するために15-17行目の範囲に必要な記述はどれですか。（2つ選択）

- A. Item item = new Item();
    System.out.println(item.getCategory() + ":" + item.getLabel());
- B. Item item = new Item();
    System.out.println(item.toString());
- C. Item item = new Item("History", "History of Japan");
    System.out.println(item);
- D. Song song = new Song("Waltz", "Francois");
    System.out.println(song);
- E. Song song = new Song();
    System.out.println(song.getGenre() + ":" + song.getArtist());
- F. Song song = new Song("Waltz", "Francois");
    System.out.println(song.genre() + ":" + song.artist());

---

## 問題43

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         Sedan sedan = new Sedan();
 4:         Auto auto = new Mid();
 5:         Mid mid = (Mid)auto;
 6:         show(sedan);
 7:         show(sedan, auto, mid);
 8:         show();
 9:     }
10:     static void show(Auto... obj) {
11:         for (Auto a : obj) {
12:             System.out.print("Auto:" + a.kind);
13:         }
14:     }
15:     static void show(Sedan obj) {
16:         System.out.print("Sedan:" + obj.kind);
17:     }
18: }
19: abstract class Auto { String kind = "abstract "; }
20: class Mid extends Auto { String kind = "mid "; }
21: class Sedan extends Mid { String kind = "compact "; }
```

- A. Sedan:compact Auto:mid Auto:abstract Auto:mid が出力される
- B. ClassCastExceptionがスローされる
- C. Sedan:compact Auto:abstract Auto:abstract Auto:abstract Auto:abstract が出力される
- D. Sedan:compact Auto:mid Auto:abstract Auto:mid Auto: が出力される
- E. NullPointerExceptionがスローされる
- F. Sedan:compact Auto:abstract Auto:abstract Auto:abstract Auto: が出力される
- G. Sedan:compact Auto:abstract Auto:abstract Auto:abstract が出力される

---

## 問題44

次のプログラムがあります。

```
1: interface Y {
2:     CharSequence y();
3: }
4: class Bar implements Y {
5:     String label = "Bar";
6:     // insert code here
7: }
```

コンパイルを成功させるために6行目に必要な記述はどれですか。（1つ選択）

- A. CharSequence y() { return null; }
- B. String y() { return "Bar"; }
- C. public String y(int v) { return String.valueOf(v); }
- D. public Object y() { return new Bar(); }
- E. protected StringBuilder y(int v) { return new StringBuilder(label); }
- F. public StringBuilder y() { return new StringBuilder(label); }
- G. この中にはないため、Barクラスをabstractにする

---

## 問題45

次のプログラムを正しく説明しているものはどれですか。（3つ選択）

```
 1: interface P {
 2:     double BONUS_RATE = 0.05;
 3:     default Number compute (int price) {
 4:         return (int)(price * BONUS_RATE);
 5:     }
 6: }
 7: interface Q {                                     // (A)
 8:     double FEE_RATE = 0.1;
 9:     default Number compute (int price) {
10:         return (int)(price * FEE_RATE);
11:     }
12: }
13: class M1 implements P, Q {}                        // (A)
14: class M2 extends M1 {}
```

- A. Aの2行について次のとおり変更するとコンパイルが成功する
    interface Q extends P {
    class M1 implements Q {
- B. インタフェースQのdefaultメソッドを削除し、次のprivateメソッドを定義するとコンパイルが成功する
    private Number compute(int price) {
        return P.super.compute(price);
    }
- C. クラスM1をabstractとし、クラスM2で次のオーバーライドを行うとコンパイルに成功する
    public Number compute(int price) {
        return Q.super.compute(price);
    }
- D. クラスM1で次のオーバーライドを行うとコンパイルが成功する
    public Integer compute(int price) {
        return price - 50;
    }
- E. クラスM1をfinalとし、クラスM2からextends M1を削除するとコンパイルに成功する
- F. クラスM1で次のオーバーライドを行うとコンパイルが成功する
    public Number compute(int price) {
        return P.super.compute(price);
    }

---

## 問題46

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         int p = 1, q = 1, m = 0, n = 0;
 4:         String[] months = {"Jan", "Mar", "May", "Jul", "Sep"};
 5:         for (String s : months) {
 6:             switch(s) {
 7:                 case "Mar", "Apr":
 8:                     m += p++;
 9:                 case "May":
10:                     ++p;
11:                     continue;
12:                 case "Jun", "Jul":
13:                     n = --q;
14:                     break;
15:                 case "Sep", "Jan":
16:                     m += 2;
17:             }
18:         }
19:         System.out.println("m:" + m + " n:" + n);
20:     }
21: }
```

- A. m:3 n:0が出力される
- B. m:3 n:-1が出力される
- C. m:0 n:-1が出力される
- D. m:5 n:-1が出力される
- E. m:5 n:0が出力される
- F. m:0 n:0が出力される

---

## 問題47

次のプログラムのコンパイルが完了しています。

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         new Main().run(args);
 4:     }
 5:     void run(String... args) {
 6:         for (var i = 0; i < 3; i++) {
 7:             try {
 8:                 System.out.print("A");
 9:                 String s = args[i];
10:            } catch (RuntimeException ex) {
11:                System.out.print("B");
12:            } finally {
13:                System.out.print("C");
14:            }
15:        }
16:    }
17: }
```

以下の方法で実行するとどのような結果になりますか。（1つ選択）

```
>java Main Neo
```

- A. ANeoCが出力される
- B. ACが出力される
- C. NeoACABCABCが出力される
- D. NeoCBCBCが出力される
- E. ACBCBCが出力される
- F. ACABCABCが出力される

---

## 問題48

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
1: public class Main {
2:     public static void main(String... args) {
3:         Shape s = new Circle();
4:         Drawable d = (Drawable)s;        // (A)
5:         System.out.print(d.LABEL);
6:         Circle c = (Circle)d;             // (B)
7:         System.out.print(c.tag);
8:         d = (Drawable)new Shape();        // (C)
9:         System.out.print(d.LABEL);        // (D)
10:    }
11: }
12: sealed interface Drawable permits Circle {
13:     String LABEL = "DRAW";
14: }
15: sealed class Shape permits Circle {
16:     protected String tag = "Shape";
17: }
18: final class Circle extends Shape implements Drawable {}
```

- A. AでClassCastExceptionがスローされる
- B. BでClassCastExceptionがスローされる
- C. CでClassCastExceptionがスローされる
- D. Dでコンパイルエラーが発生する
- E. 正常にコンパイル、実行でき、DRAWDRAWDRAWが出力される
- F. 正常にコンパイル、実行でき、DRAWShapeDRAWが出力される

---

## 問題49

次のプログラム（抜粋）があります。

```
 1: import java.util.*;
 2: sealed interface Order permits Online, Store {}
 3: record Online(String channel) implements Order {}
 4: record Store(String branch) implements Order {}
 5: class Main {
 6:     public static void main(String[] args) {
 7:         ArrayList<Order> list = new ArrayList<>();
 8:         list.add(new Store("East"));
 9:         list.add(new Store("West"));
10:        list.add(new Online("App"));
11:        list.add(new Online("Web"));
12:        list.set(0, new Store("North"));
13:        for (Order o : list) handle(o);
14:    }
15:    static void handle(Order o) {
16:        if(o instanceof Store s) {
17:            System.out.print(s.branch());
18:        }
19:    }
20: }
```

16-17行目の処理と同じ結果になるものはどれですか。（1つ選択）

- A. if(!(o instanceof Online)) {
        Store s = (Store)o;
        System.out.print(s.toString());
    }
- B. if(!(o instanceof Store)) {
        Store s = (Store)o;
        System.out.print(s);
    }
- C. if(o instanceof Store) {
        Store s = (Store)o;
        System.out.print(o.branch());
    }
- D. if(o == (Store)o) {
        Store s = (Store)o;
        System.out.print(s.branch());
    }
- E. if(o.contains("North")
        || o.contains("East")) {
        System.out.print(((Store)o).branch());
    }
- F. if(o instanceof Store) {
        Store s = (Store)o;
        System.out.print(s.branch());
    }

---

## 問題50

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: class Clip implements AutoCloseable {
 2:     private int id;
 3:     public Clip(int id) { this.id = id; }
 4:     public void close() {
 5:         System.out.print("Clip-" + id + ":");
 6:     }
 7: }
 8: public class Main {
 9:     public static void main(String[] args) {
10:        Clip c1 = new Clip(1);
11:        Clip c2 = new Clip(2);
12:        try (c1; c2;) {
13:            System.out.print("A:");
14:            try (var s1 = new Clip(3);) {
15:                System.out.print("B:");
16:            } finally {
17:                System.out.print("C:");
18:            }
19:        }
20:    }
21: }
```

- A. A:B:Clip-3:C:Clip-2:Clip-1:が出力される
- B. A:B:C:Clip-3:Clip-2:Clip-1:が出力される
- C. A:B:Clip-1:Clip-2:C:Clip-3:が出力される
- D. A:B:C:Clip-1:Clip-2:Clip-3:が出力される
- E. A:B:C:が出力される
- F. コンパイルエラーが発生する

---

## 問題51

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: interface Greeter {
 2:     default void greet() {
 3:         System.out.print("Hi... ");
 4:     }
 5: }
 6: class Base2 {
 7:     static void log() {
 8:         System.out.print("BASE ");
 9:     }
10: }
11: class Impl extends Base2 implements Greeter {
12:     public void greet() {
13:         Greeter.super.greet();
14:         System.out.print("Impl#Hi... ");
15:     }
16:     public void log() {
17:         super.log();
18:         System.out.print("IMPL ");
19:     }
20: }
21: public class Main {
22:     public static void main(String[] args) {
23:         Greeter g = new Impl();
24:         Base2 b2 = new Base2();
25:         g.greet();
26:         Impl impl = (Impl)g;
27:         impl.log();
28:         b2.log();
29:     }
30: }
```

- A. Impl#Hi... Impl#Hi... BASE IMPL BASE が出力される
- B. Impl#Hi... Impl#Hi... BASE IMPL が出力される
- C. Hi... Impl#Hi... BASE IMPL BASE が出力される
- D. Hi... Impl#Hi... BASE IMPL が出力される
- E. Hi... が出力された後、ClassCastExceptionがスローされる
- F. Hi... Impl#Hi... が出力された後、ClassCastExceptionがスローされる
- G. コンパイルエラーが発生する

---

## 問題52

次のローカル変数の宣言のうち、コンパイルエラーが発生するものはどれですか。（3つ選択）

- A. static final Double LIMIT = 5_000.0;
- B. String $num = "500";
- C. int val = Integer.parseInt("500");
- D. public var count = "2_000".length();
- E. final var r = Math.random();
- F. char MARK = (char)200.0F;
- G. boolean false = false;

---

## 問題53

次のプログラムを正しく説明しているものはどれですか。（3つ選択）

```
 1: abstract class Shape2 {
 2:     public Shape2() {}                          // (A)
 3:     public abstract double area();               // (B)
 4:     final String label() { return "shape"; }     // (C)
 5: }
 6: final class Circle2 extends Shape2 {
 7:     public double area() { return 0; }            // (D)
 8: }
 9: sealed interface Taggable {                       // (E)
10:     void tag();
11: }
12: non-sealed interface Markable extends Taggable {} // (F)
13: non-sealed record Item2(int id) implements Taggable {  // (G)
14:     public void tag(){}
15: }
```

- A. クラスShape2はインスタンス化ができないため、Shape2のコンストラクタも記述できない
- B. BのmethodX()は、public abstractを記述しなくてもコンパイラにより暗黙的に指定される
- C. Cのように、final クラスでなくてもfinalメソッドを宣言することはできる
- D. Dのようにクラス Circle2をfinalにする場合はarea()のオーバーライドが必須となる
- E. インタフェースもsealedを指定できるが、Eのようなpermitsの省略はできない
- F. インタフェースにシールされたインタフェースを継承する場合、Fのようにfinal以外を指定する必要がある
- G. レコードにシールされたインタフェースを実装する場合、Gのようにsealed以外を指定する必要がある

---

## 問題54

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         StringBuilder b1 = new StringBuilder("spring");
 4:         StringBuilder b2 = new StringBuilder("chatter");
 5:         b2.append("?");
 6:         String word = b1.toString();
 7:         String w1 = "SPRING";
 8:         String w2 = "CHATTER?";
 9:         if(b1.equals(word)) System.out.print("A");
10:        if(word.equalsIgnoreCase(w1)) System.out.print("B");
11:        if(w2.equals(b2.toString())) System.out.print("C");
12:        if(w1.length() == 4 || b2.lastIndexOf("t") == 4)
13:            System.out.println("D");
14:        if(w2.charAt(6) =='?' && b2.charAt(6) == '?')
15:            System.out.print("E");
16:    }
17: }
```

- A. ABCDEが出力される
- B. ABCEが出力される
- C. ABDが出力される
- D. BDが出力される
- E. BEが出力される
- F. ADが出力される

---

## 問題55

次のプログラム（抜粋）があります。

```
2: class MyNetException extends IOException {}
3: class MyFault extends Exception {}
4: class Base3 {
5:     public void run(double d) throws IOException {}
6: }
7: class Sub3 extends Base3 {
8:     @Override
9:     // insert code here
10: }
```

9行目に記述するとコンパイルエラーが発生するものはどれですか。（2つ選択）

- A. public void run(double d) throws Exception {}
- B. public void run(double d) throws RuntimeException {}
- C. public void run(double d) {}
- D. public void run(double d) throws MyFault {}
- E. public void run(double d) throws FileNotFoundException {}
- F. public void run(double d) throws MyNetException {}

---

## 問題56

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String... args) {
 3:         new Widget(); new Widget(); new Widget();
 4:         new Widget().print();
 5:     }
 6: }
 7: class Widget {
 8:     private static int p;
 9:     private int q;
10:    public Widget() { ++p; ++q; }
11:    public void print() {
12:        System.out.print("p:" + p-- + ", q:" + q--);
13:    }
14: }
```

- A. p:1, q:1が出力される
- B. p:3, q:1が出力される
- C. p:3, q:0が出力される
- D. p:1, q:4が出力される
- E. p:4, q:4が出力される
- F. p:4, q:1が出力される

---

## 問題57

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: class Holder { double amount = 40.0; }
 2: class Main {
 3:     public static void main(String[] args) {
 4:         Holder h1 = new Holder();                 // (A)
 5:         Holder h2 = h1;
 6:         float a = 40.0F;
 7:         float b = a;
 8:         h1.amount -= 15;                           // (B)
 9:         a *= 2;                                    // (C)
10:        System.out.println(a + ":" + b + ":"
11:                + h1.amount + ":" + h2.amount);
12:    }
13: }
```

- A. AでコンパイルエラーA発生する
- B. Bでコンパイルエラーが発生する
- C. Cでコンパイルエラーが発生する
- D. 40.0:80.0:25.0:40.0が出力される
- E. 80.0:40.0:40.0:25.0が出力される
- F. 80.0:80.0:25.0:40.0が出力される
- G. 80.0:40.0:-10.0:-10.0が出力される
- H. 80.0:40.0:25.0:25.0が出力される

---

## 問題58

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: class Line implements AutoCloseable {
 2:     private String tag;
 3:     public Line(String tag) {
 4:         this.tag = tag;
 5:     }
 6:     public void close() throws Exception {
 7:         System.out.print("shut:" + tag);
 8:         throw new Exception("Fail! ");
 9:     }
10: }
11: public class Main {
12:     public static void main(String[] args) {
13:         try (var r1 = new Line("Line1: ");
14:              var r2 = new Line("Line2: ");) {
15:             System.out.print("try: ");
16:         } catch (Exception e) {
17:             System.out.print("catch:" + e.getMessage());
18:         } finally {
19:             System.out.print("finally:");
20:         }
21:     }
22: }
```

- A. try: shut:Line2: shut:Line1: catch:Fail! finally:が出力される
- B. try: shut:Line1: shut:Line2: catch:Fail! finally:が出力される
- C. try: catch:Fail! shut:Line1: shut:Line2: finally:が出力される
- D. try: catch:Fail! shut:Line2: shut:Line1: finally:が出力される
- E. try: catch:Fail! finally: shut:Line2: shut:Line1:が出力される
- F. try: finally: catch:Fail! shut:Line2: shut:Line1:が出力される

---

## 問題59

次のプログラムを正しく説明しているものはどれですか。（2つ選択）

● remake59¥pack¥Main.java
```
1: package pack;
2: import pack.one.Alpha;      // (A)
3: import pack.two.*;           // (B)
4: public class Main {
5:     public static void main(String[] args) {
6:         new Alpha(); new Beta();    // (C)
7:     }
8: }
```

● remake59¥pack¥one¥Alpha.java
```
1: package pack.one;
2: public class Alpha {}
```

● remake59¥pack¥two¥Beta.java
```
1: package pack.two;
2: class Beta {}
```

- A. Aの行をimport pack.*; と記述してもMain.javaのコンパイルが成功する
- B. Main.javaのコンパイルにおいてBの行が原因でコンパイルエラーが発生する
- C. Main.javaのコンパイルにおいてCの行が原因でコンパイルエラーが発生する
- D. Alpha.javaとBeta.javaのコンパイルが成功するためには、両方のクラスにimport static pack.Main.main;を宣言する必要がある
- E. Alpha.javaとBeta.javaのコンパイルが成功するためには、クラスパス上でpack.Main.classが見つかる必要がある
- F. Alpha.javaとBeta.javaはそれぞれ単体でコンパイルが成功する
- G. このプログラムはコンパイル、実行ができるが何も出力されない

---

## 問題60

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: record Ticket(int id, String holder, String tier) {
 2:     Ticket {
 3:         tier = tier.toUpperCase();
 4:     }
 5:     public int id() {
 6:         return id + 1000;
 7:     }
 8:     public String getHolder() {
 9:         return holder.trim();
10:    }
11: }
12: class Main {
13:    public static void main(String[] args) {
14:        Ticket t1 = new Ticket(1, " Ada Lovelace ", "gold ");
15:        Ticket t2 = new Ticket(2, " Alan Turing", "silver ");
16:        Ticket t3 = new Ticket(3, " Grace Hopper ", "bronze ");
17:        t1.tier = " Platinum";
18:        System.out.print(t1.id() + t1.holder() + t1.tier());
19:        t2 = t3;
20:        System.out.print(t2.id()+ t2.holder() + t2.tier());
21:    }
22: }
```

- A. 1101Ada LovelaceGOLDが出力される
- B. 1101Ada LovelacePlatinumが出力される
- C. 1101Ada LovelaceGOLD1003Grace HopperBRONZEが出力される
- D. 1003Grace HopperBRONZEが出力される
- E. 1Ada LovelaceGOLD3Grace HopperBronzeが出力される
- F. 1Ada LovelaceGOLDTECHNOLOGY3Grace HopperBRONZEが出力される
- G. コンパイルエラーが発生する

---
