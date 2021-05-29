package algorithms.part.one._7_symboltable.unordered;

import algorithms.part.one._7_symboltable.SymbolTable;

import java.util.Arrays;

// It is one of the collision resolution techniques where if we find a collision on the index given by hashing
// we check the subsequent index until we find one
public class LinearProbing<Key, Value> implements SymbolTable<Key, Value> {

    private final int SIZE; // sine of the array

    private final Key[] keys; // array of keys

    private final Value[] values; // array of values

    // to initialize the Symbol Table of the given size
    public LinearProbing(int size) {
        SIZE = size;
        keys = (Key[]) new Object[SIZE];
        values = (Value[]) new Object[SIZE];
    }

    // to initialize the Symbol Table for the default size
    public LinearProbing() {
        this(9);
    }

    // to get the hash value for the given key
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % SIZE;
    }

    // to get the value from the symbol table for the given key
    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % SIZE)
            if (key.equals(keys[i]))
                return values[i];
        return null;
    }

    // to set the value in the symbol table for the given key, to update or create a new entry
    @Override
    public void put(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % SIZE) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
    }

    // to print the hash array (as i liked it 😁)
    @Override
    public String toString() {
        return "LinearProbing => { " +
                " size = " + SIZE +
                ", keys=" + Arrays.toString(keys) +
                " }";
    }
}