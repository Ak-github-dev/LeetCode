"""
Approach:
The key idea is to perform a binary search on the sorted array. If the target is found, return its index. If the target is not found, the binary search will determine the appropriate position where the target should be inserted to maintain the array's sorted order.

Steps:
Initialize:

Start with two pointers: left at the beginning of the array and right at the end of the array.
Binary Search:

Calculate the middle index mid as (left + right) // 2.
Compare the middle element nums[mid] with the target:
If nums[mid] equals the target, return mid.
If nums[mid] is less than the target, move the left pointer to mid + 1.
If nums[mid] is greater than the target, move the right pointer to mid - 1.
Insertion Point:

If the loop exits without finding the target, left will be pointing to the correct insertion index for the target.
"""
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums) - 1
    
        while left <= right:
            mid = (left + right) // 2
            
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return left