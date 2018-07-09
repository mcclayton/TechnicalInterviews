/**
 * Given an array of `n` integers and a number, `d`, perform `d` left rotations on the array.
 * Then print the updated array as a single line of space-separated integers.
 * Sample: n = 5, d = 4, array = [1, 2, 3, 4, 5];
 * Solution = 5 1 2 3 4
 */

const LeftRotation = (arr, rotation) => {
  if (!arr || arr.length === 0)
    return arr;

  const arrLength = arr.length;
  const rightShift = arrLength - (rotation % arrLength);

  const res = [];
  arr.forEach((a, idx) => {
    res[(idx + rightShift) % arrLength] = a;
  });
  return res;
};

console.log(LeftRotation([1, 2, 3, 4, 5], 4));
