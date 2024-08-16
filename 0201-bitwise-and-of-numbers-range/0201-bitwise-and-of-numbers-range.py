"""
Key Insight:
When performing a bitwise AND operation over a range of numbers, the bits that remain the same in all numbers within the range will be the bits that are set in the final result. However, as we move from left to right, bits may start to differ, particularly the least significant bits. Therefore, the common prefix of the binary representations of left and right will determine the result.

Approach:
The result of the bitwise AND operation will only preserve the common prefix of left and right. Any bits that differ between left and right will become zero in the final result.
To find this common prefix, we can shift both left and right to the right until they are equal, counting the number of shifts. The result will be left (or right, since they are equal at this point) shifted back left by the number of shifts.
"""
class Solution(object):
    def rangeBitwiseAnd(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: int
        """
        shift = 0
        # Find the common prefix
        while left < right:
            left >>= 1
            right >>= 1
            shift += 1
        
        # Shift back to the left to get the result
        return left << shift