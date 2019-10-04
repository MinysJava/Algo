package Lesson_3;

public class Main {
    public static void main(String[] args) {
//        MyStack<Integer> stack = new MyStack<>();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stack.pop());
//
//        }
//        Expreesion e = new Expreesion("(4-5) + [34-{2-3}]");
//        System.out.println(e.cheakBracket());

        MyQueue<Integer> queue = new MyQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.insert(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.remove());
        }
    }
}
