# Symbol Table

A type of Data Structure in which we store the data in the for of a Key, Value pair.  
Where we insert that data in the form of Key, Value Pair, And we retrieve the Value corresponding to the given Key from
the Symbol Table. All the Key Value pairs are generic, so we can keep anything as a key, or a value.

> Symbol Table could be of two types:
> - **[Ordered Symbol Table](./ordered)**: the pair is stored based on the order of Keys, and we support the operation based on that as well
> - **[Unordered Symbol Table](./unordered)**: the way the pair is stroed is independent of the keys.

This is the basic skeleton of the Symbol Table which is followed by both Ordered and Unordered Symbol Table

```java
// a skeleton to implement basic operation of Symbol Table with a generic Key, Value pair
public interface SymbolTable<Key, Value> {

    // get the value from the symbol table for the given key
    Value get(Key key);

    // set the value in the symbol table for the given key, to update or create a new entry
    void put(Key key, Value value);

}
```