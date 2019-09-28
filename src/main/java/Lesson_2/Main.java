package Lesson_2;

import java.util.Random;

public class Main {
    public static void main(String[] arg){
        Random random = new Random();

        MyArray<Integer> ma = new MyArray<>();
//
//        ma.add(5);
//        ma.add(66);
//        ma.add(7);
//
//        ma.add(2,13);
        for (int i = 0; i < 10; i++) {
            ma.add(random.nextInt(100));
        }

        System.out.println(ma);
        ma.insertSort();
        System.out.println(ma);

//        MySortedArray<Integer> msa = new MySortedArray<>();
//
//        msa.add(5);
//        msa.add(3);
//        msa.add(1);
//
//        System.out.println(msa);
//        System.out.println(msa.binaryFind(3));
    }
}
