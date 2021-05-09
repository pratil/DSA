package algorithms.part.one._7_symboltable.unordered;

import algorithms.part.one._7_symboltable.SymbolTable;

import java.util.ArrayList;

public class SeparateChaining<Key, Value> implements SymbolTable<Key, Value> {

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final int SIZE;

    private final ArrayList<Node> hashArray;

    public SeparateChaining(int size) {
        SIZE = size;
        hashArray = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++)
            hashArray.add(null);
    }

    public SeparateChaining() {
        this(9);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % SIZE;
    }

    @Override
    public Value get(Key key) {
        int hash = hash(key);
        Node pointer = hashArray.get(hash);
        while (pointer != null && pointer.key != key)
            pointer = pointer.next;
        return (pointer != null) ? pointer.value : null;
    }

    @Override
    public void put(Key key, Value value) {
        int hash = hash(key);
        Node pointer = hashArray.get(hash);
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                pointer.value = value;
                return;
            }
            pointer = pointer.next;
        }
        pointer = new Node(key, value, hashArray.get(hash));
        hashArray.set(hash, pointer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SeparateChaining => {\n");
        stringBuilder.append("  size => " + SIZE + "\n");
        stringBuilder.append("  hash table => {\n");
        for (int i = 0; i < SIZE; i++) {
            stringBuilder.append("    ").append(i).append(" => [");
            Node pointer = hashArray.get(i);
            while (pointer != null) {
                stringBuilder.append(pointer).append(" ");
                pointer = pointer.next;
            }
            stringBuilder.append("]\n");
        }
        stringBuilder.append("  }\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}