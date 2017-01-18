/**
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 * A Node is defined as:
 *   class Node {
 *     int data;
 *     Node next;
 *   }
*/

boolean hasCycle(Node head) {
    if (head == null) // List does not exist - No cycle
        return false;

    Node slow, fast;
    slow = fast = head; // Make both refer to the start of the list.
    
    while (slow != null && fast != null) {
        slow = slow.next;          // 1 hop.
        fast = fast.next != null ? fast.next.next : null; // 2 hops.
        if (fast == slow) {
            return true;
        }
    }
    return false;
}