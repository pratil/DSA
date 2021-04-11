package bag;

import java.util.Iterator;

public class Bag<P> implements Iterable<P> {

    private Node start;
    private int size;

    public Bag() {
        start = null;
    }

    public void add(P data) {
        start = new Node(data, start);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<P> iterator() {
        return new BagIterator();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Bag: { size=0 }";
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Bag: {\n")
                .append("  size=> ").append(size).append("\n");
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

        public Node(P data) {
            this.data = data;
            next = null;
        }

        public Node(P data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class BagIterator implements Iterator<P> {
        private Node current;

        public BagIterator() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public P next() {
            if (!hasNext())
                throw new EmptyBagException();
            Node temp = current;
            current = current.next;
            return temp.data;
        }
    }
}
