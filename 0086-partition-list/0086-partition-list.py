"""
Approach:
Create Two Separate Lists:

One list (before) will store all nodes with values less than x.
Another list (after) will store all nodes with values greater than or equal to x.
Traverse the Original List:

Traverse through the original linked list and partition the nodes into the before and after lists based on their values.
Combine the Two Lists:

Connect the before list to the after list.
Ensure the after list ends with a None to mark the end of the combined list.
Return the Head of the Combined List:

The head of the new partitioned list will be the start of the before list.
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        # Step 1: Initialize two dummy nodes for the before and after lists
        before_head = ListNode(0)
        before = before_head
        after_head = ListNode(0)
        after = after_head
        
        # Step 2: Traverse the original list
        while head:
            if head.val < x:
                before.next = head
                before = before.next
            else:
                after.next = head
                after = after.next
            head = head.next
        
        # Step 3: Combine the two lists
        after.next = None  # End the after list
        before.next = after_head.next  # Connect the before list to the after list
        
        return before_head.next