"""
Approach:

Problem:

We need to find all substrings in s that are a concatenation of all the words in words without any intervening characters.
Each word in words has the same length, say word_length.
The total length of the concatenation is total_length = word_length * len(words).

Sliding Window with Hash Maps:

We maintain a hash map word_count that stores the frequency of each word in words.
We then slide a window of length total_length over the string s.
For each starting index in s, we check if the substring from that index forms a valid concatenation by:
Splitting it into words of length word_length.
Checking if the count of these words matches the word_count dictionary.

Optimization:

Instead of checking every possible starting index in s, we only check starting indices that are multiples of word_length. This ensures that our sliding window always aligns with word boundaries.
"""
from collections import Counter
class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not s or not words:
            return []
        
        word_length = len(words[0])
        total_length = word_length * len(words)
        word_count = Counter(words)
        n = len(s)
        
        results = []
        
        # We only need to slide the window from the first `word_length` characters
        for i in range(word_length):
            left = i
            current_count = Counter()
            count = 0
            
            # Slide the window from left to right
            for right in range(i, n - word_length + 1, word_length):
                word = s[right:right + word_length]
                if word in word_count:
                    current_count[word] += 1
                    count += 1
                    
                    # If there are more words than needed, slide the window from left
                    while current_count[word] > word_count[word]:
                        left_word = s[left:left + word_length]
                        current_count[left_word] -= 1
                        left += word_length
                        count -= 1
                    
                    # If the window matches the word list, record the start index
                    if count == len(words):
                        results.append(left)
                else:
                    # Reset the window
                    current_count.clear()
                    count = 0
                    left = right + word_length
        
        return results