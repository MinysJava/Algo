package Lesson_2;

import java.util.Random;

public class Main {
    public static void main(String[] arg){
        Random random = new Random();

        MyArray<Integer> ma = new MyArray<>(1000000);

        long arrFilling = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            ma.add(random.nextInt(100));
        }
        long arrFillFinish = System.currentTimeMillis();
        System.out.println("Время заполнение цикла - " + (arrFillFinish - arrFilling));
//
//        long insertSortStart = System.currentTimeMillis();
//        ma.insertSort();
//        long insertSortFinish = System.currentTimeMillis();
//        System.out.println("Время сортировки методом вставки - " + (insertSortFinish - insertSortStart));

        long bubbleSortStart = System.currentTimeMillis();
        ma.bubbleSort();
        long bubbleSortFinish = System.currentTimeMillis();
        System.out.println("Время сортировки методом пузырька - " + (bubbleSortFinish - bubbleSortStart));

//        long selecrionSortStart = System.currentTimeMillis();
//        ma.seletionSort();
//        long selecrionSortFinish = System.currentTimeMillis();
//        System.out.println("Время сортировки методом выборки - " + (selecrionSortFinish - selecrionSortStart));

    }

}
