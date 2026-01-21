/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node to act as the head of the sorted list
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {
            // Save next node to process
            ListNode next = current.next;

            // Find correct position in sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current node into sorted list
            current.next = prev.next;
            prev.next = current;

            // Move to next node in original list
            current = next;
        }

        return dummy.next;
    }
}

