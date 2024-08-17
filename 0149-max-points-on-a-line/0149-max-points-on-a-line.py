"""
Key Insights:

Slope Calculation:
The slope between any two points (x1,y1) and (x2,y2) can be calculated as:
slope = (y2-y1)/(x2-x1) 
However, directly working with floating-point numbers can lead to precision issues. Instead, we can represent the slope as a fraction |Δ\U0001d466/Δ\U0001d465|, where Δ\U0001d466=\U0001d4662−\U0001d4661 and Δ\U0001d465=\U0001d4652−\U0001d4651.
Handling Vertical Lines:
If Δ\U0001d465=0, the line is vertical. In this case, the slope can be considered as "infinity" or represented by a special case.
Handling Overlapping Points:
We need to account for overlapping points, as they all lie on the same line.
Optimization:
For each point, calculate the slope with every other point and use a hashmap (dictionary) to count how many points share the same slope with the current point. The maximum count for a single slope gives the number of points on the same line.

Approach:
Iterate over each point and treat it as the anchor.
For each anchor point, calculate the slope with every other point and store the count of points sharing the same slope in a hashmap.
The maximum value from this hashmap plus the overlapping points gives the maximum number of points on the same line passing through the anchor point.
Repeat for all points, and return the global maximum.
"""
from collections import defaultdict
#from math import gcd
class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a

            
        def slope(p1, p2):
            dx = p2[0] - p1[0]
            dy = p2[1] - p1[1]
            if dx == 0:
                return ('inf', 0)
            g = gcd(dy, dx)
            return (dy // g, dx // g)
        
        n = len(points)
        if n <= 2:
            return n
        
        max_points = 0
        
        for i in range(n):
            slopes = defaultdict(int)
            overlap = 0
            current_max = 0
            
            for j in range(i + 1, n):
                if points[i] == points[j]:
                    overlap += 1
                    continue
                
                s = slope(points[i], points[j])
                slopes[s] += 1
                current_max = max(current_max, slopes[s])
            
            max_points = max(max_points, current_max + overlap + 1)
        
        return max_points