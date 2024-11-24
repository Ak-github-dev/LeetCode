class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; // Sum of absolute values
        int negativeCount = 0; // Count of negative elements
        int smallestAbsoluteValue = Integer.MAX_VALUE; // Smallest absolute value in the matrix

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add the absolute value
                if (value < 0) {
                    negativeCount++; // Count negatives
                }
                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, Math.abs(value));
            }
        }

        // If odd number of negatives, reduce by twice the smallest absolute value
        if (negativeCount % 2 == 1) {
            totalSum -= 2L * smallestAbsoluteValue;
        }

        return totalSum;
    }
}