class Solution {
    public long minEnd(int n, int x) {
        long result = x;            // Start with x as the base value for the result
        long remaining = n - 1;      // Number of elements remaining to fulfill the array size
        long position = 1;           // Start with the smallest bit position (1 in binary)
        
        // Loop until we place all required bits to satisfy the number of elements
        while (remaining != 0) {
            // Check if the current position bit is not already set in x
            if ((x & position) == 0) {
                // Set the bit in result if the corresponding bit in remaining is 1
                result |= (remaining & 1) * position;
                // Right shift remaining to check the next bit in the next iteration
                remaining >>= 1;
            }
            // Move to the next higher bit position
            position <<= 1;
        }
        
        return result; // Return the minimal last element that satisfies the conditions
    }
}