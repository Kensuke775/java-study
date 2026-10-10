# 模擬試験1 リメイク問題（21〜40）

元の模擬試験1（問題1〜60）と同じ出題テーマ・同じ強さのひっかけのまま、コード・値・選択肢をすべて作り直した問題集。書式・ルールは `JavaSilver/sample/mock-remake-template.md` に準拠。

---

## 問題21

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String... args) {
 3:         Vehicle[] fleet = { new Vehicle(), new Car() };
 4:         for (Vehicle v : fleet) {
 5:             v.identify();
 6:             v.describe();
 7:             System.out.print(v.capacity + ": ");
 8:         }
 9:     }
10: }
11: class Vehicle {
12:     int capacity = 4;
13:     String label = " vehicle ";
14:     static void identify() { System.out.print("V"); }
15:     void describe() { System.out.print(label); }
16: }
17: class Car extends Vehicle {
18:     int capacity = 2;
19:     String label = " car ";
20:     static void identify() { System.out.print("C"); }
21:     void describe() { System.out.print(label); }
22: }
```

- A. V vehicle 4: C car 2: が出力される
- B. V vehicle 4: V car 4: が出力される
- C. V vehicle 4: C car 4: が出力される
- D. V vehicle 4: V car 2: が出力される
- E. V vehicle 4: V vehicle 4: が出力される
- F. ClassCastExceptionがスローされる

---

## 問題22

次のプログラム（抜粋）の9行目までの処理が完了したタイミングで、ガベージコレクタの対象となるオブジェクトはいくつありますか。（1つ選択）

```
3: Token t1 = new Token();
4: Token t2 = new Token();
5: Token t3 = new Token();
6: Token t4 = t1;
7: t1 = null;
8: t2 = new Token();
9: t4 = t3;
```

- A. 0
- B. 1
- C. 3
- D. 2
- E. 4

---

## 問題23

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
1: public class Main {
2:     public static void main(String[] args) {
3:         int n = 4;
4:         do {
5:             n++;
6:             if(n % 2 == 0) continue;
7:             System.out.print(++n);
8:         } while(n++ < 12);
9:     }
10: }
```

- A. 4が出力される
- B. 5が出力される
- C. 7が出力される
- D. 8が出力される
- E. 何も出力されずにプログラムが終了する
- F. 6が出力される

---

## 問題24

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
1: import java.util.*;
2: public class Main {
3:     public static void main(String[] args) {
4:         List<String> items = List.of("P","Q","R","S","T","U","V","W");
5:         for (int idx = 0; idx < items.size(); idx++) {
6:             System.out.print(items.get(idx));
7:             if (idx > 2) {
8:                 if (idx % 2 == 1)  idx++;
9:             }
10:        }
11:    }
12: }
```

- A. PQRSTVWが出力される
- B. PQRSTUVWが出力される
- C. PQRSUVWが出力される
- D. PQRSTUWが出力される
- E. PQRSTUVが出力される
- F. PQRSWが出力される
- G. PQRSUWが出力される

---

## 問題25

次のプログラムがあります。

```
1: public class Main {
2:     public static void main(String... args) {
3:         System.out.println( [   (1)   ] );
4:     }
5: }
6: class Config {
7:     static double rate;
8:     private int limit;
9:     static { rate = 250.0; }
10:    private static double getRate() { return rate; }
11:    int getLimit() { return limit; }
12:    public String toString() { return "Config:" + rate + "," + limit; }
13: }
```

250.0:0と出力するために（1）に記述できるものはどれですか。（2つ選択）

- A. Config.rate + ":" + new Config().getLimit()
- B. Config.rate + ":" + Config.limit
- C. Config.rate + ":" + new Config().limit
- D. new Config().rate + ":" + new Config().getLimit()
- E. new Config()
- F. new Config().getRate() + ":" + new Config().getLimit()

---

## 問題26

次のプログラムを正しく説明しているものはどれですか。（3つ選択）

```
 1: class DataException extends Exception {
 2:     public DataException(String message, Throwable cause) {
 3:         super(message, cause);
 4:     }
 5: }
 6: public class Main {
 7:     public static void main(String[] args) {
 8:         String[] values = {null, "9", "Max"};
 9:         for (String v : values) {
10:            try {
11:                if (check(v)) System.out.println(v);          // (A)
12:            } catch (Exception e) {                            // (B)
13:                System.out.println(e.getCause());
14:            }
15:        }
16:    }
17:    public static boolean check(String v) throws Exception {
18:        try {
19:            char c = v.charAt(0);
20:            int n = Integer.parseInt(v);
21:        } catch (NullPointerException | NumberFormatException e) {
22:            throw new DataException(e.getMessage(), e);         // (C)
23:        }
24:        return true;
25:    }
26: }
```

- A. check()は3回呼ばれるが、11行目からの出力は1度だけ行われる
- B. 12行目のcatchブロックに制御が移るとプログラムが終了するため、13行目の出力は1度だけ行われる
- C. プログラムを実行すると、java.lang.NullPointerExceptionが出力される
- D. 22行目は例外オブジェクトの生成方法が適切でないため、コンパイルエラーが発生する
- E. プログラムを実行すると、java.lang.Exceptionが出力される
- F. プログラムを実行すると、DataExceptionが出力される
- G. プログラムを実行すると、java.lang.NumberFormatExceptionが出力される

---

## 問題27

次のプログラム（抜粋）をコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
3: String x1 = null;
4: String x2 = "";
5: String text = """
6:         """;
7: System.out.print(text != x1);
8: System.out.print(text == x2);
9: System.out.print(!(x1 == x2));
```

- A. falsefalsefalseが出力される
- B. truetruetrueが出力される
- C. truefalsetrueが出力される
- D. falsetruetrueが出力される
- E. falsetruefalseが出力される

---

## 問題28

次のプログラムはMain.javaというファイルに記述されています。

```
1: public class Main {
2:     public static void main(String[] args) {
3:         System.out.println(args[1] + " " + args[2]);
4:     }
5: }
```

以下の方法で実行するとどのような結果になりますか。（1つ選択）

```
>java Main.java "Go Go" Gold 21
```

- A. Go Goが出力される
- B. Gold21が出力される
- C. Go Go Goldが出力される
- D. Gold 21が出力される
- E. ファイルの拡張子を指定しているため実行に失敗する
- F. コマンドライン引数の指定が正しくないため実行に失敗する

---

## 問題29

次のプログラムでコンパイルエラーが発生する記述はどれですか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String... args) {
 3:         try {
 4:             String token = args[0].trim();
 5:             int size = token.length();
 6:         } catch (NullPointerException              // (A)
 7:                 | NumberFormatException              // (B)
 8:                 | ArrayIndexOutOfBoundsException e) {
 9:             e = new NullPointerException("Bad input"); // (C)
10:        } catch (Exception ex) {                       // (D)
11:            ex = new Exception("Unknown");              // (E)
12:        }
13:    }
14: }
```

- A. A
- B. B
- C. C
- D. D
- E. E

---

## 問題30

次のプログラム（抜粋）があります。

```
3: double[][] table = {{0.5, 1.5, 2.5},{7, 8, 9}};
4: for( [   (1)   ] ) {
5:     for( [   (2)   ] ) {
6:         System.out.print(v + " ");
7:     }
8: }
```

0.5 1.5 2.5 7.0 8.0 9.0 と出力するために（1）、（2）に記述できる組み合わせはどれですか。（2つ選択）

- A. (1) double v : table
    (2) double row : v
- B. (1) double[] row : table
    (2) double v : row
- C. (1) var table : double[]
    (2) var v : table
- D. (1) int i = 0; i < table.length; i++
    (2) int j = 0; j < table[i].length ; j++
- E. (1) var r : table
    (2) var v : r
- F. (1) int i = 0; i < table.size(); i++
    (2) int j = 0; j < table[i] ; j++

---

## 問題31

次のプログラムのコンパイルが完了しています。

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         double d = Double.parseDouble(args[0]);
 4:         int i = Integer.parseInt(args[1]);
 5:         new Main().pick(d, i);
 6:     }
 7:     public void pick(double x, double y) {
 8:         System.out.println("A");
 9:     }
10:     public void pick(Double x, float y) {
11:         System.out.println("B");
12:     }
13:     public void pick(int... x) {
14:         System.out.println("C");
15:     }
16:     public void pick(Double... d) {
17:         System.out.println("D");
18:     }
19:     public void pick(long x, int y) {
20:         System.out.println("E");
21:     }
22: }
```

以下の方法で実行するとどのような結果になりますか。（1つ選択）

```
>java Main 1 1
```

- A. Aが出力される
- B. Bが出力される
- C. Cが出力される
- D. Dが出力される
- E. Eが出力される

---

## 問題32

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Gadget {
 2:     private double cost;
 3:     private Gadget() {
 4:         this(200.0);                      // (A)
 5:         System.out.print(" 1:" + cost);
 6:     }
 7:     Gadget(double cost) {
 8:         cost = cost;
 9:         System.out.print(" 2:" + cost);
10:     }
11:     public void show() {
12:         System.out.println(" 3:" + this.cost);
13:     }
14:     public static void main(String[] args) {
15:         new Gadget().show();              // (B)
16:     }
17: }
```

- A. AでコンパイルエラーA発生する
- B. Bでコンパイルエラーが発生する
- C. 1:0.0 2:0.0 3:0.0が出力される
- D. 1:0.0 2:200.0 3:0.0が出力される
- E. 2:0.0 1:0.0 3:0.0が出力される
- F. 2:0.0 1:0.0 3:200.0が出力される
- G. 2:200.0 1:0.0 3:0.0が出力される

---

## 問題33

次のプログラム（抜粋）の説明として正しくないものはどれですか。（2つ選択）

```
2: public void m1(String s1, String... s2) {}
3: public void m4(int... i, int... j) {}
4: public void m5(String... s) {}
5: public void m3(var x, var... y) {}
6: public void m2(String... s, int i) {}
7: public void m6(double[] d1, double... d2) {}
```

- A. m1のように同じデータ型のみの引数リストの場合も、そのうち1つを可変長にすることができる
- B. m4のように可変長引数を2つ以上指定することはできず、コンパイルエラーが発生する
- C. m5のように引数リストが可変長引数のみの場合、引数を渡さずにメソッド呼び出しを行うことができる
- D. m3のvarは可変長引数にすることができないため、第2引数をvar yと通常の変数にすることでコンパイルが成功する
- E. m2のように複数の引数がある場合、可変長引数は引数リストの最後に記述する必要がある
- F. m6のように同じデータ型で配列と可変長引数の両方を指定することはできず、コンパイルエラーが発生する

---

## 問題34

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Member {
 2:     public String nickname;
 3:     { nickname = "Guest"; }
 4:     public Member() {}
 5:     public Member(String nickname) { this.nickname = nickname; }
 6: }
 7: class Main {
 8:     public static void main(String[] args) {
 9:         Member m1 = new Member("Neo");
10:         Member m2 = m1;
11:         m2.nickname = "Trinity";
12:         System.out.print(m1.nickname + ":" + m2.nickname + ":");
13:         Member m3 = new Member();
14:         System.out.print(m3.nickname);
15:     }
16: }
```

- A. Neo:Trinity:Guestが出力される
- B. Trinity:Trinity:が出力される
- C. Trinity:Trinity:Guestが出力される
- D. Neo:Neo:Guestが出力される
- E. Guest:Guest:Guestが出力される
- F. Neo:Neo:が出力される
- G. コンパイルエラーが発生する

---

## 問題35

次の記述のうち例外処理が必須のものはどれですか。（2つ選択）

- A. java.io.IOException
- B. java.lang.StackOverflowError
- C. java.lang.ArithmeticException
- D. java.lang.ArrayIndexOutOfBoundsException
- E. java.io.FileNotFoundException
- F. java.lang.ClassCastException
- G. java.lang.RuntimeException

---

## 問題36

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         int level = 0x0013;
 4:         if(level <= 0)
 5:             System.out.print("level: " + level + 5 + 20);
 6:         else if(level > 0 && level < 10)
 7:             System.out.print("level: " + level * 3 + 20);
 8:         else if(level >= 10 & level <20)
 9:             System.out.println("level: " + level - level);
10:        else
11:            System.out.println("level: " + level + level);
12:    }
13: }
```

- A. level: 2419が出力される
- B. level: 5720が出力される
- C. level: 0が出力される
- D. level: 19が出力される
- E. level: 0x0013が出力される
- F. level: 38が出力される
- G. コンパイルエラーが発生する

---

## 問題37

次のプログラムがあります。

```
 1: public class Main {
 2:     var a = "Main";                           // (B)
 3:     void test(int a) {
 4:         var arr = new int[]{1, 2, 3};          // (A)
 5:         final var x3 = 3.14f;                  // (C)
 6:         var list = new ArrayList<>();          // (D)
 7:         var x1 = 1, x2 = 2;                    // (E)
 8:         for (var i : arr) System.out.print(i); // (F)
 9:         list.add(' ');
10:        list.add("LIST");                       // (G)
11:    }
12:    var b = null;                               // (H)
13: }
```

次の記述のうちコンパイルが成功するものはどれですか。（3つ選択）

- A. A
- B. B
- C. C
- D. D
- E. E
- F. F
- G. G
- H. H

---

## 問題38

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: record Region(String code) {}
 2: public class Branch {
 3:     String name;
 4:     Region region;
 5:     Branch(String name, Region region) {
 6:         this.name = name; this.region = region;
 7:     }
 8: }
 9: class Main {
10:    public static void main(String[] args) {
11:        Branch b1 = new Branch("Tokyo", new Region("JP"));
12:        Branch b2 = b1;
13:        Branch b3 = new Branch("Osaka", new Region("JP"));
14:        Branch b4 = new Branch("Berlin", new Region("DE"));
15:        String result = "";
16:        result += b1 == b2 ?  "Y:" : "N:";
17:        result += !(b2.region == b3.region) ?  "Y:" : "N:";
18:        result += b2.region.code() == b3.region.code() ?  "Y:" : "N:";
19:        result += b3.name == b4.name ?  "Y:" : "N:";
20:        System.out.println(result);
21:    }
22: }
```

- A. Y:Y:Y:Yが出力される
- B. Y:N:N:Yが出力される
- C. Y:N:Y:Nが出力される
- D. Y:Y:Y:Nが出力される
- E. Y:N:N:Nが出力される

---

## 問題39

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）
なお実行の際はコマンドライン引数を渡さないものとします。

```
 1: public class Main {
 2:     public static void main(String... args) {
 3:         try {
 4:             args[0].length();
 5:             System.out.print("A");
 6:         } catch (Exception e) {
 7:             System.out.print("B");
 8:         } catch (NullPointerException
 9:                 | IndexOutOfBoundsException e) {
10:            System.out.print("C");
11:        } finally {
12:            System.out.print("E");
13:        }
14:    }
15: }
```

- A. ABEが出力される
- B. BEが出力される
- C. ACEが出力される
- D. CEが出力される
- E. コンパイルエラーが発生する

---

## 問題40

次のプログラムを正しく説明しているものはどれですか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         new Z();                        // (A)
 4:     }
 5: }
 6: class X {
 7:     X() { System.out.print("X"); }
 8:     X(int i) { System.out.print("X" + i); }
 9: }
10: class Y extends X {
11:     public Y() {
12:         super(5);
13:         System.out.print("Y");
14:     }
15: }
16: class Z extends Y {
17:     public Z() {
18:         this(9);
19:         System.out.print("Z");
20:     }
21:     public Z(int i) { System.out.print("Z" + i); }
22: }
```

- A. この記述（3行目）が適切でないため、コンパイルエラーが発生する
- B. 正常にコンパイル、実行でき、X5YZ9Zが出力される
- C. Xクラスでは別のコンストラクタを呼び出す記述がないため、コンパイルエラーが発生する
- D. Xクラスのコンストラクタを他のクラスから呼び出すためには、アクセス修飾子をpublicにする必要がある
- E. 正常にコンパイル、実行でき、Z9ZYX5が出力される
- F. 正常にコンパイル、実行でき、Z9Zが出力される

---
