"""
Approach:

Use Two Pointers:

The first pointer, i, iterates through the array.
The second pointer, pos, keeps track of the position where the next valid element should be placed.

Count Occurrences:

Maintain a count of occurrences for the current element.
If an element's count is less than or equal to 2, it is considered valid and should be placed at the pos pointer's position.

Update the Array:

Traverse through the array with the i pointer.
For each element, check if it can be added to the result (by checking its count).
If valid, place it at pos and increment pos.
"""
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 2:
            return len(nums)
        
        pos = 1  # Start from the second element
        count = 1  # Count occurrences of the current number
        
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                count += 1
            else:
                count = 1
            
            if count <= 2:
                nums[pos] = nums[i]
                pos += 1
        
        return pos