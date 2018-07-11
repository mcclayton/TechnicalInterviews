/**
 * Given an array of `n` integers, shift all of the zeroes in the array
 * to the end of the array.
 * RESTRICTION: Do this shifting in-place
 * Sample: array = [0, 1, 2, 0, 3, 0, 0, 4, 5];
 * Solution = [1, 2, 3, 4, 5, 0, 0, 0, 0]
 */

const shiftZeroesToEnd = (arr) => {
  let count = 0; // Count of non-zero numbers

  // Iterate over the array
  // For every non-zero number, replace the element at index `count`
  // with the number

  for (let i=0; i<arr.length; i++) {
    if (arr[i] !== 0) {
      arr[count++] = arr[i];
    }
  }

  // Fill remainder of array with zeroes
  let numOfZeroes = arr.length - count;
  while (numOfZeroes > 0) {
    arr[arr.length - numOfZeroes--] = 0;
  }

  return arr;
};

console.log(shiftZeroesToEnd([0, 1, 2, 0, 3, 0, 0, 4, 5]));
