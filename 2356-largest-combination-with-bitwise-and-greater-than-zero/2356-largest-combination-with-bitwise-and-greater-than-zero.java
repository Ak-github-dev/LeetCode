class Solution {
    public int largestCombination(int[] candidates) {
        int maxCombinationSize = 0;

        // Loop over each bit position up to 24 (enough for values <= 10^7)
        for (int bitPosition = 0; bitPosition < 24; bitPosition++) {
            int count = 0;

            // Count how many numbers have the current bit position set
            for (int num : candidates) {
                if ((num & (1 << bitPosition)) != 0) {
                    count++;
                }
            }

            // Update the maximum combination size with bitwise AND > 0
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }
}