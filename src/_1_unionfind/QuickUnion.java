package _1_unionfind;

import java.util.Arrays;

// an algorithm which stores the list of objects in form of forests i.e. a group of trees
public class QuickUnion implements UnionFind {

    //    array where each index represent an object and value at the index represent the parent of that object
    protected final int[] array;

    //    initialise the array, initially all are disjoint and they are the parents of themselves
    public QuickUnion(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = i;
    }

    //    to find the root of an object
    protected int root(int element) {
        while (array[element] != element)
            element = array[element];
        return array[element];
    }

    //    to group two object or group, we can just assign the root of one of them to the other's root
    @Override
    public void union(int first, int second) {
        array[root(first)] = root(second);
    }

    //    to find if two objects are connected or not we just have to see if they have the same root or not
    @Override
    public boolean find(int first, int second) {
        return root(first) == root(second);
    }

    //    to display the array
    @Override
    public String toString() {
        return "QuickUnion{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
