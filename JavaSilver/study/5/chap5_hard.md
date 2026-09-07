# 第5章 サンプル発展問題(1〜18・ex1,2,4,6,7,8,9,10,11,12,13,14,15,16,17,18 各1問、計34問)

`sample/chap5/1`〜`18`・`ex1,2,4,6,7,8,9,10,11,12,13,14,15,16,17,18`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み（無限再帰になる問題は検証後に強制終了し、結果を確認済み）。

## 目次

- [問題1(sample/chap5/1)](#q1)
- [問題2(sample/chap5/2)](#q2)
- [問題3(sample/chap5/3)](#q3)
- [問題4(sample/chap5/4)](#q4)
- [問題5(sample/chap5/5)](#q5)
- [問題6(sample/chap5/6)](#q6)
- [問題7(sample/chap5/7)](#q7)
- [問題8(sample/chap5/8)](#q8)
- [問題9(sample/chap5/9)](#q9)
- [問題10(sample/chap5/10)](#q10)
- [問題11(sample/chap5/11)](#q11)
- [問題12(sample/chap5/12)](#q12)
- [問題13(sample/chap5/13)](#q13)
- [問題14(sample/chap5/14)](#q14)
- [問題15(sample/chap5/15)](#q15)
- [問題16(sample/chap5/16)](#q16)
- [問題17(sample/chap5/17)](#q17)
- [問題18(sample/chap5/18)](#q18)
- [問題ex1(sample/chap5/ex1)](#qex1)
- [問題ex2(sample/chap5/ex2)](#qex2)
- [問題ex4(sample/chap5/ex4)](#qex4)
- [問題ex6(sample/chap5/ex6)](#qex6)
- [問題ex7(sample/chap5/ex7)](#qex7)
- [問題ex8(sample/chap5/ex8)](#qex8)
- [問題ex9(sample/chap5/ex9・複数選択)](#qex9)
- [問題ex10(sample/chap5/ex10)](#qex10)
- [問題ex11(sample/chap5/ex11)](#qex11)
- [問題ex12(sample/chap5/ex12)](#qex12)
- [問題ex13(sample/chap5/ex13)](#qex13)
- [問題ex14(sample/chap5/ex14)](#qex14)
- [問題ex15(sample/chap5/ex15)](#qex15)
- [問題ex16(sample/chap5/ex16)](#qex16)
- [問題ex17(sample/chap5/ex17)](#qex17)
- [問題ex18(sample/chap5/ex18)](#qex18)

<a id="q1"></a>
## 問題1(sample/chap5/1)

```java
class Fruit { String name; Fruit(String name) { this.name = name; } }
public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = { new Fruit("Lemon"), new Fruit("Kiwi"), new Fruit("Lime")};
        method(fruits);
        fruits[1] = null;
        for (var f : fruits)
            if (f != null) System.out.print(f.name + " ");
    }
    public static void method(Fruit[] x) {
        for (var f : x)
            if (f.name.length() == 5) f.name = "REMOVED";
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Lemon Kiwi Lime `
B. `REMOVED Kiwi Lime `
C. `REMOVED Lime `
D. `Lemon Lime `
E. 実行時に`NullPointerException`がスローされる

**解答**

正解：**C**

**補足**

- `method(fruits)`は配列(への参照)を渡しているだけなので、その中で各`Fruit`オブジェクトの`name`フィールドを書き換えると、呼び出し元の`fruits`が指している**同じオブジェクト**に対する変更として反映される。`"Lemon"`(5文字)だけが`"REMOVED"`に書き換わる。
- `method`の実行が終わった**後**で、`main`側が`fruits[1] = null;`を実行している。これは`method`とは無関係な、`main`が持つ配列変数への直接操作。
- 拡張forは`null`要素をスキップするような処理をしているので(`if(f != null)`)、`NullPointerException`にはならない（Eは誤り）。
- 最終的に`fruits`は`[REMOVEDのFruit, null, Lime(未変更)]`。出力は`REMOVED Lime `。
- `javac`/`java`で検証済み：`REMOVED Lime `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap5/2)

```java
class Sample {
    int num;
    int getNum() { return num; }
    void setNum(int num) { this.num = num; }
}
public class Main {
    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.getNum());
        s.setNum(100);
        System.out.println(s.num);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `0` の後 `100`
B. コンパイルエラーになる（`getNum()`を呼ぶ前に`num`を初期化していない）
C. `null` の後 `100`
D. `100` の後 `100`
E. 実行時に`NullPointerException`がスローされる（未初期化フィールドへのアクセス）

**解答**

正解：**A**

**補足**

- インスタンスフィールド(`int num;`)は、ローカル変数と違い**明示的な初期化が無くてもデフォルト値で自動初期化される**（`int`なら`0`）。よって`getNum()`を呼ぶ前に何もしなくても普通に呼び出せる（B・Eは誤り）。
- `int`は基本データ型なので`null`にはなりえない（Cは誤り）。
- `s.getNum()`は`0`。`s.setNum(100)`の後は`s.num`が`100`になる。
- `javac`/`java`で検証済み：`0` / `100`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap5/3)

```java
class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        item1.name = "Sweater";
        String name = item1.getName();
        item2.setName("T-shirt");
        System.out.println("item1 : " + name);
        System.out.println("itme2 : " + item2.getName());
    }
}
class Item {
    String name;
    String getName() { return name; }
    void setName(String name) { this.name = name; }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `Main`という名前のクラスが`public`ではないためコンパイルエラーになる
B. 問題なくコンパイルが通り実行できる（`item1 : Sweater` / `itme2 : T-shirt`が出力される）
C. `Item`クラスが`Main`より後ろに定義されているためコンパイルエラーになる
D. `item1.name = "Sweater";`の行でコンパイルエラーになる（フィールドへの直接代入は`setName()`を経由しなければならない）
E. `getName()`と`setName()`という名前は予約されたメソッド名のため使用できない

**解答**

正解：**B**

**補足**

- `public`を付けなくても、トップレベルクラスは普通に定義・実行できる（`java Main`のように直接実行する分には問題ない。Aは誤り）。**1ファイルに`public`なクラスを1つまで**というルールと、「`public`が無いクラスがそもそも使えない」というのは別の話。
- 同じファイル内であれば、クラスが定義される順序に制約は無い。`Item`が`Main`より後に書かれていても、`Main`の中から普通に参照できる（Cは誤り）。
- `name`フィールドはこの`Item`定義では`private`になっていない(デフォルトアクセス)。同じファイル内から直接`item1.name = "Sweater";`のようにアクセスすること自体は許可される（Dは誤り）。
- `getName`/`setName`はただの通常のメソッド名で、Javaの予約語や特別な意味を持つ名前ではない（Eは誤り。慣習的な命名パターンであるだけ）。
- `javac`/`java`で検証済み：`item1 : Sweater` / `itme2 : T-shirt`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap5/4)

```java
class Item {
    String name;
    String getName() { return name; }
    void setName(String name) { this.name = name; }
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Jacket");
        System.out.println("item : " + item.getName());
    }
}
```

このプログラムを`java Item`で実行するとどうなりますか。（1つ選択）

A. `item : Jacket` が出力される
B. `main`メソッドを持つクラスは`public`でなければならないためコンパイルエラーになる
C. インスタンスフィールドを持つクラスに`main`メソッドを書くことはできない
D. `item : null`が出力される（`main`は`static`なので、フィールドの変更が反映されない）
E. 実行時に`NoSuchMethodError`がスローされる

**解答**

正解：**A**

**補足**

- `main`メソッドを持つクラスが`public`である必要はない。`public`が無くても、そのクラス名を指定して`java クラス名`で実行できる（B・Eは誤り）。
- クラスが`static`な`main`メソッドを持つことと、そのクラスが（`static`ではない）通常のインスタンスフィールドを持つことは、何の矛盾も無く共存できる。`main`の中で`new Item()`のようにインスタンスを作れば、そのインスタンスに対して普通に`static`ではないメソッドを呼び出せる（C・Dは誤り）。
- `javac`/`java`で検証済み（`java Item`で実行）：`item : Jacket`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap5/5)

```java
// com/Item.java
package com;
class Item {
    String name;
    String getName() { return name; }
    void setName(String name) { this.name = name; }
}

// Main.java (デフォルトパッケージ)
import com.Item;
class Main {
    public static void main(String[] args) {
        Item item = new Item();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `Item`クラスに`main`メソッドが無いためコンパイルエラーになる
C. `import com.Item;`の行と、`Item`を使っている行でコンパイルエラーになる（`Item`クラス自体が`public`ではなくパッケージ外からアクセスできないため）
D. `Item`のフィールド`name`が`private`ではないためコンパイルエラーになる
E. デフォルトパッケージから他のパッケージを`import`することはできない

**解答**

正解：**C**

**補足**

- `Item`クラスは`package com;`に属しているが、クラス自体に`public`が付いていない（デフォルトアクセス）。デフォルトアクセスのクラスは**同じパッケージの中からしか使えない**ため、別のパッケージ(今回はデフォルトパッケージ)にある`Main`からは、`import`することも実際に使うこともできない。
- デフォルトパッケージから他のパッケージを`import`すること自体は普通に行われる操作であり、禁止されていない（Eは誤り、問題の本質は`Item`が`public`でないこと）。
- クラスに`main`メソッドが無くても、それ単体でコンパイルエラーにはならない（Bは誤り、`main`が必要なのは`java`コマンドで直接実行するクラスだけ）。
- `javac`で検証済み：`import com.Item;`の行と`Item item = new Item();`の行（2箇所）で「`com`の`Item`は`public`ではありません。パッケージ外からはアクセスできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap5/6)

```java
class Item {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("T-shirt");
        System.out.println(item.name);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`T-shirt`が出力される
B. `item.name`の行でコンパイルエラーになる（`name`は`private`で、`Item`の外からはアクセスできない）
C. `setName`の呼び出しの行でコンパイルエラーになる（`private`フィールドを`public`メソッドから変更することはできない）
D. 実行時に`IllegalAccessException`がスローされる
E. `Item`と`Main`が同じファイルに定義されていれば`private`でもアクセスできる

**解答**

正解：**B**

**補足**

- `private`は「そのクラス自身の中からしかアクセスできない」という、Javaで最も厳しいアクセス修飾子。同じファイル内であっても、`Item`クラスの外にある`Main`から`item.name`のように直接アクセスすることはできない（Eは誤り、同一ファイルかどうかは無関係）。
- `private`フィールドであっても、そのクラス**自身が定義した**`public`メソッド(`setName`など)の中からであれば普通にアクセス・変更できる。これこそが「`getter`/`setter`経由でアクセスさせる」というカプセル化の目的（Cは誤り）。
- アクセス制御の違反はコンパイル時に検出されるので、実行時例外にはならない（Dは誤り）。
- `javac`で検証済み：「`name`は`Item`で`private`アクセスされます」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q7"></a>
## 問題7(sample/chap5/7)

```java
public class Sample {
    public void printItem(String s) {}
    public void printItem(String[] s, int i) {}
    public boolean printItem(int i, String[] s) { return true; }
    void printItem() {}
    public void printItem(String item) {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（引数の名前が違うので別のメソッドとして扱われる）
B. 最後の`public void printItem(String item) {}`の行でコンパイルエラーになる（1つ目のメソッドとシグネチャが重複しているため）
C. 戻り値の型が`void`と`boolean`で異なるメソッドが混在しているためコンパイルエラーになる
D. アクセス修飾子(`public`/デフォルト)が異なるオーバーロードは併用できないためコンパイルエラーになる
E. 引数の数が異なる`printItem(String[] s, int i)`と`printItem(int i, String[] s)`は曖昧でコンパイルエラーになる

**解答**

正解：**B**

**補足**

- メソッドのオーバーロードは**引数の型・数・順序（シグネチャ）**で区別される。**引数の名前は一切関係ない**。`printItem(String s)`と`printItem(String item)`は、引数名こそ違うが型は同じ`String`1個なので、**全く同じシグネチャの重複定義**とみなされる（Aは誤り）。
- 戻り値の型だけが違ってもオーバーロードとして成立する条件には関係しない（オーバーロードの成立自体は引数で決まる。Cは誤り、これは別の話）。アクセス修飾子の違いもオーバーロードの可否には影響しない（Dは誤り）。
- `printItem(String[] s, int i)`と`printItem(int i, String[] s)`は、引数の**型の並び順**が違う（`String[],int`と`int,String[]`）ので、全く別のシグネチャとして問題なく共存できる（Eは誤り、曖昧にはならない）。
- `javac`で検証済み：「メソッド`printItem(String)`はすでにクラス`Sample`で定義されています」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q8"></a>
## 問題8(sample/chap5/8)

```java
class Item {
    private String name;
    public void setName(String name) { this.name = name; }
    public void printItem() {
        System.out.println("Item : " + name);
    }
    public void printItem(String mark) {
        System.out.print(mark);
        System.out.print(" Item : " + name);
        System.out.println(" " + mark);
    }
    public void printItem(String mark, int num) {
        String line = "";
        for (int i = 0; i < num; i++) {
            line += mark;
        }
        printItem(line);
    }
}
public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("T-shirt");
        item.printItem("#", 3);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `# Item : T-shirt #`
B. `### Item : T-shirt ###`
C. `Item : T-shirt`
D. `#Item : T-shirt#`（連結時の空白が抜ける）
E. `printItem(line);`の行でコンパイルエラーになる（自分自身を`this.`無しで呼び出すことはできない）

**解答**

正解：**B**

**補足**

- `printItem(line);`のように、クラス内から自分自身の（オーバーロードされた）メソッドを`this.`を付けずに呼び出すことは普通に行える（`this.printItem(line)`と書いたのと同じ意味。Eは誤り）。
- `printItem("#", 3)`は、`for`ループで`"#"`を3回連結した`line = "###"`を作り、それを引数に`printItem(line)`＝`printItem("###")`（1引数版）を呼び出す。
- 1引数版は`mark`の前後に`" Item : "+name`を挟んで出力するので、`"###" + " Item : T-shirt" + " " + "###"` = `"### Item : T-shirt ###"`。
- `javac`/`java`で検証済み：`### Item : T-shirt ###`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q9"></a>
## 問題9(sample/chap5/9)

```java
public class Sample {
    public void method(char... c) { System.out.println("A"); }
    public void method(String s, int... i) { System.out.println("B"); }
    public void method(int i, int... j) { System.out.println("C"); }
    public void method(int i, int j) { System.out.println("D"); }
    public static void main(String[] args) {
        Sample s = new Sample();
        s.method(1, 2);
    }
}
```

`s.method(1, 2);`はどのメソッドを呼び出しますか。（1つ選択）

A. `A`（`char...`は`int`を受け取れるため）
B. `B`
C. `C`（可変長引数の方が汎用的なので優先される）
D. `D`
E. 複数のメソッドが同程度に一致するためコンパイルエラーになる（曖昧な呼び出し）

**解答**

正解：**D**

**補足**

- オーバーロード解決には優先順位があり、**「可変長引数(`...`)を使わずに一致する固定引数のメソッドが1つでもあれば、それが最優先で選ばれる」**。可変長引数版は、固定引数版のどれにも一致しない場合の**最後の手段**として検討される（C・Eは誤り）。
- `method(int i, int j)`は、`method(1, 2)`（`int`が2つ）に**過不足なく正確に一致する固定引数のオーバーロード**。`method(int i, int... j)`も引数の数だけ見れば呼び出せるが、可変長引数を使う分、固定引数版より優先順位が低い。
- `char...`は`int`をそのまま受け取れないので候補にすらならない（Aは誤り）。
- `javac`/`java`で検証済み：`D`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q10"></a>
## 問題10(sample/chap5/10)

```java
public class Sample {
    public void method(long l) { System.out.print("long : " + l); }
    public void method(float f) { System.out.print("float : " + f); }
    public void method(double d) { System.out.print("double : " + d); }
    public void method(Integer i) { System.out.print("Integer : " + i); }
    public void method(int... i) { System.out.print("int... : " + i[0]); }
    public void method(byte b) { System.out.print("byte : " + b); }
    public static void main(String[] args) {
        Sample s = new Sample();
        s.method(100);
    }
}
```

`s.method(100);`はどのメソッドを呼び出しますか。（1つ選択）

A. `Integer : 100`（オートボクシングが最優先）
B. `byte : 100`（`100`は`byte`の範囲内だから）
C. `long : 100`
D. `int... : 100`
E. 複数の候補が同程度に一致するためコンパイルエラーになる（曖昧な呼び出し）

**解答**

正解：**C**

**補足**

- オーバーロード解決は複数の段階に分かれており、**「オートボクシング(`Integer`)や可変長引数(`int...`)を一切使わず、暗黙的な型の拡大(widening)だけで一致するものがあれば、そちらが優先される」**（A・Dは誤り）。
- `int`は`byte`より**表現できる範囲が広い**ため、`int`から`byte`への変換は「縮小」であり、暗黙的には行われない(明示的なキャストが必要)。よって`byte`は候補にならない（Bは誤り）。
- `int`から拡大変換できるのは`long`, `float`, `double`。この中で**最も「小さい」拡大変換(byte数の変化が最小)**である`long`が優先的に選ばれる。
- 複数の拡大変換候補がある場合でも、Javaのオーバーロード解決規則によって一意に決まるため、曖昧なコンパイルエラーにはならない（Eは誤り）。
- `javac`/`java`で検証済み：`long : 100`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q11"></a>
## 問題11(sample/chap5/11)

```java
public class Item {
    private int id;
    private String name;
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void printItem() {
        System.out.println("Item id:" + id + " name:" + name);
    }
    public static void main(String[] args) {
        new Item(300, "Hat").printItem();
        new Item().printItem();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`Item id:300 name:Hat`の後`Item id:0 name:null`が出力される
B. `new Item().printItem();`の行でコンパイルエラーになる（引数付きコンストラクタを定義すると、暗黙のデフォルトコンストラクタは自動生成されなくなるため）
C. `Item`クラスにデフォルトコンストラクタを明示的に書いていないためクラス定義自体がコンパイルエラーになる
D. 実行時に`InstantiationException`がスローされる
E. `new Item(300, "Hat")`の後にメソッドチェーンで`.printItem()`を呼ぶことはできない

**解答**

正解：**B**

**補足**

- Javaは、クラスに**コンストラクタが1つも明示的に定義されていない場合に限り**、無条件で使える「暗黙のデフォルトコンストラクタ(引数無し)」を自動生成する。
- **1つでも明示的にコンストラクタを定義すると、この自動生成は行われなくなる**。今回は`Item(int id, String name)`を定義しているので、もはや引数無しの`new Item()`は使えない（Cは誤り、クラス定義自体は正当。Dは誤り、実行時まで到達しない）。
- `new Item(...)`のようにコンストラクタ呼び出しの直後にメソッドを繋げること自体は普通に行える（Eは誤り）。
- `javac`で検証済み：`new Item().printItem();`の行で「クラス`Item`のコンストラクタ`Item`は指定された型に適用できません（期待値: int,String、検出値: 引数がありません）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q12"></a>
## 問題12(sample/chap5/12)

```java
public class Item {
    private int id;
    private String name;
    public Item() {
        this(0, "T-shirt");
    }
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void printItem() {
        System.out.println("Item id:" + id + " name:" + name);
    }
    public static void main(String[] args) {
        new Item().printItem();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Item id:0 name:null`
B. `Item id:0 name:T-shirt`
C. コンパイルエラーになる（コンストラクタの中から別のコンストラクタを呼び出すことはできない）
D. 無限ループになる（`this(...)`が自分自身を呼び出し続けるため）
E. `Item id:0 name:T-shirt`の後、さらに`Item()`が呼ばれて2回出力される

**解答**

正解：**B**

**補足**

- `this(引数...)`は、**同じクラスの別のコンストラクタを呼び出す**ための構文で、コンストラクタの中でのみ使える（Cは誤り）。これによりコンストラクタ間で初期化処理を共通化できる。
- `this(0, "T-shirt")`は自分自身(`Item()`)を再帰的に呼んでいるのではなく、**別のシグネチャを持つ**`Item(int id, String name)`を呼んでいるので、無限ループにはならない（Dは誤り）。
- `new Item()`→`this(0, "T-shirt")`が実行され、`id=0`, `name="T-shirt"`がセットされる。`printItem()`の呼び出しは`main`の中で1回だけ（Eは誤り、コンストラクタの中で`printItem()`を呼んでいるわけではない）。
- `javac`/`java`で検証済み：`Item id:0 name:T-shirt`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q13"></a>
## 問題13(sample/chap5/13)

```java
class Sample {
    int value = 100;
    static int commonValue = 500;
    public void printValue() { System.out.println("instance value : " + value); }
    public static void printCommonValue() { System.out.println("static common value : " + commonValue); }
}
public class Main {
    public static void main(String[] args) {
        Sample s1 = new Sample();
        Sample s2 = new Sample();
        s1.commonValue = 999;
        System.out.println(s2.commonValue);
        System.out.println(Sample.commonValue);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `500` の後 `999`（`s1`経由の変更は`s1`だけに影響する）
B. `999` の後 `999`
C. `500` の後 `500`
D. `999` の後 `500`
E. `s1.commonValue = 999;`の行でコンパイルエラーになる（`static`変数はインスタンス経由で代入できない）

**解答**

正解：**B**

**補足**

- `static`フィールドは、インスタンスごとではなく**クラスに1つだけ存在する**共有の値。`s1.commonValue = 999;`のように**インスタンス変数経由で書く（アクセスする）ことも文法上は許可されている**が、実際に書き換わるのは全インスタンスで共有されているその1つの値そのもの（Eは誤り、書けてしまう。ただし推奨されるスタイルではなく警告が出る処理系もある）。
- そのため`s1`経由で書き換えても、`s2.commonValue`や`Sample.commonValue`（クラス名経由の正式なアクセス方法）も含めて、**どこから見ても同じ`999`**になる（A・C・Dは誤り）。
- `javac`/`java`で検証済み：`999` / `999`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q14"></a>
## 問題14(sample/chap5/14)

```java
class Test {
    static int num;
    String s;
    static { num = 100; System.out.println("static Initializer... num : " + num); }
    { System.out.println("Initializer... s : " + s); this.s = "Test"; }
    public Test(String s) { this.s = s; System.out.println("Constructor... s : " + s); }
}
public class Main {
    static { System.out.println("static Initializer... Main"); }
    public static void main(String[] args) { new Test("A"); }
}
```

次のプログラムを実行すると、何が出力される順序になりますか。（1つ選択）

A.
```
static Initializer... Main
static Initializer... num : 100
Initializer... s : null
Constructor... s : A
```

B.
```
static Initializer... num : 100
static Initializer... Main
Initializer... s : null
Constructor... s : A
```

C.
```
static Initializer... Main
static Initializer... num : 100
Initializer... s : Test
Constructor... s : A
```

D.
```
Initializer... s : null
static Initializer... Main
static Initializer... num : 100
Constructor... s : A
```

E. `Test`クラスのstatic初期化子とインスタンス初期化子を同時に定義することはできない

**解答**

正解：**A**

**補足**

- `Main`クラスがJVMにロードされ`main`が始まる前に、**`Main`自身の`static`初期化子**がまず実行される(`"static Initializer... Main"`)。
- `main`の中で初めて`Test`クラスが使われる(`new Test("A")`)ので、この時点で`Test`クラスがロードされ、**`Test`の`static`初期化子**が(このプログラム全体を通して最初の1回だけ)実行される(`"static Initializer... num : 100"`)。
- クラスのロードが終わった後、実際にインスタンスを生成する処理として、**インスタンス初期化子(`{ }`)→コンストラクタ本体**の順で実行される。インスタンス初期化子の時点では、コンストラクタ本体でまだ`this.s = s;`が実行されていないため、`s`は`null`のまま(`"Initializer... s : null"`。Cは誤り)。
- 最後にコンストラクタ本体が実行され`this.s = "A"`となり`"Constructor... s : A"`。
- static初期化子とインスタンス初期化子は同じクラスに何個でも共存できる（Eは誤り）。
- `javac`/`java`で検証済み：A の順序。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q15"></a>
## 問題15(sample/chap5/15)

```java
public class Main {
    public static void main(String[] args) {
        int val1 = 100;
        int val2 = val1;
        val2 = 200;
        Main obj = new Main();
        obj.methodA(val2);
        System.out.println("val1 : " + val1);
        System.out.println("val2 : " + val2);
    }
    public void methodA(int val3) {
        val3 += val3;
        System.out.println("val3 : " + val3);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `val3 : 400` の後 `val1 : 100` `val2 : 400`（`methodA`内の変更が`val2`にも反映される）
B. `val3 : 400` の後 `val1 : 100` `val2 : 200`
C. `val3 : 200` の後 `val1 : 100` `val2 : 200`
D. `val3 : 400` の後 `val1 : 200` `val2 : 200`（`val1`は`val2`のコピー元なので連動する）
E. コンパイルエラーになる（`methodA`の引数名が呼び出し元の変数名と異なる）

**解答**

正解：**B**

**補足**

- `int val2 = val1;`は、`val1`が持つ**値のコピー**を`val2`に代入するだけ。以後`val1`と`val2`は完全に独立した別の変数であり、片方を変えてももう片方には一切影響しない（Dは誤り）。
- `obj.methodA(val2)`も同様に、`val2`の**値(`200`)のコピー**が仮引数`val3`に渡される(**値渡し**)。`methodA`の中で`val3`をどれだけ書き換えても、それは`val3`というメソッド内だけのローカルな話で、呼び出し元の`val2`には一切影響しない（Aは誤り）。
- メソッドの仮引数名と呼び出し時の実引数の変数名が一致している必要は無い（Eは誤り）。
- `val3 = 200 + 200 = 400`。呼び出し元の`val1`, `val2`はどちらも変化しない。
- `javac`/`java`で検証済み：`val3 : 400` / `val1 : 100` / `val2 : 200`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q16"></a>
## 問題16(sample/chap5/16)

```java
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Main obj = new Main();
        obj.methodB(array);
        System.out.println("main() array : " + Arrays.toString(array));
    }
    public void methodB(int[] ary) {
        ary[1] = 5;
        System.out.println("methodB() ary : " + Arrays.toString(ary));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `methodB() ary : [1, 5, 3]` の後 `main() array : [1, 2, 3]`（配列も値渡しなので呼び出し元は変わらない）
B. `methodB() ary : [1, 5, 3]` の後 `main() array : [1, 5, 3]`
C. `methodB() ary : [1, 2, 3]` の後 `main() array : [1, 5, 3]`
D. コンパイルエラーになる（配列をメソッドの引数として渡すには明示的なコピーが必要）
E. 実行時に配列が複製されるため、両方とも`[1, 2, 3]`のまま

**解答**

正解：**B**

**補足**

- Javaでは配列も含め、オブジェクト全般は「**参照(そのオブジェクトの場所を指す値)そのものが値渡しされる**」という扱いになる。`ary`には`array`と**同じ配列オブジェクトを指す参照のコピー**が渡される。
- 参照のコピーではあっても、指している先の配列オブジェクトは**呼び出し元と全く同じ実体**なので、`ary[1] = 5;`のように**要素の中身を書き換える**操作は、その実体を通して呼び出し元にもそのまま反映される（Aは誤り、「値渡しだから配列の中身も独立している」という誤解に注意。問題15の`int`の値渡しとは影響範囲が全く異なる）。
- 配列を引数として渡す際に自動的な複製が行われることは無い（E・Dは誤り）。
- `javac`/`java`で検証済み：`methodB() ary : [1, 5, 3]` / `main() array : [1, 5, 3]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q17"></a>
## 問題17(sample/chap5/17)

```java
class Item { String name; Item(String name) { this.name = name; } }
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("T-shirt");
        Item item2 = item1;
        item2.name = "Jeans";
        System.out.println("item1, item2 : " + item1.name + ", " + item2.name);
        System.out.println("item1 == item2 : " + (item1 == item2));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `item1, item2 : T-shirt, Jeans` の後 `item1 == item2 : false`
B. `item1, item2 : Jeans, Jeans` の後 `item1 == item2 : true`
C. `item1, item2 : T-shirt, Jeans` の後 `item1 == item2 : true`
D. `Item item2 = item1;`の行で新しい`Item`オブジェクトが複製生成される
E. 実行時に`item1`と`item2`が別々のオブジェクトになるよう自動的に調整される

**解答**

正解：**B**

**補足**

- `Item item2 = item1;`は、`item1`が持つ**参照のコピー**を`item2`に代入するだけで、**新しいオブジェクトが複製生成されるわけではない**（D・Eは誤り）。`item1`と`item2`は同じ1つの`Item`オブジェクトを指す、2つの「呼び方」に過ぎない。
- `item2.name = "Jeans";`は、その**唯一のオブジェクト**の`name`フィールドを書き換える操作。よって`item1.name`で見ても`item2.name`で見ても、同じ`"Jeans"`が見える（Aは誤り）。
- `item1 == item2`は「同じオブジェクトを指しているか」を調べる参照比較なので`true`。
- `javac`/`java`で検証済み：`item1, item2 : Jeans, Jeans` / `item1 == item2 : true`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q18"></a>
## 問題18(sample/chap5/18)

```java
class Item {}
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = item1;
        item1 = null;
        item2 = null;
        Item item3 = new Item();
        item3 = new Item();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、何も出力せず正常終了する
B. `item1 = null;`の行で`NullPointerException`がスローされる
C. `item2 = null;`の行でコンパイルエラーになる（`item1`と参照を共有している変数に`null`は代入できない）
D. `item3 = new Item();`の行でコンパイルエラーになる（変数の再代入は1度しかできない）
E. 最初に生成した`Item`オブジェクトへの参照が誰からも失われた時点で実行時エラーになる

**解答**

正解：**A**

**補足**

- 参照型のローカル変数に`null`を代入することは、`item1`と`item2`が元々同じオブジェクトを参照し合っていたかどうかに関係なく、それぞれ独立に自由に行える（Cは誤り）。`null`の代入自体は例外を発生させる操作ではない（Bは誤り、`NullPointerException`は`null`を**参照して**メンバにアクセスしようとしたときに起きるものであり、`null`を代入する行為そのものではない）。
- 通常のローカル変数（`final`が付いていない）は何度でも再代入できる（Dは誤り）。
- 誰からも参照されなくなったオブジェクト(最初に`new Item()`で作ったもの)は、いずれガベージコレクションの対象になるだけで、それによってプログラムがエラーになることは無い（Eは誤り）。
- `javac`/`java`で検証済み：問題なくコンパイル・実行でき、何も出力せず正常終了する。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex1"></a>
## 問題ex1(sample/chap5/ex1)

```java
public class Test {
    int num1 = 0;
    var num2 = 10;
    private String num3;
    protected String[] array;
    public static final long value;
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `var num2 = 10;`の行でコンパイルエラーになる（`var`はフィールド(メンバ変数)の宣言には使えない）
C. `public static final long value;`の行だけがコンパイルエラーになる（初期化されていないため）
D. `private`や`protected`など複数のアクセス修飾子が同じクラス内に混在しているためコンパイルエラーになる
E. フィールドの型は宣言順に一貫していなければならないためコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `var`はローカル変数（メソッドやコンストラクタの中の変数）専用の型推論キーワードであり、**フィールド(クラスのメンバ変数)の宣言には使えない**。
- 1つのクラスの中でフィールドごとに異なるアクセス修飾子(`private`, `protected`, デフォルト, `public`)を使い分けることは普通に行われ、何の制約も無い（Dは誤り）。フィールドの型がバラバラであることにも制約は無い（Eは誤り）。
- （参考：`public static final long value;`のような初期値の無い`final`フィールドは、コンストラクタなどで確実に代入されなければ別途コンパイルエラーになる区分の問題だが、今回は`var`の行が先に検出される）。
- `javac`で検証済み：「'var'はここでは許可されません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex2"></a>
## 問題ex2(sample/chap5/ex2)

```java
public class Product {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        p.setName("Pen");
        System.out.println(p.name);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`Pen`が出力される
B. `p.name`の行でコンパイルエラーになる（`name`は`Product`の外からアクセスできない）
C. `p.setName("Pen");`の行でコンパイルエラーになる
D. `Product`と`Main`が別ファイルに分かれているためコンパイルエラーになる
E. 実行時に`SecurityException`がスローされる

**解答**

正解：**B**

**補足**

- 第6問と同じ論点。`private`なフィールドには、そのフィールドを宣言したクラス自身の外から**フィールド名で直接**アクセスすることはできない。別クラス(別ファイル)であるかどうかは関係なく、`Product`クラスの外であれば常に不可（Dは誤り、別ファイルであること自体は普通）。
- `getName()`/`setName()`という`public`なメソッドを経由したアクセスは問題ない（Cは誤り）。
- `javac`で検証済み：「`name`は`Product`で`private`アクセスされます」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex4"></a>
## 問題ex4(sample/chap5/ex4)

```java
// パッケージ a
package a;
public class Foo {
    int val;
    int getVal() { return val; }
    void setVal(int val) { this.val = val; }
}

// パッケージ b
package b;
import a.Foo;
public class Main {
    public static void main(String[] args) {
        Foo obj = new Foo();
        obj.val = 5;
        System.out.println(obj.val);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`5`が出力される
B. `Foo`クラス自体が`public`ではないため、`import`の行でコンパイルエラーになる
C. `obj.val = 5;`と`System.out.println(obj.val);`の行でコンパイルエラーになる（`val`フィールドがデフォルトアクセスで、パッケージ外からは見えないため）
D. `getVal()`/`setVal()`もデフォルトアクセスなので、そもそも`b`パッケージからは何も呼び出せない
E. 同じ`obj`という変数名を複数のパッケージで使うことはできない

**解答**

正解：**C**

**補足**

- `Foo`クラス自体には`public`が付いているので、パッケージ`b`から`import`して使うこと自体はできる（Bは誤り）。
- しかし`val`フィールドや`getVal()`/`setVal()`メソッドには**アクセス修飾子が付いていない(デフォルトアクセス)**。デフォルトアクセスは「**同じパッケージの中からしか**アクセスできない」という制約であり、クラス自体の`public`/`private`とは別軸の話。
- 今回`val`フィールドに**直接**アクセスしようとしている(`obj.val`)ため、パッケージ`b`からはアクセスできずコンパイルエラーになる。
- もし`getVal()`/`setVal()`が`public`であれば(元のサンプルはそう定義されている)、それらのメソッド経由でのアクセスは問題なく行える（Dは誤り。ただし今回の問題文のコードは`val`に直接アクセスしている点に注意）。
- 変数名がパッケージをまたいで重複すること自体には何の制約も無い（Eは誤り）。
- `javac`で検証済み：`obj.val = 5;`と`System.out.println(obj.val);`の両方の行で「`Foo`の`val`は`public`ではありません。パッケージ外からはアクセスできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex6"></a>
## 問題ex6(sample/chap5/ex6)

```java
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        double v = obj.x(10);
        System.out.println(v);
    }
    double x(int n) { return n * 1.5; }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `15`
B. `15.0`
C. `10.0`
D. コンパイルエラーになる（`int`の計算結果を`double`型の戻り値として返せない）
E. 実行時に`ClassCastException`がスローされる

**解答**

正解：**B**

**補足**

- `x(int n)`メソッドの戻り値の型は`double`。本体の`n * 1.5`は`int`と`double`リテラルの演算なので、`n`が自動的に`double`に昇格されてから計算され(`10 * 1.5 = 15.0`)、結果はすでに`double`型。これをそのまま`double`として`return`するのは何の問題も無い（Dは誤り）。
- 呼び出し側で`double v = obj.x(10);`と受け取り、`println(v)`は`double`型の値をそのまま表示するので、整数っぽい値でも`.0`が付いた形式(`15.0`)で出力される（Aは誤り）。
- `javac`/`java`で検証済み：`15.0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex7"></a>
## 問題ex7(sample/chap5/ex7)

```java
public class Item {
    private int id;
    private String name;
    public Item() {
        this(2, "Book");
    }
    public Item(int id, String name) {
        id = id;
        name = name;
    }
    public void display() {
        System.out.print(id + ":" + name + " ");
    }
    public static void main(String[] args) {
        new Item(1, "Apple").display();
        new Item().display();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1:Apple 2:Book `
B. `0:null 0:null `
C. コンパイルエラーになる（`id = id;`は自分自身への無意味な代入としてエラーになる）
D. `1:Apple 0:null `（`this()`経由のときだけ反映されない）
E. `NullPointerException`がスローされる（`name`が`null`のまま連結されるため）

**解答**

正解：**B**

**補足**

- コンストラクタの仮引数`id`, `name`は、フィールドの`id`, `name`と**同じ名前**（シャドーイング）。`id = id;`と書くと、これは**仮引数`id`に、仮引数`id`自身の値を代入しているだけ**であり、フィールドの`this.id`には一切触れていない。`this.id = id;`のように明示的に`this.`を付けなければ、フィールドの方は更新されない。
- この「`this.`忘れ」のバグにより、`new Item(1, "Apple")`のように意味のある引数を渡しても、フィールド`id`/`name`はデフォルト値(`0`/`null`)のまま変わらない（A・Dは誤り）。
- 自分自身への代入(`id = id;`)は文法的には正当な文であり、コンパイルエラーにはならない（Cは誤り、無意味ではあるが違反ではない）。
- `name`は`null`のままだが、`+`による文字列連結は`null`を自動的に文字列`"null"`として扱うので例外にはならない（Eは誤り）。
- `javac`/`java`で検証済み：`0:null 0:null `（`this(2, "Book")`経由でも同じ理由で反映されない）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8(sample/chap5/ex8)

```java
public class Test {
    String text = "A";
    void method() { text = "B"; }
    void method(String t) {
        String text = "C";
        System.out.print(text);
    }
    public static void main(String[] args) {
        String text = "D";
        Test t = new Test();
        t.method("E");
        System.out.print(t.text);
        t.method();
        System.out.print(text);
        System.out.print(t.text);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `CADB`
B. `EADB`
C. `CABB`
D. `CADA`
E. コンパイルエラーになる（フィールドとローカル変数、複数のメソッドで同じ名前`text`を使い回すことはできない）

**解答**

正解：**A**

**補足**

- フィールド名とローカル変数名(メソッドの引数やメソッド内で宣言した変数、`main`内の変数)が同じ`text`であっても、**それぞれ別のスコープに属する別々の変数**として扱われ、コンパイルエラーにはならない（Eは誤り）。ローカル変数がある場所では、そのローカル変数がフィールドを覆い隠す(シャドーイングする)。
- `t.method("E")`：`method(String t)`が呼ばれる。この中で新しく`String text = "C";`と宣言しているので、これは**フィールドの`text`とは無関係な、このメソッド専用のローカル変数**。`print(text)`は`"C"`を出力。フィールド`text`(`"A"`)は一切変更されない。
- `print(t.text)`：フィールドはまだ`"A"`のまま→出力`"A"`。
- `t.method()`：引数無し版が呼ばれる。こちらにはローカル変数の`text`が無いので、`text = "B";`は**フィールドの`text`**を指し、フィールドが`"B"`に変わる。
- `print(text)`：`main`内のローカル変数`text`(`"D"`、フィールドとは無関係)を参照→出力`"D"`。
- `print(t.text)`：フィールドは`method()`によってすでに`"B"`に変わっている→出力`"B"`。
- 合計：`"C" + "A" + "D" + "B"` = `CADB`。
- `javac`/`java`で検証済み：`CADB`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex9"></a>
## 問題ex9(sample/chap5/ex9・複数選択)

```java
class Sample1 { Sample1() {} }
class Sample2 {}
class Sample3 { void Sample3(int i) {} }
class Sample4 { Sample4(String s, int i) {} }
```

引数無しで`new クラス名()`と書いてインスタンス化できるものをすべて選んでください。（複数選択）

A. `new Sample1()`
B. `new Sample2()`
C. `new Sample3()`
D. `new Sample4()`

**解答**

正解：**A、B、C**（Dのみ不可）

**補足**

- **A**：`Sample1()`という、引数無しのコンストラクタが明示的に定義されている。→OK
- **B**：コンストラクタが1つも定義されていない。この場合Javaが**暗黙のデフォルトコンストラクタ(引数無し)**を自動生成する。→OK
- **C**：`void Sample3(int i) {}`は、**戻り値の型(`void`)が書かれている時点でコンストラクタではなく、ただの「クラス名と同じ名前の通常のメソッド」**。コンストラクタが1つも定義されていない扱いになるので、Bと同じく暗黙のデフォルトコンストラクタが使える。→OK（`new Sample3(1)`のような呼び出しはできない点に注意）
- **D**：`Sample4(String s, int i)`という**引数付き**のコンストラクタが明示的に1つ定義されている。1つでも明示的にコンストラクタを定義すると暗黙のデフォルトコンストラクタは生成されなくなるため、引数無しの`new Sample4()`はできない。→NG
- `javac`で検証済み：`new Sample4();`の行のみ「クラス`Sample4`のコンストラクタ`Sample4`は指定された型に適用できません（期待値: String,int、検出値: 引数がありません）」。他の3つはエラー無し。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex10"></a>
## 問題ex10(sample/chap5/ex10)

```java
public class Employee {
    int id;
    String name;
    public void Employee(int id) {
        this.id = id;
    }
    public Employee(String name, int id) {
        this.name = name;
        this(id);
    }
    public void showEmployeeInfo() {
        System.out.println(id + ":" + name);
    }
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showEmployeeInfo();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `this(id);`の行だけがコンパイルエラーになる
C. `this(id);`の行と`new Employee();`の行、合わせて複数のコンパイルエラーになる
D. `public void Employee(int id)`の行がコンパイルエラーになる（コンストラクタに戻り値の型は書けない）
E. 実行時に`0:null`が出力される

**解答**

正解：**C**

**補足**

- `public void Employee(int id)`は、`void`が付いているため**コンストラクタではなく通常のメソッド**として扱われる（この宣言自体はコンパイルエラーにはならない。Dは誤り。「コンストラクタのつもりで書いたが実はメソッドになっている」というのがこの問題の隠れた罠）。
- `this(id);`は「`Employee(int)`という**コンストラクタ**」を呼び出そうとしているが、そのようなコンストラクタは存在しない（上の`Employee(int id)`はメソッドであってコンストラクタではないため）。さらに`this(...)`呼び出しはコンストラクタの**先頭の文でなければならない**というルールにも違反している(`this.name = name;`の後に書かれている)。この1行だけで2種類のエラーが同時に検出される。
- `Employee(String, int)`という引数付きコンストラクタが定義されているため、暗黙のデフォルトコンストラクタは生成されない。よって`main`内の`new Employee();`（引数無し）も別途コンパイルエラーになる（Bは誤り、エラーは1箇所だけではない）。
- `javac`で検証済み：合計3件のエラー（`this(id);`の行で「thisの呼出しはコンストラクタの先頭文である必要があります」と「コンストラクタEmployeeは指定された型に適用できません」の2件、`new Employee();`の行で1件）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11(sample/chap5/ex11)

```java
public class Test {
    public void foo(int x) {}
    public void foo(int x, int y) {}
    public static void main(String[] args) {
        Test t = new Test();
        t.foo(1);
        t.foo(1, 2);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（引数の数が異なるオーバーロードとして正しく区別される）
B. `foo`という同じ名前のメソッドを2つ定義しているためコンパイルエラーになる
C. `t.foo(1);`の呼び出しがどちらの`foo`を指すか曖昧でコンパイルエラーになる
D. 2つ目の`foo(int x, int y)`は、1つ目の`foo(int x)`の可変長引数版として扱われ、1つのメソッドに統合される
E. 実行時にどちらの`foo`が呼ばれるか不定になる

**解答**

正解：**A**

**補足**

- メソッド名が同じでも、**引数の数（今回は1個か2個か）が異なれば別のシグネチャ**として問題なく共存できる（B・Dは誤り。可変長引数(`...`)は明示的に書かない限り自動的にそう解釈されることはない）。
- `foo(1)`は引数1個なので`foo(int x)`に、`foo(1, 2)`は引数2個なので`foo(int x, int y)`に、**それぞれ一意に**対応付けられる（曖昧さは無い。Cは誤り）。
- オーバーロードの解決はコンパイル時に確定するので、実行時に「不定になる」ことは無い（Eは誤り）。
- `javac`で検証済み：エラー無くコンパイルが通る。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex12"></a>
## 問題ex12(sample/chap5/ex12)

```java
class Test {
    int x; int y;
    Test(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void print() { System.out.print(x + ":" + y); }
    public static void main(String[] args) {
        Test t = new Test(6, 9);
        System.out.print(x + ":" + y);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`6:9`が出力される
B. `main`メソッドの中で`x`と`y`を参照している行でコンパイルエラーになる（`static`な`main`から、`static`ではないインスタンスフィールドを直接参照している）
C. `t.print();`のように`t`経由で呼ばないと`print()`の中身が実行されないだけで、`main`側の`x`, `y`はコンパイルは通る
D. `Test(int x, int y)`というコンストラクタの引数名がフィールド名と同じであるためコンパイルエラーになる
E. 実行時に`x`, `y`が両方とも`0`として扱われる

**解答**

正解：**B**

**補足**

- `main`メソッドは`static`。`static`なコンテキストの中からは、**インスタンスごとに存在するフィールド(`x`, `y`)を、どのインスタンスの値か指定せずに直接参照することはできない**。`t.x`, `t.y`のように、どのインスタンスのものかを明示すれば参照できる。
- コンストラクタの引数名とフィールド名が同じであること自体はごく普通の書き方で、コンパイルエラーの原因にはならない（`this.x = x;`のように区別して書けば問題ない。Dは誤り）。
- このエラーはコンパイル時に検出されるものであり、実行時の値の話ではない（Eは誤り、そもそも実行段階まで到達しない）。
- `javac`で検証済み：「staticでない変数`x`をstaticコンテキストから参照することはできません」「staticでない変数`y`をstaticコンテキストから参照することはできません」の2件。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13(sample/chap5/ex13)

`sample/chap5/ex13/Sample.java`には、実は次のコードがそのまま含まれています。

```java
public class Sample {
    public Sample() {
        this(1);
        System.out.print(0);
    }
    public Sample(int x) {
        this(x, 2);
        this();
        System.out.print(x);
    }
    public Sample(int x, int y) {
        System.out.print(x + "" + y);
    }
    public static void main(String[] args) {
        new Sample(3);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`320`が出力される（`this(x,2)`→`this()`→`print(x)`の順で連鎖する）
B. `this();`の行でコンパイルエラーになる（1つのコンストラクタの中で`this(...)`は1回・先頭でしか呼べないため）
C. 無限再帰になる（`Sample(int x)`が`Sample()`を、`Sample()`が`Sample(int x)`を呼び合うため）
D. `public Sample(int x, int y)`が`this(x, 2)`と`this()`の両方から呼ばれるため、コンパイルエラーになる
E. `new Sample(3)`という呼び出し自体が、3つあるコンストラクタのどれに対応するか曖昧でコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `this(...)`（別のコンストラクタを呼び出す構文）には、「**1つのコンストラクタにつき、先頭の文として1回だけ**」という制約がある。`Sample(int x)`は`this(x, 2);`をすでに書いており、その**次の行**にさらに`this();`を書いてしまっているため、この時点で違反になる。
- もしこの制約が無ければ理論上は`this(x,2)`→`this()`→`Sample()`→`this(1)`→`Sample(int x)`→…と**無限に連鎖しうる**構造になっている（Cで懸念されている通り）。しかし、Javaはこの「`this(...)`は先頭に1回だけ」というルールによって、**そもそもコンストラクタの`this()`チェーンでは無限再帰の構造自体が作れないように、設計上防いでいる**。
- （参考：もし`this(...)`ではなく、同じ処理を**普通のインスタンスメソッド**として書いた場合(`sample/chap5/ex13/Test.java`)は、このような制約が無いため、`func()`→`func(1)`→`func(x,2)`＋`func()`→…という**本当の無限再帰**が発生し、`StackOverflowError`で異常終了する。コンストラクタの`this()`は「安全なチェーン」、通常メソッドの呼び出しは「歯止めの無い呼び出し」という違いが、この2つのファイルの対比から見えてくる）。
- `javac`で検証済み：`this();`の行で「thisの呼出しはコンストラクタの先頭文である必要があります」。`Test.java`（同等の処理を通常メソッドで書いたもの）は問題なくコンパイルできるが、実行すると`StackOverflowError`になることを確認済み。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14(sample/chap5/ex14)

```java
public class Test {
    public int foo(int x, int y) { return x * y; }
    public int foo(int... x) {
        int z = 0;
        for (int y : x) { z += y; }
        return z;
    }
    public void bar(Integer i) { System.out.print("Integer:" + i + " "); }
    public void bar(float i) { System.out.print("float:" + i + " "); }
    public void bar(String... s) { System.out.println("varargs:" + s.length); }
    public static void main(String... args) {
        Test t = new Test();
        System.out.print(t.foo(10, 2) + " ");
        t.bar(7);
        t.bar();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `20 Integer:7 varargs:0`
B. `12 float:7.0 varargs:0`
C. `20 float:7.0 varargs:0`
D. `20 float:7.0`のみ（引数無しの`bar()`は呼び出し候補が無くコンパイルエラーになる）
E. `12 Integer:7 varargs:0`

**解答**

正解：**C**

**補足**

- `t.foo(10, 2)`：`int`が2つ→固定引数版`foo(int x, int y)`が可変長引数版より優先され`10 * 2 = 20`。
- `t.bar(7)`：`int`リテラルの`7`は、`Integer`(オートボクシング)・`float`(暗黙の拡大)・`String...`(可変長引数)のいずれにも渡せるが、オーバーロード解決は「ボクシングや可変長引数を使わない、拡大変換のみの候補」を優先する。よって`bar(float i)`が選ばれる（Aは誤り、`Integer`は後回しにされる）。
- `t.bar()`：引数無しで呼べるのは`bar(String... s)`（可変長引数は0個の引数も受け付けられる）だけ。他の2つは必ず1つの引数を要求するので候補にならない（Dは誤り、これは正当な呼び出し）。`s.length`は`0`。
- `javac`/`java`で検証済み：`20 float:7.0 varargs:0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15(sample/chap5/ex15)

```java
class Sample { int val = 10; }
public class Main {
    public static void main(Sample s) {
        s.val++;
        System.out.print(s.val);
    }
    public static int main(int i) {
        return i * i;
    }
    public static void main(String[] args) {
        Sample s = new Sample();
        main(s);
        int num = main(10);
        System.out.print(s.val + num);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `public static void main(String[] args)`以外の`main`を定義することはできず、コンパイルエラーになる
B. 問題なくコンパイルが通り`11111`が出力される
C. 3つの`main`メソッドが同名で曖昧になりコンパイルエラーになる
D. `java Main`で実行したとき、`main(Sample s)`が最初に実行される
E. 問題なくコンパイルが通るが、`main(s)`や`main(10)`の呼び出しはJVMのエントリーポイントと衝突し実行時エラーになる

**解答**

正解：**B**

**補足**

- `main`という名前のメソッドは、**引数の型・数が異なる限り、いくつでもオーバーロードできる**（Cは誤り、名前は同じでもシグネチャが異なれば曖昧にはならない）。JVMのエントリーポイントとして特別扱いされるのは、あくまで`public static void main(String[] args)`という**ちょうど1つの決まったシグネチャ**だけ（Aは誤り）。
- `java Main`で実行された場合にJVMが呼び出すのは`main(String[] args)`だけであり、他の`main`オーバーロードはJVMからは呼ばれない、**普通の`static`メソッドとして自分で呼び出す**ことになる（Dは誤り。E も誤り、衝突は起きない）。
- `main(s)`：`s.val`(`10`)を`++`で`11`にし、`print`で`11`を出力。`main(10)`：`10*10=100`を返し`num=100`。最後に`print(s.val + num)`＝`print(11 + 100)`＝`print(111)`。
- 合計出力：`"11"`(呼び出し内)＋`"111"`(最後の行) = `"11111"`。
- `javac`/`java`で検証済み：`11111`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex16"></a>
## 問題ex16(sample/chap5/ex16)

```java
public class Counter {
    static int count;
    public void Counter(int count) { this.count = count; }
    public void reset() { count = 0; }
    public static void update(int c) { count += c; }
    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.update(3);
        c1.reset();
        count--;
        new Counter().count++;
        Counter c2 = new Counter();
        c2.update(1);
        System.out.println(Counter.count);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1`
B. `3`
C. `new Counter();`の行でコンパイルエラーになる（引数付きの`Counter(int count)`しか定義されていないため）
D. `2`
E. `count`は`static`なので、インスタンス経由(`c1.update`, `new Counter().count++`)でアクセスすること自体がコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `public void Counter(int count)`は、**戻り値の型(`void`)が付いているのでコンストラクタではなく通常のメソッド**。よってこのクラスには明示的なコンストラクタが1つも存在しないことになり、暗黙のデフォルトコンストラクタ(引数無し)が使える。`new Counter()`は問題なくコンパイルできる（Cは誤り）。
- `static`フィールドや`static`メソッドを、インスタンス経由(`c1.update(...)`や`インスタンス.フィールド`)でアクセスすることは、実質的にクラス名経由と同じ扱いとして許可されている（Eは誤り。行儀の良いスタイルではないが違反ではない）。
- 順を追うと：`c1.update(3)`→`count=3`。`c1.reset()`→`count=0`。`count--`→`count=-1`。`new Counter().count++`→（この一時的な`Counter`インスタンス経由でも、結局同じ共有の`static`フィールドにアクセスしているだけ）→`count`は`-1→0`。`c2.update(1)`→`count=1`。
- `javac`/`java`で検証済み：`1`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex17"></a>
## 問題ex17(sample/chap5/ex17)

```java
class Fruit { String name; Fruit(String name) { this.name = name; } }
public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = { new Fruit("Lemon"), new Fruit("Kiwi"), new Fruit("Lime")};
        method(fruits);
        fruits[1] = null;
        for (var f : fruits)
            if (f != null) System.out.print(f.name + " ");
    }
    public static void method(Fruit[] x) {
        for (var f : x)
            if (f.name.length() == 5) f = null;
    }
}
```

問題1とほぼ同じコードですが、`method`の中身が`f.name = "REMOVED";`ではなく`f = null;`になっています。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `REMOVED Lime `（問題1と同じ結果になる）
B. `Lime `（`f = null`により、対応する配列の要素も`null`になる）
C. `Lemon Lime `
D. 実行時に`NullPointerException`がスローされる
E. `Lemon Kiwi Lime `

**解答**

正解：**C**

**補足**

- 拡張forの`f`は、配列の各要素の**参照のコピー**を受け取るローカル変数。`f.name = ...`（問題1）は「`f`が指しているオブジェクトのフィールドを書き換える」操作であり、これは元の配列の要素(同じオブジェクト)にも影響する。
- 一方`f = null;`（本問）は「`f`という**ローカル変数自体の指す先を`null`に付け替える**」操作でしかない。配列`x`の要素(`x[0]`, `x[1]`, `x[2]`)が実際に指しているものには一切影響しない（B・Dは誤り。`f`が`null`になっても、元のオブジェクトを介した`x`側の参照は健在で、後で`f.name`にアクセスして`NullPointerException`になるようなことも起きない）。
- よって`method`は実質何もしていないのと同じで、`"Lemon"`(5文字)は書き換わらない。その後`main`側で`fruits[1] = null;`（`Kiwi`を除去）だけが効く。
- 出力：`fruits[0].name="Lemon"`, `fruits[1]=null`(スキップ), `fruits[2].name="Lime"` → `Lemon Lime `。
- `javac`/`java`で検証済み：`Lemon Lime `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex18"></a>
## 問題ex18(sample/chap5/ex18)

```java
class Item {}
public class Main {
    public static void main(String[] args) {
        Item obj1 = new Item();
        Item obj2 = new Item();
        method(obj1);
        obj1 = new Item();
        obj2 = null;
    }
    public static void method(Item obj) {
        obj = new Item();
    }
}
```

このプログラムを実行した後の状態について、正しい記述はどれですか。（1つ選択）

A. `method(obj1)`の中で`obj`に新しい`Item`を代入しているので、呼び出し元の`obj1`も新しい`Item`を指すようになる
B. `method(obj1)`を呼んだ時点と、その後の`obj1 = new Item();`は無関係で、`obj1`は`main`内で明示的に代入した新しい`Item`を指している
C. `method`の中の`obj = new Item();`が原因でコンパイルエラーになる（引数として渡された参照は再代入できない）
D. `obj1`と`obj2`は最終的に同じオブジェクトを指すようになる
E. 実行時に`obj1`が`method`内の変更を検知して同期される

**解答**

正解：**B**

**補足**

- `method(obj1)`が呼ばれると、`method`の仮引数`obj`には`obj1`が持つ**参照のコピー**が渡される。`method`の中で`obj = new Item();`と再代入しても、それは`method`内だけのローカルな`obj`という変数の指す先を変えただけで、呼び出し元の`obj1`が指すオブジェクトには一切影響しない（A・Eは誤り。引数の再代入自体は普通に行える操作でありコンパイルエラーにもならない。Cは誤り）。
- `method(obj1)`から戻った後、`main`側で明示的に`obj1 = new Item();`と書いているのは、`method`の影響とは**完全に無関係な、別の新しいオブジェクトへの代入**。
- `obj2 = null;`も独立した操作で、`obj1`とは無関係（Dは誤り、`obj1`と`obj2`が同じものを指すようになる理由が無い）。
- `javac`/`java`で検証済み：コンパイル・実行とも問題なく、`obj1`は`main`内の代入によって新しい`Item`を、`obj2`は`null`を指す状態でプログラムが終了する。

**実施記録**

回答：
正解：
迷ったポイント：