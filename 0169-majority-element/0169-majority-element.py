class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Boyer-Moore Voting Algorithm
        candidate = None
        count = 0

        # First pass to find the candidate
        for num in nums:
            if count == 0:
                candidate = num
            if num == candidate:
                count += 1
            else:
                count -= 1

        # The candidate is the majority element
        return candidate