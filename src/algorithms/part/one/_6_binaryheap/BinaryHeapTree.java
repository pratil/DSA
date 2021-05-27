package algorithms.part.one._6_binaryheap;

import java.util.List;

// Generic Binary Heap Tree parent for both min and max heap algorithms
// For the Heap Tree code we will assume that the tree starts from 1 index till nth index
// This can be done by overriding the swap(), compare() functions
// And accessing the (i-1)th index instead of ith index i.e. instead of first and second we'll use first-1 & second-1
public interface BinaryHeapTree<P extends Comparable<P>> {

    // swap as mentioned above in the comments
    default void swap(List<P> array, int first, int second) {
        first--;
        second--;
        P temp = array.get(first);
        array.set(first, array.get(second));
        array.set(second, temp);
    }

    // compare as mentioned above in the comments
    default int compare(List<P> array, int first, int second) {
        return array.get(first - 1).compareTo(array.get(second - 1));
    }

    // function to swim an index from a heap position to it's upper positions if required
    // i.e. if it is greater/less than it's child it should be moved up recursively in a min/max heap
    void swim(int index);

    // function to sink an index from a heap position to it's lower positions if required
    // i.e. if it is less/greater than it's child it should be moved down recursively in a min/max heap
    void sink(int index);

    // to get the root of the tree i.e. the top of the tree
    P peek();

    // to insert a new element in the tree
    P insert(P element);

    // to delete an element from the tree
    P delete();

    // to get the size of the tree
    int size();

    // to check if the tree is empty or not
    default boolean isEmpty() {
        return size() == 0;
    }
}
