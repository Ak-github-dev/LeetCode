"""
Steps:

Check if the Grid is Already Disconnected:

If the grid is already disconnected (i.e., there are multiple islands or no island at all), the result is 0 because no further actions are required.

Simulate Turning One Land Cell to Water:

Iterate through all the cells in the grid. For each land cell (value 1), temporarily change it to water (value 0) and then check if the grid becomes disconnected.

Simulate Turning Two Land Cells to Water:

If turning just one cell to water doesn't disconnect the grid, then try turning two different land cells into water. For each pair of cells, change them to water and check if the grid becomes disconnected.

Return the Minimum Number of Days:

The minimum number of days will be either 0, 1, or 2 based on the above checks.
"""
class Solution(object):
    def minDays(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def is_connected(grid):
            """ Check if the grid is connected or disconnected """
            def dfs(i, j):
                if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0:
                    return
                grid[i][j] = 0
                for x, y in [(0,1), (1,0), (0,-1), (-1,0)]:
                    dfs(i+x, j+y)
            
            # Find the first land cell and start DFS from there
            first_land = False
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1:
                        dfs(i, j)
                        first_land = True
                        break
                if first_land:
                    break
            
            # If there's another land cell after the first DFS, the grid is disconnected
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1:
                        return False
            
            return True

        def count_islands():
            """ Count the number of islands in the grid """
            copy_grid = [row[:] for row in grid]
            num_islands = 0
            for i in range(m):
                for j in range(n):
                    if copy_grid[i][j] == 1:
                        dfs(i, j, copy_grid)
                        num_islands += 1
            return num_islands

        def dfs(i, j, grid):
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0:
                return
            grid[i][j] = 0
            for x, y in [(0,1), (1,0), (0,-1), (-1,0)]:
                dfs(i+x, j+y, grid)
        
        m, n = len(grid), len(grid[0])

        # Case 1: Check if the grid is already disconnected
        if count_islands() != 1:
            return 0
        
        # Case 2: Check if removing one land cell disconnects the grid
        for i, j in product(range(m), range(n)):
            if grid[i][j] == 1:
                grid[i][j] = 0
                if count_islands() != 1:
                    return 1
                grid[i][j] = 1
        
        # Case 3: If the grid is still connected, return 2 as it takes two moves
        return 2
            