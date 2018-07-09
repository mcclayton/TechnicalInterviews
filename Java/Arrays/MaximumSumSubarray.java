import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given an array of `n` integers, find the largest contiguous subarray
 * sum.
 * Sample: [-2, -3, 4, -1, -2, 1, 5, -3]
 * Solution = 7, since the largest sum is the subarray [4, -1, -2, 4, -1, -2, 1, 5]
 */

public class MaximumSumSubarray {

    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(maximumSubarraySum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));    // 7
        System.out.println(maximumSubarraySum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));  // 6
        System.out.println(maximumSubarraySum(new int[] { 3, 5, 0, -5 }));                    // 5
        System.out.println(maximumSubarraySum(new int[] { 10 }));                             // 10
        System.out.println(maximumSubarraySum(new int[] { -10 }));                            // -10
    }

    /**
     * Kadane's Algorithm:
     */
    private static int maximumSubarraySum(int[] arr) {
        int globalMax = arr[0];
        int maxCurrent = arr[0];

        int num;
        for (int i=1; i<arr.length; i++) {
            num = arr[i];
            maxCurrent = Math.max(maxCurrent + num, num);
            globalMax = Math.max(globalMax, maxCurrent);
        }
        return globalMax;
    }
}
