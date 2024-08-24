/*
Approach:

Dynamic Programming (DP) Concept:

Define a DP table dp[i][j] where dp[i][j] represents the minimum number of turns needed to print the substring s[i...j].
The goal is to compute dp[0][n-1], where n is the length of the string s.

Base Case:

If i == j, then dp[i][j] = 1 because a single character only requires one turn to print.

Transition:

For each substring s[i...j], you check every possible split point k where i <= k < j:
If s[k] == s[j], the last print of s[j] can be merged with the print of s[k], so dp[i][j] = dp[i][k] + dp[k+1][j-1].
If s[k] != s[j], you would print s[i...k] and then s[k+1...j], so dp[i][j] = dp[i][k] + dp[k+1][j].
Minimize the number of operations across all possible splits.

Final Answer:

The final answer is stored in dp[0][n-1].
*/
class Solution {
    public int strangePrinter(String s) {
         int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len; // Maximum turns is len, each character separately.
                
                for (int k = i; k < j; k++) {
                    int total = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(k) == s.charAt(j)) {
                        total--;
                    }
                    dp[i][j] = Math.min(dp[i][j], total);
                }
            }
        }
        return dp[0][n-1];
    }
}