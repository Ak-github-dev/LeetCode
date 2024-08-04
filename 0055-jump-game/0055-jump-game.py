"""
Steps:

Initialize a Variable: Start with a variable max_reachable set to 0, which keeps track of the furthest index that can be reached.

Iterate Through the Array: For each index i in the array, check if i is within the range of the max_reachable.
If i is within the reachable range, update max_reachable to be the maximum of max_reachable and i + nums[i] (the furthest index that can be reached from i).
If i exceeds max_reachable, return false.

Check the End Condition: If you finish the iteration and max_reachable is at least the last index of the array, return true.
"""
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        max_reachable = 0
        for i in range(len(nums)):
            if i > max_reachable:
                return False
            max_reachable = max(max_reachable, i + nums[i])
        return max_reachable >= len(nums) - 1