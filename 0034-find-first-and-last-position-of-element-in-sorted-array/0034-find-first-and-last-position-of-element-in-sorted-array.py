"""
Strategy:
Find the First Position:

Perform a binary search to find the first occurrence of the target.
Continue searching to the left even after finding an occurrence to ensure it’s the first position.
Find the Last Position:

Similarly, perform another binary search to find the last occurrence of the target.
Continue searching to the right even after finding an occurrence to ensure it’s the last position.
Detailed Steps:
Binary Search for the First Occurrence:

Initialize left to 0 and right to the length of the array minus one.
While left is less than or equal to right, calculate the middle index.
If nums[mid] is greater than or equal to the target, move right to mid - 1 (continue searching to the left).
If nums[mid] is less than the target, move left to mid + 1.
If nums[mid] equals the target, record the position as a potential first occurrence and continue searching to the left.
Binary Search for the Last Occurrence:

Use a similar approach but adjust the conditions to ensure searching to the right after finding an occurrence.
Return the Result:

If the target is found, the first and last positions are returned. If not, [-1, -1] is returned.
"""
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findFirstPosition(nums, target):
            left, right = 0, len(nums) - 1
            first_position = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    first_position = mid
                    right = mid - 1  # Continue searching to the left
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return first_position

        def findLastPosition(nums, target):
            left, right = 0, len(nums) - 1
            last_position = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    last_position = mid
                    left = mid + 1  # Continue searching to the right
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return last_position
        
        first_position = findFirstPosition(nums, target)
        if first_position == -1:
            return [-1, -1]
        
        last_position = findLastPosition(nums, target)
        return [first_position, last_position]