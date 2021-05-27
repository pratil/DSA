package algorithms.part.one._6_binaryheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// a child of Binary Heap Tree to implement Max Heap Tree
public class MaxHeapTree<P extends Comparable<P>> implements BinaryHeapTree<P> {

    // array to store the elements in a virtual tree
    private final List<P> array;

    // to initialize an empty array
    public MaxHeapTree() {
        array = new ArrayList<>();
    }

    // to initialize the array based on the given List and convert it into a Max Heap Tree
    public MaxHeapTree(List<P> array) {
        this.array = array;
        for (int i = array.size() / 2; i > 1; i--)
            sink(i);
    }

    // to initialize the array based on the given array and convert it into a Max Heap Tree
    public MaxHeapTree(P[] array) {
        this(Arrays.asList(array));
    }

    // function to swim an index from a heap position to it's upper positions if required
    // i.e. if it is less than it's child it should be moved up recursively in the heap
    @Override
    public void swim(int index) {
        if (index <= 1)
            return;
        if (compare(array, index, index / 2) > 0) {
            swap(array, index, index / 2);
            swim(index / 2);
        }
    }

    // function to sink an index from a heap position to it's lower positions if required
    // i.e. if it is greater than it's child it should be moved down recursively in the heap
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

    // to get the root of the tree i.e. the top of the tree
    @Override
    public P peek() {
        return array.get(0);
    }

    // to insert a new element in the tree
    @Override
    public P insert(P element) {
        array.add(element);
        swim(array.size());
        return element;
    }

    // to delete an element from the tree
    @Override
    public P delete() {
        P maximum = peek();
        swap(array, 1, array.size());
        array.remove(array.size() - 1);
        sink(1);
        return maximum;
    }

    // to get the size of the tree
    @Override
    public int size() {
        return array.size();
    }


    // to print the Heap (as i liked it 😁)
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
