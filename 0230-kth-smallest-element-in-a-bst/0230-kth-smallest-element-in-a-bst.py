"""
Approach:
In-order Traversal:
Perform an in-order traversal of the BST.
During the traversal, keep a counter to track the number of nodes visited.
When the counter reaches k, record the value of the current node.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def in_order_traversal(node):
            if not node:
                return []
            # Traverse left subtree, visit current node, then traverse right subtree
            return in_order_traversal(node.left) + [node.val] + in_order_traversal(node.right)
        
        # Get all elements in in-order traversal
        sorted_elements = in_order_traversal(root)
        # Return the k-th smallest element (1-indexed)
        return sorted_elements[k - 1]