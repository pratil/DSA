# Bag

> A basic data structure to store the elements. Contains a list of generic items. Basic operations:

- **add()**: add an element in the bag
- **size()**: get the size of the bag
- **isEmpty()**: to check if the bag is empty or not
- **iterator()**: to get a custom iterator, or for non-java code a list of items in the bag

```java
// java class
// A bag of generic data items
// a linear data type that stores data
public class Bag<P> implements Iterable<P> {

//    private inner class to implement an iterator of Bag, so that the bag is Iterable
    private class BagIterator implements Iterator<P> { /* code here */ }
    
//    initialise a bag
    public Bag() { /* code here */ }
    
//    add an element in the bag
    public void add() { /* code here */ }
    
//    get the size of the bag
    public int size() { /* code here */ }
    
//    to check if the bag is empty or not
    public boolean isEmpty() { /* code here */ }
    
//    to return an iterator, which makes the Bag iterable
    @Override
    public Iterator<P> iterator() { /* code here */ }
    
}
```