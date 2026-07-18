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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create a dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers at dummy
        ListNode first = dummy;
        ListNode second = dummy;

        // Step 3: Move 'first' pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 4: Move both pointers until 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 5: 'second' is now just before the node to delete
        second.next = second.next.next;

        // Step 6: Return the updated list
        return dummy.next;
    }
}