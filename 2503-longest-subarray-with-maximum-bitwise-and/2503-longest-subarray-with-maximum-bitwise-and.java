/*
Approach:

Identify Maximum Value:

First, we need to identify the maximum value in the array nums, because any subarray with the maximum bitwise AND will consist of this value.

Find Longest Subarray of Maximum Value:

Once we have the maximum value, we traverse the array to find the longest contiguous subarray that consists of this maximum value.

Steps:
Traverse the array and find the maximum element maxVal.
Traverse the array again and count the lengths of contiguous subarrays where the elements are equal to maxVal. Keep track of the longest such subarray.
*/
class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int maxLength = 0;
        int currentLength = 0;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest subarray where all elements are equal to maxVal
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0; // Reset the current length
            }
        }

        return maxLength;
    }
}