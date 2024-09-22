class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // We decrement k because we start from the first element (1)

        while (k > 0) {
            // Calculate how many numbers exist between current and current+1
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // If k is larger than the steps, move to the next prefix
                current++;
                k -= steps;
            } else {
                // If k is smaller, we move deeper in the current prefix
                current *= 10;
                k--;
            }
        }
        
        return current;
    }

    // Count how many numbers are in the range [prefix, nextPrefix)
    private long countSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}