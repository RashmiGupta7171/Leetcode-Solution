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
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if(head == null || left == right)
//         return head;
    
//     ListNode curr = head;
//     ListNode prev = null;
//     int i = 1;
//     while (curr != null && i < left){
//         prev = curr;
//         curr = curr.next;
//         i++;
//     }
//     ListNode pointerToStart = prev;
//     ListNode start = curr;
//     prev = null;
//     while(curr != null && i <= right){
//         ListNode next = curr.next;
//         curr.next = prev;
//         curr = next;
//         i++;
//     }
//     start.next = curr;
//     if(pointerToStart != null){
//         pointerToStart.next =  prev;
//     }
//     else{
//         head = prev;
//     }
//     return head;
//     }
// }
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode curr = head;
        ListNode prev = null;
        int i = 1;

        // Move to left position
        while (curr != null && i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode pointerToStart = prev;
        ListNode start = curr;

        prev = null;

        // Reverse from left to right
        while (curr != null && i <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;          // ✅ MISSING LINE
            curr = next;
            i++;
        }

        start.next = curr;

        if (pointerToStart != null) {
            pointerToStart.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}
