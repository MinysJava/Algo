package Lesson_6;

public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> mtm = new MyTreeMap<>();

        mtm.put(5, "five");
        mtm.put(4, "four");
        mtm.put(1, "one");
        mtm.put(2, "two");

        System.out.println(mtm.get(2));
        mtm.put(2, "twotwo");
        System.out.println(mtm.get(2));

        System.out.println(mtm);
    }
}
