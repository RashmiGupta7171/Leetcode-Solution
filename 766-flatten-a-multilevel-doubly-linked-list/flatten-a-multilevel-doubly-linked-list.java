/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;

                // Flatten the child list
                Node child = flatten(curr.child);

                // Connect curr to child
                curr.next = child;
                child.prev = curr;

                // Remove child pointer
                curr.child = null;

                // Find the end of child list
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect child list to original next
                tail.next = next;

                if (next != null) {
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}