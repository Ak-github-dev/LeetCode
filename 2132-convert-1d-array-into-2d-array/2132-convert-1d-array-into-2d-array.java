/*
Approach:
Check the Size:

First, check if the size of the original array equals m * n. If not, return an empty array.
Create the 2D Array:

If the size matches, create a 2D array of dimensions m x n.
Populate this 2D array by iterating through the original array.
*/
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total elements match
        if (original.length != m * n) {
            return new int[0][0];
        }
        
        // Initialize the 2D array
        int[][] result = new int[m][n];
        
        // Fill the 2D array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }
        
        return result;
    }
}