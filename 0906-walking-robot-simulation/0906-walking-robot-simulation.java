/*
Approach:

Dynamic Programming with Memoization:

Use a 2D DP array dp[i][M] where i is the index of the pile from which the player can start picking stones and M is the maximum number of piles the player can take.
The value of dp[i][M] will represent the maximum number of stones the current player can get if they start from pile i with the maximum M.

Recursive Transition:

For each index i and M, consider taking X piles (where 1 <= X <= 2M), and calculate the number of stones the current player can collect.
Then, recursively calculate the result for the opponent starting from pile i + X with a new M = max(M, X).
The current player wants to maximize their stones, so we keep track of the maximum value possible.

Memoization:

Store the results of subproblems in the DP array to avoid recomputation.
*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;  // Starting position
        int direction = 0;  // Initially facing north (index 0 in the directions array)
        int maxDistance = 0;
        
        // Store obstacles in a set for fast lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process commands
        for (int command : commands) {
            if (command == -2) {
                // Turn left: counter-clockwise turn
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                // Turn right: clockwise turn
                direction = (direction + 1) % 4;
            } else {
                // Move forward 'command' steps
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[direction][0];
                    int newY = y + directions[direction][1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        // Stop if obstacle is encountered
                        break;
                    }
                }
            }
        }

        return maxDistance;
    }
}