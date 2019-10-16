package Lesson_6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


//        mtm.put(5, "five");
//        mtm.put(4, "four");
//        mtm.put(2, "one");
//        mtm.put(3, "two");
//        mtm.put(1, "two");
//
//        System.out.println(mtm.get(2));
//        mtm.put(2, "twotwo");
//        System.out.println(mtm.get(2));
//
//        System.out.println(mtm);
//
//        System.out.println(mtm.height());
//        System.out.println(mtm.size());
//
//        mtm.delete(3);
//        System.out.println(mtm);

//        System.out.println(mtm.isBalanced());
        Random random = new Random();
        int t;
        int treeNumber = 20;
        int maxHeight = 4;

        for (int j = 0; j <100 ; j++) {
            t = 0;
            for (int i = 0; i < treeNumber; i++) {
                MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>();
                while (mtm.height() <= maxHeight){
                    mtm.put((random.nextInt(200) - 100), (random.nextInt(200) - 100));
                }
                if(mtm.isBalanced()){
                    t += 1;
                }
            }
            System.out.print(t);
            System.out.println();
            System.out.println("Процент сбалансированных деревьев: " + (100 / treeNumber * t));
        }
    }
}
