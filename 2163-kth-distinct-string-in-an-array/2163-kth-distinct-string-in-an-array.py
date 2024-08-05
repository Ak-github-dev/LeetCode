"""
Count Frequencies:

Use a dictionary to count the occurrences of each string in the array.

Identify Distinct Strings:

Iterate through the array and keep track of strings that appear exactly once using the frequency dictionary.

Find the k-th Distinct String:

Iterate through the list of distinct strings and return the k-th one. If there are fewer than k distinct strings, return an empty string.
"""
class Solution(object):
    def kthDistinct(self, arr, k):
        """
        :type arr: List[str]
        :type k: int
        :rtype: str
        """
        # Step 1: Count frequencies of each string
        frequency = {}
        for string in arr:
            if string in frequency:
                frequency[string] += 1
            else:
                frequency[string] = 1

        # Step 2: Collect distinct strings
        distinct_strings = []
        for string in arr:
            if frequency[string] == 1:
                distinct_strings.append(string)

        # Step 3: Return the k-th distinct string if it exists
        if len(distinct_strings) >= k:
            return distinct_strings[k - 1]
        else:
            return ""