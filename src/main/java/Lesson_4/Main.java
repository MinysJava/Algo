package Lesson_4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insertFirst("1");
        list.insertFirst("2");
        list.insertFirst("3");

        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.removeFirst());
        System.out.println(list);

        list.insert("4", 0);
        System.out.println(list);
    }
}
