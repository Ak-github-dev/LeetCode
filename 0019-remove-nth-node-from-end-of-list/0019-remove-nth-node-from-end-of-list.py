"""
Approach:

Two Pointers:

Use two pointers, fast and slow.
Move the fast pointer n steps ahead of the slow pointer.
Then move both pointers at the same pace. When the fast pointer reaches the end of the list, the slow pointer will be at the node just before the one you want to remove.

Edge Cases:

If n equals the length of the list, the node to remove is the head.
Handle cases where the list contains only one node or where n is equal to the length of the list.
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0, head)
        fast = slow = dummy
        
        # Move fast n+1 steps ahead so there's a gap of n between fast and slow
        for _ in range(n + 1):
            fast = fast.next
        
        # Move both fast and slow until fast reaches the end
        while fast:
            fast = fast.next
            slow = slow.next
        
        # Skip the desired node
        slow.next = slow.next.next
        
        return dummy.next