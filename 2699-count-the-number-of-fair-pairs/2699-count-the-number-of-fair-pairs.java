class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array to use binary search
        Arrays.sort(nums);
        long count = 0;
        
        // Iterate over each element in nums
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            
            // Find the left bound for the pair (i, j) where num + nums[j] >= lower
            int left = findLeftBound(nums, i + 1, lower - num);
            
            // Find the right bound for the pair (i, j) where num + nums[j] <= upper
            int right = findRightBound(nums, i + 1, upper - num);
            
            // Add the count of fair pairs between left and right indices
            if (left != -1 && right != -1 && left <= right) {
                count += right - left + 1;
            }
        }
        
        return count;
    }
    
    // Helper function to find the left bound where num + nums[j] >= target
    private int findLeftBound(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    // Helper function to find the right bound where num + nums[j] <= target
    private int findRightBound(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}