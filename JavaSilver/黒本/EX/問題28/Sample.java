public class Sample {
    public static void main(String[] args) {

        Item a = new Item("A");
        System.out.print(a.name + a.id + ",");
        Item b = new Item("B");
        System.out.print(b.name + b.id + ",");
        b.id = "2";
        a.name = "C";
        System.out.print(a.name + a.id + ",");
        System.out.print(b.name + b.id + ",");

    }
}

class Item {
    public static String id;
    public String name;
    public Item(String name) {
        this.name = name;
        id = "1";
    }
}
