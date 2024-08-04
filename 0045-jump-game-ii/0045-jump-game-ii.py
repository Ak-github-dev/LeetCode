"""
Steps:

Initialize Variables:

jumps to keep track of the number of jumps.
current_end to mark the end of the current jump range.
next_end to mark the furthest point that can be reached with the next jump.

Iterate Through the Array:

For each index i, update next_end to be the maximum of next_end and i + nums[i].
If i reaches current_end, increment the jumps and update current_end to next_end.
If current_end is greater than or equal to the last index, return jumps.
"""
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        
        jumps = 0
        current_end = 0
        next_end = 0
        
        for i in range(len(nums) - 1):
            next_end = max(next_end, i + nums[i])
            
            if i == current_end:
                jumps += 1
                current_end = next_end
                
                if current_end >= len(nums) - 1:
                    break
        
        return jumps
