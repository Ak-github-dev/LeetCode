class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Directions for moving in the grid: up, down, left, right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0}); // Starting point

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check bounds
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        // Add to front or back of deque based on obstacle presence
                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny});
                        } else {
                            deque.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}