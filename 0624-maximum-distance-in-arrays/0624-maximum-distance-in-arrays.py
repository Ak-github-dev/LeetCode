"""
Approach:

Initialization:

Track the minimum and maximum values found so far (min_val, max_val).
Initialize the result as 0.

Iterate Through Arrays:

For each array, calculate the potential maximum distance using the current array's minimum and maximum values against the tracked min_val and max_val from previous arrays.
Update min_val and max_val with the current array's minimum and maximum values.

Consider Only Different Arrays:

Ensure that the values being compared are from different arrays.
"""
class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        min_val = arrays[0][0]
        max_val = arrays[0][-1]
        max_distance = 0

        for i in range(1, len(arrays)):
            current_min = arrays[i][0]
            current_max = arrays[i][-1]
            
            # Compare current min with global max and current max with global min
            max_distance = max(max_distance, abs(current_max - min_val), abs(max_val - current_min))
            
            # Update global min and max
            min_val = min(min_val, current_min)
            max_val = max(max_val, current_max)
        
        return max_distance