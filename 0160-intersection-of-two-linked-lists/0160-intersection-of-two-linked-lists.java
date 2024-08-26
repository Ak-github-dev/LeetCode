/*
Approach:
Two Pointers Technique:
Use two pointers, pA and pB, initially set to the heads of listA and listB, respectively.
Traverse both lists. When a pointer reaches the end of a list, redirect it to the head of the other list.
If the lists intersect, the pointers will eventually meet at the intersection node after traversing the same total length.
If the lists do not intersect, both pointers will reach the end (null) at the same time, and the loop will exit.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Traverse both lists
        while (pA != pB) {
            // If we reach the end of one list, switch to the other list
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        // pA and pB will either meet at the intersection node or at null
        return pA;
    }
}