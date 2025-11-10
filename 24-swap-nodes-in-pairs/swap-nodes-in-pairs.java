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
    public ListNode swapPairs(ListNode head) {
        return solve (head);
    }
    private ListNode solve(ListNode node){
        if(node == null || node.next == null)
        return node;

        ListNode tail = node.next;
        node.next = solve (tail.next);
        tail.next = node;
        
        return tail;
    }
}