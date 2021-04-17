package unionfind;

import java.util.Arrays;

public class WeightedQuickUnion extends QuickUnion {

    protected final int[] weight;

    public WeightedQuickUnion(int length) {
        super(length);
        weight = new int[length];
        Arrays.fill(weight, 1);
    }

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

    @Override
    public String toString() {
        return "WeightedQuickUnion{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
