"""
Steps:
Interleave the Nodes:

Traverse the list and create new nodes. Insert each new node right after the corresponding original node.
Copy Random Pointers:

Traverse the list again. For each new node, set its random pointer using the random pointer of the corresponding original node.
Restore the Original List and Extract the Copied List:

Traverse the interleaved list to separate the original nodes and the copied nodes into two distinct lists.
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return None

        # Step 1: Create new nodes and interleave them with the original nodes
        current = head
        while current:
            new_node = Node(current.val, current.next)
            current.next = new_node
            current = new_node.next
        
        # Step 2: Assign random pointers for the new nodes
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next

        # Step 3: Separate the original list and the copied list
        original = head
        copy = head.next
        new_head = head.next
        
        while original:
            original.next = original.next.next
            if copy.next:
                copy.next = copy.next.next
            original = original.next
            copy = copy.next
        
        return new_head