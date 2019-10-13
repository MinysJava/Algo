package Lesson_6;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    Node root;

    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }

    public int size(){
        return size(root);
    }

    public int height(){
        return height(root);
    }

    public Value get(Key key){
        return get(root, key);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public  boolean contains (Key key){
        return get(root, key) != null;
    }

    public void put(Key key, Value value){
        isKeyNotNull(key);
        if(value == null){
            delete(key);
        }
        root = put(root, key, value);
    }

    public Key minKey(){
        return min(root).key;
    }

    public Key maxKey(){
        return max(root).key;
    }

    public void delete(Key key){
        isKeyNotNull(key);
        delete(root, key);
    }

    private Node put (Node node, Key key, Value value){
        if(node == null){
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            node.value = value;
        } else if(cmp < 0){
            node.left = put(node.left, key, value);
            node.height = height(node.left) + 1;
        } else {
            node.right = put(node.right, key, value);
            node.height = height(node.right) + 1;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size (Node node){
        if(node == null){
            return 0;
        }
        return node.size;
    }

    private int height (Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private boolean isKeyNotNull(Key key){
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        return true;
    }

    private Value get(Node node, Key key){
        isKeyNotNull(key);
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node.value;
        } else if(cmp < 0){
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    private String toString(Node node){
        if(node == null){
            return "";
        }
        return toString(node.left) + " " +
                node.key.toString() + " = " + node.value.toString() +
                ", " + toString(node.right);
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node){
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }

    private Node deleteMin(Node node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node delete(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = delete(node.left, key);
        } else if(cmp > 0){
            node.right = delete(node.right, key);
        } else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            Node minNode = min(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = deleteMin(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }
}
