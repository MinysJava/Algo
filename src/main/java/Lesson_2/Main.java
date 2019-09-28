package Lesson_2;

public class Main {
    public static void main(String[] arg){

        MyArray<Integer> ma = new MyArray<>();

        ma.add(5);
        ma.add(66);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);
        ma.add(7);

        ma.add(2,13);

        System.out.println(ma.size());
    }
}
