# mainから直接呼ぶメソッドは、static必須（実践パターン）

## よく見る形

```java
public class Main {
    public static void main(String[] args) {
        int result = sample();   // レシーバー無しで直接呼んでいる
        System.out.println(result);
    }
    private static int sample() {   // ← static必須
        ...
    }
}
```

`main`メソッド自体が`static`なので、その中から`sample()`のように**レシーバー無し（`インスタンス変数.sample()`ではなく`sample()`だけ）**で直接呼び出すメソッドは、**呼ばれる側（`sample()`）も`static`でなければならない**。

## なぜか：レシーバー無しの呼び出しは「暗黙のthis.sample()」と同じ

`sample()`という書き方は、省略していなければ実際には`this.sample()`と解釈される。しかし`main`は`static`メソッドなので`this`が存在しない。そのため、もし`sample()`がインスタンスメソッド（`static`無し）だったら、この時点で以前確認した「staticコンテキストからインスタンスメソッドは呼べない」というエラーになる。

```java
private int sample() { ... }   // staticを付け忘れた場合
```
```
エラー: 非staticメソッドsample()を、staticコンテキストから参照することはできません
```

これは[[staticが使える場所と使えない場所]]で確認した①（`staticメソッドの中からインスタンスメソッドは呼べない`）の、最も典型的な実践パターン。**「`main`の中でヘルパーメソッドをレシーバー無しでそのまま呼んでいる」＝「そのヘルパーメソッドは`static`のはず」**、という読み方が試験問題を素早く読み解くコツになる。

## まとめ

- `main`は`static`なので、その中からレシーバー無しで呼ぶメソッドはすべて`static`でなければならない
- 逆に言えば、コード中に`private static int sample() {...}`のような宣言を見た時点で、「これは`main`（や他のstaticメソッド）から直接呼ばれる前提のヘルパーメソッドだ」と読み取れる
