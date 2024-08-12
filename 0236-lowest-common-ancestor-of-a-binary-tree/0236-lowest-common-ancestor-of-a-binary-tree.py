"""
Approach:

Recursive DFS Traversal:

Start at the root of the tree and recursively traverse down.
If the current node is either p or q, return the current node.
Recursively search the left and right subtrees.
If both left and right recursive calls return non-null values, it means one node is found in each subtree, and hence the current node is the LCA.
If only one of the calls returns a non-null value, propagate it up (since both nodes are in one subtree or the node itself is the LCA).

Base Cases:

If the current node is None, return None.
If the current node is p or q, return the current node.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Base case: If root is None or root is one of p or q
        if not root or root == p or root == q:
            return root
        
        # Recur for left and right subtrees
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # If both left and right are non-null, root is the LCA
        if left and right:
            return root
        
        # Otherwise, return the non-null child
        return left if left else right