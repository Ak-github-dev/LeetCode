"""
Approach:

BFS Initialization:

Start BFS from beginWord.
Use a queue to manage the current word and the level (number of transformations) from the beginWord.
Use a set to store all words from the wordList for quick lookup.

Exploration:

For each word, explore all possible words by changing each letter to any letter from 'a' to 'z'.
If the new word is in the wordList, it's a valid transformation.
If this new word is the endWord, return the current level + 1 (indicating the shortest path has been found).
Otherwise, add this new word to the queue and remove it from the wordList (to avoid revisiting).

Termination:

If the queue is exhausted without finding the endWord, return 0 (indicating no valid transformation sequence exists).
"""
from collections import deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        
        wordList = set(wordList)  # Convert list to set for O(1) lookups
        queue = deque([(beginWord, 1)])  # Queue stores (current_word, current_level)
        
        while queue:
            current_word, level = queue.popleft()
            
            for i in range(len(current_word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = current_word[:i] + c + current_word[i+1:]
                    
                    if next_word == endWord:
                        return level + 1
                    
                    if next_word in wordList:
                        wordList.remove(next_word)
                        queue.append((next_word, level + 1))
        
        return 0