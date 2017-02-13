import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given a value N, if we want to make change for N cents, and we have
 * infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many
 * ways can we make the change? The order of coins doesn’t matter.
 * Ex:
 * For `sum` = 10 and `S` = {2, 5, 3, 6}, there are five solutions:
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
public class CoinChange {

    public static void main(String[] args) {
        String text = "baaabab";
        int[] changeSet = new int[] {2, 5, 3, 6};
        System.out.println(countWays(changeSet, changeSet.length, 10));  // 5

        changeSet = new int[] {1, 2, 3};
        System.out.println(countWays(changeSet, changeSet.length, 4));  // 4
    }

    /**
     * Returns the count of ways we can sum  S[0...m-1] coins to get sum
     */
    public static long countWays(int[] S, int m, int sum) {
        // Time complexity of this function: O(mn)
        // Space Complexity of this function: O(n)

        // Create results table (Default values are 0)
        long[] results = new long[sum+1]; // Add extra space for base case
        results[0] = 1;   // Set base case. If no change values, then one solution i.e. No Change

        // Pick all coins one by one and update the result[] table
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++) {
            for (int j=S[i]; j<=sum; j++) {
                results[j] += results[j-S[i]];
            }
        }
        return results[sum];
    }
}
