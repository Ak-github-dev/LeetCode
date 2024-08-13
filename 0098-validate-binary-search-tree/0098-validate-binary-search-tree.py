"""
Approach:
We can solve this problem by recursively traversing the tree and keeping track of the permissible range of values for each node:

Recursion with Valid Range:
Start with the root node and an initial permissible range of (-inf, +inf).
For each node, check if its value lies within the current range.
Recursively check the left subtree with an updated range of (-inf, node.val) and the right subtree with an updated range of (node.val, +inf).
If any node violates this range, return False.
If all nodes satisfy their respective ranges, return True.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def validate(node, low=-float('inf'), high=float('inf')):
            # An empty node is a valid BST
            if not node:
                return True
            
            # The current node's value must be within the range
            if not (low < node.val < high):
                return False
            
            # Recursively validate the left and right subtrees
            return (validate(node.left, low, node.val) and
                    validate(node.right, node.val, high))
        
        return validate(root)
        