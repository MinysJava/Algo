package Lesson_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArray(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (Item[]) new Object[capacity];
    }

    public MyArray(){

        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(Item item){
        cheakLength();
        list[size] = item;
        size++;
    }

    public void add(int index, Item item){
        cheakLength();
        if(index < 0){
            index = 0;
        }

        if (index > size){
            index = size;
        }

        for (int i = size; i > index ; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }
//-----------------------------------------------------------------------------------------
//-------------------Увеличивает размер массива при его заполнении----------------------
    private void cheakLength() {
        if (list[list.length - 1] != null){
            Item[] newList =(Item[]) new Object[(list.length * 2)];
            System.arraycopy(list,0, newList,0, list.length);
            list = newList;
        }
    }
//---------------------------------------------------------------------------------------
    public boolean remove(Item item){
        int i = 0;
        while (i < size && !list[i].equals(item)){
            i++;
        }
        if(i == size){
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public Item get (int index){
        return list[index];
    }

    public void set(int index, Item item){
        list[index] = item;
    }

    public int size(){
        return size;
    }

    public boolean find(Item item){
        for (int i = 0; i < size; i++) {
            if(list[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++){
            s += list[i] + " ";
        }
        return s;
    }
}
