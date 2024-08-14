"""
Approach Using Binary Search:

The idea is to use binary search on the possible distances to efficiently find the k-th smallest one.

Sorting:

Sort the nums array. This allows us to efficiently count pairs with a distance less than or equal to a target using a two-pointer technique.

Binary Search:

Perform binary search on the possible range of distances (from 0 to max(nums) - min(nums)).
For each middle distance mid in the binary search, count how many pairs have a distance less than or equal to mid.

Counting Pairs:

Use two pointers to count how many pairs have a distance less than or equal to mid. This is possible because the array is sorted.

Narrowing Down:

If the count is greater than or equal to k, then the k-th smallest distance must be less than or equal to mid. Otherwise, it must be greater than mid.
"""
class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        def count_pairs(nums, mid):
            count = 0
            left = 0
            for right in range(len(nums)):
                while nums[right] - nums[left] > mid:
                    left += 1
                count += right - left
            return count



        nums.sort()
    
        low, high = 0, nums[-1] - nums[0]
        
        while low < high:
            mid = (low + high) // 2
            if count_pairs(nums, mid) >= k:
                high = mid
            else:
                low = mid + 1
        
        return low