/*
Approach:

Calculate the Total Length of the Linked List:

First, traverse the entire list to determine the total number of nodes (length).

Determine the Size of Each Part:

We calculate the minimum size of each part using integer division: length / k.
The remainder (length % k) gives us the number of parts that should have one extra node.

Create the Parts:

For each part:
Start from the current node and create a new linked list of the required size.
For the first remainder parts, include an extra node.
Update the current node to the next part after slicing the current part.

Handle Empty Parts:

If there are fewer nodes than k, some parts will be empty, represented by null.
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // First, calculate the total length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Determine the size of each part
        int partSize = length / k;
        int remainder = length % k; // The first remainder parts should have an extra node
        
        // Array to store the k parts
        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode prev = null;
            
            // Determine the size for this part
            int currentPartSize = partSize + (i < remainder ? 1 : 0);
            
            // Move current forward by currentPartSize steps
            for (int j = 0; j < currentPartSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }
            
            // Cut off the current part from the rest of the list
            if (prev != null) {
                prev.next = null;
            }
            
            // Store the current part in the result array
            result[i] = partHead;
        }

        return result;
    }
}