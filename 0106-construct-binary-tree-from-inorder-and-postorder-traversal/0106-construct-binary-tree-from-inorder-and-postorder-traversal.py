"""
Approach:
Understanding Traversals:

Inorder Traversal: Left subtree -> Root -> Right subtree.
Postorder Traversal: Left subtree -> Right subtree -> Root.
In the postorder traversal, the last element is always the root of the current subtree.
Recursive Construction:

Identify the root node from the last element of the postorder array.
Find the position of this root node in the inorder array. This position splits the inorder array into the left subtree and right subtree.
Recursively build the left and right subtrees using the corresponding portions of the inorder and postorder arrays.
Base Case:

If there are no elements to process in inorder or postorder, return None (which means there's no subtree).
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None
        
        # The last element in postorder is the root
        root_val = postorder.pop()
        root = TreeNode(root_val)
        
        # Find the index of the root in inorder to split the tree
        index = inorder.index(root_val)
        
        # Recursively build the right and left subtree
        # Build right subtree first since we're reducing postorder from the end
        root.right = self.buildTree(inorder[index + 1:], postorder)
        root.left = self.buildTree(inorder[:index], postorder)
        
        return root