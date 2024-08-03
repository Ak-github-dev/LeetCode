"""
Steps:
Count Frequencies:

Use a dictionary or the Counter class from the collections module to count the occurrences of each element in both arrays.
Compare Frequencies:

Compare the frequency counts of both arrays. If they match, return true; otherwise, return false.
"""
from collections import Counter
class Solution(object):
    def canBeEqual(self, target, arr):
        """
        :type target: List[int]
        :type arr: List[int]
        :rtype: bool
        """
        # Count frequencies of each element in both arrays
        target_counter = Counter(target)
        arr_counter = Counter(arr)
        
        # Compare the frequency counters
        return target_counter == arr_counter
