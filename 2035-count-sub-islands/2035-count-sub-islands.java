/*
Approach:

Depth-First Search (DFS):

Use DFS to explore each island in grid2.
For each island in grid2, check if it is a sub-island by comparing it with the corresponding cells in grid1.

Key Steps:

Traverse through each cell in grid2. When you find a 1, initiate a DFS to explore the entire island.
During the DFS, check if all corresponding cells in grid1 are also 1. If any cell in grid1 is 0 while the corresponding cell in grid2 is 1, then this island is not a sub-island.
If the DFS confirms that the island in grid2 is a sub-island, increase the sub-island count.

Marking Visited Cells:

During the DFS, mark visited cells in grid2 to avoid counting the same island multiple times.
*/
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int subIslandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // Perform DFS and check if the island in grid2 is a sub-island
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }
        
        return subIslandCount;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        // If out of bounds or water, return true
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }
        
        // Mark the current cell as visited in grid2
        grid2[i][j] = 0;
        
        // Assume the current island in grid2 is a sub-island
        boolean isSubIsland = true;
        
        // If grid1 does not have land where grid2 has land, it is not a sub-island
        if (grid1[i][j] == 0) {
            isSubIsland = false;
        }
        
        // Continue DFS in all four directions
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        
        // Combine the results from all directions
        return isSubIsland && up && down && left && right;
    }
}