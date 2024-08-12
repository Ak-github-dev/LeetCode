"""
Approach:

Level-Order Traversal (BFS):

Use a queue to traverse the tree level by level.
For each level, capture the last node. This node will be visible from the right side.
Add the value of the last node of each level to the result list.

Edge Cases:

If the tree is empty (i.e., the root is None), return an empty list.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        
        result = []
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.popleft()
                # If it's the last node in the current level, add it to the result
                if i == level_size - 1:
                    result.append(node.val)
                
                # Add left and right children to the queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        
        return result