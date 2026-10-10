# charの立ち位置：byte・shortとは別系統で、intのところで合流する

## ワイドニングの本当の系統図

```
byte → short ─┐
              ├→ int → long → float → double
       char ──┘
```

`byte`と`short`は一本の道でつながっている（`byte`→`short`は自動変換OK）が、**`char`はそのどちらとも自動変換できない、独立した別の入り口として`int`に合流している**。「`char`は`byte`・`short`のあたりにいる」という位置づけは誤りで、正しくは「`char`は`byte`・`short`とは別系統で、`int`より手前では合流しない」という理解になる。

## 検証：byte・shortとcharは、双方向ともキャストが必要

```java
byte c1 = 10;
char c2 = c1;   // byte → char
```
```
エラー: 不適合な型: 精度が失われる可能性があるbyteからcharへの変換
```

```java
char c2 = 'A';
byte c1 = c2;   // char → byte
```
```
エラー: 不適合な型: 精度が失われる可能性があるcharからbyteへの変換
```

```java
short s = 10;
char c = s;   // short → char
```
```
エラー: 不適合な型: 精度が失われる可能性があるshortからcharへの変換
```

```java
char c = 'A';
short s = c;   // char → short
```
```
エラー: 不適合な型: 精度が失われる可能性があるcharからshortへの変換
```
→ すべて検証済み。`byte`↔`char`・`short`↔`char`は**4パターンすべてキャストが必要**。

## 検証：char → int/long/float/double（合流後）は自動変換OK

```java
char c = 'A';
int i = c;       // → 65
long l = c;      // → 65
float f = c;     // → 65.0
double d = c;    // → 65.0
```
→ 検証済み。すべてキャスト無しでコンパイル・実行成功。

## なぜbyte/shortとcharの間だけ自動変換できないのか：符号の食い違い

| 型 | ビット幅 | 符号 | 範囲 |
|---|---|---|---|
| `byte` | 8bit | あり | -128〜127 |
| `short` | 16bit | あり | -32768〜32767 |
| `char` | 16bit | **なし** | 0〜65535 |

`short`と`char`はビット幅こそ同じ16bitだが、**符号の有無が違う**。例えば`short`の`-1`をそのまま`char`にすると、意味が全く違う巨大な正の値になってしまう。この「符号の食い違い」があるため、Javaは`byte`↔`char`・`short`↔`char`のどちらの方向も自動変換を許可せず、明示的なキャストを要求する設計になっている。

一方`int`以降（符号あり32bit以上）は、`char`が取りうる0〜65535の範囲を**符号を気にせずそのまま包含できる**ため、`char → int/long/float/double`は普通のワイドニングとして自動変換が許可されている。

## まとめ

| 変換 | キャスト必要か |
|---|---|
| `byte` ↔ `char`（双方向） | ✅ 必要 |
| `short` ↔ `char`（双方向） | ✅ 必要 |
| `char` → `int`/`long`/`float`/`double` | ❌ 不要（ワイドニング） |
| `int`/`long`/`float`/`double` → `char` | ✅ 必要（ナローイング） |

**「`char`は`byte`・`short`と同じグループ」ではなく、「`char`は`byte`・`short`とは別系統で、`int`以降にしか自動で合流できない」**という系統図で覚えておくのが正確。
