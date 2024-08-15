"""
Steps to Construct the Quad-Tree:

Base Case: If the grid is uniform (all 1s or all 0s), create a leaf node with the value corresponding to the grid's value and set isLeaf = True.

Recursive Case: If the grid is not uniform:

Set isLeaf = False.
Divide the grid into four equal parts (top-left, top-right, bottom-left, bottom-right).
Recursively construct the Quad-Tree for each of these subgrids.
Create a node with these four sub-trees as children.

Node Structure: The Node class has attributes for val, isLeaf, and pointers to its four children (topLeft, topRight, bottomLeft, bottomRight).
"""
"""
# Definition for a QuadTree node.
class Node(object):
    def __init__(self, val=False, isLeaf=False, topLeft=None, topRight=None, bottomLeft=None, bottomRight=None):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""


class Solution(object):
    def construct(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: Node
        """
        def is_uniform(x, y, length):
            val = grid[x][y]
            for i in range(x, x + length):
                for j in range(y, y + length):
                    if grid[i][j] != val:
                        return False, val
            return True, val

        def build_quad_tree(x, y, length):
            uniform, val = is_uniform(x, y, length)
            if uniform:
                return Node(val == 1, True)
            
            half = length // 2
            topLeft = build_quad_tree(x, y, half)
            topRight = build_quad_tree(x, y + half, half)
            bottomLeft = build_quad_tree(x + half, y, half)
            bottomRight = build_quad_tree(x + half, y + half, half)
            
            return Node(val == 1, False, topLeft, topRight, bottomLeft, bottomRight)

        return build_quad_tree(0, 0, len(grid))