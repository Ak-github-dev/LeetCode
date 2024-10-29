class Solution {
    public int maxMoves(int[][] grid) {
        // Get dimensions of the grid
        int m = grid.length;    // number of rows
        int n = grid[0].length; // number of columns
        
        // Result variable to store the maximum number of columns we can reach
        int res = 0;
        
        // dp array stores the maximum number of moves possible to reach each cell
        // in the current column we're processing
        int[] dp = new int[m];
        
        // Iterate through each column from left to right, starting from column 1
        for (int j = 1; j < n; j++) {
            // leftTop keeps track of the dp value from the cell above-left
            int leftTop = 0;
            // found indicates if we can reach any cell in the current column
            boolean found = false;
            
            // Iterate through each row in the current column
            for (int i = 0; i < m; i++) {
                // cur will store the maximum moves to reach the current cell
                int cur = -1; // Default value of -1 indicates unreachable
                // Store dp[i] to update leftTop for the next row
                int nxtLeftTop = dp[i];
                
                // Check move from top-left cell if valid
                if (i - 1 >= 0 && leftTop != -1 && grid[i][j] > grid[i - 1][j - 1]) {
                    cur = Math.max(cur, leftTop + 1);
                }
                
                // Check move from direct left cell if valid
                if (dp[i] != -1 && grid[i][j] > grid[i][j - 1]) {
                    cur = Math.max(cur, dp[i] + 1);
                }
                
                // Check move from bottom-left cell if valid
                if (i + 1 < m && dp[i + 1] != -1 && grid[i][j] > grid[i + 1][j - 1]) {
                    cur = Math.max(cur, dp[i + 1] + 1);
                }
                
                // Update dp array for the current cell
                dp[i] = cur;
                // Set found to true if we can reach the current cell
                found = found || (dp[i] != -1);
                // Update leftTop for the next row
                leftTop = nxtLeftTop;
            }
            
            // If no cell in the current column is reachable, stop further processing
            if (!found) break;
            // Update result to the current column number
            res = j;
        }
        
        // Return the maximum number of moves possible (max columns reached)
        return res;
    }
}