package algorithms.part.one._5_sort.methods;

import algorithms.part.one._5_sort.Sort;

// A child of Sort to implement Sorting array of generic objects using Heap sorting method
// For the whole code we will assume that the tree starts from 1 index till nth index
// This can be done by overriding the isLess(), isGreater() and swap() functions
// And accessing the (i-1)th index instead of ith index i.e. instead of first and second we'll use first-1 & second-1
public class Heap<P extends Comparable<P>> implements Sort<P> {

    // to get the name of the sort method only for output purpose
    @Override
    public String getName() {
        return "Heap Sort";
    }

    // overriding the function to tweak it as mentioned above in the comments
    @Override
    public boolean isGreater(P[] array, int first, int second) {
        return compare(array, first - 1, second - 1) > 0;
    }

    // overriding the function to tweak it as mentioned above in the comments
    @Override
    public boolean isLess(P[] array, int first, int second) {
        return compare(array, first - 1, second - 1) < 0;
    }

    // overriding the function to tweak it as mentioned above in the comments
    @Override
    public void swap(P[] array, int first, int second) {
        first--;
        second--;
        P temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    // function to sink an index from the heap, i.e. if it is greater than it's child it should be moved down recursively
    private void sinkAscending(P[] array, int index, int size) {
        if (2 * index <= size) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            int maximumIndex = index;
            if (leftChild <= size && isGreater(array, leftChild, maximumIndex))
                maximumIndex = leftChild;
            if (rightChild <= size && isGreater(array, rightChild, maximumIndex))
                maximumIndex = rightChild;
            if (maximumIndex != index) {
                swap(array, index, maximumIndex);
                sinkAscending(array, maximumIndex, size);
            }
        }
    }

    // a method to sort the array in Ascending order
    @Override
    public void sortAscending(P[] array) {
        int size = array.length;
        for (int i = size / 2; i >= 1; i--)
            sinkAscending(array, i, size);
        while (size > 1) {
            swap(array, 1, size);
            size--;
            sinkAscending(array, 1, size);
        }
    }

    // function to sink an index from the heap, i.e. if it is less than it's child it should be moved down recursively
    private void sinkDescending(P[] array, int index, int size) {
        if (2 * index <= size) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            int minimumIndex = index;
            if (leftChild <= size && isLess(array, leftChild, minimumIndex))
                minimumIndex = leftChild;
            if (rightChild <= size && isLess(array, rightChild, minimumIndex))
                minimumIndex = rightChild;
            if (minimumIndex != index) {
                swap(array, index, minimumIndex);
                sinkDescending(array, minimumIndex, size);
            }
        }
    }

    // a method to sort the array in Descending order
    @Override
    public void sortDescending(P[] array) {
        int size = array.length;
        for (int i = size / 2; i >= 1; i--)
            sinkDescending(array, i, size);
        while (size > 1) {
            swap(array, 1, size);
            size--;
            sinkDescending(array, 1, size);
        }
    }
}
