# String.valueOf：いろいろな型 → String

## 基本：`String`クラスの静的メソッド。渡した値を文字列にして返す

```java
String.valueOf(7)        // "7"     （int）
String.valueOf(3.14)     // "3.14"  （double）
String.valueOf(true)     // "true"  （boolean）
String.valueOf('a')      // "a"     （char）
String.valueOf(100L)     // "100"   （long）
```
→ 検証済み。`int`・`double`・`boolean`・`char`・`long`など、プリミティブ型ごとにオーバーロードが用意されている（`Object`・`char[]`版もある）。

`String`クラスの**静的メソッド**なので、`String.valueOf(...)`と**クラス名から**呼ぶ（インスタンスは不要）。戻り値は`String`。

```java
public String foo(int i) { return String.valueOf(i); }   // 紫本5-11のF：valueOf自体は正しい書き方
```

## 同じ結果になる書き方

```java
String.valueOf(7).equals("" + 7)              // true
String.valueOf(7).equals(Integer.toString(7)) // true
```
→ 検証済み。`"" + 7`（空文字との連結）や`Integer.toString(7)`と同じ結果。プリミティブは`i.toString()`のようにメソッドを呼べない（オブジェクトではない）ので、`String.valueOf(i)`が定番の変換方法。

```java
String.valueOf(12345).length()   // 5（数値の桁数を数える定番テク）
```

## 引っかかりやすいポイント

### `char`と`int`は別物（`'a'`と`97`）

```java
String.valueOf('a')          // "a"
String.valueOf((int) 'a')    // "97"
```
→ 検証済み。渡す型で呼ばれるオーバーロードが変わる。

### `char[]`を渡すと中身がつながった文字列になる

```java
String.valueOf(new char[]{'a', 'b', 'c'})   // "abc"
```

### `null`まわりの罠

```java
Object o = null;
String.valueOf(o);          // "null"（文字列の"null"。例外にならない）
o.toString();               // NullPointerException

String.valueOf(null);       // NullPointerException ← 罠！
```
→ すべて検証済み。`String.valueOf(null)`は、`null`リテラルを直接渡すと`char[]`版のオーバーロードが選ばれて、`char[]`の`null`を扱おうとして`NullPointerException`になる。`Object`型の変数に入った`null`を渡せば`"null"`という文字列になる。

## 向きが逆の`valueOf`との区別

同じ名前でも**別のメソッド**なので混同しない。

| メソッド | 向き | 戻り値 |
|---|---|---|
| `String.valueOf(7)` | いろいろな型 → **文字列** | `String` |
| `Integer.valueOf("7")` | 文字列/プリミティブ → **ラッパー**（`Integer`） | `Integer` |
| `Integer.parseInt("7")` | 文字列 → **プリミティブ**（`int`） | `int` |

```java
int n = Integer.parseInt("7");        // 7（int）
Integer w = Integer.valueOf("7");     // 7（Integer）
```
→ 検証済み。ラッパー側の`valueOf`と`xxxValue`は[[valueOfとxxxValue]]を参照。
