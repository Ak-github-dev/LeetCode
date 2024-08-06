"""
Steps:

Transpose the Matrix:

Iterate through the matrix and swap elements across the main diagonal. This means swapping matrix[i][j] with matrix[j][i] for i<j.

Reverse Each Row:

For each row in the transposed matrix, reverse the elements of the row.
"""
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
    
        # Step 1: Transpose the matrix
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # Step 2: Reverse each row
        for i in range(n):
            matrix[i].reverse()