# import static

## 意味

`import static パッケージ.クラス.メンバー名;`は、「**あるクラスのstaticメンバー（メソッドやフィールド）を、クラス名を付けずに直接呼べるようにする**」構文。

```java
import static ex.Main.main;
// これ以降、このファイルの中では main(...) と書けば ex.Main.main(...) を指す
```

## 検証：書いても何もしないケース（問題59・選択肢D）

```java
package ex.a;
import static ex.Main.main;
public class Foo {}
```

このimport文自体は**構文的には合法**でコンパイルも通るが、`Foo`の中で実際に`main(...)`を呼び出すコードが無ければ、**書いても何の効果もない「死んだ記述」**になる。

`Foo`や`Bar`が単体でコンパイルされるために、`Main`の`main`メソッドをimportする必要は全く無い（`Foo`/`Bar`は`Main`に依存していない、ただの空クラス）。「〜する必要がある」という主張自体が架空のルールで、もっともらしい構文を持ち出しているだけの誤答選択肢だった。

## ポイント

- `import static`という機能自体は実在する（`Math`クラスの`import static java.lang.Math.*;`で`sqrt(...)`のように書けるようにする、などが典型例）
- ただし「このimportが無いとコンパイルできない」という主張が出てきたら要注意。**実際に使うコードが無ければ、importの有無自体はコンパイルの成否に一切影響しない**
