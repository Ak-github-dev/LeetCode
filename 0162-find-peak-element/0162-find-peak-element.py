"""
Approach:

Binary Search:
We can use a modified binary search to find a peak element.
Start by setting two pointers: left at the beginning of the array and right at the end of the array.
Calculate the middle index mid.
Compare the middle element nums[mid] with its right neighbor nums[mid + 1]:
If nums[mid] > nums[mid + 1], it means there might be a peak on the left side, including mid itself. Hence, move right to mid.
If nums[mid] < nums[mid + 1], it means there is definitely a peak on the right side, so move left to mid + 1.
Continue narrowing down the search range until left equals right. At this point, left (or right) will be pointing to a peak element.
"""
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left, right = 0, len(nums) - 1
    
        while left < right:
            mid = (left + right) // 2
            
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1
        
        return left