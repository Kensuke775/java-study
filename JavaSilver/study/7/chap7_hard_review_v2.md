# 第7章 復習問題v2（コード・選択肢を変えた再挑戦版）

`chap7_hard_review.md`の18問（誤答14問＋自信なしフラグ4問）と同じ概念・同じ落とし穴を、変数名・数値・文字列・クラス名・選択肢の並びを変えて出題し直したもの。全問`javac`/`java`で再検証済み。回答欄は空欄。

## 目次

- [復習v2-1(元:復習問題1)](#v1)
- [復習v2-2(元:復習問題2)](#v2)
- [復習v2-3(元:復習問題3)](#v3)
- [復習v2-4(元:復習問題4)](#v4)
- [復習v2-5(元:復習問題5)](#v5)
- [復習v2-6(元:復習問題6)](#v6)
- [復習v2-7(元:復習問題7)](#v7)
- [復習v2-8(元:復習問題8)](#v8)
- [復習v2-9(元:復習問題9)](#v9)
- [復習v2-10(元:復習問題10)](#v10)
- [復習v2-11(元:復習問題11)](#v11)
- [復習v2-12(元:復習問題12)](#v12)
- [復習v2-13(元:復習問題13)](#v13)
- [復習v2-14(元:復習問題14)](#v14)
- [復習v2-15(元:復習問題15)](#v15)
- [復習v2-16(元:復習問題16)](#v16)
- [復習v2-17(元:復習問題17)](#v17)
- [復習v2-18(元:復習問題18)](#v18)



## 復習v2-1(元:復習問題1)

```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40};
        for (int i = 0; i <= nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `10` `20` `30` `40` が出力される
B. `10` `20` `30` `40` が出力された後、プログラムが異常終了する
C. `10` `20` `30` が出力された後、プログラムが異常終了する
D. `nums.length`が原因でコンパイルエラーになる
E. 無限ループになる

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- ループは`i = 0`から`i <= nums.length(=4)`まで、つまり`i = 0,1,2,3,4`で回ろうとする。
- `i = 0〜3`で`10 20 30 40`が出力される。
- `i = 4`で`nums[4]`（有効な添字は0〜3まで）にアクセスした瞬間`ArrayIndexOutOfBoundsException`がスローされ、キャッチする処理が無いため異常終了する。
- `javac`/`java`で検証済み。

## 復習v2-2(元:復習問題2)

```java
class MyError extends Exception {
    public MyError(String msg) { super(msg); }
    public MyError(Throwable cause) { super(cause); }
}
public class Main {
    public static void main(String[] args) {
        MyError e = new MyError(null);
        System.out.println(e.getMessage());
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `null` が出力される
B. `NullPointerException`がスローされる
C. `MyError(String)`が呼ばれたとみなされコンパイルは通る
D. コンパイルエラーになる（コンストラクタ呼び出しが曖昧）
E. `MyError(Throwable)`が呼ばれたとみなされコンパイルは通る

**実施記録**

回答：D  
正解：  
迷ったポイント：

解説：
- `MyError(String)`と`MyError(Throwable)`は、どちらも`null`を代入できる参照型1つを引数に取る。
- `null`にはコンパイル時の型情報が無いため、コンパイラは「どちらの引数型と解釈すべきか」を決定できず、`あいまいです`エラーになる。
- `javac`で検証済み：「MyErrorの参照はあいまいです」。

## 復習v2-3(元:復習問題3)

```java
class OverLimitException extends Exception {
    public OverLimitException(String msg) { super(msg); }
}
public class Main {
    static void checkLimit(int score) throws OverLimitException {
        if (score > 100) throw new OverLimitException("score too high: " + score);
    }
    public static void main(String[] args) {
        checkLimit(150);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `main`メソッド内の`checkLimit(150);`の行でコンパイルエラーになる
B. 実行され、何も出力されずに正常終了する
C. 実行時に`OverLimitException`がスローされてプログラムが終了する
D. `checkLimit`メソッドの宣言（`throws OverLimitException`）でコンパイルエラーになる
E. `OverLimitException`が`RuntimeException`を継承していないため、`throw`自体がコンパイルエラーになる

**実施記録**

回答：A 正解：A 迷ったポイント：

解説：
- `checkLimit`は`throws OverLimitException`と宣言されたチェック例外を投げる可能性があるメソッド。
- チェック例外は「呼び出し側で`catch`するか、自分も`throws`で宣言する」義務があるが、`main`はどちらもしていない。
- `javac`で検証済み：「例外OverLimitExceptionは報告されません。スローするには、捕捉または宣言する必要があります」。

## 復習v2-4(元:復習問題4)

```java
public class Main {
    public static void main(String[] args) {
        int[] vals = {5, 0};
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(100 / vals[i]);
            } catch (RuntimeException e) {
                System.out.println("RE:" + e.getClass().getSimpleName());
            } catch (ArithmeticException e) {
                System.out.println("AE");
            }
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `20 RE:ArithmeticException` が出力された後、`ArrayIndexOutOfBoundsException`がスローされる
B. `20 AE` が出力された後、プログラムが異常終了する
C. 実行時に`ClassCastException`がスローされる
D. 1番目の`catch (RuntimeException e)`の行でコンパイルエラーになる
E. 2番目の`catch (ArithmeticException e)`の行でコンパイルエラーになる

**実施記録**

回答：E 正解：E 迷ったポイント：

解説：
- `ArithmeticException`は`RuntimeException`のサブクラスなので、先に書いた`catch (RuntimeException e)`に完全に包含される。
- 2番目の`catch (ArithmeticException e)`には絶対に制御が渡らないとコンパイラが静的に判断できるため、到達不能コードとしてコンパイルエラーになる。
- `javac`で検証済み：「例外ArithmeticExceptionはすでに捕捉されています」。

## 復習v2-5(元:復習問題5)

```java
public class Main {
    public static void main(String[] args) {
        String[] data = {"X", "Y"};
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(data[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("caught");
                throw new RuntimeException("stop");
            } finally {
                System.out.println("cleanup");
            }
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `X` `cleanup` `Y` `cleanup` `caught` `cleanup` の後、`RuntimeException`がスローされてプログラムが終了する
B. `X` `cleanup` `Y` `cleanup` `caught` の後、`finally`は実行されずに終了する
C. `X` `cleanup` `Y` `cleanup` `caught` `cleanup` の後、正常終了する
D. `X` `Y` `caught` `cleanup` `cleanup` `cleanup` の順に出力される
E. `catch`ブロック内で`throw`しているため、`finally`は実行されない

**実施記録**

回答：C 正解：A 迷ったポイント：

解説：
- `data`は長さ2、ループは3回まわる。`i=0,1`で`X`,`Y`を出力、`finally`で`cleanup`。
- `i=2`で`ArrayIndexOutOfBoundsException`が発生し`catch`に入り`caught`を出力後、`throw new RuntimeException("stop")`で新しい例外を投げる。
- `catch`ブロック内で`throw`していても`finally`は必ず実行されるため`cleanup`が出力されてから、`RuntimeException`が伝播してプログラムが終了する。
- `javac`/`java`で検証済み：`X cleanup Y cleanup caught cleanup`の後に`Exception in thread "main" java.lang.RuntimeException: stop`。

## 復習v2-6(元:復習問題6)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(compute());
    }
    static int compute() {
        int y = 10;
        try {
            y = 20;
            fail();
            y = 30;
        } catch (Exception e) {
            y = 40;
            return y;
        } finally {
            y = 50;
        }
        return y;
    }
    static void fail() throws Exception {
        throw new Exception("err");
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `40` が出力される
B. `50` が出力される
C. `20` が出力される
D. `10` が出力される
E. 実行時に例外がスローされてプログラムが終了する

**実施記録**

回答：A 正解：A 迷ったポイント：

解説：
- `catch`ブロックで`y=40; return y;`と書いた時点で、戻り値として`40`が確定（プリミティブ型はこの時点で値がコピーされる）。
- その後`finally`で`y=50`と再代入しても、それは既に確定した戻り値には影響しない。
- `javac`/`java`で検証済み：`40`が出力される。

## 復習v2-7(元:復習問題7)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("does_not_exist_xyz.txt");
            fr.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("fr was null");
            }
        }
        System.out.println("end");
    }
}
```

`does_not_exist_xyz.txt`は実際には存在しないファイルとします。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `fr was null` `end`
B. `end`
C. 何も出力されずに異常終了する
D. `end`より前に`FileNotFoundException`のスタックトレースと`fr was null`が出力される
E. `close()`が2回呼ばれてしまい`IOException`がスローされる

**実施記録**

回答：B 正解：D 迷ったポイント：

解説：
- `new FileReader(...)`がファイル不在で`FileNotFoundException`（`IOException`のサブクラス）を投げ、`catch (IOException e)`で捕まり`printStackTrace()`でスタックトレースが出力される。
- この時点で`fr`への代入は行われていない（`new FileReader`の呼び出し自体が失敗したため）ので`fr`は`null`のまま。
- `finally`内の`fr.close()`で`NullPointerException`が発生し、`catch (NullPointerException e)`で`fr was null`が出力される。
- 最後に`end`が出力される。
- `javac`/`java`で検証済み：スタックトレース→`fr was null`→`end`の順。

## 復習v2-8(元:復習問題8)

```java
class QuietRes implements AutoCloseable {
    public void close() { System.out.print("shut "); }
}
public class Main {
    public static void main(String[] args) {
        try (QuietRes r = new QuietRes()) {
            System.out.print("open ");
            throw new IllegalStateException("bad");
        } catch (IllegalStateException e) {
            System.out.print("handle ");
        } finally {
            System.out.print("done ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `open handle shut done`
B. `open shut handle done`
C. `open handle done shut`
D. `open done shut handle`
E. `open shut done handle`

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `try`本体で`open`を出力後に例外を投げると、まず**リソースの自動`close()`が先に実行される**（`shut`）。
- その後、伝播してきた例外が`catch (IllegalStateException e)`で捕まり`handle`を出力。
- 最後に`finally`で`done`が出力される。
- `javac`/`java`で検証済み：`open shut handle done`。

## 復習v2-9(元:復習問題9)

```java
class ResX implements AutoCloseable {
    public void close() { System.out.print("closeX "); throw new RuntimeException("failX"); }
}
class ResY implements AutoCloseable {
    public void close() { System.out.print("closeY "); }
}
public class Main {
    public static void main(String[] args) {
        try (ResY y = new ResY(); ResX x = new ResX()) {
            System.out.print("run ");
        } catch (RuntimeException e) {
            System.out.print("catch:" + e.getMessage() + " ");
        } finally {
            System.out.print("finally ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `run closeX catch:failX finally`（`closeY`は呼ばれない）
B. `run closeY closeX catch:failX finally`
C. `run closeX closeY finally catch:failX`
D. 実行時に`RuntimeException`が2重にスローされてプログラムが異常終了する
E. `run closeX closeY catch:failX finally`

**実施記録**

回答：B 正解：E 迷ったポイント：

解説：
- 宣言順は`ResY, ResX`だが、`close()`は**宣言と逆順**（`ResX`→`ResY`）で呼ばれる。
- `ResX.close()`は`closeX`を出力した後に`RuntimeException("failX")`を投げるが、途中で例外が起きても**残りのリソース（ResY）は必ず`close()`される**。
- その後、最初に発生した`failX`の例外が`catch`に伝播し`catch:failX`を出力、最後に`finally`で`finally`を出力。
- `javac`/`java`で検証済み：`run closeX closeY catch:failX finally`。

## 復習v2-10(元:復習問題10)

```java
class TagRes implements AutoCloseable {
    String tag;
    TagRes(String tag) { this.tag = tag; }
    public void close() { System.out.print("shut" + tag + " "); }
}
public class Main {
    public static void main(String[] args) {
        try (TagRes a = new TagRes("A"); TagRes b = new TagRes("B")) {
            System.out.print("run ");
            return;
        } finally {
            System.out.print("done ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `run done`（`return`しているので、リソースはクローズされないまま終了する）
B. `run shutA shutB done`
C. `run shutB shutA done`
D. `run done shutB shutA`
E. `run`のみ（`return`直後にプログラムが即終了する）

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `try`本体で`return`しても、メソッドが実際に戻る前に**リソースは必ずクローズされる**（`return`はリソース解放を妨げない）。
- クローズは宣言と逆順（`b`→`a`、つまり`shutB`→`shutA`）で行われる。
- クローズが終わった後で`finally`が実行され`done`が出力されてから、実際に`return`が完了する。
- `javac`/`java`で検証済み：`run shutB shutA done`。

## 復習v2-11(元:復習問題11)

```java
class Rz3 implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("shut ");
        throw new Exception("shut-fail");
    }
}
public class Main {
    public static void main(String[] args) {
        try (Rz3 r = new Rz3()) {
            System.out.print("run ");
        } catch (RuntimeException e) {
            System.out.print("caught-RE ");
        } finally {
            System.out.print("done ");
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `run shut done` が出力される（`close()`の例外は`RuntimeException`ではないので`catch`されず、そのまま終わる）
B. `try (Rz3 r = new Rz3())`の行でコンパイルエラーになる（`close()`が投げるチェック例外`Exception`が処理されていないため）
C. `run shut caught-RE done` が出力される
D. `run`のみが出力され、`close()`の例外で異常終了する
E. `close()`の宣言（`throws Exception`）自体がコンパイルエラーになる（`AutoCloseable.close()`は`throws Exception`を宣言できない）

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `AutoCloseable`インターフェース自体は`close() throws Exception`を宣言できる（`java.lang.Exception`をそのままオーバーライドしているだけで問題ない）。
- しかし、`try-with-resources`が暗黙に呼び出す`close()`がチェック例外`Exception`を投げる可能性がある以上、その`try`文を含む`main`メソッド自身が`Exception`を`catch`するか`throws`宣言する必要がある。
- 今回`catch (RuntimeException e)`しかなく`Exception`用の対処が無いため、`try (Rz3 r = new Rz3())`の行でコンパイルエラーになる。
- `javac`で検証済み：「報告されない例外Exceptionは、スローするには捕捉または宣言する必要があります」。

## 復習v2-12(元:復習問題12)

```java
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.stepOne();
    }
    public void stepOne() throws IOException, InterruptedException {
        stepTwo();
    }
    public void stepTwo() throws InterruptedException {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、何も出力せず正常終了する
B. `stepOne`メソッドの宣言でコンパイルエラーになる
C. `stepTwo()`を呼び出している行でコンパイルエラーになる
D. `main`メソッド内の`obj.stepOne();`の行でコンパイルエラーになる
E. 実行時に`IOException`がスローされる

**実施記録**

回答：B 正解：D 迷ったポイント：

解説：
- `stepOne`は`throws IOException, InterruptedException`と宣言されているが、実際に呼んでいる`stepTwo()`は`InterruptedException`しか投げない。
- メソッドは「実際に投げる可能性がある型より広い（あるいは余分な）チェック例外」を`throws`に追加で宣言しても問題ない（今回の`IOException`は未使用の余分な宣言だが合法）。
- 問題は呼び出し側の`main`：`stepOne()`は`IOException`と`InterruttedException`という2つのチェック例外を宣言しているのに、`main`はどちらも`catch`も`throws`もしていない。
- `javac`で検証済み：`obj.stepOne();`の行で「例外IOExceptionは報告されません。スローするには、捕捉または宣言する必要があります」。

## 復習v2-13(元:復習問題13)

```java
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.first();
        } catch (RuntimeException e) {
            System.out.println("caught:" + e.getClass().getSimpleName());
        }
    }
    public void first() { second(); }
    public void second() { third(); }
    public void third() { throw new NumberFormatException("bad number"); }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `caught:NumberFormatException`
B. `caught:RuntimeException`
C. `first()`, `second()`, `third()`のいずれかに`throws`宣言が無いためコンパイルエラーになる
D. 実行時に例外が`third()`から`main`まで届かず、`second()`の中で握りつぶされる
E. スタックオーバーフローが発生する

**実施記録**

回答：A 正解：A 迷ったポイント：

解説：
- `NumberFormatException`は`RuntimeException`のサブクラス（非チェック例外）なので、`first()`/`second()`/`third()`のどれにも`throws`宣言は不要で、そのままコンパイルが通る。
- 例外は`third()`→`second()`→`first()`→`main`と、途中で`catch`されない限りそのまま上まで伝播する（「途中の`second()`で握りつぶされる」ようなことは起きない）。
- `main`の`catch (RuntimeException e)`で捕まり、`getClass().getSimpleName()`でクラス名を取得。
- `javac`/`java`で検証済み：`caught:NumberFormatException`。

## 復習v2-14(元:復習問題14)

```java
import java.sql.SQLException;
class Base { void run() throws Exception {} }
class Mid extends Base { @Override void run() throws SQLException {} }
class Leaf extends Mid { @Override void run() throws ClassNotFoundException {} }
public class Main {
    public static void main(String[] args) {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`ClassNotFoundException`も`Exception`のサブクラスだから）
B. `Base`の`run()`の行でコンパイルエラーになる
C. `Mid`の`run()`の行でコンパイルエラーになる
D. 3クラスとも無関係にコンパイルエラーになる
E. `Leaf`の`run()`の行でコンパイルエラーになる

**実施記録**

回答：A 正解：E 迷ったポイント：

解説：
- オーバーライドする際、`throws`で宣言できるチェック例外は「オーバーライドされるメソッドが宣言している型と同じか、そのサブタイプ」に限られる。
- `Mid.run()`は`SQLException`を宣言しているが、`Leaf.run()`が宣言する`ClassNotFoundException`は`SQLException`のサブタイプではない（どちらも`Exception`直下の別系統）。
- そのため`Leaf`の`run()`の行でコンパイルエラーになる。`ClassNotFoundException`が`Exception`のサブクラスであること自体は正しいが、判定基準は「直接オーバーライドする`Mid.run()`が宣言した型」であって`Exception`ではない。
- `javac`で検証済み：「Leafのrun()はMidのrun()をオーバーライドできません／オーバーライドされたメソッドはClassNotFoundExceptionをスローしません」。

## 復習v2-15(元:復習問題15)

```java
import java.sql.SQLException;
class Base { void run() throws SQLException {} }
class Mid extends Base { @Override void run() throws SQLException {} }
class Leaf extends Mid { @Override void run() {} }
public class Main {
    public static void main(String[] args) {
        Base b = new Leaf();
        try {
            b.run();
            System.out.println("ok");
        } catch (SQLException e) {
            System.out.println("ng");
        }
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `ng` が出力される
B. `Leaf`が例外を宣言していないので、`catch (SQLException e)`が原因でコンパイルエラーになる（不要な`catch`）
C. `ok` が出力される
D. `b.run();`の行でコンパイルエラーになる（`Leaf`が`SQLException`を投げないため）
E. 実行時に`ClassCastException`がスローされる

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `catch`できる例外の型は、呼び出しに使う**参照の静的型（宣言型）**を基準にコンパイラが判定する。`Base b = new Leaf();`の`b`の静的型は`Base`であり、`Base.run()`は`throws SQLException`を宣言しているため、`catch (SQLException e)`は文法上問題なく成立する。
- 実際に呼ばれるのは`Leaf.run()`（オーバーライドされ`throws`無し）なので、実行時には例外は一切発生しない。
- 結果、`b.run();`は普通に完了し、`try`ブロックの残りである`println("ok")`が実行される。
- `javac`/`java`で検証済み：`ok`が出力される。

## 復習v2-16(元:復習問題16)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            step();
        } catch (Exception e) {
            System.out.println("msg:" + e.getMessage());
            System.out.println("cause:" + e.getCause());
        }
    }
    static void step() throws Exception {
        try {
            throw new FileNotFoundException("missing");
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.

```
msg:missing
cause:null
```

B.

```
msg:java.io.FileNotFoundException: missing
cause:java.io.FileNotFoundException: missing
```

C.

```
msg:null
cause:java.io.FileNotFoundException: missing
```

D. `step`に`throws IOException`の宣言も必要なため、コンパイルエラーになる

E.

```
msg:java.lang.IllegalStateException: missing
cause:java.io.FileNotFoundException: missing
```

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `catch (FileNotFoundException e)`で捕まえた例外を、そのまま`new IllegalStateException(e)`（メッセージ省略）に渡して投げ直している。
- メッセージを省略した場合、`Throwable(Throwable cause)`コンストラクタの仕様により、自分の`message`は自動的に`cause.toString()`（＝渡した例外のクラス名+メッセージ）になる。
- そのため`getMessage()`と`getCause()`の出力がどちらも元の`FileNotFoundException`の情報を表示する形になる（内容が同じに見えるが、実体は別オブジェクト）。
- `javac`/`java`で検証済み：`msg:java.io.FileNotFoundException: missing` / `cause:java.io.FileNotFoundException: missing`。

## 復習v2-17(元:復習問題17)

```java
public class Main {
    public static void main(String[] args) {
        try {
            step();
        } catch (RuntimeException e) {
            System.out.println("caught:" + e.getMessage());
            System.out.println("cause:" + e.getCause());
        }
    }
    static void step() {
        try {
            throw new NumberFormatException("bad-number");
        } catch (NumberFormatException e) {
            throw new IllegalStateException("re-thrown", e);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.

```
caught:bad-number
cause:java.lang.IllegalStateException: re-thrown
```

B.

```
caught:re-thrown
cause:null
```

C. `IllegalStateException`と`NumberFormatException`は無関係なので`catch`できず、実行時に異常終了する

D.

```
caught:re-thrown
cause:java.lang.NumberFormatException: bad-number
```

E. `step`に`throws`宣言が無いためコンパイルエラーになる

**実施記録**

回答：D! 正解：D 迷ったポイント：

解説：
- `new IllegalStateException("re-thrown", e)`のように、メッセージと`cause`の両方を明示的に渡すコンストラクタを使うと、`getMessage()`は渡した`"re-thrown"`という自分自身のメッセージを返す。
- `getCause()`は渡した元の例外（`NumberFormatException("bad-number")`）をそのまま返す。
- 元の例外の内容が自動でメッセージにコピーされることはなく、明示的に渡した文字列がそのまま使われる。
- `javac`/`java`で検証済み：`caught:re-thrown` / `cause:java.lang.NumberFormatException: bad-number`。

## 復習v2-18(元:復習問題18)

```java
public class Main {
    public static void main(String[] args) {
        run(50);
    }
    public static void run(int value) {
        try {
            if (value < 100) {
                throw new TooSmallException("Too small!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
class TooSmallException extends Exception {
    public TooSmallException(String msg) { super(msg); }
}
```

（`TooSmallException`は`Exception`を継承したカスタム例外、`run`には`throws`宣言が一切無い）このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `run`メソッド内の`throw e;`の行でコンパイルエラーになる
B. `main`内の`run(50);`の行でコンパイルエラーになる
C. `throw new TooSmallException("Too small!");`の行でコンパイルエラーになる
D. 問題なくコンパイルが通り、実行時に`TooSmallException`がスローされてプログラムが終了する
E. 精密な再スロー(precise rethrow)により、`throws`宣言が無くても自動的に許容される

**実施記録**

回答：B 正解：A 迷ったポイント：

解説：
- 「精密な再スロー（precise rethrow, Java 7+）」は、`catch (Exception e) { throw e; }`のように広い型でキャッチしても、`e`が実質的final（再代入されていない）であれば、コンパイラが「`try`ブロック内で実際に投げられうる型」まで絞り込んで許容してくれる機能。
- ただし、この機能は「絞り込んだ型が呼び出し元のメソッドの`throws`宣言、または呼び出し元での`catch`によってちゃんと処理されている」ことが前提であり、`throws`宣言自体を不要にする機能ではない。
- 今回`run`メソッドには`throws`宣言が一切無いため、絞り込まれた`TooSmallException`（チェック例外）をそのまま外に投げようとしている`throw e;`の行でコンパイルエラーになる。
- `javac`で検証済み：「例外TooSmallExceptionは報告されません。スローするには、捕捉または宣言する必要があります」。