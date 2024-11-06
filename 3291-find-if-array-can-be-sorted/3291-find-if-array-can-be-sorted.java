class Solution {
    public boolean canSortArray(int[] nums) {
        // Stores the max value of the previous bit-count group
        short prevMaxValue = 0;
        // Minimum and maximum values of the current bit-count group
        short currMinValue = 0, currMaxValue = 0;
        // Previous bit count of the group
        byte prevBitCount = 0;

        // Loop through each number in the array
        for (final int value : nums) {
            // Get the bit count of the current value
            final byte currBitCount = (byte) Integer.bitCount(value);

            // If the current value has the same bit count as the previous group
            if (prevBitCount == currBitCount) {
                // Update the min and max values for the current group
                currMinValue = (short) Math.min(currMinValue, value);
                currMaxValue = (short) Math.max(currMaxValue, value);
            } 
            // If we encounter a new bit-count group
            else {
                // Check if the minimum value of the current group is less than
                // the maximum of the previous group, which would prevent sorting
                if (currMinValue < prevMaxValue) {
                    return false;
                }
                // Update the previous group's max value to the current max
                prevMaxValue = currMaxValue;
                // Reset min and max for the new bit-count group
                currMinValue = currMaxValue = (short) value;
                // Update the previous bit count to the current one
                prevBitCount = currBitCount;
            }
        }
        // Final check to confirm if the last group's min is greater than or equal to prevMax
        return currMinValue >= prevMaxValue;
    }
}