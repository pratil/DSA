package _7_symboltable.ordered;

import _7_symboltable.SymbolTable;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    Key getMinimum();

    Key getMaximum();

    Key floor(Key key);

    Key ceil(Key key);

    int size();

    int rank(Key key);

    Iterable<Key> keys();

    Iterable<Key> keys(Key start, Key end);

    int countKeys(Key start, Key end);

    boolean containsKey(Key key);

}
