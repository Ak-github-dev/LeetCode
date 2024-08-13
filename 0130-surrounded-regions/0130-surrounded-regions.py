"""
Approach:

Mark the Boundary 'O's:

We start by marking all 'O's that are connected to the boundary (top, bottom, left, and right edges). These 'O's cannot be surrounded, so we will not flip them.
We can use Depth-First Search (DFS) or Breadth-First Search (BFS) starting from each 'O' on the boundary to mark all connected 'O's.

Flip the Remaining 'O's:

After marking, any 'O' that is not marked must be surrounded, so we flip them to 'X'.

Restore the Marked 'O's:

Finally, we restore the marked 'O's back to 'O' since they should not be captured.
"""
class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        rows, cols = len(board), len(board[0])

        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != 'O':
                return
            # Mark the 'O' as part of a safe region by changing it to a temporary marker (e.g., '#')
            board[r][c] = '#'
            # Explore the four directions
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        # Mark all 'O's connected to the boundary
        for i in range(rows):
            if board[i][0] == 'O':
                dfs(i, 0)
            if board[i][cols - 1] == 'O':
                dfs(i, cols - 1)

        for j in range(cols):
            if board[0][j] == 'O':
                dfs(0, j)
            if board[rows - 1][j] == 'O':
                dfs(rows - 1, j)

        # Flip the remaining 'O's to 'X', and restore the marked 'O's back to 'O'
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == '#':
                    board[i][j] = 'O'