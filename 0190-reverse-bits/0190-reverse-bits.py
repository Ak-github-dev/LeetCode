# Steps:
# 1. Initialize the result: Start with result initialized with 0
# 2. Process each bit: Iterate through each of 32 bit of input int 
#   a. Extract least significant bit using bitwise AND (n & 1)
#   b. Shift result left one bit to make room for new bit
#   c. Add extracted bit to result
#   d. Shift input number right by one bit to process next bit
# 3. Return the result: After processing all 32 bits, the result will contain reversed bits of input integer
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        result = 0
        for _ in range(32):
            result = (result << 1) | (n & 1)
            n >>= 1
        return result