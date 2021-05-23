package algorithms.part.one._5_sort.methods;

import algorithms.part.one._5_sort.Sort;

// A child of Sort to implement Sorting array of generic objects using Selection sorting method
public class Selection<P extends Comparable<P>> implements Sort<P> {

    // to get the name of the sort method only for output purpose
    @Override
    public String getName() {
        return "Selection Sort";
    }

    // to find the minimum in the given array within a range
    private int findMinimum(P[] array, int startIndex, int endIndex) {
        int minimumIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++)
            if (isGreater(array, minimumIndex, i))
                minimumIndex = i;
        return minimumIndex;
    }

    // a method to sort the array in Ascending order
    @Override
    public void sortAscending(P[] array) {
        int length = array.length, minimumIndex;
        for (int i = 0; i < length - 1; i++) {
            minimumIndex = findMinimum(array, i, length - 1);
            if (minimumIndex != i)
                swap(array, minimumIndex, i);
        }
    }

    // to find the maximum in the given array within a range
    private int findMaximum(P[] array, int startIndex, int endIndex) {
        int maximumIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++)
            if (isLess(array, maximumIndex, i))
                maximumIndex = i;
        return maximumIndex;
    }

    // a method to sort the array in Descending order
    @Override
    public void sortDescending(P[] array) {
        int length = array.length, maximumIndex;
        for (int i = 0; i < length; i++) {
            maximumIndex = findMaximum(array, i, length - 1);
            if (maximumIndex != i)
                swap(array, maximumIndex, i);
        }
    }
}
