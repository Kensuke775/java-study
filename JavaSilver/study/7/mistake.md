# 第7章 ミステイク集（教科書原本7-1〜7-16の誤答問題）

教科書の章末問題（原本7-1〜7-16）を解いた際に間違えた問題を保存しておく場所。詳細な採点履歴は[problems_check_sheet.md](problems_check_sheet.md)を参照。

## 目次

- [問題3](#m3)
- [問題5](#m5)
- [問題16](#m16)

<a id="m3"></a>
## 問題3

```java
public class Main {
    public static void main(String[] args) {
        String[] values = {"x", "y", "z"};
        for (int i = 0; i <= 3; i++) {
             System.out.print(values[i]);
        }
    }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（2つ選択）

A. `RuntimeException`がスローされる
B. `NullPointerException`がスローされる
C. `ArrayIndexOutOfBoundsException`がスローされる
D. `xyz`が出力される
E. `xyznull`が出力される

**正解：C, D**

- 2026-08-25時点：回答`C,D` ✓
- 2026-09-07時点：回答`C` ✗（Dを選び忘れ。複数選択と気づいていなかった＝集中不足が原因、内容自体の理解は本人曰く問題なし）

### 復習ポイント

`values.length`は3（添字0,1,2が有効）。ループは`i=0,1,2,3`まで回ろうとする。

- `i=0,1,2`で`x`,`y`,`z`が順に`print`（改行なし）される → まず`xyz`が出力される（D）
- `i=3`で`values[3]`にアクセスした瞬間、`ArrayIndexOutOfBoundsException`がスローされてプログラムが異常終了する（C）

`javac`/`java`で検証済み：`xyz`が出力された直後に`Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3`。

**迷ったポイント**：2つ選択の設問だと気づかず1つしか選ばなかった。設問の「（2つ選択）」の指示を見落とさないこと。

<a id="m5"></a>
## 問題5

```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + ":" + a + ":" + b);
        }
    }
}
```

次のプログラムをコンパイル、実行するとどのような結果になりますか。（1つ選択）

A. `/ by zero` が出力される
B. `10:0` が出力される
C. `/ by zero:10:0` が出力される
D. `java.lang.ArithmeticException: / by zero:10:0` が出力される
E. コンパイルエラーが発生する

**正解：E**

- 2026-08-25時点：回答`D` ✗
- 2026-09-07時点：回答`D` ✗（2回とも同じ間違いで、まだ内容自体を克服できていない）

### 復習ポイント

**変数`a`と`b`は`try`ブロックの中で宣言されているため、スコープ（有効範囲）はその`try`ブロックの中だけ。** `catch`ブロックは別のブロックなので、`a`・`b`にはアクセスできない。

`javac`で検証済み：

```
Main.java:7: エラー: シンボルを見つけられません
            System.out.println(e.getMessage() + ":" + a + ":" + b);
                                                      ^
  シンボル:   変数 a
```

`ArithmeticException`が実際に発生するかどうか（ランタイムの話）以前に、**この`catch`ブロックのコード自体が変数のスコープ違反でコンパイルエラーになる**、というのが今回の引っかけ。

**迷ったポイント**：`try`本体で起きた例外がちゃんと`catch`されて`getMessage()`で内容を取れる、という「実行時の流れ」の方に気を取られて、`catch`ブロックから`try`ブロック内のローカル変数が見えるかどうかという「スコープ（コンパイル時のルール）」を見落としていた。「`try`ブロック内で宣言した変数は、その`try`ブロックの外（`catch`/`finally`含む）からは見えない」という基本ルールをまず先に確認する癖をつける。

<a id="m16"></a>
## 問題16

```java
public class Main {
    public static void main(String[] args) {
        try {
            FirstException ex;
            // insert code here
            throw ex;
        } catch(FirstException ex) {}
    }
}
class FirstException extends RuntimeException {
    FirstException() {}
    FirstException(Throwable cause) { super(cause); }
    FirstException(String message) { super(message); }
}
class SecondException extends FirstException {
    SecondException(Throwable cause) { super(cause); }
}
```

コンパイルを成功させるには、5行目にどのコードを挿入するか（3つ選択）。

A. `ex = new FirstException();`
B. `ex = new SecondException(new Exception());`
C. `ex = new SecondException("Second");`
D. `ex = new FirstException(new SecondException());`
E. `ex = new SecondException(new FirstException("First"));`

**正解：A, B, E**

- 2026-08-25時点：回答`A,D,E` ✗
- 2026-09-07時点：回答`A,C,E` ✗（別パターンでまた誤答、まだ克服できていない）

### 復習ポイント

**大原則：コンストラクタは継承されない。** `SecondException`が使えるコンストラクタは、自分で定義した`SecondException(Throwable cause)`ただ1つだけ。親`FirstException`が持つ`FirstException()`や`FirstException(String)`は`SecondException`からは呼べない。

「`Throwable cause`を受け取る」＝「`Throwable`の子孫（例外・エラーオブジェクト）なら何でも受け取れる」という意味。文字列やただの`Object`は入れられない。

**ネストした`new`は、それぞれ独立にチェックされる。** 外側の呼び出しが正しく見えても、内側の`new`が単独で無効なら全体がコンパイルエラーになる（Dで見落としやすいポイント）。

選択肢ごとの判定：

| 選択肢 | 判定 | 理由 |
|---|---|---|
| A. `new FirstException()` | ○ | `FirstException`は無引数コンストラクタを自分で持っている |
| B. `new SecondException(new Exception())` | ○ | `Exception`は`Throwable`のサブクラスなのでそのまま渡せる |
| C. `new SecondException("Second")` | ✗ | `SecondException`に`String`用のコンストラクタは無い（継承されない） |
| D. `new FirstException(new SecondException())` | ✗ | 外側はOKだが、内側の`new SecondException()`（引数なし）が単独で無効 |
| E. `new SecondException(new FirstException("First"))` | ○ | 内側`new FirstException("String")`でFirstExceptionを生成→外側はThrowableのサブクラスを受け取るのでOK |

**補足：無引数コンストラクタが無いこと自体は罪ではない。** コンストラクタを1つでも自分で書くと、そのクラスの無引数コンストラクタは自動生成されなくなるが、それ自体はコンパイルエラーにならない。問題になるのは「無引数で呼ぼうとする箇所が実際にあるかどうか」だけ（`javac`で検証済み：引数ありコンストラクタのみのクラスも普通にコンパイル・実行できる）。

**次に意識すること**：CとDの見分け方が鍵。Cは外側自体の引数が間違っている、Dは外側は正しいが内側のnewが単独で成立しない。「外側だけでなく、ネストしたnewも個別に検算する」という手順を徹底する。
