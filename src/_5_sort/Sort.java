package _5_sort;

public interface Sort<P extends Comparable<P>> {

    String getName();

    default int compare(P[] array, int first, int second) {
        return array[first].compareTo(array[second]);
    }

    default boolean isLess(P[] array, int first, int second) {
        return compare(array, first, second) < 0;
    }

    default boolean isGreater(P[] array, int first, int second) {
        return compare(array, first, second) > 0;
    }

    default int compare(P first, P second) {
        return first.compareTo(second);
    }

    default boolean isLess(P first, P second) {
        return compare(first, second) < 0;
    }

    default boolean isGreater(P first, P second) {
        return compare(first, second) > 0;
    }

    default void swap(P[] array, int first, int second) {
        P temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    void sortAscending(P[] array);

    void sortDescending(P[] array);

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

    default void sort(P[] array) {
        sort(array, Order.Ascending);
    }

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

    default void assertSorted(P[] array, Order order) throws NotSortedException {
        if (!isSorted(array, order))
            throw new NotSortedException(order);
    }
}
