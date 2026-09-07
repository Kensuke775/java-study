# 第7章 復習問題v3（誤答＋自信なしフラグの再挑戦・第2ラウンド）

`chap7_hard_review_v2.md`で誤答した6問（v2-5, v2-7, v2-9, v2-12, v2-14, v2-18）と、「!」で自信なしフラグを付けた1問（v2-17）を合わせた計7問を、変数名・数値・クラス名・選択肢の並びを変えて出題し直したもの。全問`javac`/`java`で再検証済み。回答欄は空欄。

## 目次

- [復習v3-1(元:v2-5 finally+catch+rethrowの実行順序)](#w1)
- [復習v3-2(元:v2-7 finally内closeでのNPE)](#w2)
- [復習v3-3(元:v2-9 複数リソースのclose順序)](#w3)
- [復習v3-4(元:v2-12 チェック例外の連鎖と呼び出し元)](#w4)
- [復習v3-5(元:v2-14 3段オーバーライドのthrows不整合)](#w5)
- [復習v3-6(元:v2-18 precise rethrowとthrows宣言)](#w6)
- [復習v3-7(元:v2-17 メッセージ+causeの明示指定)](#w7)

<a id="w1"></a>
## 復習v3-1(元:v2-5 finally+catch+rethrowの実行順序)

```java
public class Main {
    public static void main(String[] args) {
        int[] data = {100, 200};
        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(data[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("hit");
                throw new IllegalStateException("halt");
            } finally {
                System.out.println("tidy");
            }
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `100 tidy 200 tidy hit` の後、`finally`は実行されずに終了する
B. `100 tidy 200 tidy hit tidy` の後、正常終了する
C. `100 200 hit tidy tidy tidy` の順に出力される
D. `100 tidy 200 tidy hit tidy` の後、`IllegalStateException`がスローされてプログラムが終了する
E. `catch`ブロック内で`throw`しているため、`finally`は実行されない

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w2"></a>
## 復習v3-2(元:v2-7 finally内closeでのNPE)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            in = new FileInputStream("no_such_input_file.dat");
            in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("in was null");
            }
        }
        System.out.println("finished");
    }
}
```

`no_such_input_file.dat`は実際には存在しないファイルとします。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `in was null` `finished`
B. `finished`より前に`FileNotFoundException`のスタックトレースと`in was null`が出力される
C. 何も出力されずに異常終了する
D. `finished`
E. `close()`が2回呼ばれてしまい`IOException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w3"></a>
## 復習v3-3(元:v2-9 複数リソースのclose順序)

```java
class Alpha implements AutoCloseable {
    public void close() { System.out.print("closeAlpha "); throw new RuntimeException("failAlpha"); }
}
class Beta implements AutoCloseable {
    public void close() { System.out.print("closeBeta "); }
}
public class Main {
    public static void main(String[] args) {
        try (Beta b = new Beta(); Alpha a = new Alpha()) {
            System.out.print("start ");
        } catch (RuntimeException e) {
            System.out.print("caught:" + e.getMessage() + " ");
        } finally {
            System.out.print("end ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `start closeAlpha catch:failAlpha end`（`closeBeta`は呼ばれない）
B. `start closeBeta closeAlpha catch:failAlpha end`
C. `start closeAlpha closeBeta end catch:failAlpha`
D. 実行時に`RuntimeException`が2重にスローされてプログラムが異常終了する
E. `start closeAlpha closeBeta caught:failAlpha end`

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w4"></a>
## 復習v3-4(元:v2-12 チェック例外の連鎖と呼び出し元)

```java
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.phaseA();
    }
    public void phaseA() throws SQLException, InterruptedException {
        phaseB();
    }
    public void phaseB() throws InterruptedException {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、何も出力せず正常終了する
B. `phaseA`メソッドの宣言でコンパイルエラーになる
C. `main`メソッド内の`obj.phaseA();`の行でコンパイルエラーになる
D. `phaseB()`を呼び出している行でコンパイルエラーになる
E. 実行時に`SQLException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w5"></a>
## 復習v3-5(元:v2-14 3段オーバーライドのthrows不整合)

```java
import java.io.IOException;
import java.sql.SQLException;
class Top { void act() throws Exception {} }
class Mid extends Top { @Override void act() throws IOException {} }
class Bottom extends Mid { @Override void act() throws SQLException {} }
public class Main {
    public static void main(String[] args) {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `Bottom`の`act()`の行でコンパイルエラーになる
B. `Top`の`act()`の行でコンパイルエラーになる
C. `Mid`の`act()`の行でコンパイルエラーになる
D. 問題なくコンパイルが通る（`SQLException`も`Exception`のサブクラスだから）
E. 3クラスとも無関係にコンパイルエラーになる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w6"></a>
## 復習v3-6(元:v2-18 precise rethrowとthrows宣言)

```java
public class Main {
    public static void main(String[] args) {
        process(5);
    }
    public static void process(int level) {
        try {
            if (level < 10) {
                throw new LevelTooLowException("Too low!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
class LevelTooLowException extends Exception {
    public LevelTooLowException(String msg) { super(msg); }
}
```

（`LevelTooLowException`は`Exception`を継承したカスタム例外、`process`には`throws`宣言が一切無い）このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `main`内の`process(5);`の行でコンパイルエラーになる
B. `process`メソッド内の`throw e;`の行でコンパイルエラーになる
C. `throw new LevelTooLowException("Too low!");`の行でコンパイルエラーになる
D. 問題なくコンパイルが通り、実行時に`LevelTooLowException`がスローされてプログラムが終了する
E. 精密な再スロー(precise rethrow)により、`throws`宣言が無くても自動的に許容される

**実施記録**

回答：
正解：
迷ったポイント：

<a id="w7"></a>
## 復習v3-7(元:v2-17 メッセージ+causeの明示指定)

```java
public class Main {
    public static void main(String[] args) {
        try {
            process();
        } catch (RuntimeException e) {
            System.out.println("caught:" + e.getMessage());
            System.out.println("cause:" + e.getCause());
        }
    }
    static void process() {
        try {
            throw new ArithmeticException("div-zero");
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("invalid-calc", e);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `caught:div-zero` `cause:java.lang.IllegalArgumentException: invalid-calc`
B. `caught:invalid-calc` `cause:null`
C. `ArithmeticException`と`IllegalArgumentException`は無関係なので`catch`できず、実行時に異常終了する
D. `caught:invalid-calc` `cause:java.lang.ArithmeticException: div-zero`
E. `process`に`throws`宣言が無いためコンパイルエラーになる

**実施記録**

回答：
正解：
迷ったポイント：
