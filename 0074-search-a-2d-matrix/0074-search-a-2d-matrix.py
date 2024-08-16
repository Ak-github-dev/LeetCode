"""
Key Idea:
Since the matrix is sorted in a specific manner, we can apply binary search to efficiently search for the target. The trick is to map the 2D matrix indices to a 1D array index, which allows us to perform the binary search as if the matrix were a single sorted list.

Approach:
Matrix Properties:

The matrix has m rows and n columns.
Treat the matrix as a single list of size m * n.
Binary Search:

Use binary search on the "flattened" index:
Calculate the middle index in this "flattened" array.
Map this middle index back to the 2D matrix to check the value.
Adjust the search range based on whether the target is smaller or larger than the current middle element.
Mapping Formula:

For an index i in the 1D array, the corresponding element in the 2D matrix is located at matrix[i // n][i % n] where n is the number of columns.
"""
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        
        while left <= right:
            mid = (left + right) // 2
            mid_value = matrix[mid // n][mid % n]
            
            if mid_value == target:
                return True
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False