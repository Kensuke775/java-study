# thisはstaticメソッドの中では使えない

`this`は「今動いているインスタンス自身への参照」。`static`メソッドは、インスタンスを1つも作らなくても呼び出せる（`new`しなくても`クラス名.メソッド名(...)`で直接実行できる）ため、`static`メソッドの実行時には「今のインスタンス」自体が存在するとは限らない。そのため`this`という単語自体が`static`コンテキストでは使用禁止。

`this`の後ろに何を続けるか（メソッド呼び出しか、フィールドへの代入か）は関係なく、**`this`を書いた瞬間に一律アウト**。

## 検証

```java
public class Check {
    void method() {}
    public static void main(String[] args) {
        this.method();   // ← エラー
    }
}
```
```
エラー: staticでない変数 thisをstaticコンテキストから参照することはできません
```

```java
public class Check2 {
    int xxx = 0;
    public static void main(String[] args) {
        this.xxx += 1;   // ← これも同じ理由でエラー
    }
}
```
```
エラー: staticでない変数 thisをstaticコンテキストから参照することはできません
```

## まとめ

- `this.method()` → ❌
- `this.xxx += 1;` → ❌
- `this.`で始まる書き方はすべて、`static`メソッドの中では一律アウト
