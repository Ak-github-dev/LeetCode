"""
Steps:
Calculate Total 1's:

Compute the total number of 1's in the array.
Initial Window Setup:

Start with the first window of size total_ones and count the number of 0's in it.
Sliding the Window:

Slide the window one position to the right at a time, adjusting the count of 0's by removing the element that goes out of the window and adding the new element that enters the window.
Use modular arithmetic to handle the circular nature of the array.
Track Minimum Swaps:

Keep track of the minimum number of 0's encountered in any window, which corresponds to the minimum number of swaps needed.
"""
class Solution(object):
    def minSwaps(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total_ones = sum(nums)
        n = len(nums)
        
        if total_ones == 0:
            return 0
        
        current_zeros = 0
        
        # Initial window of size total_ones
        for i in range(total_ones):
            if nums[i] == 0:
                current_zeros += 1
                
        min_swaps = current_zeros
        
        # Sliding the window
        for i in range(1, n):
            if nums[i - 1] == 0:
                current_zeros -= 1
            if nums[(i + total_ones - 1) % n] == 0:
                current_zeros += 1
            
            min_swaps = min(min_swaps, current_zeros)
        
        return min_swaps