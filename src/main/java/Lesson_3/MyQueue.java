package Lesson_3;

import java.util.EmptyStackException;

public class MyQueue<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEF_CAP = 10;
    private int begin = 0;
    private int end = 0;


    public MyQueue(int capacity) {
        if(capacity <= 0){
            throw  new IllegalArgumentException("bad size" + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyQueue() {
        list = (Item[]) new Object[DEF_CAP];
    }

    public void insert(Item item){
        if(isFull()){
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public Item remove(){
        Item value = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public Item peekFront(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[begin];
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }
}
