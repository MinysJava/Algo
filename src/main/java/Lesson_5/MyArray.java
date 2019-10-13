package Lesson_5;


public class MyArray<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArray(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (Item[]) new Comparable[capacity];
    }

    public MyArray(){

        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
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
//-------------------Увеличивает размер массива при его заполнении-----------------------
    private void cheakLength() {
        if (list[list.length - 1] != null){
            Item[] newList =(Item[]) new Comparable[(list.length * 2)];
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

    private boolean less(Item item1, Item item2){
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2){
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void seletionSort(){
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if(less(list[j], list[iMin])){
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertSort(){
        Item key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];

            while (j > 0 && less(key, list[j - 1])){
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort(){
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])){
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    private void quickSort(int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        Item opora = list[mid];

        int i = low;
        int j = high;
        while (i <= j){
            while (less(list[i], opora)){
                i++;
            }
            while (less(opora, list[j])){
                j--;
            }
            if(i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }

        if(low < j){
            quickSort(low, j);
        }

        if(high > i){
            quickSort(i, high);
        }
    }

    public void qSort(){
        quickSort(0, size - 1);
    }
}
