"""
Approach:

Two-Pointer Technique:

Start with two pointers, one at the beginning (left) and one at the end (right) of the array.
Calculate the area formed by the lines at these two pointers.
Move the pointer pointing to the shorter line inward, since the height of the container is limited by the shorter line, and moving the shorter line inward might find a taller line that increases the area.

Area Calculation:

The area of water that can be contained between two lines is given by the formula:
Area=min(height[left], height[right])×(right−left)
Keep track of the maximum area found during the iterations.

Move Pointers:

If height[left] is less than height[right], increment the left pointer to try and find a taller line.
If height[right] is less than or equal to height[left], decrement the right pointer to try and find a taller line.
"""
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left, right = 0, len(height) - 1
        max_area = 0
        
        while left < right:
            # Calculate the current area
            width = right - left
            current_height = min(height[left], height[right])
            current_area = width * current_height
            
            # Update the maximum area found so far
            max_area = max(max_area, current_area)
            
            # Move the pointer of the shorter line
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return max_area