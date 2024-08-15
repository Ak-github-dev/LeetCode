"""
Approach:
DFS Exploration:

Start the DFS from each cell in the grid.
From each starting cell, explore its neighbors (up, down, left, right) recursively.
Mark cells as visited to avoid reusing them in the current path.
If the word is found during the DFS, return True.
Backtracking:

If the current path does not lead to a solution, backtrack by unmarking the cell as visited.
Continue exploring other possible paths.
Boundary Conditions:

Ensure the DFS does not go out of bounds.
Stop the DFS if the current character does not match the corresponding character in the word.
"""
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def dfs(board, word, i, j, k):
            if k == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[k]:
                return False
            
            # Mark the cell as visited by modifying the board in place
            temp = board[i][j]
            board[i][j] = '#'
            
            # Explore all four directions (up, down, left, right)
            found = (dfs(board, word, i+1, j, k+1) or
                    dfs(board, word, i-1, j, k+1) or
                    dfs(board, word, i, j+1, k+1) or
                    dfs(board, word, i, j-1, k+1))
            
            # Restore the original value of the board
            board[i][j] = temp
            
            return found
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(board, word, i, j, 0):
                    return True
        
        return False