class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Calculate the longest increasing subsequence ending at each index
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        // Calculate the longest decreasing subsequence starting at each index
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        // Calculate the maximum mountain length
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 1 && right[i] > 1) {
                maxMountainLength = Math.max(maxMountainLength, left[i] + right[i] - 1);
            }
        }
        
        // Minimum removals needed to make it a mountain array
        return n - maxMountainLength;
    }
}