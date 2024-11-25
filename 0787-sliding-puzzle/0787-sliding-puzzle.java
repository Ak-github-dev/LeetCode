class Solution {
    public int slidingPuzzle(int[][] board) {
        // Convert the board to a string representation
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        String target = "123450";

        // Define the valid moves for each position of '0'
        int[][] neighbors = {
            {1, 3},       // Neighbors of position 0
            {0, 2, 4},    // Neighbors of position 1
            {1, 5},       // Neighbors of position 2
            {0, 4},       // Neighbors of position 3
            {1, 3, 5},    // Neighbors of position 4
            {2, 4}        // Neighbors of position 5
        };

        // BFS initialization
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start.toString());
        visited.add(start.toString());

        int moves = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Check if we've reached the target state
                if (current.equals(target)) {
                    return moves;
                }

                // Find the position of '0'
                int zeroIndex = current.indexOf('0');

                // Try moving '0' to all valid neighbor positions
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        // If we exhaust the queue without finding the target
        return -1;
    }

    // Helper function to swap characters in a string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}