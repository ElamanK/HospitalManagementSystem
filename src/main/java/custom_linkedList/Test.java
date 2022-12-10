package custom_linkedList;
public class Test {
    public static void main(String[] args) {

        MyLinkedList<Integer> integerList = new MyLinkedList<>();
        System.out.println("Integer list");
        System.out.println("Adding elements 3,5,8");
        integerList.add(3);
        integerList.add(5);
        integerList.add(8);
        System.out.println(integerList);
        integerList.remove(5);
        System.out.println("List after removing 5");
        System.out.println(integerList);
        System.out.println();

        MyLinkedList<String> stringList = new MyLinkedList<>();
        System.out.println("String list");
        System.out.println("Adding Java,Hello,World");
        stringList.add("Java");
        stringList.add("Hello");
        stringList.add("World");
        System.out.println(stringList);
        System.out.println("Adding Test at position 2");
        stringList.add(2, "Test");
        System.out.println(stringList);
        System.out.println("Clearing list");
        stringList.clear();
        System.out.println(stringList);
        System.out.println("Testing empty method -> "+ stringList.empty());
        System.out.println();

        MyLinkedList<Double> doubleList = new MyLinkedList<>();
        System.out.println("Double list");
        System.out.println("Adding elements 11.22, 44,21, 99.01 ");
        doubleList.add(11.22);
        doubleList.add(44.21);
        doubleList.add(99.01);
        System.out.println(doubleList);
        System.out.println("Size of the list -> "+doubleList.size());

    }
}
