package _6_binaryheap;

import java.util.List;

public interface BinaryHeapTree<P extends Comparable<P>> {

    default void swap(List<P> array, int first, int second) {
        first--;
        second--;
        P temp = array.get(first);
        array.set(first, array.get(second));
        array.set(second, temp);
    }

    default int compare(List<P> array, int first, int second) {
        return array.get(first - 1).compareTo(array.get(second - 1));
    }

    void swim(int index);

    void sink(int index);

    P peek();

    P insert(P element);

    P delete();

    int size();
}
