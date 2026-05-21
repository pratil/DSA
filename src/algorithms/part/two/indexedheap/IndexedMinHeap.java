package algorithms.part.two.indexedheap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IndexedMinHeap<Key extends Comparable<Key>> implements IndexedBinaryHeapTree<Key> {

    private final int capacity;
    private int size;
    private final int[] pq;
    private final int[] qp;
    private final Key[] keys;

    public IndexedMinHeap(int max_size) {
        if (max_size < 0) throw new IllegalArgumentException("Capacity cannot be negative");
        this.capacity = max_size;
        size = 0;
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        keys = (Key[]) new Comparable[capacity + 1];
        Arrays.fill(qp, -1);
    }

    private void validate(int index) {
        if (index < 0 || index > capacity)
            throw new IllegalArgumentException("Invalid index");
    }

    private void swap(int first, int second) {
        IndexedBinaryHeapTree.super.swap(pq, qp, first, second);
    }

    private boolean isLess(int first, int second) {
        return IndexedBinaryHeapTree.super.isLess(keys, pq, first, second);
    }

    private boolean isGreater(int first, int second) {
        return IndexedBinaryHeapTree.super.isGreater(keys, pq, first, second);
    }

    @Override
    public boolean contains(int index) {
        validate(index);
        return qp[index] != -1;
    }

    @Override
    public Key get(int index) {
        if (!contains(index)) throw new NoSuchElementException("No elements present in Heap/Priority Queue");
        return keys[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, Key key) {
        if (contains(index)) throw new IllegalArgumentException("Index " + index + " already contains a Key");
        size++;
        qp[index] = size;
        pq[size] = index;
        keys[index] = key;
        swim(size);
    }

    @Override
    public Key peek() {
        if (size == 0) throw new NoSuchElementException("No elements present in Heap/Priority Queue");
        return keys[pq[1]];
    }

    @Override
    public Key delete(int index) {
        Key minimum = peek();
        int minIndex = pq[1];
        swap(1, size);
        size--;
        sink(1);
        assert minimum == keys[pq[size + 1]];
        qp[minIndex] = -1;
        keys[minIndex] = null;
        pq[size + 1] = -1;
        return minimum;
    }

    @Override
    public void swim(int index) {
        while (index > 1 && isGreater(index / 2, index)) {
            swap(index / 2, index);
            index /= 2;
        }
    }

    @Override
    public void sink(int index) {
        int leftChildIndex = 2 * index, rightChildIndex = 2 * index + 1;
        int minimumIndex = index;
        while (2 * index <= size) {
            if (isLess(leftChildIndex, minimumIndex))
                minimumIndex = leftChildIndex;
            if (rightChildIndex <= size && isLess(rightChildIndex, minimumIndex))
                minimumIndex = rightChildIndex;
            if(minimumIndex != index) {
                swap(index, minimumIndex);
                index = minimumIndex;
            }
        }
    }

    @Override
    public void decreaseKey(int index, Key key) {
        if (!contains(index)) throw new NoSuchElementException("No elements present in Heap/Priority Queue");
        if (!isLess(key, keys[pq[index]])) throw new IllegalArgumentException("New key is not less than the old Key");
        keys[index] = key;
        swim(qp[index]);
    }

    @Override
    public void increaseKey(int index, Key key) {
        if (!contains(index)) throw new NoSuchElementException("No elements present in Heap/Priority Queue");
        if (!isLess(key, keys[pq[index]]))
            throw new IllegalArgumentException("New key is not greater than the old Key");
        keys[index] = key;
        sink(qp[index]);
    }
//
//    @Override
//    public void changeKey(int index, Key key) {
//
//    }
}
