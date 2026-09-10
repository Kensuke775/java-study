# mock1 高負荷復習(問題1〜30・要点のみ)

# mock1 復習用テーブル(1〜60)

○＝一発正解、×＝誤答。「△メモ」列は空欄にしてあるので、正解した問題でも「実は迷った」「たまたま合ってた」ものがあれば、自分の言葉でそこに書き込んでください（例：「△ 迷った」「△ 消去法」など）。


| 問題  | 判定  | 回答      | 正解      | △メモ(自分で追記)                                                                                           |
| --- | --- | ------- | ------- | ---------------------------------------------------------------------------------------------------- |
| 1   | △   | C       | C       | """ java """ で躓く\nが入ってる                                                                              |
| 2   | ×   | D       | A       | public static void main()...もstaticメソッドであったことを分からなかった。対策としてはstaticの呼び出しからはインスタンスメソッドは呼べないため、そこを重視する。 |
| 3   | ×   | E,F,H   | C,E,H   | ジェネリクスがラッパーであることを忘れており、プリミティブ型を見分けられなかった。                                                            |
| 4   | ○   | A,D     | A,D     |                                                                                                      |
| 5   | ○   | D       | D       |                                                                                                      |
| 6   | ×   | A       | E       |                                                                                                      |
| 7   | ○   | E       | E       |                                                                                                      |
| 8   | ×   | B       | G       |                                                                                                      |
| 9   | ○   | A,C,E,H | A,C,E,H |                                                                                                      |
| 10  | ×   | A       | F       |                                                                                                      |
| 11  | ×   | D,E,F   | A,E,F   |                                                                                                      |
| 12  | ○   | D       | D       |                                                                                                      |
| 13  | ○   | B,E     | B,E     |                                                                                                      |
| 14  | ×   | C       | D       |                                                                                                      |
| 15  | ×   | E,G     | C,G     |                                                                                                      |
| 16  | ×   | C       | G       |                                                                                                      |
| 17  | ○   | C,E     | C,E     |                                                                                                      |
| 18  | ×   | G       | B       |                                                                                                      |
| 19  | ×   | A,D     | B,D     |                                                                                                      |
| 20  | ○   | E       | E       |                                                                                                      |
| 21  | ×   | E       | B       |                                                                                                      |
| 22  | ○   | C       | C       |                                                                                                      |
| 23  | ○   | B       | B       |                                                                                                      |
| 24  | ○   | F       | F       |                                                                                                      |
| 25  | ×   | E       | C,E     |                                                                                                      |
| 26  | ×   | A,B,E   | A,E,F   |                                                                                                      |
| 27  | ×   | E       | B       |                                                                                                      |
| 28  | ○   | C       | C       |                                                                                                      |
| 29  | ○   | D       | D       |                                                                                                      |
| 30  | ×   | A,E     | A,C     |                                                                                                      |
| 31  | ○   | A       | A       |                                                                                                      |
| 32  | ×   | C       | F       |                                                                                                      |
| 33  | ×   | C,E     | C,F     |                                                                                                      |
| 34  | ○   | B       | B       |                                                                                                      |
| 35  | ○   | A,E     | A,E     |                                                                                                      |
| 36  | ×   | F       | G       |                                                                                                      |
| 37  | ○   | A,B,C   | A,B,C   |                                                                                                      |
| 38  | ×   | E       | D       |                                                                                                      |
| 39  | ×   | B       | E       |                                                                                                      |
| 40  | ×   | A       | E       |                                                                                                      |
| 41  | ○   | D,E     | D,E     |                                                                                                      |
| 42  | ×   | E,F     | A,F     |                                                                                                      |
| 43  | ×   | C       | A       |                                                                                                      |
| 44  | ×   | A       | F       |                                                                                                      |
| 45  | ×   | A,C,E   | A,C,D   |                                                                                                      |
| 46  | ○   | C       | C       |                                                                                                      |
| 47  | ○   | E       | E       |                                                                                                      |
| 48  | ×   | A       | C       |                                                                                                      |
| 49  | ×   | F       | D       |                                                                                                      |
| 50  | ○   | A       | A       |                                                                                                      |
| 51  | ×   | C       | G       |                                                                                                      |
| 52  | ×   | C,E,G   | B,E,G   |                                                                                                      |
| 53  | ×   | A,D,E   | C,D,F   |                                                                                                      |
| 54  | ×   | F       | E       |                                                                                                      |
| 55  | ○   | C,F     | C,F     |                                                                                                      |
| 56  | ○   | D       | D       |                                                                                                      |
| 57  | ○   | H       | H       |                                                                                                      |
| 58  | ○   | B       | B       |                                                                                                      |
| 59  | ×   | E,G     | C,F     |                                                                                                      |
| 60  | ○   | G       | G       |                                                                                                      |




**内訳**：○ 27問 / × 33問（27/60 = 45%）

1回目の模試(問題1〜30)で間違えた16問（問題2, 3, 6, 8, 10, 11, 14, 15, 16, 18, 19, 21, 25, 26, 27, 30）と、会話中に深掘りした発展知識だけをまとめたもの。正解した問題は基本的に省略。全問`javac`/`java`で検証済み、公式解答・解説の要点も反映。

## 目次

- [問題2](#m2)
- [問題3](#m3)
- [問題6](#m6)
- [問題8](#m8)
- [問題10](#m10)
- [問題11](#m11)
- [問題14](#m14)
- [問題15](#m15)
- [問題16](#m16)
- [問題18](#m18)
- [問題19](#m19)
- [問題21](#m21)
- [問題25](#m25)
- [問題26](#m26)
- [問題27](#m27)
- [問題30](#m30)



## 問題2

```java
public class Test {
    public static void main(String[] args) {
        System.out.println(method(args));         // (A)
    }
    // insert code here
}
```

（A）の行を実行するために5行目に記述するメソッド宣言として正しいものはどれですか。（1つ選択）

A. `static int method(String... s) { return s.length;}`
B. `int method(String... s) { return s.length;}`
C. `private static void method(String... s) {}`
D. `public void method(String... s) {}`
E. `protected String method() { return "hi";}`
F. `static String method() { return "hi";}`

**正解：A**（あなたの回答：D）

### 復習ポイント

- `static`な`main()`からは、`static`なメソッドしか直接呼び出せない。B・D・Eはインスタンスメソッドなので、`new Test().method(args)`のようにインスタンス化しないと呼べない（`main`から直接は呼べずコンパイルエラー）。
- Cは戻り値が`void`なので、`println(...)`の引数として使えない（`println`は何か値を受け取る必要がある）。
- Fは`method()`が引数無しの宣言で、呼び出し側は`method(args)`と引数ありで呼んでいるため、シグネチャが一致せず呼び出せない。
- 残るAだけが「`static`・戻り値あり・可変長引数`String...`で`args`を受け取れる」という3条件を全部満たす。

---



## 問題3

ジェネリクスに関する記述のうち、コンパイルが成功するものはどれですか。（3つ選択）

A. `ArrayList<Integer> list = new ArrayList<>();`
B. `ArrayList<String> list = new ArrayList<String>();`
C. `ArrayList<double> list = new ArrayList<>();`
D. `List<Item> list = new ArrayList<>();`
E. `List<String> list = new List<String>();`
F. `List list = new ArrayList();`
G. `List<Integer> list = List.of(1, 2, 3);`
H. `ArrayList<Integer> list = Arrays.asList("1", "2", "3");`

**正解：C、E、Hがコンパイルエラー**（つまり正解はA、B、D、F、G）（あなたの回答：D、E、F → Aを見落とし、Cを誤って選択）

### 復習ポイント

- **C**：ジェネリクスの型引数にはプリミティブ型（`double`）を直接書けない。`Double`のようなラッパークラスにする必要がある（`javac`検証済み：「予期しない型」エラー）。
- **E**：`List`はインタフェースなので`new List<String>()`のように直接インスタンス化できない（「Listはabstractです。インスタンスを生成することはできません」）。
- **H**：`Arrays.asList()`の戻り値の型は`List<T>`であって`ArrayList<T>`ではない。しかも中身が`String`なので推論される型引数も`Integer`ではなく`String`になる（二重に不一致）。
- A・B・D・F・Gはどれも型引数と生成式の対応が正しく合っている（Fはraw型で警告は出るがエラーではない）。



### 発展：List / ArrayList / Arrays.asList / List.of の関係整理（追加で確認した内容）

この問題をきっかけに、もう少し深く確認した内容を追記。

**3つは別物**

- `List`：インタフェース（契約）。`new List<>()`のように直接インスタンス化できない。
- `ArrayList`：`List`を実装した具体的なクラスの1つ。`new ArrayList<>()`でインスタンスを作れる。
- `Arrays`：`ArrayList`とは無関係の別のユーティリティクラス。`Arrays.asList()`という静的メソッドを持つだけで、継承関係は一切ない。

`List`**型の変数には「**`List`**を満たすもの」なら何でも入る**

```java
List<String> list1 = new ArrayList<>(Arrays.asList("a", "b")); // ArrayListのインスタンス
List<String> list2 = Arrays.asList("a", "b");                   // Arrays内部の別クラスのインスタンス
List<String> list3 = List.of("a", "b");                          // また別の内部クラスのインスタンス
```

**中身を変更できるかどうかは生成方法によって全く違う**（`java`で検証済み）

```java
List<Integer> a = Arrays.asList(1, 2, 3);
a.set(0, 100);  // OK（置き換えは可能）
a.add(4);       // UnsupportedOperationException（サイズ変更は不可、固定サイズ）

List<Integer> b = List.of(1, 2, 3);
b.set(0, 100);  // UnsupportedOperationException（完全に不変）
b.add(4);       // UnsupportedOperationException
```

`new ArrayList<>(既存のコレクション)`というコンストラクタで包むと、中身を1つずつコピーした**全く新しい、普通に可変な`ArrayList`**が作られるので、元の制限は一切引き継がれず自由に`add`/`remove`/`set`できるようになる。

**ジェネリクスには配列のような共変性(covariance)が無い**（`javac`で検証済み）

```java
String[] strArray = {"a", "b"};
Object[] objArray = strArray;  // OK（配列は共変）

List<String> strList = new ArrayList<>();
List<Object> objList = strList;  // コンパイルエラー（ジェネリクスは非共変）
// 不適合な型: ArrayList<String>をList<Object>に変換できません
```

`String`が`Object`の一種であることと、`List<String>`が`List<Object>`として扱えることは**別の話**。配列がこれを許して`ArrayStoreException`という実行時エラーの温床になった反省から、ジェネリクスは意図的に「型引数が違えば無関係の別の型」という厳しいルールを採用している。

`List<Integer> list1 = new ArrayList<>();` **と** `ArrayList<Integer> list2 = new ArrayList<>();` **は実体は同じでも「見え方」が違う**（`javac`/`java`で検証済み）

```java
list1.getClass() == list2.getClass()  // true（実体はどちらも同じArrayList）
```

実行時のオブジェクトは同じでも、**変数として宣言した型（左辺の型）によって、呼び出せるメソッドの範囲が変わる**。将来の実装差し替えのしやすさから、特に理由が無い限り`List`型で宣言するのがJavaのお作法（インタフェースに対してプログラミングする）。

---



## 問題6

```java
class FirstExeption extends Exception {}
class SubFirstException extends FirstExeption {}
class SecondException extends RuntimeException {}
public class Main {
    public static void main(String[] args) {
        try {
            execute(5 % 2);
        } catch (SubFirstException | SecondException e) {   // (A)
            System.out.println("SubFirst | Second");
        } catch (FirstExeption e) {                         // (B)
            System.out.println("First");
        } catch (Exception e) {
            System.out.println("Ex");
        }
    }
    public static void execute(int value) throws Exception {
        switch (value) {
            case 1 -> throw new FirstExeption();
            case 2 -> throw new SubFirstException();
            case 3 -> throw new SecondException();
            default -> throw new RuntimeException();        // (C)
        }
    }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. Aでコンパイルエラーが発生する
B. Bでコンパイルエラーが発生する
C. Cでコンパイルエラーが発生する
D. 正常にコンパイル、実行でき、`SubFirst | Second`が出力される
E. 正常にコンパイル、実行でき、`First`が出力される
F. 正常にコンパイル、実行でき、`Ex`が出力される

**正解：E**（あなたの回答：A）

### 復習ポイント

- `execute(5 % 2)` = `execute(1)`なので、実際に投げられるのは`new FirstExeption()`本体（`SubFirstException`ではない）。
- `catch (SubFirstException | SecondException e)`（A）が拾えるのは「`SubFirstException`かそのサブタイプ」または「`SecondException`かそのサブタイプ」だけ。`FirstExeption`はこれらの**親**なので対象外——ここが今回の勘違いポイント。「`SubFirstException`が`Exception`を継承しているから`FirstExeption`も拾われるはず」という考え方は方向が逆。`catch`のマッチングは「投げられた実際の型から見て、`catch`の型が同じか祖先か」だけで判定される。
- `FirstExeption`にマッチするのは2番目の`catch (FirstExeption e)`（B）で、そこで`"First"`が出力される。
- `javac`/`java`で検証済み：出力は`First`。

---



## 問題8

Test.javaというファイルに以下が書かれています。

```java
public class A {
    public static void main(String... args) {
        System.out.println(0b0100 | 3);
    }
}
```

このプログラムを正しく説明しているものはどれですか。（1つ選択）

A. `>javac Test.java`でコンパイルが成功し、`>java A`を実行すると3が出力される
B. `>javac Test.java`でコンパイルが成功し、`>java A`を実行すると4が出力される
C. `>java Test.java`でプログラムを実行するためには、ソースファイル名をA.javaにする必要がある
D. `>javac Test.java`でコンパイルが成功するためには、クラス名をMainにする必要がある
E. `>java Test.java`でプログラムの実行ができ、falseが出力される
F. `>java Test.java`でプログラムの実行ができるが、何も出力されない
G. 正しい説明はない

**正解：G**（あなたの回答：B）

### 復習ポイント

- ファイル名`Test.java`の中身が`public class A`——名前が不一致。**普通の`javac Test.java`**はこの不一致を許さず、必ずコンパイルエラーになる（A・B・Dはこの時点で誤り）。
- `java Test.java`**（ソースファイルモード）だけ**は名前の不一致が免除される特例があり、リネームせずそのまま実行できて`0b0100 | 3` = `4 | 3` = `7`が出力される（`javac`/`java`で検証済み）。
- Cの「A.javaにリネームする必要がある」は、実際はリネームしなくても動くので誤り。
- E・Fは実行はできるが出力内容の説明が間違っている（`false`でも「何も出力されない」でもなく`7`が出る）。
- 正しい内容（「`java Test.java`で実行でき、`7`が出力される」）を言い当てている選択肢がA〜Fの中に1つも無いため、消去法でG。

---



## 問題10

```java
public class Item {
    private String name;
    void Item() {
        name = "Something";
    }
    public Item(String name) {
        name = name;
    }
    public String toString() {
        return " Item:" + name;
    }
    public static void main(String...args) {
        System.out.print(new Item());
        System.out.println(new Item("Coffee"));
    }
}
```

このプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. `Item:null`が出力される
B. `Item:Something Item:Coffee`が出力される
C. `Item:Something`が出力される
D. `Item:Coffee`が出力される
E. `Item@27fe3806`が出力される
F. コンパイルエラーが発生する

**正解：F**（あなたの回答：A）

### 復習ポイント

- 3〜5行目の`void Item() { ... }`は**コンストラクタではなく、ただのメソッド**（戻り値`void`が付いているため）。コンストラクタは戻り値の型を一切書かない。
- そのため`Item`クラスに実際に存在するコンストラクタは`public Item(String name)`（引数1つ）の**1つだけ**。引数無しの`new Item()`に対応するコンストラクタが存在しない。
- 13行目`new Item()`（引数無し）が、存在しないコンストラクタを呼ぼうとしてコンパイルエラーになる。
- ちなみに`public Item(String name) { name = name; }`も、引数の`name`とフィールドの`name`が同名でシャドーイングされており（`this.name = name;`ではない）実際にはフィールドへの代入になっていない、というバグも含んでいるが、今回はそれ以前にコンパイル自体が通らない。

---



## 問題11

次の記述のうちコンパイルが成功するものはどれですか。（3つ選択）

A. `int[][] a = {{-1, 0, 1}, {'A', 'B', 'C'}};`
B. `boolean b = new Boolean[1][2];`
C. `char[][] c = new char[3][3] {{'1', '2', '3'}, {'A', 'B', 'C'}};`
D. `Double[][] d = {{0.1, 0.1e-2}, {Math.floor(3.14), Math.round(3.14)}};`
E. `char e[][] = new char[1][1]; e[0][0] = (char)100;`
F. `Object[][] f = {{}, {"Java", 17}};`

**正解：A、E、F**（あなたの回答：D、E、F → Aを見落とし、Dを誤って選択）

### 復習ポイント

- **A（正解）**：`char`リテラル（`'A'`など）は暗黙的に`int`に変換されるので、`int[][]`の要素として問題なく使える。
- **B（誤り）**：`new Boolean[1][2]`は`Boolean[][]`型（配列）で、非配列の`boolean`変数には代入できない（型の不一致。前に検証した通り`javac`でエラー）。
- **C（誤り）**：`new char[3][3] {...}`のように、サイズ指定と初期化子`{...}`を同時に書くことはできない（どちらか片方だけ）。
- **D（誤り）**：`Math.round(3.14)`の戻り値は`long`型。`Double[][]`（`Double`はラッパークラス、内部は`double`扱い）に`long`の値をそのまま入れようとすると型が合わずコンパイルエラーになる。
- **E（正解）**：`char e[][] = ...`のように`[]`を変数名側に付ける書き方も有効（Silver頻出パターン）。`(char)100`のキャストで`'d'`が代入される。
- **F（正解）**：`Object[][]`なので、要素数0の配列(`{}`)や、`String`と`Integer`が混在した配列(`{"Java", 17}`)も、すべて`Object`として問題なく扱える。

---



## 問題14

```java
public class Main {
    protected void main(int a) {           // (A)
        final var FLAG = true;
        final int VALUE;                   // (B)
        if (!FLAG) VALUE = 100;            // (C)
        System.out.println(VALUE);         // (D)
    }
    public static void main(String[] args) {
        new Main().main(100);
    }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. Aでコンパイルエラーが発生する
B. Bでコンパイルエラーが発生する
C. Cでコンパイルエラーが発生する
D. Dでコンパイルエラーが発生する
E. 何も出力されない
F. 100が出力される

**正解：D**（あなたの回答：C）

### 復習ポイント

- `final var FLAG = true;`は「`final`＋リテラルでの初期化」なのでコンパイル時定数。`!FLAG`は常に`false`と評価できる、という点までは合っている。
- ただし`if (!FLAG) VALUE = 100;`という**代入を含まないシンプルな条件式**（`!FLAG`）の場合は、コンパイラの確定代入解析が「この条件は常にfalseだ」と認識し、`VALUE`への代入が絶対に起きないと判断する。
- そのため(C)の行自体はエラーにならず、`VALUE`を実際に読み取ろうとする(D)の`println(VALUE)`の行で「変数VALUEは初期化されていない可能性があります」というコンパイルエラーになる（`javac`検証済み）。
- 似た構造の別バージョン（三項演算子の中に代入`flag = true`を混ぜたパターン）だと、代入式が混ざることでコンパイラが定数として認識できなくなり、結果は同じ「(D)の行でエラー」になるが、理由（定数として認識される／されない）が微妙に異なる点に注意。

---



## 問題15

```java
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "8", "11", "17");
        for (var i = 0; i <= list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
            } catch ( [ (1) ] ) {
                System.out.print(e.getMessage());
            } finally {
                System.out.println(" loop " + i + " has finished.");
            }
        }
    }
}
```

例外がスローされることなくプログラムを終了するために（1）に記述するものはどれですか。（2つ選択）

A. `NumberFormatException | RuntimeException e`
B. `NumberFormatException e | StringIndexOutOfBoundsException e`
C. `NumberFormatException | IndexOutOfBoundsException e`
D. `NumberFormatException | StringIndexOutOfBoundsException e`
E. `IndexOutOfBoundsException e`
F. `NumberFormatException e`
G. `Exception e`

**正解：C、G**（あなたの回答：E、G → Cを見落とし、Eを誤って選択）

### 復習ポイント

- `for`文の条件が`i <= list.size()`（`<`ではなく`<=`）なので、リストの要素数を1つ超えたインデックスまでループしようとする → 最後のループで`list.get(i)`が**`IndexOutOfBoundsException`**を投げる。
- また`"Java"`という数字に変換できない文字列があるので、`Integer.parseInt("Java")`は**`NumberFormatException`**を投げる。
- つまり、この2種類の例外の**両方**を確実に拾える`catch`にする必要がある。
- **A（誤り）**：multi-catchの構文では継承関係にあるクラス同士は書けない（`NumberFormatException`は`RuntimeException`のサブクラスなので不可）。
- **B（誤り）**：構文自体が間違っている（変数`e`は最後に1回だけ書く。各型ごとに`e`を書くのは不可）。
- **C（正解）**：`NumberFormatException | IndexOutOfBoundsException e`——両方の例外型を正しくmulti-catchで拾える。
- **D（誤り）**：`StringIndexOutOfBoundsException`は今回のコードでは発生しない例外（`IndexOutOfBoundsException`ではあるが、今回投げられるのはリストの範囲外用の`IndexOutOfBoundsException`であって文字列操作由来のものではない）。
- **E・F（誤り）**：片方の例外しか拾えていない。
- **G（正解）**：`Exception`は両方の例外のスーパークラスなので、まとめて拾える。

---



## 問題16

```java
public class Main {
    void method() {
        var x = "Java SE 17";
        var y = new StringBuilder("Java").append("17");
        var v = x.substring(8);
        var z = y.substring(4,6);
        int i = x.equals(y) ? 1 : v.equals(z) ? 2 : 0;
        System.out.println(i);
    }
    public static void main(String[] args) {
        this.method();
    }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. 0が出力される
B. 1が出力される
C. 2が出力される
D. 5行目のsubstring()の使用方法が適切でないためコンパイルエラーが発生する
E. 6行目のsubstring()の使用方法が適切でないためコンパイルエラーが発生する
F. ローカル変数iが初期化されない可能性があるためコンパイルエラーが発生する
G. method()の呼び出し方法が適切でないためコンパイルエラーが発生する

**正解：G**（あなたの回答：C）

### 復習ポイント

- `main`は`static`メソッド。その中で`this.method()`と書いているが、`this`は「インスタンスそのもの」を指すキーワードなので、**インスタンスが存在しない**`static`**メソッドの中では使用できない**。
- これは(問題18でも出てきた)「`this`はインスタンスメンバ専用、staticコンテキストでは使えない」というルールそのもの。
- 仮に11行目を`new Main().method();`に直せば、正しくインスタンス化されて`method()`が呼び出せる。その場合の中身の計算は、`x.substring(8)`→`"17"`、`y.substring(4,6)`→`"17"`が返るので`v.equals(z)`が`true`になり、`i`は`2`が出力される（が、今回は呼び出し方自体がエラーなのでそこまで到達しない）。

---



## 問題18

```java
public class Book {
    private static final int id = 17;
    String title;
    { title = "Java Silver"; }
}
class Main {
    public static void main(String... args) {
        Book book = new Book();
        System.out.println( [ (1) ] );
    }
}
```

何らかの出力を行うために（1）に記述できるものはどれですか。（1つ選択）

A. `book.id`
B. `book.title`
C. `Book.id`
D. `this.title`
E. `this(id)`
F. `title()`
G. この中にはない

**正解：B**（あなたの回答：G）

### 復習ポイント

- `id`は`private static final`。`private`が付いているので、別クラスの`Main`からは`book.id`（A）でも`Book.id`（C）でもアクセスできない。
- `title`にはアクセス修飾子が付いていない（パッケージプライベート）。`Main`クラスは`Book`と同じファイル＝同じパッケージなので、`title`にはアクセス可能。インスタンスフィールドは参照変数（`book`）を介してアクセスするので`book.title`（B）が正しい。
- `title`はインスタンス初期化ブロック（`{ title = "Java Silver"; }`）で`"Java Silver"`に初期化されているので、`book.title`は`"Java Silver"`を返す。
- `this`（D）は`Book`クラス自身の中でしか使えないキーワードで、`Main`クラスの中では使用できない。
- `this(id)`（E）はコンストラクタ内で使う別コンストラクタ呼び出しの構文で今回は無関係。`title()`（F）はメソッド呼び出しの形だが、`Book`にそんなメソッドは定義されていない。

---



## 問題19

```java
int c = 'c';
String text = "";
switch (c) {
   case 97:
   case 98:
        text = "a | b | "; break;
   case 99:
   case 100:
        text = "c | d | "; break;
   case 101:
        text = "e | ";         break;
   default:
        text = "the others";
}
```

上記と同じ結果になるものはどれですか。（2つ選択）

A.

```java
String text = switch (c) {
    case 97, case 98: yield "a | b | ";
    case 99, case 100: yield "c | d | ";
    case 101: yield "e | ";
    default: yield "the others";
}
```

B.

```java
String text = switch (c) {
    case 97, 98 -> "a | b | ";
    case 99, 100 -> "c | d | ";
    case 101 -> "e | ";
    default -> "the others";
};
```

C.

```java
String text = switch (c) {
    case 97, 98 -> { yield "a | b | "; }
    case 99, 100 -> "c | d | ";
    case 101 -> "e | ";
};
```

D.

```java
String text = switch (c) {
    case 97, 98: yield "a | b | ";
    case 99, 100: yield "c | d | ";
    case 101: yield "e | ";
    default: yield "the others";
};
```

E.

```java
String text = "";
switch (c) {
    case 97, 98 -> text = "a | b | ";
    case 99, 100 -> text = "c | d | ";
    case 101 -> text = "e | ";
    default : { text = "the others"; }
}
```

**正解：B、D**（あなたの回答：A、D → Aを誤って選択）

### 復習ポイント

- **A（誤り）**：`case 97, case 98:`という書き方が構文間違い（`case`の中でさらに`case`と書いてしまっている。正しくは`case 97, 98:`）。さらにswitch式は最後に`;`が必要だが付いていない。
- **B（正解）**：`->`形式で全ケース（`default`含む）を網羅している正しいswitch式。
- **C（誤り）**：`default`が無い。switch式は必ず全ケースを網羅する必要があり、`default`の省略は許されない。
- **D（正解）**：`:`とyieldの組み合わせのswitch式。Aと似ているが構文が正しい（`case 97, 98:`と正しく書かれている）。
- **E（誤り）**：switch**文**なのに`case`の中で`->`を使っている。1つのswitchの中で`:`形式と`->`形式は混在できない。

---



## 問題21

```java
public class Main {
    public static void main(String... args) {
        Top[] array = { new Top(), new Bottom()};
        for (Top t: array) {
            t.showInfo();
            t.print();
            System.out.print(t.value + ": ");
        }
    }
}
class Top {
    int value = 10;
    String name = " top ";
    static void showInfo() { System.out.print("T"); }
    void print() { System.out.print(name); }
}
class Bottom extends Top {
    int value = 90;
    String name = " bottom ";
    static void showInfo() { System.out.print("B"); }
    void print() { System.out.print(name); }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. `T top 10: B bottom 90:` が出力される
B. `T top 10: T bottom 10:` が出力される
C. `T top 10: B bottom 10:` が出力される
D. `T top 10: B top 10:` が出力される
E. `T top 10: T top 90:` が出力される
F. `ClassCastException`がスローされる
G. `ArrayIndexOutOfBoundsException`がスローされる

**正解：B**（あなたの回答：E）

### 復習ポイント

- `for (Top t: array)`の`t`は**宣言型が常に**`Top`。実際の中身が1回目`Top`、2回目`Bottom`でも変数の型自体は変わらない。
- `t.showInfo()`（**static**メソッド）：staticメソッドの呼び出し解決は宣言型（`Top`）だけを見る。オーバーライドではなく隠蔽の対象なので、2回とも`T`が出力される。
- `t.print()`（インスタンスメソッド）：普通のオーバーライドで動的ディスパッチが効く。1回目は`Top`の`print()`（`" top "`）、2回目は`Bottom`の`print()`（`" bottom "`）。
- `t.value`（フィールド）：**フィールドには動的ディスパッチが効かない**。常に宣言型（`Top`）のフィールドが参照されるので、2回とも`Top.value = 10`が使われる（`Bottom.value = 90`は使われない）。
- まとめ：「メソッドは実際の型（動的）、フィールドは宣言した型（静的）」という違いがこの問題の核心。

---



## 問題25

```java
public class Main {
    public static void main(String... args) {
        System.out.println( [ (1) ] );
    }
}
class MyClass {
    static double a;
    private int b;
    static { a = 100.0; }
    private static double getA() { return a; }
    int getB() { return b; }
    public String toString() { return "MyClass:" + a + "," + b; }
}
```

`100.0:0`と出力するために（1）に記述できるものはどれですか。（2つ選択）

A. `MyClass.a + ":" + MyClass.b`
B. `MyClass.a + ":" + new MyClass().b`
C. `MyClass.a + ":" + new MyClass().getB()`
D. `new MyClass()`
E. `new MyClass().a + ":" + new MyClass().getB()`
F. `new MyClass().getA() + ":" + new MyClass().getB()`

**正解：C、E**（あなたの回答：A、C、E → Aを誤って選択）

### 復習ポイント

- `a`は`static`フィールドなので、クラス名でアクセスする`MyClass.a`（C）でも、インスタンス経由の`new MyClass().a`（E、staticメンバをインスタンス経由でアクセスするのは許可されている）でもどちらも取得できる。
- `b`は**`private`のインスタンス変数**。`Main`クラスから直接`MyClass.b`や`new MyClass().b`のように変数名でアクセスすることはできない（A・Bが誤りな理由）。取得するには`getB()`（`private`が付いていないので呼べる）を使う必要がある。
- `getA()`は`private`なので、`Main`クラスから`new MyClass().getA()`のように呼ぶことはできない（Fが誤りな理由）。
- Dの`new MyClass()`はそのまま`println`に渡すと`toString()`が自動で呼ばれ`"MyClass:100.0,0"`が出力される——`"100.0:0"`とはフォーマットが異なるので誤り。
- 正しいのはC・E：`static`メンバへのアクセス方法（クラス名 or インスタンス経由）はどちらでもよいが、`private`なインスタンス変数`b`の取得だけは必ず`getB()`を経由する必要がある、という点が今回の核心。

---



## 問題26

```java
class InvalidDataException extends Exception {
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
public class Main {
    public static void main(String[] args) {
        String[] text = {null, "17", "Duke"};
        for (String s : text) {
            try {
                if(validate(s)) System.out.println(s);       // (A)
            } catch (Exception e) {                          // (B)
                System.out.println(e.getCause());
            }
        }
    }
    public static boolean validate(String s) throws Exception {
        try {
            char c = s.charAt(0);
            int a = Integer.parseInt(s);
        } catch(NullPointerException | NumberFormatException e) {
            throw new InvalidDataException(e.getMessage(), e); // (C)
        }
        return true;
    }
}
```

次のプログラムを正しく説明しているものはどれですか。（3つ選択）

A. Aのvalidate()は3回呼ばれるが、11行目からの出力は1度だけ行われる
B. Bのcatchブロックに制御が移るとプログラムが終了するため、13行目の出力は1度だけ行われる
C. Cは例外オブジェクトの生成方法が適切でないため、コンパイルエラーが発生する
D. プログラムを実行すると、`java.lang.Exception`が出力される
E. プログラムを実行すると、`java.lang.NullPointerException`が出力される
F. プログラムを実行すると、`java.lang.NumberFormatException`が出力される
G. プログラムを実行すると、`InvalidDataException`が出力される

**正解：A、E、F**（あなたの回答：A、B、E → Bを誤って選択、Fを見落とし）

### 復習ポイント

- `text`配列は`{null, "17", "Duke"}`の3要素。`validate()`は3回呼ばれる。
- 1つ目（`null`）：`s.charAt(0)`で`NullPointerException`
- 2つ目（`"17"`）：`charAt(0)`も`parseInt("17")`も成功 → 例外なし → `validate()`が`true`を返し、`11行目`で`"17"`が出力される（**これが「1度だけ行われる」出力**）
- 3つ目（`"Duke"`）：`charAt(0)`は成功するが`Integer.parseInt("Duke")`で`NumberFormatException`
- どちらの例外も21行目の`catch(NullPointerException | NumberFormatException e)`でキャッチされ、`InvalidDataException(e.getMessage(), e)`として**再スロー**される（`e`が`cause`として渡される）。
- `main`側の`catch (Exception e)`は、この`InvalidDataException`を受け取り、`e.getCause()`（＝元の`NullPointerException`または`NumberFormatException`のインスタンス）を`println`する。オブジェクトを`println`すると自動で`toString()`が呼ばれるので、`java.lang.NullPointerException: ...`・`java.lang.NumberFormatException: ...`という形式で出力される（E・Fが正解）。
- Bが誤りな理由：`catch`ブロックに制御が移ってもプログラムは終了しない。`for`ループは3要素分続くので、`catch`の処理（13行目）は該当する2回とも実行される。
- Cが誤りな理由：`InvalidDataException(String message, Throwable cause)`というコンストラクタのシグネチャに対して`e.getMessage()`（String）と`e`（Throwable）を正しく渡しており、コンパイルエラーにはならない。

---



## 問題27

```java
String s1 = null;
String s2 = "";
String text = """
                                    """;
System.out.print(text != s1);
System.out.print(text == s2);
System.out.print(!(s1 == s2));
```

次のプログラム（抜粋）をコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. `falsefalsefalse`が出力される
B. `truetruetrue`が出力される
C. `truefalsetrue`が出力される
D. `falsetruetrue`が出力される
E. `falsetruefalse`が出力される

**正解：B**（あなたの回答：E）

### 復習ポイント

- テキストブロック（`"""..."""`）は、中身が空白だけの行しか無い場合、余分な空白が取り除かれた結果**中身が空の文字列**（`""`と同じ）になる。
- `text != s1`：`text`は`null`ではない（空文字列という実体があるオブジェクト）ので、`s1`（`null`）とは当然異なる → `true`
- `text == s2`：どちらも中身が空文字列で、文字列リテラルの`""`は文字列プールにインターンされているため、同じオブジェクトを指す → `true`
- `!(s1 == s2)`：`s1`（`null`）と`s2`（`""`という実体）は別物なので`s1 == s2`は`false`。それを`!`で反転して`true`
- 結果は`true` `true` `true` → `truetruetrue`（B）。`javac`/`java`で検証済み。
- テキストブロックが「空白しかない中身」の場合に空文字列と等価になる、という挙動を知らないと引っかかりやすい問題。

---



## 問題30

```java
double[][] dArr = {{0.1, 0.2, 0.3},{4, 5, 6}};
for( [      (1)     ] ) {
       for( [     (2)   ] ) {
           System.out.print(d + " ");
       }
}
```

`0.1 0.2 0.3 4.0 5.0 6.0`と出力するために（1）、（2）に記述できる組み合わせはどれですか。（2つ選択）

A. (1) `double[] arr : dArr`　(2) `double d : arr`
B. (1) `double d : arr`　(2) `double arr : dArr[]`
C. (1) `var x : dArr`　(2) `var d : x`
D. (1) `var dArr : double[]`　(2) `var d : dArr[]`
E. (1) `int i = 0; i < dArr.length; i++`　(2) `int j = 0; j < dArr[i].length; j++`
F. (1) `int i = 0; i < dArr.size(); i++`　(2) `int j = 0; j < dArr[i]; j++`

**正解：A、C**（あなたの回答：A、E → Cを見落とし、Eを誤って選択）

### 復習ポイント

- 出力コード（`System.out.print(d + " ")`）を見ると、内側のループ変数は`d`という**変数名**で参照されている。これは拡張for文（`for (型 変数名 : 配列)`）でしか実現できない書き方——通常のfor文なら`dArr[i][j]`のように添字でアクセスするはずで、変数名`d`は出てこない。よってこの時点でE・Fは除外できる。
- 2次元配列`double[][]`を拡張forで回す場合、外側（1）は「`double[]`型（1次元配列）を受け取る変数」、内側（2）は「`double`型（要素そのもの）を受け取る変数」という対応関係。
- **A**：`(1) double[] arr : dArr`（外側：1次元配列を受け取る）、`(2) double d : arr`（内側：その要素を受け取る）→ 正しい対応
- **B（誤り）**：(1)と(2)の役割が逆になっている（`(1)`がいきなり`double d`で要素を受けようとしている）
- **C**：`var`を使っても同じ構造なら成立する（`var x`は`double[]`、`var d`は`double`と推論される）→ 正解
- **D（誤り）**：`:`の右側は必ず「参照する配列変数名」であり、`dArr[]`のように`[]`を付けて書くことはできない
- 「拡張forの`:`の右側には常に配列（またはIterable）の変数名だけを書く、型や添字表記は書けない」という点がE・F・Dを消去する決め手。

---



## 高負荷問題（List / ArrayList / Arrays.asList / List.of の関係整理より）

問題3の発展内容（ジェネリクスの非共変性、`Arrays.asList()`の戻り値型、プリミティブ型引数の禁止）を踏まえた出題。次の記述のうち、**コンパイルエラーになるものを3つ**選んでください。

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));   // A
        List<Object> list2 = new ArrayList<String>();                    // B
        ArrayList<Integer> list3 = Arrays.asList(1, 2, 3);                // C
        List<Integer> list4 = List.of(1, 2, 3);                            // D
        List<double> list5 = new ArrayList<>();                           // E
        List<String> list6 = new ArrayList<>(List.of("a", "b"));          // F
        List<String> list7 = Arrays.asList("a", "b");                     // G
    }
}
```

A. (A)の行  
B. (B)の行  
C. (C)の行  
D. (D)の行  
E. (E)の行  
F. (F)の行  
G. (G)の行

**実施記録**

回答：
正解：
迷ったポイント：

---

