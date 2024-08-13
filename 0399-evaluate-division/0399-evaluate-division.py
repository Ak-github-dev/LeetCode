"""
Approach:

Graph Representation:

We can represent the equations as a directed graph where each variable is a node.
For each equation A / B = value, we create a directed edge from A to B with a weight equal to value, and a reverse edge from B to A with a weight equal to 1 / value.

Breadth-First Search (BFS) or Depth-First Search (DFS):

For each query C / D, we can perform a BFS or DFS starting from C to find the path to D. The product of the edge weights along the path will give us the value of C / D.
If there's no path between C and D, it means the division result is undefined, and we should return -1.0 for that query.

Handling Special Cases:

If C or D is not in the graph, return -1.0.
If C is equal to D, the result should be 1.0 (since any number divided by itself is 1).
"""
from collections import defaultdict, deque
class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        # Step 1: Build the graph
        graph = defaultdict(dict)
        for (A, B), value in zip(equations, values):
            graph[A][B] = value
            graph[B][A] = 1.0 / value
        
        # Step 2: Process each query using BFS
        def bfs(src, dst):
            if src not in graph or dst not in graph:
                return -1.0
            if src == dst:
                return 1.0
            
            queue = deque([(src, 1.0)])
            visited = set([src])
            
            while queue:
                node, curr_product = queue.popleft()
                if node == dst:
                    return curr_product
                for neighbor, value in graph[node].items():
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append((neighbor, curr_product * value))
            return -1.0
        
        # Step 3: Answer all queries
        results = []
        for C, D in queries:
            results.append(bfs(C, D))
        
        return results