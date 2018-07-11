/**
 * Given an array of `n` integers, find the largest contiguous subarray
 * sum.
 * Sample: [-2, -3, 4, -1, -2, 1, 5, -3]
 * Solution = 7, since the largest sum is the subarray [4, -1, -2, 4, -1, -2, 1, 5]
 */

// O(N^2)
const BruteForce = (arr) => {
  if (!arr || arr.length === 0) {
    return [];
  }

  let maxSum = arr[0];
  for (let i=0; i<arr.length; i++) {
    let localSum = arr[0];
    for (let j=i; j<arr.length; j++) {
      localSum += arr[j];
      if (maxSum < localSum) {
        maxSum = localSum;
      }
    }
  }
  return maxSum;
};

// O(N)
const Improved = (arr) => {
  /*
   * Kadane's Algorithm 
   */

  let globalMax = arr[0];
  let currMax = arr[0];

  arr.forEach((num) => {
    currMax = Math.max(currMax + num, num);
    globalMax = Math.max(currMax, globalMax);
  });

  return globalMax;
};

console.log(Improved(
  [-2, -3, 4, -1, -2, 1, 5, -3]
));

console.log(Improved([-1, -2, -3]))
