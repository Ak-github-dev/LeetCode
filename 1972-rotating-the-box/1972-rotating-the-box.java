class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // number of rows
        int n = box[0].length; // number of columns
        
        // Step 1: Simulate the falling stones for each row
        for (int i = 0; i < m; i++) {
            int emptySpot = n - 1; // Start from the rightmost position
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // Move the stone to the lowest available spot
                    box[i][j] = '.';
                    box[i][emptySpot--] = '#';
                } else if (box[i][j] == '*') {
                    // Update emptySpot to one position left of the obstacle
                    emptySpot = j - 1;
                }
            }
        }
        
        // Step 2: Rotate the box 90 degrees clockwise
        char[][] rotatedBox = new char[n][m]; // Resulting box after rotation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotatedBox;
    }
}