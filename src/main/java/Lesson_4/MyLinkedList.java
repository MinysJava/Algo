package Lesson_4;

import java.util.Iterator;

public class MyLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item>{

        Node current = new Node(null, first);
        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public Item next() {
            current = current.getNext();
            return (Item) current.getValue();
        }

        @Override
        public void remove() {

        }
    }

    private class Node<Item>{
        private Item value;
        private Node next;
        private Node prev;

        public Node(Item value) {
            this.value = value;
        }

        public Node(Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public void insertFirst(Item item){
        Node newNode = new Node(item);
        newNode.setNext(first);
        if(isEmpty()){
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()){
            throw new NullPointerException("List is Empty");
        }
        Node temp = first;
        first = first.getNext();
        size--;
        if(isEmpty()){
            last = null;
        }else {
            first.setPrev(null);
        }
        return (Item) temp.getValue();
    }

    public void insertLast(Item item){
        Node newNode = new Node(item);
        if(isEmpty()){
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public Item removeLast(){
        if (isEmpty()){
            throw new NullPointerException("List is Empty");
        }
        Node temp = last;
        if(last.getPrev() != null){
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        size--;
        last = last.getPrev();
        return (Item) temp.getValue();
    }

    public void insert(Item item, int index){
        if(index <= 0){
            insertFirst(item);
            return;
        }
        if(index > size){
            index = size;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1){
            current = current.getNext();    // заменить на .next
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext()); // заменить на .next
        newNode.setPrev(current.getNext());
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        size++;
    }

    public boolean remove (Item item){
        if(isEmpty()){
            return false;
        }
        if(first.getValue().equals(item)){
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.getValue().equals(item)){
            current = current.getNext();
        }
        if (current == null){
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public boolean contains(Item item){
        return indexOf(item) > -1;
    }

    public int indexOf(Item item){
        Node current = first;
        int index = 0;
        while (current != null){
            if(current.getValue().equals(item)){
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public Item getFirst() {
        if (isEmpty()){
            throw  new NullPointerException("List is Empty");
        }
        return (Item) first.getValue(); // заменить на .value
    }

    public Item getLast() {
        if (isEmpty()){
            throw  new NullPointerException("List is Empty");
        }
        return (Item) last.getValue(); // заменить на .value
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null){
            sb.append(current.getValue() + ", ");
            current = current.getNext();    // заменить на .next
        }
        return sb.toString();
    }
}
