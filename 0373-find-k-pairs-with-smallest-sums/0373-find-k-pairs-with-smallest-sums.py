"""
Key Insights:
Initial Pairing:

Since both nums1 and nums2 are sorted, the smallest possible sum pair is (nums1[0], nums2[0]).
The next smallest pair will either include nums1[0] with nums2[1], or nums1[1] with nums2[0].
Using a Min-Heap:

We can use a min-heap to always extract the smallest sum pair.
We initialize the heap with pairs combining nums1[0] with every element in nums2 (up to k elements, as there's no need to add more pairs initially than k).
For each extracted pair (i, j), we push the next potential pair (i+1, j) if it hasn’t been considered yet.
Efficiency:

This approach ensures that we efficiently find the k smallest pairs without generating all possible pairs, which would be infeasible given the constraints.
"""
import heapq
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        if not nums1 or not nums2:
            return []
        
        min_heap = []
        result = []

        # Initialize the heap with the smallest possible pairs
        for i in range(min(k, len(nums1))):
            heapq.heappush(min_heap, (nums1[i] + nums2[0], i, 0))
        
        # Extract the smallest pairs from the heap
        while k > 0 and min_heap:
            sum_val, i, j = heapq.heappop(min_heap)
            result.append([nums1[i], nums2[j]])
            
            # If there is a next pair in the row, add it to the heap
            if j + 1 < len(nums2):
                heapq.heappush(min_heap, (nums1[i] + nums2[j + 1], i, j + 1))
            
            k -= 1
        
        return result