"""
Steps:

Iterate through the grid: Since we are looking for 3x3 subgrids, we need to check every possible 3x3 subgrid within the larger grid.

Check for Magic Square:

Verify if the 3x3 subgrid contains all numbers from 1 to 9.
Check if all rows, columns, and diagonals have the same sum.

Count Valid Magic Squares: Count the number of valid 3x3 subgrids that meet the criteria.
"""
"""
Center Element: In a 3x3 magic square containing numbers from 1 to 9, the center element must be 5.
Sum Check: The sum of each row, column, and both diagonals must be 15.
Unique Elements: The square must contain all numbers from 1 to 9 without repetition
"""
class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def is_magic(i, j):
            # Check the center of the 3x3 grid
            if grid[i+1][j+1] != 5:
                return False
            
            # Extract the 3x3 grid
            s = set([grid[i][j], grid[i][j+1], grid[i][j+2],
                    grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2],
                    grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2]])
            
            # Check if the grid contains exactly the numbers 1 to 9
            if s != {1, 2, 3, 4, 5, 6, 7, 8, 9}:
                return False
            
            # Check rows, columns, and diagonals sum to 15
            if (grid[i][j] + grid[i][j+1] + grid[i][j+2] != 15 or
                grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] != 15 or
                grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] != 15 or
                grid[i][j] + grid[i+1][j] + grid[i+2][j] != 15 or
                grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] != 15 or
                grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] != 15 or
                grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] != 15 or
                grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] != 15):
                return False
            
            return True

        rows = len(grid)
        cols = len(grid[0])
        count = 0
        
        # Traverse all possible 3x3 subgrids
        for i in range(rows - 2):
            for j in range(cols - 2):
                if is_magic(i, j):
                    count += 1
                    
        return count