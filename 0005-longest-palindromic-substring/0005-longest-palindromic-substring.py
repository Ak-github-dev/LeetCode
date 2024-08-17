"""
Steps:

Expand Around Each Center:

For each possible center, expand outward while the substring remains a palindrome.
Track the longest palindrome found during these expansions.

Edge Cases:

If the input string has a length of 1, the longest palindrome is the string itself.
If the input string is already a palindrome, the entire string is returned.
"""
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        def expandAroundCenter(s, left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1


            
        if not s or len(s) == 1:
            return s
        
        start, end = 0, 0
        
        for i in range(len(s)):
            len1 = expandAroundCenter(s, i, i)  # Odd length palindrome
            len2 = expandAroundCenter(s, i, i + 1)  # Even length palindrome
            max_len = max(len1, len2)
            
            if max_len > end - start:
                start = i - (max_len - 1) // 2
                end = i + max_len // 2
        
        return s[start:end + 1]

    def expandAroundCenter(s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return right - left - 1