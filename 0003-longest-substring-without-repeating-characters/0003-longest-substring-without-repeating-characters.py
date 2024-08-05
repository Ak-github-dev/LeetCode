"""
Steps:

Use Two Pointers:

Use two pointers, left and right, to represent the current window of characters being considered.
Move the right pointer to expand the window and include new characters.
Move the left pointer to shrink the window when a duplicate character is encountered.

Track Characters in the Current Window:

Use a set to keep track of characters currently in the window.
If the character at right is already in the set, move the left pointer to the right until the duplicate character is removed from the window.

Update Maximum Length:

Continuously update the maximum length of the substring without repeating characters as the window expands and contracts.
"""
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_set = set()
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            # If the character is in the set, move the left pointer to the right
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1
            # Add the character to the set and update the maximum length
            char_set.add(s[right])
            max_length = max(max_length, right - left + 1)
        
        return max_length