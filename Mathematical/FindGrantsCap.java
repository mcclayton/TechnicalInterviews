import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * The awards committee had planned to give `n` research grants this year, out of
 * its total yearly budget. However, the budget was reduced to `b` dollars.
 * The committee members has decided to affect the minimal number of highest
 * grants, by applying a maximum cap `c` on all grants: every grant that was
 * planned to be higher than `c` will now be `c` dollars. Help the committee
 * to choose the right value of c that would make the total sum of grants equal
 * to the new budget.
 */
class FindGrantsCap {

    public static void main (String[] args) throws java.lang.Exception {
        int[] grants = new int[] { 5, 6, 7, 10 };
        int budget = 21;
        System.out.println(findGrantsCap(grants, budget));
    }

    /**
     * Finds the cap amount such that summing all the grants using the
     * cap value will equal the budget exactly.
     */
    private static double findGrantsCap(int[] grants, int budget) {
        int numOfGrants = grants.length;
        if (grants == null || numOfGrants == 0 || budget == 0) {
            return 0;
        }

        // Sort the array of grants in ascending order
        Arrays.sort(grants);


        int[] partialSums = new int[numOfGrants];
        int tempSum = 0;
        // Compute the partial sum
        // grant[0] + ... + grant[i];
        // for every grant in the array
        for (int i=0; i<numOfGrants; i++) {
            tempSum += grants[i];
            partialSums[i] = tempSum;
        }
        // If the sum of all the grants is less than or equal
        // to the budget, then the cap is the last (largest) grant
        if (partialSums[numOfGrants - 1] <= budget) {
            return partialSums[numOfGrants - 1];
        }

        // Find where to begin the range where we will start capping the budget
        int rangeStart;
        for (rangeStart=0; rangeStart<numOfGrants; rangeStart++) {
            if (findCapSum(rangeStart, grants) > budget) {
                if (findCapSum(rangeStart - 1, grants) < budget) {
                    break;
                }
            }
        }


        int partialSum = rangeStart == 0 ? 0 : partialSums[rangeStart - 1];
        // Derived from budget = partialSum[range - 1] + cap * (numOfGrants - rangeStart)
        double cap = (budget - partialSum) / (double)(numOfGrants - rangeStart);
        return cap;
    }

    /**
     * Finds the sum of all the grants using grant[i] as the
     * cap
     */
    private static int findCapSum(int i, int[] grants) {
        if (i < 0) {
            return 0;
        }
        int cap = grants[i];
        int sum = 0;
        for (int j=0; j < i; j++) {
            sum += grants[j];
        }
        sum += (grants.length - i) * cap;
        return sum;
    }
}
