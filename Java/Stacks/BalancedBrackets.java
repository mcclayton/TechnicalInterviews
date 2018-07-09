import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. 
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced. 
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of 
 * parentheses encloses a single, unbalanced closing square bracket, ].
 * 
 * Given an expression such as "{{[][[(())]]}()}", return true or false for whether or not the
 * expression is balanced.
 */ 

public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
        if (expression.length() == 0 || (expression.length() % 2) != 0) {
            // If string is empty or odd number of characters, then expression is unbalanced
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c : expression.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                // If the character is an opening bracket, push it to the satck
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the last character in the stack
                // is the matching opening bracket
                if (stack.isEmpty()) {
                    // If the stack is empty, then we are hitting an unbalanced closing bracket
                    return false;
                } else {
                    char popped = stack.pop();
                    // If last character in stack is not the matching opening bracket, then exp. is unbalanced
                    switch (c) {
                        case '}':  
                            if (popped != '{') {
                                return false;
                            }
                            break;
                        case ']':  
                            if (popped != '[') {
                                return false;
                            }
                            break;
                        case ')':  
                            if (popped != '(') {
                                return false;
                            }
                            break;
                    }
                }
            }
        }
        // If the stack is not empty, then there is an extra opening bracket
        return stack.isEmpty();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
