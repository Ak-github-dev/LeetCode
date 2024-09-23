/*
Approach:

Dynamic Programming Table:

Create a DP array dp[] where dp[i] represents the minimum number of extra characters if we consider the substring s[0...i-1].
The goal is to minimize dp[n], where n is the length of the string.

Transition:

For each position i in the string, try to match every word in the dictionary.
If the word from the dictionary can fit starting at position i, update the DP table to reflect fewer extra characters.

Base Case:

dp[0] = 0, meaning if there is no string, there are no extra characters.

Final Answer:

After filling the DP array, dp[n] will give the minimum number of extra characters that could not be matched by any word in the dictionary.
*/
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>();
        
        // Add dictionary words into a set for faster lookup
        for (String word : dictionary) {
            wordSet.add(word);
        }

        // dp[i] will store the minimum number of extra characters for substring s[0:i]
        int[] dp = new int[n + 1];
        
        // Initialize dp array with worst case, where all characters are extra
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            // Try to match every substring starting at i with words from dictionary
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (wordSet.contains(substring)) {
                    dp[j] = Math.min(dp[j], dp[i]);
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + j - i);
                }
            }
        }

        return dp[n];
    }
}