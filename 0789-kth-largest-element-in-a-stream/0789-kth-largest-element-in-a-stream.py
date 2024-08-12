"""
Approach:

Min-Heap:

A min-heap is a binary tree where the parent node is smaller than or equal to its child nodes. This property allows us to efficiently keep track of the smallest element in the heap, which will be the kth largest element in our case.

Initialization:

Initialize the heap with the first k elements of the stream. If the initial stream has more than k elements, process the rest by comparing each element with the smallest element in the heap:
If the new element is larger than the smallest element in the heap, replace the smallest element with the new one and re-adjust the heap.

Adding New Elements:

When a new element is added to the stream:
If the heap has fewer than k elements, simply add the new element.
If the heap already has k elements, compare the new element with the smallest element in the heap:
If the new element is larger, replace the smallest element with the new one.
The root of the heap will always be the kth largest element.
"""
class KthLargest(object):

    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        self.k = k
        self.min_heap = nums
        heapq.heapify(self.min_heap)  # Convert nums into a min-heap
        
        # If there are more than k elements, reduce the size to k
        while len(self.min_heap) > k:
            heapq.heappop(self.min_heap)
        

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        # Add the new value to the heap
        heapq.heappush(self.min_heap, val)
        
        # If heap size exceeds k, remove the smallest element
        if len(self.min_heap) > self.k:
            heapq.heappop(self.min_heap)
        
        # The root of the heap is the kth largest element
        return self.min_heap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)