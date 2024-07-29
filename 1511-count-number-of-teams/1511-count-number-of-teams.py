"""
The naive approach would involve three nested loops to examine every triplet, resulting in an O(n^3) time complexity. However, this approach may be optimized to 
O(n^2) using dynamic programming concepts.

Optimized Approach:
Dynamic Programming Optimization: Count the number of possible ways to pick two soldiers before each soldier such that they form a valid subsequence. We achieve this by:

Maintaining two counts for each soldier:
left_smaller[j]: How many soldiers to the left of j have a rating less than rating[j].
left_larger[j]: How many soldiers to the left of j have a rating greater than rating[j].
As you iterate over each soldier, update these counts for all subsequent soldiers.
Count Valid Triplets: Use the counts from the previous step to determine how many valid triplets each soldier can be a part of as the middle soldier.

For each soldier j:
Teams where rating[i] < rating[j] < rating[k]: 
left_smaller[j]×right_larger[j]

Teams where rating[i] > rating[j] > rating[k]: 
left_larger[j]×right_smaller[j]
"""
class Solution(object):
    def numTeams(self, rating):
        """
        :type rating: List[int]
        :rtype: int
        """
        n = len(rating)
        if n < 3:
            return 0
        
        left_smaller = [0] * n
        left_larger = [0] * n
        right_smaller = [0] * n
        right_larger = [0] * n
        result = 0
        
        # Compute left counts
        for j in range(n):
            for i in range(j):
                if rating[i] < rating[j]:
                    left_smaller[j] += 1
                elif rating[i] > rating[j]:
                    left_larger[j] += 1
        
        # Compute right counts and accumulate the results
        for j in range(n):
            for k in range(j + 1, n):
                if rating[j] < rating[k]:
                    right_larger[j] += 1
                    result += left_smaller[j]
                elif rating[j] > rating[k]:
                    right_smaller[j] += 1
                    result += left_larger[j]
        
        return result