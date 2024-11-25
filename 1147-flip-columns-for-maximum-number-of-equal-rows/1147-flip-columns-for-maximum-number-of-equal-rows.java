class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // Map to store patterns and their frequencies
        Map<String, Integer> patFreq = new HashMap<>();
        
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        return Collections.max(patFreq.values());
    }
}