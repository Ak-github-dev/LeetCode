"""
Steps:
Build the Graph:

Use an adjacency list to represent the graph.
For each pair [a, b] in prerequisites, add an edge from b to a.
Cycle Detection using DFS:

Use a visitation state array to track the state of each node:
0: Node has not been visited.
1: Node is being visited (currently in the recursion stack).
2: Node and its descendants are fully visited.
If you encounter a node that is being visited again (1), it means there is a cycle.
"""
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # Build the graph
        graph = [[] for _ in range(numCourses)]
        for dest, src in prerequisites:
            graph[src].append(dest)
        
        # Visitation state: 0 = unvisited, 1 = visiting, 2 = visited
        visit = [0] * numCourses
        
        def hasCycle(v):
            if visit[v] == 1:
                return True
            if visit[v] == 2:
                return False
            
            visit[v] = 1
            for neighbor in graph[v]:
                if hasCycle(neighbor):
                    return True
            
            visit[v] = 2
            return False
        
        for i in range(numCourses):
            if visit[i] == 0:
                if hasCycle(i):
                    return False
        
        return True