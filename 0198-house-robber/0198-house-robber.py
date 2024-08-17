"""
Problem Breakdown:

Decision Making:

For each house i, you have two choices:
Rob the house: If you rob house i, you cannot rob house i-1, so the maximum amount you can rob up to house i is the amount in house i plus the maximum amount you could rob up to house i-2.
Skip the house: If you skip house i, the maximum amount you can rob up to house i is the same as the maximum amount you could rob up to house i-1.

State Definition:

Let dp[i] be the maximum amount of money you can rob from the first i houses.
The transition formula is:dp[i]=max(dp[i−1],dp[i−2]+nums[i])
Here, dp[i-1] represents the scenario where you skip house i, and dp[i-2] + nums[i] represents the scenario where you rob house i.

Base Cases:

dp[0] = nums[0]: If there's only one house, rob it.
dp[1] = \max(nums[0], nums[1]): If there are two houses, rob the one with the most money.
"""
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        
        return dp[-1]