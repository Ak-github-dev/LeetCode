"""
Approach:
Sliding Window Technique:
Use two pointers to create a window that slides over the array.
Maintain a running sum of the elements within the window.
Adjust the window size by moving the left pointer to minimize the length while ensuring the sum is greater than or equal to the target.


Steps:

Initialize Pointers and Variables:

left: The start of the sliding window.
current_sum: The sum of the elements within the window.
min_length: Initialize to a large value to keep track of the minimal length of the subarray.

Expand and Contract the Window:

Expand the window by moving the right pointer and adding the current element to current_sum.
Once current_sum is greater than or equal to the target, try to contract the window by moving the left pointer to find the minimal length subarray.
"""
class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        current_sum = 0
        min_length = float('inf')
        
        for right in range(len(nums)):
            current_sum += nums[right]
            
            while current_sum >= target:
                min_length = min(min_length, right - left + 1)
                current_sum -= nums[left]
                left += 1
                
        return min_length if min_length != float('inf') else 0