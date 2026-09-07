# 第3章 サンプル発展問題(1〜21・ex2,3,4,5,6,7,8,9,11,12,13,14,15,16,18,19,20 各1問、計38問)

`sample/chap3/1`〜`21`・`ex2,3,4,5,6,7,8,9,11,12,13,14,15,16,18,19,20`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題1(sample/chap3/1)](#q1)
- [問題2(sample/chap3/2)](#q2)
- [問題3(sample/chap3/3)](#q3)
- [問題4(sample/chap3/4・複数選択)](#q4)
- [問題5(sample/chap3/5)](#q5)
- [問題6(sample/chap3/6)](#q6)
- [問題7(sample/chap3/7)](#q7)
- [問題8(sample/chap3/8)](#q8)
- [問題9(sample/chap3/9)](#q9)
- [問題10(sample/chap3/10)](#q10)
- [問題11(sample/chap3/11)](#q11)
- [問題12(sample/chap3/12)](#q12)
- [問題13(sample/chap3/13)](#q13)
- [問題14(sample/chap3/14)](#q14)
- [問題15(sample/chap3/15)](#q15)
- [問題16(sample/chap3/16)](#q16)
- [問題17(sample/chap3/17)](#q17)
- [問題18(sample/chap3/18)](#q18)
- [問題19(sample/chap3/19)](#q19)
- [問題20(sample/chap3/20)](#q20)
- [問題21(sample/chap3/21)](#q21)
- [問題ex2(sample/chap3/ex2)](#qex2)
- [問題ex3(sample/chap3/ex3)](#qex3)
- [問題ex4(sample/chap3/ex4)](#qex4)
- [問題ex5(sample/chap3/ex5・複数選択)](#qex5)
- [問題ex6(sample/chap3/ex6)](#qex6)
- [問題ex7(sample/chap3/ex7)](#qex7)
- [問題ex8(sample/chap3/ex8)](#qex8)
- [問題ex9(sample/chap3/ex9)](#qex9)
- [問題ex11(sample/chap3/ex11)](#qex11)
- [問題ex12(sample/chap3/ex12)](#qex12)
- [問題ex13(sample/chap3/ex13)](#qex13)
- [問題ex14(sample/chap3/ex14)](#qex14)
- [問題ex15(sample/chap3/ex15)](#qex15)
- [問題ex16(sample/chap3/ex16)](#qex16)
- [問題ex18(sample/chap3/ex18)](#qex18)
- [問題ex19(sample/chap3/ex19)](#qex19)
- [問題ex20(sample/chap3/ex20)](#qex20)

<a id="q1"></a>
## 問題1(sample/chap3/1)

```java
public class Main {
    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'P', 'P', 'L', 'E'};
        int value = 0;
        for (char c : chars) {
            value += switch (c) {
                case 'A': System.out.print("a!");
                default: yield 3;
                case 'P': yield 2;
            };
        }
        System.out.println(value);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `a!13`
B. `a!10`
C. `a!7`
D. コンパイルエラーになる（`default`が`case 'P'`より前に書かれているため）
E. `a!2`

**解答**

正解：**A**

**補足**

- `default`はどこに書いても構わない（Dは誤り）。今回は`case 'A'`と`case 'P'`の間に挟まっている。
- `'A'`のとき：`case 'A'`に一致し`"a!"`を出力した後、`yield`が無いので**フォールスルー**して`default`に流れ込み`yield 3`。`value += 3`。
- `'P'`のとき(2回)：直接`case 'P'`に一致し`yield 2`。それぞれ`value += 2`。
- `'L'`, `'E'`のとき：どの`case`にも一致しないので`default`に入り`yield 3`。それぞれ`value += 3`。
- 合計：`3(A) + 2(P) + 2(P) + 3(L) + 3(E) = 13`。`"a!"`は`'A'`のときの1回だけ出力される。
- `javac`/`java`で検証済み：`a!13`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap3/2)

```java
public class Main {
    public static void main(String[] args) {
        int a = 1, c;
        c = a++;
        System.out.println("a:" + a + " c:" + c);
        a = 1;
        c = ++a;
        System.out.println("a:" + a + " c:" + c);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
a:2 c:2
a:2 c:2
```

B.
```
a:2 c:1
a:2 c:2
```

C.
```
a:1 c:2
a:2 c:1
```

D.
```
a:2 c:1
a:2 c:1
```

E. コンパイルエラーになる（`int a = 1, c;`のようにカンマ区切りで初期化の有無が違う宣言は書けない）

**解答**

正解：**B**

**補足**

- `c = a++;`（後置）：**まず現在の`a`の値(`1`)を`c`に代入してから**、`a`をインクリメントする。よって`c:1`、その後`a:2`。
- `c = ++a;`（前置）：**先に`a`をインクリメントしてから**、その新しい値を`c`に代入する。よって`a:2`と`c:2`が同じ値になる。
- `int a = 1, c;`のように、1つの型宣言の中で一部だけ初期化する（`a`は初期化・`c`は未初期化）という書き方は文法上問題ない（Eは誤り）。
- `javac`/`java`で検証済み：`a:2 c:1` の後 `a:2 c:2`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap3/3)

```java
public class Main {
    public static void main(String[] args) {
        int e = 7;
        int x = 3;
        System.out.println("e %= x : " + (e %= x));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `e %= x : 2`
B. `e %= x : 1`
C. `e %= x : 0`
D. `e %= x : 2.33`
E. コンパイルエラーになる（複合代入演算子の式全体を`println`に直接渡すことはできない）

**解答**

正解：**B**

**補足**

- `e %= x`は`e = e % x`と同じ意味。`7 % 3`は「7を3で割った余り」＝`1`。
- 複合代入演算子(`+=`, `-=`, `%=`など)による代入式は、それ自体が**代入後の値を持つ式**として扱えるため、`println(...)`のような式が必要な場所にそのまま埋め込むことができる（Eは誤り）。
- `%`は整数同士なら整数の余りを返すので小数になることはない（Dは誤り）。
- `javac`/`java`で検証済み：`e %= x : 1`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap3/4・複数選択)

```java
public class Main {
    public static void main(String[] args) {
        int i = 0, j = 10;
        boolean b1;
        b1 = (i > 0) & ((j++) <= 10);
        System.out.println("b1 : " + b1 + " j : " + j);
    }
}
```

このプログラムの実行結果について、正しい記述をすべて選んでください。（複数選択）

A. `b1`は`false`になる
B. `j`は最終的に`11`になる（`&`は両辺を必ず評価するため）
C. `j`は最終的に`10`のまま変わらない（左辺が`false`なので右辺は評価されない）
D. もし`&`ではなく`&&`（短絡評価）を使っていたら、`j`は`10`のままになる
E. `&`は`boolean`同士にしか使えないため、この式自体がコンパイルエラーになる

**解答**

正解：**A、B、D**

**補足**

- `i > 0`は`i=0`なので`false`。`&`（**非短絡**の論理積）は、左辺の結果に関わらず**右辺も必ず評価する**。よって`(j++) <= 10`も実行され、`j`は評価の副作用として`11`にインクリメントされる（B正しい、Cは誤り）。
- 最終的に`b1 = false & true = false`（Aは正しい）。
- もし`&&`（短絡評価）であれば、左辺が`false`と確定した時点で右辺の評価自体をスキップするため、`j++`は実行されず`j`は`10`のまま（Dは正しい）。この「実行されるかどうかの違い」こそが`&`と`&&`の本質的な違い。
- `&`は`boolean`同士の論理演算にも、整数同士のビット演算にも使える汎用の演算子であり、`boolean`専用ではない（Eは誤り）。
- `javac`/`java`で検証済み：`b1 : false j : 11`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap3/5)

```java
public class Main {
    public static void main(String[] args) {
        String result = 11 % 2 == 0 ? "even" : 11 % 3 == 0 ? "multi3" : "odd";
        System.out.println(result);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `even`
B. `multi3`
C. `odd`
D. コンパイルエラーになる（三項演算子を入れ子にはできない）
E. 実行時に例外がスローされる

**解答**

正解：**C**

**補足**

- 三項演算子は**入れ子（ネスト）にして書くことができる**（Dは誤り）。`条件1 ? 値A : (条件2 ? 値B : 値C)`のように、右側の分岐にさらに三項演算子を書ける。
- `11 % 2 == 0`は`11`が奇数なので`false`。よって全体は`11 % 3 == 0 ? "multi3" : "odd"`の評価に進む。
- `11 % 3`は`2`（`0`ではない）ので、こちらも`false`。結果は`"odd"`。
- `javac`/`java`で検証済み：`odd`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap3/6)

```java
public class Main {
    public static void main(String[] args) {
        int i = 65;
        long l = 65L;
        System.out.println("i == l : " + (i == l));
        char a = 'A';
        System.out.println("i == a : " + (i == a));
        String s1 = "Duke";
        String s2 = new String("Duke");
        String s3 = s2;
        System.out.println("s2 == s3 : " + (s2 == s3));
        System.out.println("s1 == s2 : " + (s1 == s2));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
i == l : false
i == a : false
s2 == s3 : true
s1 == s2 : false
```

B.
```
i == l : true
i == a : true
s2 == s3 : true
s1 == s2 : false
```

C.
```
i == l : true
i == a : true
s2 == s3 : false
s1 == s2 : true
```

D. `i == l`の行がコンパイルエラーになる（`int`と`long`は直接比較できない）
E. `i == a`の行がコンパイルエラーになる（`int`と`char`は直接比較できない）

**解答**

正解：**B**

**補足**

- 基本データ型同士の`==`比較では、片方がもう片方の型に**暗黙的に昇格(widening)**されてから数値として比較される。`int`と`long`、`int`と`char`もこの対象で、コンパイルエラーにはならない（D・Eは誤り）。`65 == 65L`も`65 == 'A'`（`'A'`の文字コードは65）もどちらも`true`。
- `s3 = s2;`は「参照のコピー」であり、`s2`と`s3`は**同じオブジェクト**を指す。よって`s2 == s3`は`true`。
- `s1`（リテラル、文字列プール）と`s2`（`new String(...)`で明示的に生成した別オブジェクト）は、内容が同じでも異なるオブジェクトなので`s1 == s2`は`false`。
- `javac`/`java`で検証済み：`true` / `true` / `true` / `false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q7"></a>
## 問題7(sample/chap3/7)

```java
public class Main {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Ja" + "va";
        String s3 = "Ja";
        String s4 = s3 + "va";
        System.out.println(s1 == s2);
        System.out.println(s1 == s4);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true` `true`
B. `false` `false`
C. `true` `false`
D. `false` `true`
E. コンパイルエラーになる（変数を使った`+`と、リテラル同士の`+`は混在できない）

**解答**

正解：**C**

**補足**

- `s2 = "Ja" + "va"`は、**両方ともコンパイル時に値が確定しているリテラル同士の連結**。このような式は**コンパイル時に`"Java"`という1つの定数として畳み込まれ(constant folding)**、実行時に新しいオブジェクトを作る処理は発生しない。結果として文字列プール上の`"Java"`（`s1`と同じもの）を指すため`s1 == s2`は`true`。
- `s4 = s3 + "va"`は、`s3`が**変数**（コンパイル時点では値が未確定として扱われる）であるため、この連結は**実行時に新しい`String`オブジェクトを生成する処理**になる。中身は同じ`"Java"`でも、プール上の`s1`とは別オブジェクトなので`s1 == s4`は`false`。
- 見た目が似た2つの文字列連結でも、「両辺ともコンパイル時定数かどうか」で挙動が変わるという点が最大のポイント。
- `javac`/`java`で検証済み：`true` / `false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q8"></a>
## 問題8(sample/chap3/8)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("James");
        StringBuilder sb2 = sb1.append("!");
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `false` `false`
B. `false` `true`
C. `true` `false`
D. `true` `true`
E. コンパイルエラーになる（`append`の戻り値を別の変数で受けることはできない）

**解答**

正解：**D**

**補足**

- `StringBuilder`の`append()`は、新しいオブジェクトを作るのではなく、**呼び出し元のオブジェクト自身(`this`)を書き換えた上で、その`this`をそのまま戻り値として返す**設計になっている。
- そのため`sb2 = sb1.append("!")`の`sb2`は、`sb1`とは**全く同じオブジェクト**を指すことになる。`sb1 == sb2`は`true`。
- 同じオブジェクト同士であれば、たとえ`StringBuilder`が`equals()`をオーバーライドしていなくても（デフォルトの参照比較のままでも）当然`true`になる。
- `append()`の戻り値を別の変数で受け取ること自体は普通のメソッド呼び出しであり問題ない（Eは誤り）。
- `javac`/`java`で検証済み：`true` / `true`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q9"></a>
## 問題9(sample/chap3/9)

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = null;
        System.out.println(arr.length);
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `0` が出力される
B. `arr.length`の行でコンパイルエラーになる（`null`の配列に対して`.length`は使えない）
C. 実行時に`NullPointerException`がスローされる
D. `null`という文字列が出力される
E. 実行時に`ArrayIndexOutOfBoundsException`がスローされる

**解答**

正解：**C**

**補足**

- `arr`は`null`が代入されただけの、参照先を持たない変数。`.length`は「配列オブジェクトが実際に持っているフィールド的な情報」にアクセスする操作なので、参照先が無い(`null`)状態でこれを行おうとすると実行時に失敗する。
- `arr`が`int[]`型であること自体はコンパイラも認識しているので、`.length`という書き方自体はコンパイル時には正当と判断される（Bは誤り、実行時まで失敗が判明しない）。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "<local1>" is null`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q10"></a>
## 問題10(sample/chap3/10)

```java
public class Main {
    public static void main(String[] args) {
        byte b = (byte) 200;
        System.out.println(b);
        int val = (int)(50 * 0.5);
        System.out.println(val);
        boolean bool = 5 > (int) 5.9;
        System.out.println(bool);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
-56
25
false
```

B.
```
-56
25
true
```

C.
```
200
25
false
```

D.
```
-56
26
false
```

E. `byte b = (byte) 200;`の行でコンパイルエラーになる（200は`byte`の範囲外）

**解答**

正解：**A**

**補足**

- `byte`の範囲は`-128`〜`127`。`200`はこの範囲外だが、**明示的なキャスト`(byte)`を書いている限り、コンパイルエラーにはならず「値が変わる(オーバーフローする)ことを許容した上での変換」として実行される**（Eは誤り）。`200`を`byte`として無理やり収めると`-56`になる。
- `(int)(50 * 0.5)`：`50 * 0.5`は`double`として`25.0`と計算され、`(int)`キャストで小数部が**切り捨て**られて`25`になる（Dのような四捨五入はされない）。
- `(int) 5.9`は小数部を切り捨てて`5`になる。`5 > 5`は`false`（Bは誤り）。
- `javac`/`java`で検証済み：`-56` / `25` / `false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q11"></a>
## 問題11(sample/chap3/11)

```java
public class Main {
    public static void main(String[] args) {
        byte b1 = 5;
        byte b2 = ++b1;
        System.out.println(b2);
        short s1 = 3, s2 = 4;
        short s3 = (short)(s1 + s2);
        System.out.println(s3);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
6
7
```

B. `byte b2 = ++b1;`の行でコンパイルエラーになる（`++`の結果は`int`型になるため`byte`に代入できない）
C. `short s3 = (short)(s1 + s2);`の行でコンパイルエラーになる（`(short)`キャストがあっても`short`同士の加算結果は代入できない）
D.
```
6
7.0
```
E. 実行時に`ArithmeticException`がスローされる

**解答**

正解：**A**

**補足**

- `++`（インクリメント演算子）は特別扱いされており、`byte`や`short`の変数に対して使っても、暗黙的に`byte`/`short`型に戻すキャストが内部で行われる。よって`byte b2 = ++b1;`はキャスト無しでも問題なくコンパイルできる（Bは誤り）。結果は`6`。
- 一方、`s1 + s2`のような**普通の算術演算**の結果は`byte`/`short`同士であっても自動的に`int`型に格上げされる。この`int`の結果を`short`型の変数に代入するには、明示的な`(short)`キャストが必要（今回はすでにキャストされているのでコンパイルは通る。Cは誤り、キャストがあれば代入できる）。結果は`7`。
- どちらも小数を含まない整数演算なので`.0`が付くことはない（Dは誤り）。
- `javac`/`java`で検証済み：`6` / `7`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q12"></a>
## 問題12(sample/chap3/12)

```java
public class Main {
    public static void main(String[] args) {
        Integer obj1 = 200;
        int i1 = obj1;
        Double obj2 = 10;
        System.out.println(i1);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`200`が出力される
B. `Integer obj1 = 200;`の行でコンパイルエラーになる（`200`は`Integer`のキャッシュ範囲外のため）
C. `int i1 = obj1;`の行でコンパイルエラーになる（オートアンボクシングは`Integer`には使えない）
D. `Double obj2 = 10;`の行でコンパイルエラーになる（`int`のリテラルは`Integer`へのオートボクシングにしか対応しておらず、`Double`への自動変換はできない）
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**D**

**補足**

- `Integer obj1 = 200;`はオートボクシングにより`int`から`Integer`へ自動変換される。この変換自体は`-128〜127`のキャッシュ範囲外の値でも問題なく成立する（キャッシュの有無は`==`比較の結果に影響するだけで、代入自体がエラーになるわけではない。Bは誤り）。
- `int i1 = obj1;`はオートアンボクシングにより問題なく`Integer`から`int`に戻せる（Cは誤り）。
- 問題は`Double obj2 = 10;`。オートボクシングは「**その場に書かれたリテラル/式の型と、対応するラッパークラスの型が一致する場合にのみ**」自動的に働く仕組みで、`int`リテラルの`10`は`Integer`へのオートボクシングにしか対応しておらず、そこからさらに`Double`へ変換する、という2段階の暗黙変換は行われない。
- `javac`で検証済み：「不適合な型: intをDoubleに変換できません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q13"></a>
## 問題13(sample/chap3/13)

```java
public class Main {
    public static void main(String[] args) {
        int i = 15;
        if (i > 10)
            System.out.println(i + " is");
            System.out.println("Greater than 10");
        System.out.println("i : " + i);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
15 is
i : 15
```

B.
```
15 is
Greater than 10
i : 15
```

C. `Greater than 10`の行のインデントが`if`の中身と揃っていないためコンパイルエラーになる
D.
```
Greater than 10
i : 15
```
（`i > 10`が`false`だった場合の出力）
E.
```
15 is
Greater than 10
```
（`i : 15`は出力されない）

**解答**

正解：**B**

**補足**

- `{}`（波括弧）を付けていない`if`文は、**直後の1文だけ**が条件付きの実行対象になる。インデント(見た目の字下げ)はコンパイラにとって何の意味も持たない、あくまで人間が読みやすくするための飾りに過ぎない（Cは誤り）。
- よって`if (i > 10)`の対象は`System.out.println(i + " is");`の1文だけで、次の`System.out.println("Greater than 10");`は**`if`の条件に関わらず常に実行される**独立した文。
- `i = 15 > 10`は`true`なので両方の`println`が実行され、その後`i : 15`も出力される。
- `javac`/`java`で検証済み：`15 is` / `Greater than 10` / `i : 15`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q14"></a>
## 問題14(sample/chap3/14)

```java
public class Main {
    public static void main(String[] args) {
        int i = 5;
        if (i < 10) {
            System.out.println("Less than 10");
        } else
            System.out.println("Greater or equal 10");
            System.out.println("done");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
Less than 10
```

B.
```
Less than 10
done
```

C.
```
Less than 10
Greater or equal 10
done
```

D. `else`ブロックに複数の文があるのに`{}`が無いためコンパイルエラーになる
E.
```
Greater or equal 10
done
```

**解答**

正解：**B**

**補足**

- `if`ブロックには`{}`が付いているが、対応する`else`側には`{}`が付いていない。この場合、`else`にぶら下がるのは直後の1文(`System.out.println("Greater or equal 10");`)だけで、その次の`System.out.println("done");`は`else`とは無関係に**常に実行される**独立した文になる。
- 文法上、`if`/`else`のどちらか一方だけに`{}`が付いていても何の問題も無い（Dは誤り）。
- `i = 5 < 10`は`true`なので`if`ブロック側(`Less than 10`)が実行され、`else`側(`Greater or equal 10`)は実行されない。その後`done`は無条件に出力される。
- `javac`/`java`で検証済み：`Less than 10` / `done`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q15"></a>
## 問題15(sample/chap3/15)

```java
public class Main {
    public static void main(String[] args) {
        int i = 30;
        if (i < 10) {
            System.out.println("A");
        } else if (i < 20) {
            System.out.println("B");
        } else if (i < 30) {
            System.out.println("C");
        }
        System.out.println("done");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `A` `done`
B. `B` `done`
C. `C` `done`
D. `done`のみ
E. コンパイルエラーになる（`else`が無い`if-else if`の連鎖の最後には必ず`else`が必要）

**解答**

正解：**D**

**補足**

- `i = 30`は`i < 10`,`i < 20`,`i < 30`のいずれも満たさない（`30 < 30`は`false`）。
- `if-else if`の連鎖に、最後の受け皿となる`else`が無い場合、**どの条件にも一致しなければ何も実行されずにそのまま素通りする**。これは文法違反ではなく正当な書き方（Eは誤り、`else`は必須ではない）。
- よってこのケースでは`if`関連のブロックからは何も出力されず、後続の`System.out.println("done");`だけが実行される。
- `javac`/`java`で検証済み：`done`のみ。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q16"></a>
## 問題16(sample/chap3/16)

```java
public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            String s = args[0];
            if (s.length() == 4) {
                System.out.println("s.length() == 4");
            }
        }
        System.out.println("end");
    }
}
```

このプログラムをコマンドライン引数を1つも渡さずに実行するとどうなりますか。（1つ選択）

A. `s.length() == 4` `end` の順に出力される
B. `end` のみが出力される
C. `args[0]`にアクセスしようとして`ArrayIndexOutOfBoundsException`がスローされる
D. `NullPointerException`がスローされる（`args`が`null`のため）
E. 何も出力されずに正常終了する

**解答**

正解：**B**

**補足**

- 引数を渡さない場合`args`は`null`ではなく**長さ0の配列**（Dは誤り）。`args.length != 0`は`false`になるので、外側の`if`ブロックの中身(`args[0]`へのアクセスを含む)は**一切実行されない**。よって範囲外アクセスの例外も起きない（Cは誤り）。
- 内側の`if`ブロックに到達しないまま、外側の`if`ブロックを抜けて`System.out.println("end");`だけが実行される。
- `javac`/`java`で検証済み（引数無しで実行）：`end`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q17"></a>
## 問題17(sample/chap3/17)

`sample/chap3/17/Main.java`には、実は次の1行が含まれています（`\"`のつもりで書かれたと思われる部分が、`\`(バックスラッシュ)ではなく`¥`(円記号)になっています）。

```java
String s = new String("Java");
if ("Java".equals(s)) {
    System.out.println("¥"Java¥".equals(s)");
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`"Java".equals(s)`という文字列がそのまま出力される
B. 問題なくコンパイルが通り、`¥Java¥.equals(s)`のように円記号付きで出力される
C. コンパイルエラーになる（`¥`はエスケープ文字として認識されず、文字列リテラルが途中で終わってしまう）
D. 実行時に文字化けした状態で出力される
E. `equals(s)`の部分がメソッド呼び出しとして誤って解釈され、無限に別のコンパイルエラーが連鎖する

**解答**

正解：**C**

**補足**

- `\"`（バックスラッシュ+ダブルクォート）であれば「文字列の中に`"`という文字そのものを含める」という正当なエスケープシーケンスになるが、**`¥`(円記号、U+00A5)はバックスラッシュ(U+005C)とは全く別の文字**であり、エスケープシーケンスの開始文字として機能しない。
- そのため`"¥"Java¥".equals(s)"`は、コンパイラから見ると**`"¥"`という(円記号1文字だけの)完結した文字列リテラルの直後に、`Java¥`という解釈不能なテキストが続いている**という状態になり、構文解析が破綻する。
- 日本語配列キーボードやフォントによっては`\`と`¥`が似て見える(あるいは変換されてしまう)ことがあり、見た目だけでは区別しにくい典型的なトラブル。
- `javac`で検証済み（`sample/chap3/17/Main.java`をそのままコンパイル）：「')'がありません」「';'がありません」の2件のエラー。**このサンプルファイル自体、現状ではコンパイルが通らない状態**になっている。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q18"></a>
## 問題18(sample/chap3/18)

```java
public class Main {
    public static void main(String[] args) {
        String s = "C";
        switch (s) {
            case "A":
                System.out.println("A"); break;
            case "B":
                System.out.println("B"); break;
            case "C", "D":
                System.out.println("C, D"); break;
            default:
                System.out.println("Other"); break;
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Other`
B. `C, D`
C. `C`
D. コンパイルエラーになる（1つの`case`に複数の値をカンマ区切りで書くことはできない）
E. `C, D`の後に`Other`も出力される（`break`が効いていないため）

**解答**

正解：**B**

**補足**

- 1つの`case`ラベルに`case "C", "D":`のようにカンマ区切りで複数の値をまとめて指定することができる（Dは誤り）。「`"C"`か`"D"`のどちらかに一致すれば、このラベルにマッチする」という意味。
- `s = "C"`なのでこの結合ラベルに一致し、`"C, D"`が出力されて`break`によりswitch文を抜ける。他の`case`（`default`含む）には流れ込まない（A・Eは誤り）。
- `javac`/`java`で検証済み：`C, D`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q19"></a>
## 問題19(sample/chap3/19)

```java
public class Main {
    public static void main(String[] args) {
        String z = "A";
        switch (z) {
            default:
                System.out.println("Other");
            case "B":
                System.out.println("B");
            case "A":
                System.out.println("A");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Other` `B` `A`（`default`が先頭に書かれているので必ず最初に実行される）
B. `A`のみ
C. `B` `A`
D. `Other`のみ
E. コンパイルエラーになる（`default`を先頭に書くことはできない）

**解答**

正解：**B**

**補足**

- `default`を`switch`の先頭に書くこと自体は文法上問題ない（Eは誤り）。
- 重要なのは、**`default`は「他のどの`case`にも一致しなかったときの入り口」というだけであり、書かれている位置とは無関係**という点。`z = "A"`はまず`case "A":`という一致するラベルを探しに行き、見つかればそこへ直接ジャンプする。`default`や`case "B"`は素通りされる（A・Cは誤り、`default`が先頭にあっても実行順は変わらない）。
- `case "A":`にジャンプした後は`break`が無いのでそのままフォールスルーするが、`case "A"`は**switch文の一番最後のラベル**なのでこれ以上流れ込む先が無く、`"A"`だけが出力されて終わる。
- `javac`/`java`で検証済み：`A`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q20"></a>
## 問題20(sample/chap3/20)

```java
public class Main {
    public static void main(String[] args) {
        String s = "A";
        switch (s) {
            case "A", "B" -> System.out.println("A-B");
            case "C", "D" -> { System.out.println("C-D"); break; }
            default -> throw new RuntimeException("N/A");
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `case "C", "D" -> { ... break; }`の`break`の行がコンパイルエラーになる（アロー構文では`break`は使用できない）
B. 問題なくコンパイルが通り、`A-B`が出力される
C. `default`に`throw`を書くことはできないためコンパイルエラーになる
D. 実行時に`RuntimeException`がスローされる
E. `case "A", "B"`のように複数ラベルとアロー構文は併用できないためコンパイルエラーになる

**解答**

正解：**B**

**補足**

- アロー構文の`{}`ブロックの中に`break;`を書くこと自体は文法違反ではない（コンパイルは通る。Aは誤り）。ただし、アロー構文はそもそもフォールスルーしない仕組みなので、この`break`は実質的に「ブロックの最後に到達した場合と同じ効果」しか持たず、**書いても書かなくても動作は変わらない冗長なコード**になる。
- `default`に`throw`を書くことも問題ない（Cは誤り、`switch`式ではなく`switch`文としての`throw`は普通に使える）。
- 複数ラベル(`case "A", "B"`)とアロー構文は普通に組み合わせられる（Eは誤り）。
- `s = "A"`は`case "A", "B"`に一致するので、そのブロックの`System.out.println("A-B")`が実行されるだけで、`default`の`throw`まで到達しない（Dは誤り）。
- `javac`/`java`で検証済み：`A-B`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q21"></a>
## 問題21(sample/chap3/21)

```java
public class Main {
    public static void main(String[] args) {
        int month = 6;
        System.out.println(month + " is " +
            switch (month) {
                case 12, 1, 2:  yield "Winter";
                case 3, 4, 5:   yield "Spring";
                case 6, 7, 8:   yield "Summer";
                case 9, 10, 11: yield "Autumn";
                default:        yield "N/A";
            });
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `6 is Summer`
B. `Summer`のみ（`month + " is " +`の部分は評価されない）
C. コンパイルエラーになる（`+`演算子の途中に`switch`式を埋め込むことはできない）
D. `6 is Spring`
E. `6 is N/A`

**解答**

正解：**A**

**補足**

- `switch`式は、値を返す「式」として扱われるので、他の式の一部（今回は`+`による文字列連結の一部）として直接埋め込むことができる（Cは誤り）。
- `month = 6`は`case 6, 7, 8:`に一致し`yield "Summer"`。この`"Summer"`が`switch`式全体の評価結果になる。
- 文字列連結全体は`month + " is " + (switch式の結果)`という1つの式として評価されるので、`"6"`も`" is "`も`"Summer"`もすべて連結されて出力される（Bは誤り）。
- `javac`/`java`で検証済み：`6 is Summer`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex2"></a>
## 問題ex2(sample/chap3/ex2)

```java
public class Main {
    public static void main(String[] args) {
        int a = 10; double b = 2.0;
        var v = 2 + a / b * 5;
        System.out.println(v);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `27`
B. `27.0`
C. `2` （整数除算が優先されるため`a/b`の時点で`5`になり、以降整数として計算される）
D. コンパイルエラーになる（`int`と`double`が混在する式は`var`で受けられない）
E. `12.0`

**解答**

正解：**B**

**補足**

- `a`(`int`)と`b`(`double`)が混在する演算では、`int`側が自動的に`double`に昇格されてから計算される。よって`a / b`は整数除算ではなく`10 / 2.0 = 5.0`という浮動小数点の除算になる（Cは誤り）。
- 続けて`5.0 * 5 = 25.0`、`2 + 25.0 = 27.0`。全体が`double`型の値になる。
- `var`は右辺の式全体の型（ここでは`double`）をそのまま推論するだけで、混在する式自体を禁止するような制約は無い（Dは誤り）。
- `javac`/`java`で検証済み：`27.0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex3"></a>
## 問題ex3(sample/chap3/ex3)

```java
public class Main {
    public static void main(String[] args) {
        int x = 5, y = 1;
        System.out.println(++x + x++ + y++ + ++y);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `14`
B. `15`
C. `16`
D. `18`
E. コンパイルエラーになる（1つの式の中で同じ変数を複数回インクリメントすることはできない）

**解答**

正解：**C**

**補足**

- 1つの式の中で同じ変数に対して複数回インクリメント演算子を使うこと自体は文法上問題ない（Eは誤り、実務では読みにくいので避けるべきだが試験には出うる）。
- 左から順に評価する：`++x`（`x`は`5→6`、式の値は`6`）→ `x++`（式の値は現在の`x`である`6`、その後`x`は`7`になる）→ `y++`（式の値は現在の`y`である`1`、その後`y`は`2`になる）→ `++y`（`y`は`2→3`、式の値は`3`）。
- 合計：`6 + 6 + 1 + 3 = 16`。
- `javac`/`java`で検証済み：`16`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex4"></a>
## 問題ex4(sample/chap3/ex4)

```java
public class Main {
    public static void main(String[] args) {
        byte data = 10;
        int[] array = {data, (int)10.5};
        System.out.println(array[0] < array[1]);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true`
B. `false`
C. コンパイルエラーになる（`byte`型の変数を`int[]`の初期化子に直接混ぜることはできない）
D. コンパイルエラーになる（`double`から`int`への変換にはキャストが必要だが、それでも配列の初期化子には使えない）
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**B**

**補足**

- `byte`型の値は`int`より表現できる範囲が狭い型なので、**暗黙的に(キャスト無しで)`int`へ昇格**できる。`int[]`の初期化子の中に`byte`型の変数をそのまま書いても問題ない（Cは誤り）。
- `(int)10.5`は明示的なキャストにより`10`になる（小数部切り捨て）。配列の初期化子の中で式やキャストを使うことも普通に許される（Dは誤り）。
- 結果として`array = {10, 10}`。`array[0] < array[1]`は`10 < 10`で`false`。
- `javac`/`java`で検証済み：`false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex5"></a>
## 問題ex5(sample/chap3/ex5・複数選択)

```java
public class Main {
    public static void main(String[] args) {
        System.out.print(" value:" + 10 + 5);
        System.out.print(" value:" + 10 * 2 - 5);
        System.out.print(" value:" + 5 + 10 * 2);
    }
}
```

このプログラムについて、正しい記述をすべて選んでください。（複数選択）

A. 1行目(`" value:" + 10 + 5`)は問題なくコンパイルできる
B. 2行目(`" value:" + 10 * 2 - 5`)は問題なくコンパイルできる
C. 2行目は、`" value:" + 10 * 2`の時点で一度`String`になり、その`String`から`5`を引こうとしてコンパイルエラーになる
D. 3行目(`" value:" + 5 + 10 * 2`)は問題なくコンパイルできる
E. このプログラム全体は、いずれか1行でもコンパイルエラーがあれば、他の行が正しくても全体としてコンパイルが失敗する

**解答**

正解：**A、C、D、E**（Bは誤り、Cが正確な理由）

**補足**

- `+`は数値の加算にも文字列の連結にも使えるが、`-`は**数値専用**で`String`に対しては使えない演算子。`*`, `-`は`+`より演算子の優先順位が高いので先に計算されるが、それでも「一度`String`になった後に`-`を使おうとする」構造自体は変わらない。
- 1行目：`" value:" + 10 + 5`は左から順に`+`だけで評価される。`" value:" + 10` → 文字列連結で`" value:10"`。さらに`+ 5` → 文字列連結で`" value:105"`。全部`+`なので問題なし（Aは正しい）。
- 2行目：`*`が先に計算され`10 * 2 = 20`。式は`" value:" + 20 - 5`となる。`" value:" + 20` → 文字列連結で`" value:20"`（`String`型）。続く`"..." - 5`は**`String`から`int`を引く**という不正な演算になり、ここでコンパイルエラーになる（B・Cの通り）。
- 3行目：`10 * 2 = 20`が先に計算され、式は`" value:" + 5 + 20`となる。すべて`+`なので左から順に文字列連結され問題なし（Dは正しい）。
- 1つのファイルの中でどこか1行でもコンパイルエラーがあれば、他の行が正しくても**そのファイル全体のコンパイルが失敗する**（Eは正しい。エラーの無い行だけ実行される、ということはない）。
- `javac`で検証済み：2行目の`- 5`の部分で「二項演算子'-'のオペランド型が不正です（最初の型: String、2番目の型: int）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex6"></a>
## 問題ex6(sample/chap3/ex6)

```java
public class Main {
    public static void main(String[] args) {
        int a = 10, b = 10, x, y;
        x = ++a;
        y = b--;
        int val = y < --x ? x++ : ++y;
        System.out.println("val:" + val);
        System.out.println("x:" + x + " y:" + y);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `val:11` の後 `x:10 y:11`
B. `val:10` の後 `x:11 y:10`
C. `val:11` の後 `x:11 y:11`
D. `val:12` の後 `x:12 y:10`
E. コンパイルエラーになる（三項演算子の分岐の中で`++`や`--`のような副作用のある式を使うことはできない）

**解答**

正解：**A**

**補足**

- 三項演算子の各分岐の中でインクリメント/デクリメントのような副作用のある式を使うこと自体は文法上問題ない（Eは誤り。ただし実際に実行されるのは選ばれた分岐だけ）。
- `x = ++a;`：`a`は`10→11`、`x = 11`。`y = b--;`：`y`は現在の`b`である`10`、その後`b`は`9`になる（`b`はこれ以降使わない）。
- 三項演算子の条件部分`y < --x`：`--x`で`x`は`11→10`、条件は`10 < 10`で`false`。
- **条件が`false`なので、真の分岐(`x++`)は一切評価されず**、偽の分岐`++y`だけが実行される。`y`は`10→11`、この式全体の値は`11`。よって`val = 11`。
- `x`は条件式の中の`--x`で`10`になったところで止まっており(真の分岐の`x++`が実行されていないので、それ以上変化しない)、最終的に`x:10`。`y:11`。
- `javac`/`java`で検証済み：`val:11` / `x:10 y:11`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex7"></a>
## 問題ex7(sample/chap3/ex7)

`sample/chap3/ex7/Main.java`には、実は次のコードがそのまま含まれています。

```java
public class Main {
    public static void main(String[] args) {
        int a = 5, b = 10;
        int x = a >= b ? a += 2 : a < b :  b -= 2 ? b * 2;
        System.out.println(x);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `x`には`10`が代入され、`10`が出力される
B. `x`には`14`が代入され、`14`が出力される
C. 三項演算子が正しくネストされておらず、構文として破綻しておりコンパイルエラーになる
D. 三項演算子は1つの式に1回しか使えないためコンパイルエラーになる
E. 実行時に`ArithmeticException`がスローされる

**解答**

正解：**C**

**補足**

- 三項演算子`条件 ? 値A : 値B`は「`?`と`:`が必ず1組」という構造を持つ。今回の`a >= b ? a += 2 : a < b : b -= 2 ? b * 2`は、`:`が余分に登場してしまっており、正しくネストされた三項演算子として構文解析できない（Dのような「三項演算子は1回しか使えない」という制約自体は存在しないが、そもそも今回はネストの書き方自体が壊れている）。
- **このサンプルファイル自体が、現状コンパイルの通らない壊れたコード**になっている。
- `javac`で検証済み（`sample/chap3/ex7/Main.java`をそのままコンパイル）：「';'がありません」「':'がありません」の2件のエラー。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8(sample/chap3/ex8)

```java
public class Main {
    public static void main(String[] args) {
        String J = "J";
        String s1 = "Java";
        String s2 = J + "ava";
        String s3 = "Ja" + "va";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true` `true`
B. `false` `true`
C. `false` `false`
D. `true` `false`
E. コンパイルエラーになる（変数を使った文字列連結は`==`比較できない）

**解答**

正解：**B**

**補足**

- `s2 = J + "ava"`：`J`は変数なので、コンパイル時にはその値が定数として確定していない。よってこの連結は実行時に新しい`String`オブジェクトを生成する処理になり、中身が`"Java"`と同じでも`s1`とは別オブジェクト。`s1 == s2`は`false`。
- `s3 = "Ja" + "va"`：両方ともリテラル同士の連結なので、コンパイル時に`"Java"`という1つの定数に畳み込まれる(constant folding)。文字列プール上の`s1`と同じオブジェクトを指すため`s1 == s3`は`true`。
- `==`比較自体はどんな`String`変数同士でも文法上可能（Eは誤り、あくまで参照比較として成立する）。
- `javac`/`java`で検証済み：`false` / `true`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex9"></a>
## 問題ex9(sample/chap3/ex9)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Java");
        sb1.append("Java");
        String s1 = "Java";
        String s2 = sb2.toString();
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(sb1));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true` `true` `true` `true` `true`
B. `false` `false` `true` `true` `false`
C. `false` `false` `false` `true` `false`
D. `false` `true` `false` `true` `true`
E. `false` `false` `false` `true` `true`

**解答**

正解：**C**

**補足**

- `sb1`と`sb2`はそれぞれ別々に`new`された、内容がたまたま同じ(`"Java"`)になった別オブジェクト。`==`は`false`、`StringBuilder`は`equals()`を独自実装していないので参照比較のまま`false`。
- `s2 = sb2.toString()`は、**呼び出すたびに新しい`String`オブジェクトを生成する**メソッド。中身が同じ`"Java"`であっても、リテラルの`s1`（文字列プール）とは別オブジェクトなので`s1 == s2`は`false`。ただし`equals()`は中身を比較するので`true`。
- `s1.equals(sb1)`：`String.equals()`は、比較相手が`String`型でなければ内部で即座に`false`を返す（型が違う時点で内容比較にすら進まない）。`sb1`は`StringBuilder`なので`false`。
- `javac`/`java`で検証済み：`false` `false` `false` `true` `false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11(sample/chap3/ex11)

```java
public class Main {
    public static void main(String[] args) {
        var v = 10;
        if (v == 10.5)
            System.out.println(10.5);
        System.out.println("done");
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `10.5` `done` の順に出力される
B. `done` のみが出力される
C. `v == 10.5`の行でコンパイルエラーになる（`var`で推論された`int`型と`double`リテラルは直接比較できない）
D. `var`は`double`との比較を想定していないため、`v`自体が`double`型として再推論される
E. 実行時に例外がスローされる

**解答**

正解：**B**

**補足**

- `var v = 10;`により`v`は`int`型と推論される。`int`と`double`の`==`比較は、`int`側が自動的に`double`に昇格されてから行われるため、コンパイルは問題なく通る（C・Dは誤り。`var`で推論された型は一度決まったら変わらない）。
- `10`(int→double変換後`10.0`) と `10.5` は等しくないので`v == 10.5`は`false`。`if`の中身は実行されない。
- `System.out.println("done");`は`if`の外にあるので無条件に実行される。
- `javac`/`java`で検証済み：`done`のみ。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex12"></a>
## 問題ex12(sample/chap3/ex12)

```java
public class Main {
    public static void main(String[] args) {
        int a = 1, b = 2, x = 5, y = 10;
        var v = 0;
        if ((++a == b) | ((x *= 2) == y)) v = x;
        else v = y;
        System.out.println("v:" + v);
        System.out.println("x:" + x);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `v:10` の後 `x:5`（左辺が真なので右辺の`x *= 2`は評価されない）
B. `v:10` の後 `x:10`
C. `v:5` の後 `x:5`
D. コンパイルエラーになる（複合代入式`x *= 2`を条件式の中に書くことはできない）
E. 実行時に例外がスローされる

**解答**

正解：**B**

**補足**

- `++a`で`a`は`1→2`。`a == b`は`2 == 2`で`true`。
- `|`（非短絡の論理和）は、**左辺がすでに`true`であっても、右辺を必ず評価する**という点が`||`（短絡評価）との決定的な違い。よって`(x *= 2) == y`も実行され、`x`は`5→10`に書き換わる（Aは誤り、短絡評価と混同しないこと）。`10 == 10`で`true`。
- 全体は`true | true = true`なので`if`側が実行され、`v = x = 10`。
- 複合代入式は値を持つ式として、条件式の一部に組み込むことができる（Dは誤り）。
- `javac`/`java`で検証済み：`v:10` / `x:10`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13(sample/chap3/ex13)

```java
public class Main {
    public static void main(String[] args) {
        int length = args.length;
        if (length = 2) {
            System.out.println("Welcome");
        } else {
            System.out.println("Bye");
        }
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 引数を2個渡せば`Welcome`、それ以外なら`Bye`が出力される
B. `length = 2`という代入によって、常に`length`が`2`になった上で判定されるため、常に`Welcome`が出力される
C. `if (length = 2)`の行でコンパイルエラーになる（`if`の条件には`boolean`型の式が必要）
D. `length == 2`の書き間違いを検出して、コンパイラが自動的に警告付きで比較として扱う
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**C**

**補足**

- `if (条件)`の`条件`部分には**`boolean`型の値を持つ式**が必要。`length = 2`は「比較」ではなく「**代入**」の式であり、この式全体の値は代入後の値である`int`型の`2`になる。
- C言語では`int`を条件式に流用できる場合があるが、**Javaでは`int`を`boolean`が必要な場所にそのまま使うことはできず**、暗黙変換も行われない。
- `==`（比較）と`=`（代入）の書き間違いは、Javaでは`boolean`変数の条件式でこの手のミスをすると即座にコンパイルエラーとして検出される（Dのような自動修正機能は無い）ため、C言語などと違って比較的安全とされる。
- `javac`で検証済み：「不適合な型: intをbooleanに変換できません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14(sample/chap3/ex14)

```java
public class Main {
    public static void main(String[] args) {
        String[] array = {"H", "e", "l", "l", "o"};
        String text = "";
        if (array[0] == "H") {
            text += array[0];
        }
        if (!(array[2] == "e")) {
            text += "e";
        } else if (array[4].equalsIgnoreCase("O")) {
            text += "o";
        } else {
            text += "!";
        }
        System.out.println(text);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Ho`
B. `He`
C. `H!`
D. `e`
E. コンパイルエラーになる（配列の要素同士は`==`で比較できない）

**解答**

正解：**B**

**補足**

- 配列リテラル`{"H", "e", "l", "l", "o"}`の各要素はコンパイル時に確定する文字列リテラルなので、文字列プール上の同じ`"H"`, `"e"`等を指す。`array[0] == "H"`のような**リテラル同士の`==`比較**は、たまたまプールの仕組みにより`true`になる（Eは誤り、`==`自体はどんな参照型同士でも書ける）。
- `array[0] == "H"`は`true`なので`text += array[0]`で`text = "H"`。
- `array[2]`は`"l"`。`array[2] == "e"`は`false`なので`!(false)`は`true`。よって`if`側(`text += "e"`)が実行され、`else if`（`array[4]`(`"o"`)を`equalsIgnoreCase("O")`する箇所）には到達しない（Aは誤り）。
- 最終的に`text = "H" + "e" = "He"`。
- `javac`/`java`で検証済み：`He`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15(sample/chap3/ex15)

```java
public class Main {
    public static void main(String[] args) {
        var v1 = "Hello Java SE";
        var v2 = new StringBuilder("Hello Java SE");
        var v3 = v1.replace("Hello", "Hi");
        var v4 = v2.replace(0, 5, "Hi").toString();
        String s = "";
        if (v1 == v3) {
            if (v1 == v4) s = "v1, v3, v4";
        } else {
            if (v3.equals(v4))
                s = "v3, v4";
            s = "N/A";
        }
        System.out.println(s);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `v3, v4`
B. `N/A`
C. `v1, v3, v4`
D. 空文字列（何も代入されないまま）
E. コンパイルエラーになる（`if`の中に`{}`の無い1文と`{}`付きの文が混在している）

**解答**

正解：**B**

**補足**

- `v1.replace(...)`は`String`の非破壊的メソッドで新しい`String`を返すため、内容が変わっていれば`v1 == v3`は`false`。`else`側に進む。
- `v3.equals(v4)`は中身がどちらも`"Hi Java SE"`になるため`true`。よって`if`側の`s = "v3, v4";`が実行される……が、**`if`に`{}`が無いため、対象はこの1文だけ**。次の行`s = "N/A";`は`if-else`の外側にある独立した文として**常に実行される**。
- 結果として`s`は一度`"v3, v4"`になった直後に`"N/A"`で上書きされ、最終的に出力されるのは`"N/A"`。「`if`の中に見えるインデントに惑わされて、`s = "N/A";`まで条件付きだと誤解する」のがこの問題の狙い。
- `{}`の有無が混在していること自体はコンパイルエラーの原因にならない（Eは誤り）。
- `javac`/`java`で検証済み：`N/A`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex16"></a>
## 問題ex16(sample/chap3/ex16)

```java
public class Main {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        if (x < 100)
            System.out.print("A");
        else if (x <= 100 && x >= 50)
            System.out.print("B");
        else
            System.out.println("C");
    }
}
```

コマンドライン引数として`"70"`を1つ渡して実行した場合、何が出力されますか。（1つ選択）

A. `A`のみ
B. `B`のみ
C. `A`と`B`の両方
D. `C`
E. `x <= 100 && x >= 50`という書き方はコンパイルエラーになる（範囲を表す条件は`50 <= x && x <= 100`の順で書かなければならない）

**解答**

正解：**A**

**補足**

- `x = 70`。最初の`if (x < 100)`が`true`になった時点で、`System.out.print("A")`が実行され、**この`if-else if-else`の連鎖全体を抜ける**。後続の`else if`や`else`は一切評価されない（C・Bは誤り、`70`は`50〜100`の範囲にも入るが、最初の条件で確定して終わるのでそこには到達しない）。
- 比較演算子`<=`や`>=`は、書く順序（`x <= 100`でも`100 >= x`でも）に関する制約は無く、今回のような書き方も正当（Eは誤り）。
- `javac`/`java`で検証済み（引数`"70"`を渡して実行）：`A`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex18"></a>
## 問題ex18(sample/chap3/ex18)

```java
public class Main {
    public static void main(String[] args) {
        final char a = 'a';
        char k = 'k';
        int val = 0;
        switch ("Black".charAt(3)) {
            case a:
                val += 1; break;
            case a + 2:
                val += 2;
            case k:
                val += 3;
        }
        System.out.println(val);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`5`が出力される
B. `case k:`の行でコンパイルエラーになる（`k`が`final`ではなく、コンパイル時定数として扱えないため）
C. `case a:`の行でコンパイルエラーになる（`final`変数は`case`ラベルに使えない）
D. `case a + 2:`の行でコンパイルエラーになる（`case`ラベルには算術式を書けない）
E. 実行時に`ArithmeticException`がスローされる

**解答**

正解：**B**

**補足**

- `switch`の`case`ラベルには**コンパイル時定数**しか書けない。`final char a = 'a';`のように`final`かつリテラルで初期化された変数は「コンパイル時定数」として扱われるので、`case a:`はOK（Cは誤り）。`a + 2`も、`final`な定数同士の演算はコンパイル時に計算できるためOK（Dは誤り）。
- 一方`char k = 'k';`は`final`が付いていない**通常の変数**。値が変わらないとしても、コンパイラの目からは「実行時にならないと確定しない可能性がある値」として扱われ、コンパイル時定数の条件を満たさない。
- `"Black".charAt(3)`は`'c'`だが、これはこの問題の本質ではない（そもそも`case k:`の時点でコンパイルが失敗するため、実行結果自体が存在しない）。
- `javac`で検証済み：`case k:`の行で「定数式が必要です」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex19"></a>
## 問題ex19(sample/chap3/ex19)

```java
public class Main {
    public static void main(String[] args) {
        int i = 3;
        switch (i++) {
            case 1, 2 -> i += 10;
            case 3, 4 -> i *= 2;
            default -> i = 0;
        }
        System.out.println(i);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `6`
B. `8`
C. `13`
D. `0`
E. `26`

**解答**

正解：**B**

**補足**

- `switch (i++)`の`i++`は**後置インクリメント**。「`switch`の条件判定に使われる値は現在の`i`(`3`)だが、判定に使うために評価された瞬間、副作用として`i`はすでに`4`にインクリメントされている」という点がポイント。
- 判定に使われる値は`3`なので`case 3, 4`に一致し、`i *= 2`が実行される。しかしこの時点で**`i`の実際の値はすでに`4`になっている**（`switch`の選択に使われた値`3`とは別）。
- よって`i *= 2`は`4 * 2 = 8`となり、`i`は`8`になる。「switchの判定値」と「その後の処理で実際に使われる変数`i`の値」がズレる点に注意。
- `javac`/`java`で検証済み：`8`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex20"></a>
## 問題ex20(sample/chap3/ex20)

```java
public class Main {
    public static void main(String[] args) {
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9: yield "A";
            case 8: yield "B";
            case 7: yield "C";
        };
        System.out.println(grade);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`B`が出力される
B. 問題なくコンパイルが通り`C`が出力される
C. コンパイルエラーになる（`switch`式の対象(`score / 10`)に`default`が無く、全ての`int`値を網羅できていないため）
D. `score`が`85`のとき`8.5`に対応する`case`が無いためコンパイルエラーになる
E. 実行時に、どの`case`にも一致しないことによる例外がスローされる

**解答**

正解：**C**

**補足**

- `score / 10`は`int`同士の除算なので`8`（整数除算、小数点以下切り捨て）になり、これ自体は正当な整数値（Dのような「8.5に対応するcaseが無い」という懸念はそもそも成立しない）。
- `switch`**式**は、対象の型が`enum`や`sealed`型のように「取りうる値をコンパイラが全て把握できる」場合を除き、**`default`が無ければ網羅性を保証できずコンパイルエラーになる**。`int`はまさにその「網羅性を保証できない」型の代表例。
- 今回は`case 10,9`, `8`, `7`だけがあり`default`が無いため、たとえ実際に渡ってくる値(`8`)がカバーされていても、**コンパイラは全ての`int`値の可能性を考慮する**のでエラーになる。実行時まで到達しないのでEも誤り。
- `javac`で検証済み：「switch式がすべての可能な入力値をカバーしていません」。

**実施記録**

回答：
正解：
迷ったポイント：