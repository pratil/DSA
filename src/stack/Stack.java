package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<P> implements Iterable<P> {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

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

    public P pop() {
        if (top == null)
            throw new EmptyStackException();
        Node deletedNode = top;
        top = top.next;
        size--;
        return deletedNode.data;
    }

    public P peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<P> iterator() {
        return new StackIterator();
    }

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

    private class Node {
        P data;
        Node next;

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
}
