import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given an array of `n` integers and a number, `d`, perform `d` left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.
 * Sample: n = 5, d = 4, array = [1, 2, 3, 4, 5]; 
 * Solution = 5 1 2 3 4
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int numbers[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            numbers[a_i] = in.nextInt();
        }
        
        // Convert left shift to right shift (Easier to deal with)
        int numbersLength = numbers.length;
        int rightShift = numbersLength - (d%numbersLength);
        int[] result = new int[numbersLength];
        for (int i = 0; i < numbersLength; i++) {
            // Rotate the array
            result[(i + rightShift) % numbersLength] = numbers[i];
        }
        for (int i=0; i<result.length; i++) {
            // Print the result
            System.out.format("%d ", result[i]);
        }
    }
}
