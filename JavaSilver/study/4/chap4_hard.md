# 第4章 サンプル発展問題(1〜13・ex1,3,5,6,7,8,9,10,11,12,13,14,15,16 各1問、計27問)

`sample/chap4/1`〜`13`・`ex1,3,5,6,7,8,9,10,11,12,13,14,15,16`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み（無限ループになる問題は検証後に強制終了し、結果を確認済み）。

## 目次

- [問題1(sample/chap4/1)](#q1)
- [問題2(sample/chap4/2)](#q2)
- [問題3(sample/chap4/3)](#q3)
- [問題4(sample/chap4/4)](#q4)
- [問題5(sample/chap4/5)](#q5)
- [問題6(sample/chap4/6)](#q6)
- [問題7(sample/chap4/7)](#q7)
- [問題8(sample/chap4/8)](#q8)
- [問題9(sample/chap4/9)](#q9)
- [問題10(sample/chap4/10)](#q10)
- [問題11(sample/chap4/11)](#q11)
- [問題12(sample/chap4/12)](#q12)
- [問題13(sample/chap4/13)](#q13)
- [問題ex1(sample/chap4/ex1)](#qex1)
- [問題ex3(sample/chap4/ex3)](#qex3)
- [問題ex5(sample/chap4/ex5)](#qex5)
- [問題ex6(sample/chap4/ex6)](#qex6)
- [問題ex7(sample/chap4/ex7)](#qex7)
- [問題ex8(sample/chap4/ex8・複数選択)](#qex8)
- [問題ex9(sample/chap4/ex9)](#qex9)
- [問題ex10(sample/chap4/ex10)](#qex10)
- [問題ex11(sample/chap4/ex11)](#qex11)
- [問題ex12(sample/chap4/ex12)](#qex12)
- [問題ex13(sample/chap4/ex13)](#qex13)
- [問題ex14(sample/chap4/ex14)](#qex14)
- [問題ex15(sample/chap4/ex15)](#qex15)
- [問題ex16(sample/chap4/ex16)](#qex16)

<a id="q1"></a>
## 問題1(sample/chap4/1)

```java
public class Main {
    public static void main(String[] args) {
        int b = 1;
        while (b <= 5) {
            b++;
            System.out.print(b);
        }
        System.out.println();
        System.out.println("b:" + b);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `12345` の後 `b:5`
B. `23456` の後 `b:6`
C. `12345` の後 `b:6`
D. `23456` の後 `b:5`
E. 無限ループになる

**解答**

正解：**B**

**補足**

- `b++`が`System.out.print(b)`より**先**に実行される点がポイント。ループの各周で、まず`b`をインクリメントしてから、その**インクリメント後の値**を出力する。
- `b=1`(条件`1<=5`true)→`b=2`,出力`2`。`b=2`(true)→`b=3`,出力`3`。…`b=5`(true)→`b=6`,出力`6`。`b=6`で条件`6<=5`が`false`になり終了。
- 出力される数字が`1`からではなく`2`から始まる点、そして最後の`b`が`5`ではなく`6`になっている点の両方が引っかかりやすい。
- `javac`/`java`で検証済み：`23456` / `b:6`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap4/2)

```java
public class Main {
    public static void main(String[] args) {
        int b = 5;
        while (b >= 0)
            b--;
        System.out.print(b);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `0`
B. `-1`
C. 無限ループになる（`int`は`0`未満にならないよう自動的に止まる）
D. `5`
E. コンパイルエラーになる（`while`の中身に`{}`が無い）

**解答**

正解：**B**

**補足**

- `int`型には「0未満になれない」というような自動的な歯止めは無い。負の数も普通に表現できる（Cは誤り）。
- `b=5,4,3,2,1,0`はいずれも`b >= 0`が`true`なのでループが続き、`b`が`-1`になった時点で初めて`b >= 0`が`false`になりループを抜ける。
- `while`の中身が`{}`で囲まれていない単一の文であっても、これまで見てきた`if`文と同様に問題なく成立する（Eは誤り）。
- `javac`/`java`で検証済み：`-1`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap4/3)

```java
public class Main {
    public static void main(String[] args) {
        int b = 1;
        do
            System.out.print(b + " ");
        while ((b += 2) < 10);
        System.out.println();
        System.out.println("b:" + b);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1 3 5 7 9 ` の後 `b:11`
B. `1 3 5 7 9 ` の後 `b:9`
C. `3 5 7 9 ` の後 `b:11`（1回目のインクリメント後から出力が始まる）
D. コンパイルエラーになる（`do`ブロックに`{}`が無いのに、`while`条件の中で複合代入演算子を使っている）
E. 無限ループになる

**解答**

正解：**A**

**補足**

- `do`ブロックに`{}`が無くても、その直後の1文だけを対象にした`do-while`文として正当に成立する（Dは誤り）。
- `do`の中身（`print`）が**先に必ず1回実行**され、その**後**で`(b += 2) < 10`という条件式が評価される。この複合代入は「`b`に`2`を足した上で、その足した後の値を使って比較する」という1つの式として機能する。
- `b=1`で出力「1 」→条件評価で`b=3`,`3<10`true→出力「3 」→`b=5`,true→出力「5 」→`b=7`,true→出力「7 」→`b=9`,true→出力「9 」→`b=11`,`11<10`false→終了。
- 出力された数字の個数(5個: 1,3,5,7,9)と、ループを抜けた時点の`b`の値(11、条件判定のために最後にもう一度足された分も含む)がズレる点に注意。
- `javac`/`java`で検証済み：`1 3 5 7 9 ` / `b:11`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap4/4)

```java
public class Main {
    public static void main(String[] args) {
        int a = 1;
        while (a > 10) {
            System.out.print(a + " ");
            a--;
        }
        System.out.println("while-done a:" + a);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `while-done a:1`（`while`ブロックは1回も実行されない）
B. `1 ` の後 `while-done a:0`（少なくとも1回は実行される）
C. 無限ループになる（`a`が減り続けるが`10`を超えることはないため）
D. コンパイルエラーになる（`while`の条件が最初から`false`になることが分かる場合は書けない）
E. `1 ` の後 `while-done a:1`

**解答**

正解：**A**

**補足**

- `while`文は、ブロックに入る**前**に条件を評価する。`a=1`の時点で`a > 10`はすでに`false`なので、ブロックの中身は**1回も実行されない**（B・Eは誤り、`do-while`と違って最低1回の実行は保証されない）。
- `a`が書き換えられることもないので、そのまま最後の`println`だけが実行される。
- コンパイル時に「この条件は最初からfalseになる」ことを検出して拒否するような仕組みは無い（Dは誤り。定数`false`そのものを書いた場合の到達不能コード判定とは別の話）。
- `javac`/`java`で検証済み：`while-done a:1`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap4/5)

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 5; i > 0; i--) {
            System.out.print(i);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `12345`
B. `54321`
C. `543210`
D. `5432`
E. 無限ループになる

**解答**

正解：**B**

**補足**

- `for`の3要素はそれぞれ「初期化式(`i=5`、最初に1回だけ)」「継続条件(`i>0`、毎回チェック)」「更新式(`i--`、本体実行後に毎回)」という役割。
- `i=5`(条件`5>0`true)→出力`5`→更新`i=4`。`4>0`true→出力`4`→`i=3`。…`1>0`true→出力`1`→`i=0`。`0>0`はfalseとなりここで終了(`0`は出力されない。Cは誤り)。
- `javac`/`java`で検証済み：`54321`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap4/6)

`sample/chap4/6/Main.java`には、次のようなコードが含まれています（`\n`のつもりで`¥n`(円記号+n)と書かれています）。

```java
for (var a = 0; a < 5; a++)
    System.out.print(a);
System.out.println("¥n----");
```

このコードを実行するとどうなりますか。（1つ選択）

A. `01234` の後、改行してから`----`が出力される（`¥n`は`\n`と同じ意味に解釈される）
B. `01234¥n----` という1行がそのまま出力される（`¥n`は改行として機能せず、文字としてそのまま表示される）
C. `¥`(円記号)が不正な文字としてコンパイルエラーになる
D. `01234`のみが出力され、`println`の行は無視される
E. 実行時に文字コード変換の例外がスローされる

**解答**

正解：**B**

**補足**

- **ダブルクォートで囲まれた文字列リテラルの中**では、`¥`(円記号、U+00A5)は特にエスケープ文字として扱われず、**ただの1文字**として解釈される（バックスラッシュ`\`と違って、`\n`のような特別な意味を持たない）。
- そのためこの行は文法的には完全に正当な文字列リテラルであり、**コンパイルは通ってしまう**（Cは誤り）。しかし実行結果は「改行してから`----`」ではなく、「`¥n----`という文字の並びがそのまま1行で出力される」という、意図とは異なる結果になる。
- 文字リテラル（`'¥u0061'`のような1文字）の場合は即座にコンパイルエラーになったが（第2・3章参照）、**文字列リテラルの中では、単に「見た目が期待と違うだけの、正常に動くコード」になってしまう**という、より発見しにくいタイプの不具合になる点に注意。
- `javac`/`java`で検証済み（`sample/chap4/6/Main.java`を実際に実行）：`01234¥n----`という1行がそのまま出力される（`sample/chap4/8/Main.java`にも同じ`¥n`が使われており、同様の結果になることを確認済み）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q7"></a>
## 問題7(sample/chap4/7)

```java
public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        for (int e : array) {
            e *= 2;
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.print(array[0] + " " + array[1] + " " + array[2]);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `20 40 60 ` の後 `20 40 60`（配列の中身自体も書き換わる）
B. `20 40 60 ` の後 `10 20 30`
C. `10 20 30 ` の後 `10 20 30`（`e *= 2`が反映されない）
D. コンパイルエラーになる（拡張for文のループ変数は再代入できない）
E. `20 40 60 ` の後 `10 20 30`だが、2回目にforループを回すと今度は反映される

**解答**

正解：**B**

**補足**

- 拡張for(`for (int e : array)`)のループ変数`e`は、配列の各要素の**値のコピー**を受け取るだけの、独立したローカル変数。`e`を書き換えても、それは`e`というコピー先の変数を書き換えているだけで、**元の配列`array`の要素そのものには一切影響しない**（A・Cは誤り）。
- 拡張forのループ変数への再代入自体は文法上禁止されていない（`final`を付けない限り。Dは誤り）。
- ループ後に`array`自身の中身を確認すると、`e *= 2`を行う前の元の値(`10 20 30`)のまま変わっていない。
- `javac`/`java`で検証済み：`20 40 60 ` / `10 20 30`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q8"></a>
## 問題8(sample/chap4/8)

`sample/chap4/8/Main.java`にも問題6と同じ`¥n`（円記号+n）が使われています。

```java
public class Main {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana"};
        for (var v : fruits)
            System.out.print(v + " ");
        System.out.println("¥n----");
    }
}
```

このプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Apple Banana ` の後、改行して`----`
B. `Apple Banana ¥n----` が1行でそのまま出力される
C. コンパイルエラーになる
D. `Apple Banana `のみ出力され、`println`の行は実行されない
E. `var`を拡張for文のループ変数に使うこと自体がコンパイルエラーになる

**解答**

正解：**B**

**補足**

- 問題6と同じ理由。文字列リテラルの中の`¥`は特別なエスケープとしては機能せず、そのままの文字として出力される。
- `var`は拡張for文のループ変数の型推論にも問題なく使える（Eは誤り）。`v`は`fruits`の要素と同じ`String`型と推論される。
- `javac`/`java`で検証済み：`Apple Banana ¥n----`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q9"></a>
## 問題9(sample/chap4/9)

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.print(i);
            if (i % 5 == 0) {
                String s = " ...";
                System.out.println(s);
            }
        }
        System.out.println(s);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`12345 ...6`のような出力になる
B. `String s = " ...";`の行でコンパイルエラーになる（`for`ループの中で新しい変数は宣言できない）
C. 最後の`System.out.println(s);`の行でコンパイルエラーになる（`s`が参照できるスコープの外にあるため）
D. `if (i % 5 == 0)`の判定が`i=5`のとき`true`になることはない
E. 実行時に`s`が`null`として扱われ、最後の行で何も出力されない

**解答**

正解：**C**

**補足**

- `String s`は`if`ブロックの中で宣言されているので、**そのブロックを抜けた時点でスコープも終わる**。`for`ループの外にある最後の`println(s)`からは、この`s`は一切見えない（存在しないものとして扱われる）。
- `for`ループの中で新しい変数を宣言すること自体は普通に行われる（Bは誤り）。
- `i % 5 == 0`は`i=5`のときに`true`になる（Dは誤り）。
- 参照できない変数の使用はコンパイル時に検出されるため、実行時まで問題が持ち越されることはない（Eは誤り）。
- `javac`で検証済み：最後の`System.out.println(s);`の行で「シンボルを見つけられません（シンボル: 変数s）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q10"></a>
## 問題10(sample/chap4/10)

```java
public class Main {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4, 5}};
        int count = 0;
        for (int[] x : array) {
            count += x.length;
        }
        System.out.println(count);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `2`（`array.length`がそのまま使われる）
B. `4`
C. `5`
D. コンパイルエラーになる（内側の配列の長さが揃っていないため拡張forで使えない）
E. 実行時に例外がスローされる

**解答**

正解：**C**

**補足**

- `array`は「長さ2の配列」と「長さ3の配列」という、要素数の異なる2つの配列を持つギザギザ配列。この構造自体は拡張forで問題なく扱える（Dは誤り、各行の長さが揃っている必要は無い）。
- 拡張forの`x`には、`array`の各要素である`int[]`（1回目は`{1,2}`、2回目は`{3,4,5}`）が順に代入される。
- `x.length`は1回目が`2`、2回目が`3`。合計`count = 2 + 3 = 5`。
- `javac`/`java`で検証済み：`5`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q11"></a>
## 問題11(sample/chap4/11)

```java
public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            if (i == 3) {
                break;
            }
        }
        System.out.println("i:" + i);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `i:3`
B. `i:2`
C. 無限ループになる（`while(true)`は`break`があっても止まらない）
D. `i:0`
E. コンパイルエラーになる（`while(true)`は到達不能コードとして扱われる）

**解答**

正解：**A**

**補足**

- `while (true)`は本来止まらないループだが、内部で明示的に`break`を書くことで、その`break`に到達した時点でループを脱出できる（Cは誤り）。`while(true) { ... }`のように、ループの内部にコードがあり、その中に`break`があるという構造は到達不能コード扱いにはならない（Eは誤り。「絶対に実行されないコード」ではなく「無条件に実行されるコード」なので問題ない）。
- `i`は`1`,`2`,`3`と増え、`i==3`になった時点で`break`が実行されループを抜ける。
- `javac`/`java`で検証済み：`i:3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q12"></a>
## 問題12(sample/chap4/12)

```java
public class Main {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                continue;
            }
            total += i;
        }
        System.out.println(total);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `55`（1から10までの合計）
B. `37`
C. `18`（3の倍数だけの合計）
D. `0`（`continue`のせいでループ自体が止まってしまう）
E. コンパイルエラーになる

**解答**

正解：**B**

**補足**

- `continue`は、その回のループ本体の残りの処理をスキップして、**次の周の継続条件チェック・更新式へ即座に進む**もの。ループ全体を止めるものではない（Dは誤り）。
- `i`が`3`の倍数(`3, 6, 9`)のときだけ`continue`が実行され、`total += i;`がスキップされる。それ以外(`1,2,4,5,7,8,10`)は普通に合計に加算される。
- `1+2+4+5+7+8+10 = 37`。（1〜10の合計`55`からスキップされた`3+6+9=18`を引いた値と一致する）。
- `javac`/`java`で検証済み：`37`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q13"></a>
## 問題13(sample/chap4/13)

```java
public class Main {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    continue outer;
                }
                System.out.print("i:" + i + " j:" + j + " ");
            }
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `i:0 j:0 i:1 j:0 i:2 j:0 `
B. `i:0 j:0 i:0 j:1 i:1 j:0 i:1 j:1 i:2 j:0 i:2 j:1 `
C. `i:0 j:0 `のみ（`continue outer`が最初に実行された時点でプログラム自体が終了する）
D. コンパイルエラーになる（ラベルの直後には`for`文以外を書けない）
E. 無限ループになる

**解答**

正解：**A**

**補足**

- `continue outer;`は、内側の`for`だけでなく、**ラベル`outer`が付いた外側の`for`の「次の周」まで一気にスキップする**。「内側のループを抜けて、外側のループの継続条件チェック・更新式に進む」という動きになる（プログラム自体が終了するわけではない。Cは誤り）。
- 各`i`について、内側`j=0`のときだけ出力(`j==1`にはまだなっていないので`continue`されない)。`j=1`になった瞬間に`outer`まで一気に抜けるので、`j=2`に到達することは無い（Bは誤り）。
- ラベル(`outer:`)は`for`文に限らず、任意の文の前に置ける文法要素（Dは誤り。今回はたまたま`for`文に付けている）。
- `javac`/`java`で検証済み：`i:0 j:0 i:1 j:0 i:2 j:0 `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex1"></a>
## 問題ex1(sample/chap4/ex1)

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        while (x > 5) {
            System.out.print(x-- + " ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `10 9 8 7 6 `
B. `10 9 8 7 6 5 `
C. `9 8 7 6 5 `
D. `10 9 8 7 `
E. 無限ループになる（`x--`が条件の`x > 5`に反映されないため）

**解答**

正解：**A**

**補足**

- `x--`（後置デクリメント）は「現在の`x`の値を式の値として使ってから、その後で`x`を減らす」という動作。`print`には**減らす前の値**が渡される。
- `x`の値が減っていくことは、次の周のループ継続条件の判定に確実に反映される（Eは誤り。「式の中の副作用が反映されない」ということはない）。
- `x=10`(条件`10>5`true)→出力`10`,その後`x=9`。`9>5`true→出力`9`,`x=8`。…`6>5`true→出力`6`,`x=5`。`5>5`falseで終了(`5`自体は出力されない。Bは誤り)。
- `javac`/`java`で検証済み：`10 9 8 7 6 `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex3"></a>
## 問題ex3(sample/chap4/ex3)

```java
public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60};
        int count = array.length;
        while (count > 1) {
            count--;
            System.out.print(array[--count] + " ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `60 40 20 `
B. `50 30 10 `
C. `60 50 40 30 20 `
D. `50 30 `
E. 実行時に`ArrayIndexOutOfBoundsException`がスローされる

**解答**

正解：**B**

**補足**

- ループの1周ごとに、`count--;`（単独文）と`array[--count]`の中の`--count`（式の中の前置デクリメント）の**2回、`count`が減っている**という点が最大の引っかけポイント。
- 初期値`count = 6`（配列の長さ）。1周目：`count--`で`5`、続けて`array[--count]`の`--count`で`4`、`array[4]=50`を出力。`count`は`4`。
- `count > 1`（`4>1`）で継続。2周目：`count--`で`3`、`--count`で`2`、`array[2]=30`を出力。`count`は`2`。
- `count > 1`（`2>1`）で継続。3周目：`count--`で`1`、`--count`で`0`、`array[0]=10`を出力。`count`は`0`。
- `count > 1`（`0>1`）は`false`で終了。
- `javac`/`java`で検証済み：`50 30 10 `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex5"></a>
## 問題ex5(sample/chap4/ex5)

```java
public class Main {
    public static void main(String[] args) {
        // args に "1", "2", "3" が渡されたとする
        int v = 0, w = 0;
        for (String s : args) {
            v += ++w + Integer.parseInt(s);
        }
        System.out.println(v);
    }
}
```

コマンドライン引数として`"1" "2" "3"`の3つを渡して実行した場合、何が出力されますか。（1つ選択）

A. `6`（`args`の数値の合計のみ）
B. `12`
C. `9`（`w`の値が全て`3`になったものとして扱われる）
D. `3`（最後の1回分の値だけが残る）
E. コンパイルエラーになる（拡張forのループ変数`args`は`main`の引数と名前が同じため使えない）

**解答**

正解：**B**

**補足**

- `++w`（前置インクリメント）は、`w`をインクリメントした**後**の値をその場で使う。1周目`w`は`0→1`、2周目`1→2`、3周目`2→3`。
- 各周で`v += (++wの値) + (その周の引数をintに変換した値)`が加算される。
- 1周目(`s="1"`)：`v += 1 + 1 = 2` → `v=2`。2周目(`s="2"`)：`v += 2 + 2 = 4` → `v=6`。3周目(`s="3"`)：`v += 3 + 3 = 6` → `v=12`。
- 拡張forのループ変数名は、`main`の仮引数名(`args`)と同じ名前を使わなければ何でもよい。今回は`s`という別名を使っているので特に問題は無い（Eの前提自体がずれている）。
- `javac`/`java`で検証済み（引数`"1" "2" "3"`を渡して実行）：`12`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex6"></a>
## 問題ex6(sample/chap4/ex6)

```java
public class Main {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int a = 0, b = 1;
        for (a = chars.length - b; a > b; a -= 2) {
            System.out.print(chars[a]);
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `fd`
B. `fdb`
C. `edc`
D. `fed`
E. 実行時に`ArrayIndexOutOfBoundsException`がスローされる

**解答**

正解：**A**

**補足**

- `chars.length`は`6`、`b=1`なので初期値`a = 6 - 1 = 5`。
- `a > b`（`5 > 1`）が`true`の間、`chars[a]`を出力してから`a -= 2`。
- `a=5`：出力`chars[5]='f'`→`a=3`。`3>1`true：出力`chars[3]='d'`→`a=1`。`1>1`はfalseで終了。
- `chars[1]`(`'b'`)には到達しないので出力は`fd`のみ（Bは誤り）。
- `javac`/`java`で検証済み：`fd`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex7"></a>
## 問題ex7(sample/chap4/ex7)

```java
public class Main {
    public static void main(String[] args) {
        String[] array = {"A ", "B "};
        for (final String s : array) {
            s += s.toLowerCase();
            System.out.print(s);
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`A aB b`のように出力される
B. `s += s.toLowerCase();`の行でコンパイルエラーになる（`final`なループ変数への再代入）
C. `for (final String s : array)`の行でコンパイルエラーになる（拡張forのループ変数に`final`は付けられない）
D. 実行時に`s`が変更不可能な例外をスローする
E. `final`を付けても、ループの各周で新しく変数が用意されるため問題なくコンパイルできる

**解答**

正解：**B**

**補足**

- 拡張forのループ変数に`final`を付けること自体は文法上可能（Cは誤り）。「ループの各周で、その周専用の`final`な変数として扱われる」という考え方はある意味正しいが（Eの前半の発想）、`s += ...`は`s`という**同じ変数への再代入**にあたるため、`final`である以上その周の中であっても許されない（Eは誤り、初期化(配列要素の代入)以降の再代入が問題になる）。
- `+=`のような複合代入演算子も、内部的には「新しい値を計算して同じ変数に代入し直す」という再代入の一種として扱われる。
- コンパイル時点で検出される問題なので、実行時例外にはならない（Dは誤り）。
- `javac`で検証済み：「変数`s`はすでに代入されている可能性があります」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8(sample/chap4/ex8・複数選択)

```java
public class Main {
    public static void main(String[] args) {
        do
            System.out.print("*");
        while (false);

        while (1 == 2)
            System.out.print("*");
    }
}
```

このプログラムについて、正しい記述をすべて選んでください。（複数選択）

A. `do ... while (false);`の部分は問題なくコンパイルでき、`*`が1回だけ出力される
B. `while (1 == 2) System.out.print("*");`の部分も問題なくコンパイルできる
C. `while (1 == 2) System.out.print("*");`の行はコンパイルエラーになる（コンパイラが`1 == 2`を常に`false`と判定し、本体を到達不能コードとみなすため）
D. `do-while(false)`は本体が1回も実行されないループとして扱われる
E. `while`と`do-while`はどちらも「条件が定数的にfalseだと分かる場合、本体が到達不能コードとしてコンパイルエラーになる」という同じルールに従う

**解答**

正解：**A、C**

**補足**

- `do`ブロックは**必ず先に1回実行してから**条件を判定する構造なので、たとえ条件が最初から`false`だと分かっていても、本体（`System.out.print("*")`）は**必ず1回は実行されうる**、つまり到達可能なコードである。よって`do ... while(false);`は問題なくコンパイルでき、`*`が1回出力される（A正しい、Dは誤り、「1回も実行されない」わけではなく「1回だけ実行される」）。
- 一方`while`は**先に条件を判定してから**本体に入る構造。`1 == 2`のように**コンパイル時に定数として`false`だと確定できる条件**の場合、コンパイラは「この本体には絶対に制御が到達しない」と判断し、**到達不能コードとして明確なコンパイルエラー**にする（Bは誤り、Cが正しい）。
- つまり`while`と`do-while`は、同じ「条件が定数的にfalse」という状況でも、片方は本体が到達可能(`do-while`)、もう片方は到達不能(`while`)という**非対称なルール**になっている（Eは誤り。同じルールではない）。
- `javac`で検証済み：`while (1 == 2) System.out.print("*");`の行で「この文に制御が移ることはありません」。`do-while(false)`側だけを切り出すとエラー無くコンパイルでき、`*`が1回出力される。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex9"></a>
## 問題ex9(sample/chap4/ex9)

```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        while (x != 10) {
            System.out.print(x);
            x -= 2;
        }
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `0` の後、正常終了する（`x`が`0`未満になった時点で自動的に止まる）
B. `0-2-4-6-8` の後、`x`が`10`を通り越した時点で自動的に止まる
C. `x`が`10`ぴったりになることは一生無いため、無限ループになる
D. コンパイルエラーになる（`!=`による終了条件は非推奨のため使えない）
E. 実行時に`ArithmeticException`がスローされる（マイナスの値を扱おうとしたため）

**解答**

正解：**C**

**補足**

- `x`は`0`から`2`ずつ**減っていく**（`x -= 2`）ため、`0, -2, -4, -6, ...`とマイナス方向へどこまでも進み続ける。**`10`という値にちょうど一致することは決して無い**ので、`x != 10`は永遠に`true`のまま終わらない。
- 「`x >= 10`のような大小比較」であれば、途中で条件をまたいだ瞬間に停止できるが、**「等しいかどうか」だけを見る`!=`は、値がちょうどその数値を通過したかどうかを判定できない**ため、意図した終了条件からズレて動くと無限ループの原因になりやすい。
- `int`の演算に特別な自動停止機構は無い（A・Bは誤り）。
- `javac`/`java`で実際に検証（強制終了で確認）：`0`から始まり`x`が減り続けたまま停止せず、無限ループになることを確認済み。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex10"></a>
## 問題ex10(sample/chap4/ex10)

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 2; ) {
            i++;
            int j;
            for (j = 0; j < i; j++) {
            }
            System.out.print(j + " ");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1 2 `
B. `0 1 `
C. コンパイルエラーになる（外側の`for`の更新式が空欄になっている）
D. 無限ループになる（外側の`for`に更新式が無いため`i`が増えない）
E. `1 1 `

**解答**

正解：**A**

**補足**

- `for`の3要素（初期化式・継続条件・更新式）は、**それぞれ省略可能**。今回は更新式の部分が空になっているが、これは正当な文法（Cは誤り）。その代わり、ループ本体の中で`i++;`という形で手動で`i`を増やしている（Dは誤り、`i`はちゃんと増える）。
- 外側1周目：`i++`で`i=1`。内側`for (j=0; j<1; j++)`は`j=0`のとき`0<1`でループ本体（空）を実行し`j=1`、`1<1`はfalseで終了。`j`は`1`のまま`print`。
- 外側の条件`i<2`（`1<2`）で継続。2周目：`i++`で`i=2`。内側`for(j=0; j<2; j++)`は`j=0→1→2`と回り、`j=2`で終了。`print`。
- 外側条件`i<2`（`2<2`）は`false`で終了。
- `javac`/`java`で検証済み：`1 2 `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11(sample/chap4/ex11)

```java
public class Main {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[3];
        array[1] = new int[]{1, 2};
        for (int i = 0; i < 2; i++) {
            array[0][i] = i + 1;
        }
        for (int ar[] : array) {
            for (int a : ar)
                System.out.print(a);
            System.out.print("_");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `123_12_`
B. `120_12_`
C. `120_120_`（`array[1]`も3要素分表示される）
D. コンパイルエラーになる（拡張forのループ変数に`int ar[]`という宣言方法は使えない）
E. 実行時に`ArrayIndexOutOfBoundsException`がスローされる（`array[0][2]`に一度もアクセスしていないため）

**解答**

正解：**B**

**補足**

- `int ar[]`のように、変数名の後ろに`[]`を付ける古い書き方は、拡張forのループ変数の宣言としても問題なく使える（Dは誤り。第1章で見た`String args[]`と同じ考え方）。
- `array[0] = new int[3]`は`{0, 0, 0}`で初期化される。続く`for (i=0;i<2;i++)`のループは`i=0,1`の**2回だけ**回るため、`array[0][0]=1`, `array[0][1]=2`は上書きされるが、`array[0][2]`は初期値の`0`のまま変わらない（未初期化アクセスによる実行時エラーにはならない。Eは誤り、配列要素はデフォルト値で初期化済み）。
- `array[1] = {1, 2}`はそのまま。
- 出力：`array[0]`(`{1,2,0}`)を1要素ずつ→`120`、区切り`_`。`array[1]`(`{1,2}`)→`12`、区切り`_`。
- `javac`/`java`で検証済み：`120_12_`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex12"></a>
## 問題ex12(sample/chap4/ex12)

```java
public class Main {
    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'P', 'P', 'L', 'E'};
        int value = 0;
        for (char c : chars) {
            value += switch (c) {
                case 'A': yield 1;
                case 'P': yield 2;
                default: yield 3;
            };
        }
        System.out.println(value);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `11`
B. `13`（第3章で見た類題と同じ結果になる）
C. `9`
D. コンパイルエラーになる（`case`が3つとも`yield`を持っているのに`default`も書かれているのは冗長でエラーになる）
E. `1`（最初の文字だけで確定してしまう）

**解答**

正解：**A**

**補足**

- 一見、以前見た「`case 'A'`に`yield`が無くフォールスルーする」問題と似ているが、**今回は`case 'A'`にも`yield 1;`がきちんと書かれている**ため、フォールスルーは一切発生しない（Bは誤り、あの問題とは結果が異なる）。各文字はそれぞれ独立に自分の`case`（または`default`）だけで完結する。
- `'A'`→`yield 1`。`'P'`(2回)→それぞれ`yield 2`。`'L'`, `'E'`→どちらも`case`に一致せず`default`→それぞれ`yield 3`。
- 合計：`1 + 2 + 2 + 3 + 3 = 11`。
- 全ての`case`に`yield`があった上でさらに`default`を書くこと自体は冗長でも違反でもない（Dは誤り。むしろ`char`は`default`が無いとそもそもコンパイルエラーになる対象なので必須）。
- `javac`/`java`で検証済み：`11`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13(sample/chap4/ex13)

```java
public class Main {
    public static void main(String[] args) {
        String text = "Hello";
        int index = 1;
        while (index < text.length()) {
            switch (text.charAt(index)) {
                case 'H':
                    System.out.print(0);
                case 'e':
                    System.out.print(1);
                    break;
                case 'l':
                    System.out.print(2);
                    index++;
                    continue;
                case 'o':
                    System.out.print(3);
            }
            index++;
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1223`
B. `0123`
C. `1220123`（`index`が2周分ずれて重複して処理される）
D. 無限ループになる（`case 'l'`の`continue`によりループを抜けられなくなる）
E. `12`のみ（`case 'o'`に`break`が無いため異常終了する）

**解答**

正解：**A**

**補足**

- `text = "Hello"`（H,e,l,l,o）、`index`は`1`から開始（`H`はスキップ）。
- `index=1`：`charAt(1)='e'`→`case 'e'`：出力`1`→`break`でswitchを抜ける→`while`の最後の`index++`で`index=2`。
- `index=2`：`charAt(2)='l'`→`case 'l'`：出力`2`→`index++`(`index=3`)→**`continue`**でswitch後の`index++`をスキップし、ループの継続条件チェックへ直接戻る。
- `index=3`：`charAt(3)='l'`→同様に出力`2`→`index++`(`index=4`)→`continue`。
- `index=4`：`charAt(4)='o'`→`case 'o'`：出力`3`（`break`が無いが、これがswitch内の最後の`case`なので自然に終わる）→switchの外の`index++`で`index=5`。
- `index=5`、`5<5`はfalseで終了。出力は`1`,`2`,`2`,`3`＝`1223`。
- `continue`は「switch文を含むループ本体の残り」をスキップして次のループ判定へ進むだけであり、ループ自体を止まらせるものではない（D・Eは誤り）。
- `javac`/`java`で検証済み：`1223`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14(sample/chap4/ex14)

```java
public class Main {
    public static void main(String[] args) {
        String[][] letters = {{"A ", "B ", "C ", "D "}
                            , {"E ", "F ", "G ", "H "}};
        for (String[] letter : letters) {
            for (String s : letter) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
A B C D 
E F G H 
```

B.
```
A B C D E F G H 
```
（改行は1回だけ）

C.
```
A E 
B F 
C G 
D H 
```
（縦方向に読まれる）

D. コンパイルエラーになる（外側の`letter`は`String[]`型なのに`letters`の要素は`String[]`ではないため）

E. `letters.length`が`8`として扱われる

**解答**

正解：**A**

**補足**

- `letters`は「2つの要素（それぞれが`String[4]`）を持つ配列」＝`String[][]`型。外側の拡張forの`letter`は`String[]`型として正しく1行分（4要素）を受け取れる（Dは誤り）。
- 外側1周目：`letter = {"A ","B ","C ","D "}`。内側のforで4要素を順に出力し`A B C D `、その後`println()`で改行。
- 外側2周目：`letter = {"E ","F ","G ","H "}`。同様に`E F G H `を出力し改行。
- `letters.length`は「外側の要素数」＝`2`（Eは誤り）。
- `javac`/`java`で検証済み：`A B C D `（改行）`E F G H `（改行）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15(sample/chap4/ex15)

```java
public class Main {
    public static void main(String[] args) {
        String[] cities = {"Paris ", null, "Tokyo ", "Rio ", null};
        for (String city : cities) {
            int count = 0;
            if (city == null) {
                count++;
                continue;
            }
            System.out.print(city);
        }
        System.out.println(", N/A:" + count);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`Paris Tokyo Rio , N/A:2`が出力される
B. `city == null`の判定自体がコンパイルエラーになる（`null`との比較には`equals`を使わなければならない）
C. `count`を参照している最後の`println`の行でコンパイルエラーになる（`count`は拡張forのループ内で毎回宣言し直される変数のため、ループの外からは見えない）
D. `continue`が原因で、2周目以降`count`の宣言自体が実行されずコンパイルエラーになる
E. `null`を含む配列を拡張forでまわすこと自体がコンパイルエラーになる

**解答**

正解：**C**

**補足**

- `int count = 0;`は拡張for文の**本体(ブロック)の中**で宣言されている。ローカル変数のスコープはそのブロックの中だけなので、ループを抜けた後の`println(", N/A:" + count)`からは`count`が見えない（存在しないものとして扱われる）。
- 「ループの外で使いたい値を、ループの中だけで宣言してしまっている」という、問題9(通常のfor文版)と同じ構造の間違い。今回は拡張forでも同じ問題が起きることを確認する内容。
- 参照型同士の`==`比較（`null`かどうかの判定）はごく普通に書ける（Bは誤り。`equals`が必須なのは内容比較であって`null`チェックではない）。`null`を含む配列を拡張forで回すこと自体にも制約は無い（Eは誤り）。
- `count`の宣言自体は毎回のループの最初に実行されるので、`continue`があってもその前の宣言済み処理には影響しない（Dは誤り。単にスコープの問題）。
- `javac`で検証済み：最後の`println`の行で「シンボルを見つけられません（シンボル: 変数count）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex16"></a>
## 問題ex16(sample/chap4/ex16)

```java
public class Main {
    public static void main(String[] args) {
        String[][] str = {{"A", "B", "C"}, {"D", "E", "F"}};
        outer:
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                if (i == 1) break outer;
                if (j == 2) continue outer;
                System.out.print(str[i][j]);
            }
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `ABDE`
B. `AB`
C. `ABCDEF`
D. `A`
E. コンパイルエラーになる（同じ`for`ループに対して`break`と`continue`の両方に同じラベルを使うことはできない）

**解答**

正解：**B**

**補足**

- 同じラベルを`break`と`continue`の両方で使い分けること自体は普通に許される（Eは誤り）。
- `i=0`：`j=0`（`i==1`?false、`j==2`?false）→出力`A`。`j=1`（false,false）→出力`B`。`j=2`（`i==1`?false、`j==2`?true）→`continue outer`で外側の次の周へ。
- `i=1`：`j=0`の時点で`i==1`が`true`になっているので**即座に`break outer`**が実行され、内側のループにすら入り込まずプログラム全体（`outer`ループ）を脱出する。
- 結果、出力されるのは`i=0`のときの`A`と`B`だけ＝`AB`。
- `javac`/`java`で検証済み：`AB`。

**実施記録**

回答：
正解：
迷ったポイント：