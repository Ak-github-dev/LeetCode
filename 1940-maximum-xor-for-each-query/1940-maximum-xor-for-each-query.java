class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int totalXOR = 0;
        int maxVal = (1 << maximumBit) - 1;  // This is 2^maximumBit - 1, which has all bits set up to maximumBit

        // Calculate the initial total XOR of the entire array
        for (int num : nums) {
            totalXOR ^= num;
        }

        // Process each query by calculating the best k and updating totalXOR
        for (int i = 0; i < n; i++) {
            result[i] = totalXOR ^ maxVal; // Best k for current totalXOR
            totalXOR ^= nums[n - 1 - i];   // Remove the last element's contribution for the next query
        }

        return result;
    }
}