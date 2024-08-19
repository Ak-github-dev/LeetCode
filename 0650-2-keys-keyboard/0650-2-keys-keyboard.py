"""
Insight:
The optimal strategy for solving this problem involves recognizing that the problem is essentially about breaking down n into its prime factors. This is because the minimum number of operations needed to obtain n 'A's on the screen corresponds to the sum of the factors of n.


Explanation:

Prime Factorization:

If you have n 'A's on the screen, and you have to reach n by starting with one 'A', you can think of this as multiplying the initial 'A' by some factors to reach n.
For example, to reach 9 'A's:
Start with 1 'A'.
Multiply by 3 (through "Copy All" and two "Paste" operations), and you get 3 'A's.
Multiply by 3 again to get 9 'A's.
The minimum number of operations is 6 (1 "Copy All" and 5 "Paste" operations, or equivalently 3 + 3).


Dynamic Programming Approach:

We can use dynamic programming to build up the solution iteratively.
Let dp[i] represent the minimum number of operations needed to get exactly i 'A's.
To compute dp[i], you consider all factors j of i (where i % j == 0), and dp[i] is the minimum value of dp[j] + (i // j).
"""
class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n + 1)
    
        for i in range (2, n + 1):
            dp[i] = i  # The worst case is we need `i` steps (all 'Paste')
            for j in range(1, i//2 + 1):
                if i % j == 0:
                    dp[i] = min(dp[i], dp[j] + i // j)
        
        return dp[n]