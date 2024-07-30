"""
Steps

Calculate the Length:

Traverse the list to find its length and also keep track of the tail node.

Connect Tail to Head:

Form a circular linked list by connecting the tail node to the head.

Find New Head and New Tail:

Calculate the position of the new tail, which is (length−kmodlength−1).
The new head is the node next to the new tail.

Break the Circle:

Set the next of the new tail to None to break the circular connection.
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head or not head.next or k == 0:
            return head

        # Step 1: Find the length of the list and the tail node
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1

        # Step 2: Form a circular linked list
        tail.next = head

        # Step 3: Find the new head and new tail
        k = k % length
        steps_to_new_head = length - k
        new_tail = head
        for _ in range(steps_to_new_head - 1):
            new_tail = new_tail.next
        new_head = new_tail.next

        # Step 4: Break the circle
        new_tail.next = None

        return new_head