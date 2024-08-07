"""
Detailed Explanation:

Initialization:

rows and cols are initialized to the dimensions of the board.
directions is a list of tuples representing the 8 possible directions (horizontal, vertical, diagonal) to check for neighbors.

Helper Function:

count_live_neighbors(row, col) counts the number of live neighbors for the cell at position (row, col). A cell is considered "live" if it is 1 (currently alive) or 2 (was alive but is marked to die).

Mark Cells Based on Rules:

Iterate through each cell in the board.
Count the live neighbors using the count_live_neighbors function.
Apply the rules:
If a live cell has fewer than 2 or more than 3 live neighbors, mark it as 2 (was alive but will die).
If a dead cell has exactly 3 live neighbors, mark it as -1 (was dead but will come to life).

Update Board:

Iterate through the board again to finalize the state of each cell:
Convert cells marked as 2 to 0 (dead).
Convert cells marked as -1 to 1 (alive).
"""
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0]) if rows > 0 else 0
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        def count_live_neighbors(row, col):
            live_count = 0
            for dx, dy in directions:
                neighbor_row, neighbor_col = row + dx, col + dy
                if 0 <= neighbor_row < rows and 0 <= neighbor_col < cols:
                    if board[neighbor_row][neighbor_col] == 1 or board[neighbor_row][neighbor_col] == 2:
                        live_count += 1
            return live_count
        for i in range(rows):
            for j in range(cols):
                # Count live neighbors
                live_neighbors = count_live_neighbors(i, j)
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = -1 
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0  # Convert dead cell (was alive) to 0
                elif board[i][j] == -1:
                    board[i][j] = 1  # Convert live cell (was dead) to 1