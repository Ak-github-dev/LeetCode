"""
Approach:
Understanding Preorder and Inorder:
Preorder Traversal: Visits nodes in the order of Root -> Left -> Right.
Inorder Traversal: Visits nodes in the order of Left -> Root -> Right.
Recursive Construction:
The first element in the preorder list is always the root of the tree or subtree.
Find this root element in the inorder list. The elements to the left of this root in the inorder list belong to the left subtree, and the elements to the right belong to the right subtree.
Recursively apply this process to construct the left and right subtrees.
Steps:
Identify the root from the preorder array.
Find the root in the inorder array to divide it into left and right subtrees.
Recursively build the left and right subtrees using the corresponding subarrays of preorder and inorder.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None
        
        # The first element of preorder is always the root
        root_val = preorder[0]
        root = TreeNode(root_val)
        
        # Find the index of the root in inorder to split into left and right subtrees
        mid = inorder.index(root_val)
        
        # Recursively build the left and right subtree
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        
        return root