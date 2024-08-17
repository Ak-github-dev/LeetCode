"""
Key Observations:

Length Check:

If the length of s3 is not equal to the sum of the lengths of s1 and s2, then s3 cannot be formed by interleaving s1 and s2.

DP Table Definition:

Let's define dp[i][j] as True if s3[:i+j] can be formed by interleaving s1[:i] and s2[:j].
dp[i][j] will be True if either:
dp[i-1][j] is True and s1[i-1] == s3[i+j-1] (meaning we take a character from s1), or
dp[i][j-1] is True and s2[j-1] == s3[i+j-1] (meaning we take a character from s2).

Base Case:

dp[0][0] is True because an empty s1 and s2 can form an empty s3.
"""
class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s1) + len(s2) != len(s3):
            return False
        
        dp = [[False] * (len(s2) + 1) for _ in range(len(s1) + 1)]
        
        dp[0][0] = True
        
        # Fill the first row (considering only s2)
        for j in range(1, len(s2) + 1):
            dp[0][j] = dp[0][j-1] and s2[j-1] == s3[j-1]
        
        # Fill the first column (considering only s1)
        for i in range(1, len(s1) + 1):
            dp[i][0] = dp[i-1][0] and s1[i-1] == s3[i-1]
        
        # Fill the rest of the table
        for i in range(1, len(s1) + 1):
            for j in range(1, len(s2) + 1):
                dp[i][j] = (dp[i-1][j] and s1[i-1] == s3[i+j-1]) or \
                        (dp[i][j-1] and s2[j-1] == s3[i+j-1])
        
        return dp[-1][-1]