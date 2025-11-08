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
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode slow = head , fast = head;

//         for(int i = 1 ; i < n ; i++){
//             fast = fast.next;
//         }
//         while(fast != null){
//             // return head.next;
//               slow = slow.next;
//             fast = fast.next;
//         }
//         // while(fast != null && fast.next != null){
//         //     slow = slow.next;
//         //     fast = fast.next;
//         // }
//         // if(slow != null && slow.next != null)
//         slow.next = slow.next.next;


//         return head;
//     }
// }














class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (like removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast ahead by n+1 steps so that slow points to the node before the target
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from end
        slow.next = slow.next.next;

        // Return the updated list
        return dummy.next;
    }
}
