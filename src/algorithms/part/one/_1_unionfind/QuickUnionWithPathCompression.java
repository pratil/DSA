package algorithms.part.one._1_unionfind;

import java.util.Arrays;

// an algorithm which stores the list of objects in form of forests i.e. a group of trees
// this is an improvement of QuickUnion where we compress the path of the object every time we find it's root
public class QuickUnionWithPathCompression extends QuickUnion {

    //    initialize same as QuickUnion
    public QuickUnionWithPathCompression(int length) {
        super(length);
    }

    //    same as QuickUnion just we reduce the path from root to the element from n to 1, it flattens the tree
    @Override
    protected int root(int element) {
        while (array[element] != element) {
            array[element] = array[array[element]];
            element = array[element];
        }
        return array[element];
    }

//    find and union code works same as QuickUnion, just it is faster as it takes the advantage of flat tree

    //    to display the array
    @Override
    public String toString() {
        return "QuickUnionWithPathCompression{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
