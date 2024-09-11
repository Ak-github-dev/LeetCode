/*
Key Insight:

The bits that differ between start and goal indicate where flips are required. By using the XOR (^) operation between the two numbers, we can identify which bits are different.
The number of 1s in the result of the XOR operation represents the number of differing bits, and thus the number of bit flips required.

Approach:

XOR Operation:

XOR start and goal. This will give a binary number where each 1 indicates a differing bit between start and goal.

Count the 1s:

Count the number of 1s in the result of the XOR operation, which corresponds to the number of bit flips required.
*/
class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR of start and goal will give us a number with bits set to 1 where they differ
        int xor = start ^ goal;
        
        // Count the number of 1s in the XOR result (i.e., the number of differing bits)
        int count = 0;
        while (xor != 0) {
            count += xor & 1;  // Add 1 if the last bit is 1
            xor >>= 1;         // Right shift to check the next bit
        }
        
        return count;
    }
}