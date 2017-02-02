import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

/**
 * Given two strings `s1` and `s2`, determine if `s2` is a rotation of `s1`
 * using only a single call to the method contains (isSubstring).
 * Sample: s1 = "jumpsuit", s2 = "psuitjum"
 * Solution = true
 */

public class StringRotationCheck {

    public static void main(String[] args) {
        System.out.println(isRotation("watterbottle", "erbottlewatt")); // -> true
        System.out.println(isRotation("test", "hello")); // -> false
        System.out.println(isRotation("j", "j")); // -> true
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() && s1.length() > 0) {
            // If lengths are not equal, s2 cannot possibly be a rotation of s1
            return false;
        }

        // To determine if s2 is a rotation of s1
        // Simply check if s2 is a substring of s1+s1.
        String concat = s1+s1;
        return concat.contains(s2);
    }
}
