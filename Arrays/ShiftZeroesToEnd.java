import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given an array of `n` integers, shift all of the zeroes in the array
 * to the end of the array.
 * RESTRICTION: Do this shifting in-place
 * Sample: array = [0, 1, 2, 0, 3, 0, 0, 4, 5];
 * Solution = [1, 2, 3, 4, 5, 0, 0, 0, 0]
 */

public class ShiftZeroesToEnd {

    public static void main(String[] args) {
        int[] testArray = {0, 3, 0, 0, 5, 6, 0};
        System.out.println(Arrays.toString(shiftZeroesToEnd(testArray)));
    }

    public static int[] shiftZeroesToEnd(int[] arr) {
        int count = 0; // The count of non-zero elements

        // Iterate over the array
        // For every non-zero number, replace element at index `count`
        // with the number
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // Increment `count` for non-zero number
            }
        }
        // Fill remainder of array with zeroes
        while (count < arr.length)
            arr[count++] = 0;
        return arr;
    }
}
