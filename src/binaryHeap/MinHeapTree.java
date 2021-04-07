package binaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapTree<P extends Comparable<P>> implements BinaryHeapTree<P> {

    private final List<P> array;

    public MinHeapTree() {
        array = new ArrayList<>();
    }

    public MinHeapTree(List<P> array) {
        this.array = array;
        for (int i = array.size() / 2; i > 1; i--)
            sink(i);
    }

    public MinHeapTree(P[] array) {
        this(Arrays.asList(array));
    }

    @Override
    public void swim(int index) {
        if (index <= 1)
            return;
        if (compare(array, index, index / 2) < 0) {
            swap(array, index, index / 2);
            swim(index / 2);
        }
    }

    @Override
    public void sink(int index) {
        if (2 * index > array.size())
            return;
        int leftChildIndex = 2 * index, rightChildIndex = 2 * index + 1;
        int minimumIndex = index;
        if (leftChildIndex <= array.size() && compare(array, leftChildIndex, minimumIndex) < 0)
            minimumIndex = leftChildIndex;
        if (rightChildIndex <= array.size() && compare(array, rightChildIndex, minimumIndex) < 0)
            minimumIndex = rightChildIndex;
        if (minimumIndex != index) {
            swap(array, index, minimumIndex);
            sink(minimumIndex);
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
        P minimum = peek();
        swap(array, 1, array.size());
        array.remove(array.size() - 1);
        sink(1);
        return minimum;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public String toString() {
        if (array.size() < 1)
            return "MinHeapTree => { size: 0 }";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MinHeapTree => {\n");
        stringBuilder.append("  ").append("size => ").append(array.size()).append("\n");
        stringBuilder.append("  ").append("array => [\n");
        for (int i = 0; i < array.size(); i++)
            stringBuilder.append("    [").append(i + 1).append("] -> ").append(array.get(i)).append("\n");
        stringBuilder.append("  ").append("]\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

