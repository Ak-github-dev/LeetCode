/*
Approach:

Iterate through the List:

Traverse the linked list and for each adjacent pair of nodes, calculate the GCD of their values.

Insert GCD Nodes:

Create a new node with the GCD value and insert it between the two adjacent nodes.

Edge Case:

If the linked list contains only one node, no insertion is needed, and we simply return the original list.
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val);  // Calculate GCD between adjacent nodes
            ListNode newNode = new ListNode(gcdValue);  // Create a new node with the GCD value
            newNode.next = current.next;  // Insert new node between the current and next nodes
            current.next = newNode;
            current = newNode.next;  // Move to the next pair of nodes
        }
        
        return head;  // Return the modified list
    }
    
    // Helper function to calculate the GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}