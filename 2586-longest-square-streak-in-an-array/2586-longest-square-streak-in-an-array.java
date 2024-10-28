/*
Approach:

Check and Start Streak from Each Element:

Sort nums and store them in a HashSet for efficient lookup.
For each unique number in nums, start checking for streaks only if that number is a candidate to start a valid square streak (it’s the base of potential squares).

Only Expand with Consecutive Squares:

As we expand the streak by squaring the number iteratively, check if each squared result exists in the HashSet.
Stop expanding if a square exceeds the allowable limit or isn’t present in the set.

Update Maximum Length:

Track the longest square streak found, ensuring we capture streaks of length at least 2, as required.
*/
class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        
        // Populate the set for O(1) lookups
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = -1;

        // Iterate over each number and try to form a square streak
        for (int num : nums) {
            if (!set.contains(num)) continue; // skip if not present in the set
            
            int current = num;
            int currentLength = 0;

            // Expand the streak only if consecutive squares are present
            while (set.contains(current)) {
                currentLength++;
                set.remove(current); // Remove to prevent re-processing
                current *= current; // Move to the next square
                
                if (current > 100000) break; // prevent overflow, stop further checking
            }

            if (currentLength >= 2) { // valid streak condition
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength == -1 ? -1 : maxLength;
    }
}