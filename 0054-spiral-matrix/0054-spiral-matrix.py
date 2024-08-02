"""
Approach:
Initialize Boundaries:

Define the boundaries for the top, bottom, left, and right edges of the matrix.
Traverse the Matrix:

Move from the left to the right along the top boundary, then increment the top boundary.
Move from the top to the bottom along the right boundary, then decrement the right boundary.
Move from the right to the left along the bottom boundary, then decrement the bottom boundary.
Move from the bottom to the top along the left boundary, then increment the left boundary.
Continue this process until all elements are traversed.
Stop Condition:

The traversal stops when the top boundary exceeds the bottom boundary or the left boundary exceeds the right boundary.
"""
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or not matrix[0]:
            return []
        
        result = []
        top, bottom = 0, len(matrix) - 1
        left, right = 0, len(matrix[0]) - 1
        
        while top <= bottom and left <= right:
            # Traverse from left to right along the top row
            for j in range(left, right + 1):
                result.append(matrix[top][j])
            top += 1
            
            # Traverse from top to bottom along the right column
            for i in range(top, bottom + 1):
                result.append(matrix[i][right])
            right -= 1
            
            if top <= bottom:
                # Traverse from right to left along the bottom row
                for j in range(right, left - 1, -1):
                    result.append(matrix[bottom][j])
                bottom -= 1
            
            if left <= right:
                # Traverse from bottom to top along the left column
                for i in range(bottom, top - 1, -1):
                    result.append(matrix[i][left])
                left += 1
        
        return result