package unionfind;

import java.util.Arrays;

public class QuickUnionWithPathCompression extends QuickUnion {

    public QuickUnionWithPathCompression(int length) {
        super(length);
    }

    @Override
    protected int root(int element) {
        while (array[element] != element) {
            array[element] = array[array[element]];
            element = array[element];
        }
        return array[element];
    }

    @Override
    public String toString() {
        return "QuickUnionWithPathCompression{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
