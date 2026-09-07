# 第6章 サンプル発展問題(1〜33・ex2,3,4,5,6,7,8,10,11,13,14,15,16,17,18,19,20,21,22,24 各1問、計53問)

`sample/chap6/1`〜`33`・`ex2,3,4,5,6,7,8,10,11,13,14,15,16,17,18,19,20,21,22,24`それぞれについて、難問寄りの発展問題を1問ずつ作成。全問`javac`/`java`で実行結果・エラーメッセージを検証済み。

## 目次

- [問題1(sample/chap6/1)](#q1)
- [問題2(sample/chap6/2)](#q2)
- [問題3(sample/chap6/3)](#q3)
- [問題4(sample/chap6/4)](#q4)
- [問題5(sample/chap6/5)](#q5)
- [問題6(sample/chap6/6)](#q6)
- [問題7(sample/chap6/7)](#q7)
- [問題8(sample/chap6/8)](#q8)
- [問題9(sample/chap6/9)](#q9)
- [問題10(sample/chap6/10)](#q10)
- [問題11(sample/chap6/11)](#q11)
- [問題12(sample/chap6/12)](#q12)
- [問題13(sample/chap6/13)](#q13)
- [問題14(sample/chap6/14)](#q14)
- [問題15(sample/chap6/15)](#q15)
- [問題16(sample/chap6/16)](#q16)
- [問題17(sample/chap6/17)](#q17)
- [問題18(sample/chap6/18)](#q18)
- [問題19(sample/chap6/19)](#q19)
- [問題20(sample/chap6/20)](#q20)
- [問題21(sample/chap6/21)](#q21)
- [問題22(sample/chap6/22)](#q22)
- [問題23(sample/chap6/23)](#q23)
- [問題24(sample/chap6/24)](#q24)
- [問題25(sample/chap6/25)](#q25)
- [問題26(sample/chap6/26)](#q26)
- [問題27(sample/chap6/27)](#q27)
- [問題28(sample/chap6/28)](#q28)
- [問題29(sample/chap6/29)](#q29)
- [問題30(sample/chap6/30)](#q30)
- [問題31(sample/chap6/31)](#q31)
- [問題32(sample/chap6/32)](#q32)
- [問題33(sample/chap6/33・複数選択)](#q33)
- [問題ex2(sample/chap6/ex2)](#qex2)
- [問題ex3(sample/chap6/ex3)](#qex3)
- [問題ex4(sample/chap6/ex4)](#qex4)
- [問題ex5(sample/chap6/ex5)](#qex5)
- [問題ex6(sample/chap6/ex6)](#qex6)
- [問題ex7(sample/chap6/ex7)](#qex7)
- [問題ex8(sample/chap6/ex8)](#qex8)
- [問題ex10(sample/chap6/ex10)](#qex10)
- [問題ex11(sample/chap6/ex11)](#qex11)
- [問題ex13(sample/chap6/ex13)](#qex13)
- [問題ex14(sample/chap6/ex14)](#qex14)
- [問題ex15(sample/chap6/ex15)](#qex15)
- [問題ex16(sample/chap6/ex16・複数選択)](#qex16)
- [問題ex17(sample/chap6/ex17)](#qex17)
- [問題ex18(sample/chap6/ex18)](#qex18)
- [問題ex19(sample/chap6/ex19)](#qex19)
- [問題ex20(sample/chap6/ex20)](#qex20)
- [問題ex21(sample/chap6/ex21)](#qex21)
- [問題ex22(sample/chap6/ex22)](#qex22)
- [問題ex24(sample/chap6/ex24)](#qex24)

<a id="q1"></a>
## 問題1(sample/chap6/1)

```java
class Animal {
    String name = "Animal";
    static String category() { return "Generic"; }
    void speak() {
        System.out.println(name + " makes a sound (" + category() + ")");
    }
}
class Dog extends Animal {
    String name = category();
    static String category() { return "Canine"; }
}
public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.speak();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Dog makes a sound (Canine)`
B. `Animal makes a sound (Canine)`
C. `Animal makes a sound (Generic)`
D. `Dog makes a sound (Generic)`
E. 実行時に`NullPointerException`がスローされる（`Dog`の`name`初期化時に`category()`がまだ使えないため）

**解答**

正解：**C**

**補足**

- `speak()`は`Animal`クラスに定義されているメソッド。この中で無条件に書かれた`name`と`category()`は、**呼び出されたインスタンスの実際の型(`Dog`)ではなく、そのコードが書かれている場所(`Animal`自身)を基準に解決される**。
- フィールド(`name`)は多態的に振る舞わない(オーバーライドではなくシャドーイング)ため、`Animal`の`speak()`内の`name`は常に`Animal`自身の`name`(`"Animal"`)を指す。
- `static`メソッド(`category()`)も同様に多態的ではない。`Animal`内で無条件に呼んだ`category()`は、常に`Animal.category()`(`"Generic"`)に解決される。`Dog`が独自の`category()`を持っていても、`Animal`のコードには一切影響しない。
- `Dog`の`name`フィールド自体の初期化(`category()`の呼び出し)は問題なく完了しており、`NullPointerException`は起きない（Eは誤り。これは`Dog`インスタンスが構築される際に一度だけ行われる別の話）。
- `javac`/`java`で検証済み：`Animal makes a sound (Generic)`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q2"></a>
## 問題2(sample/chap6/2)

```java
class Item {
    private int id = 100;
    public void display() {
        System.out.println("Item id: " + id);
    }
}
class Clothes extends Item {
    private String brand = "Java";
    @Override
    public void display() {
        super.display();
        System.out.println("Clothes brand: " + brand);
    }
}
public class Main {
    public static void main(String[] args) {
        new Clothes().display();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Item id: 100` の後 `Clothes brand: Java`
B. `Clothes brand: Java` の後 `Item id: 100`
C. `Clothes brand: Java`のみ（`super.display()`が`Item`の`display()`を上書きしてしまうため）
D. 無限ループになる（`super.display()`が`Clothes#display()`を再度呼び出すため）
E. `Item`の`id`が`private`なので`display()`自体がコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `super.display();`は「オーバーライドしている自分自身ではなく、直接の親クラス(`Item`)が持つ`display()`を明示的に呼び出す」という構文。これにより`Item#display()`の処理(`Item id: 100`の出力)が先に実行される。
- `super.display()`は`Item`側の`display()`だけを呼ぶのであって、無限に自分自身へ戻ってくることはない（Dは誤り）。呼び出しが終わればそのまま`Clothes#display()`の続きの行に処理が戻る。
- `private`なフィールド(`id`)であっても、そのフィールドを持つクラス自身が定義した`public`メソッド(`display()`)の中からは普通にアクセスできる（Eは誤り）。
- `javac`/`java`で検証済み：`Item id: 100` / `Clothes brand: Java`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q3"></a>
## 問題3(sample/chap6/3)

```java
class Super {
    public void methodA(int i) {}
}
class Sub extends Super {
    @Override
    public void methodA() {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（引数の有無に関わらず同じ名前ならオーバーライドとみなされる）
B. `Sub`の`methodA()`の行でコンパイルエラーになる（`Super`の`methodA(int i)`をオーバーライドできていないため）
C. `Super`の`methodA(int i)`の行がコンパイルエラーになる
D. `Sub`のクラス宣言自体がコンパイルエラーになる
E. `methodA()`は`methodA(int i)`のオーバーロードとして自動的に扱われ、`@Override`は単に無視される

**解答**

正解：**B**

**補足**

- オーバーライドが成立するための条件の1つは「**引数の型・数・順序(シグネチャ)が親と完全に一致していること**」。`methodA()`(引数無し)と`methodA(int i)`(引数1つ)は**別のシグネチャ**なので、これはオーバーライドではなく、たまたま同じ名前を持つ**別メソッド(オーバーロード)の新規追加**にあたる。
- しかし`@Override`アノテーションが付いているため、コンパイラは「これは本当にオーバーライドになっているか」を検証し、一致する親メソッドが無いことを検出してエラーにする（Eは誤り、`@Override`は無視されずむしろ検証に使われる）。
- `@Override`を外せば、この`methodA()`は単なるオーバーロードの追加としてコンパイルが通る（Aは誤り、`@Override`が付いている今回の設問としては不正解）。
- `javac`で検証済み：「メソッドはスーパータイプのメソッドをオーバーライドまたは実装しません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q4"></a>
## 問題4(sample/chap6/4)

```java
class Super {
    int x = 1;
    static int y = 2;
    void instMethod() { System.out.println("Super#instMethod()"); }
    static void statMethod() { System.out.println("Super#statMethod()"); }
}
class Sub extends Super {
    double x = 1.0;
    static double y = 2.0;
    void instMethod() { System.out.println("Sub#instMethod()"); }
    static void statMethod() { System.out.println("Sub#statMethod()"); }
}
public class Main {
    public static void main(String[] args) {
        Super obj = new Sub();
        System.out.println("obj.x:" + obj.x);
        System.out.println("obj.y:" + obj.y);
        obj.statMethod();
        obj.instMethod();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `obj.x:1.0` / `obj.y:2.0` / `Sub#statMethod()` / `Sub#instMethod()`（実際のオブジェクトの型がすべてに優先される）
B. `obj.x:1` / `obj.y:2` / `Super#statMethod()` / `Sub#instMethod()`
C. `obj.x:1` / `obj.y:2` / `Sub#statMethod()` / `Super#instMethod()`
D. `obj.x:1.0` / `obj.y:2` / `Super#statMethod()` / `Sub#instMethod()`
E. コンパイルエラーになる（`Sub`が`Super`と型の違うフィールド`x`, `y`を同名で再定義しているため）

**解答**

正解：**B**

**補足**

- 型が違っても同名のフィールドを再定義すること自体は「オーバーライド」ではなく「**シャドーイング(隠蔽)**」として正当に成立する（Eは誤り）。
- **フィールド**(`x`)・**static変数**(`y`)・**static メソッド**(`statMethod()`)は、いずれも多態的ではなく、**参照変数の宣言型(静的型、ここでは`Super`)を基準に解決される**。実際のオブジェクトが`Sub`であっても、`obj.x`は`Super`の`int x`(`1`)、`obj.y`は`Super`の`int y`(`2`)、`obj.statMethod()`も`Super#statMethod()`が呼ばれる。
- 一方、**通常のインスタンスメソッド**(`instMethod()`)だけが真に多態的(動的束縛)であり、実際のオブジェクトの型(`Sub`)を基準に`Sub#instMethod()`が呼ばれる。
- `javac`/`java`で検証済み：`obj.x:1` / `obj.y:2` / `Super#statMethod()` / `Sub#instMethod()`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q5"></a>
## 問題5(sample/chap6/5)

```java
public final class Super {}
class Sub extends Super {}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `class Sub extends Super {}`の行でコンパイルエラーになる（`final`クラスは継承できない）
C. `public final class Super {}`の行でコンパイルエラーになる（`final`と`public`は同時に付けられない）
D. 実行時に`new Sub()`をした瞬間にエラーになる
E. `Sub`は自動的に`Super`のコピーとして扱われ、継承関係にはならない

**解答**

正解：**B**

**補足**

- `final`をクラスに付けると、そのクラスは**それ以上サブクラスを持てない(継承禁止)**という意味になる。`public`と`final`は矛盾する組み合わせではなく普通に併用できる（Cは誤り）。
- この制約はコンパイル時に検出されるので、実行時まで問題が持ち越されることはない（D・Eは誤り）。
- `javac`で検証済み：「final `Super`からは継承できません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q6"></a>
## 問題6(sample/chap6/6)

```java
class A { A() { System.out.println("class A"); } }
class B extends A { B() { System.out.println("class B"); } }
class C extends B { C() { System.out.println("class C"); } }
class Main {
    public static void main(String[] args) { new C(); }
}
```

次のプログラムを実行すると、何が出力される順序になりますか。（1つ選択）

A. `class C` `class B` `class A`
B. `class A` `class B` `class C`
C. `class C`のみ（`A`, `B`のコンストラクタは明示的に呼ばれていないので実行されない）
D. コンパイルエラーになる（`super()`を明示的に呼び出していないため）
E. `class A` `class C`（`B`のコンストラクタは`C`から見えないため飛ばされる）

**解答**

正解：**B**

**補足**

- コンストラクタの中で`super(...)`も`this(...)`も明示的に書かれていない場合、Javaは自動的に**引数無しの`super()`をコンストラクタの先頭に挿入**する。これによりオブジェクトの構築は必ず**継承階層の一番上(`A`)から順に、下(`C`)へ向かって**行われる（D・Eは誤り、明示的な`super()`は必須ではない）。
- `new C()`は、`C()`の先頭で暗黙的に`super()`(`B()`)を呼び、`B()`もさらに暗黙的に`super()`(`A()`)を呼ぶ。その結果`A()`の中身が最初に実行され、次に`B()`、最後に`C()`自身の中身が実行される（A・Cは誤り）。
- `javac`/`java`で検証済み：`class A` / `class B` / `class C`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q7"></a>
## 問題7(sample/chap6/7)

```java
class Item {
    private int id;
    Item(int id) { this.id = id; }
    public void display() { System.out.println("Item id: " + id); }
}
class Clothes extends Item {
    private String brand;
    Clothes(int id, String brand) {
        super(id);
        this.brand = brand;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Clothes brand: " + brand);
    }
}
class Main {
    public static void main(String[] args) {
        new Clothes(100, "Duke's Clothes").display();
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Item id: 100` の後 `Clothes brand: Duke's Clothes`
B. `Item(int id)`しか用意されていないので`Clothes`が継承できずコンパイルエラーになる
C. `super(id);`の行でコンパイルエラーになる（`Item`に引数無しのコンストラクタが無いため）
D. `Clothes brand: Duke's Clothes`のみ出力される
E. 実行時に`id`が未初期化のままアクセスされ例外がスローされる

**解答**

正解：**A**

**補足**

- `Item`が引数付きコンストラクタしか持たない(暗黙のデフォルトコンストラクタが自動生成されない)状態でも、`Clothes`側が`super(id);`のように**明示的に対応するコンストラクタを呼び出せば**問題なく継承・初期化できる（B・Cは誤り。「継承できない」わけではなく、「暗黙の`super()`が使えないので明示する必要がある」だけ）。
- `super(id);`によって`Item`の`id`フィールドは正しく初期化されるので、`display()`内の`id`参照も問題なく機能する（Eは誤り）。
- `javac`/`java`で検証済み：`Item id: 100` / `Clothes brand: Duke's Clothes`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q8"></a>
## 問題8(sample/chap6/8)

```java
public record Item(int id, String name) {}
class Main {
    public static void main(String[] args) {
        Item item1 = new Item(100, "T-shirt");
        Item item2 = new Item(200, "Jeans");
        System.out.println("item1.id(): " + item1.id());
        System.out.println("item1.equals(item2): " + item1.equals(item2));
        System.out.println("item1.toString(): " + item1.toString());
    }
}
```

次のプログラムを実行すると、`item1.toString()`はどのような形式で出力されますか。（1つ選択）

A. `Item@`から始まるハッシュコード付きの文字列(`Object`のデフォルト実装のまま)
B. `Item[id=100, name=T-shirt]`
C. `Item(100, T-shirt)`
D. `id: 100, name: T-shirt`
E. `toString()`が自動生成されないためコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `record`は宣言するだけで、コンポーネント(今回は`id`, `name`)の値を元にした`toString()`, `equals()`, `hashCode()`が**自動的に生成される**（Eは誤り、生成されないどころか呼び出さなくても自動で使える）。
- 自動生成される`toString()`の書式は`レコード名[コンポーネント名=値, コンポーネント名=値, ...]`という決まった形式(`Item[id=100, name=T-shirt]`)であり、`Object`のデフォルト(A)や独自の書式(C・D)にはならない。
- `javac`/`java`で検証済み：`item1.toString(): Item[id=100, name=T-shirt]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q9"></a>
## 問題9(sample/chap6/9)

```java
record Clothes(int id, String brand) {
    Clothes {
        id = id > 0 ? id : 0;
    }
}
class Test {
    public static void main(String[] args) {
        Clothes c = new Clothes(-5, "   Duke   ");
        System.out.println(c);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Clothes[id=0, brand=Duke]`（`brand`も自動的にトリムされる）
B. `Clothes[id=-5, brand=   Duke   ]`
C. `Clothes[id=0, brand=   Duke   ]`
D. コンパイルエラーになる（コンパクトコンストラクタの中でパラメータに再代入することはできない）
E. 実行時に`IllegalArgumentException`がスローされる

**解答**

正解：**C**

**補足**

- `Clothes { ... }`という中括弧だけの形は**コンパクトコンストラクタ**。この中でパラメータ(`id`, `brand`)に再代入すると、**その再代入後の値がそのままフィールドに格納される**という特別な仕組みになっている（Dは誤り、これがコンパクトコンストラクタの主な用途）。
- 今回は`id`だけを`id > 0 ? id : 0`で補正しているが、`brand`には一切手を加えていない。**手を加えなかったコンポーネントは、渡された値がそのまま(トリムなどの加工をされずに)格納される**。よって`brand`は空白付きの`"   Duke   "`のまま（Aは誤り）。
- `id`は`-5`なので`0`に補正される（Bは誤り）。今回は例外を投げるようなコードは書かれていない（Eは誤り）。
- `javac`/`java`で検証済み：`Clothes[id=0, brand=   Duke   ]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q10"></a>
## 問題10(sample/chap6/10)

```java
record Sample(int x, int y) {
    private static double b = 200.0;
    public double calc() { return x + y; }
    public static double getB() { return b; }
    @Override public int x() { return x * 2; }
    @Override
    public String toString() { return "Sample record... x:" + x + ", y:" + y; }
}
public class Main {
    public static void main(String[] args) {
        Sample s = new Sample(10, 20);
        System.out.println("s.calc(): " + s.calc());
        System.out.println("s.x(): " + s.x());
        System.out.println(s);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `s.calc(): 30.0` / `s.x(): 20` / `Sample record... x:10, y:20`
B. `s.calc(): 60.0` / `s.x(): 20` / `Sample record... x:20, y:20`（`x()`のオーバーライドが`calc()`や`toString()`にも反映される）
C. `s.calc(): 30.0` / `s.x(): 10` / `Sample record... x:10, y:20`（アクセサのオーバーライドは無効）
D. `x()`のオーバーライド自体がコンパイルエラーになる
E. `private static double b`のようなインスタンス変数以外のフィールドは`record`に定義できない

**解答**

正解：**A**

**補足**

- `record`のアクセサメソッド(`x()`など)は**自由にオーバーライドできる**（Dは誤り）。ただし`record`内の他のコードが`x`という**フィールド(コンポーネント)を直接参照している箇所**は、あくまで元のフィールドの値(`10`)を見るのであって、オーバーライドしたアクセサメソッド経由の値(`20`)を自動的に見に行くわけではない（Bは誤り、`calc()`や`toString()`の中の`x`はフィールド直接参照）。
- `s.x()`のように**明示的にアクセサメソッドを呼んだ場合だけ**、オーバーライドされた実装(`x * 2 = 20`)が使われる（Cは誤り）。
- `record`には、コンポーネント以外にも`static`フィールドを追加で持てる（ただし`static`ではない追加のインスタンスフィールドは持てない、という制約がある。Eは誤り、`static`変数の追加自体は問題ない）。
- `javac`/`java`で検証済み：`s.calc(): 30.0` / `s.x(): 20` / `Sample record... x:10, y:20`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q11"></a>
## 問題11(sample/chap6/11)

```java
abstract class Sample1 {
    public abstract void methodA();
    public void methodB() {}
}
public class Main {
    public static void main(String[] args) {
        Sample1 s1 = new Sample1();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`s1`は`methodA()`を持たない不完全なオブジェクトとして生成される
B. `new Sample1();`の行でコンパイルエラーになる（抽象クラスはインスタンス化できない）
C. `public abstract void methodA();`の行でコンパイルエラーになる（抽象メソッドには具体的な処理が必要）
D. 実行時に`InstantiationException`がスローされる
E. `methodB()`が具象メソッドなので、そのおかげで`new Sample1()`が可能になる

**解答**

正解：**B**

**補足**

- `abstract`が付いたクラスは、たとえ具象メソッド(`methodB()`)を1つ以上持っていても、**抽象メソッド(`methodA()`)が1つでも残っている限り`new`でインスタンス化できない**（A・Eは誤り）。「一部だけ実装されている」という不完全な状態でオブジェクトを生成させないための制約。
- 抽象メソッドの宣言自体(処理本体が無いこと)は、そのクラスが`abstract`である限り正当（Cは誤り）。
- インスタンス化の可否はコンパイル時に検出されるので、実行時例外にはならない（Dは誤り）。
- `javac`で検証済み：「`Sample1`は`abstract`です。インスタンスを生成することはできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q12"></a>
## 問題12(sample/chap6/12)

```java
abstract class Transport {
    private int speed;
    public Transport(int speed) { this.speed = speed; }
    public int getSpeed() { return speed; }
    public abstract void move();
}
abstract class Car extends Transport {
    public Car(int speed) { super(speed); }
}
public class Main {
    public static void main(String[] args) {
        Car c = new Car(100);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Car`は`Transport`のコンストラクタを正しく呼んでいるため）
B. `new Car(100);`の行でコンパイルエラーになる（`Car`も抽象メソッド`move()`を実装していない抽象クラスのため）
C. `Car`クラスの宣言自体がコンパイルエラーになる（抽象クラスは抽象クラスを継承できない）
D. `public Car(int speed) { super(speed); }`の行でコンパイルエラーになる
E. 実行時に`move()`が呼ばれるまではエラーにならない

**解答**

正解：**B**

**補足**

- 抽象クラスは、親の抽象メソッドを実装せずに**そのまま抽象メソッドとして持ち越す**ことができる（`Car`自身も`abstract`なのでこれは合法。C・Dは誤り、コンストラクタで速度を受け渡すこと自体も普通に行える）。
- しかし持ち越した`move()`が具象クラスでまだ実装されていない以上、**`Car`自身も抽象クラスのまま**であり、`new Car(100)`のようにインスタンス化しようとした時点でコンパイルエラーになる（Eは誤り、実行時まで待たずコンパイル時に検出される）。
- `javac`で検証済み：「`Car`は`abstract`です。インスタンスを生成することはできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q13"></a>
## 問題13(sample/chap6/13)

```java
public interface Test {
    int EXCELLENT = 100;
    private int BELOW_AVERAGE = 60;
    void foo();
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（インタフェースのフィールドは自由にアクセス修飾子を付けられる）
B. `private int BELOW_AVERAGE = 60;`の行でコンパイルエラーになる
C. `int EXCELLENT = 100;`の行でコンパイルエラーになる（アクセス修飾子が明記されていないため）
D. `void foo();`の行でコンパイルエラーになる（インタフェースのメソッドには本体が必須）
E. `BELOW_AVERAGE`が`private`なので、実装クラスから使えないだけでコンパイル自体は通る

**解答**

正解：**B**

**補足**

- インタフェースのフィールド(定数)は、修飾子を省略しても**常に暗黙で`public static final`**として扱われる（Cは誤り、省略自体は正当）。
- しかし**`private`を明示的に付けることはできない**。定数は実装クラス全体から参照されることが前提の仕組みであり、`private`にすると存在意義と矛盾するため許可されていない（A・Eは誤り、そもそもコンパイルが通らない）。
- インタフェースの抽象メソッド(本体無し)は正当な構文（Dは誤り。`default`/`static`/`private`が付いていれば本体が必須になる、という別のルールと混同しないこと）。
- `javac`で検証済み：「修飾子`private`をここで使用することはできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q14"></a>
## 問題14(sample/chap6/14)

```java
interface Eatable {
    void showCalories();
}
class Item {
    String name;
    Item(String name) { this.name = name; }
}
class Food extends Item implements Eatable {
    private int calories;
    public Food(String name, int calories) {
        super(name);
        this.calories = calories;
    }
    @Override
    public void showCalories() {
        System.out.println(name + ": " + calories + "kcal/100g");
    }
}
public class Main {
    public static void main(String[] args) {
        Food f = new Food("Chocolate", 500);
        f.showCalories();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`Chocolate: 500kcal/100g`が出力される
B. クラスの継承(`extends Item`)とインタフェースの実装(`implements Eatable`)を同時に行うことはできない
C. `extends`と`implements`は書く順序を逆(`implements Eatable extends Item`)にしなければならない
D. `Food`の親は`Item`と`Eatable`のどちらか一方に限定されるためコンパイルエラーになる
E. `super(name);`が`Item`と`Eatable`のどちらのコンストラクタか曖昧になりコンパイルエラーになる

**解答**

正解：**A**

**補足**

- 1つのクラスは、**クラスの継承(`extends`、1つまで)とインタフェースの実装(`implements`、複数可)を同時に行える**（B・Dは誤り）。
- 書く順序は`class クラス名 extends 親クラス implements インタフェース1, インタフェース2, ...`という決まった並びであり、逆にはできない（Cは誤り。今回のコードはすでにこの正しい順序）。
- インタフェースはコンストラクタを持たないため、`super(name);`が指すのは常に**クラスの継承元(`Item`)のコンストラクタ**であり曖昧にはならない（Eは誤り）。
- `javac`/`java`で検証済み：`Chocolate: 500kcal/100g`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q15"></a>
## 問題15(sample/chap6/15)

```java
interface Foo { void foo(); }
interface Bar { void bar(); }
interface Baz extends Foo, Bar { void baz(); }
public class Concrete implements Baz {
    @Override public void foo() {}
    @Override public void baz() {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Baz`だけを`implements`しているので、`Baz`自身の`baz()`だけ実装すればよい）
B. `public class Concrete implements Baz {`の行でコンパイルエラーになる（`Bar`の`bar()`が実装されていないため）
C. インタフェースは1つの`extends`しか持てないため、`interface Baz extends Foo, Bar`の行でコンパイルエラーになる
D. `foo()`と`baz()`だけ実装されていれば、`bar()`は自動的に空実装として補われる
E. `Concrete`が`Foo`と`Bar`を明示的に`implements`していないため、`foo()`のオーバーライドは無効になる

**解答**

正解：**B**

**補足**

- **インタフェースは複数のインタフェースを同時に`extends`できる**（クラスの継承と違い、複数可。Cは誤り）。`Baz`は`Foo`と`Bar`の両方を継承しているので、`Baz`が要求する抽象メソッドは`foo()`, `bar()`, `baz()`の**3つ全て**になる。
- `implements Baz`と書くだけで、`Baz`が間接的に継承している`Foo`・`Bar`の抽象メソッドも含めて、**実装クラスは全て実装する義務を負う**（Aは誤り、`baz()`だけでは足りない）。
- 実装漏れがあれば自動的に空実装が補われることは無い（Dは誤り、明確なコンパイルエラーになる）。
- `Concrete`が実際に実装しているメソッドは`Baz`の階層をたどって要求されるシグネチャと一致していれば有効なオーバーライドとして機能する（Eは誤り、`implements`に`Baz`とだけ書いてあっても`foo()`は正しく`Foo`のオーバーライドとして認識される）。
- `javac`で検証済み：「`Concrete`は`abstract`でなく、`Bar`内の`abstract`メソッド`bar()`をオーバーライドしません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q16"></a>
## 問題16(sample/chap6/16)

```java
interface Foo {
    default void x() { System.out.println("Foo#x()"); }
    default void y() { System.out.println("Foo#y()"); }
}
class Test implements Foo {
    public static void main(String[] args) {
        Test t = new Test();
        t.x();
        t.y();
    }
}
```

`Test`クラスは`x()`も`y()`もオーバーライドしていません。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Foo#x()` の後 `Foo#y()`
B. `Foo`の`default`メソッドをオーバーライドせずに使うことはできず、コンパイルエラーになる
C. `t.x()`, `t.y()`とも実行時に`AbstractMethodError`がスローされる
D. `default`メソッドは`static`にしかアクセスできないため`t.x()`のような呼び出し自体がコンパイルエラーになる
E. 何も出力されない（`default`メソッドは明示的に呼び出されるまで存在しないものとして扱われる）

**解答**

正解：**A**

**補足**

- `default`メソッドは、インタフェースの中に**すでに実装(本体)が書かれている**メソッド。実装クラス側でオーバーライドするかどうかは**任意**であり、オーバーライドしなければそのままインタフェースの実装が使われるだけで、コンパイルエラーにはならない（B・Cは誤り、`default`があること自体が「実装済み」を意味する）。
- `default`メソッドは通常のインスタンスメソッドと同様、`t.x()`のように参照変数経由で普通に呼び出せる（D・Eは誤り）。
- `javac`/`java`で検証済み：`Foo#x()` / `Foo#y()`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q17"></a>
## 問題17(sample/chap6/17)

```java
interface Foo {
    static void statMethod() { System.out.println("Foo#statMethod()"); }
}
interface Bar extends Foo {
    default void x() { System.out.print("call from Bar#x()... "); }
}
class Concrete implements Bar {}
public class Main {
    public static void main(String[] args) {
        Concrete c = new Concrete();
        c.statMethod();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Concrete`は`Bar`経由で`Foo`を継承しているため）
B. `c.statMethod();`の行でコンパイルエラーになる（インタフェースの`static`メソッドは参照変数経由で呼び出せない）
C. `interface Bar extends Foo`の行でコンパイルエラーになる（`static`メソッドを持つインタフェースは継承できない）
D. `c.statMethod();`は`Bar.statMethod()`の呼び出しとして扱われ、問題なくコンパイルが通る
E. 実行時に`NoSuchMethodError`がスローされる

**解答**

正解：**B**

**補足**

- インタフェースの`static`メソッドは、**クラスの`static`メソッドと同様に継承されない**。サブインタフェース(`Bar`)経由(`Bar.statMethod()`)でも、実装クラスの**インスタンス経由**(`c.statMethod()`)でも呼び出すことはできない（D・Aは誤り）。呼び出せるのは、それを宣言した**インタフェース名を直接指定した場合**(`Foo.statMethod()`)だけ。
- `static`メソッドを持つインタフェース自体を継承すること自体には何の制約も無い（Cは誤り）。
- コンパイル時に解決できない呼び出し方法なので、コンパイルエラーとして検出される（Eは誤り、実行時まで到達しない）。
- `javac`で検証済み：「シンボルを見つけられません（シンボル: メソッド`statMethod()`、場所: タイプ`Concrete`の変数`c`）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q18"></a>
## 問題18(sample/chap6/18)

```java
interface Foo {
    default void a() {
        common();
        System.out.println("default a()");
    }
    static void y() {
        statCommon();
        System.out.println("static y()");
    }
    private void common() {
        System.out.print("common(): ");
    }
    private static void statCommon() {
        System.out.print("statCommon(): ");
    }
}
public class Test implements Foo {
    public static void main(String[] args) {
        Test t = new Test();
        t.a();
        Foo.y();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `private`なメソッドはインタフェース自体に定義できないためコンパイルエラーになる
B. 問題なくコンパイルが通り`common(): default a()`の後`statCommon(): static y()`が出力される
C. `common()`・`statCommon()`は`private`なので、同じインタフェース内の`default`/`static`メソッドからも呼び出せずコンパイルエラーになる
D. `private static void statCommon()`は矛盾した組み合わせ(`private`かつ`static`)なのでコンパイルエラーになる
E. `private`メソッドは実装クラス(`Test`)から直接オーバーライドしなければ使えない

**解答**

正解：**B**

**補足**

- Java 9以降、インタフェースには`default`/`static`メソッドの補助的な内部処理をまとめるための**`private`メソッド**（インスタンス用）・**`private static`メソッド**（`static`用）を定義できる（A・Dは誤り）。
- これらの`private`メソッドは、**同じインタフェース内の`default`メソッドや`static`メソッドから普通に呼び出せる**（`common()`は`default`メソッドの`a()`から、`statCommon()`は`static`メソッドの`y()`から）。実装クラス側でオーバーライドする必要も無い（C・Eは誤り、`private`なので実装クラスからオーバーライドすること自体そもそもできない）。
- `javac`/`java`で検証済み：`common(): default a()` / `statCommon(): static y()`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q19"></a>
## 問題19(sample/chap6/19)

```java
// com/a/Shape.java
package com.a;
public abstract sealed class Shape permits Circle, Triangle, Square {
    public abstract double calcArea();
}
// (Circle, Triangle, Squareの定義は省略)

// com/b/Heart.java
package com.b;
import com.a.Shape;
public final class Heart extends Shape {}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Heart`は`final`クラスなのでシールドクラスの継承として問題ない）
B. `Heart`の宣言でコンパイルエラーになる（`Shape`の`permits`句に`Heart`が含まれていないため）
C. `import com.a.Shape;`の行でコンパイルエラーになる（シールドクラスは別パッケージから`import`できない）
D. `Shape`の宣言自体がコンパイルエラーになる（抽象クラスは`sealed`にできない）
E. 実行時に`Heart`のインスタンス化を試みた瞬間にエラーになる

**解答**

正解：**B**

**補足**

- `sealed`クラスは、`permits`句に**明示的に列挙されたクラスだけ**が継承を許される。`Heart`が`final`であるかどうかは無関係で、そもそも`permits`のリスト(`Circle, Triangle, Square`)に`Heart`という名前が含まれていない時点で継承資格が無い（Aは誤り）。
- `sealed`クラス自体を他パッケージから`import`して使うこと(継承ではなく参照として使うこと)には制約は無い（Cは誤り）。`abstract`と`sealed`は矛盾せず併用できる（Dは誤り、`abstract sealed class`という組み合わせ自体は正当）。
- 継承の可否はコンパイル時に検証されるので、実行時まで問題が持ち越されることはない（Eは誤り）。
- `javac`で検証済み：`Heart`の宣言行で「クラスはシール・クラス`Shape`を拡張できません（'permits'句に指定されていないためです）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q20"></a>
## 問題20(sample/chap6/20)

```java
public sealed class Shape permits Circle, Triangle {}
final class Circle extends Shape {}
non-sealed class Triangle extends Shape {}
class Star extends Triangle {}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `class Star extends Triangle {}`の行でコンパイルエラーになる（`Shape`の`permits`句に`Star`が含まれていないため）
C. `non-sealed class Triangle`の行でコンパイルエラーになる（`sealed`クラスのサブクラスは`non-sealed`にできない）
D. `Star`が`sealed`でも`final`でも`non-sealed`でもないためコンパイルエラーになる
E. `Shape`と直接の継承関係を持つ`Circle`, `Triangle`以外はすべてコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `sealed`クラスの`permits`句が制限するのは、あくまで**そのクラスを直接継承できる相手**まで。`Triangle`は`non-sealed`に指定されているため、**そこから先の継承階層は普通のクラスと同じく無制限に開放される**（B・E は誤り）。
- `sealed`クラスのサブクラスは、`final`(それ以上継承させない)・`sealed`(限定した継承を許す)・`non-sealed`(制限を解除する)のいずれかを選ばなければならないというルールがあるが、`Triangle`はきちんと`non-sealed`を選んでいるので問題ない（Cは誤り）。
- `Star`のように`non-sealed`なクラスをさらに継承する場合、`Star`自身は`final`/`sealed`/`non-sealed`のいずれかを名乗る必要は無い（`Triangle`自体が`sealed`ではなく、その制約の対象外だから。Dは誤り）。
- `javac`で検証済み：エラー無くコンパイルが通る。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q21"></a>
## 問題21(sample/chap6/21)

```java
sealed interface Item permits Food {
    double TAX_RATE = 0.1;
    int calcPrice();
}
record Food(String name, int price) implements Item {
    @Override
    public int calcPrice() {
        return (int)(price * (1 + TAX_RATE));
    }
}
public class Main {
    public static void main(String[] args) {
        Food food = new Food("Chocolate", 750);
        System.out.println(food.name() + ": " + food.calcPrice() + "yen");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Chocolate: 825yen`
B. `Chocolate: 750yen`
C. `record`は`sealed`インタフェースを`implements`できないためコンパイルエラーになる
D. `Item`が`interface`なので`permits`句を書くこと自体がコンパイルエラーになる
E. コンパイルエラーになる（`record`は`abstract`メソッドを実装する際、明示的に`final`を付けなければならない）

**解答**

正解：**A**

**補足**

- `record`は`sealed`インタフェースの許可対象(`permits`)として問題なく指定でき、`implements`することもできる（Cは誤り）。`record`は暗黙的に`final`扱いなので、明示的な`final`修飾も不要（Eは誤り）。
- `interface`も`class`と同様に`sealed`＋`permits`を宣言できる（Dは誤り）。
- `calcPrice()`は`(int)(750 * 1.1)`＝`(int)825.0`＝`825`。
- `javac`/`java`で検証済み：`Chocolate: 825yen`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q22"></a>
## 問題22(sample/chap6/22)

```java
class Super {}
class Sub extends Super {}
interface Foo {}
class FooImpl implements Foo {}
public class Main {
    static Sub methodA() { return new Sub(); }
    static void methodB(Super s) {}
    static Foo methodC() { return new FooImpl(); }
    public static void main(String[] args) {
        Super s1 = new Sub();
        Super s2 = methodA();
        methodB(new Sub());
        Foo f1 = new FooImpl();
        Foo f2 = methodC();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `Super s2 = methodA();`の行でコンパイルエラーになる（戻り値の型`Sub`と代入先の型`Super`が完全に一致していないため）
C. `methodB(new Sub());`の行でコンパイルエラーになる（引数の型`Sub`とパラメータの型`Super`が一致していないため）
D. インタフェース型の変数(`Foo f1`, `Foo f2`)には実装クラスのインスタンスを代入できないためコンパイルエラーになる
E. `Sub`を`Super`型の変数で受け取るには明示的なキャスト`(Super)`が必要になる

**解答**

正解：**A**

**補足**

- サブクラス(`Sub`)のインスタンスやサブクラスを返すメソッドの戻り値は、スーパークラス(`Super`)型の変数に**暗黙的に(キャスト無しで)代入できる(アップキャスト)**。戻り値の型と代入先の型が完全に一致している必要は無く、代入先が戻り値の型のスーパークラスであれば十分（B・Eは誤り）。
- メソッドの引数についても同様で、`Super`型を要求するパラメータに`Sub`のインスタンスを渡すことができる（Cは誤り）。
- クラスがインタフェースを実装している場合も全く同じ考え方で、インタフェース型の変数に実装クラスのインスタンスを代入できる（Dは誤り）。
- `javac`で検証済み：エラー無くコンパイルが通る。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q23"></a>
## 問題23(sample/chap6/23)

```java
// com.a.Shape(abstract sealed), com.a.Square(sealed extends Shape), com.a.Cube(final extends Square) がある前提
import com.a.*;
public class Main {
    public static void main(String[] args) {
        Shape obj = new Cube();
        System.out.println("Cube : " + obj.calcArea());
        System.out.println("Shape: " + obj.toString());
    }
}
```

`Shape`は`toString()`で`getClass().getName() + ": " + calcArea() + " sq cm"`を返すよう定義されているとします。次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Cube : 150.0` の後 `Shape: com.a.Shape: 150.0 sq cm`（`toString()`は`Shape`自身の`calcArea()`を使う）
B. `Cube : 150.0` の後 `Shape: com.a.Cube: 150.0 sq cm`
C. `Cube : 150.0` の後 `Shape: com.a.Cube: 0.0 sq cm`
D. `getClass()`は`Shape`のインスタンスであるという静的な情報しか返さないため`com.a.Shape`になる
E. `obj.toString();`の行でコンパイルエラーになる（`Shape`型の変数に対して`Cube`固有の情報を取得しようとしているため）

**解答**

正解：**B**

**補足**

- `obj`の静的型は`Shape`だが、`getClass()`は**実行時の実際のクラス**を返すメソッドであり、静的型には左右されない。よって`getClass().getName()`は`"com.a.Cube"`になる（D は誤り）。
- `toString()`は`Shape`で定義されているが、その中で呼んでいる`calcArea()`は**抽象メソッドのオーバーライド**を通じて、実際のオブジェクト(`Cube`)の実装(`150.0`)が呼ばれる(動的束縛)。`Shape`自身が`calcArea()`の具体的な計算式を持っているわけではないので、Aのような結果にはならない。
- `toString()`が実行される中でも`calcArea()`は正しく`150.0`を返す(Cのように`0.0`になることは無い)。
- `Shape`型の変数から`toString()`を呼ぶこと自体は`Object`由来の普通のメソッド呼び出しであり、何の制約も無い（Eは誤り）。
- `javac`/`java`で検証済み：`Cube : 150.0` / `Shape: com.a.Cube: 150.0 sq cm`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q24"></a>
## 問題24(sample/chap6/24)

```java
import com.a.Cube;
import com.a.Shape;
import com.a.Square;
public class Main {
    public static void main(String[] args) {
        Shape obj2 = new Square();
        Square s2 = (Square) obj2;
        Cube c2 = (Cube) obj2;
    }
}
```

（`Cube`は`Square`のサブクラス）このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、実行時にも例外は起きない
B. `Cube c2 = (Cube) obj2;`の行でコンパイルエラーになる（`Cube`と`Square`は無関係な型のため）
C. 問題なくコンパイルが通るが、`Cube c2 = (Cube) obj2;`の行で実行時に`ClassCastException`がスローされる
D. `Square s2 = (Square) obj2;`の行ですでにコンパイルエラーになる（アップキャストにキャストは不要で書くこと自体が禁止されている）
E. 実行時に自動的に`Square`が`Cube`に変換される

**解答**

正解：**C**

**補足**

- `Cube`は`Square`の**サブクラス**なので、`(Cube) obj2`という**ダウンキャストの構文自体は、コンパイラの目からは「理論上あり得る変換」として許可される**（Bは誤り、無関係な型ではない）。
- しかし、実際に`obj2`が参照しているオブジェクトの**実体は`Square`**であり、`Cube`ではない。実行時にJVMが実体の型をチェックし、要求された型(`Cube`)と一致しないことを検出して`ClassCastException`をスローする（A・Eは誤り）。
- `Square s2 = (Square) obj2;`のように、静的型と実際にキャストする型が完全に一致する場合、キャスト自体は冗長だが書くこと自体は禁止されていない（Dは誤り）。
- `javac`/`java`で検証済み：コンパイルは成功し、実行時に`Exception in thread "main" java.lang.ClassCastException: class com.a.Square cannot be cast to class com.a.Cube`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q25"></a>
## 問題25(sample/chap6/25)

```java
class Shape {}
class Square extends Shape {}
class Heart {}
public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Square square = (Square) shape;
        Heart heart = (Heart) shape;
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、実行時にすべて例外なく完了する
B. `Square square = (Square) shape;`の行だけがコンパイルエラーになる
C. `Heart heart = (Heart) shape;`の行だけがコンパイルエラーになる（`Shape`と`Heart`は継承関係が無く、絶対に変換できないとコンパイラが判断できるため）
D. どちらの行も、実行時になるまでキャストの成否は判断できないため、コンパイルエラーにはならない
E. `Square`, `Heart`のどちらも実行時に`ClassCastException`がスローされる

**解答**

正解：**C**

**補足**

- `Square`は`Shape`の**サブクラス**なので、`(Square) shape`は「理論上あり得る変換」としてコンパイラは許可する（実際には`shape`の実体が`Shape`そのものなので実行時に`ClassCastException`にはなるが、それは今回の設問の対象外）。
- 一方`Heart`は`Shape`と**継承関係が全く無い、別系統のクラス**。片方がクラス(インタフェースではない)である場合、コンパイラは継承階層を静的に解析でき、「`Shape`のインスタンスが同時に`Heart`でもある可能性は理論上あり得ない」と**コンパイル時に断定できる**ため、実行を待たずに明確なコンパイルエラーとして弾く（D は誤り。もし`Heart`がインタフェースだったら、多重実装の可能性がある関係上、この場では弾かれずコンパイルは通っていた）。
- `javac`で検証済み：`Heart heart = (Heart) shape;`の行で「不適合な型: `Shape`を`Heart`に変換できません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q26"></a>
## 問題26(sample/chap6/26)

```java
// com.a.Shape, com.a.Square, com.a.Cube (SquareのサブクラスがCube) がある前提
import com.a.*;
public class Main {
    public static void main(String[] args) {
        Shape obj = new Square();
        testSmart(obj);
    }
    static void testSmart(Object obj) {
        if (obj instanceof Cube c) {
            System.out.println(c.calcVolume());
        } else if (obj instanceof Square s) {
            System.out.println(s.calcArea() + " sq cm");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `25.0 sq cm`
B. `obj`の実体が`Square`(`Cube`のスーパークラス)なので`instanceof Cube`が`true`になり、`c.calcVolume()`が出力される
C. `instanceof Cube c`が`false`と評価された時点で`c`という変数が未定義のままになりコンパイルエラーになる
D. 何も出力されない
E. `Square`は`Cube`のスーパークラスなので、`instanceof Square s`のブロックには到達しない

**解答**

正解：**A**

**補足**

- `obj`の実体は`Square`そのもの(`Cube`ではない)なので、`obj instanceof Cube c`は`false`。`instanceof`は「実際にその型(またはサブタイプ)のインスタンスかどうか」を見るのであって、継承関係の向きを勘違いしないよう注意（Bは誤り。`Square`が`Cube`のスーパークラスだからといって、`Square`の実体が`Cube`扱いされることはない）。
- `false`と評価された場合、パターン変数`c`は**その`if`ブロックのスコープ内で単に使えないだけ**で、コンパイルエラーの原因にはならない（Cは誤り。`c`が使われるのは`true`だった場合の分岐の中だけ）。
- `else if (obj instanceof Square s)`は、`obj`が実際に`Square`のインスタンスなので`true`になり、この分岐が実行される（D・Eは誤り）。
- `javac`/`java`で検証済み：`25.0 sq cm`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q27"></a>
## 問題27(sample/chap6/27)

```java
// com.a.Circle, Triangle, Square, Cube はいずれも Shape のサブクラスで、それぞれ独自の calcArea() を持つ
import com.a.*;
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Triangle(), new Square(), new Cube() };
        for (Shape s : shapes) {
            System.out.println(s.calcArea() + " sq cm");
        }
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. 4つとも同じ`Shape`の`calcArea()`が呼ばれ、同じ値が4回出力される
B. `Circle`, `Triangle`, `Square`, `Cube`それぞれ独自の`calcArea()`が呼ばれ、それぞれ異なる値が出力される
C. 配列の要素が異なるサブクラス同士なので、`Shape[] shapes = {...}`の行でコンパイルエラーになる
D. `s.calcArea()`は`s`の静的型(`Shape`)を基準に解決されるため、`Shape`が抽象メソッドしか持たない場合は実行時エラーになる
E. 実行順序は配列の宣言順とは無関係にJVMが最適な順序で決定する

**解答**

正解：**B**

**補足**

- `Shape[]`という配列には、`Shape`のサブクラスであるオブジェクトを混在させて格納できる（配列は共変なので、異なるサブクラス同士でも問題ない。Cは誤り）。
- `s.calcArea()`は通常のインスタンスメソッド呼び出しなので**動的束縛**の対象。`for`ループの各周で`s`が実際に参照しているオブジェクト(`Circle`→`Triangle`→`Square`→`Cube`)ごとに、それぞれがオーバーライドした`calcArea()`が呼ばれる（A・Dは誤り。抽象メソッドであっても、実際のオブジェクトは必ず具象クラスの実装を持っているので実行時エラーにはならない）。
- 拡張forは配列の要素を宣言順(先頭から末尾)にたどる、という決まった順序で実行される（Eは誤り）。
- `javac`/`java`で検証済み：`78.53981633974483 sq cm` / `7.5 sq cm` / `25.0 sq cm` / `150.0 sq cm`（それぞれ異なる計算式の結果）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q28"></a>
## 問題28(sample/chap6/28)

```java
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Kiwi");
        fruits.add("Lemon");
        fruits.add(null);
        fruits.add(0, "Lemon");
        String val1 = fruits.remove(0);
        boolean val2 = fruits.remove("Lemon");
        String val3 = fruits.set(0, "Mango");
        System.out.println(val1 + ", " + val2 + ", " + val3);
        System.out.println(fruits);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Lemon, true, Kiwi` の後 `[Mango, null]`
B. `Kiwi, true, Lemon` の後 `[Mango, null]`
C. `Lemon, false, Kiwi` の後 `[Kiwi, null]`
D. `Lemon, true, Kiwi` の後 `[Mango, Lemon, null]`
E. `fruits.remove("Lemon")`が`String`を返さず`boolean`を返すため、`val2`の代入行でコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `add(0, "Lemon")`によって、リストの中身は先頭から`[Lemon, Kiwi, Lemon, null]`になる。
- `remove(0)`（`int`引数＝**添字指定**の削除）は先頭(`"Lemon"`)を削除して返す。この時点で`val1 = "Lemon"`、リストは`[Kiwi, Lemon, null]`。
- `remove("Lemon")`（`Object`引数＝**値指定**の削除）は、残っている最初の一致(`"Lemon"`)を削除し、削除に成功したかどうかの`boolean`(`true`)を返す。この時点で`val2 = true`、リストは`[Kiwi, null]`。
- `set(0, "Mango")`は添字0(`"Kiwi"`)を`"Mango"`に置き換え、**置き換える前の古い値**を返す。`val3 = "Kiwi"`、リストは`[Mango, null]`。
- `remove(int)`と`remove(Object)`はオーバーロードとして共存しており、それぞれ独立して正しく型付けされているのでコンパイルエラーにはならない（Eは誤り）。
- `javac`/`java`で検証済み：`Lemon, true, Kiwi` / `[Mango, null]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q29"></a>
## 問題29(sample/chap6/29)

```java
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = Integer.valueOf(20);
        HashSet<Integer> values = new HashSet<>();
        values.add(i1);
        values.add(i2);
        System.out.println(values.add(20));
        System.out.println(values.add(30));
        System.out.println(values.size());
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `true` `true` `4`（`values.add(20)`は`i2`とは別の新しいオブジェクトなので追加される）
B. `false` `true` `3`
C. `true` `false` `3`
D. `false` `false` `2`
E. `values.add(20)`は`int`を渡しているため`Integer`用の`HashSet`にはコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `int`型の`20`を`Integer`用の`HashSet`に`add()`すると、自動的にオートボクシングされて`Integer`のインスタンスとして扱われる（Eは誤り）。
- `HashSet`は要素の重複判定に`equals()`/`hashCode()`を使う。`Integer`はこれらを**値の中身で比較する**ようきちんとオーバーライドしているため、「別のオブジェクトかどうか」ではなく「同じ数値かどうか」で重複が判定される（Aは誤り）。`i2`(値`20`)と`values.add(20)`(オートボクシングされた値`20`)は、オブジェクトとしては別でも値としては同じなので、`add(20)`は「すでに存在するので追加されなかった」ことを意味する`false`を返す。
- `values.add(30)`は新しい値なので`true`。最終的な要素は`{10, 20, 30}`の3個。
- `javac`/`java`で検証済み：`false` / `true` / `3`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q30"></a>
## 問題30(sample/chap6/30)

```java
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> depts = new HashMap<>();
        depts.put(10, "HR");
        depts.put(20, "Tech");
        depts.put(30, "Learning");
        String old = depts.put(20, "Engineering");
        String removed = depts.remove(10);
        System.out.println(old + ", " + removed);
        System.out.println(depts.get(20) + ", " + depts.get(10));
        System.out.println(depts.size());
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Tech, HR` の後 `Engineering, null` の後 `2`
B. `null, HR` の後 `Engineering, null` の後 `2`
C. `Tech, HR` の後 `Engineering, HR` の後 `3`（`remove`しても値そのものは残る）
D. `Tech, true` の後 `Engineering, null` の後 `2`
E. `depts.put(20, "Engineering");`の行でコンパイルエラーになる（同じキーに2回`put`することはできない）

**解答**

正解：**A**

**補足**

- `put(key, value)`は、そのキーが**すでに存在していれば値を上書きし、上書きされる前の古い値を返す**。既存のキー`20`(`"Tech"`)に`put(20, "Engineering")`すると、戻り値は`"Tech"`（同じキーへの複数回の`put`は普通に許可されている操作。Eは誤り）。
- `remove(key)`は、削除した**値そのもの**を返す（Dのように`boolean`を返すのは`Collection`系の`remove(Object)`の場合の話で、`Map`の`remove(key)`は削除された値を返す）。`remove(10)`は`"HR"`を返し、キー`10`はマップから完全に消える。
- 削除後は`get(10)`は`null`になる（Cは誤り、`remove`後はキーごと消えるので値も参照できなくなる）。
- 最終的なサイズは`{20:"Engineering", 30:"Learning"}`の2個。
- `javac`/`java`で検証済み：`Tech, HR` / `Engineering, null` / `2`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q31"></a>
## 問題31(sample/chap6/31)

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List unsafeList = new ArrayList();
        unsafeList.add("Non-Generics");
        unsafeList.add(1.4);
        for (int i = 0; i < unsafeList.size(); i++) {
            System.out.println((String) unsafeList.get(i));
        }
    }
}
```

次のプログラムを実行すると、何が起きますか。（1つ選択）

A. `Non-Generics`の後`1.4`が出力され、正常終了する
B. `List unsafeList = new ArrayList();`の行でコンパイルエラーになる（型引数の無い`List`は使えない）
C. `unsafeList.add(1.4);`の行でコンパイルエラーになる（型引数が無くても要素の型は統一しなければならない）
D. `Non-Generics`が出力された後、2つ目の要素にアクセスする行で実行時に`ClassCastException`がスローされる
E. コンパイル時に「型が安全でない」という警告付きでコンパイルは成功するが、実行時には何の問題も起きない

**解答**

正解：**D**

**補足**

- 型引数を省略した`List`(raw type、生の型)は、後方互換性のために今でも使用可能。ただし**コンパイラによる型チェックが一切働かなくなる**ため、異なる型の要素(`String`と`Double`)を混在させることも文法上できてしまう（B・Cは誤り。ただし「未チェックまたは安全ではない操作」という警告は出る）。
- `unsafeList.get(0)`(`"Non-Generics"`、実際は`String`)を`(String)`にキャストするのは問題なく成功する。
- しかし`unsafeList.get(1)`は実際には`Double`型の`1.4`(オートボクシングされた`Double`インスタンス)であり、これを`(String)`にキャストしようとすると実行時に失敗する（A・Eは誤り、警告が出るだけで実行時に安全というわけではない）。
- `javac`/`java`で検証済み：`Non-Generics`が出力された後`Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.String`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q32"></a>
## 問題32(sample/chap6/32)

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] numArray = {1, 5, 3};
        Arrays.sort(numArray);
        int[] small = {1, 3};
        int[] same = {1, 3, 5};
        int[] large = {5, 3, 1};
        System.out.println(Arrays.compare(numArray, small));
        System.out.println(Arrays.compare(numArray, same));
        System.out.println(Arrays.compare(numArray, large));
    }
}
```

（`numArray`はソート後`[1, 3, 5]`になっているとします）`Arrays.compare()`の結果について、正しい組み合わせはどれですか。（1つ選択）

A. `1` `0` `-1`
B. `0` `0` `0`（要素数が違っても中身が似ていれば同じとみなされる）
C. `-1` `0` `1`
D. `true` `true` `false`（`compare`は`boolean`を返す）
E. `numArray`と`small`は要素数が違うため、`compare`の呼び出し自体がコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `Arrays.compare(a, b)`は、辞書式順序で`a`と`b`を比較し、`a`が大きければ正、等しければ`0`、`a`が小さければ負の`int`を返す（Dは誤り、`boolean`ではない）。
- `numArray`(`[1,3,5]`) vs `small`(`[1,3]`)：先頭2要素は一致するが、`numArray`の方が要素数が多い(＝残りの要素がある分だけ「大きい」とみなされる)ので正の値(`1`)。要素数が異なっていても比較自体は可能（Eは誤り、Bのように「同じとみなされる」わけでもない）。
- `numArray` vs `same`(`[1,3,5]`)：完全に同じ内容なので`0`。
- `numArray` vs `large`(`[5,3,1]`)：先頭要素`1`と`5`を比較した時点で`numArray`の方が小さいので負の値(`-1`)。
- `javac`/`java`で検証済み：`1` / `0` / `-1`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="q33"></a>
## 問題33(sample/chap6/33・複数選択)

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] str = {"O", "P", "Q"};
        List<String> list1 = Arrays.asList(str);
        str[1] = "Piano";
        list1.set(0, "Organ");
        List<Double> list3 = List.of(1.0, 2.0, 3.0);
    }
}
```

このプログラムの各操作について、正しい記述をすべて選んでください。（複数選択）

A. `str[1] = "Piano";`の後、`list1`の中身にも`"Piano"`が反映される(`Arrays.asList()`は元の配列と連動するビューだから)
B. `list1.set(0, "Organ");`は問題なく実行でき、元の配列`str`の中身にも反映される
C. `list1.add("Violin");`のような要素追加を試みると、実行時に`UnsupportedOperationException`がスローされる（サイズ固定のため）
D. `list3.set(0, 0.0);`は問題なく実行できる
E. `List.of(...)`で生成したリストに対して`set()`を試みると、実行時に`UnsupportedOperationException`がスローされる

**解答**

正解：**A、B、C、E**（Dのみ誤り）

**補足**

- `Arrays.asList(str)`は、**新しい独立したリストを複製するのではなく、渡した配列`str`そのものをバックエンドとする「ビュー」**を返す。そのため配列側を書き換えれば`list1`にも反映され(A正しい)、`list1.set(...)`で書き換えれば元の配列にも反映される(B正しい)、という**双方向に連動する**関係になる。
- `Arrays.asList()`が返すリストは**サイズ固定**(要素の変更(`set`)はできるが、追加・削除はできない)。`add()`のような構造を変える操作を試みると`UnsupportedOperationException`がスローされる(C正しい)。
- `List.of(...)`が返すリストは`Arrays.asList()`よりさらに厳しい**完全な不変(immutable)リスト**。`set()`のような値の変更すら許されず、`UnsupportedOperationException`がスローされる(Dは誤り、Eが正しい)。
- `javac`/`java`で検証済み：`list1`は`str`の変更後`[O, Piano, Q]`に、`str`は`list1.set`後`[Organ, Piano, Q]`になる。`list1.add(...)`と`list3.set(0, 0.0)`はどちらも実行時に`UnsupportedOperationException`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex2"></a>
## 問題ex2(sample/chap6/ex2)

```java
class Top {
    int x = 1;
    int y = 2;
}
class Middle extends Top {
    double x = 3.5;
    public void update() { super.x = 40; }
}
class Bottom extends Middle {
    public void update() { super.update(); y = 50; }
}
class Main {
    public static void main(String[] args) {
        Middle obj = new Bottom();
        obj.update();
        System.out.println(obj.x + ":" + obj.y);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `40.0:50`（`super.x = 40`が`Middle`の`x`にも反映される）
B. `3.5:50`
C. `3.5:2`（`Bottom`の`y = 50`は`Top`のフィールドを変更できない）
D. `40.0:2`
E. `x`という同名フィールドが2つの型(`int`と`double`)で存在すること自体がコンパイルエラーになる

**解答**

正解：**B**

**補足**

- `Top`の`int x`と`Middle`の`double x`は、型が違っても**別々の独立したフィールドとして共存する(シャドーイング)**（Eは誤り）。`Middle`の`update()`内の`super.x = 40;`は、**`Top`側の`x`だけ**を`40`に書き換えるのであって、`Middle`自身の`x`(`3.5`)には一切影響しない（Aは誤り）。
- `obj`の宣言型は`Middle`なので、`obj.x`は`Middle`自身が持つ`double x`(`3.5`のまま)を指す。
- `y`は`Middle`にも`Bottom`にも独自の定義が無いため、`Top`から継承した唯一の`y`フィールドを指す。`Bottom`の`update()`内の`y = 50;`はこの`Top`由来の`y`を書き換えるので、`obj.y`は`50`になる（Cは誤り、書き換わる）。
- `javac`/`java`で検証済み：`3.5:50`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex3"></a>
## 問題ex3(sample/chap6/ex3)

```java
public class Super {
    protected String text = "something";
}
public class A extends Super {}
public class B extends A {}
public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.text);
    }
}
```

（`Super`, `A`, `B`, `Main`はすべて同じパッケージ内の別ファイルとします）次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `something`
B. `A`は`text`を継承していないためコンパイルエラーになる
C. `protected`なフィールドは、たとえ同じパッケージでも別ファイルからは参照できない
D. `null`
E. `Super`と`Main`が同じパッケージであることを明示する`import`文が無いためコンパイルエラーになる

**解答**

正解：**A**

**補足**

- `protected`は「同じパッケージ内」または「別パッケージであってもサブクラスから」アクセスできるアクセス修飾子。今回は全て**同じパッケージ**なので、継承関係の深さ(`Super`→`A`→`B`)に関わらず素直にアクセスできる（B・Cは誤り）。
- 同じパッケージに属するクラス同士は、`import`文を書かなくても互いに参照できる（Eは誤り。`import`が必要なのは異なるパッケージのクラスを使うときだけ）。
- `text`は`Super`のコンストラクタ相当の初期化子で`"something"`にすでに初期化されているので`null`にはならない（Dは誤り）。
- `javac`/`java`で検証済み：`something`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex4"></a>
## 問題ex4(sample/chap6/ex4)

```java
// ex6/foo/One.java
package ex6.foo;
public class One {
    public int a = 1;
    int b = 2;
    protected int c = 3;
}
// ex6/bar/Two.java
package ex6.bar;
import ex6.foo.One;
public class Two extends One {
    private int a = 2;
    int calc() { return a + b + c; }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`Two`は`One`を継承しているので全フィールドにアクセスできる）
B. `calc()`内の`b`の参照でコンパイルエラーになる（`b`はデフォルトアクセスで別パッケージからは継承していても見えないため）
C. `calc()`内の`a`の参照でコンパイルエラーになる（`Two`独自の`private int a`と`One`の`public int a`が同名で衝突するため）
D. `calc()`内の`c`の参照でコンパイルエラーになる（`protected`は継承先でも別パッケージからは一切使えないため）
E. `class Two extends One`の行でコンパイルエラーになる（別パッケージのクラスは継承できない）

**解答**

正解：**B**

**補足**

- パッケージをまたいだ継承自体は普通に行える。`public`なクラスであれば別パッケージからの継承(`extends`)も可能（Eは誤り）。
- `a`(`public`)は無条件にどこからでも見える。`Two`が独自に`private int a`を宣言していても、これは`One`の`a`を**シャドーイング**しているだけで、コンパイルエラーにはならない（Cは誤り。`calc()`内の`a`は`Two`自身の`private int a`を指す）。
- `c`(`protected`)は、**別パッケージであってもサブクラス自身からは(継承したメンバとして)アクセスできる**（Dは誤り）。
- `b`(デフォルトアクセス、修飾子無し)だけは「**同じパッケージの中からしか**アクセスできない」という制約があり、たとえ継承関係にあっても別パッケージの`Two`からは見えない。
- `javac`で検証済み：`calc()`内の`b`の参照で「`One`の`b`は`public`ではありません。パッケージ外からはアクセスできません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex5"></a>
## 問題ex5(sample/chap6/ex5)

```java
class Super {
    public int func() { return 0; }
}
class Sub extends Super {
    @Override
    public long func() { return 1L; }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る（`long`は`int`を包含するより広い型なので共変戻り値として認められる）
B. `Sub`の`func()`の行でコンパイルエラーになる（基本データ型の戻り値はオーバーライドで変更できない）
C. `public long func() { return 1L; }`は新しいオーバーロードとして追加され、`Super`の`func()`はそのまま残る
D. 戻り値の型を変える場合は`@Override`を外せば問題なくコンパイルできる
E. 実行時にどちらの`func()`が呼ばれるか、呼び出し方によって変わる

**解答**

正解：**B**

**補足**

- 共変戻り値(戻り値の型を、より狭い**サブクラス型**に変更できる仕組み)が使えるのは**参照型**の戻り値だけ。**基本データ型(`int`, `long`など)の戻り値は、オーバーライドにおいて`long`が`int`を「包含する」ような概念自体が存在せず、完全に同じ型でなければならない**（Aは誤り）。
- `func()`は名前も引数(無し)も`Super`と同じなので、戻り値の型だけを変えて別メソッドとして追加(オーバーロード)することもできない。**戻り値の型だけが異なり、名前・引数が同じメソッドは、オーバーライドの資格が無い限りそもそも共存できない**というルールに引っかかる（Cは誤り）。
- `@Override`を外しても、根本的な「戻り値の型の非互換」自体は解消されないため、依然としてコンパイルエラーになる（Dは誤り）。
- コンパイル時に確定する問題なので、実行時に呼び分けられるようなことはない（Eは誤り）。
- `javac`で検証済み：「`Sub`の`func()`は`Super`の`func()`をオーバーライドできません（戻り値の型`long`は`int`と互換性がありません）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex6"></a>
## 問題ex6(sample/chap6/ex6)

```java
class Parent {
    private static void methodA() { System.out.println("static Parent methodA()"); }
    private void methodB() { System.out.println("Parent#methodB()"); }
}
class Child extends Parent {
    public static void methodA() { System.out.println("static Child methodA()"); }
    public void methodB() { System.out.println("Child#methodB()"); }
}
public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        Child.methodA();
        obj.methodB();
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`static Child methodA()`の後`Child#methodB()`が出力される
B. `obj.methodB();`の行でコンパイルエラーになる（`obj`の静的型`Parent`の`methodB()`が`private`でアクセスできないため）
C. `Child`の`methodA()`, `methodB()`は`Parent`の`private`メンバをオーバーライドしようとしているためコンパイルエラーになる
D. `Child.methodA();`の行でコンパイルエラーになる（`static`メソッドは`private`な親と同名にできない）
E. 実行時に`Parent`側の`private`メソッドが呼ばれ`static Parent methodA()`と`Parent#methodB()`が出力される

**解答**

正解：**B**

**補足**

- `private`なメンバは、**そのメンバを宣言したクラス自身の中でしか使えない**。オーバーライドの対象にすらならず、`Child`の同名メソッドは`Parent`とは無関係な**全く新しいメンバ**として扱われる（C・Dは誤り、名前が同じでも衝突・オーバーライドの試みにはならない）。
- `obj`の**静的型は`Parent`**。`obj.methodB()`という呼び出しは、コンパイラがまず「`Parent`型に`methodB()`という呼び出し可能なメンバがあるか」を確認しようとするが、`Parent#methodB()`は`private`であり、`Main`クラスからは**そもそも見えない(アクセスできない)**。よってこの時点でコンパイルエラーになる（E は誤り、実行時まで到達しない）。
- `Child.methodA();`は`Child`自身の`public static`メンバを直接呼んでいるだけなので問題なくコンパイルできる（Dは誤り）。
- `javac`で検証済み：`obj.methodB();`の行で「`methodB()`は`Parent`で`private`アクセスされます」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex7"></a>
## 問題ex7(sample/chap6/ex7)

```java
class Plant {
    public Plant() { System.out.println("Plant"); }
    public Plant(int id) { this(); System.out.println("Plant " + id); }
}
class Vegetable extends Plant {
    public Vegetable(int id) { System.out.println("Vegetable " + id); }
}
class Tomato extends Vegetable {
    public Tomato(int id) { super(id); System.out.println("Tomato"); }
    public static void main(String[] args) { new Tomato(1); }
}
```

次のプログラムを実行すると、何が出力される順序になりますか。（1つ選択）

A. `Plant` `Plant 1` `Vegetable 1` `Tomato`（`Plant(int id)`経由で呼ばれる）
B. `Plant` `Vegetable 1` `Tomato`
C. `Vegetable 1` `Plant` `Tomato`
D. `Plant 1` `Vegetable 1` `Tomato`
E. コンパイルエラーになる（`Vegetable`のコンストラクタが`super`も`this`も呼んでいないため）

**解答**

正解：**B**

**補足**

- `Vegetable(int id)`は`super(...)`も`this(...)`も明示的に書いていないので、コンパイラが自動的に**引数無しの`super()`**を先頭に挿入する。これは`Plant()`(引数無し版)を呼び出すのであって、`Plant(int id)`ではない（A・Dは誤り。「`int`を受け取るコンストラクタだから同じく`int`を受け取る親のコンストラクタが呼ばれる」という誤解に注意。`Plant(int id)`は一度も呼ばれない）。この暗黙の挿入自体は正当でコンパイルエラーにはならない（Eは誤り）。
- `Tomato(1)`→`super(1)`(`Vegetable(1)`)→(暗黙の)`super()`(`Plant()`、`"Plant"`を出力)→`Vegetable(1)`の本体(`"Vegetable 1"`を出力)→`Tomato(1)`の本体(`"Tomato"`を出力)、という順。
- `javac`/`java`で検証済み：`Plant` / `Vegetable 1` / `Tomato`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex8"></a>
## 問題ex8(sample/chap6/ex8)

```java
class One {
    int no;
    public One(int no) { this.no = no; }
    public String toString() { return "One:" + no; }
}
class Two extends One {
    String text;
    public Two(String text) {
        super(0);
        this.text = text;
    }
    public String toString() { return super.toString() + ", Two:" + text; }
    public static void main(String[] args) {
        System.out.println(new One(1));
        System.out.println(new Two("two"));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `One:1` の後 `One:0, Two:two`
B. `One:1` の後 `Two:two`（`super.toString()`は呼ばれない）
C. `One`に引数無しのコンストラクタが無いため`Two`のコンストラクタ宣言でコンパイルエラーになる
D. `One:1` の後 `One:1, Two:two`
E. `println(new One(1))`は`toString()`を呼ばず`One@`から始まるハッシュコード形式になる

**解答**

正解：**A**

**補足**

- `One`が引数付きコンストラクタしか持たない状態でも、`Two`側が`super(0);`のように明示的に対応するコンストラクタを呼べば問題ない（Cは誤り）。
- `println(obj)`は`obj`が`toString()`をオーバーライドしていれば、それを自動的に呼び出す。`One`自身が`toString()`をオーバーライドしているので、`new One(1)`は`"One:1"`（Eは誤り）。
- `Two`の`toString()`内の`super.toString()`は、明示的に**親クラス(`One`)の`toString()`**を呼び出す構文であり、正しく機能する（Bは誤り）。`super(0)`により`Two`の`no`は`0`になっているので、`super.toString()`は`"One:0"`を返す。
- `javac`/`java`で検証済み：`One:1` / `One:0, Two:two`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex10"></a>
## 問題ex10(sample/chap6/ex10)

```java
public record Item(String name, int stock) {
    Item {
        if (stock < 0) throw new IllegalArgumentException("negative stock");
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. コンパイルエラーになる（コンパクトコンストラクタ`Item { ... }`のアクセス修飾子が、`public record`である`Item`自身より弱いため`public Item { ... }`と書く必要がある）
C. コンパクトコンストラクタの中では`throw`を使うことができない
D. `if (stock < 0)`のような通常のコンパイルされる条件式はコンパクトコンストラクタの中には書けない
E. `stock`という同じ名前をコンポーネントとコンパクトコンストラクタの引数チェックで2回使うことはできない

**解答**

正解：**B**

**補足**

- `record`の**正規(標準)コンストラクタ**（コンパクトコンストラクタも含む）は、**そのレコード自身のアクセス修飾子と同じか、それより強い**アクセス修飾子でなければならないというルールがある。
- 今回`Item`は`public record`だが、コンパクトコンストラクタが`Item { ... }`のようにアクセス修飾子を省略している(＝デフォルトアクセスになる)ため、`public`である`Item`本体より**弱いアクセス権限を割り当てようとしている**と判定されコンパイルエラーになる。
- 正しく動かすには`public Item { ... }`のように、レコード自身と同じ`public`を明示する必要がある。
- コンパクトコンストラクタの中で`throw`を使うこと自体は、値のバリデーション用途として広く使われる正当な書き方（C・D・Eは誤り、これらは今回のエラーの原因ではない）。
- `javac`で検証済み：「レコード`Item`に無効な標準コンストラクタがあります（(public)より強いアクセス権限を割り当てようとしました）」。`public Item { ... }`に直せば問題なくコンパイル・実行でき、`stock=-100`で`IllegalArgumentException`がスローされる。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex11"></a>
## 問題ex11(sample/chap6/ex11)

```java
public record Curriculum(String name, String level) {}
class Main {
    public static void main(String[] args) {
        Curriculum obj1 = new Curriculum("English", "intermediate");
        obj1.name = "Japanese";
        System.out.println(obj1);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り、`name`が`"Japanese"`に書き換わった状態で出力される
B. `obj1.name = "Japanese";`の行でコンパイルエラーになる（`record`のコンポーネントは`private final`な扱いで、直接の代入(そもそもフィールドとしてのアクセス自体)ができない）
C. `record`のコンポーネントは一度だけ再代入が許されるためコンパイルは通るが、2回目の代入からエラーになる
D. `obj1.name()`と書けばアクセサ経由で再代入できる
E. `record`はそもそも`class`のように`.`でメンバにアクセスすることができない

**解答**

正解：**B**

**補足**

- `record`のコンポーネント(`name`, `level`)は、内部的に`private final`なフィールドとして生成され、**外部に公開されるのはアクセサメソッド(`name()`, `level()`)だけ**。フィールド名と同じ`obj1.name`のような書き方でアクセスすること自体が、`private`であるためそもそもできない（Eは誤り、`.`によるメンバアクセス自体はメソッド呼び出しなら普通に行える。Cは誤り、1回すら代入できない）。
- `name()`はアクセサ(取得用)メソッドであり、値を返すだけで再代入する手段は提供されない。`record`のコンポーネントは生成後変更不可能(イミュータブル)であることが設計上の前提（Dは誤り）。
- `javac`で検証済み：「`name`は`Curriculum`で`private`アクセスされます」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex13"></a>
## 問題ex13(sample/chap6/ex13)

```java
interface X { void methodX(); }
interface Y { void methodY(); }
abstract class Base implements X {
    void methodA() {}
    abstract void methodB();
}
class Derived extends Base {
    void methodX() {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通る
B. `class Derived extends Base {`の行でコンパイルエラーになる（`Base`の抽象メソッド`methodB()`が未実装で、`Derived`が`abstract`でもないため）
C. `void methodX() {}`の行でコンパイルエラーになる（アクセス修飾子`public`を明示しなければインタフェースのメソッドを実装したことにならない）
D. `Base`が`interface X`を実装しているのに自身も抽象メソッド(`methodB`)を持てることがそもそも矛盾でコンパイルエラーになる
E. `interface Y`は一度も使われていないためコンパイルエラーになる（未使用のインタフェースは宣言できない）

**解答**

正解：**B**

**補足**

- `Derived`は`Base`の抽象メソッド`methodB()`を実装しないまま`extends`しているが、`Derived`自身も`abstract`と宣言されていない。「未実装の抽象メソッドが残っている具象クラス」は許されない。
- `abstract class`が`interface`を実装しつつ、自分自身も別の抽象メソッド(`methodB`)を追加で持つこと自体は正当な設計（Dは誤り。抽象クラスは実装を先送りできる）。
- インタフェースの抽象メソッドを実装する際は、**元の宣言より広いか同じアクセス修飾子**が必要（インタフェースのメソッドは暗黙`public`なので、実装側も`public`にする必要がある）。今回の`methodX()`はデフォルトアクセスのままなので、本来ならこちらもエラーの対象になりうるが、まず先に**継承階層全体で報告される`methodB()`未実装のエラーが優先して検出される**。
- 未使用のインタフェース宣言自体に制約は無い（Eは誤り）。
- `javac`で検証済み：「`Derived`は`abstract`でなく、`Base`内の`abstract`メソッド`methodB()`をオーバーライドしません」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex14"></a>
## 問題ex14(sample/chap6/ex14)

```java
interface One { default double x() { return 10.0; } }
interface Two { default int x() { return 10; } }
class Foo implements One, Two {
    public void y() {}
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. `Foo`が`x()`をオーバーライドしていないためコンパイルエラーになる
B. `Foo`クラスの宣言自体がコンパイルエラーになる（`One`と`Two`の`x()`は戻り値の型(`double`と`int`)が非互換のため、この2つを同時に実装すること自体が成立しない）
C. `One`, `Two`の階層に順序を付けて、後に書かれた`Two`の`x()`が優先される
D. `Foo`で`x()`を明示的にオーバーライドすれば、戻り値の型が違っていても解決できる
E. 実行時にどちらの`x()`が使われるか不定になる

**解答**

正接：**B**

**補足**

- 通常、2つの無関係なインタフェースが同名の`default`メソッド(引数・戻り値も同じ)を持っていて衝突する場合は、実装クラス側でオーバーライドすれば解決できる。しかし今回は`One#x()`(`double`)と`Two#x()`(`int`)で**戻り値の型自体が非互換**であり、これは「同じシグネチャの衝突」ではなく「**そもそも両立不可能な2つのメソッドを同時に継承しようとしている**」状態。
- この場合はオーバーライドによっても解決できず、`One`と`Two`を同時に`implements`しようとした`Foo`クラスの宣言自体がコンパイルエラーになる（A・Dは誤り）。
- 「後に書いた方が優先される」というような暗黙のルールは無い（C・Eは誤り、そもそも実行段階まで到達しない）。
- `javac`で検証済み：「タイプ`Two`と`One`は互換性がありません（両方とも`x()`を定義していますが、戻り値の型が無関係です）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex15"></a>
## 問題ex15(sample/chap6/ex15)

```java
public interface Test {
    String TEST_NAME = "Test";
    double TEST_VALUE = 5.0;
    static double calc() { return TEST_VALUE * TEST_VALUE; }
}
class Main implements Test {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.TEST_NAME + ":" + Test.calc());
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `Test:25.0`
B. `m.TEST_NAME`は`static`メンバへのインスタンス経由アクセスなのでコンパイルエラーになる
C. `Test.calc()`は`static`メソッドなので`Main`から呼び出せずコンパイルエラーになる
D. `calc()`の中の`TEST_VALUE`は`Main`が持つ値を参照しようとしてコンパイルエラーになる
E. `null:25.0`

**解答**

正解：**A**

**補足**

- インタフェースの定数(`static final`扱い)は、**インタフェース名経由でも、実装クラスのインスタンス経由でも**アクセスできる（Bは誤り。フィールドやstaticメンバをインスタンス経由でアクセスすること自体は許可されている操作）。
- `Test`が実装先の`Main`から見て親のような役割のインタフェースになっている場合、`Test.calc()`のようにインタフェース名を直接指定して呼び出す分には全く問題ない（Cは誤り。`static`メソッドが実装クラス経由(`Main.calc()`のような呼び方)ができないのとは別の話）。
- `calc()`はインタフェース`Test`自身の中に定義されており、その中の`TEST_VALUE`は同じインタフェース内の定数を指すので何の問題も無い（Dは誤り）。
- `TEST_NAME`は`"Test"`で初期化済みなので`null`にはならない（Eは誤り）。
- `javac`/`java`で検証済み：`Test:25.0`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex16"></a>
## 問題ex16(sample/chap6/ex16・複数選択)

```java
public sealed class Fruit permits Lemon, Orange {}
final class Mango extends Fruit {}
non-sealed class Lemon extends Fruit {}
class Orange extends Fruit permits Mandarin {}
final class Mandarin extends Orange {}
```

このプログラムをコンパイルすると、どの行がコンパイルエラーになりますか。（複数選択）

A. `final class Mango extends Fruit {}`（`Fruit`の`permits`句に`Mango`が含まれていない）
B. `non-sealed class Lemon extends Fruit {}`
C. `class Orange extends Fruit permits Mandarin {}`（`permits`句を持つクラスは自分自身も`sealed`と宣言しなければならない）
D. `final class Mandarin extends Orange {}`
E. `public sealed class Fruit permits Lemon, Orange {}`

**解答**

正解：**A、C**

**補足**

- **A**：`Fruit`の`permits`句は`Lemon, Orange`のみで`Mango`が含まれていない。`Mango`は`Fruit`の許可対象外なのでエラーになる。
- **C**：`permits`句を書けるのは`sealed`クラスだけ。`Orange`は`class Orange extends Fruit permits Mandarin {}`のように`permits`を書いているのに、`sealed`という修飾子自体が付いていない。「`permits`句を持つなら`sealed`でなければならない」というルールに違反する。
- **B**：`Lemon`は`Fruit`の許可対象(`permits`に含まれる)であり、`non-sealed`(それ以降は無制限に継承可)を選ぶこと自体は正当。
- **D**：もし`Orange`が正しく`sealed class Orange extends Fruit permits Mandarin {}`と書かれていれば(Cのエラーを除けば)、`Mandarin`は`Orange`の`permits`句に含まれているので`final`として問題なく継承できる。
- **E**：`Fruit`自身の宣言は正当（`sealed`＋`permits`の基本形）。
- `javac`で検証済み：2件のエラー（`Mango`の行で「クラスはシール・クラス`Fruit`を拡張できません（'permits'句に指定されていないためです）」、`Orange`の行で「無効な`permits`句（classはシールする必要があります）」）。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex17"></a>
## 問題ex17(sample/chap6/ex17)

```java
interface X {}
class Zero {}
class One extends Zero {}
class Two extends Zero implements X {}
class Main {
    public static void main(String[] args) {
        new Main().test(new Two());
    }
    void test(Object obj) {
        if (obj instanceof X) System.out.print("X ");
        if (obj instanceof Zero z) System.out.print("Zero ");
        if (obj instanceof One o) System.out.print("One ");
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `X Zero One `（`Two`は`Zero`のサブクラスなので`One`とも判定される）
B. `X Zero `
C. `X One `
D. `Zero `のみ
E. `X `のみ

**解答**

正解：**B**

**補足**

- `Two`は`Zero`を継承(`extends`)し、かつ`X`を実装(`implements`)している。よって`obj instanceof X`と`obj instanceof Zero z`はどちらも`true`。
- `One`もまた`Zero`を継承しているが、**`One`と`Two`は`Zero`を共通の親に持つだけの、互いに無関係な兄弟クラス**。`Two`のインスタンスが`One`でもあるということはない（Aは誤り、「`Two`が`Zero`のサブクラスだから`Zero`の別のサブクラスである`One`にもなる」という誤解に注意）。
- それぞれの`if`は独立しており、複数該当すればそれぞれ出力される(1つだけしか出力されない、ということはない。C・D・Eは誤り)。
- `javac`/`java`で検証済み：`X Zero `。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex18"></a>
## 問題ex18(sample/chap6/ex18)

```java
interface Browser {
    default void browse() { System.out.print(" Browsing.."); }
}
class MobilePhone implements Browser {
    public void call() { System.out.print(" Calling.."); }
    public void browse() { System.out.print(" Just scrolling.."); }
}
class Laptop implements Browser {}
public class Main {
    public static void main(String[] args) {
        Browser br = new MobilePhone();
        br.browse();
        br = new Laptop();
        br.browse();
        MobilePhone mp = (MobilePhone) br;
    }
}
```

次のプログラムを実行すると、何が起きますか。（1つ選択）

A. ` Just scrolling.. Browsing..`の後、正常終了する
B. ` Just scrolling.. Browsing..`の後、`(MobilePhone) br`の行で実行時に`ClassCastException`がスローされる
C. ` Browsing.. Browsing..`の後、正常終了する（`Laptop`は`browse()`を持たないので`Browser`のデフォルトが常に優先される）
D. `Laptop`が`browse()`をオーバーライドしていないためコンパイルエラーになる
E. `MobilePhone mp = (MobilePhone) br;`の行でコンパイルエラーになる（`Browser`型の変数を`MobilePhone`にキャストできない）

**解答**

正解：**B**

**補足**

- `Laptop`は`browse()`をオーバーライドしていないので、`default`メソッド(`" Browsing.."`)がそのまま使われる。これは正当であり、コンパイルエラーにはならない（Dは誤り。`default`メソッドのオーバーライドは任意）。
- `MobilePhone`は独自に`browse()`をオーバーライド(`" Just scrolling.."`)しているので、`new MobilePhone().browse()`はそちらが呼ばれる（Cは誤り。`default`が常に優先されるわけではなく、通常のオーバーライドと同じ動的束縛のルールに従う）。
- `Browser`型の変数を`MobilePhone`にキャストすること自体は「理論上あり得る変換」として構文上許可される（Eは誤り、`MobilePhone`は`Browser`を実装しているため）。
- しかし`br`は最終的に`Laptop`のインスタンスを指している状態でキャストされようとしているため、実行時に実体の型チェックに失敗し`ClassCastException`がスローされる（A・Cは誤り、最後まで到達しない）。
- `javac`/`java`で検証済み：` Just scrolling.. Browsing..`の後、`Exception in thread "main" java.lang.ClassCastException: class Laptop cannot be cast to class MobilePhone`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex19"></a>
## 問題ex19(sample/chap6/ex19)

```java
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(1); scores.add(2); scores.add(null);
        scores.add(3, 3);
        scores.set(4, 10);
        System.out.println(scores);
    }
}
```

次のプログラムを実行するとどうなりますか。（1つ選択）

A. `[1, 2, null, 3, 10]`
B. `scores.add(3, 3);`の後、リストの中身は`[1, 2, null, 3]`(要素数4)になっており、続く`scores.set(4, 10);`で実行時に`IndexOutOfBoundsException`がスローされる
C. `scores.add(null);`の行でコンパイルエラーになる（`Integer`型のリストに`null`は追加できない）
D. `scores.add(3, 3);`は「値`3`を2個追加する」という意味になり、リストは`[1, 2, null, 3, 3]`になる
E. `set(4, 10)`は要素数が足りない場合、自動的にリストの末尾に追加してくれる

**解答**

正解：**B**

**補足**

- `Integer`のような参照型を要素とする`List`には`null`を要素として追加できる（Cは誤り）。
- `add(3, 3)`は`add(int index, E element)`（**添字3の位置に値`3`を挿入**）として解釈される。2個追加しているわけではない（Dは誤り）。この時点でリストは`[1, 2, null, 3]`(要素数4、有効な添字は`0`〜`3`)になる。
- `set(4, 10)`は「**既存の要素を置き換える**」操作であり、`add`のように新しい位置を自動的に広げてはくれない。添字`4`はまだ存在しない位置なので、実行時に範囲外エラーになる（A・Eは誤り。`set`には`add`のような自動追加機能は無い）。
- `javac`/`java`で検証済み：`Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex20"></a>
## 問題ex20(sample/chap6/ex20)

```java
import java.util.ArrayList;
record Item(int no, String name) {}
public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, "Laptop"));
        items.add(new Item(2, "Mobile"));
        items.add(new Item(2, "Phone"));
        for (Item i : items) {
            System.out.print(i.no() + ", ");
        }
        System.out.println(items.set(1, new Item(3, "Smartwatch")));
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `1, 2, 2, ` の後 `Item[no=2, name=Mobile]`
B. `1, 2, ` の後 `Item[no=2, name=Mobile]`（`no`が重複する`Item`は`List`に追加できない）
C. `1, 2, 2, ` の後 `Item[no=3, name=Smartwatch]`（`set`は新しく設定した値を返す）
D. `add()`の時点で`no`が重複しているためコンパイルエラーになる
E. `1, 2, 2, ` の後 `null`（置き換える前の値は保持されない）

**解答**

正解：**A**

**補足**

- `List`（`Set`とは違う）は、要素の重複を一切気にしない。`no`の値が同じ`Item`同士(record自体は別インスタンス)でも問題なく複数追加できる（B・Dは誤り）。
- 拡張forでは追加した順に`no`が出力されるので`1, 2, 2, `。
- `set(index, element)`は「**その添字に新しい値をセットし、セットする前の古い値を返す**」という仕様。今回添字`1`にあった古い値は`new Item(2, "Mobile")`なので、それがそのまま返る(`record`の自動生成`toString()`により`Item[no=2, name=Mobile]`という形式で表示される。C・Eは誤り、新しい値が返ったり`null`になったりはしない)。
- `javac`/`java`で検証済み：`1, 2, 2, ` / `Item[no=2, name=Mobile]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex21"></a>
## 問題ex21(sample/chap6/ex21)

```java
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(1, 3);
        System.out.println(numbers);
        System.out.println(numbers.remove(1));
        System.out.println(numbers);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `[1, 3, 2]` の後 `3` の後 `[1, 2]`
B. `[1, 3, 2]` の後 `2` の後 `[1, 3]`（`remove(1)`は「値が`1`の要素」ではなく「値が`2`」を探して削除しようとするため）
C. `[1, 2, 3]` の後 `2` の後 `[1, 3]`
D. `[1, 3, 2]` の後 `true` の後 `[1, 3]`
E. `numbers.add(1, 3);`の行でコンパイルエラーになる（すでに要素`1`が入っているため重複した値は追加できない）

**解答**

正解：**A**

**補足**

- `add(1, 3)`は`add(int index, E element)`（**添字1に値`3`を挿入**）。`[1, 2]`だったリストは`[1, 3, 2]`になる（重複の可否は無関係。Eは誤り、リストは重複した値を問題なく許容する）。
- `remove(1)`が受け取っている`1`は、明示的にオートボクシングされていない**`int`リテラル**。`List<Integer>`には`remove(int index)`(添字指定)と`remove(Object o)`(値指定)の2つのオーバーロードがあるが、**プリミティブの`int`を渡した場合は`remove(int index)`が優先的に選ばれる**（値として`Integer`の`1`を消したい場合は`remove(Integer.valueOf(1))`のように明示的にボクシングする必要がある。Bは誤り、値指定として解釈されるわけではない）。
- `remove(int index)`は削除した**要素の値**を返す（`Collection`の`remove(Object)`が返す`boolean`とは異なる。Dは誤り）。添字`1`の要素(`3`)を削除して`3`を返し、リストは`[1, 2]`になる。
- `javac`/`java`で検証済み：`[1, 3, 2]` / `3` / `[1, 2]`。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex22"></a>
## 問題ex22(sample/chap6/ex22)

```java
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.add("UK", "United Kingdom");
        System.out.println(map);
    }
}
```

このプログラムをコンパイルするとどうなりますか。（1つ選択）

A. 問題なくコンパイルが通り`{UK=United Kingdom}`が出力される
B. `map.add("UK", "United Kingdom");`の行でコンパイルエラーになる（`Map`インタフェースに`add()`というメソッドは存在しない）
C. `Map`は`Collection`を継承していないので`new HashMap<>()`自体がコンパイルエラーになる
D. `add()`は`Map`では`put()`のエイリアス(別名)として自動的に扱われる
E. 実行時に`NoSuchMethodError`がスローされる

**解答**

正解：**B**

**補足**

- `Map`インタフェースはキーと値のペアを扱うためのAPIとして`put(key, value)`, `get(key)`, `remove(key)`などを持つが、**`add()`というメソッドは存在しない**（`List`や`Set`のような`Collection`系のインタフェースには`add()`があるが、`Map`は`Collection`を継承していない独立した別系統のインタフェースであり、そちらの命名規則を引き継いでいない。Dは誤り、自動的なエイリアスの仕組みは無い）。
- `new HashMap<>()`自体は正当なインスタンス化であり、コンパイルエラーの原因にはならない（Cは誤り。「`Map`が`Collection`を継承していない」ことと「`HashMap`をインスタンス化できるかどうか」は別の話）。
- 存在しないメソッドの呼び出しはコンパイル時に検出される（Eは誤り、実行時まで到達しない）。
- `javac`で検証済み：「シンボルを見つけられません（シンボル: メソッド`add(String,String)`、場所: タイプ`Map<String,String>`の変数`map`）」。

**実施記録**

回答：
正解：
迷ったポイント：
<a id="qex24"></a>
## 問題ex24(sample/chap6/ex24)

```java
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Object[] oArr = {"100", new String("200"), 300};
        String[] sArr = {"100", "200", "300"};
        int value = Arrays.mismatch(sArr, oArr);
        System.out.println(value);
    }
}
```

次のプログラムを実行すると、何が出力されますか。（1つ選択）

A. `-1`（全要素が一致するため）
B. `0`
C. `2`
D. `String[]`と`Object[]`という異なる配列型同士なので`Arrays.mismatch()`の行でコンパイルエラーになる
E. 実行時に`ArrayStoreException`がスローされる

**解答**

正解：**C**

**補足**

- `String[]`は`Object[]`の**サブタイプ**として扱えるため、`Arrays.mismatch(Object[] a, Object[] b)`のようなメソッドに`String[]`をそのまま渡すことができる（Dは誤り）。
- `mismatch()`は、先頭から`equals()`で比較していき、**最初に値が食い違ったインデックス**を返す(すべて一致すれば`-1`)。
- 添字`0`：`"100".equals("100")`→一致。添字`1`：`"200".equals(new String("200"))`→内容が同じ`String`同士なので一致。添字`2`：`sArr[2]`は`String`の`"300"`、`oArr[2]`は`Integer`の`300`。`"300".equals(300)`は、比較相手の型が違う(`String`と`Integer`)ため`false`(不一致)。
- よって最初に不一致になる添字`2`が返る（A・Bは誤り）。配列への格納時点で型の不整合は起きていないので`ArrayStoreException`にもならない（Eは誤り、`oArr`は`Object[]`としてどんな参照型でも格納できる）。
- `javac`/`java`で検証済み：`2`。

**実施記録**

回答：
正解：
迷ったポイント：