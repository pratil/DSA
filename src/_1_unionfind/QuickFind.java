package _1_unionfind;

import java.util.Arrays;

public class QuickFind implements UnionFind {

    private final int[] array;

    public QuickFind(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = i;
    }

    @Override
    public void union(int first, int second) {
        int firstParent = array[first];
        int secondParent = array[second];
        int length = array.length;
        for (int i = 0; i < length; i++)
            if (array[i] == firstParent)
                array[i] = secondParent;
    }

    @Override
    public boolean find(int first, int second) {
        return array[first] == array[second];
    }

    @Override
    public String toString() {
        return "QuickFind{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
