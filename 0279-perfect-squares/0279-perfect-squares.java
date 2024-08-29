/*
Dynamic Programming Approach:

Define a DP Array:

Let dp[i] represent the least number of perfect square numbers that sum to i.
Initialize dp[0] to 0 because zero perfect squares sum up to 0.

Transition:

For each number i from 1 to n, we want to compute dp[i].
For every perfect square number j * j (where j * j <= i), update dp[i] as:
dp[i] = min(dp[i],dp[i−j∗j]+1)
The idea is to reduce the problem to a smaller subproblem, subtracting the square of j from i and adding one to count the square itself.

Result:

The answer for n will be stored in dp[n].
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 needs 0 squares to sum up to 0
        
        // Calculate the least number of perfect squares for each number up to n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}