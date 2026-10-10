# charAt と範囲外アクセス時の例外

## Stringクラスのメソッド、戻り値は`char`

シグネチャ：`char charAt(int index)`

戻り値の型は**プリミティブの`char`**（`Character`ではない）。文字列のうち、指定した位置にある1文字だけを取り出して返す。

## 検証コード

```java
String c = "abc";
c.charAt(1);    // → 'b'（0始まりのインデックス）
c.charAt(10);   // ← 範囲外
c.charAt(-1);   // ← 範囲外（負数）
```
```
java.lang.StringIndexOutOfBoundsException: String index out of range: 10
java.lang.StringIndexOutOfBoundsException: String index out of range: -1
```
→ 検証済み。

## `charAt(int index)`：指定した位置（0始まり）の1文字を取り出す

`indexOf`系（文字を探して位置を返す）とは逆で、`charAt`は**位置（インデックス）を渡して、そこにある文字（`char`）を返す**メソッド。文字列の先頭は`0`番目。

## 範囲外を指定すると`StringIndexOutOfBoundsException`（実行時例外）

`index`が**負の数**、または**文字列の長さ以上**の場合、コンパイルエラーにはならず、**実行時に`StringIndexOutOfBoundsException`がスローされる**。

- 「大幅にずれている」かどうかは関係なく、**1つでも範囲外なら例外**（`"abc".charAt(3)`のように、ほんの少し範囲を超えただけでも同じ例外になる）
- `StringIndexOutOfBoundsException`は`IndexOutOfBoundsException`のサブクラス（配列の範囲外アクセス`ArrayIndexOutOfBoundsException`も同じ`IndexOutOfBoundsException`の子孫だが、`String`用と`配列`用で別々の具象クラスが用意されている）

## まとめ

| 状況 | 結果 |
|---|---|
| `0 <= index < 文字列の長さ` | 正常にその位置の`char`が返る |
| `index`が負の数、または文字列の長さ以上 | `StringIndexOutOfBoundsException`（実行時例外） |
