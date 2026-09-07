# 第1章 サンプル発展問題(1〜6・ex4 各1問、計7問)

`sample/chap1/1`〜`6`・`ex4`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題1(sample/chap1/1)](#q1)
- [問題2(sample/chap1/2)](#q2)
- [問題3(sample/chap1/3)](#q3)
- [問題4(sample/chap1/4)](#q4)
- [問題5(sample/chap1/5)](#q5)
- [問題6(sample/chap1/6)](#q6)
- [問題ex4(sample/chap1/ex4・複数選択)](#qex4)

<a id="q1"></a>
## 問題1(sample/chap1/1)

```java
public class Main {
    public static void main(String args[]) {
        System.out.println("ok");
    }
}
```

`main`メソッドの引数が`String[] args`ではなく`String args[]`という書き方になっています。このプログラムをコンパイル、実行するとどうなりますか。（1つ選択）

A. `ok` が出力される
B. コンパイルエラーになる（`String args[]`という書き方は許されない）
C. コンパイルは通るが、JVMが`main`メソッドとして認識できず実行時にエラーになる
D. `args`が`String[]`型ではなく`String`型の配列的な何かとして扱われ、型が異なる旨のコンパイルエラーになる
E. `public static void main`の宣言としては無効なので、別の`main`メソッドを探しに行き、見つからず実行時エラーになる

**解答**

正解：**A**

**補足**

- Javaでは配列の宣言を`型[] 変数名`（`String[] args`）と書く方式に加えて、C言語由来の`型 変数名[]`（`String args[]`）という書き方も**今でも文法上有効**。
- どちらの書き方でも「`args`は`String[]`型である」という意味は完全に同じであり、コンパイラは同一のものとして扱う（B・Dは誤り）。
- `main`メソッドの認識は「名前が`main`」「`public static void`」「引数が`String[]`(相当)1つ」という条件で行われ、これを満たしているのでJVMは正しく`main`メソッドとして認識する（C・Eは誤り）。
- `javac`/`java`で検証済み：`ok`が出力される。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap1/2)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
    }
}
public class Sample {}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`java Main`で`Main`が出力される
B. `Sample`が`public`だと`Main`と名前が衝突するためコンパイルエラーになる
C. `Sample`クラスの宣言でコンパイルエラーになる（`public`なクラスは1ファイルに1つまで、かつファイル名と一致していなければならない）
D. `Main.java`というファイル名なので`Sample`側のクラス定義自体が無視される
E. 1つのファイルに複数の`public`クラスを書くこと自体は許されるが、実行時にどちらの`main`を呼ぶか指定できないためエラーになる

**解答**

正解：**C**

**補足**

- 1つの`.java`ファイルに書ける**`public`な最上位クラスは1つまで**、というルールがある。`Main`が既に`public`としてファイル名(`Main.java`)と一致しているところに、さらに`Sample`まで`public`にしてしまうと違反になる。
- エラーの原因は「名前の衝突」ではなく「`public`クラスとファイル名の対応関係」というルール（B・Eは誤り、そもそも実行時まで到達せずコンパイルの時点で失敗する）。
- `Sample`側の定義が無視されるようなことはなく、明確なコンパイルエラーとして扱われる（Dは誤り）。
- `javac`で検証済み：「クラス`Sample`は`public`であり、ファイル`Sample.java`で宣言する必要があります」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap1/3)

`Main.java`というファイル名だが、中身は次のようになっているとします。

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Source-file mode - Main.java");
    }
}
```

このファイルに対して`java Main.java`（ソースファイルモードでの直接実行）を行った場合と、`javac Main.java`（通常のコンパイル）を行った場合、それぞれどうなりますか。（1つ選択）

A. どちらも同じくコンパイルエラーになる（`public`クラス名`Hello`とファイル名`Main`が不一致のため）
B. `java Main.java`は`Source-file mode - Main.java`と出力されて成功するが、`javac Main.java`はコンパイルエラーになる
C. `java Main.java`はコンパイルエラーになるが、`javac Main.java`は成功する
D. どちらも成功し、同じように実行できる
E. `java Main.java`はファイル名と一致する`Main`という名前のクラスが無いため、実行時に`ClassNotFoundException`になる

**解答**

正解：**B**

**補足**

- 通常の`javac`によるコンパイルでは、`public`な最上位クラスの名前とファイル名は一致していなければならない（問題2と同じルール）。`Hello`と`Main.java`は不一致なので`javac Main.java`は明確にコンパイルエラーになる。
- 一方、Java 11以降で使える**ソースファイルモード**（`java ファイル名.java`のようにコンパイルと実行を1コマンドで済ませる実行方式）では、この「`public`クラス名とファイル名の一致」というルールが**適用されない**という特例がある。中の`public class Hello`がファイル名`Main.java`と一致していなくても、そのまま実行できてしまう。
- 「ソースファイルモードは通常のコンパイルを内部で行っているだけ」という思い込みがあると、この違いを見落としやすい。
- `javac`/`java`で検証済み：`java Main.java`は`Source-file mode - Main.java`と出力されて正常終了(exit 0)。`javac Main.java`は「クラス`Hello`は`public`であり、ファイル`Hello.java`で宣言する必要があります」というエラー。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap1/4)

```java
package com.se;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
    }
}
class Sample {}
```

このファイルを`javac Main.java`（`-d`オプション無し）でコンパイルした場合、生成される`Main.class`はどこに配置されますか。また、その後`java com.se.Main`を実行するとどうなりますか。（1つ選択）

A. `com/se/Main.class`に自動的に配置され、`java com.se.Main`は`Main`と出力されて成功する
B. コンパイル自体が`package com.se;`の行でエラーになる（`-d`が無いとパッケージ宣言は使えない）
C. `Main.class`は現在のディレクトリにそのまま配置され、`java com.se.Main`は該当クラスを見つけられずエラーになる
D. `Main.class`は現在のディレクトリに配置されるが、`java com.se.Main`は問題なく成功する
E. コンパイルは成功するが、`.class`ファイルは生成されない

**解答**

正解：**C**

**補足**

- `package com.se;`という宣言があっても、`-d`オプションを指定しなければ**javacはパッケージ構造に対応したディレクトリを自動生成しない**。あくまで`Main.class`はコンパイル元と同じ場所（カレントディレクトリ）にそのまま出力される（Aは誤り）。
- パッケージ宣言自体は`-d`の有無に関わらず有効な文法であり、コンパイル自体は成功する（B・Eは誤り）。
- しかし`java com.se.Main`という実行時の指定は「`com/se/Main.class`というパスにあるクラスを探す」という意味になる。`Main.class`がカレントディレクトリに直置きされている状態ではこのパスに一致せず、`ClassNotFoundException`になる（Dは誤り、実行は失敗する）。
- `javac`/`java`で検証済み：`java com.se.Main`は「メイン・クラスcom.se.Mainを検出およびロードできませんでした（原因: java.lang.ClassNotFoundException: com.se.Main）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap1/5)

```java
package com.se;
public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
    }
}
```

このファイルを`javac -d classes Main.java`でコンパイルした場合、`classes`ディレクトリの中はどうなりますか。また、その後どのコマンドで実行できますか。（1つ選択）

A. `classes/Main.class`が生成され、`java -cp classes Main`で実行できる
B. `classes/com/se/Main.class`が生成され、`java -cp classes com.se.Main`で実行できる
C. `classes/com.se/Main.class`（パッケージ名がそのままディレクトリ名になる）が生成される
D. `-d`オプションは出力先を指定するだけで、パッケージ用のサブディレクトリは作られず`classes/Main.class`になる
E. コンパイルエラーになる（`-d`オプションと`package`宣言は同時に使えない）

**解答**

正解：**B**

**補足**

- `-d ディレクトリ`オプションを付けると、javacは指定したディレクトリの中に**パッケージ名をそのままディレクトリ階層に変換した構造**でクラスファイルを配置する。`com.se`というパッケージ名なら`com/se/`という2階層のディレクトリになる（Cのように`.`区切りのままの1階層ディレクトリにはならない）。
- 実行するときは、そのルートディレクトリ(`classes`)を`-cp`（クラスパス）に指定した上で、完全修飾名(`com.se.Main`)でクラスを指定する。
- `javac`/`java`で検証済み：`classes/com/se/Main.class`が生成され、`java -cp classes com.se.Main`で`Main`が出力される。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap1/6)

```java
// com/se/sub/Foo.java
package com.se.sub;
public class Foo {
    public void display() { System.out.println("Foo"); }
}

// com/se/sub/Bar.java
package com.se.sub;
public class Bar {
    public void display() { System.out.println("Bar"); }
}

// com/se/Main.java
package com.se;
import com.se.sub.Foo;
public class Main {
    public static void main(String[] args) {
        Foo s = new Foo();
        s.display();
        Bar b = new Bar();
        b.display();
    }
}
```

`Foo`は`import`されていますが、`Bar`は`import`も完全修飾名(`com.se.sub.Bar`)での記述もされていません。このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Bar`は`Foo`と同じパッケージ`com.se.sub`にいるので、1つ`import`すれば同じパッケージのクラスは全部使えるようになる）
B. `Bar`が見つからないというコンパイルエラーになる
C. `Main`と`Bar`は異なるパッケージだが、`Main`のパッケージ(`com.se`)が`Bar`のパッケージ(`com.se.sub`)の**親**なので、自動的に参照できる
D. `import com.se.sub.Foo;`という記述が、`com.se.sub`パッケージ全体を`import`したものとして扱われる
E. `Bar`という名前がどこにも定義されていないと解釈され、`Bar b`の行自体が変数の型として不正になり別の種類のエラーになる

**解答**

正解：**B**

**補足**

- Javaの`import`は**クラス単位（または`import パッケージ名.*;`のワイルドカード）**で指定する必要があり、「同じパッケージの別のクラスを1つimportしたから、そのパッケージの他のクラスも自動的に使える」ということはない（A・Dは誤り）。
- パッケージ名に親子のような見た目の階層（`com.se`と`com.se.sub`）があっても、Javaの`package`は**あくまでフラットな名前空間**であり、`com.se`パッケージにいるからといって`com.se.sub`パッケージのクラスに自動的にアクセスできるようにはならない（Cは誤り。「サブパッケージ」という言葉のイメージに引きずられやすい）。
- `Bar`を使うには`import com.se.sub.Bar;`を追加するか、`com.se.sub.Bar`という完全修飾名で書く必要がある（元の`sample/chap1/6/Main.java`はこの完全修飾名の書き方を採用している）。
- エラーは「型が見つからない」という`Foo`と同種の`シンボルを見つけられません`エラーになる（Eのような別種のエラーにはならない）。
- `javac`で検証済み：「シンボルを見つけられません（シンボル: クラス`Bar`）」が`Bar b = new Bar();`の行で2回（型宣言側と`new`側）出る。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex4"></a>
## 問題ex4(sample/chap1/ex4・複数選択)

次のA〜Eは、それぞれ独立した1つの`.java`ファイルの中身とファイル名です。**コンパイルが成功するものをすべて選んでください**。（複数選択）

A. ファイル名`Hello.java`
```java
class Hello {}
class Main {}
class Test {}
```

B. ファイル名`Hello.java`
```java
class Hello {}
public class Main {}
```

C. ファイル名`Hello.java`
```java
public class Hello {}
```

D. ファイル名`Main.java`
```java
public class Main {}
class Hello {}
```

E. ファイル名`Hello.java`
```java
public class Hello {}
public class Main {}
```

**解答**

正解：**A、C、D**（B、Eはコンパイルエラー）

**補足**

- **A**: `public`なクラスが1つも無い。この場合、ファイル名とクラス名が一致している必要は無い（`Main`や`Test`という名前のクラスがファイル内にあっても、ファイル名`Hello.java`と無関係に共存できる）。→OK
- **C**: `public class Hello`とファイル名`Hello.java`が一致している。最もシンプルな正しいパターン。→OK
- **D**: `public class Main`とファイル名`Main.java`が一致しており、ほかに`public`でない`Hello`が同居しているだけ。→OK
- **B**: `public class Main`があるのに、ファイル名は`Hello.java`（`Main.java`ではない）。`public`クラスの名前とファイル名が不一致なのでコンパイルエラー。
- **E**: `public class Hello`はファイル名と一致しているが、さらに`public class Main`も同じファイルに存在し、こちらはファイル名`Hello.java`と一致しない。**1ファイルにpublicクラスは1つまで、かつそのpublicクラス名はファイル名と一致していなければならない**というルールに違反しており、B同様のエラーになる。
- まとめると、判定基準は「ファイル内に`public`な最上位クラスがあるなら、それは1つだけであり、かつファイル名と一致していなければならない。`public`が無いなら、クラス名は何でも自由」という1本のルールに集約できる。
- `javac`で検証済み：A・C・Dはエラー無し。B・Eはどちらも同じ「クラス`Main`は`public`であり、ファイル`Main.java`で宣言する必要があります」というエラー。

**実施記録**

回答：
正解：
迷ったポイント：