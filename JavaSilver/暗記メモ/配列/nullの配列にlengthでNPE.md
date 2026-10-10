# nullの配列に.lengthでアクセスするとNPE

## 検証コード

```java
int[] arr = null;
System.out.println(arr.length);
```
```
Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "arr" is null
```
→ 検証済み。

## ポイント：メソッドでもフィールド（プロパティ）でも、nullへの`.`アクセスは同じ扱い

`length`は配列が持つ「プロパティ」であり、メソッドの`length()`ではない。しかし`null`に対して`.`（ドット）で何かにアクセスしようとした瞬間、それが**メソッド呼び出し（`.method()`）だろうがフィールドアクセス（`.length`のようなプロパティ）だろうが、区別なく`NullPointerException`になる**。

## まとめ

- `arr.length`（配列のプロパティ）も、`arr`が`null`なら`NullPointerException`
- 「フィールドアクセスだから例外にならない」ということはない。`null`経由の`.`アクセスは全部NPEの対象
