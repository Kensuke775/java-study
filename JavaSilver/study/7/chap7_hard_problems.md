# 第7章 サンプル発展問題(1〜16 各2問、計32問)

`sample/chap7/1`〜`16`それぞれについて、難問寄りの発展問題を2問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題1-1・1-2(sample/chap7/1)](#q1)
- [問題2-1・2-2(sample/chap7/2)](#q2)
- [問題3-1・3-2(sample/chap7/3)](#q3)
- [問題4-1・4-2(sample/chap7/4)](#q4)
- [問題5-1・5-2(sample/chap7/5)](#q5)
- [問題6-1・6-2(sample/chap7/6)](#q6)
- [問題7-1・7-2(sample/chap7/7)](#q7)
- [問題8-1・8-2(sample/chap7/8)](#q8)
- [問題9-1・9-2(sample/chap7/9)](#q9)
- [問題10-1・10-2(sample/chap7/10)](#q10)
- [問題11-1・11-2(sample/chap7/11)](#q11)
- [問題12-1・12-2(sample/chap7/12)](#q12)
- [問題13-1・13-2(sample/chap7/13)](#q13)
- [問題14-1・14-2(sample/chap7/14)](#q14)
- [問題15-1・15-2(sample/chap7/15)](#q15)
- [問題16-1・16-2(sample/chap7/16)](#q16)



## 問題1-1(sample/chap7/1)

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

回答：A 正解：C 迷ったポイント： 

解説：
- ループは`i = 1`から`i <= fruits.length(=3)`まで、つまり`i = 1, 2, 3`で回ろうとする。
- `i = 1`で`"Banana"`、`i = 2`で`"Cherry"`が出力される。
- `i = 3`で`fruits[3]`（有効な添字は0,1,2まで）にアクセスした瞬間、`ArrayIndexOutOfBoundsException`がスローされ、キャッチする処理が無いためプログラムはそこで異常終了する。
- `javac`/`java`で検証済み：`Banana` `Cherry`の後に`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`が出力される。

## 問題1-2(sample/chap7/1)

```java
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}, {5, 6}};
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            total += grid[i][2];
        }
        System.out.println(total);
    }
}
```

次のプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `21` が出力される
B. `0` が出力される
C. 何も出力されずにプログラムが異常終了する
D. `grid.length`が原因でコンパイルエラーになる
E. 無限ループになる

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `grid`は3行×2列の二次元配列（各行の長さは2、有効な添字は`0`,`1`のみ）。
- `total += grid[i][2];`は、どの行に対しても存在しない添字`2`にアクセスしようとしている。
- `i = 0`の1回目のループで即座に`grid[0][2]`が範囲外となり`ArrayIndexOutOfBoundsException`がスローされる。`total`への加算や`println`には一度も到達しない。
- `javac`/`java`で検証済み：何も出力されないまま`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2`が出力される。

## 問題2-1(sample/chap7/2)

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

回答：A 正解：E 迷ったポイント：

解説：
- `InvalidAgeException`は`InvalidAgeException(String message)`と`InvalidAgeException(Throwable cause)`という、**どちらも参照型を1つ受け取る**コンストラクタを持っている。
- `null`リテラルはどちらの引数型（`String`・`Throwable`）にも当てはまるため、コンパイラは「どちらを呼びたいのか」を型情報だけからは決定できない。
- `javac`で検証済み：「`InvalidAgeException`の参照はあいまいです」というコンパイルエラーになる（`InvalidAgeException(String)`と`InvalidAgeException(Throwable)`の両方が一致する、という説明付き）。
- 回避するには`(String) null`または`(Throwable) null`のように明示的にキャストして、どちらのコンストラクタを呼びたいかをコンパイラに伝える必要がある。

## 問題2-2(sample/chap7/2)

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

回答：B 正解：D 迷ったポイント：

解説：
- `InvalidAgeException`は`Exception`を継承したチェック例外（`RuntimeException`ではない）。
- `validate`メソッドは`throws InvalidAgeException`を宣言しているので、`validate`自身の定義はコンパイルエラーにならない（Cは誤り）。`throw`自体も、`Exception`（延いては`Throwable`）を継承していれば問題なく行える（Eは誤り）。
- 問題は**呼び出し側**の`main`。チェック例外を投げる可能性がある`validate(-5);`を、`try-catch`で捕まえるか`main`自身に`throws`を宣言するかしていないため、呼び出し箇所でコンパイルエラーになる。
- `javac`で検証済み：「例外`InvalidAgeException`は報告されません。スローするには、捕捉または宣言する必要があります」。

## 問題3-1(sample/chap7/3)

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

回答：D 正解：C 迷ったポイント：

解説：
- `ArrayIndexOutOfBoundsException`は`RuntimeException`のサブクラス。複数`catch`は上から順に走査されるため、継承関係にある例外は**サブクラス（狭い方）を先、スーパークラス（広い方）を後**に書かなければならない。
- 本問は逆順（`RuntimeException`が先、`ArrayIndexOutOfBoundsException`が後）なので、下の`catch`には制御が絶対に届かず、Javaはこれをコンパイルエラーとして弾く。
- `javac`で検証済み：「例外`ArrayIndexOutOfBoundsException`はすでに捕捉されています」。

## 問題3-2(sample/chap7/3)

```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 20};
        try {
            System.out.println(nums[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `5`
B. `null`
C. `Index 5 out of bounds for length 2`
D. `java.lang.ArrayIndexOutOfBoundsException`
E. 何も出力されない

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `nums`は長さ`2`（有効な添字は`0`,`1`）。`nums[5]`で`ArrayIndexOutOfBoundsException`がスローされ、`catch`で捕まる。
- `e.getMessage()`は例外オブジェクトに設定された詳細メッセージを返す。現行JDK（本検証はJDK 17）では「不正な添字」と「配列の長さ」の両方を含む`"Index 5 out of bounds for length 2"`という文字列になる。
- Dのように`e`自体（`toString()`相当）を出力したわけではない点に注意（`e`をそのまま`println`すればクラス名込みの`java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2`になるが、今回は`getMessage()`のみ）。
- `javac`/`java`で検証済み。

## 問題4-1(sample/chap7/4)

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

回答：C 正解：B 迷ったポイント：

解説：
- `i = 0`：`data[0]`は`"A"`が存在するので正常に出力され、`finally`も実行される（`A` `finally`）。
- `i = 1`：`data[1]`は範囲外で`ArrayIndexOutOfBoundsException`。`catch`が捕まえて`"catch"`を出力した後、`throw new RuntimeException("rethrown")`で**別の例外を投げ直す**。
- ここがポイントで、**`catch`ブロックの中で新たに`throw`しても、そのまま伝播する前に必ず`finally`が実行される**（`return`のときと同じ原則）。よって`"finally"`が出力されてから、ようやく`RuntimeException`が`main`の外まで伝播してプログラムが終了する。
- `javac`/`java`で検証済み：`A` `finally` `catch` `finally`の後にスタックトレースが出力される。

## 問題4-2(sample/chap7/4)

```java
public class Main {
    public static void main(String[] args) {
        String[] data = {"A", "B"};
        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(data[i]);
            } catch (NullPointerException e) {
                System.out.println("catch" + i);
            } finally {
                if (i == 2) {
                    continue;
                }
                System.out.println("finally" + i);
            }
        }
        System.out.println("done");
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A.

```
A
finally0
B
finally1
finally2
finally3
done
```

B.

```
A
finally0
B
finally1
finally3
```

C. `catch (NullPointerException e)`の行でコンパイルエラーになる（`ArrayIndexOutOfBoundsException`を捕まえられないため）

D.

```
A
finally0
B
finally1
```

E.

```
A
finally0
B
finally1
finally2
```

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `i = 0, 1`：`data[0]="A"`, `data[1]="B"`は正常に出力され、`finally`内の`if(i==2)`は偽なので`finally0`, `finally1`が出力される。
- `i = 2`：`data[2]`は範囲外で`ArrayIndexOutOfBoundsException`がスローされる。`catch (NullPointerException e)`は型が合わず**マッチしない**ため、この例外は`catch`をすり抜けて伝播しようとする（Cのように、これ自体はコンパイルエラーの理由にはならない。単に「捕まらず伝播するだけ」）。
- `finally`ブロックに入ると`if (i == 2)`が真なので`continue;`が実行される。**`finally`が`continue`で異常完了すると、伝播中だった例外は完全に破棄される**ため、`"finally2"`は出力されないまま次のループ（`i = 3`）へ進む。
- `i = 3`：`data[3]`も範囲外で`ArrayIndexOutOfBoundsException`。今度は`finally`内の`if(i==2)`が偽なので`continue`は実行されず、`"finally3"`が出力されてから`finally`は正常完了する。その結果、`i=3`の例外は破棄されずにそのまま伝播し、`main`の外まで届いてプログラムが異常終了する（`"done"`は出力されない）。
- `javac`/`java`で検証済み：`A` `finally0` `B` `finally1` `finally3`の後にスタックトレースが出力される。

## 問題5-1(sample/chap7/5)

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

回答：D 正解：C 迷ったポイント：

解説：
- `try`内で`x = 1;`の後`method()`が例外をスローするので`x = 2;`には到達しない。
- `catch`で`x = 3;`とした後、`return x;`を実行する。**ここで`return`文の右辺の式`x`はこの時点(値は`3`)で評価され、戻り値として確定する**。
- その後、実際に呼び出し元へ戻る前に`finally`が実行され、`x = 4;`で`x`の値自体は`4`に変わる。しかし**`finally`が独自に`return`していない**ため、`finally`は戻り値には一切関与せず、既に確定していた`3`がそのまま返る。
- 「`finally`で`x`を書き換えたのだから`4`が返るはず」という誤解が起きやすいポイント。`finally`が戻り値を上書きするのは、`finally`自身が`return`（や`throw`）で異常完了したときだけ（問題15参照）で、単に変数の値を変えているだけでは戻り値は変わらない。
- `javac`/`java`で検証済み：出力は`3`。

## 問題5-2(sample/chap7/5)

```java
public class Main {
    static void check(int mode) {
        try {
            if (mode == 1) throw new java.io.FileNotFoundException("fnf");
            if (mode == 2) throw new java.io.IOException("io");
        } catch (java.io.IOException e) {
            System.out.println("caught:" + e.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        check(1);
        check(2);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.

```
caught:IOException
caught:IOException
```

B.

```
caught:FileNotFoundException
caught:FileNotFoundException
```

C.

```
caught:FileNotFoundException
caught:IOException
```

D. `catch (java.io.IOException e)`が`FileNotFoundException`をキャッチできず、1回目の呼び出しで例外が伝播しプログラムが終了する

E. コンパイルエラーになる（`FileNotFoundException`用の`catch`が別途必要）

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `catch (IOException e)`のように**スーパークラス型で指定**すると、`IOException`自身だけでなく、そのサブクラスである`FileNotFoundException`も含めて1つの`catch`でまとめて捕まえられる（Eのように別々の`catch`を用意する必要はない）。
- `e.getClass().getSimpleName()`は`catch`に書かれた**宣言型**ではなく、**実際に生成された例外オブジェクトの実行時の型**を返す。よって`mode=1`では`FileNotFoundException`、`mode=2`では`IOException`とそれぞれ正確に表示される。
- `javac`/`java`で検証済み。

## 問題6-1(sample/chap7/6)

```java
public class Main {
    public static void main(String[] args) {
        try {
            String s = "abc";
            int i2 = Integer.parseInt(s);
            int i1 = s.length();
            System.out.println(i1 + i2);
        } catch (NumberFormatException e) {
            System.out.println("NFE:" + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `NPE`
B. `NFE:For input string: "abc"`
C. `6`（`i1=3`, `i2=3`のような整合の取れた値）
D. `3`
E. 何も出力されない

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `s = "abc"`は`null`ではないので`NullPointerException`は起きない（Aは誤り）。
- `Integer.parseInt(s)`が`s.length()`より**先に実行される**（コードの記述順）。`"abc"`は数値として解析できないので、この時点で`NumberFormatException`がスローされる。
- 例外がスローされた瞬間に`try`ブロックの残り（`s.length()`や`println`）は一切実行されない。よって`i1`や`i2`が実際に計算されることはなく、C・Dのような数値が出力される余地はない。
- `catch (NumberFormatException e)`が先に書かれており、これが型として一致するのでここで捕まる。`e.getMessage()`は`"For input string: \"abc\""`。
- `javac`/`java`で検証済み。

## 問題6-2(sample/chap7/6)

```java
public class Main {
    public static void main(String[] args) {
        String s = null;
        try {
            int i1 = s.length();
        } catch (NumberFormatException e) {
            System.out.println("NFE");
        }
        System.out.println("done");
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `NFE` `done` の順に出力される
B. `done` のみが出力される
C. `s.length()`の行で`NullPointerException`がスローされ、`catch`にマッチせず`main`まで伝播してプログラムが異常終了する（`done`は出力されない）
D. `NullPointerException`は`catch (NumberFormatException e)`で無事キャッチされ、`done`が出力される
E. コンパイルエラーになる（`null`に対するメソッド呼び出しは許可されない）

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- `s`が`null`の状態で`s.length()`という**レシーバへのメンバアクセス**を行っているため、`NullPointerException`がスローされる（これはコンパイル時ではなく実行時のエラー。Eは誤り）。
- 用意されている`catch`は`NumberFormatException`のみで、`NullPointerException`とは無関係な兄弟同士の型なのでマッチしない（Dは誤り）。
- キャッチされなかった例外はそのまま`main`の外まで伝播し、`System.out.println("done");`には到達しないままプログラムが異常終了する。
- 「`null`絡みだから広く例外処理していれば安心」という思い込みに対する引っかけ。`catch`の型は実際にスローされる例外の型と一致（またはその祖先型）していなければ意味がない。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.NullPointerException: ...`が出力され、`done`は出力されない。

## 問題7-1(sample/chap7/7)

```java
public class Main {
    public static void main(String[] args) {
        try {
            method(2);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("caught:" + e.getClass().getSimpleName());
        }
    }
    static void method(int mode) {
        int[] arr = {1, 2};
        if (mode == 1) {
            int x = arr[5];
        } else {
            int y = Integer.parseInt("xx");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `caught:ArrayIndexOutOfBoundsException`
B. `caught:NumberFormatException`
C. `caught:RuntimeException`
D. コンパイルエラーになる（`ArrayIndexOutOfBoundsException`と`NumberFormatException`は継承関係にないため組み合わせられない）
E. 実行時に例外がキャッチされずプログラムが終了する

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `mode = 2`なので`else`側が実行され、`Integer.parseInt("xx")`が`NumberFormatException`をスローする。
- `ArrayIndexOutOfBoundsException`と`NumberFormatException`は互いに無関係な兄弟同士（どちらも`RuntimeException`の子孫だが、直接の親子関係にはない）なので、multi-catchで組み合わせること自体は問題ない（Dは誤り）。
- `e.getClass().getSimpleName()`は実際にスローされた型をそのまま返すので`NumberFormatException`。
- `javac`/`java`で検証済み。

## 問題7-2(sample/chap7/7)

```java
public class Main {
    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("bad");
        } catch (NumberFormatException | IllegalArgumentException e) {
            System.out.println("caught:" + e.getMessage());
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `caught:bad` が出力される
B. `caught:null` が出力される
C. 実行時に`ClassCastException`がスローされる
D. `catch (NumberFormatException | IllegalArgumentException e)`の行でコンパイルエラーになる
E. 問題なくコンパイルは通るが、`NumberFormatException`側の`catch`には実行時に絶対到達しない

**実施記録**

回答：D 正解：D 迷ったポイント：

解説：
- `NumberFormatException`は`IllegalArgumentException`のサブクラス（継承チェーン：`NumberFormatException → IllegalArgumentException → RuntimeException`）。
- multi-catch(`A | B`)で組み合わせられるのは、**互いに無関係な型同士だけ**。継承関係にある型を組み合わせると、「片方がもう片方に包含されて意味がない（冗長）」とコンパイラが判断し、はっきりとしたコンパイルエラーになる（Eのように「コンパイルは通るが無意味」という扱いではない）。
- `javac`で検証済み：「複数catch文の代替をサブクラス化によって関連付けることはできません（代替`NumberFormatException`は代替`IllegalArgumentException`のサブクラスです）」。
- `sample/chap7/7/Sample1.java`の`IOException | Exception`（これも継承関係にある組み合わせ）と全く同じ理由によるエラー。

## 問題8-1(sample/chap7/8)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("/no/such/dir/test.txt");
            fw.write("hello");
            System.out.println("wrote");
        } catch (IOException e) {
            System.out.println("catch:" + e.getClass().getSimpleName());
        } finally {
            if (fw != null) {
                System.out.println("closing");
            } else {
                System.out.println("fw is null, skip close");
            }
        }
    }
}
```

`/no/such/dir/`は存在しないディレクトリだとします。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `wrote` `closing`
B. `catch:IOException` `closing`
C. `catch:FileNotFoundException` `fw is null, skip close`
D. `catch:FileNotFoundException` `closing`
E. コンパイルエラーになる

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- 存在しないディレクトリへの書き込みは`new FileWriter(...)`という**コンストラクタ呼び出しの時点**で失敗する。具体的には`IOException`のサブクラスである`FileNotFoundException`がスローされる（Bのように親クラス名で出力されるわけではない。`getClass()`は実際の型を返す）。
- コンストラクタ呼び出しが失敗すると、その**代入(`fw = ...`)自体が完了しない**ため、`fw`は初期値の`null`のまま。
- `finally`内の`if (fw != null)`は偽になるので、`"fw is null, skip close"`が出力される（A・B・Dのように`fw`が非nullとして扱われることはない）。
- `javac`/`java`で検証済み。

## 問題8-2(sample/chap7/8)

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

回答：B! 正解：B 迷ったポイント：

解説：
- 今回は書き込みが正常に成功するケースなので、外側の`try`で例外は起きず、`fw`には正しく`FileWriter`が代入されている。
- `finally`内の`fw.close()`も正常に成功し、内側の`catch (IOException e)`・`catch (NullPointerException e)`はどちらも発火しない。
- そのまま`"end"`だけが出力される。**外側で例外が起きなかった場合に何が出力されるか**を問う、いわば「引っかけの無いケース」を正確に見抜けるかがポイント（普段は例外が起きるケースばかり練習しがちなので、逆に「起きないケース」の方が見落としやすい）。
- `javac`/`java`で検証済み。

## 問題9-1(sample/chap7/9)

```java
class Res implements AutoCloseable {
    String name;
    Res(String n) { this.name = n; System.out.print("open" + n + " "); }
    public void close() { System.out.print("close" + name + " "); }
}
public class Main {
    public static void main(String[] args) {
        try (Res a = new Res("A"); Res b = new Res("B")) {
            System.out.print("body ");
        }
        System.out.println();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `openA openB body closeA closeB`
B. `openA openB body closeB closeA`
C. `openB openA body closeA closeB`
D. `openA closeA openB closeB body`
E. `body openA openB closeB closeA`

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- 複数リソースの**初期化(コンストラクタ呼び出し)は宣言順(左から右)**に行われる → `openA` → `openB`。
- `try`ブロック本体を実行 → `body`。
- **クローズは宣言と逆順** → `closeB` → `closeA`。
- `javac`/`java`で検証済み：`openA openB body closeB closeA`。

## 問題9-2(sample/chap7/9)

```java
class Res implements AutoCloseable {
    String name;
    Res(String n) { this.name = n; System.out.print("open" + n + " "); }
    public void close() { System.out.print("close" + name + " "); }
}
public class Main {
    public static void main(String[] args) {
        Res a = new Res("A");
        try (a; Res b = new Res("B")) {
            a = new Res("X");
            System.out.print("body ");
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `openA openB body closeB closeA` が出力される
B. `openA openB openX body closeB closeX` が出力される
C. `try (a; ...)`の行でコンパイルエラーになる（`a`は事前宣言後に再代入されているため）
D. `a = new Res("X");`の行でコンパイルエラーになる
E. `try`に渡せるのは`new`で直接生成した式のみで、変数`a`をそのまま渡すこと自体がコンパイルエラーになる

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- Java 9以降、事前に宣言済みの変数をそのまま`try(a)`に渡すことができる（Eは誤り。この機能自体は許可されている）。
- ただし条件があり、**その変数は`try()`に渡す前の時点で、すでにfinalまたは実質的final(effectively final)でなければならない**。
- 本問は`try (a; ...)`より**後**、`try`ブロックの**中**で`a = new Res("X");`と再代入している。「実質的final」は変数のスコープ全体を通して判定されるため、**あとで再代入している事実だけで、`try(a)`の時点まで遡ってエラーになる**（Dのように再代入した行がエラーになるわけではない）。
- `javac`で検証済み：「try-with-resourcesリソースとして使用される変数`a`が、finalでも事実上のfinalでもありません」、エラー行は`try (a; ...)`の方。

## 問題10-1(sample/chap7/10)

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

回答：E 正解：B 迷ったポイント：

解説：
- `try`本体で`RuntimeException`がスローされると、その例外が`catch`に渡される**前**に、`try`ブロックを抜ける処理の一環として**リソースの`close()`が自動的に呼ばれる**。
- つまり実行順は「本体の例外発生」→「暗黙のclose()」→「catchへ例外が渡されて処理」→「finally」という順番になる。「例外が起きたら即座に`catch`に飛ぶ」と思っていると、`close()`が先に挟まることを見落としやすい。
- `javac`/`java`で検証済み：`body close catch finally`。

## 問題10-2(sample/chap7/10)

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        try (FileWriter fw = new FileWriter("p10.txt")) {
            fw.write("x");
        }
        System.out.println("done");
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `catch`が無いためコンパイルエラーになる
B. `finally`が無いためコンパイルエラーになる
C. 問題なくコンパイルが通り、`done`が出力される
D. `try-with-resources`は必ず`catch`か`finally`を伴わなければならず、両方無いのは違反
E. `main`に`throws IOException`を書いてはいけない（`main`はthrowsを宣言できない）

**実施記録**

回答：C 正解：C 迷ったポイント：

解説：
- 通常の`try`文と違い、**try-with-resourcesは`catch`も`finally`も省略してtryブロックのみで成立可能**（A・B・Dはいずれも誤り）。
- リソース(`FileWriter`)のオープンや`write()`、暗黙のclose()が投げうる`IOException`は、`try`の中で捕まえない代わりに、`main`自身に`throws IOException`と宣言することで呼び出し元（JVM）に委ねている。
- `main`メソッドは他の任意のメソッドと同様に`throws`を宣言できる（Eは誤り。`main`だからといって特別な制限は無い）。
- `javac`/`java`で検証済み：正常にコンパイル・実行され`done`が出力される。

## 問題11-1(sample/chap7/11)

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

回答：C 正解：A 迷ったポイント：

解説：
- 宣言順は`b`, `a`なので、クローズは逆順の`a`, `b` → `closeA`が先、`closeB`が後。
- `a`（`ResA`）の`close()`が例外を投げても、**それより後にクローズされるはずだった`b`（`ResB`）の`close()`は独立して必ず実行される**（Bのように途中で打ち切られることはない）。
- `closeA`で発生した`RuntimeException("failA")`は、`try`ブロック本体では何も例外が起きていないので、そのまま主例外として`catch`に渡る → `catch:failA`。
- `javac`/`java`で検証済み：`body closeA closeB catch:failA finally`。

## 問題11-2(sample/chap7/11)

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

回答：A! 正解：B 迷ったポイント：

解説：
- `try`ブロック内で`return`しても、**実際に呼び出し元へ戻る前に、リソースは通常通り逆順(`r2`→`r1`)でクローズされる**（Aのように`return`で素通りされることはない）。
- リソースのクローズが終わった**後**に、通常の`try-finally`のルール通り`finally`が実行される。
- `javac`/`java`で検証済み：`body close2 close1 finally`。

## 問題12-1(sample/chap7/12)

```java
class Rz implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("close ");
        throw new Exception("close-fail");
    }
}
public class Main {
    public static void main(String[] args) {
        try (Rz r = new Rz()) {
            System.out.print("body ");
            throw new RuntimeException("body-fail");
        } catch (Exception e) {
            System.out.print("caught:" + e.getMessage() + " ");
            for (Throwable t : e.getSuppressed()) {
                System.out.print("suppressed:" + t.getMessage() + " ");
            }
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `body close caught:close-fail suppressed:body-fail`
B. `body close caught:body-fail suppressed:close-fail`
C. `body caught:body-fail`（`close-fail`はどこにも出てこない）
D. `body close caught:body-fail`（`getSuppressed()`は空でforループは実行されない）
E. 実行時に2つ目の例外(`close-fail`)により`ClassCastException`がスローされる

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `try`本体で`RuntimeException("body-fail")`が先にスローされる。tryブロックを抜ける際に呼ばれる`close()`でも`Exception("close-fail")`がスローされる。
- **すでに主例外(body側)が存在する場合、close()側の例外はそれを上書きせず、主例外に「抑制された例外(suppressed exception)」として付加される**。伝播するのは`body-fail`の方（Aのように優劣が逆になることはない）。
- `e.getSuppressed()`には`close-fail`が1件入っているので、forループは1回実行される（Dは誤り）。
- `javac`/`java`で検証済み：`body close caught:body-fail suppressed:close-fail`。

## 問題12-2(sample/chap7/12)

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

回答：D! 正解：D 迷ったポイント：

解説：
- `try`本体自体は何も例外を投げないが、**try-with-resourcesは暗黙的に`close()`を呼び出しており、その`close()`が宣言しているチェック例外(`Exception`)は、たとえ本体側で何も起きなくてもコンパイル時のcatch-or-specify解析の対象になる**。
- 用意されている`catch`は`RuntimeException`のみで、`close()`が投げうる`Exception`（チェック例外）を処理できていないため、コンパイルエラーになる（本体が例外を投げるかどうかは無関係）。
- `AutoCloseable`インタフェースの`close()`は元々`throws Exception`と宣言されているので、実装クラスが`throws Exception`を書くこと自体は正当（Eは誤り）。
- `javac`で検証済み：「報告されない例外`Exception`は、スローするには捕捉または宣言する必要があります」（「リソース変数'r'でのclose()の暗黙的なコールから例外がスローされました」という補足付き）。

## 問題13-1(sample/chap7/13)

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

回答：A 正解：D 迷ったポイント：

解説：
- `checkedA()`は自分自身の中で`checkedB()`（`throws ClassNotFoundException`）を呼んでいるが、`checkedA()`自身も`throws ClassNotFoundException`を宣言しているので、この呼び出し自体は問題ない（Cは誤り）。同様に`checkedA()`が`IOException`を宣言していること自体も問題ない（Bは誤り）。
- 問題は呼び出し元の`main`。`checkedA()`は`IOException`と`ClassNotFoundException`という2つのチェック例外を宣言しているが、`main`はどちらも`try-catch`で捕まえておらず、`throws`宣言もしていない。
- `javac`で検証済み：`obj.checkedA();`の行で「例外`IOException`は報告されません。スローするには、捕捉または宣言する必要があります」。

## 問題13-2(sample/chap7/13)

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

回答：A! 正解：A 迷ったポイント：

解説：
- `IllegalStateException`は`RuntimeException`のサブクラス、つまり**非チェック例外**。`a()`, `b()`, `c()`のどのメソッドにも`throws`宣言は不要で、コンパイルは問題なく通る（Cは誤り）。
- 非チェック例外は、`c()`→`b()`→`a()`→`main`と、途中に`catch`が無ければ**何段でも自動的に伝播していく**（Dのように途中で握りつぶされることはない）。
- `e.getClass().getSimpleName()`は実際にスローされたクラス名(`IllegalStateException`)を返す。`catch (RuntimeException e)`は`IllegalStateException`を包含する広い型で捕まえているだけで、`e`自体の実行時の型が変わるわけではない（Bは誤り）。
- `javac`/`java`で検証済み。

## 問題14-1(sample/chap7/14)

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

回答：A 正解：C 迷ったポイント：

解説：
- オーバーライドの例外ルールは「**直接の親が宣言した型のサブタイプであること**」で判定される。`Leaf`が実際にオーバーライドしているのは`Base`の`method()`ではなく、直接の親である`Mid`の`method() throws FileNotFoundException`。
- `java.net.SocketTimeoutException`は`IOException`のサブクラスではあるが、`FileNotFoundException`の**サブクラスでも同じ型でもない**（両方とも`IOException`の子孫同士の兄弟）。「`IOException`の子孫だから大元のBaseに対しては狭めている」は関係なく、**あくまで直接の親であるMidの宣言と比較される**という点が今回のポイント（Aは誤り）。
- `Base`・`Mid`自体の宣言はそれぞれの直接の親（`Base`は誰も継承していない、`Mid`は`Base`の`IOException`に対して`FileNotFoundException`できちんと狭めている）を正しく満たしているのでエラーにならない（B・Dは誤り）。
- `javac`で検証済み：「`Leaf`の`method()`は`Mid`の`method()`をオーバーライドできません（オーバーライドされたメソッドは`SocketTimeoutException`をスローしません）」。

## 問題14-2(sample/chap7/14)

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

回答：E! 正解：A 迷ったポイント：

解説：
- `b`の**静的型(宣言型)は`Base`**であり、コンパイラは`b.method()`の呼び出しを、実体が`Leaf`かどうかに関わらず`Base.method()`（`throws IOException`）の宣言だけを見てチェックする。よって`catch (IOException e)`はごく普通に許可される（Cは誤り。「投げない可能性がある」だけであって「投げてはいけない」わけではないので、備えのための`catch`は無駄にはなってもコンパイルエラーにはならない）。
- 実際には`Leaf.method()`は何も例外を投げないよう実装されている（オーバーライドで例外を「無くす」のは狭める方向の極端形として合法）。
- 実行してみると、`b.method()`自体は何も例外を投げずに正常終了し、続く`System.out.println("called");`が実行される。`catch`ブロックの中身が実行される出番は無い。
- `javac`/`java`で検証済み：`called`が出力される。

## 問題15-1(sample/chap7/15)

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

回答：A! 正解：C 迷ったポイント：

解説：
- `methodA`は元の`IOException`を`catch`した上で、`new RuntimeException(e)`という**`Throwable cause`のみを受け取るコンストラクタ**で包んで投げ直している（`IOException`自体はcatchして処理済みなので、`methodA`に改めて`throws IOException`を宣言する必要はない。Dは誤り）。
- `Throwable(Throwable cause)`コンストラクタは、メッセージを明示的に渡さなかった場合、**`cause`の`toString()`を自動的にメッセージとして設定する**。`cause.toString()`は「クラス名: メッセージ」の形式(`java.io.IOException: io-fail`)になる。
- よって`e.getMessage()`は`null`にはならず`"java.io.IOException: io-fail"`（Bは誤り）。`e.getCause()`は元の`IOException`オブジェクトそのものなので、`println`すれば同じく`toString()`形式で表示され、結果的に`msg`と`cause`は同じ文字列になる。
- `javac`/`java`で検証済み。

## 問題15-2(sample/chap7/15)

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

回答：C 正解：A 迷ったポイント：

解説：
- `IllegalArgumentException(String message, Throwable cause)`という**両方を明示的に指定するコンストラクタ**を使っているので、`getMessage()`は明示的に渡した`"wrapped"`、`getCause()`は明示的に渡した元の例外(`IllegalStateException("original")`)がそのまま返る（問題15-1の「causeのみ」パターンとの対比）。
- どちらの例外も`RuntimeException`の子孫（非チェック例外）なので、`methodB`に`throws`宣言は不要（Dは誤り）。`IllegalStateException`は`catch`されて処理済みであり、実際に`main`まで伝播するのは新しく投げ直された`IllegalArgumentException`（`RuntimeException`型の`catch`で問題なく捕まる。Eは誤り）。
- `javac`/`java`で検証済み。

## 問題16-1(sample/chap7/16)

```java
public class Main {
    public static void main(String[] args) {
        try {
            execute(-5);
        } catch (ValueTooSmallException | ValueTooLargeException e) {
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
        }
    }
    public static void execute(int value) throws ValueTooLargeException, ValueTooSmallException {
        try {
            if (value < 0) {
                throw new ValueTooSmallException("Too small!");
            } else if (value > 100) {
                throw new ValueTooLargeException("Too large!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
```

（`ValueTooLargeException`・`ValueTooSmallException`はともに`Exception`を継承したカスタム例外）次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Exception:Too small!`
B. `ValueTooSmallException:Too small!`
C. `execute`メソッド内の`catch (Exception e) { throw e; }`の行でコンパイルエラーになる（`Exception`型を`throws ValueTooLargeException, ValueTooSmallException`で宣言されたメソッドから投げているため）
D. `main`側の`catch (ValueTooSmallException | ValueTooLargeException e)`が`Exception`型を受け取れずコンパイルエラーになる
E. 実行時に`ClassCastException`がスローされる

**実施記録**

回答：B 正解：B 迷ったポイント：

解説：
- `catch (Exception e) { throw e; }`という書き方は、宣言上の型こそ`Exception`だが、Javaコンパイラは「この`catch`ブロックに実際に飛び込んでくる可能性があるのは、対応する`try`内で投げられている`ValueTooSmallException`と`ValueTooLargeException`だけ」と、より精密に解析する（**精密な再スロー(precise rethrow)**という機能）。そのため`execute`メソッドが`throws ValueTooLargeException, ValueTooSmallException`とだけ宣言していても、この`throw e;`はコンパイルエラーにならない（Cは誤り）。
- `e.getClass().getSimpleName()`は実際にスローされたクラス名(`ValueTooSmallException`)をそのまま返す。`catch`の宣言型や`Exception`という見た目に引きずられて`A`を選ばないように注意。
- `main`側のmulti-catchも、`execute`の`throws`宣言と型が一致しているので問題なくコンパイルが通る（Dは誤り）。
- `javac`/`java`で検証済み：`ValueTooSmallException:Too small!`。

## 問題16-2(sample/chap7/16)

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

**実施記録** 回答：C! 正解：C 迷ったポイント：

解説：
- 精密な再スロー(問題16-1参照)は、あくまで「**そのメソッド自身が`throws`で宣言している型の範囲内でなら**、`catch (Exception e) { throw e; }`のように広い型でキャッチしても、実際にスローされる精密な型で許容してくれる」という機能であって、「`throws`宣言そのものを不要にする」機能ではない（Eは誤り）。
- 今回の`execute`メソッドには`throws`宣言が一切無い。`try`ブロック内で`throw`した時点(`ValueTooLargeException`を生成する行自体)はメソッド内なので問題ないが（Dは誤り）、それを`catch (Exception e) { throw e; }`で**チェック例外のまま外へ投げ直そうとしている箇所自体**が、宣言も`catch`も無いままチェック例外を外に漏らそうとしている状態になり、そこでコンパイルエラーになる。
- `main`側の`execute(200);`自体は、`execute`メソッドの宣言（今回は不完全でコンパイルが通らない）が確定しない限り評価できないため、Bのように呼び出し側が直接の原因になるわけではない。
- `javac`で検証済み：`throw e;`の行で「例外`ValueTooLargeException`は報告されません。スローするには、捕捉または宣言する必要があります」。