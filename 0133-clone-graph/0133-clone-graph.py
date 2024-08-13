"""
Approach:

Using a HashMap:

We'll use a hash map (visited) to keep track of the nodes we've already cloned. The keys will be the original nodes, and the values will be the corresponding cloned nodes.
This map will help in avoiding cycles and ensure that each node is cloned exactly once.

DFS or BFS:

We can use either Depth-First Search (DFS) or Breadth-First Search (BFS) to traverse the graph. Both approaches will help us explore all nodes and their neighbors while cloning the structure.
For each node, we check if it's already cloned. If not, we clone it, then recursively clone its neighbors.

Edge Cases:

If the input graph is empty (i.e., the input node is None), we simply return None.
"""
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None
        
        # Hash map to store cloned nodes
        visited = {}
        
        def dfs(node):
            # If node is already cloned, return the clone
            if node in visited:
                return visited[node]
            
            # Clone the node
            clone = Node(node.val)
            visited[node] = clone
            
            # Clone the neighbors
            for neighbor in node.neighbors:
                clone.neighbors.append(dfs(neighbor))
            
            return clone
        
        return dfs(node)