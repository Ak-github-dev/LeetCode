"""
Approach:

Understanding the Problem:

The "linked list" should be created in place by modifying the original tree.
After flattening, the left child of each node should be None, and the right child should point to the next node in the pre-order traversal sequence.
In-Place Flattening:

We can modify the tree as we go by using the right pointers of the nodes to form the "linked list".
For each node, if it has a left subtree, we need to move it to the right, and then append the original right subtree to the end of this newly moved subtree.

Steps:

Traverse the tree node by node.
For each node, if it has a left child:
Find the rightmost node in the left subtree.
Connect this rightmost node to the original right subtree.
Move the left subtree to the right.
Set the left child to None.
Move to the next node in the modified right subtree.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        current = root
    
        while current:
            if current.left:
                # Find the rightmost node in the left subtree
                rightmost = current.left
                while rightmost.right:
                    rightmost = rightmost.right
                
                # Connect the rightmost node to the current's right subtree
                rightmost.right = current.right
                
                # Move the left subtree to the right
                current.right = current.left
                current.left = None
            
            # Move to the next node in the modified right subtree
            current = current.right
