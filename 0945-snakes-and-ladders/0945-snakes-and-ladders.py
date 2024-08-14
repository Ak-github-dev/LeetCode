"""
Approach:
We can use Breadth-First Search (BFS) to find the shortest path from the starting cell (square 1) to the destination (square n^2). BFS is suitable here because it explores all possible paths level by level, ensuring that the first time we reach the destination, we do so in the minimum number of moves.

Steps:

Understand the Board Representation:

The board is labeled from 1 to n^2, but the indexing on the board is in a 2D matrix format.
We need to convert between the 1D index (like cell numbers) and the 2D board coordinates (r, c).

BFS Initialization:

Start BFS from square 1. Use a queue where each element is a tuple containing the current square and the number of moves taken to reach it.
Use a set to track visited squares to avoid re-processing them.

BFS Exploration:

For each square, simulate rolling a die (moving between 1 to 6 squares forward).
For each resulting square, check if there is a snake or ladder. If there is, move to the square at the end of the snake/ladder.
If we reach the last square (n^2), return the number of moves taken.

Termination:

If BFS completes without reaching n^2, return -1 as it's not possible to reach the end.
"""
class Solution(object):
    def snakesAndLadders(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        from collections import deque

        def get_board_value(board, n, idx):
            r, c = divmod(idx, n)
            if r % 2 == 0:
                return board[n - 1 - r][c]
            else:
                return board[n - 1 - r][n - 1 - c]

        


        n = len(board)
        target = n * n
        
        queue = deque([(1, 0)])  # (current square, number of moves)
        visited = set()
        visited.add(1)
        
        while queue:
            square, moves = queue.popleft()
            
            for i in range(1, 7):
                next_square = square + i
                if next_square > target:
                    continue
                
                r, c = divmod(next_square - 1, n)
                if r % 2 == 0:
                    board_value = board[n - 1 - r][c]
                else:
                    board_value = board[n - 1 - r][n - 1 - c]
                
                if board_value != -1:
                    next_square = board_value
                
                if next_square == target:
                    return moves + 1
                
                if next_square not in visited:
                    visited.add(next_square)
                    queue.append((next_square, moves + 1))
        
        return -1