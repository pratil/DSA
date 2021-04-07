package binaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeapTree<P extends Comparable<P>> implements BinaryHeapTree<P> {

    private final List<P> array;

    public MaxHeapTree() {
        array = new ArrayList<>();
    }

    public MaxHeapTree(List<P> array) {
        this.array = array;
        for (int i = array.size() / 2; i > 1; i--)
            sink(i);
    }

    public MaxHeapTree(P[] array) {
        this(Arrays.asList(array));
    }

    @Override
    public void swim(int index) {
        if (index <= 1)
            return;
        if (compare(array, index, index / 2) > 0) {
            swap(array, index, index / 2);
            swim(index / 2);
        }
    }

    @Override
    public void sink(int index) {
        if (2 * index > array.size())
            return;
        int leftChildIndex = 2 * index, rightChildIndex = 2 * index + 1;
        int maximumIndex = index;
        if (leftChildIndex <= array.size() && compare(array, leftChildIndex, maximumIndex) > 0)
            maximumIndex = leftChildIndex;
        if (rightChildIndex <= array.size() && compare(array, rightChildIndex, maximumIndex) > 0)
            maximumIndex = rightChildIndex;
        if (maximumIndex != index) {
            swap(array, index, maximumIndex);
            sink(maximumIndex);
        }
    }

    @Override
    public P peek() {
        return array.get(0);
    }

    @Override
    public P insert(P element) {
        array.add(element);
        swim(array.size());
        return element;
    }

    @Override
    public P delete() {
        P maximum = peek();
        swap(array, 1, array.size());
        array.remove(array.size() - 1);
        sink(1);
        return maximum;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public String toString() {
        if (array.size() < 1)
            return "MaxHeapTree => { size: 0 }";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MaxHeapTree => {\n");
        stringBuilder.append("  ").append("size => ").append(array.size()).append("\n");
        stringBuilder.append("  ").append("array => [\n");
        for (int i = 0; i < array.size(); i++)
            stringBuilder.append("    [").append(i + 1).append("] -> ").append(array.get(i)).append("\n");
        stringBuilder.append("  ").append("]\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
