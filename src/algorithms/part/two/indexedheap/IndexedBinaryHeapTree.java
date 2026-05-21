package algorithms.part.two.indexedheap;

// Generic Binary Heap Tree parent for both min and max heap algorithms
public interface IndexedBinaryHeapTree<Key extends Comparable<Key>> {

    default void swap(int[] pq, int[] qp, int first, int second) {
        int temp = pq[first];
        pq[first] = pq[second];
        pq[second] = temp;
        qp[pq[first]] = first;
        qp[pq[second]] = second;
    }

    default int compare(Key first, Key second) {
        return first.compareTo(second);
    }

    default boolean isLess(Key first, Key second) {
        return compare(first, second) < 0;
    }

    default boolean isGreater(Key first, Key second) {
        return compare(first, second) > 0;
    }

    default int compare(Key[] keys, int[] pq, int first, int second) {
        return compare(keys[pq[first]], keys[pq[second]]);
    }

    default boolean isLess(Key[] keys, int[] pq, int first, int second) {
        return compare(keys, pq, first, second) < 0;
    }

    default boolean isGreater(Key[] keys, int[] pq, int first, int second) {
        return compare(keys, pq, first, second) > 0;
    }

    // function to swim an index from a heap position to it's upper positions if required
    // i.e. if it is greater/less than it's child it should be moved up recursively in a min/max heap
    void swim(int index);

    // function to sink an index from a heap position to it's lower positions if required
    // i.e. if it is less/greater than it's child it should be moved down recursively in a min/max heap
    void sink(int index);

    // to get the root of the tree i.e. the top of the tree.
    // which is Minimum/Maximum in case of MinHeap/MaxHeap
    Key peek();

    // to insert a new element in the tree at a given index
    void insert(int index, Key key);

    // to delete an element from the tree at a given index
    Key delete(int index);

    // to check if some key is present in the tree or not at a given index
    boolean contains(int index);

    // to get the element from the tree at a given index
    Key get(int index);

    // to get the size of the tree
    int size();

    // to check if the tree is empty or not
    default boolean isEmpty() {
        return size() == 0;
    }

    void decreaseKey(int index, Key key);

    void increaseKey(int index, Key key);

//    void changeKey(int index, Key key);

}
