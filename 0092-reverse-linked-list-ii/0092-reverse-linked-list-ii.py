# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseBetween(self, head, left, right):
        """
        :type head: ListNode
        :type left: int
        :type right: int
        :rtype: ListNode
        """
        # Edge case where no reversal is needed
        if left == right:
            return head
        
        # Create a dummy node to handle edge cases gracefully
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        
        # Move `prev` to the element right before `left`
        for _ in range(left - 1):
            prev = prev.next
        
        # `start` will eventually point to the element at position `left`
        start = prev.next
        then = start.next
        
        # Perform the actual reversal between left and right
        for _ in range(right - left):
            start.next = then.next
            then.next = prev.next
            prev.next = then
            then = start.next
        
        return dummy.next
