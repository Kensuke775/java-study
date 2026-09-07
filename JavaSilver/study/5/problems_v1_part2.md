## 目次

**問題一覧**

- [問題1-2](#q1-2)
- [問題3-2](#q3-2)
- [問題4-2](#q4-2)
- [問題5-2](#q5-2)
- [問題6-2](#q6-2)
- [問題7-2](#q7-2)
- [問題8-2](#q8-2)
- [問題9-2](#q9-2)
- [問題10-2](#q10-2)
- [問題11-2](#q11-2)
- [問題13-2](#q13-2)
- [問題12-2](#q12-2)
- [問題14-2](#q14-2)
- [問題15-2](#q15-2)
- [問題16-2](#q16-2)
- [問題17-2](#q17-2)



## 問題1-2

```java
public class Item {
    String name;
    String getName() {
        return name;
    }
    void setName(String n) {
        this.name = n;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("Sweater");
        item2 = item1;
        item2.setName("T-shirt");
        System.out.println("item1 : " + item1.getName());
        System.out.println("item2 : " + item2.getName());
    }
}
```

このコードの実行結果はどれか。

A. item1 : Sweater / item2 : T-shirt

B. item1 : T-shirt / item2 : T-shirt

C. item1 : Sweater / item2 : Sweater

D. コンパイルエラーになる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題3-2

```java
class Item {
    String name;
    String getName() {
        return name;
    }
    void setName(String name) {
        name = name;
    }
}
```

```java
Item item1 = new Item();
Item item2 = new Item();

item1.name = "Sweater";
String name = item1.getName();
item2.setName("T-shirt");
System.out.println("item1 : " + name);
System.out.println("itme2 : " + item2.getName());
```

`setName`の中身を`this.name = name;`から`name = name;`に変更した(フィールドは`private`にせずそのまま)。この場合の出力はどうなるか。

A. `item1 : Sweater` / `itme2 : T-shirt`

B. `item1 : Sweater` / `itme2 : null`

C. `item1 : null` / `itme2 : null`

D. コンパイルエラーになる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題4-2

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
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("Jacket");
        item2.setName("Jacket");
        System.out.println(item1 == item2);
        System.out.println(item1.equals(item2));
        System.out.println(item1.getName().equals(item2.getName()));
    }
}
```

このコードの実行結果はどれか。

A. true / true / true

B. false / false / true

C. false / true / true

D. true / false / false

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題5-2

`com/Item.java`(パッケージ`com`):

```java
package com;

public class Item {
    public String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

`Main.java`(デフォルトパッケージ、`com`とは別ディレクトリ):

```java
class Main {
    public static void main(String[] args) {
        com.Item item = new com.Item();
        item.setName("Sweater");
        System.out.println(item.getName());
    }
}
```

`Item`クラス・フィールド・メソッドすべてに`public`を付け、Main側では`import com.Item;`を書かずに`com.Item`という完全修飾名だけで直接使っている。この場合どうなるか。

A. `import`がないためコンパイルエラーになる

B. `Sweater`が出力される

C. `null`が出力される

D. 実行時に`ClassNotFoundException`がスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題6-2

```java
class Item {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public boolean sameName(Item other) {
        return this.name.equals(other.name);
    }
}
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("T-shirt");
        item2.setName("T-shirt");
        System.out.println(item1.sameName(item2));
    }
}
```

このコードの実行結果はどれか。

A. コンパイルエラーになる(otherのnameにアクセスできない)

B. true

C. false

D. NullPointerExceptionがスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題7-2

```java
public class Sample {
    public void printItem(String s) {}
    public void printItem(String[] s, int i) {}
    public boolean printItem(int i, String[] s) { return true; }
    public void printItem(int i, String[] s) {}
    void printItem() {}
}
```

3行目のメソッドと同じ引数`(int i, String[] s)`を持つが、戻り値の型だけ`void`に変えた新しいメソッドを追加した。このクラスはどうなるか。

A. 問題なくコンパイルできる(戻り値の型が違うので別メソッドとして扱われる)

B. 3行目のメソッドが上書きされ、`boolean`が`void`に変わる

C. `boolean`から`void`への変更自体が許可されないためコンパイルエラーになる

D. コンパイルエラーになる(引数の型が同じで戻り値だけ異なるメソッドは区別されない)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題8-2

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
        item.printItem(null);
    }
}
```

このコードの実行結果はどれか。

A. コンパイルエラーになる(呼び出す printItem が曖昧)

B. `null Item : T-shirt null`

C. `NullPointerException`がスローされる

D. `Item : T-shirt`(markの部分は何も表示されない)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題9-2

```java
public class Sample {
    public void method(char... c) { ... }
    public void method(String s, int... i) { ... }
    public void method(int i, int... j) {
        System.out.print("method(int i, int... j) : " + i + ":");
        for (int v : j) { System.out.print(v); }
        System.out.println();
    }
    // method(int i, int j) は削除した

    public static void main(String... args) {
        Sample s = new Sample();
        s.method(100, 200);
    }
}
```

4番目のメソッド`method(int i, int j)`(引数の数が完全一致する非可変長引数版)を削除した。この状態で`s.method(100, 200);`を呼び出すとどうなるか。

A. コンパイルエラーになる(呼び出しがどのメソッドか曖昧で決定できないため)

B. 実行時に`NoSuchMethodError`がスローされる

C. `method(int i, int... j) : 100:200`が出力される

D. `method(char... c) :` の呼び出しとして解釈され、文字化けした出力になる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題10-2

```java
public class Sample {
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

元のサンプルにあった`method(long l)`を削除した(int版はコメントアウトのまま)。この状態で`s.method(100);`の出力はどうなるか。

A. `float : 100.0`が出力される(floatの方がdoubleよりも「狭い」ため、より具体的なメソッドとして優先される)

B. `double : 100.0`が出力される(より安全な拡大変換が優先されるため)

C. コンパイルエラーになる(floatとdoubleのどちらのメソッドを呼ぶか曖昧になるため)

D. `long : 100`が出力される(内部的に自動でlong型が生成されるため)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題11-2

```java
public class Item {
    private int id;
    private String name;
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Item(String name) {
        System.out.println("before this()");
        this(0, name);
    }
    public void printItem() {
        System.out.println("Item id:" + id + " name:" + name);
    }
    public static void main(String[] args) {
        Item item = new Item("Jacket");
        item.printItem();
    }
}
```

このコードの実行結果はどれか。

A. before this() / Item id:0 name:Jacket

B. Item id:0 name:Jacket (before this()は出力されない)

C. コンパイルエラーになる

D. スタックオーバーフローで実行時エラーになる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題13-2

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
    public static void printBoth() {
        System.out.println(value);
        System.out.println(commonValue);
    }
}
```

このコードの実行結果はどれか。

A. コンパイルは通り、printBoth()呼び出し時にNullPointerExceptionがスローされる

B. コンパイルエラーになる

C. 問題なくコンパイルされ、value=0, commonValue=500 が出力される

D. valueの行だけコンパイルエラーになり、commonValueの行はコンパイルされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題12-2

```java
public class Item {
    private int id;
    private String name;
    public Item() {
        this(0, "T-shirt");
    }
    public Item(int id, String name) {
        this();
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

`Item(int, String)`コンストラクタの先頭に`this();`を追加した(`Item()`は元のまま`this(0, "T-shirt");`を呼ぶ)。このクラスはどうなるか。

A. `Item(int, String)`が呼ばれた後に`Item()`が呼ばれ、無限ループになり実行時に`StackOverflowError`がスローされる

B. 問題なくコンパイルでき、`id:0 name:T-shirt`のインスタンスが生成される

C. コンパイルエラーになる(`this()`は1つのクラスに付き1回しか定義できないため)

D. コンパイルエラーになる(コンストラクタ同士が循環して呼び出し合っている)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題14-2

```java
class Test {
    static int num;
    {
        System.out.println("Initializer... s : " + s);
        this.s = "Test";
    }
    String s;
    static {
        num = 100;
        System.out.println("static Initializer... num : " + num);
    }
    public Test(String s) {
        this.s = s;
        System.out.println("Constructor... s : " + s);
    }
}
public class Main {
    public static void main(String[] args) {
        new Test("A");
    }
}
```

このコードの実行結果はどれか。

A. Initializer... s : null / static Initializer... num : 100 / Constructor... s : A

B. コンパイルエラーになる

C. Initializer... s : Test / static Initializer... num : 100 / Constructor... s : A

D. NullPointerExceptionがスローされる

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題15-2

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
        val3 = new int[]{999};
        System.out.println("val3[0] : " + val3[0]);
    }
}
```

`methodA`の中身を「要素を書き換える」のではなく「`val3`に新しい配列を代入する」に変えた。この場合の3行の出力はどうなるか。

A. `val3[0] : 999` / `val1[0] : 999` / `val2[0] : 999`

B. `val3[0] : 200` / `val1[0] : 200` / `val2[0] : 200`

C. `val3[0] : 999` / `val1[0] : 200` / `val2[0] : 200`

D. コンパイルエラーになる(メソッド内でパラメータに新しい配列を代入することはできないため)

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題16-2

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
        modify(ary);
        System.out.println("methodB() ary : " + Arrays.toString(ary));
    }
    public void modify(int[] a) {
        a[0] = 99;
        a = new int[]{0, 0, 0};
    }
}
```

このコードの実行結果はどれか。

A. methodB() ary : [99, 2, 3] / main() array : [99, 2, 3]

B. methodB() ary : [0, 0, 0] / main() array : [0, 0, 0]

C. methodB() ary : [99, 2, 3] / main() array : [1, 2, 3]

D. methodB() ary : [0, 0, 0] / main() array : [99, 2, 3]

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---

## 問題17-2

```java
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Jeans");
        Item item3 = new Item("Jeans");
        System.out.println("item1.equals(item3) : " + item1.equals(item3));
        System.out.println("item1.name.equals(item3.name) : " + item1.name.equals(item3.name));
    }
}
class Item {
    String name;
    Item(String name) { this.name = name; }
}
```

`Item`クラスは`equals()`メソッドをオーバーライドしていない。`item1`と`item3`は別インスタンスだが、`name`フィールドの値は同じ`"Jeans"`。この場合の出力はどうなるか。

A. `item1.equals(item3) : false` / `item1.name.equals(item3.name) : true`

B. `item1.equals(item3) : true` / `item1.name.equals(item3.name) : true`

C. `item1.equals(item3) : true` / `item1.name.equals(item3.name) : false`

D. `item1.equals(item3) : false` / `item1.name.equals(item3.name) : false`

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


**実施記録**

回答：
正解：
迷ったポイント：

---
