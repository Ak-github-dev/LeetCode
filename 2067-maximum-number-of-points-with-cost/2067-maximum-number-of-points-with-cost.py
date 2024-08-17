"""
Problem Breakdown:

Matrix Definition:
Given a matrix points where points[r][c] represents the points you can gain by choosing the cell (r, c) in row r.
Transitioning between rows has a cost, defined as abs(c1 - c2) for choosing column c1 in row r and column c2 in row r + 1.
Objective:
Maximize the sum of points across all rows, considering the cost for moving between columns from one row to the next.

Dynamic Programming Approach:
DP Definition:
Let dp[c] represent the maximum score obtainable in the current row by choosing column c.
Transition:
We need to update dp[c2] for the next row using the values from the current row.
However, directly calculating the max for each possible transition would be inefficient, leading to a naive O(m×n^2) complexity, which is too slow for large inputs.

Optimization:
To optimize, we can utilize the following approach:
Left to Right Sweep: Compute the maximum possible value we can carry from the left to the right.
Right to Left Sweep: Compute the maximum possible value we can carry from the right to the left.
This allows us to efficiently compute the maximum value at each column in the next row considering the transition costs.
"""
class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        m, n = len(points), len(points[0])
    
        # dp will hold the maximum points at each column for the current row
        dp = points[0]
        
        for r in range(1, m):
            # Left to right sweep
            left_dp = [0] * n
            left_dp[0] = dp[0]
            for c in range(1, n):
                left_dp[c] = max(left_dp[c - 1] - 1, dp[c])
            
            # Right to left sweep
            right_dp = [0] * n
            right_dp[-1] = dp[-1]
            for c in range(n - 2, -1, -1):
                right_dp[c] = max(right_dp[c + 1] - 1, dp[c])
            
            # Update dp for the next row
            for c in range(n):
                dp[c] = points[r][c] + max(left_dp[c], right_dp[c])
        
        return max(dp)