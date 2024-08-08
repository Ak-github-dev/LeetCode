"""
Steps:

Initialize a result list: This will store the final merged intervals.

Traverse the intervals:
Before the new interval: Add all intervals that end before the new interval starts.
Merging intervals: Merge all overlapping intervals with the new interval.
After the new interval: Add the remaining intervals that start after the new 
interval ends.

Handle edge cases: Ensure the new interval is added in the correct position if it doesn't overlap with any intervals.
"""
class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        result = []
        i = 0
        n = len(intervals)
        
        # Add all intervals before newInterval
        while i < n and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1
        
        # Merge intervals that overlap with newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        
        # Add the merged interval
        result.append(newInterval)
        
        # Add all intervals after newInterval
        while i < n:
            result.append(intervals[i])
            i += 1
        
        return result