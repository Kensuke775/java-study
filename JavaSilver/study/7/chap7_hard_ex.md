# 第7章 サンプル(ex)発展問題(ex3〜16 各2問、計28問)

`sample/chap7/ex3`〜`ex16`それぞれについて、難問寄りの発展問題を2問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題ex3-1・ex3-2(sample/chap7/ex3)](#qex3)
- [問題ex4-1・ex4-2(sample/chap7/ex4)](#qex4)
- [問題ex5-1・ex5-2(sample/chap7/ex5)](#qex5)
- [問題ex6-1・ex6-2(sample/chap7/ex6)](#qex6)
- [問題ex7-1・ex7-2(sample/chap7/ex7)](#qex7)
- [問題ex8-1・ex8-2(sample/chap7/ex8)](#qex8)
- [問題ex9-1・ex9-2(sample/chap7/ex9)](#qex9)
- [問題ex10-1・ex10-2(sample/chap7/ex10)](#qex10)
- [問題ex11-1・ex11-2(sample/chap7/ex11)](#qex11)
- [問題ex12-1・ex12-2(sample/chap7/ex12)](#qex12)
- [問題ex13-1・ex13-2(sample/chap7/ex13)](#qex13)
- [問題ex14-1・ex14-2(sample/chap7/ex14)](#qex14)
- [問題ex15-1・ex15-2(sample/chap7/ex15)](#qex15)
- [問題ex16-1・ex16-2(sample/chap7/ex16)](#qex16)

<a id="qex3"></a>
## 問題ex3-1(sample/chap7/ex3)

```java
public class Main {
    public static void main(String[] args) {
        String[] values = {"x", "y", "z"};
        for (int i = 0; i <= 3; i++) {
            System.out.print(values[i]);
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `xyz` が出力される
B. `xyz` が出力された後、プログラムが異常終了する
C. `xy` が出力された後、プログラムが異常終了する
D. コンパイルエラーになる
E. 無限ループになる

**解答**

正解：**B**

**補足**

- `values.length`は`3`。ループ条件が`i <= 3`（`<`ではなく`<=`）なので`i = 0,1,2,3`まで回ろうとする。
- `i = 0,1,2`で`"x"`,`"y"`,`"z"`が出力され、`i = 3`で存在しない添字`values[3]`にアクセスした瞬間`ArrayIndexOutOfBoundsException`がスローされる。
- `catch`が無いのでその場でプログラムは異常終了する。
- `javac`/`java`で検証済み：`xyz`の後にスタックトレースが出力される。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex3-2(sample/chap7/ex3)

```java
public class Main {
    public static void main(String[] args) {
        String[] values = {"p", "q"};
        int i = 0;
        try {
            while (true) {
                System.out.print(values[i]);
                i++;
            }
        } finally {
            System.out.print("(" + i + ")");
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `pq(2)` の後、正常終了する
B. `pq(2)` の後、`ArrayIndexOutOfBoundsException`がスローされてプログラムが終了する
C. `catch`が無いため`try`単体では成立せずコンパイルエラーになる
D. 無限ループになる
E. `pq(1)` の後、`ArrayIndexOutOfBoundsException`がスローされてプログラムが終了する

**解答**

正解：**B**

**補足**

- `try`は`catch`が無くても`finally`さえあれば構文として成立する（Cは誤り）。
- `while(true)`は`values[i]`が範囲外になるまで回り続ける。`i=0`で`"p"`、`i=1`で`"q"`を出力後`i++`で`i=2`になり、`values[2]`（有効な添字は`0`,`1`のみ）で`ArrayIndexOutOfBoundsException`。
- 例外がスローされた瞬間の`i`の値は`2`。伝播する前に必ず`finally`が実行されるので`"(2)"`が出力されてから、キャッチする`catch`が無いのでそのままプログラムは異常終了する（Eのように`i=1`時点で終わるわけではない）。
- `javac`/`java`で検証済み：`pq(2)`の後にスタックトレースが出力される。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex4"></a>
## 問題ex4-1(sample/chap7/ex4)

```java
public class Main {
    public static void main(String[] args) {
        String s = null;
        try {
            int i = Integer.parseInt(s);
            System.out.println(s);
        } catch (NullPointerException e) {
            System.out.println("exception");
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `exception` が出力される
B. `null` が出力される
C. `Integer.parseInt(s)`の行で`NullPointerException`がスローされ`catch`で捕まる
D. `catch (NullPointerException e)`が実際にスローされる例外の型と一致しないため、キャッチされずプログラムが異常終了する
E. コンパイルエラーになる

**解答**

正解：**D**

**補足**

- `Integer.parseInt(null)`は、引数が`null`であることを内部で検知して**`NumberFormatException`**をスローする（`s`自体へのメンバアクセスをしているわけではないので`NullPointerException`にはならない。CはBともに誤り）。
- 用意されている`catch (NullPointerException e)`は型が一致しないためこの例外をキャッチできず、そのまま`main`の外まで伝播してプログラムが異常終了する。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.NumberFormatException: Cannot parse null string`。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex4-2(sample/chap7/ex4)

```java
public class Main {
    public static void main(String[] args) {
        String s = "12abc";
        try {
            int i = Integer.parseInt(s.trim());
            System.out.println(i);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("caught:" + e.getClass().getSimpleName());
        }
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `12` が出力される
B. `caught:NumberFormatException` が出力される
C. `caught:IllegalArgumentException` が出力される
D. `caught:NullPointerException` が出力される
E. `IllegalArgumentException`と`NullPointerException`は継承関係にないためmulti-catch自体はOKだが、`NumberFormatException`はどちらにも一致せずキャッチされない

**解答**

正解：**B**

**補足**

- `"12abc"`は数値として解析できないので`Integer.parseInt()`は`NumberFormatException`をスローする（Aは誤り）。
- `NumberFormatException`は`IllegalArgumentException`のサブクラスなので、`catch (IllegalArgumentException | NullPointerException e)`のうち`IllegalArgumentException`側できちんと捕まる（Eは誤り、`IllegalArgumentException`は`NumberFormatException`の祖先なので一致する）。
- `e.getClass().getSimpleName()`は`catch`の宣言型ではなく実際にスローされたクラス名を返すので、`IllegalArgumentException`（C）ではなく`NumberFormatException`（B）になる。
- `javac`/`java`で検証済み。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex5"></a>
## 問題ex5-1(sample/chap7/ex5)

```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + ":" + a + ":" + b);
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `/ by zero:10:0` が出力される
B. `null:10:0` が出力される
C. `catch`ブロック内の`a`・`b`の参照でコンパイルエラーになる（シンボルが見つからない）
D. `int result = a / b;`の行でコンパイルエラーになる（ゼロ除算はコンパイル時に検出される）
E. 実行時に`NullPointerException`がスローされる

**解答**

正解：**C**

**補足**

- `a`と`b`は`try`ブロックの中で宣言されたローカル変数。ローカル変数の**スコープは、宣言されたブロックの中だけ**に限られる。
- `catch`ブロックは`try`ブロックとは別のスコープなので、`try`内で宣言した`a`・`b`は`catch`の中からは参照できない。
- ゼロ除算(`int`同士)は実行時エラー(`ArithmeticException`)であり、コンパイル時には検出されない（Dは誤り）。今回はその手前、変数スコープの方で先にコンパイルが失敗する。
- `javac`で検証済み：「シンボルを見つけられません（シンボル: 変数a）」「シンボルを見つけられません（シンボル: 変数b）」の2件のエラー。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex5-2(sample/chap7/ex5)

```java
public class Main {
    public static void main(String[] args) {
        int a = 10, b = 0, result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + ":" + a + ":" + b + ":" + result);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `/ by zero:10:0:0`
B. `/ by zero:10:0:null`
C. `null:10:0:0`
D. `catch`ブロック内の変数参照でコンパイルエラーになる
E. `result`が未初期化変数としてコンパイルエラーになる

**解答**

正解：**A**

**補足**

- 問題ex5-1との対比がポイント。今回は`a`, `b`, `result`をすべて`try`ブロックの**外**（`main`メソッドの直下）で宣言しているので、スコープは`main`メソッド全体に及び、`catch`ブロックからも問題なく参照できる（Dは誤り）。
- `result`は`0`で初期化済みなので未初期化変数のエラーにもならない（Eは誤り）。`a / b`（ゼロ除算）が失敗した時点で`result`への代入は行われず、`result`は初期値の`0`のまま。
- `e.getMessage()`は`"/ by zero"`。`result`は`int`型なので`null`になることはない（Bは誤り）。
- `javac`/`java`で検証済み：`/ by zero:10:0:0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex6"></a>
## 問題ex6-1(sample/chap7/ex6)

```java
public class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        try {
            disp(values);
            System.out.print(" try-end");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(" catch");
        } finally {
            System.out.print(" finally");
        }
    }
    public static void disp(int[] x) {
        for (int i = 0; i <= 4; i++) {
            System.out.print(x[i]);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1234 try-end finally`
B. `1234 catch finally`
C. `1234 catch finally try-end`
D. `catch finally`
E. `1234`のみが出力され、そこで終了する

**解答**

正解：**B**

**補足**

- `disp(values)`の中で`i=0,1,2,3`のとき`x[i]`は正常にアクセスでき`1234`が出力される。`i=4`で`x[4]`（長さ4、有効な添字は0〜3）が範囲外となり`ArrayIndexOutOfBoundsException`がスローされる。
- この例外は`disp`メソッドの中では捕まえられていないので、呼び出し元(`main`)まで伝播する。`main`側の`try`で`disp(values);`を呼んでいる箇所が例外で中断されるため、続く`System.out.print(" try-end");`には到達しない（A・Cは誤り）。
- `catch (ArrayIndexOutOfBoundsException e)`がこの例外をキャッチして`" catch"`を出力し、その後`finally`が実行されて`" finally"`。
- `javac`/`java`で検証済み：`1234 catch finally`。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex6-2(sample/chap7/ex6)

```java
public class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        try {
            System.out.print(disp(values));
            System.out.print(" try-end");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(" catch");
        } finally {
            System.out.print(" finally");
        }
    }
    public static int disp(int[] x) {
        int sum = 0;
        for (int i = 0; i <= 4; i++) {
            sum += x[i];
        }
        return sum;
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `10 catch finally`
B. ` catch finally`（`disp`の戻り値は一切出力されない）
C. `10 try-end finally`
D. `catch finally`（先頭に空白は付かない）
E. コンパイルエラーになる（`disp`が値を返す前に例外をスローする可能性があるため）

**解答**

正解：**B**

**補足**

- 今回の`disp`は`sum`を計算するだけで、ループの中で何も`print`していない点が問題ex6-1との違い。
- `i=4`で`x[4]`が範囲外となり、`disp`メソッドは**戻り値を返す前に**例外をスローする。
- `System.out.print(disp(values));`は、まず引数`disp(values)`を評価してから`print`を呼び出す、という順序で実行されるため、**引数の評価(`disp`の呼び出し)が例外で失敗した時点で、外側の`print`自体は一度も呼ばれない**（Aのように`10`が出力されることはない）。
- 結果として、`main`の`try`ブロックの実行はそこで中断され、`catch`→`finally`という順に処理される。`System.out.print(" catch");`の先頭に半角スペースが入っているので、出力全体は先頭に空白が付いた` catch finally`になる（Dは誤り）。
- `javac`/`java`で検証済み：` catch finally`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex7"></a>
## 問題ex7-1(sample/chap7/ex7)

```java
public class Main {
    public static void main(String[] args) {
        String s = "s";
        try {
            System.out.print(s.length()); return;
        } catch (RuntimeException e) {
            System.out.print(" catch"); return;
        } finally {
            System.out.print(" finally");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1`
B. `1 finally`
C. `1 catch finally`
D. コンパイルエラーになる（`return`の後にコードが続くため）
E. 何も出力されない

**解答**

正解：**B**

**補足**

- `s = "s"`なので`s.length()`は正常に`1`を返し、例外は一切起きない。`catch`ブロックは実行されない（Cは誤り）。
- `System.out.print(1); return;`の`return`は、即座にメソッドを終了させるのではなく、**その前に必ず`finally`を実行させてから**メソッドを終了させる。
- 各`catch`/`finally`ブロックはそれぞれ独立した構文要素であり、「`return`の後にコードが続く」という到達不能コードの制約は同じブロック内だけの話（`finally`ブロックは別ブロックなので普通に実行される。Dは誤り）。
- `javac`/`java`で検証済み：`1 finally`。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex7-2(sample/chap7/ex7)

```java
public class Main {
    public static void main(String[] args) {
        String s = null;
        try {
            System.out.print(s.length()); return;
        } catch (RuntimeException e) {
            System.out.print(" catch"); return;
        } finally {
            System.out.print(" finally"); return;
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `catch finally`
B. `finally`のみ
C. `catch`のみ（`finally`内の`return`によって`print`自体がスキップされる）
D. コンパイルエラーになる（`finally`ブロックの中で`return`は使用できない）
E. 実行時に`NullPointerException`が`catch`されずに伝播し、プログラムが異常終了する

**解答**

正解：**A**

**補足**

- `s`が`null`なので`s.length()`で`NullPointerException`がスローされる。これは`RuntimeException`のサブクラスなので`catch (RuntimeException e)`でキャッチされ`" catch"`が出力される（Eは誤り）。
- `finally`ブロックの中で`return`を書くこと自体は文法的に問題ない（Dは誤り）。`finally`に入った時点で`" finally"`という`print`文自体は普通に実行されてから`return`するので、Cのように出力がスキップされることもない。
- `catch`が`return`しようとした後、`finally`が実行されて`" finally"`が出力され、`finally`自身も`return`することでメソッドが終了する（今回は`void`メソッドなので、`catch`の`return`と`finally`の`return`のどちらが「勝つか」は戻り値には影響しないが、両方とも普通に実行はされる）。
- `javac`/`java`で検証済み：`catch finally`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8-1(sample/chap7/ex8)

```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("a");
            x();
        } catch (NumberFormatException e) {
            System.out.print("NFE ");
        }
    }
    public static void x() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `NFE` が出力される
B. `x()`が投げうる`ClassNotFoundException`が処理されていないため、`x();`の行でコンパイルエラーになる
C. 実行時に`ClassNotFoundException`が`catch`されずに伝播し、プログラムが異常終了する
D. `x()`メソッドの宣言自体がコンパイルエラーになる
E. `Integer.parseInt("a")`の行でコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `x()`メソッド自体は`throws ClassNotFoundException`を正しく宣言しているので、メソッド定義自体は問題ない（Dは誤り）。
- 問題は呼び出し側。`try`ブロックの中に書かれてはいるが、用意されている`catch`は`NumberFormatException`のみで、`x()`が投げうる**チェック例外**`ClassNotFoundException`には一切対応していない。
- 「`try`の中に書いてあるから安心」ではなく、**その`try`に対応する`catch`(または呼び出し元の`throws`宣言)が、実際にスローされうる型をカバーしているか**が問われる。`Integer.parseInt("a")`自体は非チェック例外(`NumberFormatException`)なので、その行自体はコンパイルエラーの原因にならない（Eは誤り）。
- `javac`で検証済み：`x();`の行で「例外`ClassNotFoundException`は報告されません。スローするには、捕捉または宣言する必要があります」。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex8-2(sample/chap7/ex8)

```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("a");
            x();
        } catch (NumberFormatException | ClassNotFoundException e) {
            System.out.print("caught:" + e.getClass().getSimpleName());
        }
    }
    public static void x() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `caught:ClassNotFoundException`
B. `caught:NumberFormatException`
C. `x()`が一度も呼ばれないままプログラムが正常終了する
D. 両方の型を1つのmulti-catchにまとめること自体がコンパイルエラーになる
E. 実行時に2つの例外が両方ともスローされ、プログラムが異常終了する

**解答**

正解：**B**

**補足**

- `NumberFormatException`（非チェック）と`ClassNotFoundException`（チェック）は無関係な兄弟同士なので、multi-catchで組み合わせること自体は問題ない（Dは誤り）。
- `Integer.parseInt("a")`が**先に**実行され、この時点で`NumberFormatException`がスローされる。例外がスローされた瞬間、`try`ブロックの残りの行(`x();`)は実行されない。
- よって`x()`は一度も呼び出されず（Cは誤り、正常終了ではなく例外がキャッチされて処理される）、`ClassNotFoundException`が実際にスローされる出番も無い（Eは誤り）。
- `javac`/`java`で検証済み：`caught:NumberFormatException`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex9"></a>
## 問題ex9-1(sample/chap7/ex9)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        new Main().test(args);
    }
    public void test(String... args) throws IOException {
        throw new FileNotFoundException();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `test`メソッドの宣言でコンパイルエラーになる（`FileNotFoundException`は`IOException`ではないため）
C. `throw new FileNotFoundException();`の行でコンパイルエラーになる
D. `main`メソッド内の`test(args)`の呼び出しでコンパイルエラーになる
E. 可変長引数(`String... args`)と`throws`は同時に使えないためコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `test`メソッドは`throws IOException`と宣言しているが、実際に投げているのは`IOException`の**サブクラス**である`FileNotFoundException`。メソッドの`throws`宣言には、実際に投げる型そのものだけでなく、**その型を包含するスーパークラス**を書いてもよい（B・Cは誤り）。
- `main`は`throws Exception`と宣言しており、`IOException`は`Exception`のサブクラスなので、`test(args);`の呼び出しも問題なく許容される（Dは誤り）。
- 可変長引数と`throws`宣言は全く別の要素で、同時に使うことに何の制約もない（Eは誤り）。
- `javac`で検証済み：エラー無くコンパイルが通る。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex9-2(sample/chap7/ex9)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        new Main().test(args);
    }
    public void test(String... args) {
        throw new FileNotFoundException();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `test`メソッドに`throws`宣言が無いため、`throw new FileNotFoundException();`の行でコンパイルエラーになる
C. `main`側の`test(args);`の呼び出しでコンパイルエラーになる
D. `FileNotFoundException`は非チェック例外なので、`throws`宣言が無くても問題ない
E. 実行時に`FileNotFoundException`がスローされてプログラムが終了する

**解答**

正解：**B**

**補足**

- `FileNotFoundException`は`IOException`のサブクラスであり`Exception`の子孫（`RuntimeException`ではない）＝**チェック例外**（Dは誤り）。
- `test`メソッドが`throws`を一切宣言していないため、メソッド自身の中で`throw`しているその行自体がチェック例外の未処理としてコンパイルエラーになる。呼び出し側(`main`)の話ではなく、**投げている本人のメソッド定義側**でエラーになる点に注意（Cは誤り）。
- `javac`で検証済み：`throw new FileNotFoundException();`の行で「例外`FileNotFoundException`は報告されません。スローするには、捕捉または宣言する必要があります」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex10"></a>
## 問題ex10-1(sample/chap7/ex10)

```java
public class Main {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            System.out.print("A");
        } finally {
            System.out.print("B");
        }
    }
}
class MyResource {
    public MyResource() {
        System.out.print("C");
    }
    public void close() {
        System.out.print("D");
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `CADB` が出力される
B. `CABD` が出力される
C. `try (MyResource resource = new MyResource())`の行でコンパイルエラーになる
D. `public void close()`の行でコンパイルエラーになる（`close`という名前は予約されている）
E. 実行時に例外がスローされる（`close()`が自動的には呼ばれないため）

**解答**

正解：**C**

**補足**

- `MyResource`は`close()`という名前・シグネチャのメソッドこそ持っているが、**`AutoCloseable`（または`Closeable`）インタフェースを実装していない**。
- try-with-resourcesで使えるリソースは、「`close()`という名前のメソッドを持っているかどうか」という構造的な一致では判定されず、**`AutoCloseable`を正式に実装しているかどうか**という型による判定になる。
- `close()`という名前自体に予約語のような特別な制約は無い（Dは誤り）。
- `javac`で検証済み：「不適合な型: try-with-resourceは変数型に使用できません（`MyResource`を`AutoCloseable`に変換できません）」。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex10-2(sample/chap7/ex10)

```java
public class Main {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            System.out.print("A");
        } finally {
            System.out.print("B");
        }
    }
}
class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.print("C");
    }
    public void close() {
        System.out.print("D");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `CADB`
B. `CABD`
C. `CDAB`
D. `ACDB`
E. `CADB`ではなく`ACBD`（`try`ブロックの実行が先で、コンストラクタは`try`の中で呼ばれる）

**解答**

正解：**A**

**補足**

- `implements AutoCloseable`を追加しただけで、問題ex10-1と同じ構造がそのまま動くようになる。
- 順番は「①コンストラクタ実行(`C`)」→「②tryブロック本体(`A`)」→「③(暗黙の)close()実行(`D`)」→「④finally(`B`)」。コンストラクタは`try(...)`の**丸括弧の中**、つまり`try`ブロック本体に入る前に呼ばれる（Dのように本体が先ではない）。
- `close()`は`finally`より前、tryブロックを抜ける処理の一部として自動的に呼ばれる。
- `javac`/`java`で検証済み：`CADB`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11-1(sample/chap7/ex11)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Resource r1 = new Resource("r1");
        try (r1; Resource r2 = new Resource("r2")) {
            System.out.print("try ");
        } catch (IOException e) {
            System.out.print("IOException ");
        }
    }
}
class Resource implements Closeable {
    String name;
    public Resource(String name) { this.name = name; }
    public void close() throws IOException {
        System.out.print(name + ":close() ");
        throw new IOException();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `try r1:close() r2:close() IOException `
B. `try r2:close() r1:close() IOException `
C. `try r2:close() IOException `（`r2`のclose()が失敗した時点で`r1`のclose()は呼ばれない）
D. `try r2:close() r1:close() `の後、`IOException`がキャッチされずにプログラムが異常終了する
E. コンパイルエラーになる（事前宣言した`r1`をそのまま`try(r1; ...)`に渡せない）

**解答**

正解：**B**

**補足**

- `Resource`は`AutoCloseable`のサブインタフェースである`Closeable`を実装しており、事前宣言した変数(`r1`)を再代入せずにそのまま`try(r1; ...)`へ渡す書き方も問題なくコンパイルできる（Eは誤り）。
- クローズは宣言(`r1`, `r2`)と逆順、つまり`r2`→`r1`の順（Aは誤り）。
- `r2.close()`が例外を投げても、**その後にクローズされるはずだった`r1`の`close()`は独立して必ず実行される**（Cは誤り）。
- 最初にスローされた`r2`側の`IOException`が主例外として`catch (IOException e)`に届く（Dは誤り、ちゃんとキャッチされる）。
- `javac`/`java`で検証済み：`try r2:close() r1:close() IOException `。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex11-2(sample/chap7/ex11)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try (Resource2 r1 = new Resource2("r1", false);
             Resource2 r2 = new Resource2("r2", true)) {
            System.out.print("try ");
        } catch (IOException e) {
            System.out.print("IOException:" + e.getSuppressed().length + " ");
        }
    }
}
class Resource2 implements Closeable {
    String name; boolean fail;
    public Resource2(String name, boolean fail) { this.name = name; this.fail = fail; }
    public void close() throws IOException {
        System.out.print(name + ":close() ");
        if (fail) throw new IOException(name);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `try r2:close() r1:close() IOException:0 `
B. `try r2:close() r1:close() IOException:1 `
C. `try r1:close() r2:close() IOException:0 `
D. `try r1:close() r2:close() IOException:1 `
E. `try r2:close() IOException:0 `（`r1`は`fail=false`なので`close()`自体が呼ばれない）

**解答**

正解：**A**

**補足**

- クローズは宣言(`r1`, `r2`)の逆順なので`r2`→`r1`（C・Dは誤り）。
- `fail=false`の`r1`であっても、**リソースである以上`close()`自体は必ず呼ばれる**（`fail`は「呼ばれた結果例外を投げるかどうか」を制御しているだけ。Eは誤り）。
- `r2.close()`（先にクローズされる）が例外を投げ、`r1.close()`（後にクローズされる）は正常終了(何も投げない)。例外を投げたのは`r2`の1件だけなので、`suppressed`として付加される追加の例外は無く`getSuppressed().length`は`0`（Bは誤り）。
- `javac`/`java`で検証済み：`try r2:close() r1:close() IOException:0 `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex12"></a>
## 問題ex12-1(sample/chap7/ex12)

```java
public class Main {
    public static void main(String[] args) {
        try {
            new Main().x(null);
        } catch (RuntimeException ex) {}
    }
    public void x(String s) throws NullPointerException {
        if (s == null) {
            throw new NullPointerException();
        } else {
            throw new Exception();
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、実行時に何も出力せず正常終了する
B. `x`メソッドの宣言（`throws NullPointerException`）自体がコンパイルエラーになる
C. `else`ブロックの`throw new Exception();`の行でコンパイルエラーになる
D. `if`ブロックの`throw new NullPointerException();`の行でコンパイルエラーになる
E. `new Main().x(null);`の呼び出し側でコンパイルエラーになる

**解答**

正解：**C**

**補足**

- `x`メソッドの宣言`throws NullPointerException`自体は、非チェック例外を宣言しているだけなので単独では何の問題も無い（Bは誤り。非チェック例外はそもそも宣言してもしなくても自由）。
- `if`ブロックの`NullPointerException`は非チェック例外なのでそのまま`throw`できる（Dは誤り）。
- 問題は`else`ブロック。`new Exception()`は**チェック例外**であり、`x`メソッドはこれを`throws`宣言に含めていない（`NullPointerException`だけ）。そのためこの`throw`文自体がコンパイルエラーになる。
- 呼び出し側の`try-catch (RuntimeException ex)`は、`x`メソッドの宣言が確定しない以上そもそも評価されない（Eは誤り、直接の原因ではない）。
- `javac`で検証済み：`throw new Exception();`の行で「例外`Exception`は報告されません。スローするには、捕捉または宣言する必要があります」。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex12-2(sample/chap7/ex12)

```java
public class Main {
    public static void main(String[] args) {
        try {
            new Main().x(null);
        } catch (RuntimeException ex) {
            System.out.print("caught");
        }
    }
    public void x(String s) throws NullPointerException {
        if (s == null) {
            throw new NullPointerException();
        } else {
            throw new IllegalStateException();
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `caught`
B. 何も出力されない
C. `IllegalStateException`が`throws NullPointerException`の宣言と一致しないためコンパイルエラーになる
D. 実行時に`NullPointerException`がキャッチされずに伝播しプログラムが異常終了する
E. `s == null`の判定自体が常に`false`になるためコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `else`ブロックを`Exception`(チェック)から`IllegalStateException`(非チェック、`RuntimeException`の子孫)に変えたのが問題ex12-1との違い。非チェック例外はメソッドの`throws`宣言と型が一致していなくても自由に投げられる（Cは誤り。`throws NullPointerException`は「これ以外投げてはいけない」という制約ではなく、非チェック例外は宣言と無関係）。
- 引数は`null`なので`if`側の`NullPointerException`が実際にスローされる。これは`RuntimeException`のサブクラスなので`catch (RuntimeException ex)`で問題なく捕まる（Dは誤り）。
- `javac`/`java`で検証済み：`caught`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13-1(sample/chap7/ex13)

```java
import java.io.*;
class Super {
    public void method() throws FileNotFoundException {}
}
class Sub extends Super {
    @Override
    public void method() throws IOException {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`IOException`は`FileNotFoundException`の親なので広く構えているだけ）
B. `Sub`の`method()`の行でコンパイルエラーになる
C. `Super`の`method()`の行でコンパイルエラーになる
D. `@Override`アノテーション自体が不要な警告を出すだけで、コンパイルは通る
E. 実行時に例外がスローされる

**解答**

正解：**B**

**補足**

- オーバーライドの例外ルールは「オーバーライドする側は、親が宣言した型と**同じか、より狭い(サブクラスの)**型しか宣言できない」というもの。
- `IOException`は`FileNotFoundException`の**親**（より広い型）にあたるため、これは「狭める」ではなく「広げる」方向であり、ルール違反になる（Aは誤り。「親のFileNotFoundExceptionより広いから安全」という直感は逆）。
- `Super`側は誰かをオーバーライドしているわけではないので単独では問題ない（Cは誤り）。
- `javac`で検証済み：「`Sub`の`method()`は`Super`の`method()`をオーバーライドできません（オーバーライドされたメソッドは`IOException`をスローしません）」。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex13-2(sample/chap7/ex13)

```java
import java.io.*;
class Super {
    public void method() throws FileNotFoundException {}
}
class Sub extends Super {
    @Override
    public void method(String extra) throws Exception {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（オーバーライドとして正しく認識される）
B. `throws Exception`が`FileNotFoundException`より広いためコンパイルエラーになる
C. `@Override`の行でコンパイルエラーになる（オーバーライドまたは実装の対象が無い）
D. `method`という同じ名前を2つ定義していることになりコンパイルエラーになる
E. 実行時にどちらの`method`が呼ばれるか不定になる

**解答**

正解：**C**

**補足**

- `Sub`の`method(String extra)`は、引数を1つ受け取るように**シグネチャ(引数の型・数)を変えてしまっている**。これは`Super`の`method()`（引数無し）を**オーバーライドしているのではなく、全くの別メソッドとして新規追加(オーバーロード)している**状態。
- `@Override`アノテーションは「これは親の対応するメソッドを正しくオーバーライドしている」ことをコンパイラに検証させるためのものなので、実際にはオーバーライドが成立していない（シグネチャが違う）今回のケースでは、コンパイラがそれを検出してエラーにする。
- 例外の型がどうこう(Bのような判定)以前に、**そもそもオーバーライドの関係が成立していない**という、より根本的なところでエラーになる点に注意。同名メソッドでも引数が違えばオーバーロードとして共存できるので、Dのような「二重定義」エラーにもならない。
- `javac`で検証済み：「メソッドはスーパータイプのメソッドをオーバーライドまたは実装しません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14-1(sample/chap7/ex14)

```java
public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException("MyEx");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class MyException extends Exception {
    MyException(String message) { super(message); }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `MyEx`
B. `MyException: MyEx`
C. `null`
D. `MyException@`から始まるハッシュコード付きの文字列
E. コンパイルエラーになる

**解答**

正解：**B**

**補足**

- `System.out.println(e)`のように**例外オブジェクトそのもの**を渡すと、暗黙的に`e.toString()`が呼ばれる。
- `Throwable`の`toString()`は「完全修飾でないクラス名: `getMessage()`の結果」という形式になっている。よって`e.getMessage()`が`"MyEx"`なら、`toString()`の結果は`"MyException: MyEx"`になる。
- `e.getMessage()`だけを出力すればAの`"MyEx"`になるが、今回は`e`自体を渡している点に注意。`Object`のデフォルトの`toString()`（Dのようなハッシュコード形式）は、`Throwable`が独自に`toString()`をオーバーライドしているため使われない。
- `javac`/`java`で検証済み：`MyException: MyEx`。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex14-2(sample/chap7/ex14)

```java
public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException("MyEx");
        } catch (Exception e) {
            System.out.println(e.toString().equals(e.getMessage()));
        }
    }
}
class MyException extends Exception {
    MyException(String message) { super(message); }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true`
B. `false`
C. `null`
D. `NullPointerException`がスローされる
E. コンパイルエラーになる（`Exception`は`equals`をオーバーライドしていない）

**解答**

正解：**B**

**補足**

- `e.getMessage()`は`"MyEx"`のみ。`e.toString()`は`"MyException: MyEx"`という、クラス名を含んだ別の文字列になる。
- この2つの文字列は明らかに内容が異なるので`equals()`は`false`を返す。
- `equals()`は`Object`から継承したデフォルト実装（文字列の場合は`String`が内容比較にオーバーライド済み）がそのまま使えるので、独自にオーバーライドしていなくても呼び出し自体に問題は無い（Eは誤り）。
- `javac`/`java`で検証済み：`false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15-1(sample/chap7/ex15)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception ex) {
            System.out.print("Exception! ");
        }
    }
    static void test() throws FileNotFoundException {
        try {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.print("RuntimeException! ");
            }
            throw new FileNotFoundException("FileNotFoundException! ");
        } catch (IOException e) {
            System.out.print("IOException! ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `RuntimeException! IOException! `
B. `RuntimeException! Exception! `
C. `IOException! `のみ
D. `RuntimeException! FileNotFoundException! `
E. `Exception! `のみ

**解答**

正解：**A**

**補足**

- 内側の`try`で`RuntimeException`がスローされ、内側の`catch (RuntimeException e)`でそのままキャッチ・処理される(`"RuntimeException! "`)。
- 処理は正常に続き、外側の`try`ブロック内で`throw new FileNotFoundException(...)`が実行される。`FileNotFoundException`は`IOException`のサブクラスなので、外側の`catch (IOException e)`でキャッチされる(`"IOException! "`)。
- `test()`メソッド自体は`FileNotFoundException`を投げずに正常終了するので、`main`側の`catch (Exception ex)`は一度も発火しない（B・C・Eは誤り）。
- `javac`/`java`で検証済み：`RuntimeException! IOException! `。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex15-2(sample/chap7/ex15)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            test();
            System.out.print("main-end ");
        } catch (Exception ex) {
            System.out.print("Exception! ");
        }
    }
    static void test() throws FileNotFoundException {
        try {
            try {
                throw new RuntimeException();
            } catch (ArithmeticException e) {
                System.out.print("ArithmeticException! ");
            }
            throw new FileNotFoundException("fnf! ");
        } catch (IOException e) {
            System.out.print("IOException! ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `ArithmeticException! IOException! main-end `
B. `Exception! `
C. `ArithmeticException! Exception! `
D. `IOException! main-end `
E. コンパイルエラーになる（`RuntimeException`を`catch (ArithmeticException e)`で受けられないため）

**解答**

正解：**B**

**補足**

- 内側で実際にスローされているのは`new RuntimeException()`（`ArithmeticException`ではない、ただの素の`RuntimeException`）。`ArithmeticException`は`RuntimeException`の**サブクラス**であり、`catch`は「その型かそのサブタイプ」しか受け取れない。今回はスローされた型(`RuntimeException`)の方が`catch`の宣言型(`ArithmeticException`)より**広い**ため一致せず、キャッチされない（Eのようにコンパイルエラーにはならない。実行時の型不一致は普通に許される書き方）。
- キャッチされなかった`RuntimeException`は内側の`try-catch`をすり抜け、`throw new FileNotFoundException(...)`の行にも到達しないまま、外側の`catch (IOException e)`にも(`RuntimeException`は`IOException`と無関係な型なので)一致せず、`test()`メソッドの外まで伝播する。
- `RuntimeException`は非チェック例外なので`test()`の`throws FileNotFoundException`宣言と無関係に伝播でき、`main`側の`catch (Exception ex)`でようやく捕まる(`"Exception! "`)。`test()`が正常終了しなかったので`"main-end "`は出力されない。
- `javac`/`java`で検証済み：`Exception! `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex16"></a>
## 問題ex16-1(sample/chap7/ex16)

```java
public class Main {
    public static void main(String[] args) {
        try {
            FirstException ex;
            ex = new SecondException("oops");
            throw ex;
        } catch (FirstException ex) {
            System.out.print("caught");
        }
    }
}
class FirstException extends RuntimeException {
    FirstException() {}
    FirstException(Throwable cause) { super(cause); }
    FirstException(String message) { super(message); }
}
class SecondException extends FirstException {
    SecondException(Throwable cause) { super(cause); }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`caught`が出力される（`FirstException`が`String`用コンストラクタを持っているから）
B. `ex = new SecondException("oops");`の行でコンパイルエラーになる
C. `catch (FirstException ex)`の行でコンパイルエラーになる
D. `throw ex;`の行でコンパイルエラーになる
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**B**

**補足**

- **コンストラクタは継承されない**。`FirstException`が`String`用のコンストラクタを持っていても、`SecondException`自身が明示的に定義しているのは`SecondException(Throwable cause)`という1つだけ（Aは誤り、親のコンストラクタが自動的に使えるわけではない）。
- `new SecondException("oops")`は、`SecondException`に存在しない「`String`を受け取るコンストラクタ」を探そうとして失敗する。
- `catch`や`throw`の行に到達する前に、そもそも`SecondException`のインスタンス生成自体が失敗するので、C・Dは無関係。
- `javac`で検証済み：「不適合な型: Stringを`Throwable`に変換できません」（`SecondException`が受け取れるのは`Throwable`だけであり、`String`リテラルはそこに当てはまらない）。

**実施記録**

回答：
正解：
迷ったポイント：
## 問題ex16-2(sample/chap7/ex16)

```java
public class Main {
    public static void main(String[] args) {
        try {
            FirstException ex;
            ex = new SecondException();
            throw ex;
        } catch (FirstException ex) {
            System.out.print("caught");
        }
    }
}
class FirstException extends RuntimeException {
    FirstException() {}
    FirstException(Throwable cause) { super(cause); }
    FirstException(String message) { super(message); }
}
class SecondException extends FirstException {
    SecondException(Throwable cause) { super(cause); }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`caught`が出力される（`FirstException`が無引数コンストラクタを持っているから）
B. `catch (FirstException ex)`の行でコンパイルエラーになる
C. `ex = new SecondException();`の行でコンパイルエラーになる
D. `throw ex;`の行でコンパイルエラーになる
E. 実行時に`NoSuchMethodException`がスローされる

**解答**

正解：**C**

**補足**

- 問題ex16-1と同じ「コンストラクタは継承されない」という原則。`FirstException()`という無引数コンストラクタが親に存在していても、`SecondException`自身は`SecondException(Throwable cause)`という**引数1つのコンストラクタしか持っていない**。
- `new SecondException()`（引数無し）は、`SecondException`に存在しない「引数の無いコンストラクタ」を探そうとして失敗する（Aは誤り）。
- コンストラクタの解決は完全にコンパイル時に行われるので、Eのような実行時エラーにはならない。
- `javac`で検証済み：「クラス`SecondException`のコンストラクタ`SecondException`は指定された型に適用できません（期待値: Throwable、検出値: 引数がありません）」。

**実施記録**

回答：
正解：
迷ったポイント：