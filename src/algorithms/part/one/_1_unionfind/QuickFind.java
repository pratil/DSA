package algorithms.part.one._1_unionfind;

import java.util.Arrays;

// an algorithm which stores the value of a object in all the objects of that group
public class QuickFind implements UnionFind {

    //    array to store the numbers as objects and the value contains the value of a object in the group
    private final int[] array;

    //    to initialize the array, initially all objects are disjoint and are in their own group
    public QuickFind(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = i;
    }

    //    assign the value of second objects group to all the objects who's objects are equal to that of first object
    @Override
    public void union(int first, int second) {
        int firstParent = array[first];
        int secondParent = array[second];
        int length = array.length;
        for (int i = 0; i < length; i++)
            if (array[i] == firstParent)
                array[i] = secondParent;
    }

    //    if the value of both the objects are same then both objects are in the same group
    @Override
    public boolean find(int first, int second) {
        return array[first] == array[second];
    }

    //    to display the array
    @Override
    public String toString() {
        return "QuickFind{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
