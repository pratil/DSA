package algorithms.part.one._5_sort;

public class Merge<P extends Comparable<P>> implements Sort<P> {

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public void sortAscending(P[] array) {
        int length = array.length;
        P[] auxiliaryArray = array.clone();
        sortAscending(array, auxiliaryArray, 0, length - 1);
    }

    private void sortAscending(P[] array, P[] auxiliaryArray, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortAscending(array, auxiliaryArray, start, mid);
            sortAscending(array, auxiliaryArray, mid + 1, end);
            if (isGreater(array, mid, mid + 1))
                mergeAscending(array, auxiliaryArray, start, mid, end);
        }
    }

    private void mergeAscending(P[] array, P[] auxiliaryArray, int start, int mid, int end) {
        System.arraycopy(array, start, auxiliaryArray, start, end - start + 1);
        int first = start, second = mid + 1, result = start;
        while (first <= mid && second <= end)
            array[result++] = isLess(auxiliaryArray, first, second) ? auxiliaryArray[first++] : auxiliaryArray[second++];
        while (first <= mid)
            array[result++] = auxiliaryArray[first++];
        while (second <= end)
            array[result++] = auxiliaryArray[second++];
    }

    @Override
    public void sortDescending(P[] array) {
        int length = array.length;
        P[] auxiliaryArray = array.clone();
        sortDescending(array, auxiliaryArray, 0, length - 1);
    }

    private void sortDescending(P[] array, P[] auxiliaryArray, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortDescending(array, auxiliaryArray, start, mid);
            sortDescending(array, auxiliaryArray, mid + 1, end);
            if (isLess(array, mid, mid + 1))
                mergeDescending(array, auxiliaryArray, start, mid, end);
        }
    }

    private void mergeDescending(P[] array, P[] auxiliaryArray, int start, int mid, int end) {
        System.arraycopy(array, start, auxiliaryArray, start, end - start + 1);
        int first = start, second = mid + 1, result = start;
        while (first <= mid && second <= end)
            array[result++] = isGreater(auxiliaryArray, first, second) ? auxiliaryArray[first++] : auxiliaryArray[second++];
        while (first <= mid)
            array[result++] = auxiliaryArray[first++];
        while (second <= end)
            array[result++] = auxiliaryArray[second++];
    }
}
