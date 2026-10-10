# enumとは

## 概要

`enum`は、「取りうる値が決まりきった、限られた選択肢の集合」を表すための専用の型。曜日、季節、状態（成功/失敗など）のように、「これ以外の値は存在しない」というものを表現するのに使う。

```java
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
```

`SPRING`・`SUMMER`・`AUTUMN`・`WINTER`はそれぞれ、**`Season`型の唯一無二のインスタンス（定数）**。

## 検証コード

```java
Season s = Season.SPRING;
System.out.println(s);              // SPRING（toString()。デフォルトは定数名がそのまま出る）
System.out.println(s.name());       // SPRING（定数名を文字列で取得）
System.out.println(s.ordinal());    // 0（宣言順のインデックス、0始まり）

for (Season season : Season.values()) {   // 全定数を宣言順の配列で取得
    System.out.println(season + " : " + season.ordinal());
}
// SPRING : 0
// SUMMER : 1
// AUTUMN : 2
// WINTER : 3

Season parsed = Season.valueOf("SUMMER");   // 文字列から定数を逆引き
System.out.println(parsed == Season.SUMMER);   // true

switch (s) {
    case SPRING -> System.out.println("春です");
    default -> System.out.println("その他");
}
// 春です

System.out.println(s.getClass().getSuperclass());   // class java.lang.Enum
```
→ すべて検証済み。

## 押さえておくべきポイント

- **各定数はSingleton（唯一のインスタンス）**：`Season.SPRING`はプログラム全体でただ1つしか存在しない。だから`==`で安全に比較できる（`valueOf`の結果と`==`で比較しても`true`になる）
- **暗黙的に`java.lang.Enum`を継承**：そのため`enum`は他のクラスを`extends`できない（Javaは単一継承）。ただし`interface`は`implements`できる
- **`values()`・`valueOf()`・`ordinal()`・`name()`**はコンパイラが自動的に用意してくれるメソッド
  - `values()`：宣言順の配列を返す
  - `valueOf(String)`：定数名の文字列から対応する定数を取得する
  - `ordinal()`：宣言順のインデックス（0始まり）
  - `name()`：定数名そのものを文字列で返す
- **`switch`文・`switch`式で使える**：全定数を`case`で網羅すれば`default`が不要になる（[[switch文とswitch式]]参照）
- フィールドやコンストラクタ、メソッドを持たせることもできる（各定数ごとに異なる値を持たせられる）

## まとめ

`enum`は「決まった個数の、名前付きの定数」を安全に表現するための型。各定数はSingletonインスタンスとして扱われ、`==`比較・`switch`との相性が良く、コンパイラが`values()`・`valueOf()`・`ordinal()`・`name()`を自動生成してくれる。
