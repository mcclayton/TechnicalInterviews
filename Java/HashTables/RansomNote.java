import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut 
 * out whole words from it and use them to create an untraceable replica of his ransom note. 
 * The words in his note are case-sensitive and he must use whole words available in the magazine, 
 * meaning he cannot use substrings or concatenation to create the words he needs.
 * 
 * Given the words in the magazine and the words in the ransom note, return `true` if he can replicate his ransom note 
 * exactly using whole words from the magazine; otherwise, return `false`
 * 
 * magazineWords = ["give", "me", "one", "grand", "today", "night"]
 * ransomWords = ["give", "one", "grand", "today"]
 * Solution = true
 */

public class RansomNote {

    public static void main(String[] args) {
        String[] magazineWords = {"give", "me", "one", "grand", "today", "night"};
        String[] ransomWords = {"give", "one", "grand", "today"};
        canGenerateRansom(magazineWords, ransomWords); // Return true for this example
    }
    
    public static boolean canGenerateRansom(String[] magazineWords, String[] ransomWords) {
        // If there are fewer words in the magazine than the ransom note, return false
        if (magazineWords.length < ransomWords.length) {
            return false;
        }
        
        // Create hash tables that keep track of word frequency
        HashMap<String, Integer> magMap = buildWordFreqMap(magazineWords);
        HashMap<String, Integer> ransomMap = buildWordFreqMap(ransomWords);
        
        // Check to see if there are enough of each word in the magazine to build the ransom
        for (String ransomWord : ransomWords) {
            if (!magMap.containsKey(ransomWord)) {
                // If there is a word in the ransom message, that is not in the magazine: return false
                return false;
            } else if ((magMap.get(ransomWord) - ransomMap.get(ransomWord)) < 0) {
                // If the frequency count for a given word in the ransom is more than that of the word in the magazine
                // then return false
                return false;
            }
        }
        // There are enough words in the magazine to create the ransom message
        return true;
    }
    
    // Build out a word frequency hash map
    public static HashMap<String, Integer> buildWordFreqMap(String[] words) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        for (String word : words) {
            if (!hmap.containsKey(word)) {
                hmap.put(word, 1);
            } else {
                hmap.put(word, hmap.get(word) + 1);
            }
        }
        return hmap;
    }
}