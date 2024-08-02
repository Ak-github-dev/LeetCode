"""
Approach:

Graph Representation:

Use an adjacency list to represent the graph.
Use an array to keep track of the in-degrees (number of incoming edges) of each vertex.

Topological Sorting using Kahn's Algorithm:

Initialize a queue with all vertices that have an in-degree of 0.

    Process each vertex by:
        Adding it to the topological order.
        Decreasing the in-degree of its neighbors by 1.
        Adding neighbors with an in-degree of 0 to the queue.

If all vertices are processed and added to the topological order, return the order.
If not all vertices are processed, it indicates a cycle, and thus, return an empty array.
"""
from collections import deque, defaultdict
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        # Create an adjacency list and in-degree array
        adj_list = defaultdict(list)
        in_degree = [0] * numCourses
        
        # Populate the adjacency list and in-degree array
        for dest, src in prerequisites:
            adj_list[src].append(dest)
            in_degree[dest] += 1
        
        # Initialize the queue with all nodes having in-degree 0
        queue = deque([i for i in range(numCourses) if in_degree[i] == 0])
        topological_order = []
        
        while queue:
            node = queue.popleft()
            topological_order.append(node)
            
            # Decrease the in-degree of all neighbors
            for neighbor in adj_list[node]:
                in_degree[neighbor] -= 1
                # If in-degree becomes 0, add it to the queue
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)
        
        # Check if topological sort is possible
        if len(topological_order) == numCourses:
            return topological_order
        else:
            return []
            