public class Main {
    public static void main(String[] args) {
        B b = new C();
        A t = new C();

        b.test(1);            // (1)
        (A)b.test(2);          // (2)
        ((A)b).test(3);        // (3)
        t.test(4);             // (4)
        (A)t.test(5);          // (5)
        ((A)t).test(6);        // (6)
    }
}

sealed interface A permits C {   // (7)
    void test(int i);
}

class B {                        // (8)
    public static final int NUM = 2;
}

final class C extends B implements A {   // (9)

    @Override
    public void test(int i) {
        System.out.println(i * B.NUM);
    }

}
