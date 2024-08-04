"""
Detailed Implementation:

Compute Subarray Sums:

Use nested loops to generate all subarray sums.
Sort the Sums:

Sort the generated subarray sums.
Sum the Range:

Extract the required range and compute the sum, using modulo 10**9+7 to handle large numbers.
"""
class Solution(object):
    def rangeSum(self, nums, n, left, right):
        """
        :type nums: List[int]
        :type n: int
        :type left: int
        :type right: int
        :rtype: int
        """
        mod = 10**9 + 7
        subarray_sums = []
        
        # Generate all subarray sums
        for start in range(n):
            current_sum = 0
            for end in range(start, n):
                current_sum += nums[end]
                subarray_sums.append(current_sum)
        
        # Sort the subarray sums
        subarray_sums.sort()
        
        # Sum the elements from the sorted list in the range [left, right]
        result = sum(subarray_sums[left-1:right]) % mod
        
        return result