class Solution(object):
    def minimumCost(self, source, target, original, changed, cost):
        """
        :type source: str
        :type target: str
        :type original: List[str]
        :type changed: List[str]
        :type cost: List[int]
        :rtype: int
        """
        import sys
        INF = sys.maxsize
        
        # Step 1: Initialize the cost matrix for Floyd-Warshall algorithm
        dist = [[INF] * 26 for _ in range(26)]
        
        # Each character can convert to itself with zero cost
        for i in range(26):
            dist[i][i] = 0
        
        # Fill in the initial costs from the given transformation rules
        for i in range(len(original)):
            orig = ord(original[i]) - ord('a')
            chng = ord(changed[i]) - ord('a')
            dist[orig][chng] = min(dist[orig][chng], cost[i])
        
        # Step 2: Run Floyd-Warshall algorithm to find shortest paths
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if dist[i][k] < INF and dist[k][j] < INF:
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        
        # Step 3: Compute the total minimum cost to convert source to target
        total_cost = 0
        n = len(source)
        for i in range(n):
            s_char = ord(source[i]) - ord('a')
            t_char = ord(target[i]) - ord('a')
            if dist[s_char][t_char] == INF:
                return -1
            total_cost += dist[s_char][t_char]
        
        return total_cost
        