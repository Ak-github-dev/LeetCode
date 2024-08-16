"""
consider two cases:

Maximum Subarray Sum in the Non-Circular Array: This is the classic problem solved by Kadane's algorithm, where we find the maximum sum of a contiguous subarray in a linear array.

Maximum Subarray Sum in the Circular Array: This involves considering the possibility that the subarray might wrap around the end of the array and start again from the beginning. To find this, we can use the total sum of the array and subtract the sum of the minimum subarray (which we can also find using Kadane's algorithm, but with inverted signs).

Key Points:
If the maximum subarray sum in the circular case is equal to the total sum of the array, it means all elements are part of the subarray (all elements are positive). However, if the array contains only negative numbers, the maximum sum should not consider the circular sum, as it would result in the empty subarray (which isn't allowed). Therefore, in such cases, the result should be the maximum element.

The solution is to return the maximum of the two cases (linear and circular).
"""
class Solution(object):
    def maxSubarraySumCircular(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def kadane(nums):
            max_ending_here = max_so_far = nums[0]
            for x in nums[1:]:
                max_ending_here = max(x, max_ending_here + x)
                max_so_far = max(max_so_far, max_ending_here)
            return max_so_far
        
        # Case 1: Maximum subarray sum without considering wrap-around
        max_kadane = kadane(nums)
        
        # Case 2: Maximum subarray sum considering wrap-around
        total_sum = sum(nums)
        # Inverting the numbers to find the minimum subarray sum
        min_kadane = kadane([-x for x in nums])
        max_wrap = total_sum + min_kadane  # total_sum - (-min subarray sum)
        
        # Handling the edge case where all elements are negative
        if max_wrap == 0:
            return max_kadane
        
        return max(max_kadane, max_wrap)