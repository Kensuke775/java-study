# staticが使える場所と使えない場所

## `static`を付けられる場所・付けられない場所

| 対象 | `static`を付けられるか |
|---|---|
| トップレベルのクラス自体 | ❌（`public static class T {}`はエラー） |
| クラス直下のフィールド | ✅ |
| クラス直下のメソッド | ✅ |
| クラスの中にネストしたクラス（インナークラス） | ✅（`static class Inner {}`） |
| クラス直下の初期化ブロック（`static { ... }`） | ✅ |
| ローカル変数（メソッドの中の変数） | ❌ |
| メソッドの中に書く`static class`・`static {}` | ❌ |

**ポイント：`static`が使えるのは「クラス本体の直下」だけ**。「インスタンスメソッドか`static`メソッドか」は関係なく、**メソッドという箱の中に入った時点で、`static`付きの宣言は一切書けなくなる**。

## 検証：トップレベルクラスに`static`

```java
public static class T {
}
```
```
エラー: 修飾子staticをここで使用することはできません
```

## 検証：クラス直下ならOK（フィールド・メソッド・ネストクラス・初期化ブロック）

```java
public class T2 {
    static int x = 1;          // staticフィールド
    static void m() {}         // staticメソッド
    static class Inner {}      // staticネストクラス
    static {                   // static初期化ブロック
        x = 2;
    }
}
```
→ コンパイル成功（検証済み）。

## 検証：メソッドの中には`static`付きの宣言が一切書けない

```java
void method() {
    static String cont = "";   // ← エラー（ローカル変数にstaticは不可）
}
```
```
エラー: 式の開始が不正です
```

```java
void method() {
    static class Local {}   // ← エラー
}
```
```
エラー: 式の開始が不正です
```

```java
void method() {
    static {   // ← エラー
        int x = 1;
    }
}
```
```
エラー: 式の開始が不正です
```

## staticメソッドの中は「インスタンスの情報」を一切持てない

`static`メソッドは、どのインスタンスにも紐づかずに（`new`しなくても）呼び出せる。そのため、`static`メソッドの中には「今どのインスタンスの話をしているか」という情報（＝`this`）がそもそも存在しない。

### ①インスタンスメソッドは呼べない

```java
class Value {
    void instanceMethod() {}
    static void staticMethod() {
        instanceMethod();   // ← エラー
    }
}
```
```
エラー: 非staticメソッドinstanceMethod()を、staticコンテキストから参照することはできません
```

### ②インスタンス変数（フィールド）にも触れない

```java
class Value {
    private String contents;
    public static void print() {
        System.out.println(contents);   // ← エラー
    }
}
```
```
エラー: staticでない変数 contentsをstaticコンテキストから参照することはできません
```

### ③`this`自体も使えない（詳細は[[../this/staticメソッドの中では使えない]]）

`this.method()`や`this.field`も、結局は上の①②と同じ理由でエラーになる（`this`が指すべき「今のインスタンス」がstaticコンテキストには存在しないため）。

## まとめ

- `static`が書けるのは「クラス本体の直下」だけ（トップレベルクラス自体・ローカル変数・メソッドの中身には書けない）
- `static`メソッドの中では、`this`もインスタンスメソッドもインスタンス変数も一切触れない（「今どのインスタンスの話か」という文脈が存在しないため）
- 逆に、`static`同士（`static`フィールド・`static`メソッド）へのアクセスは、`static`メソッドの中からでも普通にできる
