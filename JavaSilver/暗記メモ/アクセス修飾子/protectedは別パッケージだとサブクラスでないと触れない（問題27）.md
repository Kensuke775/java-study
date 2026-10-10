# protectedは「別パッケージ」の時だけサブクラスが必要（問題27）

## 検証コード：別パッケージ・非サブクラス → コンパイルエラー

```java
// other/Book.java
package other;
public class Book {
    private String isbn;
    public void setIsbn(String isbn) { this.isbn = isbn; }
    protected void printInfo() { System.out.println(isbn); }
}

// ex27/StoryBook.java
package ex27;
import other.Book;
public class StoryBook extends Book {}

// ex27/Main.java
package ex27;
public class Main {
    public static void main(String[] args) {
        StoryBook story = new StoryBook();
        story.setIsbn("xxx-x-xxxxxx-xx-x");
        story.printInfo();   // ← ここでコンパイルエラー
    }
}
```
```
エラー: printInfo()はBookでprotectedアクセスされます
        story.printInfo();
             ^
```
→ 検証済み。答えは「コンパイルエラーが発生する」。

## 検証コード：同じパッケージ・非サブクラス → 問題なく成功

```java
package other;
public class MainSamePkg {
    public static void main(String[] args) {
        Book b = new Book();
        b.setIsbn("same-package-test");
        b.printInfo();   // ← extends していないのに普通に呼べる
    }
}
```
→ `same-package-test`と表示され、コンパイル・実行とも成功。検証済み。

## なぜこうなるのか

`protected`のアクセス可否は「同じパッケージか、別パッケージか」で完全に場合分けされる。

| アクセスする側の状況 | `protected`メンバーに触れるか |
|---|---|
| 宣言クラスと**同じパッケージ**（サブクラスでなくてもOK） | ✅ 触れる |
| **別パッケージ**、かつそのクラスの**サブクラス**（自分自身の型・サブタイプ経由でのみ） | ✅ 触れる |
| **別パッケージ**、かつサブクラスでもない（ただの第三者） | ❌ 触れない |

問題27では、`Main`は`StoryBook`と同じ`ex27`パッケージにいるが、`printInfo()`の宣言元である`Book`は別パッケージ`other`。`Main`自身は`Book`のサブクラスではない（`StoryBook`がサブクラスなだけ）ので、「同じパッケージにいる別クラス経由」では救われず、アクセス不可になる。

`StoryBook`自身（`Book`のサブクラス）なら`ex27`パッケージ内で`printInfo()`を呼び出せるが、`Main`はただ`StoryBook`のインスタンスを外から使っているだけの無関係な第三者クラスなので、`protected`の壁に阻まれる。

## 無名（デフォルト）パッケージでいつも触れていた理由

無名パッケージに属するクラス同士は全部「同じパッケージ」扱いになる。だから`extends`していなくても`protected`メンバーに素通しでアクセスできていた（表の1段目のケース）。パッケージを分けた途端、この特権が消える。

## もし`Book`が`other`ではなく`ex27`パッケージにいたら

```java
package samepkg;
public class Book2 {
    private String isbn;
    public void setIsbn(String isbn) { this.isbn = isbn; }
    protected void printInfo() { System.out.println(isbn); }
}

package samepkg;
public class Main2 {
    public static void main(String[] args) {
        Book2 b = new Book2();   // extendsなし、ただのBook2そのもの
        b.setIsbn("same-pkg-no-extends");
        b.printInfo();
    }
}
```
→ `same-pkg-no-extends`と表示され、コンパイル・実行とも成功。検証済み。

`Book`と`Main`が同じパッケージにいれば、`Main`は`Book`を`extends`すらしていなくても、`protected`メンバーに普通にアクセスできる。「同じパッケージにいる」という事実だけで十分で、継承関係は一切不要。

## 「継承する権利」は継承した本人にしか使えない（第三者には及ばない）

問題27の核心はここ。`StoryBook`が別パッケージの`Book`を`extends`しているという事実は、`StoryBook`**自身のコードの中でしか**効力を持たない。`Main`は`StoryBook`のインスタンスを外から使っているだけの第三者であり、`Main`自身は`Book`を`extends`していない。

だから「どこかにサブクラス（`StoryBook`）が存在する」ことは、それを外から使う`Main`側には一切恩恵を与えない。`protected`が別パッケージ相手に開放されるのは、あくまで**アクセスしているコード自身がサブクラスである場合**に限られる。「サブクラスが存在する」と「自分がサブクラスである」は別問題、という点を混同しないこと。

## まとめ

- `protected`だから常に`extends`が必要、という理解は誤り
- 正しくは「**別パッケージ**の場合に限り」サブクラスであることが必要
- 同じパッケージなら、サブクラスでなくても普通にアクセスできる（`Book`が`ex27`にいれば`Main`は`extends`不要）
- 「サブクラスと同じパッケージにいる」＝「サブクラスである」ではない（`Main`が引っかかったのはここ）
- 継承した権利は継承した本人（`StoryBook`）にしか使えず、それを外から使う第三者（`Main`）には及ばない

関連：[[クラス自体とメンバーの可視性は別（問題26）]]
