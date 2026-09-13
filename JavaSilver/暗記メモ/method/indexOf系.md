# indexOf系メソッド

## indexOf / lastIndexOf の違い

`lastIndexOf`は「後ろから探して、最後に見つかった位置（インデックス）を返す」メソッド。`indexOf`（前から探して最初に見つかった位置）の逆方向版。

| メソッド | 探す方向 | 見つからない場合 |
|---|---|---|
| `indexOf(...)` | 前から | `-1`を返す |
| `lastIndexOf(...)` | **後ろから** | `-1`を返す |

## Stringでの例

```java
String s = "banana";
s.indexOf('a');        // 1（最初の'a'の位置）
s.lastIndexOf('a');    // 5（最後の'a'の位置）
s.lastIndexOf("na");   // 4（後ろから探して最後に一致した"na"の開始位置）
```

## Listでの例

```java
List<String> list = List.of("a", "b", "a", "c");
list.indexOf("a");       // 0（最初に見つかった"a"の位置）
list.lastIndexOf("a");   // 2（最後に見つかった"a"の位置）
```

## ポイント

`String`・`List`どちらにも存在し、使い方（何を見つけたいか）は同じ。「同じ値が複数ある時に、どちらの位置を返すか」が`indexOf`と`lastIndexOf`の違い。
