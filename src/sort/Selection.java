package sort;

public class Selection<P extends Comparable<P>> implements Sort<P> {

    @Override
    public String getName() {
        return "Selection Sort";
    }

    private int findMinimum(P[] array, int startIndex, int endIndex) {
        int minimumIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++)
            if (isGreater(array, minimumIndex, i))
                minimumIndex = i;
        return minimumIndex;
    }

    @Override
    public void sortAscending(P[] array) {
        int length = array.length, minimumIndex;
        for (int i = 0; i < length - 1; i++) {
            minimumIndex = findMinimum(array, i, length - 1);
            if (minimumIndex != i)
                swap(array, minimumIndex, i);
        }
    }

    private int findMaximum(P[] array, int startIndex, int endIndex) {
        int maximumIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++)
            if (isLess(array, maximumIndex, i))
                maximumIndex = i;
        return maximumIndex;
    }

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
