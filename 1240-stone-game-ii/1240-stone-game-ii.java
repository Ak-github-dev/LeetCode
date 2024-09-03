/*
Approach:

Dynamic Programming with Memoization:

Use a 2D DP array dp[i][M] where i is the index of the pile from which the player can start picking stones and M is the maximum number of piles the player can take.
The value of dp[i][M] will represent the maximum number of stones the current player can get if they start from pile i with the maximum M.

Recursive Transition:

For each index i and M, consider taking X piles (where 1 <= X <= 2M), and calculate the number of stones the current player can collect.
Then, recursively calculate the result for the opponent starting from pile i + X with a new M = max(M, X).
The current player wants to maximize their stones, so we keep track of the maximum value possible.

Memoization:

Store the results of subproblems in the DP array to avoid recomputation.
*/
class Solution {
    private int[][] dp;
    private int[] suffixSum;
    public int stoneGameII(int[] piles) {
       int n = piles.length;
        dp = new int[n][n];
        suffixSum = new int[n];
        
        // Calculate the suffix sums for quick lookups
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        return maxStones(0, 1);
    }

    private int maxStones(int i, int M) {
        if (i >= dp.length) {
            return 0;
        }

        if (2 * M >= dp.length - i) {
            return suffixSum[i]; // If we can take all remaining piles, take them
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int max = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int next = maxStones(i + X, Math.max(M, X));
            max = Math.max(max, suffixSum[i] - next);
        }

        dp[i][M] = max;
        return max; 
    }
}