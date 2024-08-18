"""
Approach:

Character Frequency Counting:

First, we count the frequency of each character in the string t. This helps us know how many of each character we need in the current window to satisfy the requirement.

Sliding Window:

We use two pointers (left and right) to represent the current window in string s.
We expand the window by moving the right pointer to include more characters until all characters in t are included in the current window.
Once all required characters are included, we try to shrink the window from the left to find the smallest possible window that still contains all the characters from t.

Check and Update Minimum Window:

During the process, whenever a valid window is found (i.e., it contains all the characters from t with the correct frequency), we check if it's smaller than the previously recorded minimum window. If it is, we update the minimum window.

Final Result:

If a valid window is found during the process, return the minimum window substring. Otherwise, return an empty string.
"""
from collections import Counter, defaultdict
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not s or not t:
            return ""
        
        # Dictionary to keep count of all unique characters in t
        dict_t = Counter(t)
        
        # Number of unique characters in t that need to be present in the desired window
        required = len(dict_t)
        
        # Left and right pointer
        left, right = 0, 0
        
        # Formed is used to keep track of how many unique characters in t
        # are currently in the window in the desired frequency
        formed = 0
        
        # Dictionary to keep count of all the unique characters in the current window
        window_counts = defaultdict(int)
        
        # The result tuple (window length, left, right)
        ans = float("inf"), None, None
        
        while right < len(s):
            # Add one character from the right to the window
            character = s[right]
            window_counts[character] += 1
            
            # If the frequency of the current character added matches the desired count in t
            if character in dict_t and window_counts[character] == dict_t[character]:
                formed += 1
            
            # Try and contract the window till the point where it ceases to be 'desirable'
            while left <= right and formed == required:
                character = s[left]
                
                # Save the smallest window until now
                if right - left + 1 < ans[0]:
                    ans = (right - left + 1, left, right)
                
                # The character at the position pointed by the `left` pointer is no longer
                # a part of the window
                window_counts[character] -= 1
                if character in dict_t and window_counts[character] < dict_t[character]:
                    formed -= 1
                
                # Move the left pointer ahead, this would help to look for a new window
                left += 1
            
            # Keep expanding the window by moving the right pointer
            right += 1
        
        return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]