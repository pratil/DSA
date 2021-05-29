package algorithms.part.one._7_symboltable;

// a skeleton to implement basic operation of Symbol Table with a generic Key, Value pair
public interface SymbolTable<Key, Value> {

    // to get the value from the symbol table for the given key
    Value get(Key key);

    // to set the value in the symbol table for the given key, to update or create a new entry
    void put(Key key, Value value);

}
