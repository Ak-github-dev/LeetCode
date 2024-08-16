"""
Key Idea:
The array can be divided into two parts: one of these parts is always sorted. By determining which part is sorted, we can decide whether to continue searching in that part or the other.

Approach:
Binary Search with Rotation Check:
Start by initializing two pointers, left and right, at the start and end of the array.
Calculate the middle index mid.
Check if the mid element is equal to the target. If it is, return mid.
Determine which part of the array is sorted:
If the left part (nums[left] to nums[mid]) is sorted:
Check if the target lies within this range. If it does, continue searching in the left part by moving the right pointer to mid - 1.
Otherwise, search in the right part by moving the left pointer to mid + 1.
If the right part (nums[mid] to nums[right]) is sorted:
Check if the target lies within this range. If it does, continue searching in the right part by moving the left pointer to mid + 1.
Otherwise, search in the left part by moving the right pointer to mid - 1.
If the loop completes without finding the target, return -1.
"""
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums) - 1
    
        while left <= right:
            mid = (left + right) // 2
            
            # If the target is found at mid
            if nums[mid] == target:
                return mid
            
            # Determine which side is sorted
            if nums[left] <= nums[mid]:  # Left side is sorted
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:  # Right side is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        # If target is not found
        return -1