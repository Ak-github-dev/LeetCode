class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Step 1: Initialize the graph using adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1}); // Edge from i to i+1 with weight 1
        }

        // Result array
        int[] result = new int[queries.length];

        // Step 2: Process each query
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            // Add the new edge to the graph
            graph.get(u).add(new int[]{v, 1});

            // Step 3: Use Dijkstra's algorithm to find the shortest path
            result[q] = dijkstra(n, graph);
        }

        return result;
    }

    private int dijkstra(int n, List<List<int[]>> graph) {
        // Priority queue for Dijkstra's algorithm (min-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0, 0}); // {node, distance}

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            // If the distance is outdated, skip
            if (currentDist > dist[node]) continue;

            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // Return the shortest path to city n-1
        return dist[n - 1];
    }
}