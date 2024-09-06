/*
Approach:

Use a Set:

Store all the values from nums in a HashSet to allow O(1) time complexity for checking if a node's value exists in nums.

Traverse the Linked List:

As we traverse the linked list, we check if the current node's value is in the set.
If the value is in the set, we skip that node by adjusting the pointers. Otherwise, we keep the node.

Edge Cases:

If the head itself is a value that needs to be removed, we adjust the head pointer accordingly.
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Store all values in nums in a set for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node to handle cases where the head might need to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // Traverse the linked list and remove nodes whose values exist in the set
        while (curr != null) {
            if (set.contains(curr.val)) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev pointer forward if the current node is not removed
                prev = curr;
            }
            // Move curr pointer forward
            curr = curr.next;
        }

        return dummy.next;
    }
}