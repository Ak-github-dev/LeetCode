class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the longest non-decreasing suffix
        int right = n - 1;
        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Remove either the prefix or the suffix
        int result = Math.min(n - left - 1, right);

        // Try to merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}