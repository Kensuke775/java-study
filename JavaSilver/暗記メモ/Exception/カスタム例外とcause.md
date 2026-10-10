# カスタム例外とcause（問題26）

## 検証コード

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
                if (validate(s)) System.out.println(s);
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
    }
    public static boolean validate(String s) throws Exception {
        try {
            char c = s.charAt(0);
            int a = Integer.parseInt(s);
        } catch (NullPointerException | NumberFormatException e) {
            throw new InvalidDataException(e.getMessage(), e);
        }
        return true;
    }
}
```

## `super(message, cause)`は何をしているか

`Exception`（さらに遡って`Throwable`）には`Throwable(String message, Throwable cause)`という2引数コンストラクタが最初から用意されている。カスタム例外のコンストラクタで`super(message, cause)`と書くと、この親コンストラクタに委譲され、**渡した`cause`（元の例外）が内部に保存される**。

保存された`cause`は、あとから`e.getCause()`で取り出せる。「独自例外に、元の例外を`cause`として包んで運ぶ」という、例外のラッピングの定番パターン。

カスタム例外クラス自体（`InvalidDataException`）は`Exception`を継承しただけのクラスで、特別なフィールドやメソッドを持っているわけではない。`getCause()`が機能するのは、コンストラクタで`super(message, cause)`を呼んで**親（`Throwable`）に情報を渡しているから**という点が核心。

## 1周ずつ追う

| `s`の値 | `validate(s)`内で起きること | mainの`catch`で出力される内容 |
|---|---|---|
| `null` | `s.charAt(0)`で`NullPointerException`が発生 → `catch`で捕まえ、`InvalidDataException(e.getMessage(), e)`をthrow（`e`=NPE） | `e.getCause()` → **元のNPE**が出力される |
| `"17"` | `charAt(0)`も`Integer.parseInt("17")`も例外無し。`validate`は`true`を返す | 例外は起きないので`catch`には入らず、`"17"`がそのまま出力される |
| `"Duke"` | `Integer.parseInt("Duke")`で`NumberFormatException`が発生 → 同様に`InvalidDataException`でラップ | `e.getCause()` → **元のNFE**が出力される |

## ポイント

- `catch (NullPointerException | NumberFormatException e)`のようなマルチキャッチで捕まえた例外`e`を、そのまま新しい例外の`cause`として次に投げ直せる
- 呼び出し元（`main`側）は、実際に受け取る例外の型（`InvalidDataException`）とは別に、`getCause()`で「本当は何が原因だったか（NPEかNFEか）」を知ることができる
- これは「例外を握りつぶさずに、より意味のある独自例外に変換しつつ、元の情報も失わない」ための標準的な設計パターン
