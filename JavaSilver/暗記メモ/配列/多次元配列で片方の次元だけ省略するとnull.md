# `new int[2][]`は外側だけ確定し、各要素はnull（要素数0の配列とは別物）

## 検証コード

```java
int[][] arr2 = new int[2][];
System.out.println(arr2.length);   // → 2
System.out.println(arr2[0]);       // → null
System.out.println(arr2[1]);       // → null
System.out.println(arr2[0][0]);
```
```
2
null
null
Exception in thread "main" java.lang.NullPointerException: Cannot load from int array because "<local1>[0]" is null
```
→ 検証済み。

## 解説

`int[][]`は正確には「`int[]`を要素として持つ配列」。`new int[2][]`と書くと、**外側の次元（2）だけが確定**し、内側の次元（各要素が指す`int[]`）は指定されない。

- `arr2`自体は要素数**2**の配列（`arr2.length == 2`）
- 各要素（`arr2[0]`・`arr2[1]`）は、それぞれ「`int[]`型への参照」だが、まだどんな配列も指していない状態＝参照型のデフォルト値である**`null`**

「中身が空の配列（`{}`のような要素数0の配列）」と「参照そのものが`null`（配列自体が存在しない）」は別物（[[nullの配列にlengthでNPE]]と同じ構造）。

## なぜ`arr2[0][0]`がNullPointerExceptionになるのか

`arr2[0][0]`は2段階に分解される。

1. `arr2[0]` → `arr2`（長さ2）の0番目にアクセス。**範囲内なので成功**。結果は`null`
2. `[0]`（2回目） → `null`に対してさらに`[0]`でアクセスしようとする → `NullPointerException`

もし1段階目の添字が範囲外（例：`arr2[5]`）なら`ArrayIndexOutOfBoundsException`になるが、今回は1段階目は有効範囲内で成功し、その先の`null`に対する添字アクセスで例外になる、という点がポイント。

## 比較まとめ

| 配列の書き方 | 状態 |
|---|---|
| `int[] arr = {};` | 要素数0の配列（有効なインデックスが存在しない） |
| `int[] arr1 = new int[1];` | 要素数1の配列（`arr1[0]`は`int`のデフォルト値`0`で存在する） |
| `int[][] arr2 = new int[2][];` | 外側は要素数2の配列。各要素（`int[]`）はまだ生成されておらず`null` |
| `arr2[0][0]` | `arr2[0]`（`null`）に対して`[0]`でアクセス → `NullPointerException` |

中身まで使いたい場合は、`new int[2][3]`（両方の次元を指定）や、`arr2[0] = new int[3];`のように後から内側の配列を生成する必要がある。
