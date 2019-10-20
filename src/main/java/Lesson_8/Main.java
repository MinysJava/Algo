package Lesson_8;

public class Main {
    public static void main(String[] args) {
//        ChainingHashMap<Integer, String> map = new ChainingHashMap<>();
//
//        map.put(1, "one");
//        map.put(2, "two");
//        map.put(12, "12");
//        map.put(15, "15");
//
////        System.out.println(map.get(1));
//        System.out.println(map);
//
//        map.del(2);
//        System.out.println("-----------------");
//
//        System.out.println(map);
//        System.out.println("-----------------");
//        map.put(2, "two");
//        System.out.println(map);

        LinearProbingHashMap<Integer, String> map2 = new LinearProbingHashMap<>();

        map2.put(1, "one");
//        map2.put(1, "one");
        map2.put(2, "two");
        map2.put(12, "12");
        map2.put(15, "15");

        System.out.println(map2);

        map2.del(2);
        System.out.println("-----------------");

        System.out.println(map2);
        System.out.println(map2.get(15));
        System.out.println("-----------------");
        map2.put(2, "two");
        System.out.println(map2);

//        map2.del(21);
//        System.out.println("-----------------");
//
//        System.out.println(map2);
    }
}
