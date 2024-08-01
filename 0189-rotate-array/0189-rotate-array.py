"""
Steps:
Normalize k: If k is greater than the length of the array n, compute k % n. This is because rotating by the array's length results in the same array.
Reverse the Entire Array: Reverse all elements of the array.
Reverse the First k Elements: Reverse the first k elements.
Reverse the Remaining Elements: Reverse the elements from k to the end of the array
"""
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n  # Normalize k to ensure it is within the bounds of the array length
        
        def reverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        
        # Step 1: Reverse the entire array
        reverse(0, n - 1)
        
        # Step 2: Reverse the first k elements
        reverse(0, k - 1)
        
        # Step 3: Reverse the remaining elements
        reverse(k, n - 1)