# recordの自動生成アクセサも、interfaceのメソッドと戻り値の互換性ルールに従う

## お題

```java
public interface Test {
    default void value() {
        System.out.println("A");
    }
}
public record Data(String value) implements Test {}
```
```
エラー: Dataのvalue()はTestのvalue()を実装できません
  戻り値の型Stringはvoidと互換性がありません
```
→ 検証済み。

## 4パターンで検証

| interfaceの`value()`の戻り値 | recordのcomponent | 結果 |
|---|---|---|
| `void` | `String value` | ❌ 「戻り値の型Stringはvoidと互換性がありません」 |
| `int` | `int value` | ✅ 型一致 |
| `Object` | `String value` | ✅ `String`は`Object`のサブタイプ（共変戻り値でOK） |
| `int` | `String value` | ❌ 「abstractでなく...オーバーライドしません」（非互換） |

## 解説

`record`は、宣言したコンポーネント（例：`String value`）ごとに、**同じ名前・その型を返すアクセサメソッド**（`value()`）を自動生成する。このアクセサは通常のメソッドと同じ扱いを受けるので、`implements`したインターフェースに同名のメソッドがあれば、**そのインターフェースの抽象メソッド／defaultメソッドをオーバーライド（実装）する候補**として扱われる。

オーバーライドが成立するかどうかは、[[../interface/CharSequenceの共変戻り値]]と同じ**戻り値の互換性ルール**がそのまま適用される。

- 戻り値の型が完全に一致 → OK
- 戻り値の型が共変（サブタイプ） → OK
- 戻り値の型に互換性が無い（`void`と`String`、`int`と`String`など） → コンパイルエラー

元の問題で`void`だからダメだったのは特別なルールではなく、「recordが自動生成するアクセサの戻り値の型」と「インターフェース側が要求する戻り値の型」の間に**互換性があるかどうか**という、オーバーライド全般に共通するルールで判定されているだけ。componentの型を`int`や独自クラスに変えても、同じ基準（一致 or 共変）で判定される。

## まとめ

- `record`の自動生成アクセサは、`implements`したインターフェースの同名メソッドに対して、通常のオーバーライドと同じ戻り値互換性チェックを受ける
- 一致・共変ならOK、非互換ならコンパイルエラー（`void`に限った特別な話ではない）
