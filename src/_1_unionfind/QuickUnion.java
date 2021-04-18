package _1_unionfind;

import java.util.Arrays;

public class QuickUnion implements UnionFind {

    protected final int[] array;

    public QuickUnion(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = i;
    }

    @Override
    public void union(int first, int second) {
        array[root(first)] = root(second);
    }

    protected int root(int element) {
        while (array[element] != element)
            element = array[element];
        return array[element];
    }

    @Override
    public boolean find(int first, int second) {
        return root(first) == root(second);
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
