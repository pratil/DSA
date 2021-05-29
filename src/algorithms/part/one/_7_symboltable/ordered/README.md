# Ordered Symbol Table

This is a form of symbol table where the way we store the data is dependent on the Keys. Keys need to be comparable, as
the Ordered Symbol Table supports buck of operation based on the keys.

```java
// a skeleton to implement basic operation of Ordered Symbol Table
// to implement a generic Key, Value pair, where Key will be comparable
// and will support queries related to the order of keys
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    // to get the minimum key in the Symbol table
    Key getMinimum();

    // to get the maximum key in the Symbol table
    Key getMaximum();

    // to get the largest key smaller than the given key
    Key floor(Key key);

    // to get the smallest key larger than the given key
    Key ceil(Key key);

    // to give the size of the symbol table
    int size();

    // to give the rank of the given key i.e. number of keys which are smaller than the current key
    int rank(Key key);

    // to get the list of the keys in ascending order
    Iterable<Key> keys();

    // to get the list of the keys in ascending order in the given range
    Iterable<Key> keys(Key start, Key end);

    // to get the number of the keys in ascending order in the given range
    int countKeys(Key start, Key end);

    // to check if the given key is present or not in the Symbol Table
    boolean containsKey(Key key);

    // to delete the key value pair from the symbol table corresponding to the given key
    Value delete(Key key);

}
```
