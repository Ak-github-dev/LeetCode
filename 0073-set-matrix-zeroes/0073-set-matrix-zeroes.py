"""
Steps:
Use First Row and First Column as Markers:

Traverse the matrix and use the first row and first column to mark rows and columns that should be set to zero. We also need to track separately if the first row and the first column themselves should be set to zero.
Mark Rows and Columns:

Traverse the matrix and for each element that is zero, set the corresponding element in the first row and the first column to zero.
Set Zeroes Based on Markers:

Traverse the matrix again (excluding the first row and first column) and use the markers to set the elements to zero.
Handle First Row and First Column:

Finally, set the first row and first column to zero if needed based on the separate tracking.
"""
"""
Complexity Analysis:

Time Complexity: O(m×n), where m is the number of rows and n is the number of columns. We traverse the matrix multiple times but each traversal is linear.

Space Complexity: O(1), as we use no extra space apart from a few variables to track the state of the first row and column.
"""
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        if not matrix:
            return

        rows, cols = len(matrix), len(matrix[0])
        first_row_has_zero = any(matrix[0][j] == 0 for j in range(cols))
        first_col_has_zero = any(matrix[i][0] == 0 for i in range(rows))

        # Use first row and column as markers
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0

        # Set zeroes based on markers in the first row and column
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        # Handle the first row
        if first_row_has_zero:
            for j in range(cols):
                matrix[0][j] = 0

        # Handle the first column
        if first_col_has_zero:
            for i in range(rows):
                matrix[i][0] = 0