package algorithms.part.one._5_sort.methods;

import algorithms.part.one._5_sort.Sort;

// A child of Sort to implement Sorting array of generic objects using Insertion sorting method
public class Insertion<P extends Comparable<P>> implements Sort<P> {

    // to get the name of the sort method only for output purpose
    @Override
    public String getName() {
        return "Insertion Sort";
    }

    // a method to sort the array in Ascending order
    @Override
    public void sortAscending(P[] array) {
        int length = array.length, j;
        for (int i = 1; i < length; i++) {
            P data = array[i];
            j = i - 1;
            while (j >= 0 && isGreater(array[j], data)) {
                array[j + 1] = array[j];
                j--;
            }
            if (j + 1 != i)
                array[j + 1] = data;
        }
    }

    // a method to sort the array in Descending order
    @Override
    public void sortDescending(P[] array) {
        int length = array.length, j;
        for (int i = 0; i < length; i++) {
            P data = array[i];
            j = i - 1;
            while (j >= 0 && isLess(array[j], data)) {
                array[j + 1] = array[j];
                j--;
            }
            if (i != j + 1)
                array[j + 1] = data;
        }
    }
}
