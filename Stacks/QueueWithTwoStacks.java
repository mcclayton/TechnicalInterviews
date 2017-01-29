import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueWithTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { 
            // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
           if (stackOldestOnTop.isEmpty()) {
                // Take the contents pushed onto stackNewestOnTop and push them to stackOldestOnTop
                moveFromStackToStack(stackNewestOnTop, stackOldestOnTop);
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if (stackOldestOnTop.isEmpty()) {
                // Take the contents pushed onto stackNewestOnTop and push them to stackOldestOnTop
                moveFromStackToStack(stackNewestOnTop, stackOldestOnTop);
            }
            return stackOldestOnTop.pop();
        }
        
        private void moveFromStackToStack(Stack<T> s1, Stack<T> s2) {
            // Take all the contents of s1 and push them onto s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
