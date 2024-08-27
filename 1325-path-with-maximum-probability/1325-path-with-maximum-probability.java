/*
Approach:

Graph Representation:

Represent the graph using an adjacency list where each node points to a list of pairs (neighbor, probability).

Modified Dijkstra's Algorithm:

Use a priority queue (max-heap) to always expand the node with the highest probability first.
Initialize a probability array where probability[i] keeps track of the highest probability to reach node i.
Start with the start node and initialize its probability to 1 (since the probability of being at the start node is 1).
For each node, update the probability of reaching its neighbors by multiplying the current node's probability with the edge probability.
If a higher probability path to a neighbor is found, update the neighbor's probability and push it into the priority queue.

Termination:

The algorithm terminates when you reach the end node with the maximum probability, or when the queue is empty (indicating that no path exists).
*/
import java.util.*;
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair<>(v, prob));
            graph.get(v).add(new Pair<>(u, prob));
        }

        // Max heap priority queue (using a comparator to prioritize higher probabilities)
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        double[] probabilities = new double[n];
        probabilities[start_node] = 1.0;
        pq.offer(new Pair<>(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair<Integer, Double> current = pq.poll();
            int node = current.getKey();
            double currentProb = current.getValue();

            if (node == end_node) {
                return currentProb;
            }

            for (Pair<Integer, Double> neighbor : graph.get(node)) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = currentProb * edgeProb;

                if (newProb > probabilities[nextNode]) {
                    probabilities[nextNode] = newProb;
                    pq.offer(new Pair<>(nextNode, newProb));
                }
            }
        }

        return 0.0;
    }

    // Pair class to hold node and probability pairs
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}