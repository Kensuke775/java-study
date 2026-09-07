package reflect.study;

public class Switch {
    public static void main(String[] args) {
        int score = 4;
        String rank = switch (score) {
            case 1: System.out.println("Hello");
            case 2:
                yield "Low";
            case 3:
                yield "Middle";
            case 4: System.out.println("Hey");
            case 5:
                yield "High";
            default:
                yield "Unknown";
        };
        System.out.println(rank);
    }
}
// 実行結果:
// Hey
// High

class Switch_2 {
    public static void main(String[] args) {
        int score = 2;

        // アロー式 + 単一の式(yieldは書かない、式の値がそのまま結果)
        String single = switch (score) {
            case 1 -> "Low";
            case 2 -> "Middle";
            default -> "Unknown";
        };

        // アロー式 + ブロック({ }の中でyieldして値を返す)
        String block = switch (score) {
            case 1 -> {
                System.out.print("(calc1) ");
                yield "Low";
            }
            case 2 -> {
                System.out.print("(calc2) ");
                yield "Middle";
            }
            default -> {
                yield "Unknown";
            }
        };

        System.out.println(single);
        System.out.println(block);
    }
}
// 実行結果:
// (calc2) Middle
// Middle
// (block代入時にprint("(calc2) ")が先に実行され、その後にsingle→blockの順でprintlnされるため、
//  1行目が「(calc2) Middle」、2行目が「Middle」という並びになる)

class Switch_3 {
    public static void main(String[] args) {
        int score = 9;
        String result = switch (score) {
            case 1 -> "Low";
            case 2 -> "Middle";
            case 9 -> {                          // アローブロック内でthrow
                System.out.print("(checking) ");
                throw new IllegalArgumentException("block throw: " + score);
            }
            default -> throw new IllegalArgumentException("direct throw: " + score); // アロー直後にそのままthrow
        };
        System.out.println(result);
    }
}
// 実行結果:
// (checking) Exception in thread "main" java.lang.IllegalArgumentException: block throw: 9
// 	at reflect.study.Switch_3.main(Switch.java:69)

class Switch_4 {
    public static void main(String[] args) {
        int score = 6;
        String rank = switch (score) {
            default:
                    System.out.println("Hello");
            case 1: System.out.println("Hello");
            case 2:
            case 3:
            case 4: System.out.println("Hey");
            case 5:
                yield "High";
        };
        System.out.println(rank);
    }
}
// 実行結果:
// Hello
// Hello
// Hey
// High
// (defaultが先頭にあり、そこにyieldが無くてもcase1→2→3→4→5とフォールスルーして
//  最後のcase5のyieldに到達すればOK。defaultが最後だとフォールスルー先が無く
//  コンパイルエラーになる)
