class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize inDegree array
        int[] inDegree = new int[n];
        
        // Step 2: Populate inDegree from edges
        for (int[] edge : edges) {
            int stronger = edge[0];
            int weaker = edge[1];
            inDegree[weaker]++;
        }
        
        // Step 3: Identify the champion
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) { // Potential champion
                if (champion != -1) {
                    return -1; // More than one champion candidate
                }
                champion = i;
            }
        }
        
        // If no champion is found, return -1
        return champion;
    }
}