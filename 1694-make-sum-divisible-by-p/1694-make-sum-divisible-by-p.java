/*
Approach

Modular Arithmetic Observation:

Let totalSum be the sum of all elements in the array nums. If totalSum % p == 0, the sum is already divisible by p, and we can return 0 (no need to remove any subarray).
If totalSum % p != 0, let's call the remainder target = totalSum % p. We want to remove a subarray such that the sum of the remaining elements is divisible by p, which means we need to find a subarray whose sum gives the same remainder target when divided by p.

Prefix Sums and Modular Arithmetic:

We can use prefix sums to compute the cumulative sum of the elements up to each index, and track the remainders of these sums when divided by p. The goal is to find the smallest subarray that, when removed, results in a sum divisible by p.
By using a map to store the latest index of each remainder encountered, we can efficiently find the smallest subarray that, when removed, gives the desired remainder.

Key Steps:

Calculate target = totalSum % p.
Traverse the array and calculate prefix sums modulo p. Use a map to store the last occurrence of each remainder.
Check if removing the subarray between two prefix sums would yield a total sum divisible by p.
Return the minimum length of such a subarray, or -1 if no valid subarray is found.
*/
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Find the target remainder we need to remove
        long target = totalSum % p;
        if (target == 0) return 0; // If totalSum is already divisible by p
        
        Map<Long, Integer> prefixRemainderIndex = new HashMap<>();
        prefixRemainderIndex.put(0L, -1); // Initial remainder is 0 at index -1 (before the array starts)
        
        long prefixSum = 0;
        int minLength = n;  // Start with the largest possible length
        
        // Traverse through the array
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long currentRemainder = prefixSum % p;
            
            // Find what remainder we need to match with a previous prefix
            long desiredRemainder = (currentRemainder - target + p) % p;
            
            // If we've seen this remainder before, calculate the length of the subarray to remove
            if (prefixRemainderIndex.containsKey(desiredRemainder)) {
                minLength = Math.min(minLength, i - prefixRemainderIndex.get(desiredRemainder));
            }
            
            // Store the current remainder and its index
            prefixRemainderIndex.put(currentRemainder, i);
        }
        
        // If we found a valid subarray, return its length, otherwise return -1
        return minLength == n ? -1 : minLength;
    }
}