# 第7章 復習問題（誤答＋自信なし正解の再挑戦）

chap7_hard_problemsで誤答した14問と、「!」で自信なしフラグを付けた正解4問（8-2, 12-2, 13-2, 16-2）を合わせた計18問。回答欄を空にして再挑戦できるようにしたもの。

## 目次

- [復習問題1(元:問題1-1)](#r1)
- [復習問題2(元:問題2-1)](#r2)
- [復習問題3(元:問題2-2)](#r3)
- [復習問題4(元:問題3-1)](#r4)
- [復習問題5(元:問題4-1)](#r5)
- [復習問題6(元:問題5-1)](#r6)
- [復習問題7(元:問題8-2)](#r7)
- [復習問題8(元:問題10-1)](#r8)
- [復習問題9(元:問題11-1)](#r9)
- [復習問題10(元:問題11-2)](#r10)
- [復習問題11(元:問題12-2)](#r11)
- [復習問題12(元:問題13-1)](#r12)
- [復習問題13(元:問題13-2)](#r13)
- [復習問題14(元:問題14-1)](#r14)
- [復習問題15(元:問題14-2)](#r15)
- [復習問題16(元:問題15-1)](#r16)
- [復習問題17(元:問題15-2)](#r17)
- [復習問題18(元:問題16-2)](#r18)

<a id="r1"></a>
## 復習問題1(元:問題1-1 / sample/chap7/1)

```java
public class Main {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (int i = 1; i <= fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `Apple` `Banana` `Cherry` が出力される
B. `Banana` `Cherry` が出力される
C. `Banana` `Cherry` が出力された後、プログラムが異常終了する
D. `Apple` `Banana` が出力された後、プログラムが異常終了する
E. コンパイルエラーになる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r2"></a>
## 復習問題2(元:問題2-1 / sample/chap7/2)

```java
public class Main {
    public static void main(String[] args) {
        InvalidAgeException e = new InvalidAgeException(null);
        System.out.println(e.getMessage());
    }
}
```

`InvalidAgeException`は`String message`用と`Throwable cause`用、両方の1引数コンストラクタを持つ（`sample/chap7/2/InvalidAgeException.java`参照）。このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `null` が出力される
B. `NullPointerException`がスローされる
C. `InvalidAgeException(String)`が呼ばれたとみなされコンパイルは通る
D. `InvalidAgeException(Throwable)`が呼ばれたとみなされコンパイルは通る
E. コンパイルエラーになる（コンストラクタ呼び出しが曖昧）

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r3"></a>
## 復習問題3(元:問題2-2 / sample/chap7/2)

```java
public class Main {
    static void validate(int age) throws InvalidAgeException {
        if (age < 0) throw new InvalidAgeException("negative age: " + age);
    }
    public static void main(String[] args) {
        validate(-5);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 実行され、何も出力されずに正常終了する
B. 実行時に`InvalidAgeException`がスローされてプログラムが終了する
C. `validate`メソッドの宣言（`throws InvalidAgeException`）でコンパイルエラーになる
D. `main`メソッド内の`validate(-5);`の行でコンパイルエラーになる
E. `InvalidAgeException`が`RuntimeException`を継承していないため、`throw`自体がコンパイルエラーになる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r4"></a>
## 復習問題4(元:問題3-1 / sample/chap7/3)

```java
public class Main {
    public static void main(String[] args) {
        String[] data = {"X", "Y"};
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(data[i]);
            } catch (RuntimeException e) {
                System.out.println("RE:" + e.getClass().getSimpleName());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("AIOOBE");
            }
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `X` `Y` `RE:ArrayIndexOutOfBoundsException` が出力される
B. `X` `Y` `AIOOBE` が出力される
C. 2番目の`catch (ArrayIndexOutOfBoundsException e)`の行でコンパイルエラーになる
D. 1番目の`catch (RuntimeException e)`の行でコンパイルエラーになる
E. 実行時に`ClassCastException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r5"></a>
## 復習問題5(元:問題4-1 / sample/chap7/4)

```java
public class Main {
    public static void main(String[] args) {
        String[] data = {"A"};
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println(data[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("catch");
                throw new RuntimeException("rethrown");
            } finally {
                System.out.println("finally");
            }
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `A` `catch` `finally` の後、正常終了する
B. `A` `finally` `catch` `finally` の後、`RuntimeException`がスローされてプログラムが終了する
C. `A` `catch` `finally` の後、`RuntimeException`がスローされてプログラムが終了する
D. `catch`ブロック内で`throw`しているため、`finally`は実行されない
E. `A` `catch` の後、`finally`より先に`RuntimeException`が伝播してプログラムが終了する

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r6"></a>
## 復習問題6(元:問題5-1 / sample/chap7/5)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(check());
    }
    static int check() {
        int x = 0;
        try {
            x = 1;
            method();
            x = 2;
        } catch (Exception e) {
            x = 3;
            return x;
        } finally {
            x = 4;
        }
        return x;
    }
    static void method() throws Exception {
        throw new Exception("boom");
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `1` が出力される
B. `2` が出力される
C. `3` が出力される
D. `4` が出力される
E. 実行時に例外がスローされてプログラムが終了する

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r7"></a>
## 復習問題7(元:問題8-2 / sample/chap7/8)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("scratch.txt");
            fw.write("data");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("fw was null");
            }
        }
        System.out.println("end");
    }
}
```

`scratch.txt`は書き込み可能な場所とします。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `fw was null` `end`
B. `end`
C. 何も出力されずに異常終了する
D. `end`より前に`NullPointerException`のスタックトレースが出力される
E. `close()`が2回呼ばれてしまい`IOException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r8"></a>
## 復習問題8(元:問題10-1 / sample/chap7/10)

```java
class LoudRes implements AutoCloseable {
    public void close() { System.out.print("close "); }
}
public class Main {
    public static void main(String[] args) {
        try (LoudRes r = new LoudRes()) {
            System.out.print("body ");
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            System.out.print("catch ");
        } finally {
            System.out.print("finally ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `body catch close finally`
B. `body close catch finally`
C. `body catch finally close`
D. `body finally close catch`
E. `body close finally catch`

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r9"></a>
## 復習問題9(元:問題11-1 / sample/chap7/11)

```java
class ResA implements AutoCloseable {
    public void close() { System.out.print("closeA "); throw new RuntimeException("failA"); }
}
class ResB implements AutoCloseable {
    public void close() { System.out.print("closeB "); }
}
public class Main {
    public static void main(String[] args) {
        try (ResB b = new ResB(); ResA a = new ResA()) {
            System.out.print("body ");
        } catch (RuntimeException e) {
            System.out.print("catch:" + e.getMessage() + " ");
        } finally {
            System.out.print("finally ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `body closeA closeB catch:failA finally`
B. `body closeA catch:failA finally`（`closeB`は呼ばれない）
C. `body closeB closeA catch:failA finally`
D. `body closeA closeB finally catch:failA`
E. 実行時に`RuntimeException`が2重にスローされてプログラムが異常終了する

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r10"></a>
## 復習問題10(元:問題11-2 / sample/chap7/11)

```java
class LoudRes2 implements AutoCloseable {
    String n;
    LoudRes2(String n) { this.n = n; }
    public void close() { System.out.print("close" + n + " "); }
}
public class Main {
    public static void main(String[] args) {
        try (LoudRes2 r1 = new LoudRes2("1"); LoudRes2 r2 = new LoudRes2("2")) {
            System.out.print("body ");
            return;
        } finally {
            System.out.print("finally ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `body finally`（`return`しているので、リソースはクローズされないまま終了する）
B. `body close2 close1 finally`
C. `body close1 close2 finally`
D. `body finally close2 close1`
E. `body`のみ（`return`直後にプログラムが即終了する）

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r11"></a>
## 復習問題11(元:問題12-2 / sample/chap7/12)

```java
class Rz2 implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("close ");
        throw new Exception("close-fail");
    }
}
public class Main {
    public static void main(String[] args) {
        try (Rz2 r = new Rz2()) {
            System.out.print("body ");
        } catch (RuntimeException e) {
            System.out.print("caught-RE ");
        } finally {
            System.out.print("finally ");
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `body close finally` が出力される（`close()`の例外は`RuntimeException`ではないので`catch`されず、そのまま終わる）
B. `body close caught-RE finally` が出力される
C. `body`のみが出力され、`close()`の例外で異常終了する
D. `try (Rz2 r = new Rz2())`の行でコンパイルエラーになる（`close()`が投げるチェック例外`Exception`が処理されていないため）
E. `close()`の宣言（`throws Exception`）自体がコンパイルエラーになる（`AutoCloseable.close()`は`throws Exception`を宣言できない）

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r12"></a>
## 復習問題12(元:問題13-1 / sample/chap7/13)

```java
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.checkedA();
    }
    public void checkedA() throws IOException, ClassNotFoundException {
        checkedB();
    }
    public void checkedB() throws ClassNotFoundException {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、何も出力せず正常終了する
B. `checkedA`メソッドの宣言でコンパイルエラーになる
C. `checkedB()`を呼び出している行でコンパイルエラーになる
D. `main`メソッド内の`obj.checkedA();`の行でコンパイルエラーになる
E. 実行時に`IOException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r13"></a>
## 復習問題13(元:問題13-2 / sample/chap7/13)

```java
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.a();
        } catch (RuntimeException e) {
            System.out.println("caught:" + e.getClass().getSimpleName());
        }
    }
    public void a() { b(); }
    public void b() { c(); }
    public void c() { throw new IllegalStateException("deep"); }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `caught:IllegalStateException`
B. `caught:RuntimeException`
C. `a()`, `b()`, `c()`のいずれかに`throws`宣言が無いためコンパイルエラーになる
D. 実行時に例外が`c()`から`main`まで届かず、`b()`の中で握りつぶされる
E. スタックオーバーフローが発生する

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r14"></a>
## 復習問題14(元:問題14-1 / sample/chap7/14)

```java
import java.io.*;
class Base { void method() throws IOException {} }
class Mid extends Base { @Override void method() throws FileNotFoundException {} }
class Leaf extends Mid { @Override void method() throws java.net.SocketTimeoutException {} }
public class Main {
    public static void main(String[] args) {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`SocketTimeoutException`も`IOException`のサブクラスだから）
B. `Mid`の`method()`の行でコンパイルエラーになる
C. `Leaf`の`method()`の行でコンパイルエラーになる
D. `Base`の`method()`の行でコンパイルエラーになる
E. 3クラスとも無関係にコンパイルエラーになる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r15"></a>
## 復習問題15(元:問題14-2 / sample/chap7/14)

```java
import java.io.*;
class Base { void method() throws IOException {} }
class Mid extends Base { @Override void method() throws FileNotFoundException {} }
class Leaf extends Mid { @Override void method() {} }
public class Main {
    public static void main(String[] args) {
        Base b = new Leaf();
        try {
            b.method();
            System.out.println("called");
        } catch (IOException e) {
            System.out.println("caught");
        }
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `called` が出力される
B. `caught` が出力される
C. `Leaf`が例外を宣言していないので、`catch (IOException e)`が原因でコンパイルエラーになる（不要な`catch`）
D. `b.method();`の行でコンパイルエラーになる（`Leaf`が`IOException`を投げないため）
E. 実行時に`ClassCastException`がスローされる

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r16"></a>
## 復習問題16(元:問題15-1 / sample/chap7/15)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("msg:" + e.getMessage());
            System.out.println("cause:" + e.getCause());
        }
    }
    static void methodA() throws Exception {
        try {
            throw new IOException("io-fail");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
msg:io-fail
cause:null
```

B.
```
msg:null
cause:java.io.IOException: io-fail
```

C.
```
msg:java.io.IOException: io-fail
cause:java.io.IOException: io-fail
```

D. `methodA`に`throws IOException`の宣言も必要なため、コンパイルエラーになる

E.
```
msg:java.lang.RuntimeException: io-fail
cause:java.io.IOException: io-fail
```

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r17"></a>
## 復習問題17(元:問題15-2 / sample/chap7/15)

```java
public class Main {
    public static void main(String[] args) {
        try {
            methodB();
        } catch (RuntimeException e) {
            System.out.println("caught:" + e.getMessage());
            System.out.println("cause:" + e.getCause());
        }
    }
    static void methodB() {
        try {
            throw new IllegalStateException("original");
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("wrapped", e);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
caught:wrapped
cause:java.lang.IllegalStateException: original
```

B.
```
caught:original
cause:java.lang.IllegalArgumentException: wrapped
```

C.
```
caught:wrapped
cause:null
```

D. `methodB`に`throws`宣言が無いためコンパイルエラーになる
E. `IllegalStateException`と`IllegalArgumentException`は無関係なのでcatchできず、実行時に異常終了する

**実施記録**

回答：
正解：
迷ったポイント：

<a id="r18"></a>
## 復習問題18(元:問題16-2 / sample/chap7/16)

```java
public class Main {
    public static void main(String[] args) {
        execute(200);
    }
    public static void execute(int value) {
        try {
            if (value > 100) {
                throw new ValueTooLargeException("Too large!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
```

（`ValueTooLargeException`は`Exception`を継承したカスタム例外、`execute`には`throws`宣言が一切無い）このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、実行時に`ValueTooLargeException`がスローされてプログラムが終了する
B. `main`内の`execute(200);`の行でコンパイルエラーになる
C. `execute`メソッド内の`throw e;`の行でコンパイルエラーになる
D. `throw new ValueTooLargeException("Too large!");`の行でコンパイルエラーになる
E. 精密な再スロー(precise rethrow)により、`throws`宣言が無くても自動的に許容される

**実施記録**

回答：
正解：
迷ったポイント：
