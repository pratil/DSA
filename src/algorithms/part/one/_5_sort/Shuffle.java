package algorithms.part.one._5_sort;

import util.Random;

import java.util.Arrays;

// A class to shuffle the list of generic array of objects
public class Shuffle<P> {
    private void swap(P[] array, int first, int second) {
        P temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public void getRandomisedArray(P[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            swap(array, i, Random.intValue(i - 1));
            System.out.println(Arrays.toString(array));
        }
    }
}
