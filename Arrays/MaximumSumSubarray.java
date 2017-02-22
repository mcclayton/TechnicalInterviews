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
    }

    /**
     * Kadane's Algorithm:
     * Initialize:
     * max_so_far = 0
     * max_ending_here = 0
     *
     * Loop for each element of the array
     * (a) max_ending_here = max_ending_here + a[i]
     * (b) if(max_ending_here < 0)
     *        max_ending_here = 0
     * (c) if(max_so_far < max_ending_here)
     *        max_so_far = max_ending_here
     * return max_so_far
     */
    private static int maximumSubarraySum(int[] arr) {
        int globalMax = arr[0];
        int maxCurrent = arr[0];

        for (int num : arr) {
            maxCurrent = Math.max(maxCurrent + num, num);
            globalMax = Math.max(globalMax, maxCurrent);
        }
        return globalMax;
    }
}
