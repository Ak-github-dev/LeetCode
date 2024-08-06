"""
Approach
We can use a hashmap or array freq to store the frequency of each letter in word. Once we add the count of each letter from word to freq, we sort the array in descending order. After sorting, the most frequent characters will be at the beginning of the array.

Sorting the array will help us to greedily find the minimum number of pushes needed. This is because we start off by mapping the most frequently pushed characters in word. The first 8 distinct characters need 1 push, then 2 ... For this approach, we map the most frequently pushed characters to the first 8 buttons (at this point they will require only 1 push) until we have to go back to the first button if word has more than 8 distinct characters.

We use (i / 8 + 1) which determines the multiplier based on the position. For every 8 characters, the multiplier increases by 1. (e.g positions 0-7 have a multiplier of 1, 8-15 have a multiplier of 2 and so on). We sum up res and stop the loop when freq[i] == 0 indicating no more characters.

Complexity
Time complexity: O(n)
Space complexity: O(1)
"""
class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        res = i = 0
        for n in sorted(Counter(word).values(), reverse=True):
            res += n * (i // 8 + 1)
            i += 1
        return res