package algorithms.part.one._5_sort.methods;

import algorithms.part.one._5_sort.Order;
import algorithms.part.one._5_sort.Shuffle;
import algorithms.part.one._5_sort.Sort;

// A child of Sort to implement Sorting array of generic objects using Quick sorting method
public class Quick<P extends Comparable<P>> implements Sort<P> {

    // to get the name of the sort method only for output purpose
    @Override
    public String getName() {
        return "Quick Sort";
    }

    // to partition the array in three parts left half, pivot and right half
    // where on left half all the elements are less than pivot
    // and on right half all the elements are greater than pivot
    private int partitionAscending(P[] array, int start, int end) {
        if (start >= end)
            return -1;
        int pivotIndex = start;
        start++;
        while (start <= end) {
            while (start <= end && compare(array[start], array[pivotIndex]) <= 0)
                start++;
            while (start <= end && compare(array[end], array[pivotIndex]) >= 0)
                end--;
            if (start < end)
                swap(array, start, end);
            else
                break;
        }
        swap(array, pivotIndex, end);
        return end;
    }

    // to partition the array and recursively process it
    private void sortAscending(P[] array, int start, int end) {
        if (start < end) {
            int pivot = partitionAscending(array, start, end);
            if (pivot != -1) {
                sortAscending(array, start, pivot - 1);
                sortAscending(array, pivot + 1, end);
            }
        }
    }

    // a method to sort the array in Ascending order
    @Override
    public void sortAscending(P[] array) {
        sortAscending(array, 0, array.length - 1);
    }

    // to partition the array in three parts left half, pivot and right half
    // where on left half all the elements are greater than pivot
    // and on right half all the elements are less than pivot
    private int partitionDescending(P[] array, int start, int end) {
        if (start >= end)
            return -1;
        int pivotIndex = start;
        start++;
        while (start <= end) {
            while (start <= end && compare(array[start], array[pivotIndex]) >= 0)
                start++;
            while (start <= end && isLess(array[end], array[pivotIndex]))
                end--;
            if (start < end)
                swap(array, start, end);
            else
                break;
        }
        swap(array, pivotIndex, end);
        return end;
    }

    // to partition the array and recursively process it
    private void sortDescending(P[] array, int start, int end) {
        if (start < end) {
            int pivot = partitionDescending(array, start, end);
            sortDescending(array, start, pivot - 1);
            sortDescending(array, pivot + 1, end);
        }
    }

    // a method to sort the array in Descending order
    @Override
    public void sortDescending(P[] array) {
        sortDescending(array, 0, array.length - 1);
    }

    // to override the sort method and randomize the array before sorting (which increases the efficiency of the Quick.sot)
    @Override
    public void sort(P[] array, Order order) {
        Shuffle<P> shuffle = new Shuffle<>();
        shuffle.getRandomisedArray(array);
        Sort.super.sort(array, order);
    }
}
