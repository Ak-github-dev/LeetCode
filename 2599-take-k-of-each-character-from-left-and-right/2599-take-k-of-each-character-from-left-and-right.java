class Solution {
    public int takeCharacters(String s, int k) {
        // Step 1: Count total occurrences of 'a', 'b', and 'c'
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // Step 2: If any character appears less than k times, return -1
        for (int count : totalCount) {
            if (count < k) return -1;
        }

        // Step 3: Sliding window to find maximum valid middle window
        int n = s.length();
        int[] windowCount = new int[3];
        int left = 0;
        int maxMiddleSize = 0;

        for (int right = 0; right < n; right++) {
            // Add current character to window
            windowCount[s.charAt(right) - 'a']++;

            // Shrink window from the left if it exceeds the remaining allowable count
            while (windowCount[0] > totalCount[0] - k ||
                   windowCount[1] > totalCount[1] - k ||
                   windowCount[2] > totalCount[2] - k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum size of the middle window
            maxMiddleSize = Math.max(maxMiddleSize, right - left + 1);
        }

        // Step 4: Calculate the minimum characters removed
        return n - maxMiddleSize;
    }
}