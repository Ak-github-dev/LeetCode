class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort the robot positions and factory positions
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        int robotCount = robot.size();
        int factoryCount = factory.length;
        
        // Initialize dp array to store results
        long[][] dp = new long[robotCount + 1][factoryCount + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        
        // DP calculation
        for (int j = 1; j <= factoryCount; j++) {
            dp[0][j] = 0; // No robots need zero distance
            
            // Process each robot with respect to the factory limit
            for (int i = 1; i <= robotCount; i++) {
                dp[i][j] = dp[i][j - 1]; // Case when this factory is skipped
                
                long distanceSum = 0;
                for (int k = 1; k <= factory[j - 1][1] && i - k >= 0; k++) {
                    // Calculate distance for k robots
                    distanceSum += Math.abs(factory[j - 1][0] - robot.get(i - k));
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distanceSum);
                    }
                }
            }
        }
        
        // Return the minimum total distance to repair all robots
        return dp[robotCount][factoryCount];
    }
}