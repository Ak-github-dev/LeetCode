"""
Steps:
Iterate Through the Grid:

Traverse each cell in the grid.
Whenever you encounter a '1', it signifies the start of a new island.
DFS/BFS to Mark the Island:

Use DFS or BFS to visit all the cells connected to the current '1' (marking them as visited by setting them to '0').
Count the Islands:

Keep a count of how many times you initiate a DFS/BFS from an unvisited '1'.
"""
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        
        def dfs(grid, i, j):
            # If out of bounds or at a cell that is water ('0'), stop the DFS
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
                return
            
            # Mark the cell as visited
            grid[i][j] = '0'
            
            # Continue the DFS in all four directions
            dfs(grid, i - 1, j)  # Up
            dfs(grid, i + 1, j)  # Down
            dfs(grid, i, j - 1)  # Left
            dfs(grid, i, j + 1)  # Right
        
        num_islands = 0
        
        # Traverse the grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    num_islands += 1
                    dfs(grid, i, j)
        
        return num_islands