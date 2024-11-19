class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long maxSum = 0;
        long currentSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            // Expand the window and add the current element to the sum
            currentSum += nums[end];

            // If the element is already in the set, shrink the window from the left
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            // Add the current element to the set
            set.add(nums[end]);

            // If the window size becomes k, check if it's a valid subarray
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Shrink the window from the left to prepare for the next iteration
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}