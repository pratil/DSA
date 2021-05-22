# Queue

A Data Structure to store items in a Queue, i.e. FIFO order (First In First Out)
Contains all the list of generic items, and some basic operations:

- **add()**: to insert data in Queue from rear (end)
- **poll()**: to delete data from Queue from front (start), returns null if no item present
- **remove()**: to delete data from Queue from front (start), throws exception if no item present
- **peek()**: to peek (get) data from the front(start) of queue, returns null if no item present
- **element()**: to peek (get) data from the front(start) of queue, throws exception if no item present
- **size()**: get the size of the queue
- **isEmpty()**: to check if the queue is empty or not
- **iterator()**: to get a custom iterator, or for non-java code a list of items in the queue

```java
// java class
// to create a generic Queue Data Structure
public class Queue<P> implements Iterable<P> {

    // to initialize the Queue
    public Queue() { /* code here */ } 

    // to insert data in Queue from rear (end)
    public P add(P data) { /* code here */ } 

    // to delete data from Queue from front (start)
    // returns null if no item present
    public P poll() { /* code here */ } 

    // to delete data from Queue from front (start)
    // throws exception if no item present
    public P remove() { /* code here */ } 

    // to peek (get) data from the front(start) of queue
    // returns null if no item present
    public P peek() { /* code here */ } 

    // to peek (get) data from the front(start) of queue
    // throws exception if no item present
    public P element() { /* code here */ } 

    // to get the size of Queue
    public int size() { /* code here */ } 

    // to check if the Queue is empty or not
    public boolean isEmpty() { /* code here */ } 

    // to return the iterator of Queue, to make the Queue iterable
    @Override
    public Iterator<P> iterator() { /* code here */ }  

    // private inner class to implement an iterator for Queue, so that the Queue is Iterable
    private class QueueIterator implements Iterator<P> { /* code here */ } 
}

```