"""
o count the number of nodes in a complete binary tree efficiently, you can leverage the tree's complete nature to devise a solution that is faster than a simple O(n) traversal of all nodes. Specifically, the approach utilizes the properties of the complete binary tree to perform binary search and tree height calculations to achieve a time complexity better than O(n), ideally around O(log^2 n).

Approach to Solve the Problem:
Calculate Tree Height: First, determine the height of the tree by traversing from the root to the deepest left child. This gives the height h of the tree and can be done in O(log n) time because the tree is complete.

Binary Search on the Last Level:

The idea is to determine how many nodes are present in the last level of the tree. You can do this by performing a binary search on the indices of the last level's nodes.
If a node at a certain index exists, it means all nodes before it also exist, and if it doesn't exist, no nodes after it exist.
Count Nodes Using Binary Search:

Use the height of the tree to determine the range of possible node indices in the last level.
Apply binary search to count how many nodes exist in the last level.
Total Node Count:

Calculate the total number of nodes as the sum of all nodes in all full levels (which is 2^h −1, where h is the height of the tree excluding the last level) plus the number of nodes in the last level found via binary search.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        def tree_height(node):
            height = 0
            while node.left:
                node = node.left
                height += 1
            return height

        def node_exists(idx, h, node):
            left, right = 0, 2**h - 1
            for _ in range(h):
                mid = (left + right) // 2
                if idx <= mid:
                    node = node.left
                    right = mid
                else:
                    node = node.right
                    left = mid + 1
            return node is not None

        height = tree_height(root)
        if height == 0:
            return 1

        # Binary search to find how many nodes are in the last level
        left, right = 0, 2**height - 1
        while left <= right:
            mid = (left + right) // 2
            if node_exists(mid, height, root):
                left = mid + 1
            else:
                right = mid - 1

        # Total nodes up to the last level + nodes in the last level
        return (2**height - 1) + left