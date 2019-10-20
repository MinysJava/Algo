package Lesson_8;

public class LinearProbingHashMap<Key, Value> {
    private int capacity = 7;
    private int size = 0;

    private Key[] keys = (Key[]) new Object[capacity];
    private Value[] values = (Value[]) new Object[capacity];
    private boolean[] delete = new boolean[capacity];


    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(Key key, Value value){
        isKeyNotNull(key);
        if(size == capacity - 1){
            throw new IllegalArgumentException("Array full");
        }
        int i;
        for (i = hash(key); (keys[i] != null && !delete[i]); i = (i + 1) % capacity) {
            if(keys[i].equals(key)){
                values[i] = value;
                delete[i] = false;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        delete[i] = false;
        size++;
    }

    public Value get (Key key){
        isKeyNotNull(key);
        int i;
        for (i = hash(key); (keys[i] != null || delete[i]); i = (i + 1) % capacity) {
            if(keys[i] != null && keys[i].equals(key)){
               return values[i];
            }
        }
        return null;
    }
//-------------- Удаление ------------------------
    public void del (Key key){
        isKeyNotNull(key);
        for (int i = 0; i < capacity; i++) {
            if(keys[i] != null && keys[i].equals(key)){
                delete[i] = true;
                keys[i] = null;
                values[i] = null;
                return;
            }
        }
    }
//-----------------------------------------------
    private boolean isKeyNotNull (Key key){
        if(key == null){
            throw new IllegalArgumentException("Null is BAD!!");
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {

            sb.append(keys[i] + " = " + values[i] + ", del - " + delete[i]);

            sb.append("\n");
        }
        return sb.toString();
    }
}
