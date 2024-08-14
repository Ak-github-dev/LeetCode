"""
Steps:

Base Case:

If the list is empty, return an empty list as there are no permutations.
If the list has one element, return a list containing that single element as the only permutation.

Recursive Case:

Iterate through each element in the list.
For each element, remove it from the list, generate all permutations of the remaining list, and then add the removed element back in front of each of these permutations.
Collect all these permutations in a result list.
"""
import heapq
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Base case: if the list is empty, return an empty list
        if len(nums) == 0:
            return []
        # Base case: if the list has one element, return it as the only permutation
        if len(nums) == 1:
            return [nums]
        
        # Resultant list to store all permutations
        result = []
        
        # Loop through the list and generate permutations
        for i in range(len(nums)):
            # Take the current element
            current = nums[i]
            # Remaining list without the current element
            remaining_list = nums[:i] + nums[i+1:]
            # Generate all permutations for the remaining list
            for p in self.permute(remaining_list):
                # Add the current element to the front of each permutation
                result.append([current] + p)
        
        return result