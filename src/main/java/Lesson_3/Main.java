package Lesson_3;

public class Main {
    public static void main(String[] args) {

        MyDeque<Integer> deque = new MyDeque<>(5);
        deque.insertLeft(0);
        deque.insertLeft(-1);
        deque.insertRight(1);
        while( !deque.isEmpty() ){
            int n = deque.removeLeft();
            System.out.println(n);
        }

        String str = "12345";

        System.out.println(reversString(str));
    }

    public static String reversString(String str){
        String reversStr = "";
        char[] symbol = str.toCharArray();

        for (int i = symbol.length - 1; i >= 0; i--) {
            reversStr += symbol[i];
        }
        return reversStr;
    }
}
