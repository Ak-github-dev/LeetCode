/*
To solve the "Max Number of K-Sum Pairs" problem efficiently, we can use a HashMap to keep track of the frequencies of the numbers as we iterate through the array. The idea is to check for each number if its complement (i.e., k - num) exists in the map. If it does, we have found a pair and can increment our operation count. Otherwise, we store the number in the map for future pairings.
*/
/*
Explanation:

Frequency Map:

We use a HashMap called freqMap to store the frequency of each number in the array.

Iterating Through the Array:

For each number in nums, we calculate its complement (k - num).
We check if the complement is already in the map with a count greater than 0. If it is, it means we've found a pair that sums up to k.
If a pair is found, we increment the operations counter and decrease the frequency of the complement in the map by 1.

Handling Unpaired Numbers:

If the complement is not found, we simply store the current number in the map or increment its frequency if it already exists.

Return the Result:

Finally, we return the number of valid operations (pairs) found.

Time Complexity:
The time complexity is O(n) where n is the length of the nums array. This is because we only make a single pass through the array and all map operations (get, put) take constant time on average.

Space Complexity:
The space complexity is also O(n) in the worst case, where all elements might need to be stored in the HashMap.
*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;
            if (freqMap.getOrDefault(complement, 0) > 0) {
                operations++;
                freqMap.put(complement, freqMap.get(complement) - 1);
            } else {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}