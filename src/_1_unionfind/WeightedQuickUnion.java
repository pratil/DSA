package _1_unionfind;

import java.util.Arrays;

// an algorithm which stores the list of objects in form of forests i.e. a group of trees
// this is an improvement of QuickUnion where we store weights of the objects as well
public class WeightedQuickUnion extends QuickUnion {

    //    array where each index represent an object and value represent the weight i.e. count of objects that it holds
    protected final int[] weight;

    //    initialise the array, initially all are disjoint and they are the parents of themselves and weights are 1
    public WeightedQuickUnion(int length) {
        super(length);
        weight = new int[length];
        Arrays.fill(weight, 1);
    }

//    find and root code works same as QuickUnion

    //    we can assign the root of the smaller tree to the root of larger tree, this way height of tree can be minimized
    @Override
    public void union(int first, int second) {
        int first_root = root(first);
        int second_root = root(second);
        if (first_root == second_root)
            return;
        if (weight[first_root] < weight[second_root]) {
            array[first_root] = second_root;
            weight[second_root] += weight[first_root];
        } else {
            array[second_root] = first_root;
            weight[first_root] += weight[second_root];
        }
    }

    //    to display the array
    @Override
    public String toString() {
        return "WeightedQuickUnion{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
