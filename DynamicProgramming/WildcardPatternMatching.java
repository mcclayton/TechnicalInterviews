import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given a text and a wildcard pattern, implement wildcard pattern matching
 * algorithm that finds if wildcard pattern is matched with text. The matching
 * should cover the entire text (not partial text)
 * `?` - matches any single character
 * `*` - Matches any sequence of characters (including the empty sequence)
 * Ex:
 * Text = "baaabab",
 * Pattern = “*****ba*****ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false
 */

public class WildcardPatternMatching {

    public static void main(String[] args) {
        String text = "baaabab";
        System.out.println(isMatch(text, "*****ba*****ab"));  // True
        System.out.println(isMatch(text, "ba*ab"));           // True
        System.out.println(isMatch(text, "*"));               // True
        System.out.println(isMatch(text, ""));                // False
        System.out.println(isMatch(text, "b?aa*b"));          // True
        System.out.println(isMatch(text, "baaa?ab"));         // True
        System.out.println(isMatch(text, "???????"));         // True
    }

    /**
     * // Both text and pattern are null
     * T[0][0] = true;
     *
     * // Pattern is null
     * T[i][0] = false;
     *
     * // Text is null
     * T[0][j] = T[0][j - 1] if pattern[j – 1] is '*'
     */

    public static boolean isMatch(String text, String pattern) {
        int s = text != null ? text.length() : 0;       // Text length
        int p = pattern != null ? pattern.length() : 0; // Pattern length

        // An empty pattern can only match an empty string
        if (p == 0) {
            return s == 0;
        }

        // Create lookup table to store results of previous computations
        // resultsTable[i][j] = true if first `i` characters
        // of text match with first `j` characters of pattern
        boolean[][] resultsTable = new boolean[s+1][p+1];

        // Empty pattern can match empty string
        resultsTable[0][0] = true;

        // Only '*' can match with empty string
        for (int i = 1; i <= p; i++) {
            if (pattern.charAt(i-1) == '*') {
                resultsTable[0][i] = resultsTable[0][i-1];
            }
        }

        // fill the table in bottom-up fashion
        for (int i=1; i <= s; i++) {
            for (int j=1; j <= p; j++) {
                // Two cases if we see a '*'
                // a) We ignore ‘*’ character and move
                //    to next  character in the pattern,
                //     i.e., ‘*’ indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j-1) == '*') {
                    resultsTable[i][j] = resultsTable[i][j-1] || resultsTable[i-1][j];
                } else if (pattern.charAt(j-1) == '?' || text.charAt(i-1) == pattern.charAt(j-1)) {
                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match

                    // If current characters match, result is same as
                    // result for lengths minus one. Characters match
                    resultsTable[i][j] = resultsTable[i-1][j-1];
                } else {
                    // If characters don't match
                    resultsTable[i][j] = false;
                }
            }
        }
        return resultsTable[s][p];
    }
}
