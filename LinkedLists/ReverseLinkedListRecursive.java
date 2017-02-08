/**
 * Reverse a linked list recursively and return the new head of the reversed list.
 * i.e.
 * (1) -> (2) -> (3) -> (4) -> NULL
 * becomes
 * (4) -> (3) -> (2) -> (1) -> NULL
 * A Node is defined as:
 *   class Node {
 *     int data;
 *     Node next;
 *   }
*/

public class ReverseLinkedListRecursive {
    private static class Node {
        private Node next;
        private int data;
        Node() {
            this(0);
        }
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Build out a test list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printList(head);
        printList(reverseList(head));
    }

    /**
     * (1) -> (2) -> (3) -> (4) -> NULL
     * Reverse of `n` elements list `l` is the reverse of the list at `l + 1` follow by `l` node
     * Ex:
     * 1 <- [ 2 <- [ 3 <- [ 4 ] ] ] -> NULL
     */
    public static Node reverseList(Node list) {
        // Reverse of null is null
        if (list == null) return null;
        // Reverse of one element list is itself
        if (list.next == null) return list;

        // Get next element in list
        Node secondElem = list.next;

        // Unlink first first node or will cause cycle
        list.next = null;

        // Reverse second element and beyond
        Node reverseRest = reverseList(secondElem);

        // Join two lists
        secondElem.next = list;
        // Return new head (end of list)
        return reverseRest;
    }

    /**
     * Helper method to print out a linked list
     */
    public static void printList(Node list) {
        Node n = list;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}