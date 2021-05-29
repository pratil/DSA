package algorithms.part.one._7_symboltable.unordered;

import algorithms.part.one._7_symboltable.SymbolTable;

import java.util.ArrayList;

// It is one of the collision resolution techniques where if we find a collision on the index given by hashing
// we create a Linked List and store the head in the index position
public class SeparateChaining<Key, Value> implements SymbolTable<Key, Value> {

    private final int SIZE; // sine of the array
    private final ArrayList<Node> hashArray; // list of nodes which will act as a hash array

    // to initialize the Symbol Table of the given size
    public SeparateChaining(int size) {
        SIZE = size;
        hashArray = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++)
            hashArray.add(null);
    }

    // to initialize the Symbol Table for the default size
    public SeparateChaining() {
        this(9);
    }

    // to get the hash value for the given key
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % SIZE;
    }

    // to get the value from the symbol table for the given key
    @Override
    public Value get(Key key) {
        int hash = hash(key);
        Node pointer = hashArray.get(hash);
        while (pointer != null && pointer.key != key)
            pointer = pointer.next;
        return (pointer != null) ? pointer.value : null;
    }

    // to set the value in the symbol table for the given key, to update or create a new entry
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

    // to print the hash array (as i liked it 😁)
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

    // Node to create a Linked List
    private class Node {
        Key key; // symbol table key
        Value value; // symbol table value
        Node next; // pointer to the next node

        // to initialize a node
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // to print the hash array (as i liked it 😁)
        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}