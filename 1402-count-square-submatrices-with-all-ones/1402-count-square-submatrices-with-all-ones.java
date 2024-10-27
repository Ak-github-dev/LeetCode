/*
Approach:

Initialize a DP table: Let dp[i][j] represent the size of the largest square submatrix with all ones ending at cell (i, j).

Transition:
If matrix[i][j] is 1, then dp[i][j] will be the minimum of dp[i-1][j], dp[i][j-1], and dp[i-1][j-1] plus 1.
This is because to form a square ending at (i, j), we need the cells to the left, above, and diagonally top-left to also form squares of size dp[i][j] - 1.

Count squares:
Sum up all values in dp to get the total number of square submatrices with all ones.

Result: The result is the sum of all values in the dp table.
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // Edge cells can only form 1x1 squares.
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    count += dp[i][j]; // Add the count of squares ending at (i, j).
                }
            }
        }
        return count;
    }
}