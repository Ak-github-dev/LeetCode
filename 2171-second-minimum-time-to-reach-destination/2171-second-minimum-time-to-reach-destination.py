"""
Approach:

Graph Representation:

Represent the graph using an adjacency list since the number of edges is large but not enough to justify a full adjacency matrix (dense graph).

Traffic Light Timing:

Manage the traversal times at each vertex based on the traffic light's state. If you arrive at a vertex and the light is red, you must wait until it turns green to continue.

Modified Dijkstra's Algorithm:

Normally, Dijkstra's algorithm computes the shortest path from a source to all vertices in a graph. Here, we need to consider:
The time due to traffic signals.
We need to find not just the shortest path but the second shortest (the smallest time greater than the minimum).

Tracking Paths:

Use a priority queue to explore paths in order of increasing travel time.
Track two shortest times to each node: the shortest and the second shortest.
When updating paths, consider whether the new path time qualifies as the shortest or the second shortest for that node.

Early Stopping:

If the second shortest time to the destination node is found, that can be returned as the result.
"""

import heapq
from collections import defaultdict, deque
class Solution(object):
    def secondMinimum(self, n, edges, time, change):
        """
        :type n: int
        :type edges: List[List[int]]
        :type time: int
        :type change: int
        :rtype: int
        """
        graph = defaultdict(list)
    
        # Build the graph
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # Priority queue: (current_time, vertex)
        pq = [(0, 1)]
        # Distances array
        dist = defaultdict(lambda: [float('inf'), float('inf')])  # Keep two smallest times
        
        while pq:
            cur_time, node = heapq.heappop(pq)
            
            # Process the current node for the second minimum time
            if node == n and cur_time > dist[node][0]:
                return cur_time
            
            # Iterate over all adjacent nodes
            for neighbor in graph[node]:
                new_time = cur_time + time
                # Determine if waiting at the light is necessary
                if (cur_time // change) % 2 == 1:  # If light is red
                    new_time = ((cur_time // change) + 1) * change + time
                
                if new_time < dist[neighbor][0]:
                    dist[neighbor][1] = dist[neighbor][0]  # Update second smallest
                    dist[neighbor][0] = new_time  # Update smallest
                    heapq.heappush(pq, (new_time, neighbor))
                elif dist[neighbor][0] < new_time < dist[neighbor][1]:
                    dist[neighbor][1] = new_time
                    heapq.heappush(pq, (new_time, neighbor))