package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<P> implements Iterable<P> {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    public P add(P data) {
        if (data == null)
            throw new NullPointerException("null values cannot be pushed");
        if (front == null)
            front = rear = new Node(data);
        else {
            rear.next = new Node(data);
            rear = rear.next;
        }
        size++;
        return rear.data;
    }

    public P poll() {
        if (front == null)
            return null;
        else {
            Node deletedElement = front;
            front = front.next;
            size--;
            return deletedElement.data;
        }
    }

    public P remove() {
        P data = poll();
        if (data == null)
            throw new EmptyQueueException();
        return data;
    }

    public P peek() {
        if (front == null)
            return null;
        return front.data;
    }

    public P element() {
        P data = peek();
        if (data == null)
            throw new EmptyQueueException();
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<P> iterator() {
        return new QueueIterator();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "queue.Queue: { size=0 }";
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("queue.Queue: {\n")
                .append("  size=> ").append(size).append("\n")
                .append("  front=> ").append(front.data).append("\n")
                .append("  rear=> ").append(rear.data).append("\n")
                .append("  contents=> {\n");
        for (P p : this)
            stringBuffer.append("    ").append(p).append("\n");
        stringBuffer.append("  }\n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private class Node {
        P data;
        Node next;

        Node() {
            data = null;
            next = null;
        }

        Node(P data) {
            this.data = data;
            next = null;
        }

        Node(P data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class QueueIterator implements Iterator<P> {
        Node current;

        public QueueIterator() {
            current = front;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public P next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node temp = current;
            current = current.next;
            return temp.data;
        }
    }
}
