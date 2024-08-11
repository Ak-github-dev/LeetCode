"""
Approach:

Use a dummy node to traverse levels:

We can use a dummy node to help in linking all the nodes on the current level.
This dummy node will have its next pointer move across all nodes on the current level, and then we can use this setup to connect nodes at the next level.

Level Order Traversal (without extra space):

Start with the root node and initialize a current pointer that will move across the current level.
For each node in the current level:
Connect the left child (if it exists) to the next available position using the dummy node.
Connect the right child (if it exists) similarly.
Move to the next node in the current level using the next pointer.
Once the level is complete, move to the next level by setting the current pointer to the dummy node’s next pointer (which now points to the first node in the next level).
Reset the dummy node for the next iteration.
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        
        current = root
        dummy = Node(0)  # Dummy node that helps in linking nodes on the next level
        while current:
            tail = dummy  # Tail is used to build the next level's linked list
            while current:
                if current.left:
                    tail.next = current.left
                    tail = tail.next
                if current.right:
                    tail.next = current.right
                    tail = tail.next
                current = current.next  # Move to the next node in the current level
            
            # Move to the next level
            current = dummy.next
            dummy.next = None  # Reset the dummy node for the next level
        
        return root