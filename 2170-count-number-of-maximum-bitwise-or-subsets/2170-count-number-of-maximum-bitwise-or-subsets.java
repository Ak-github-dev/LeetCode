/*
Approach:

Calculate Maximum OR Value:

We need to compute the maximum bitwise OR that can be obtained by any subset of the array. This maximum OR is achieved by taking the OR of all elements of the array because this gives the most inclusive OR operation.

Count Subsets with Maximum OR:

Once we know the maximum OR value, we need to count how many subsets produce this maximum OR.

Subset Generation:

For this, we can generate all possible subsets of nums using a backtracking approach or by iterating over all possible subsets (since nums.length <= 16, this is feasible).
For each subset, calculate its bitwise OR and check if it matches the maximum OR value.
*/
class Solution {
    public int countMaxOrSubsets(int[] nums) {
       int maxOr = 0;
        int count = 0;
        
        // Calculate the maximum possible OR by OR'ing all the elements
        for (int num : nums) {
            maxOr |= num;
        }
        
        // Use a backtracking function to count how many subsets match this maxOr
        count = countSubsets(nums, 0, 0, maxOr);
        
        return count;
    }
    
    // Helper function to recursively count subsets
    private int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        // Base case: if we've reached the end of the nums array
        if (index == nums.length) {
            return (currentOr == maxOr) ? 1 : 0;
        }
        
        // Recursive case: either include nums[index] or don't include it
        // 1. Include nums[index]
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr);
        
        // 2. Don't include nums[index]
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr);
        
        // Return the sum of both cases
        return include + exclude; 
    }
}