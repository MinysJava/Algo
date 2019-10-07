package Lesson_4;

public class MyLinkedQueue<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public void insert(T value){
        stack.insertLast(value);
    }

    public T remove(){
        return stack.removeFirst();
    }

    public T peekFront(){
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
