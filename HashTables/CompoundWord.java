import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given a word and a list of words, determine if the word is comprised of
 * two of the other words in the list.
 * Sample:
 * word = "horseshoe"
 * wordList = ["ball", "shoe", "jump", "horse"]
 * Solution = true
 */

public class CompoundWord {

    public static void main(String[] args) {
        String word = "newspaper";
        String[] wordList = {"run", "horse", "paper", "foo", "bar", "news"};
        canGenerateWord(word, wordList); // Return true for this example
    }

    // This solution is O(n + m) where n is the length of word and m is the length of wordList
    public static boolean canGenerateWord(String word, String[] wordList) {
        // Create Hash Table for each entry in the word list that maps each word to itself
        HashMap<String, String> wordMap = new HashMap<String, String>();
        for (String s : wordList) {
            wordMap.put(s, s);
        }
        // Iterate through each possible way to split the word into a prefix and suffix
        // and check if the prefix + suffix are in the hash map
        String prefix;
        String suffix;
        for (int i=0; i < word.length(); i++) {
            prefix = word.substring(0, i+1);
            suffix = word.substring(i+1, word.length());
            if (wordMap.containsKey(prefix) && wordMap.containsKey(suffix)) {
                // Found a prefix and suffix split that are in the original wordList
                return true;
            }
        }
        // No possible solution
        return false;
    }
}
