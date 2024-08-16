"""
Idea:
The number of set bits in a binary number can be determined by repeatedly checking the least significant bit (LSB) and then right-shifting the number until all bits are checked.

Approach:
Check the LSB:
Use the bitwise AND operation (n & 1) to check if the least significant bit is 1.
If it is, increment the count of set bits.
Right Shift:
Right shift the number by 1 (n >>= 1) to move the next bit to the LSB position.
Continue this process until the number becomes 0.
"""
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            count += n & 1
            n >>= 1
        return count