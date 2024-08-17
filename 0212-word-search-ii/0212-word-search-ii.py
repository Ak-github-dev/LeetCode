"""
Key Steps:
Trie Construction:

Insert all the words from the list into a Trie. This allows us to efficiently check if a prefix of a word exists in the dictionary.
DFS with Backtracking:

For each cell in the board, initiate a DFS to explore all possible paths that could form words present in the Trie.
Mark cells as visited during exploration to avoid revisiting them within the same path.
If a valid word is found during DFS, add it to the result list.
Early Termination:

If at any point during DFS the current prefix doesn't match any word in the Trie, terminate that path early.
Edge Cases:

If the board is empty or the list of words is empty, return an empty list.
"""
class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = None

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.word = word


class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        def dfs(node, i, j):
            char = board[i][j]
            if char not in node.children:
                return
            
            next_node = node.children[char]
            if next_node.word:
                found_words.add(next_node.word)
                next_node.word = None  # Avoid duplicates
            
            board[i][j] = '#'  # Mark as visited
            
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < len(board) and 0 <= y < len(board[0]) and board[x][y] != '#':
                    dfs(next_node, x, y)
            
            board[i][j] = char  # Restore the board cell




        # Build the Trie
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        found_words = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(trie.root, i, j)
        
        return list(found_words)
