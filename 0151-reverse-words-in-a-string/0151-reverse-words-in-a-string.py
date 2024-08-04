"""
Split the String:

Split the string by spaces to get a list of words. This will handle multiple spaces naturally, as empty strings resulting from consecutive spaces will be ignored.

Reverse the List of Words:

Reverse the list of words obtained from the split operation.

Join the Words:

Join the reversed list of words with a single space to form the final string.
"""
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Split the string into words, ignoring multiple spaces
        words = s.split()
        
        # Reverse the list of words
        reversed_words = words[::-1]
        
        # Join the reversed list of words with a single space
        result = ' '.join(reversed_words)
        
        return result