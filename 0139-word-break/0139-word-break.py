"""
Dynamic Programming Approach:

Define the DP Array:

Let dp[i] be a boolean value that represents whether the substring s[0:i] (from the start to the i-th character) can be segmented into words found in the dictionary.

Transition Formula:

For each position i in the string s, we check every possible word ending at i.
If there exists an index j such that dp[j] is True (meaning s[0:j] can be segmented) and the substring s[j:i] is a word in the dictionary, then we can set dp[i] to True.

Initialization:

dp[0] should be True because an empty string is always a valid segmentation (base case).

Final Result:

The answer will be dp[len(s)], indicating whether the entire string s can be segmented into words from the dictionary.
"""
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        word_set = set(wordDict)  # Use a set for O(1) lookups
        dp = [False] * (len(s) + 1)
        dp[0] = True  # Base case: empty string can be segmented
        
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
        
        return dp[len(s)]