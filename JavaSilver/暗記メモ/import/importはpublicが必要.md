# importはpublicが必要

## 同じパッケージなら`public`不要、別パッケージからは`import`していても`public`必須

```java
// 同じパッケージ（ex.b）同士
package ex.b;
class Bar {}          // publicなし

package ex.b;
public class UseBar {
    public static void main(String[] args) {
        new Bar();     // importも無いのに、そのまま使える
    }
}
```
→ 問題なくコンパイル・実行成功。

```java
// 別パッケージから
package ex.b;
class Bar {}           // publicなし（package-private）

package ex;
import ex.b.*;
public class Main {
    public static void main(String[] args) {
        new Bar();      // ← エラー
    }
}
```
```
エラー: シンボルを見つけられません
シンボル: クラス Bar
```

## まとめ

| 状況 | `public`は必要か |
|---|---|
| **同じパッケージ内**から使う | ❌ 不要（無指定＝package-privateのままで見える） |
| **別パッケージから`import`して**使う | ✅ 必要（`import`はあくまで"視界に入れる"だけで、アクセス権限は別問題） |

`import`は「別パッケージにあるクラスの名前を、フルパス（`ex.b.Bar`）で書かずに済むようにする」ための**便宜的な機能**であって、アクセス制御（`public`/`private`/無指定/`protected`）とは完全に別の仕組み。同じパッケージにいる限りimportすら要らずに使えるが、パッケージを跨いだ瞬間に「`public`が付いているかどうか」という別のゲートが立ちはだかる。ワイルドカードインポート（`import ex.b.*;`）であっても、アクセス権限そのものを突破する力は無い。
