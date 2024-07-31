"""
Steps:
Initialization:

dp[0][0] is 0 since no operation is needed to convert an empty string to an empty string.
dp[i][0] is i because it takes i deletions to convert a string of length i to an empty string.
dp[0][j] is j because it takes j insertions to convert an empty string to a string of length j.
DP Transition:

If word1[i-1] == word2[j-1], then no new operation is needed: dp[i][j] = dp[i-1][j-1].
If word1[i-1] != word2[j-1], consider the minimum of the three operations:
Insert: dp[i][j-1] + 1
Delete: dp[i-1][j] + 1
Replace: dp[i-1][j-1] + 1
"""
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m, n = len(word1), len(word2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        
        # Initialize the base cases
        for i in range(m + 1):
            dp[i][0] = i
        for j in range(n + 1):
            dp[0][j] = j
        
        # Fill the dp array
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1] + 1,  # Replace
                                dp[i][j - 1] + 1,      # Insert
                                dp[i - 1][j] + 1)      # Delete
        
        return dp[m][n]
