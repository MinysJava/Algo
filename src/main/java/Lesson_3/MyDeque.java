package Lesson_3;

import java.util.EmptyStackException;

public class MyDeque<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEF_CAP = 10;
    private int begin = 0;
    private int end = 0;


    public MyDeque(int capacity) {
        if(capacity <= 0){
            throw  new IllegalArgumentException("bad size" + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyDeque() {
        list = (Item[]) new Object[DEF_CAP];
    }

    public void insertRight(Item item){
        if(isFull()){
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(Item item){
        if(isFull()){
            throw new StackOverflowError();
        }
        size++;
        list[prevIndex(begin)] = item;
        begin = prevIndex(begin);
    }

    public Item removeLeft(){
        Item value = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public Item removeRight(){
        Item value = peekRight();
        size--;
        list[prevIndex(end)] = null;
        end = prevIndex(end);
        return value;
    }

    public Item peekRight(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[prevIndex(end)];
    }

    public Item peekLeft(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[begin];
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    private int prevIndex(int index){
        if(index == 0){
            return list.length - 1;
        }
        return (index - 1) % list.length;
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
