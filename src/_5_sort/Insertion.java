package _5_sort;

public class Insertion<P extends Comparable<P>> implements Sort<P> {

    @Override
    public String getName() {
        return "Insertion Sort";
    }

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
