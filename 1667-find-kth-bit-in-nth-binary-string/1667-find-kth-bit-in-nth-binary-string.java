/*
Recursive Approach:

We can break down the problem as follows:

If k is less than or equal to 2^(n-1) - 1, then k is within S_{n-1}.
If k is exactly 2^(n-1), then it is the middle bit, which is 1.
If k is greater than 2^(n-1), we need to transform k to its corresponding index in the reversed and inverted S_{n-1} and invert the result.
*/
class Solution {
    public char findKthBit(int n, int k) {
        return findKthBitHelper(n, k);
    }
    
    private char findKthBitHelper(int n, int k) {
        if (n == 1) {
            return '0';  // Base case: S1 is "0".
        }
        
        int mid = (1 << (n - 1));  // Midpoint is 2^(n-1).
        
        if (k == mid) {
            return '1';  // The middle bit is always 1.
        } else if (k < mid) {
            return findKthBitHelper(n - 1, k);  // Look in the first half, corresponding to S_{n-1}.
        } else {
            // Look in the second half, corresponding to the reverse-invert of S_{n-1}.
            int newK = mid - (k - mid);
            char result = findKthBitHelper(n - 1, newK);
            return invert(result);
        }
    }
    
    private char invert(char bit) {
        return bit == '0' ? '1' : '0';  // Invert the bit.
    }
}