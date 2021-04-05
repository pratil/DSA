package sort;

public class Quick<P extends Comparable<P>> implements Sort<P> {

    @Override
    public String getName() {
        return "Quick Sort";
    }

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

    private void sortAscending(P[] array, int start, int end) {
        if (start < end) {
            int pivot = partitionAscending(array, start, end);
            if (pivot != -1) {
                sortAscending(array, start, pivot - 1);
                sortAscending(array, pivot + 1, end);
            }
        }
    }

    @Override
    public void sortAscending(P[] array) {
        sortAscending(array, 0, array.length - 1);
    }

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

    private void sortDescending(P[] array, int start, int end) {
        if (start < end) {
            int pivot = partitionDescending(array, start, end);
            sortDescending(array, start, pivot - 1);
            sortDescending(array, pivot + 1, end);
        }
    }

    @Override
    public void sortDescending(P[] array) {
        sortDescending(array, 0, array.length - 1);
    }
}
