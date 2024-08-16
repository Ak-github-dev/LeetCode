"""
Key Observations:

No Duplicates: The array contains unique elements, so we don't need to handle duplicate values, which simplifies the logic.
Rotated Sorted Array: In a rotated sorted array, if you pick the middle element, one half of the array will be sorted, and the other half will contain the rotation (and hence the minimum element).

Approach:
Use binary search to narrow down the range where the minimum element can be found.
Compare the middle element with the rightmost element to determine which part of the array is unsorted (and therefore contains the minimum).

Steps:
Initialize:
Set left to 0 and right to the last index of the array.
Binary Search:
While left is less than right:
Calculate the middle index mid.
Compare nums[mid] with nums[right]:
If nums[mid] > nums[right], it means the minimum is in the right half, so set left to mid + 1.
Otherwise, the minimum is in the left half, including mid, so set right to mid.
Termination:
When left equals right, it will point to the minimum element.
"""
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left, right = 0, len(nums) - 1
    
        while left < right:
            mid = (left + right) // 2
            
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]