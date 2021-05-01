# Stack

A Data Structure to store items in a Stack, i.e. LIFO order (Last In First Out)
Contains all the list of generic items, and some basic operations:

- **push()**: to add or put data in a stack
- **pop()**: to delete or remove the data from stack
- **peek()**: to get the last top item from stack
- **size()**: get the size of the stack
- **isEmpty()**: to check if the stack is empty or not
- **iterator()**: to get a custom iterator, or for non-java code a list of items in the stack

```java
// java class
// to create a generic Stack Data Structure
public class Stack<P> implements Iterable<P> {

    // to initialize the Stack
    public Stack() { /* code here */ }

    // to push (insert) data in stack on the top
    public P push(P item)  { /* code here */ }

    // to pop (delete) data from stack from the top
    public P pop() { /* code here */ }

    // to peek (get) data from the top of stack
    public P peek()  { /* code here */ }

    // to get the size of Stack
    public int size()  { /* code here */ }

    // to check if the Stack is empty or not
    public boolean isEmpty() { /* code here */ }

    // to return the iterator of Stack, to make the Stack iterable
    @Override
    public Iterator<P> iterator() { /* code here */ }

    // private inner class to implement an iterator for Stack, so that the Stack is Iterable
    private class StackIterator implements Iterator<P> { /* code here */ }
    
}

```