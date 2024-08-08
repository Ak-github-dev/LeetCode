"""
Steps:
Sort the balloons: Sort the balloons by their ending position. This helps us to always prioritize bursting the balloons that end the earliest.
Initialize arrows count: Start with one arrow and set the position of this arrow to the end position of the first balloon.
Iterate through the balloons: For each balloon, check if it can be burst by the current arrow (i.e., its start position is less than or equal to the current arrow position).
Update arrow position: If a balloon cannot be burst by the current arrow, increment the arrow count and set the new arrow position to the end of the current balloon.
"""
class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if not points:
            return 0
        
        # Sort balloons by their end position
        points.sort(key=lambda x: x[1])
        
        # Initialize the number of arrows needed and the position of the first arrow
        arrows = 1
        arrow_pos = points[0][1]
        
        for x_start, x_end in points:
            # If the current balloon starts after the last arrow position, we need a new arrow
            if x_start > arrow_pos:
                arrows += 1
                arrow_pos = x_end
        
        return arrows