/*
Recursive Approach:

The recursive approach leverages the call stack to reverse the list:
Base case: If the list is empty or contains a single node, return the node as it is already reversed.
Recursively reverse the rest of the list.
Adjust the pointers such that the current node becomes the new tail of the reversed part.
*/
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
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        
        // Adjust pointers
        head.next.next = head; // The next node points back to current node
        head.next = null; // The current node points to null (end of reversed list)
        
        return newHead; // Return the new head of the reversed list
    }
}