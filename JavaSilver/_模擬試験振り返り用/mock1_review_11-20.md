# mock1 復習用問題集(11〜20)

## 目次

- [問題11](#問題11)
- [問題11 EX](#q11-ex)
- [問題12](#問題12)
- [問題12 EX](#q12-ex)
- [問題13](#問題13)
- [問題14](#問題14)
- [問題15](#問題15)
- [問題16](#問題16)
- [問題17](#問題17)
- [問題18](#問題18)
- [問題19](#問題19)
- [問題20](#問題20)

## 問題11

```
次の記述のうちコンパイルが成功するものはどれですか。
                         （3 つ選択）

 A. int[][] a = {{-1, 0, 1}, {'A', 'B', 'C'}};
 B. boolean b = new Boolean[1][2];
 C. char[][] c = new char[3][3] {{'1', '2', '3'}, {'A', 'B', 'C'}};
 D. D o u b l e [ ] [ ] d = { { 0 . 1 , 0 . 1 e - 2 } , { M a t h . f l o o r ( 3 . 1 4 ) , M a t h .
      round(3.14)}};
 E. char e[][] = new char[1][1];
      e[0][0] = (char)100;
 F. Object[][] f = {{}, {"Java", 17}};
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題11 EX

```
次の記述のうちコンパイルが成功するものはどれですか。
                         （3 つ選択）

 A. int[][] a = {{Math.min(3, 5), 7}, {2, 9}};
 B. float[][] b = {{Math.round(2.5f), 1.0f}};
 C. int[][] c = new int[2][2] {{1, 2}, {3, 4}};
 D. Boolean[][] d = new boolean[2][2];
 E. Integer[][] e = {{Math.max(1, 2), Math.min(3, 4)}};
 F. Long[][] f = {{Math.ceil(1.1), Math.round(2.2)}};
```

**実施記録**

---



## 問題11 EX2

```
次の記述のうち、コンパイルが失敗するものを3つ選んでください。
                         （3 つ選択）

 A. double d = Math.max(1, 2.5); System.out.println(d);
 B. Long a = 5;
 C. Boolean[][] b = new Boolean[][]{{true, false}}; System.out.println(b[0][0]);
 D. int e = Math.round(3.5f) + Math.round(2.5); System.out.println(e);
 E. Integer[] arr = new int[3];
 F. Short s = null; int x = s; System.out.println(x);
```

**実施記録**

回答：正解： 迷ったポイント：

D

---



## 問題12

```
次のプログラムに 2 行目の記述がある場合に残りのコードを正しく説明している
ものはどれですか。
        （1 つ選択）
```

```
1    public class Main {
2         public static void main(String[] args) {}
3         public Main(String... args) {}                            // (A)
4         public void main(String arg) {}                           // (B)
5         static void Main(String[] args) {}                        // (C)
6         public static void main(String... var) {}                 // (D)
7         public void main() {}                                     // (E)
8         public static void main(int[] args) {}                    // (F)
9    }
```

```
 A. A は戻り値を記述していないためコンパイルエラーが発生する
 B. Bは引数がString 型の配列でないためコンパイルエラーが発生する

 C. このプログラムをコンパイル、実行すると C のメソッドが呼ばれる

 D. Dは 2 行目のメソッドと宣言が重複するためコンパイルエラーが発生する
 E. Eは引数リストの記述が適切でないためコンパイルエラーが発生する
 F. このプログラムをコンパイル、実行すると F のメソッドが呼ばれる
```

**実施記録**

回答：D
正解：D
迷ったポイント：なし（一発正解）

---

<a id="q12-ex"></a>
## 問題12 EX

```
次のプログラムがあります。
```

```
1   public class App {
2       public static void main(String[] args) {}
3       public App(int... vals) {}                    // (A)
4       void main(int val) {}                         // (B)
5       static void App(int[] args) {}                // (C)
6       public static void main(int[] nums) {}        // (D)
7       void main() {}                                // (E)
8       public static void main(int... more) {}       // (F)
9   }
```

```
このプログラムをコンパイルするとどうなりますか。
                                    （1つ選択）

 A. Aでコンパイルエラーが発生する
 B. Bでコンパイルエラーが発生する
 C. Cでコンパイルエラーが発生する
 D. Dでコンパイルエラーが発生する
 E. Eでコンパイルエラーが発生する
 F. Fでコンパイルエラーが発生する
 G. コンパイルエラーは発生しない
```

**実施記録**

回答：G
正解：F
迷ったポイント：DとFが「main(int[])」と「main(int...)」で重複しており、コンパイラはあとに書かれたF側の行にエラーを出す。2行目のmain(String[])とは引数の型（int vs String）が違うため無関係で、重複はD・F同士の間で起きている点を見落とした。

---



## 問題13

```
次の記述のうちコンパイルエラーが発生するものはどれですか。
                            （2 つ選択）

 A. public record Record() {}
 B. Record record(String name) {}
 C. public record Record(Object record) {}
 D. record Product(double price) {}
 E. record Product(double price) extends Record {}
 F. final record Product(int... x) {}
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題14

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   public class Main {
 2       protected void main(int a) {           // (A)
 3           final var FLAG = true;
 4           final int VALUE;                   // (B)
 5           if (!FLAG) VALUE = 100;            // (C)
 6           System.out.println(VALUE);         // (D)
 7       }
 8       public static void main(String[] args) {
 9           new Main().main(100);
10       }
11   }
```

```
 A. A でコンパイルエラーが発生する

 B. Bでコンパイルエラーが発生する

 C. C でコンパイルエラーが発生する
 D. Dでコンパイルエラーが発生する
 E. 何も出力されない
 F. 100 が出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題15

```
次のプログラム（抜粋）があります。
```

```
 2    public class Main {
 3        public static void main(String[] args) {
 4            List<String> list = List.of("Java", "8", "11", "17");
 5            for (var i = 0; i <= list.size(); i++) {
 6                try {
 7                    Integer.parseInt(list.get(i));
 8                } catch ( [   (1)     ] ) {
 9                    System.out.print(e.getMessage());
10                } finally {
11                    System.out.println(" loop " + i + " has finished.");
12                }
13            }
14        }
15    }
```

```
例外がスローされることなくプログラムを終了するために（1）に記述するもの
はどれですか。
      （2 つ選択）

 A. NumberFormatException | RuntimeException e
 B. NumberFormatException e | StringIndexOutOfBoundsException e
 C. NumberFormatException | IndexOutOfBoundsException e
 D. NumberFormatException | StringIndexOutOfBoundsException e
 E. IndexOutOfBoundsException e

 F. NumberFormatException e

 G. Exception e
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題16

```
次のプログラムをコンパイル、実行するとどのような結果になりますか。
                                （1つ選択）
```

```
 1   public class Main {
 2       void method() {
 3           var x = "Java SE 17";
 4           var y = new StringBuilder("Java").append("17");
 5           var v = x.substring(8);
 6           var z = y.substring(4,6);
 7           int i = x.equals(y) ? 1 : v.equals(z) ? 2 : 0;
 8           System.out.println(i);
 9       }
10       public static void main(String[] args) {

11           this.method();
12       }
13   }
```

```
 A. 0 が出力される
 B. 1 が出力される
 C. 2 が出力される
 D. 5 行目の substring() の使用方法が適切でないためコンパイルエラーが発
     生する
 E. 6 行目の substring() の使用方法が適切でないためコンパイルエラーが発
     生する
 F. ローカル変数 iが初期化されない可能性があるためコンパイルエラーが発
     生する
 G. method() の呼び出し方法が適切でないためコンパイルエラーが発生する
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題17

```
   次のプログラム（抜粋）があります。
```

```
3             char[] vowels = {'a', 'e', 'i', 'o', 'u'};
4             for (char c : vowels)    System.out.print(c);
```

```
   4 行目の処理と同じ結果になるものはどれですか。
                          （2 つ選択）

    A. for (int i = 0; i <= vowels.length ; i++) {
         System.out.print(vowels[i]);
         }
    B. for (int i = 1; i < vowels.length ; i++) {
             System.out.print(vowels[i]);
         }
    C. int i;
         for (i = 0 ;i < vowels.length;) {
             System.out.print(vowels[i]); i++;
         }
    D. for (int i = 0 ;;i++) {
             System.out.print(vowels[i]); i++;
         }
    E. for (var v = 0; v < vowels.length; v++)
             System.out.print(vowels[v]);
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題18

```
   次のプログラムがあります。
```

```
    1    public class Book {
    2         private static final int id = 17;
    3         String title;
    4         { title = "Java Silver"; }

 5   }
 6   class Main {
 7       public static void main(String... args) {
 8             Book book = new Book();
 9             System.out.println( [      (1)      ] );
10       }
11   }
```

```
何らかの出力を行うために（1）に記述できるものはどれですか。
                             （1 つ選択）

 A. book.id
 B. book.title
 C. Book.id
 D. this.title
 E. this(id)
 F. title()

 G. この中にはない
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題19

```
次のプログラム（抜粋）があります。
```

```
 3             int c = 'c';
 4             String text = "";
 5             switch (c) {
 6                case 97:
 7                case 98:
 8                     text = "a | b | "; break;
 9                case 99:
10                case 100:
11                     text = "c | d | "; break;
12                case 101:
13                     text = "e | ";         break;

   14                   default:
   15                        text = "the others";
   16               }
```

```
   4 行目以降の処理と同じ結果になるものはどれですか。
                            （2 つ選択）

    A. String text = switch (c) {
              case 97, case 98: yield "a | b | ";
              case 99, case 100: yield "c | d | ";
              case 101: yield "e | ";
              default: yield "the others";
         }
    B. String text = switch (c) {
              case 97, 98 -> "a | b | ";
              case 99, 100 -> "c | d | ";
              case 101 -> "e | ";
              default -> "the others";
         };
    C. String text = switch (c) {
              case 97, 98 -> { yield "a | b | "; }
              case 99, 100 -> "c | d | ";
              case 101 -> "e | ";
         };
    D. String text = switch (c) {
              case 97, 98: yield "a | b | ";
              case 99, 100: yield "c | d | ";
              case 101: yield "e | ";
              default: yield "the others";
         };
    E. String text = "";
         switch (c) {
              case 97, 98 -> text = "a | b | ";
              case 99, 100 -> text = "c | d | ";

           case 101 -> text = "e | ";
           default : { text = "the others";}
       }
```

**実施記録**

回答：
正解：
迷ったポイント：

---



## 問題20

```
   次のプログラムを正しく説明しているものはどれですか。
                            （1 つ選択）
```

```
1   public class Main {
2         public static void main(String[] args) {
3             int i;
4             for (i = 5; i > -5 ; i -= 2) {
5                 System.out.print(i);
6             }
7         }
8   }
```

```
    A. カウンタ変数 i が初期化されていないため、コンパイルエラーが発生する
    B. 条件式の指定が適切でないため、コンパイルエラーが発生する
    C. カウンタ変数 i の更新処理が適切でないため、コンパイルエラーが発生する
    D. 531 が出力された後、無限ループになる
    E. 正常にコンパイル、実行でき、531-1-3 が出力される
    F. 正常にコンパイル、実行でき、54321 が出力される
    G. 正常にコンパイル、実行でき、543210-1-2-3-4-5 が出力される
```

**実施記録**

回答：
正解：
迷ったポイント：

---

