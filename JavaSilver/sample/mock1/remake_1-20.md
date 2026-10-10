# 模擬試験1 リメイク問題（1〜20）

元の模擬試験1（問題1〜60）と同じ出題テーマ・同じ強さのひっかけのまま、コード・値・選択肢をすべて作り直した問題集。書式・ルールは `JavaSilver/sample/mock-remake-template.md` に準拠。

---

## 問題1

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     public static void main(String[] args) {
 3:         String a1 = "Gold";
 4:         String a2 = new String("Gold");
 5:         String a3 = "Gold";
 6:         String a4 = new String("Gold").intern();
 7:         String a5 = "gold";
 8:         String a6 = """
 9:                 gold
10:                 """;
11:         System.out.println((a1 == a2) + ":" + (a1 == a3)
12:                   + ":" + (a3 == a4) + ":" + (a3 == a5)
13:                   + ":" + (a5 == a6) +":" + (a5.equals(a6)));
14:     }
15: }
```

- A. true:true:true:false:false:falseが出力される
- B. true:true:true:false:false:trueが出力される
- C. false:true:false:false:false:trueが出力される
- D. false:true:true:false:false:falseが出力される
- E. false:true:true:false:true:trueが出力される
- F. false:false:true:false:false:trueが出力される

---

## 問題2

次のプログラムがあります。

```
1: public class Test {
2:     public static void main(String[] args) {
3:         System.out.println(count(args));
4:     }
5:     // insert code here
6: }
```

5行目に記述するメソッド宣言として正しいものはどれですか。（1つ選択）

- A. static int count(String... words) { return words.length;}
- B. int count(String... words) { return words.length;}
- C. public void count(String... words) {}
- D. private static void count(String... words) {}
- E. static String count() { return "ok";}
- F. protected String count() { return "ok";}

---

## 問題3

次の記述のうちコンパイルエラーが発生するものはどれですか。（3つ選択）

- A. List<Car> cars = new ArrayList<>();
- B. ArrayList<int> values = new ArrayList<>();
- C. ArrayList<Double> nums = new ArrayList<>();
- D. List items = new ArrayList();
- E. List<String> names = new List<String>();
- F. List<String> labels = List.of("x", "y");
- G. ArrayList<String> words = new ArrayList<String>();
- H. ArrayList<String> letters = Arrays.asList(1, 2, 3);

---

## 問題4

次のプログラムがあります。

● remake4¥Main.java
```
1: package com.shop;
2: import com.stock.Inventory;
3: public class Main {
4:     public static void main(String[] args) {
5:         Inventory.show();
6:     }
7: }
```

● remake4¥Inventory.java
```
1: package com.stock;
2: public class Inventory {
3:     public static void show() {
4:         System.out.println("Inventory");
5:     }
6: }
```

コンパイル、実行を行うとInventoryが出力されるものはどれですか。（2つ選択）
なおコマンドはremake4ディレクトリで実行し、OSにはCLASSPATH環境変数の指定がないものとします。

- A. >javac -d . Main.java Inventory.java
     >java -classpath . com.shop.Main
- B. >javac *.java
     >java com.shop.Main
- C. >javac classes Main.java Inventory.java
     >java -p classes Main
- D. >javac -d *.java
     >java -cp com.shop.Main
- E. >javac -d classes *.java
     >java -cp classes com.shop.Main
- F. >javac -d classes *.java
     >java -cp classes Main

---

## 問題5

次のプログラムがあります。

```
1: class Box {
2:     public static void main(String[] args) {
3:         run(new Box(), args);
4:     }
5:     static void run(Box b, String... s) {
6:         System.out.println(b + ", " + s);
7:     }
8: }
```

以下の方法で実行するとどのような結果になりますか。（1つ選択）

```
>java Box Alpha Beta 42
```

- A. Box, [Alpha, Beta, 42]が出力される
- B. Box@5e91993f, [Alpha, Beta, 42]が出力される
- C. [LBox;@5e91993f, java.lang.String@2c13da15が出力される
- D. Box, {Alpha Beta 42}が出力される
- E. falseが出力される
- F. Box@5e91993f, [Ljava.lang.String;@2c13da15が出力される
- G. この中にはない

---

## 問題6

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: class AlphaException extends Exception {}
 2: class ChildAlphaException extends AlphaException {}
 3: class BetaException extends RuntimeException {}
 4: public class Main {
 5:     public static void main(String[] args) {
 6:         try {
 7:             run(7 % 3);
 8:         } catch (ChildAlphaException | BetaException e) {  // (A)
 9:             System.out.println("Child | Beta");
10:         } catch (AlphaException e) {                        // (B)
11:             System.out.println("Alpha");
12:         } catch (Exception e) {
13:             System.out.println("Ex");
14:         }
15:     }
16:     public static void run(int value) throws Exception {
17:         switch (value) {
18:             case 1 -> throw new AlphaException();
19:             case 2 -> throw new ChildAlphaException();
20:             case 3 -> throw new BetaException();
21:             default -> throw new RuntimeException();       // (C)
22:         }
23:     }
24: }
```

- A. Aでコンパイルエラーが発生する
- B. Bでコンパイルエラーが発生する
- C. 正常にコンパイル、実行でき、Alphaが出力される
- D. Cでコンパイルエラーが発生する
- E. 正常にコンパイル、実行でき、Child | Betaが出力される
- F. 正常にコンパイル、実行でき、Exが出力される

---

## 問題7

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: import java.util.*;
 2: public class Main {
 3:     static int counter = 10;
 4:     public static void main(String[] args) {
 5:         int[][] grid = new int[2][];
 6:         grid[0] = new int[2];
 7:         grid[1] = new int[1];
 8:         grid[0][0] += ++counter;
 9:         grid[0][1] = grid[1].length;
10:         grid[1][0] = counter++;
11:         System.out.println(Arrays.toString(grid[0])
12:                 + ":" + Arrays.toString(grid[1]));
13:     }
14: }
```

- A. [11, 1]:[10]が出力される
- B. [10, 1]:[11]が出力される
- C. [11, 0]:[12]が出力される
- D. [12, 1]:[11]が出力される
- E. [11, 1]:[11]が出力される
- F. [11, 2]:[10]が出力される
- G. [10, 0]:[12]が出力される

---

## 問題8

次のプログラムはLaunch.javaというファイルに記述されています。このプログラムを正しく説明しているものはどれですか。（1つ選択）

```
1: public class B {
2:     public static void main(String... args) {
3:         System.out.println(0b0110 | 9);
4:     }
5: }
```

- A. >javac Launch.java でコンパイルが成功し、>java B を実行すると6が出力される
- B. 正しい説明はない
- C. >javac Launch.java でコンパイルが成功し、>java B を実行すると9が出力される
- D. >java Launch.java でプログラムを実行するためには、ソースファイル名をB.javaにする必要がある
- E. >javac Launch.java でコンパイルが成功するためには、クラス名をMainにする必要がある
- F. >java Launch.java でプログラムの実行ができ、falseが出力される
- G. >java Launch.java でプログラムの実行ができるが、何も出力されない

---

## 問題9

次のプログラムがあります。

```
1: sealed class Shape {}
2: final class Square extends Shape {}
3: // insert code here
```

3行目に記述できるクラス宣言として正しいものはどれですか。（4つ選択）

- A. public class Circle {}
- B. private class Circle {}
- C. static class Circle extends Shape {}
- D. final class Circle {}
- E. abstract final class Circle {}
- F. sealed final class Circle {}
- G. abstract class Circle {}
- H. non-sealed class Circle extends Shape {}

---

## 問題10

次のプログラムがあります。

```
 1: public class Ticket {
 2:     private String label;
 3:     void Ticket() {
 4:         label = "Unknown";
 5:     }
 6:     public Ticket(String label) {
 7:         label = label;
 8:     }
 9:     public String toString() {
10:         return " Ticket:" + label;
11:     }
12:     public static void main(String...args) {
13:         System.out.print(new Ticket());
14:         System.out.println(new Ticket("VIP"));
15:     }
16: }
```

このプログラムを正しく説明しているものはどれですか。（1つ選択）

- A. Ticket:null Ticket:VIP が出力される
- B. Ticket:Unknown Ticket:VIP が出力される
- C. コンパイルエラーが発生する
- D. Ticket:VIP が出力される
- E. Ticket@4554617c が出力される
- F. Ticket:Unknown が出力される

---

## 問題11

次の記述のうちコンパイルが成功するものはどれですか。（3つ選択）

- A. boolean[][] flags = new Boolean[2][3];
- B. int[][] m = {{-2, 0, 2}, {'X', 'Y', 'Z'}};
- C. char[][] grid = new char[2][2] {{'a', 'b'}, {'c', 'd'}};
- D. char[][] c2 = new char[1][1];
    c2[0][0] = (char)98;
- E. Double[][] nums = { {1.5, 2.5e1}, {Math.floor(2.7), Math.round(2.7)}};
- F. Object[][] mix = {{}, {"Hi", 42}};

---

## 問題12

次のプログラムがあります。

```
1: public class Main {
2:     public static void main(String[] args) {}
3:     public Main(String... args) {}               // (A)
4:     public void main(String arg) {}               // (B)
5:     public static void main(int[] args) {}        // (C)
6:     public void main() {}                         // (D)
7:     public static void main(String... var) {}     // (E)
8:     static void main(String[] args) {}            // (F)
9: }
```

このプログラムを正しく説明しているものはどれですか。（1つ選択）

- A. Aは戻り値を記述していないためコンパイルエラーが発生する
- B. Bは引数がString型の配列でないためコンパイルエラーが発生する
- C. このプログラムをコンパイル、実行するとCのメソッドが呼ばれる
- D. Dは引数リストの記述が適切でないためコンパイルエラーが発生する
- E. Eは2行目のメソッドと宣言が重複するためコンパイルエラーが発生する
- F. このプログラムをコンパイル、実行するとFのメソッドが呼ばれる

---

## 問題13

次の記述のうちコンパイルエラーが発生するものはどれですか。（2つ選択）

- A. record Coupon(double discount) extends Record {}
- B. public record Record() {}
- C. final record Coupon(int... codes) {}
- D. Record holder(String name) {}
- E. public record Record(Object record) {}
- F. record Coupon(double discount) {}

---

## 問題14

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     protected void run(int n) {
 3:         final var ready = true;
 4:         final int total;
 5:         if (!ready) total = 50;
 6:         System.out.println(total);
 7:     }
 8:     public static void main(String[] args) {
 9:         new Main().run(50);
10:     }
11: }
```

- A. 2行目でコンパイルエラーが発生する
- B. 3行目でコンパイルエラーが発生する
- C. 5行目でコンパイルエラーが発生する
- D. 何も出力されない
- E. 50が出力される
- F. 6行目でコンパイルエラーが発生する

---

## 問題15

次のプログラム（抜粋）があります。

```
3: public class Main {
4:     public static void main(String[] args) {
5:         List<String> list = List.of("Gold", "3", "9", "21");
6:         for (var i = 0; i <= list.size(); i++) {
7:             try {
8:                 Integer.parseInt(list.get(i));
9:             } catch ( [   (1)   ] ) {
10:                System.out.print(e.getMessage());
11:            } finally {
12:                System.out.println(" round " + i + " done.");
13:            }
14:        }
15:    }
16: }
```

例外がスローされることなくプログラムを終了するために（1）に記述するものはどれですか。（2つ選択）

- A. NumberFormatException | RuntimeException e
- B. NumberFormatException e | StringIndexOutOfBoundsException e
- C. NumberFormatException | IndexOutOfBoundsException e
- D. NumberFormatException | StringIndexOutOfBoundsException e
- E. IndexOutOfBoundsException e
- F. NumberFormatException e
- G. Exception e

---

## 問題16

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

```
 1: public class Main {
 2:     void run() {
 3:         var p = "Java Gold 21";
 4:         var q = new StringBuilder("Java").append("21");
 5:         var r = p.substring(10);
 6:         var t = q.substring(4, 6);
 7:         int result = p.equals(q) ? 1 : r.equals(t) ? 2 : 0;
 8:         System.out.println(result);
 9:     }
10:     public static void main(String[] args) {
11:         this.run();
12:     }
13: }
```

- A. 0が出力される
- B. 1が出力される
- C. 2が出力される
- D. 5行目のsubstring()の使用方法が適切でないためコンパイルエラーが発生する
- E. 6行目のsubstring()の使用方法が適切でないためコンパイルエラーが発生する
- F. run()の呼び出し方法が適切でないためコンパイルエラーが発生する
- G. ローカル変数resultが初期化されない可能性があるためコンパイルエラーが発生する

---

## 問題17

次のプログラム（抜粋）があります。

```
3: char[] cons = {'b', 'c', 'd', 'f', 'g'};
4: for (char c : cons) System.out.print(c);
```

4行目の処理と同じ結果になるものはどれですか。（2つ選択）

- A. int i;
    for (i = 0 ;i < cons.length;) {
        System.out.print(cons[i]); i++;
    }
- B. for (int i = 0; i <= cons.length ; i++) {
        System.out.print(cons[i]);
    }
- C. for (int i = 1; i < cons.length ; i++) {
        System.out.print(cons[i]);
    }
- D. for (var k = 0; k < cons.length; k++)
        System.out.print(cons[k]);
- E. for (int i = 0 ;;i++) {
        System.out.print(cons[i]); i++;
    }

---

## 問題18

次のプログラムがあります。

```
1: public class Device {
2:     private static final int code = 42;
3:     String model;
4:     { model = "Java Gold Device"; }
5: }
6: class Main {
7:     public static void main(String... args) {
8:         Device device = new Device();
9:         System.out.println( [   (1)   ] );
10:    }
11: }
```

何らかの出力を行うために（1）に記述できるものはどれですか。（1つ選択）

- A. この中にはない
- B. device.code
- C. Device.code
- D. this.model
- E. this(code)
- F. model()
- G. device.model

---

## 問題19

次のプログラム（抜粋）があります。

```
 3: int n = 'd';
 4: String label = "";
 5: switch (n) {
 6:     case 97:
 7:     case 98:
 8:         label = "a | b | "; break;
 9:     case 99:
10:     case 100:
11:         label = "c | d | "; break;
12:     case 101:
13:         label = "e | ";    break;
14:     default:
15:         label = "others";
16: }
```

4行目以降の処理と同じ結果になるものはどれですか。（2つ選択）

- A. String label = switch (n) {
        case 97, case 98: yield "a | b | ";
        case 99, 100: yield "c | d | ";
        case 101: yield "e | ";
        default: yield "others";
    };
- B. String label = switch (n) {
        case 97, 98 -> "a | b | ";
        case 99, 100 -> "c | d | ";
        case 101 -> "e | ";
        default -> "others";
    };
- C. String label = switch (n) {
        case 97, 98 -> { yield "a | b | "; }
        case 99, 100 -> "c | d | ";
        case 101 -> "e | ";
    };
- D. String label = "";
    switch (n) {
        case 97, 98 -> label = "a | b | ";
        case 99, 100 -> label = "c | d | ";
        case 101 -> label = "e | ";
        default : { label = "others";}
    }
- E. String label = switch (n) {
        case 97, 98: yield "a | b | ";
        case 99, 100: yield "c | d | ";
        case 101: yield "e | ";
        default: yield "others";
    };

---

## 問題20

次のプログラムを正しく説明しているものはどれですか。（1つ選択）

```
1: public class Main {
2:     public static void main(String[] args) {
3:         int i;
4:         for (i = 7; i > -7 ; i -= 3) {
5:             System.out.print(i);
6:         }
7:     }
8: }
```

- A. カウンタ変数iが初期化されていないため、コンパイルエラーが発生する
- B. 条件式の指定が適切でないため、コンパイルエラーが発生する
- C. 正常にコンパイル、実行でき、741-2-5が出力される
- D. カウンタ変数iの更新処理が適切でないため、コンパイルエラーが発生する
- E. 741が出力された後、無限ループになる
- F. 7410が出力される
- G. 741-2-5-8-11が出力される

---
