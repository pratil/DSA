package _5_sort;

public class Heap<P extends Comparable<P>> implements Sort<P> {

    @Override
    public String getName() {
        return "Heap Sort";
    }

    @Override
    public boolean isGreater(P[] array, int first, int second) {
        return compare(array, first - 1, second - 1) > 0;
    }

    @Override
    public boolean isLess(P[] array, int first, int second) {
        return compare(array, first - 1, second - 1) < 0;
    }

    @Override
    public void swap(P[] array, int first, int second) {
        first--;
        second--;
        P temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

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
