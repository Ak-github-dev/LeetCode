/*
Approach:

Calculate the Target Sum:

The total sum of all n + m rolls can be calculated using the formula:
targetSum=mean*(n+m)
We already have the sum of the observed rolls. So, we can calculate the sum of the missing rolls (missingSum) by subtracting the sum of the observed rolls from the target sum.

Distribute the Missing Sum:

The missing rolls must be values between 1 and 6 (because they represent the values of dice rolls).
To distribute the missingSum among n rolls, we must ensure that each roll is between 1 and 6. If it's impossible to distribute the missingSum in this range, we return an empty array.

Greedy Distribution:

Start by assigning each missing roll a value of 1, then try to increase the values of the rolls (up to a maximum of 6) until the sum of the missing rolls matches missingSum.
*/
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        
        // Calculate the target sum for all n + m rolls
        int targetSum = mean * (n + m);
        
        // Calculate the sum of the observed rolls
        int observedSum = 0;
        for (int roll : rolls) {
            observedSum += roll;
        }
        
        // Calculate the missing sum
        int missingSum = targetSum - observedSum;
        
        // The missing sum must be between n and 6 * n
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];  // Impossible to achieve the desired mean
        }
        
        // Initialize the result array with 1's (minimum value for each roll)
        int[] result = new int[n];
        Arrays.fill(result, 1);
        
        // Distribute the remaining (missingSum - n) across the rolls
        int remaining = missingSum - n;
        for (int i = 0; i < n && remaining > 0; i++) {
            int increment = Math.min(5, remaining);  // Max increment to make it 6
            result[i] += increment;
            remaining -= increment;
        }
        
        return result;
    }
}