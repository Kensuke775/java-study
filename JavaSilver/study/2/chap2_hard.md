# 第2章 サンプル発展問題(1〜16・ex5,8,9,10,11,13,14,15 各1問、計24問)

`sample/chap2/1`〜`16`・`ex5,8,9,10,11,13,14,15`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題1(sample/chap2/1・複数選択)](#q1)
- [問題2(sample/chap2/2)](#q2)
- [問題3(sample/chap2/3)](#q3)
- [問題4(sample/chap2/4)](#q4)
- [問題5(sample/chap2/5)](#q5)
- [問題6(sample/chap2/6)](#q6)
- [問題7(sample/chap2/7)](#q7)
- [問題8(sample/chap2/8)](#q8)
- [問題9(sample/chap2/9)](#q9)
- [問題10(sample/chap2/10)](#q10)
- [問題11(sample/chap2/11)](#q11)
- [問題12(sample/chap2/12)](#q12)
- [問題13(sample/chap2/13)](#q13)
- [問題14(sample/chap2/14)](#q14)
- [問題15(sample/chap2/15)](#q15)
- [問題16(sample/chap2/16)](#q16)
- [問題ex5(sample/chap2/ex5)](#qex5)
- [問題ex8(sample/chap2/ex8)](#qex8)
- [問題ex9(sample/chap2/ex9)](#qex9)
- [問題ex10(sample/chap2/ex10)](#qex10)
- [問題ex11(sample/chap2/ex11)](#qex11)
- [問題ex13(sample/chap2/ex13)](#qex13)
- [問題ex14(sample/chap2/ex14)](#qex14)
- [問題ex15(sample/chap2/ex15)](#qex15)

<a id="q1"></a>
## 問題1(sample/chap2/1・複数選択)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("James");
        StringBuilder sb3 = new StringBuilder("James");
        System.out.println(sb1 == sb3);
        System.out.println(sb1.equals(sb3));
        System.out.println(sb1.toString().equals(sb3.toString()));
    }
}
```

このプログラムを実行したときの出力について、正しい記述をすべて選んでください。（複数選択）

A. 1行目(`sb1 == sb3`)は`false`になる
B. 2行目(`sb1.equals(sb3)`)は`true`になる（中身の文字列が同じだから）
C. 2行目(`sb1.equals(sb3)`)は`false`になる（`StringBuilder`は`equals()`をオーバーライドしていないため）
D. 3行目(`sb1.toString().equals(sb3.toString())`)は`true`になる
E. `sb1`と`sb3`は同じオブジェクトを参照している

**解答**

正解：**A、C、D**

**補足**

- `sb1`と`sb3`はそれぞれ別の`new`で生成された、**別々のオブジェクト**。`==`は参照(アドレス)の比較なので`false`（Aは正しい、Eは誤り）。
- **`StringBuilder`は`equals()`をオーバーライドしていない**（`String`とは違う点に注意）。そのため`Object`のデフォルト実装がそのまま使われ、結局`==`と同じ「参照の比較」になる。中身の文字列が同じでも`sb1.equals(sb3)`は`false`（Cが正しく、Bは誤り）。
- 一方`toString()`で`String`に変換すれば、`String`は`equals()`を内容比較にオーバーライドしているので、中身が同じなら`true`になる（Dは正しい）。「`StringBuilder`は中身で比較、`String`に変換すれば中身で比較」という対比がポイント。
- `javac`/`java`で検証済み：`false` `false` `true`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap2/2)

```java
public class Main {
    public static void main(String[] args) {
        String t4 = """
                Red    \s
                Black \
                end""";
        System.out.print(t4);
        System.out.println("|");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
Red    
Black end|
```

B.
```
Red
Black
end|
```

C.
```
RedBlackend|
```

D. コンパイルエラーになる（テキストブロックの中で`\`や`\s`は使用できない）
E.
```
Red    \s
Black \
end|
```

**解答**

正解：**A**

**補足**

- `\s`はテキストブロック専用のエスケープで、**行末の空白がテキストブロックの自動トリム対象から除外され、そのまま1個の半角スペースとして残る**。よって`"Red    "`の行末に`\s`分の空白が確実に残る。
- 行末の単独の`\`（バックスラッシュ）は**行連結**を意味し、その行の改行そのものを無かったことにして次の行と1行に繋げる。`"Black \"`の直後に改行を挟まず`"end"`が続くので`"Black end"`という1行になる。
- D・Eのように「テキストブロックの中では特殊文字が使えない／そのまま文字として出力される」ということはなく、通常の文字列と同様にエスケープシーケンスとして解釈される。
- `javac`/`java`で検証済み：`Red    ` (行末に空白) → 改行 → `Black end|`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap2/3)

`sample/chap2/3/Main.java`には、実は次の1行が含まれています（見た目はほぼ同じですが、`\`(バックスラッシュ)ではなく`¥`(円記号、Unicode上は別の文字)が使われています）。

```java
System.out.println('¥u0061');
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`a`が出力される（`¥`も`\`と同じくUnicodeエスケープの開始文字として扱われる）
B. コンパイルエラーになる（`¥u0061`はUnicodeエスケープとして認識されず、文字リテラルとして不正な形になる）
C. コンパイルは通るが、実行時に文字化けした記号が出力される
D. `¥`という1文字がそのまま出力される（`u0061`の部分は無視される）
E. 日本語ロケールの環境でのみ正しく`a`として解釈される

**解答**

正解：**B**

**補足**

- Unicodeエスケープ(`\uXXXX`)として認識されるのは、あくまで**バックスラッシュ`\`(U+005C)**から始まる場合だけ。**円記号`¥`(U+00A5)**は見た目が似ていても全くの別文字であり、コンパイラはこれを特別扱いしない。
- 日本語フォント・一部の日本語配列キーボードでは`\`が`¥`として表示・入力されることがあるため、目視だけでは区別がつきにくい（Eのような「日本語環境なら大丈夫」という仕組みは存在しない。むしろ逆で、この混同は日本語環境で起きやすい典型的なトラブル）。
- `'¥u0061'`は「`¥`という1文字と、`u0061'`という続きの文字」として扱われようとし、**閉じられていない文字リテラル**として解析が破綻する。
- `javac`で実際に検証済み（`sample/chap2/3/Main.java`をそのままコンパイル）：「文字リテラルが閉じられていません」というエラーが2件、「文ではありません」というエラーが1件、計3件のエラーになる。**このサンプルファイル自体、現状ではコンパイルが通らない状態**になっている。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap2/4)

```java
public class Main {
    public static void main(String[] args) {
        char c1, c2;
        c1 = 'J';
        System.out.println("c1 : " + c1);
        System.out.println("c2 : " + c2);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `c1 : J` `c2 : ` の順に出力される（`c2`は`char`のデフォルト値である`\0`として扱われる）
B. `c1 : J`のみが出力される
C. `c2`を使用している行でコンパイルエラーになる（初期化されていない可能性がある変数）
D. `char c1, c2;`の宣言行でコンパイルエラーになる（複数のローカル変数を1行で宣言できない）
E. 実行時に`c2`が`null`として扱われ、`NullPointerException`がスローされる

**解答**

正解：**C**

**補足**

- **ローカル変数にはフィールドのような自動的なデフォルト値は無い**。`char`型フィールドなら`\0`で自動初期化されるが、ローカル変数の`c2`は「宣言されただけで未初期化」の状態（A・Eは誤り、`char`はそもそも参照型ではないので`null`にもならない）。
- 1つの`char`型として`c1, c2`をカンマ区切りで同時に宣言すること自体は問題ない（Dは誤り）。
- **未初期化のローカル変数を、値を読み取る形で使用しようとするとコンパイルエラーになる**（代入せずに使おうとした時点で検出される）。今回は`c1`だけ代入され`c2`は未代入のまま`+`演算子で参照しようとしているのでアウト。
- `javac`で検証済み：「変数`c2`は初期化されていない可能性があります」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap2/5)

```java
public class Main {
    public static void main(String[] args) {
        long l1 = 2_200_000_000;
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（代入先が`long`型なので、右辺のリテラルも自動的に`long`として扱われる）
B. コンパイルエラーになる（`2_200_000_000`は`int`の範囲を超えており、リテラル自体には`L`が必要）
C. `long`型変数への代入なので、範囲を超えても自動的に丸められる
D. アンダースコア(`_`)区切りが3桁ごとになっていないためコンパイルエラーになる
E. 実行時に`ArithmeticException`がスローされる

**解答**

正解：**B**

**補足**

- 整数リテラルは、末尾に`L`(または`l`)を付けない限り**デフォルトで`int`型**として解釈される。`2_200_000_000`（アンダースコアを除くと`2200000000`）は`int`の最大値(`2,147,483,647`)を超えているため、**代入先の型が`long`かどうかに関わらず、リテラル自体の時点で範囲外エラーになる**（Aは誤り。「代入先を見てから自動調整してくれる」わけではない）。
- アンダースコア区切りは3桁ごとである必要はなく、数字と数字の間であれば自由な位置に挿入できる（Dは誤り。あくまで可読性のための機能で桁区切りルールの強制はない）。
- 正しく書くには`long l1 = 2_200_000_000L;`のように`L`を付ける必要がある。
- `javac`で検証済み：「整数が大きすぎます」。`L`を付けた版は問題なくコンパイル・実行でき`2200000000`が出力される。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap2/6)

```java
public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        String original = s;
        s = s + " Duke";
        System.out.println(s);
        System.out.println(original);
        System.out.println(s == original);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
Hello World Duke
Hello World Duke
true
```

B.
```
Hello World Duke
Hello World
false
```

C.
```
Hello World Duke
Hello World
true
```

D. `original`も`"Hello World Duke"`に書き換わってしまうため、`println(original)`は`Hello World Duke`になる
E. コンパイルエラーになる（`String`は`+`演算子で連結できない）

**解答**

正解：**B**

**補足**

- `String`は**イミュータブル(不変)**。`s = s + " Duke";`は、既存の`"Hello World"`というオブジェクトの中身を書き換えているのではなく、**新しい`String`オブジェクトを生成し、その新しいオブジェクトへの参照を変数`s`に再代入している**。
- `original`は元の`"Hello World"`オブジェクトへの参照を保持したままなので、書き換わらない（Dは誤り）。
- `s`と`original`は今や**別のオブジェクト**を指しているので、`s == original`（参照比較）は`false`（A・Cは誤り）。
- `+`による文字列連結はJavaの基本機能としてサポートされている（Eは誤り）。
- `javac`/`java`で検証済み：`Hello World Duke` / `Hello World` / `false`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q7"></a>
## 問題7(sample/chap2/7)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("GoldSilver");
        sb.append("GGG").substring(0);
        System.out.println(sb);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `GoldSilverGGG`
B. `GoldSilver`
C. `GoldSilverGGG`が`sb`とは別に生成されるが、`sb`自体は`GoldSilver`のまま
D. コンパイルエラーになる（`String`を返す`substring()`の後にさらに`StringBuilder`用のメソッドを繋げていないため）
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**A**

**補足**

- `sb.append("GGG")`は`sb`自身に`"GGG"`を追記し、その`StringBuilder`（`sb`自身）への参照を返す。この時点で`sb`の中身はすでに`"GoldSilverGGG"`になっている。
- 続く`.substring(0)`は、その時点の`sb`の中身から**新しい`String`オブジェクトを生成して返すだけ**で、`sb`自身の中身を変更する操作ではない。この戻り値はどこにも代入されずに捨てられている。
- よって最終的に`println(sb)`で表示されるのは、`append`によってすでに変更された後の`sb`の中身、つまり`"GoldSilverGGG"`（Bは誤り、`substring`が`sb`を元に戻すような効果は無い）。
- メソッドチェーンの途中で戻り値の型が変わっても(`StringBuilder`→`String`)、その戻り値をさらに使わずに文として終わらせること自体はコンパイルエラーにならない（Dは誤り）。
- `javac`/`java`で検証済み：`GoldSilverGGG`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q8"></a>
## 問題8(sample/chap2/8)

```java
public class Main {
    public static void main(String[] args) {
        int[] vers = new int[3];
        vers[0] = 8; vers[1] = 11; vers[2] = 17;
        System.out.println(vers[3]);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `0`（初期化されていない要素なのでデフォルト値が返る）
B. `17`（最後の要素の値が使い回される）
C. コンパイルエラーになる
D. 実行時に`ArrayIndexOutOfBoundsException`がスローされる
E. 何も出力されずに正常終了する

**解答**

正解：**D**

**補足**

- `new int[3]`で生成される配列の有効な添字は`0, 1, 2`の3つだけ。`vers[3]`という4番目の要素は**そもそも存在しない**。
- 配列の範囲外アクセスは**コンパイル時には検出されない**（添字は実行時に評価される値なので、コンパイラには`3`が範囲内か外かの判断がつかない。Cは誤り）。デフォルト値が返ってくるようなこともない（A・Bは誤り、それは「存在するが未代入の要素」の場合の話であり、今回は要素自体が存在しない）。
- 実行時に`ArrayIndexOutOfBoundsException`がスローされ、キャッチする処理が無いのでプログラムはそこで異常終了する。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q9"></a>
## 問題9(sample/chap2/9)

```java
public class Main {
    public static void main(String[] args) {
        double[] darr = new double[1];
        String[] sarr = new String[1];
        System.out.println("darr[0] : " + darr[0]);
        System.out.println("sarr[0] : " + sarr[0]);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
darr[0] : 0.0
sarr[0] : null
```

B.
```
darr[0] : 0
sarr[0] : null
```

C.
```
darr[0] : 0.0
sarr[0] : 
```

D. `sarr[0]`が`null`のまま文字列連結しようとした行で`NullPointerException`がスローされる
E. どちらの配列も未初期化状態なので、両方とも実行時エラーになる

**解答**

正解：**A**

**補足**

- 配列は`new`で生成された時点で、要素ごとの**デフォルト値**で自動的に初期化される。数値型(`double`)は`0.0`（整数のような`0`ではなく、小数点付きの`0.0`。Bは誤り）、参照型(`String`)は`null`になる。
- `null`を`+`で文字列連結しようとした場合、`NullPointerException`にはならず、コンパイラ/実行系が自動的に**文字列`"null"`として扱う**（`String.valueOf(null)`相当の変換が行われる。C・Dは誤り）。
- `javac`/`java`で検証済み：`darr[0] : 0.0` / `sarr[0] : null`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q10"></a>
## 問題10(sample/chap2/10)

```java
public class Main {
    public static void main(String[] args) {
        var arr3 = new int[2] {1, 2};
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（要素数の指定と初期化子は併用できる）
B. `var arr3`の部分がコンパイルエラーになる（`var`は配列の型推論に対応していない）
C. `new int[2] {1, 2}`の部分がコンパイルエラーになる（配列生成でサイズ指定と初期化子リストを同時に使うことはできない）
D. 要素数`2`と実際の要素数`2`が一致しているので問題なくコンパイルが通り、`{1, 2}`は無視される
E. 実行時に配列の長さが不正だという例外がスローされる

**解答**

正解：**C**

**補足**

- 配列を生成するとき、`new 型[要素数]`（要素数を指定する形）と`new 型[]{初期化子...}`（初期化子リストで要素数を暗黙的に決める形）は、**どちらか一方しか使えない**。両方を同時に書くこと自体が文法違反になる（A・Dは誤り。「数が一致していれば大目に見てくれる」という救済は無い）。
- `var`自体はこの問題とは無関係で、配列の型推論には普通に対応している（`var arr1 = new int[3];`のような単独の書き方は問題なくコンパイルできる。Bは誤り）。
- これはコンパイル時に構文として弾かれる問題であり、実行時エラーにはならない（Eは誤り）。
- `javac`で検証済み：「次元式と初期化の両方を使用した配列の作成は無効です」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q11"></a>
## 問題11(sample/chap2/11)

```java
public class Main {
    public static void main(String[] args) {
        int[][] array = {{100, 0, 0}, {0, 0, 200}};
        System.out.println(array.length + ":" + array[0].length + ":" + array[1].length);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `2:3:3`
B. `3:2:2`
C. `6:0:0`
D. `2:2:3`
E. コンパイルエラーになる（2次元配列リテラルの各行の要素数は一致していなければならない）

**解答**

正解：**A**

**補足**

- `array`は「2つの要素（それぞれが`int[]`）を持つ配列」＝`array.length`は`2`。
- `array[0]`は`{100, 0, 0}`（要素数3）、`array[1]`は`{0, 0, 200}`（要素数3）。よって`array[0].length`, `array[1].length`はどちらも`3`。
- 2次元配列リテラルにおいて、各行(内側の配列)の要素数は**揃っている必要はない**（今回はたまたま両方3個だが、揃っていなくても問題ない。Eは誤り。ギザギザ配列として成立する）。
- `javac`/`java`で検証済み：`2:3:3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q12"></a>
## 問題12(sample/chap2/12)

```java
public class Main {
    public static void main(String[] args) {
        int[][] array = {
            {100},
            {0, 0},
            {0, 0, 200}
        };
        System.out.println(array.length + ":" + array[0].length + ":" + array[1].length + ":" + array[2].length);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `3:3:3:3`（内側の配列は自動的に最大要素数に揃えられる）
B. `3:1:2:3`
C. コンパイルエラーになる（各行の要素数が異なっている）
D. `9:1:2:3`（全要素数の合計が`array.length`になる）
E. 実行時に`ArrayIndexOutOfBoundsException`がスローされる

**解答**

正解：**B**

**補足**

- Javaの多次元配列は、実態としては「配列の配列」。各内側の配列(`array[0]`, `array[1]`, `array[2]`)は、それぞれ独立して**異なる長さを持てる**（いわゆるギザギザ配列/jagged array）。自動的に揃えられたり、揃っていないとエラーになったりはしない（A・Cは誤り）。
- `array.length`は「外側の配列の要素数」＝`3`（内側の要素数の合計ではない。Dは誤り）。`array[0].length`は`1`、`array[1].length`は`2`、`array[2].length`は`3`。
- `javac`/`java`で検証済み：`3:1:2:3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q13"></a>
## 問題13(sample/chap2/13)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + "!");
    }
}
```

このプログラムを、コマンドライン引数を1つも渡さずに(`java Main`のように)実行するとどうなりますか。（1つ選択）

A. `Hello null!` が出力される
B. `Hello !` が出力される（`args[0]`は空文字列として扱われる）
C. 実行時に`ArrayIndexOutOfBoundsException`がスローされる
D. コンパイルエラーになる（引数を渡さないことが事前にわかっている）
E. `args`自体が`null`になっているため`NullPointerException`がスローされる

**解答**

正解：**C**

**補足**

- コマンドライン引数を1つも渡さない場合、`args`は`null`になるのではなく、**要素数`0`の空配列**になる（Eは誤り）。
- 要素数`0`の配列に対して`args[0]`という存在しない添字でアクセスしようとしているので、`ArrayIndexOutOfBoundsException`がスローされる（A・Bのような値が返ってくることはない）。
- コマンドライン引数の数はプログラムの**実行時**に決まるものであり、コンパイル時点では検証しようがない（Dは誤り）。
- `javac`/`java`で検証済み（引数なしで実行）：`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q14"></a>
## 問題14(sample/chap2/14)

```java
public class Main {
    public static void main(String[] args) {
        String s1 = "Java Language";
        String s2 = s1.replace("Language", "VM");
        System.out.println(s1);
        System.out.println(s2);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
Java VM
Java VM
```

B.
```
Java Language
Java VM
```

C.
```
Java VM
Java Language
```

D. `replace`は破壊的メソッドなので`s1`も書き換わり、`s2`と同じ結果になる
E. コンパイルエラーになる（`String`に`replace`メソッドは無い）

**解答**

正解：**B**

**補足**

- `String`は不変(イミュータブル)なので、`replace()`のような加工系メソッドは**元の`String`オブジェクトを書き換えず、加工結果を持った新しい`String`オブジェクトを返す**だけ。
- `s1`はそのまま`"Java Language"`のまま変わらず、戻り値を受け取った`s2`だけが`"Java VM"`になる（A・Dは誤り、`replace`は非破壊的メソッド）。
- `replace()`は`String`クラスに標準で用意されているメソッド（Eは誤り）。
- `javac`/`java`で検証済み：`Java Language` / `Java VM`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q15"></a>
## 問題15(sample/chap2/15)

```java
public class Main {
    public static void main(String[] args) {
        String t1 = """
                    Language: %s
                    Version : %d
                    """.formatted("Java", 15);
        System.out.print(t1);
        String t3 = "Hello\\n\\tworld";
        System.out.println(t3);
        System.out.println(t3.translateEscapes());
    }
}
```

次のプログラムを実行すると、`t3`関連の出力(4〜5行目)はどうなりますか。（1つ選択）

A.
```
Hello
	world
Hello
	world
```

B.
```
Hello\n\tworld
Hello\n\tworld
```

C.
```
Hello\n\tworld
Hello
	world
```

D. `t3.translateEscapes()`という呼び出し自体がコンパイルエラーになる（`String`にそのようなメソッドは無い）
E.
```
Hello
	world
Hello\n\tworld
```

**解答**

正解：**C**

**補足**

- `"Hello\\n\\tworld"`という**ソースコード上の文字列リテラル**では、`\\`は「バックスラッシュ1文字」を表すエスケープ。つまりこの文字列の**実際の中身**は、改行やタブではなく`Hello`, `\`, `n`, `\`, `t`, `world`という**文字の並び**そのもの。
- そのため`println(t3)`は、その文字の並びをそのまま`Hello\n\tworld`という**見たままの文字列**として出力する（改行やタブとしては解釈されない）。
- `translateEscapes()`は、文字列の中身に含まれる`\n`や`\t`のような**エスケープシーケンス表現の文字の並び**を、実行時に改めて解析して実際の制御文字（改行・タブ）に変換するメソッド。これを呼ぶことで初めて`Hello`＋改行＋タブ＋`world`という見た目になる。
- `String`クラスにJava 15以降`translateEscapes()`は標準で用意されている（Dは誤り）。
- `javac`/`java`で検証済み：`Hello\n\tworld`の後に、改行・タブを含んだ`Hello` / `	world`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q16"></a>
## 問題16(sample/chap2/16)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Apple ")
                .append("Lime ")
                .append("Kiwi ")
                .delete(6, 11)
                .insert(6, "Lemon ");
        System.out.println("sb : " + sb);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `sb : Apple Lime Kiwi `
B. `sb : Apple Lemon Kiwi `
C. `sb : Apple Kiwi Lemon `
D. コンパイルエラーになる（`new`の直後に`.append`を繋げることはできない）
E. `sb : Apple Lemon `

**解答**

正解：**B**

**補足**

- `new StringBuilder(...)`のコンストラクタ呼び出しの戻り値（生成されたばかりのオブジェクト自身）に対して、そのまま`.append(...)`のようにメソッドを繋げることができる（Dは誤り）。
- 順を追うと：`"Apple "` → `append("Lime ")`で`"Apple Lime "` → `append("Kiwi ")`で`"Apple Lime Kiwi "`。
- `delete(6, 11)`は添字6〜10（`"Lime "`の部分、5文字）を削除し`"Apple Kiwi "`になる。
- `insert(6, "Lemon ")`は添字6の位置に`"Lemon "`を挿入し`"Apple Lemon Kiwi "`になる。
- 各メソッドはすべて`sb`自身を書き換えて、その`sb`自身への参照を返す(メソッドチェーン)。
- `javac`/`java`で検証済み：`sb : Apple Lemon Kiwi `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex5"></a>
## 問題ex5(sample/chap2/ex5)

```java
public class Main {
    public static void main(String[] args) {
        String text = "";
        System.out.println(text == null);
        System.out.println(text.length());
        System.out.println(text);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A.
```
true
0
```
(3行目は何も出力されない)

B.
```
false
0

```
（3行目は空行として出力される）

C. `text.length()`の行で`NullPointerException`がスローされる（空文字列は実質`null`扱いのため）
D.
```
true
0

```

E. コンパイルエラーになる（空の文字列リテラル`""`は無効）

**解答**

正解：**B**

**補足**

- `""`（空文字列リテラル）は`null`では**ない**。「文字が0個入っている、れっきとした`String`オブジェクト」であり、参照自体はちゃんと存在する（A・C・Dは誤り。「空＝null」という混同に注意）。
- `text.length()`は、有効なオブジェクトに対する通常のメソッド呼び出しなので普通に`0`を返す。
- `println(text)`は、中身が0文字の文字列を出力するので、見た目には**何も無い空行**が出力される。
- 空文字列リテラル自体はJavaの正当な構文（Eは誤り）。
- `javac`/`java`で検証済み：`false` / `0` / (空行)。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8(sample/chap2/ex8)

```java
public class Main {
    public static void main(String[] args) {
        var a = 10; var b = 20;
        var c = "30";
        System.out.println(c + b + a);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `60`（すべて数値として加算される）
B. `302010`
C. `"30"2010`（文字列と数値が混在したまま出力される）
D. コンパイルエラーになる（`String`と`int`は`+`できない）
E. `3020` + `10`のような結果になる（`b`と`a`は先に数値同士で足される）

**解答**

正解：**B**

**補足**

- `+`演算子は**左から右へ順番に評価**される。最初の`c + b`の時点で、`c`が`String`型なので、この`+`は「数値の加算」ではなく「**文字列としての連結**」と解釈される。
- `c + b` = `"30" + 20` = `"3020"`（文字列連結）。続けて`"3020" + a` = `"3020" + 10` = `"302010"`（こちらも文字列連結）。
- 一度どこかで`String`が絡んで文字列連結になると、**それ以降の`+`も自動的にすべて文字列連結として扱われる**（Eのように、途中から数値同士の計算に「戻る」ことはない。かつ左結合なので`b + a`が先に計算されるわけでもない）。
- `String`と`int`の`+`はコンパイルエラーにならず、文字列連結として正当に成立する（Dは誤り）。
- `javac`/`java`で検証済み：`302010`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex9"></a>
## 問題ex9(sample/chap2/ex9)

```java
public class Main {
    public static void main(String[] args) {
        final String s;
        s = "James";
        s = "Duke";
        System.out.println(s);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`Duke`が出力される（後から代入した値で上書きされる）
B. `final String s;`の宣言時に初期値が無いためコンパイルエラーになる
C. `s = "Duke";`の行でコンパイルエラーになる（`final`変数への2回目の代入）
D. `s = "James";`の行でコンパイルエラーになる（`final`変数は宣言と同時に代入しなければならない）
E. `println(s)`の行で、`s`がどちらの値か不定なためコンパイルエラーになる

**解答**

正解：**C**

**補足**

- `final`な変数は、宣言時に初期値を書かなくてもよい（いわゆる**blank final**）。ただしその場合、**実際に値を代入できる機会はプログラム全体を通して1回きり**という制約がある（B・Dは誤り。宣言と同時の代入は必須ではない）。
- 1回目の`s = "James";`はこの「1回きりの代入」に該当するのでOK。しかし2回目の`s = "Duke";`は、すでに一度確定した`final`変数への**再代入**にあたるためコンパイルエラーになる。
- `final`はあくまで「再代入を禁止する」という制約であり、値そのものが不定になるようなことはない（Eは誤り、そもそもここでコンパイルが失敗する）。
- `javac`で検証済み：「変数`s`はすでに代入されている可能性があります」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex10"></a>
## 問題ex10(sample/chap2/ex10)

```java
public class Main {
    public static void main(String[] args) {
        double[] array = new double[3];
        array[1] = 10.5; array[2] = 20.0; array[3] = 30.1;
        System.out.println(array[0] + " : " + array[1] + " : " + array[2]);
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `0.0 : 10.5 : 20.0` が出力される
B. `array[3] = 30.1;`の代入自体は成立し、配列が自動的に拡張されるため問題なく実行できる
C. `array[3] = 30.1;`の行で実行時に`ArrayIndexOutOfBoundsException`がスローされ、`println`には到達しない
D. コンパイルエラーになる（配列のサイズ3に対し添字3〜が使われている）
E. `array[0]`は初期化されていないため`NullPointerException`がスローされる

**解答**

正解：**C**

**補足**

- `new double[3]`の有効な添字は`0, 1, 2`のみ。`array[3]`は存在しない要素であり、Javaの配列は**サイズ固定**で自動拡張などされない（Bは誤り）。
- 添字が範囲外かどうかは実行時にしか判定できないため、コンパイルエラーにはならない（Dは誤り）。
- `array[3] = 30.1;`の代入をしようとした**その行**で`ArrayIndexOutOfBoundsException`がスローされ、それ以降の`println`の行には一切到達しない（Aのような出力は行われない）。
- `double`は基本データ型であり`null`にはならない（Eは誤り）。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11(sample/chap2/ex11)

```java
public class Main {
    public static void main(String[] args) {
        boolean bAry[] = new boolean[];
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（要素数を省略すると長さ0の配列になる）
B. コンパイルエラーになる（配列のサイズも初期化子リストも指定されていない）
C. `boolean bAry[]`という宣言の書き方自体がコンパイルエラーになる
D. 実行時に`NegativeArraySizeException`がスローされる
E. `new boolean[]`は自動的に`new boolean[0]`として扱われる

**解答**

正解：**B**

**補足**

- `new 型[]`で配列を生成する場合、**「要素数を指定する」か「`{...}`で初期化子リストを与える」のどちらかが必須**。今回はどちらも書かれていないため、そもそも配列を生成する情報が足りていない。
- `boolean bAry[]`という宣言の書き方(変数名の後ろに`[]`)自体は、問題1で見た通り正当な文法（Cは誤り）。
- 「要素数指定なし＝長さ0」という自動解釈は存在しない（A・Eは誤り。長さ0の配列が欲しいなら明示的に`new boolean[0]`と書く必要がある）。
- コンパイル時点で構文として不正なので、実行時エラーにもならない（Dは誤り）。
- `javac`で検証済み：「配列の大きさが指定されていません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13(sample/chap2/ex13・複数選択)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0] + args[1] + args[2]);
    }
}
```

コマンドライン引数についての次の記述のうち、正しいものをすべて選んでください。（複数選択）

A. 引数を1つも渡さなかった場合、`args`は`null`になる
B. 引数を1つも渡さなかった場合、`args.length`は`0`になる
C. `args[0]`のようなアクセスがコンパイル時に検証されることはなく、実際に渡された引数の数によって実行時に成功・失敗が決まる
D. コマンドライン引数はすべて`String`型として`args`に格納される
E. 引数を渡す数が足りない場合、不足分は自動的に空文字列`""`で埋められる

**解答**

正解：**B、C、D**

**補足**

- 引数が無い場合でも`args`自体は`null`ではなく、**要素数`0`の配列**として渡ってくる（Aは誤り、Bが正しい）。
- `args[0]`, `args[1]`, `args[2]`のようなアクセスは、コンパイル時には「文法として正しいかどうか」しかチェックされない。実際に何個の引数が渡されるかは実行時に決まるため、範囲外アクセスは実行時の`ArrayIndexOutOfBoundsException`として検出される（Cは正しい）。
- コマンドライン引数は数値であっても文字列であっても、すべて`String`として`args`に格納される（数値として使いたい場合は`Integer.parseInt()`等で変換が必要。Dは正しい）。
- 不足分を自動的に埋めるような機能は無い（Eは誤り、単に配列の長さがその分短くなるだけ）。
- `javac`/`java`で検証済み（引数無しで実行）：`0`の後、`args[0]`のアクセスで`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14(sample/chap2/ex14)

```java
public class Main {
    public static void main(String[] args) {
        String s = "Java 17";
        s.append(" Silver");
        int length = s.length();
        int index = s.indexOf("Gold");
        System.out.println(length + " : " + index);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`length`は`14`、`index`は`-1`になる
B. `s.append(" Silver");`の行でコンパイルエラーになる（`String`型に`append`メソッドは存在しない）
C. `int length = s.length();`の行でコンパイルエラーになる
D. `int index = s.indexOf("Gold");`の行でコンパイルエラーになる（存在しない文字列を検索しているため）
E. 実行時に`NoSuchMethodException`がスローされる

**解答**

正解：**B**

**補足**

- `append()`は`StringBuilder`/`StringBuffer`が持つメソッドであり、**`String`クラスには存在しない**。`String`は不変なので「末尾に追記する」という破壊的な操作自体がそもそも用意されていない。
- `String`に対して`s.append(...)`と書いた時点で、コンパイラは`String`型に`append`という名前のメソッドが定義されていないことを検出し、その場でコンパイルエラーにする（実行時まで判明が持ち越されることはない。Eは誤り）。
- `length()`や`indexOf()`は`String`にも普通に存在するメソッドなので、それ自体は問題ない（C・Dは誤り。ただし今回はB自体が先に成立するので、これらの行に到達する前にコンパイル全体が失敗する）。
- `indexOf()`は該当する文字列が見つからない場合、例外ではなく`-1`を返す仕様（この点は覚えておく価値があるが、今回のコンパイルエラーの原因ではない）。
- `javac`で検証済み：「シンボルを見つけられません（シンボル: メソッド`append(String)`、場所: タイプ`String`の変数`s`）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15(sample/chap2/ex15)

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Gold").append("Silver");
        sb.insert(4, " ").delete(4, 5);
        sb.substring(0, 4);
        System.out.println(sb);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Gold`
B. `GoldSilver`
C. `Gold Silver`
D. コンパイルエラーになる（`sb.substring(0, 4);`の戻り値を使っていないため）
E. 実行時に例外がスローされる

**解答**

正解：**B**

**補足**

- `append("Gold").append("Silver")`で`sb`の中身は`"GoldSilver"`になる。
- `insert(4, " ")`で添字4の位置に空白を挿入し`"Gold Silver"`。続く`delete(4, 5)`で添字4(挿入したばかりの空白1文字)を削除し、元の`"GoldSilver"`に戻る。
- `sb.substring(0, 4)`は`"Gold"`という**新しい`String`**を生成して返すだけで、`sb`自身の中身には一切影響しない。しかもその戻り値はどこにも代入されず捨てられている。
- メソッドの戻り値を使わずに文として呼び出すこと自体は、`StringBuilder`のメソッドチェーンの一部を切り離した形であってもコンパイルエラーにはならない（Dは誤り。問題7と同じ考え方）。
- 最終的に`println(sb)`で表示されるのは、`substring`より前の時点で確定していた`sb`自身の中身、つまり`"GoldSilver"`。
- `javac`/`java`で検証済み：`GoldSilver`。

**実施記録**

回答：
正解：
迷ったポイント：