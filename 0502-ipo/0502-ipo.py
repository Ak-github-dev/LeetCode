"""
Approach:

Initial Preparation:

Pair the profits and capital values together and sort them by the capital values. This sorting helps in efficiently finding projects that can be started given the current capital.

Use a Max-Heap:

Use a max-heap to keep track of the most profitable projects that can be started with the current capital.
The max-heap is necessary because, at each step, we want to select the project with the maximum profit that we can afford.

Iterative Selection:

Start with the initial capital w and iterate up to k times.
For each iteration:
Push all projects into the max-heap that can be started with the current capital.
If the heap is not empty, pop the project with the maximum profit and add its profit to the current capital.
If the heap is empty, break out of the loop early because no more projects can be started.

Result:

The final capital after at most k projects is the answer.
"""
import heapq
class Solution(object):
    def findMaximizedCapital(self, k, w, profits, capital):
        """
        :type k: int
        :type w: int
        :type profits: List[int]
        :type capital: List[int]
        :rtype: int
        """
        # Pair up capital and profits and sort by capital
        projects = sorted(zip(capital, profits))
        
        max_heap = []
        i = 0
        
        for _ in range(k):
            # Push all projects we can start with the current capital into the max-heap
            while i < len(projects) and projects[i][0] <= w:
                heapq.heappush(max_heap, -projects[i][1])  # Push profit as a negative to simulate max-heap
                i += 1
            
            # If no project can be started, break out of the loop
            if not max_heap:
                break
            
            # Pop the most profitable project
            w += -heapq.heappop(max_heap)
        
        return w