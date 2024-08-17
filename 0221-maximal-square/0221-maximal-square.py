"""
Key Observations:

Base Case:

If matrix[i][j] is '0', then dp[i][j] is 0 because a square cannot end at a cell with a '0'.
If matrix[i][j] is '1', then the value of dp[i][j] will depend on the minimum value of the neighboring cells in the DP table: dp[i-1][j] (top), dp[i][j-1] (left), and dp[i-1][j-1] (top-left diagonal).

Transition:

If matrix[i][j] is '1', then dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1.
This formula works because to form a square of side length greater than 1, all three of these neighbors must be part of a square as well.

Result:

The result will be the maximum value in the DP table, and the area of the square will be that value squared.
"""
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        max_side = 0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    max_side = max(max_side, dp[i][j])
        
        return max_side * max_side