## 目次

**問題一覧**

- [問題1-1](#q1-1)
- [問題3-1](#q3-1)
- [問題4-1](#q4-1)
- [問題5-1](#q5-1)
- [問題6-1](#q6-1)
- [問題7-1](#q7-1)
- [問題8-1](#q8-1)
- [問題9-1](#q9-1)
- [問題10-1](#q10-1)
- [問題11-1](#q11-1)
- [問題13-1](#q13-1)
- [問題12-1](#q12-1)
- [問題14-1](#q14-1)
- [問題15-1](#q15-1)
- [問題16-1](#q16-1)
- [問題17-1](#q17-1)



## 問題1-1

```java
public class Item {
    String name;
    String getName() {
        return name;
    }
    void setName(String name) {
        name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setName("Sweater");
        System.out.println("item1 : " + item1.getName());
    }
}
```

このコードの実行結果はどれか。

A. item1 : Sweater

B. item1 : null

C. コンパイルエラーになる

D. NullPointerExceptionがスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題3-1

```java
class Item {
    private String name;
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
}
```

```java
Item item1 = new Item();
item1.name = "Sweater";
```

`Item`クラスの`name`フィールドを`private`に変更した(getName/setNameの中身は変更なし)。このとき`item1.name = "Sweater";`の行はどうなるか。

A. コンパイルエラーになる

B. "Sweater"が正常に設定され、出力に影響しない

C. 実行時に`IllegalAccessException`がスローされる

D. "Sweater"は設定されるが、`getName()`を呼ぶと`null`が返る

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題4-1

```java
class Item {
    String name;
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        Item item = new Item();
        item.setName(null);
        System.out.println("item : " + item.getName());
        System.out.println(item.getName() == null);
    }
}
```

このコードの実行結果はどれか。

A. コンパイルエラーになる

B. 1行目でNullPointerExceptionがスローされる

C. item : null / true

D. item : / true

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題5-1

`com/Item.java`(パッケージ`com`):

```java
package com;

public class Item {
    String name;
     String getName() {
        return name;
    }
     void setName(String name) {
        this.name = name;
    }
}
```

`Main.java`(デフォルトパッケージ、`com`とは別ディレクトリ):

```java
import com.Item;

class Main {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getName());
    }
}
```

元のソースでは`Item`クラスに修飾子が付いていなかったが、ここでは`public class Item`に変更した(フィールド・メソッドはそのまま修飾子なし)。この場合どうなるか。

A. 問題なくコンパイル・実行でき、`null`が出力される

B. `new Item()`の行でコンパイルエラーになる

C. `item.getName()`の行でコンパイルエラーになる

D. 実行時に`IllegalAccessError`がスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題6-1

```java
class Item {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("T-shirt");
        System.out.println("item : " + item.getName());
        item.name = "Sweater";
        System.out.println("item : " + item.name);
    }
}
```

このコードの実行結果はどれか。

A. item : T-shirt / item : Sweater

B. コンパイルエラーになる

C. 実行時に例外がスローされる

D. item : T-shirt とだけ表示される

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題7-1

```java
public class Sample {
    public void printItem(String s) {}
    public void printItem(String[] s, int i) {}
    public boolean printItem(int i, String[] s) { return true; }
    void printItem() {}
    public void printItem(String item) {}
}
```

元のサンプルではコメントアウトされていた5番目のメソッド`public void printItem(String item) {}`を有効にした。このクラスはどうなるか。

A. コンパイルエラーになる(1行目のメソッドと引数の型が重複するため定義できない)

B. 問題なくコンパイルできる(オーバーロードとして成立する)

C. コンパイルエラーになる(引数名`item`が予約語として扱われるため)

D. 実行時に例外がスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題8-1

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
        item.printItem("#", 0);
        item.printItem("#", -2);
    }
}
```

このコードの実行結果はどれか。

A. 何も出力されない

B. `Item : T-shirt`(前後に半角スペース)が2回出力される

C. `# Item : T-shirt #`が2回出力される

D. 1回目は何も出力されず、2回目は`# Item : T-shirt #`が出力される

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題9-1

```java
public class Sample {
    public void method(char... c) { ... }
    public void method(String s, int... i) { ... }
    public void method(int i, int... j) { ... }
    public void method(int i, int j) { ... }
    public void method(String... s, int i) {}
}
```

元のコードでコメントアウトされていた5番目のメソッド`public void method(String... s, int i) {}`を有効にした。このクラスはどうなるか。

A. 問題なくコンパイルできる

B. コンパイルエラーになる(可変長引数は最後のパラメータでなければならない)

C. コンパイルエラーになる(同じ型の可変長引数を複数のメソッドで使えないため)

D. 実行時に例外がスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題10-1

```java
public class Sample {
    public void method(int i) { System.out.print("int : " + i); }
    public void method(long l) { System.out.print("long : " + l); }
    public void method(float f) { System.out.print("float : " + f); }
    public void method(double d) { System.out.print("double : " + d); }
    public void method(Integer i) { System.out.print("Integer : " + i); }
    public void method(int... i) { System.out.print("int... : " + i[0]); }
    public void method(byte b) { System.out.print("byte : " + b); }
    public static void main(String... args) {
        Sample s = new Sample();
        s.method(100);
    }
}
```

元のサンプルではコメントアウトされていた`method(int i)`を有効にした(他のメソッドはそのまま)。この状態で`s.method(100);`の出力はどうなるか。

A. `long : 100`(引数なしのメソッドが優先されるルールは変わらないため)

B. コンパイルエラーになる(オーバーロードの候補が曖昧になるため)

C. `int... : 100`(可変長引数が優先される)

D. `int : 100`(完全に型が一致するメソッドが最優先される)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題11-1

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
        Item item = new Item();
        item.printItem();
    }
}
```

このコードの実行結果はどれか。

A. Item id:0 name:null が出力される

B. コンパイルエラーになる

C. NullPointerExceptionがスローされる

D. Item id: name: が出力される(idもnameも空)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題13-1

```java
public class Sample {
    int value = 100;
    static int commonValue = 500;
    public void printValue() {
        System.out.println("instance value : " + value);
    }
    public static void printCommonValue() {
        System.out.println("static common value : " + commonValue);
    }
}
public class Main {
    public static void main(String[] args) {
        Sample s1 = new Sample();
        Sample s2 = new Sample();
        s1.commonValue = 999;
        s2.printCommonValue();
        Sample.printCommonValue();
        System.out.println(s1.commonValue == s2.commonValue);
    }
}
```

このコードの実行結果はどれか。

A. static common value : 500 / static common value : 999 / false

B. static common value : 999 / static common value : 999 / true

C. コンパイルエラーになる(s1.commonValueへの代入が不正)

D. static common value : 999 / static common value : 500 / false

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題12-1

```java
public class Item {
    private int id;
    private String name;
    public Item() {
        System.out.println("before this()");
        this(0, "T-shirt");
    }
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void printItem() {
        System.out.println("Item id:" + id + " name:" + name );
    }
    public static void main(String[] args) {
        new Item().printItem();
    }
}
```

元のコードでは`this(0, "T-shirt");`がコンストラクタの先頭文だったが、その前に`System.out.println("before this()");`を追加した。このクラスはどうなるか。

A. 問題なくコンパイル・実行でき、`before this()`が先に出力される

B. 実行時に`StackOverflowError`がスローされる

C. コンパイルエラーになる(`this()`呼び出しはコンストラクタの先頭文でなければならない)

D. コンパイルエラーになる(`this()`は`Item()`コンストラクタ内で2回以上呼び出せないため)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題14-1

```java
class Test {
    static int num;
    String s;
    static {
        num = 100;
        System.out.println("static Initializer... num : " + num);
    }
    {
        this.s = "Test";
        System.out.println("Initializer... s : " + s);
    }
    public Test(String s) {
        this.s = s;
        System.out.println("Constructor... s : " + s);
    }
}
public class Main {
    static { System.out.println("static Initializer... Main"); }
    public static void main(String[] args) {
        new Test("A");
        new Test("B");
    }
}
```

このコードの実行結果はどれか。

A. static Initializer... Main / static Initializer... num : 100 / Initializer... s : Test / Constructor... s : A / static Initializer... num : 100 / Initializer... s : Test / Constructor... s : B

B. static Initializer... Main / static Initializer... num : 100 / Initializer... s : Test / Constructor... s : A / Initializer... s : Test / Constructor... s : B

C. static Initializer... num : 100 / static Initializer... Main / Initializer... s : Test / Constructor... s : A / Initializer... s : Test / Constructor... s : B

D. static Initializer... Main / Initializer... s : Test / Constructor... s : A / static Initializer... num : 100 / Initializer... s : Test / Constructor... s : B

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題15-1

```java
public class Main {
    public static void main(String[] args) {
        int[] val1 = {100};
        int[] val2 = val1;
        val2[0] = 200;
        Main obj = new Main();
        obj.methodA(val2);
        System.out.println("val1[0] : " + val1[0]);
        System.out.println("val2[0] : " + val2[0]);
    }
    public void methodA(int[] val3) {
        val3[0] += val3[0];
        System.out.println("val3[0] : " + val3[0]);
    }
}
```

`val1`と`val2`を`int`から`int[]`に変えた(`val2 = val1;`で同じ配列を参照する)。この状態で実行した場合の3行の出力はどうなるか。

A. `val3[0] : 400` / `val1[0] : 400` / `val2[0] : 400`

B. `val3[0] : 400` / `val1[0] : 200` / `val2[0] : 400`

C. `val3[0] : 400` / `val1[0] : 100` / `val2[0] : 200`

D. `val3[0] : 200` / `val1[0] : 200` / `val2[0] : 200`

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題16-1

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
        ary = new int[]{9, 9, 9};
        ary[0] = 100;
        System.out.println("methodB() ary : " + Arrays.toString(ary));
    }
}
```

このコードの実行結果はどれか。

A. methodB() ary : [100, 9, 9] / main() array : [1, 5, 3]

B. methodB() ary : [100, 9, 9] / main() array : [100, 9, 9]

C. methodB() ary : [100, 5, 9] / main() array : [1, 5, 3]

D. methodB() ary : [100, 9, 9] / main() array : [1, 2, 3]

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題17-1

```java
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("T-shirt");
        Item item2 = new Item("T-shirt");
        item2.name = "Jeans";
        System.out.println("item1, item2 : "
                        + item1.name + ", " + item2.name);
        System.out.println("item1 == item2 : "
                        + (item1 == item2));
    }
}
class Item {
    String name;
    Item(String name) { this.name = name; }
}
```

元のコードでは`Item item2 = item1;`(同じ参照を代入)だったが、代わりに`Item item2 = new Item("T-shirt");`(同じ引数で別インスタンスを生成)に変えた。この場合の出力はどうなるか。

A. `item1, item2 : Jeans, Jeans` / `item1 == item2 : true`

B. コンパイルエラーになる(同じ引数で2つのオブジェクトを生成できないため)

C. `item1, item2 : T-shirt, Jeans` / `item1 == item2 : true`

D. `item1, item2 : T-shirt, Jeans` / `item1 == item2 : false`

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---
