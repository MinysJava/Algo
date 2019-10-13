package Lesson_4;

public class MyLinkedStack<T> {
    private MyOneLinkedList<T> stack = new MyOneLinkedList<>();

    public void push(T value){
        stack.insertFirst(value);
    }

    public T pop(){
        return stack.removeFirst();
    }

    public T peek(){
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
