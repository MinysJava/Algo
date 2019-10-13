package Lesson_4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insertFirst("1");
        list.insertFirst("2");
        list.insertFirst("3");

//        System.out.println(list);
//        System.out.println(list.getFirst());
//        System.out.println(list.removeFirst());
//        System.out.println(list);

        list.insertLast("4");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
