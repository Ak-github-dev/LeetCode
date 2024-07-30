"""
Approach

Prefix and Suffix Counts:

We can maintain two arrays: prefix_b_count and suffix_a_count.
prefix_b_count[i] will store the count of 'b's from the start of the string up to index i.
suffix_a_count[i] will store the count of 'a's from index i to the end of the string.

Calculate Prefix and Suffix Counts:

Traverse the string from left to right to populate prefix_b_count.
Traverse the string from right to left to populate suffix_a_count.

Determine Minimum Deletions:

At each index i, we need to consider:
All 'a's to the right of i should be removed (suffix_a_count[i]).
All 'b's to the left of i should be removed (prefix_b_count[i]).
The total deletions at each index i would be the sum of prefix_b_count[i] and suffix_a_count[i+1].

Find the minimum value of deletions across all possible indices.
"""

class Solution(object):
    def minimumDeletions(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
    
        # Step 1: Calculate prefix_b_count
        prefix_b_count = [0] * (n + 1)
        for i in range(1, n + 1):
            prefix_b_count[i] = prefix_b_count[i - 1] + (1 if s[i - 1] == 'b' else 0)
        
        # Step 2: Calculate suffix_a_count
        suffix_a_count = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix_a_count[i] = suffix_a_count[i + 1] + (1 if s[i] == 'a' else 0)
        
        # Step 3: Find the minimum deletions
        min_deletions = float('inf')
        for i in range(n + 1):
            min_deletions = min(min_deletions, prefix_b_count[i] + suffix_a_count[i])
        
        return min_deletions

        