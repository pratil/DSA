package _3_stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

// to create a generic Stack Data Structure
public class Stack<P> implements Iterable<P> {

    // private inner class to implement LinkedList
    private class Node {
        P data; // data of generic type
        Node next; // pointer to the next node

        // constructors to initialize the node
        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(P data) {
            this.data = data;
            this.next = null;
        }

        public Node(P data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class StackIterator implements Iterator<P> {
        private Node current;

        public StackIterator() {
            this.current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public P next() {
            if (!hasNext())
                throw new NoSuchElementException("no element found");
            Node temp = current;
            current = current.next;
            return temp.data;
        }
    }

    private Node top; // to store the top of the stack
    private int size; // to store the size of stack

    // to initialize the Stack
    public Stack() {
        top = null;
        size = 0;
    }

    // to push (insert) data in stack on the top
    public P push(P item) {
        if (item == null)
            throw new NullPointerException("null values cannot be pushed");
        if (top == null)
            top = new Node(item);
        else {
            Node newTop = new Node(item);
            newTop.next = top;
            top = newTop;
        }
        size++;
        return top.data;
    }

    // to pop (delete) data from stack from the top
    public P pop() {
        if (top == null)
            throw new EmptyStackException();
        Node deletedNode = top;
        top = top.next;
        size--;
        return deletedNode.data;
    }

    // to peek (get) data from the top of stack
    public P peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    // to get the size of Stack
    public int size() {
        return size;
    }

    // to check if the Stack is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // to get the iterator of Stack, to make the Stack iterable
    @Override
    public Iterator<P> iterator() {
        return new StackIterator();
    }

    // to print the Stack (as i liked it 😁)
    @Override
    public String toString() {
        if (isEmpty())
            return "stack.Stack: { size=0 }";
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("stack.Stack: {\n")
                .append("  size=> ").append(size).append("\n")
                .append("  top=> ").append(top.data).append("\n");
        stringBuffer.append("  contents=> {\n");
        for (P p : this)
            stringBuffer.append("    ").append(p).append("\n");
        stringBuffer.append("  }\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

}
