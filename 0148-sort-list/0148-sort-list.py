"""
Steps:

Divide the List: Use the fast and slow pointer technique to find the middle of the linked list and split it into two halves.

Conquer (Sort Each Half): Recursively sort each half.

Combine (Merge the Sorted Halves): Merge the two sorted halves together.
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        
        # Step 1: Split the list into two halves using the fast and slow pointer approach
        def split_list(head):
            slow, fast = head, head.next
            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next
            mid = slow.next
            slow.next = None
            return head, mid
        
        # Step 2: Merge two sorted lists
        def merge_lists(l1, l2):
            dummy = ListNode(0)
            current = dummy
            while l1 and l2:
                if l1.val < l2.val:
                    current.next = l1
                    l1 = l1.next
                else:
                    current.next = l2
                    l2 = l2.next
                current = current.next
            current.next = l1 if l1 else l2
            return dummy.next
        
        # Step 3: Recursively split and merge
        left, right = split_list(head)
        left = self.sortList(left)
        right = self.sortList(right)
        
        # Merge sorted halves
        return merge_lists(left, right)