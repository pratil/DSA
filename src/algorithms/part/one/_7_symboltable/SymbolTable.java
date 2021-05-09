package algorithms.part.one._7_symboltable;

public interface SymbolTable<Key, Value> {

    Value get(Key key);

    void put(Key key, Value value);

}
