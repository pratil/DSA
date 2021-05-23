package algorithms.part.one._5_sort;

// Generic Sort parent for all the sorting algorithms
public interface Sort<P extends Comparable<P>> {

    String getName(); // to get the name of the sort method only for output purpose

    void sortAscending(P[] array); // a method to sort the array in Ascending order

    void sortDescending(P[] array); // a method to sort the array in Descending order

    // a method to compare two numbers with the given index in the array
    default int compare(P[] array, int first, int second) {
        return array[first].compareTo(array[second]);
    }

    // a method to check if the first index is less than second index in the array
    default boolean isLess(P[] array, int first, int second) {
        return compare(array, first, second) < 0;
    }

    // a method to check if the first index is greater than second index in the array
    default boolean isGreater(P[] array, int first, int second) {
        return compare(array, first, second) > 0;
    }

    // a method to compare two numbers
    default int compare(P first, P second) {
        return first.compareTo(second);
    }

    // a method to check if the first element is less than second element
    default boolean isLess(P first, P second) {
        return compare(first, second) < 0;
    }

    // a method to check if the first element is greater than second element
    default boolean isGreater(P first, P second) {
        return compare(first, second) > 0;
    }

    // a method to swap two positions in the given array
    default void swap(P[] array, int first, int second) {
        P temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    // a generic method to sort the array in the given order as passed in parameters
    default void sort(P[] array, Order order) {
        if (array.length <= 1)
            return;
        StopWatch stopWatch;
        double timeTakenToSort = 0;
        switch (order) {
            case Ascending:
                stopWatch = new StopWatch();
                sortAscending(array);
                timeTakenToSort = stopWatch.getTime();
                break;
            case Descending:
                stopWatch = new StopWatch();
                sortDescending(array);
                timeTakenToSort = stopWatch.getTime();
                break;
        }
        assertSorted(array, order);
        System.out.println(getName() + " took " + timeTakenToSort + " seconds to sort" +
                " an Array of " + array[0].getClass().getName() + " in " + order + " order, of size " + array.length);
    }

    // a default method to sort the array in ascending order if no order is passed
    default void sort(P[] array) {
        sort(array, Order.Ascending);
    }

    // a function to validate if the given array is sorted in the given order or not, and return true if sorted
    default boolean isSorted(P[] array, Order order) {
        int length = array.length;
        switch (order) {
            case Ascending:
                for (int i = 0; i < length - 1; i++)
                    if (isGreater(array[i], array[i + 1]))
                        return false;
                break;
            case Descending:
                for (int i = 0; i < length - 1; i++)
                    if (isLess(array[i], array[i + 1]))
                        return false;
                break;
        }
        return true;
    }

    // a function to assert that the array is sorted in the given order if not sorted would raise an exception
    default void assertSorted(P[] array, Order order) throws NotSortedException {
        if (!isSorted(array, order))
            throw new NotSortedException(order);
    }
}
