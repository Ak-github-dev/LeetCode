"""
Steps:

Base Case:

If the array is empty, return None.

Recursive Case:

Find the middle element of the array, which will be the root of the current subtree.
Recursively create the left subtree using the left half of the array.
Recursively create the right subtree using the right half of the array.
Return the root node.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None
        
        # Find the middle element
        mid = len(nums) // 2
        
        # Create the root node with the middle element
        root = TreeNode(nums[mid])
        
        # Recursively construct the left subtree and attach to root
        root.left = self.sortedArrayToBST(nums[:mid])
        
        # Recursively construct the right subtree and attach to root
        root.right = self.sortedArrayToBST(nums[mid+1:])
        
        return root