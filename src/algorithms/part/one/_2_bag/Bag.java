package algorithms.part.one._2_bag;

import java.util.Iterator;

// A bag of generic data items
// a linear data type that stores data
public class Bag<P> implements Iterable<P> {

    //    private inner class to implement LinkedList
    private class Node {
        //        data of generic type
        P data;
        //        pointer to the next node
        Node next;

        //        constructor to initialize the node
        public Node(P data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //    private inner class to implement An iterator of Bag so that we can make the bag iterable
    private class BagIterator implements Iterator<P> {
        //        node to store the current element
        private Node current;

        //        to initialise the current node as start
        public BagIterator() {
            current = start;
        }

        //        to check if the next element is present or not in the Bag
        @Override
        public boolean hasNext() {
            return current != null;
        }

        //        if next element is present return the data from the element and move to next, otherwise throw custom exception
        @Override
        public P next() {
            if (!hasNext())
                throw new EmptyBagException();
            Node temp = current;
            current = current.next;
            return temp.data;
        }
    }

    //    Head of the linked list containing all the elements in the bag
    private Node start;
    //    to keep the count of elements in the bag
    private int size;

    //    initialise an empty bag
    public Bag() {
        start = null;
    }

    //    add an element in the bag
    public void add(P data) {
        start = new Node(data, start);
        size++;
    }

    //    get the size of the bag
    public int size() {
        return size;
    }

    //    to check if the bag is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    //    to return an iterator, which makes the Bag iterable
    @Override
    public Iterator<P> iterator() {
        return new BagIterator();
    }

    //    to display the items in bag
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

}
