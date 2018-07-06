import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Given two strings, `a` and `b`, that may or may not be of the same length, 
 * determine the minimum number of character deletions required to make
 * `a` and `b` anagrams. Any characters can be deleted from either of the strings.
 * Sample: a = "cde" b = "abc". 
 * Solution = 4 character deletions are required to make `a` and `b` anagrams 
 */

public class MinDeletionsAnagrams {
    public static int numberNeeded(String first, String second) {
      // Get frequency counts for both strings
      int bitVectorA[] = getFrequencyBitVector(first);
      int bitVectorB[] = getFrequencyBitVector(second);
      
      int sum = 0;
      // Sum the differences in frequencies of each character in both strings
      for (int i=0; i<bitVectorA.length; i++) {
          sum += Math.abs(bitVectorA[i] - bitVectorB[i]);
      }
      // Sum is the minimum number of characters that need to be deleted for
      // the strings to be anagrams
      return sum;
    }
    
    public static int[] getFrequencyBitVector(String s) {
      int bitVector[] = new int[26];
      for (int i=0; i<s.length(); i++) {
          bitVector[s.charAt(i) - 'a'] += 1;
      }
      return bitVector;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
