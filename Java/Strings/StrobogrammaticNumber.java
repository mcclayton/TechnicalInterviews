import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated
 * 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 * For example, the numbers "96", "808", and "818" are all strobogrammatic.
 */

public class StrobogrammaticNumber {
    private static final Map<Character, Character> strobMap;
    static {
        // Static initializer
        strobMap = new HashMap<Character, Character>();
        strobMap.put('0', '0');
        strobMap.put('1', '1');
        strobMap.put('6', '9');
        strobMap.put('8', '8');
        strobMap.put('9', '6');
    };

    public static void main(String[] args) {
        System.out.println(isStrobogrammaticNumber("1"));          // => True
        System.out.println(isStrobogrammaticNumber("9"));          // => False
        System.out.println(isStrobogrammaticNumber("161"));        // => False
        System.out.println(isStrobogrammaticNumber("16891"));      // => True
        System.out.println(isStrobogrammaticNumber("8968"));       // => True
        System.out.println(isStrobogrammaticNumber("57"));         // => False
        System.out.println(isStrobogrammaticNumber("2"));          // => False
    }

    public static boolean isStrobogrammaticNumber(String num) {
        int lIndex = 0;
        int rIndex = num.length() - 1;
        char l, r;
        while (lIndex <= rIndex) {
            l = num.charAt(lIndex);
            r = num.charAt(rIndex);

            if (!strobMap.containsKey(l) || !strobMap.containsKey(r)) {
                return false;
            } else {
                if (strobMap.get(l) != r || strobMap.get(r) != l) {
                    return false;
                }
            }
            lIndex++;
            rIndex--;
        }
        return true;
    }
}
