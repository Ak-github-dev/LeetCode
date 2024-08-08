"""
Sort the Intervals: Start by sorting the intervals based on their starting times. This helps in easily finding overlapping intervals.

Initialize the Merged Intervals List: Create a list to store the merged intervals.

Merge Intervals: Iterate through the sorted intervals and merge them if they overlap. If the current interval overlaps with the last interval in the merged list, update the end of the last interval in the merged list. If it does not overlap, simply add the current interval to the merged list.
"""
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if not intervals:
            return []
        
        # Step 1: Sort intervals by their start time
        intervals.sort(key=lambda x: x[0])
        
        # Step 2: Initialize the merged intervals list with the first interval
        merged = [intervals[0]]
        
        for current in intervals[1:]:
            # Get the last interval in the merged list
            last = merged[-1]
            
            # Step 3: If current interval overlaps with the last merged interval, merge them
            if current[0] <= last[1]:
                last[1] = max(last[1], current[1])
            else:
                # Otherwise, add the current interval to the merged list
                merged.append(current)
        
        return merged