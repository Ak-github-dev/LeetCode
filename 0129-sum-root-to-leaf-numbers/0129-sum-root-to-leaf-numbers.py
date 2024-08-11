"""
Steps:

Recursive DFS Traversal:

Traverse the tree from the root to each leaf node.
Maintain a running total as you traverse down the tree, multiplying the current sum by 10 and adding the current node's value.

Base Case:

When you reach a leaf node (a node with no children), add the current total to the result.
Return the Result:

After traversing the entire tree, return the accumulated sum of all root-to-leaf paths.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, current_sum):
            if not node:
                return 0
            
            current_sum = current_sum * 10 + node.val
            
            # If it's a leaf node, return the current sum
            if not node.left and not node.right:
                return current_sum
            
            # Otherwise, return the sum of the left and right subtrees
            return dfs(node.left, current_sum) + dfs(node.right, current_sum)
        
        return dfs(root, 0)