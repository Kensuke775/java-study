package reflect.study;

public class Exception_1 {

        public static void main(String[] args) {
            System.out.println(test(false)); // finallyは例外を投げず、そのままreturnする
            System.out.println(test(true));  // finallyの中で例外が先に起きる
        }
    
        static String test(boolean explode) {
            try {
                throw new RuntimeException("body");
            } catch (RuntimeException e) {
                return "catch:" + e.getMessage();
            } finally {
                if (explode) {
                    throw new IllegalStateException("finally boom");//
                }
                return "finally:override";
            }
        }
}
//　実行結果
// finally:override
// Exception in thread "main" java.lang.IllegalStateException: finally boom
// 	at Main.test(Main.java:14)
// 	at Main.main(Main.java:4)


class Exception_2 {
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println("caught: " + e);
            System.out.println("suppressed count: " + e.getSuppressed().length);
            System.out.println("cause: " + e.getCause());
        }
    }

    static void method() throws Exception {
        try {
            throw new RuntimeException("EXCEPTION-A (tryで先に発生)");
        } finally {
            throw new IllegalStateException("EXCEPTION-B (finallyで後から発生)");
        }
    }
}

// 実行結果:
// caught: java.lang.IllegalStateException: EXCEPTION-B (finallyで後から発生)
// suppressed count: 0
// cause: null
