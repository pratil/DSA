package algorithms.part.one._7_symboltable.unordered;

import algorithms.part.one._7_symboltable.SymbolTable;

import java.util.Arrays;

public class LinearProbing<Key, Value> implements SymbolTable<Key, Value> {

    private final int SIZE;

    private final Key[] keys;

    private final Value[] values;

    public LinearProbing(int size) {
        SIZE = size;
        keys = (Key[]) new Object[SIZE];
        values = (Value[]) new Object[SIZE];
    }

    public LinearProbing() {
        this(9);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % SIZE;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % SIZE)
            if (key.equals(keys[i]))
                return values[i];
        return null;
    }

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

    @Override
    public String toString() {
        return "LinearProbing => { " +
                " size = " + SIZE +
                ", keys=" + Arrays.toString(keys) +
                " }";
    }
}