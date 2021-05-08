package _4_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

// to create a generic Queue Data Structure
public class Queue<P> implements Iterable<P> {

    // private inner class to implement LinkedList
    private class Node {
        P data; // data of generic type
        Node next; // pointer to the next node

        // constructors to initialize the node
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

    // to store the start of the queue
    private Node front;

    // to store the end of the queue
    private Node rear;

    // to store the size of the queue
    private int size;

    // to initialize the Queue
    public Queue() {
        front = rear = null;
        size = 0;
    }

    // to insert data in Queue from rear (end)
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

    // to delete data from Queue from front (start)
    // returns null if no item present
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

    // to delete data from Queue from front (start)
    // throws exception if no item present
    public P remove() {
        P data = poll();
        if (data == null)
            throw new EmptyQueueException();
        return data;
    }

    // to peek (get) data from the front(start) of queue
    // returns null if no item present
    public P peek() {
        if (front == null)
            return null;
        return front.data;
    }

    // to peek (get) data from the front(start) of queue
    // throws exception if no item present
    public P element() {
        P data = peek();
        if (data == null)
            throw new EmptyQueueException();
        return data;
    }

    // to get the size of Queue
    public int size() {
        return size;
    }

    // to check if the Queue is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // to return the iterator of Queue, to make the Queue iterable
    @Override
    public Iterator<P> iterator() {
        return new QueueIterator();
    }

    // to print the Queue (as i liked it 😁)
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
