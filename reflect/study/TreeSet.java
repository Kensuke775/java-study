package reflect.study;

import java.util.Set;

record Client(String name, int age) implements Comparable<Client> {
    @Override
    public int compareTo(Client o) {
        return this.name.compareTo(o.name); //この場合名前で重複し、size()2
        // [Client[name=Alice, age=25], Client[name=Bob, age=20]]
        // 2

        // return this.age - o.age; //ageの昇順でソートされsize()3
        // [Client[name=Bob, age=20], Client[name=Alice, age=25], Client[name=Bob, age=30]]
        // 3
    }
}

public class TreeSet {
    public static void main(String[] args) {
        Set<Client> set = new java.util.TreeSet<>();
        set.add(new Client("Bob", 20));
        set.add(new Client("Bob", 30));
        set.add(new Client("Alice", 25));
        System.out.println(set);
        System.out.println(set.size());
    }
}
