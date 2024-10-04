/*
Approach

Sorting: 

Since we want to form teams with equal total skill, a sorted array helps in pairing the smallest and largest values. By doing this, we can try to ensure that all pairs have the same sum.

Two-Pointer Technique:

Use a two-pointer technique to pair the smallest and largest values in the array.
Calculate the skill sum for the first team as the sum of the first and last player. Then, check if all subsequent pairs have the same skill sum.
If they don't, return -1 because it's not possible to divide the players into valid teams.

Chemistry Calculation:

For each valid pair, calculate the chemistry as the product of the two players' skills and accumulate the result.
*/
class Solution {
    public long dividePlayers(int[] skill) {
         // Sort the skills array
        Arrays.sort(skill);
        
        int n = skill.length;
        long totalChemistry = 0;
        int targetSum = skill[0] + skill[n - 1];  // Target sum of the skills of each pair
        
        int left = 0, right = n - 1;
        
        while (left < right) {
            int currentSum = skill[left] + skill[right];
            // Check if the current pair's sum matches the target sum
            if (currentSum != targetSum) {
                return -1;
            }
            // Add the product of the two skills (chemistry of the team) to the total chemistry
            totalChemistry += (long) skill[left] * skill[right];
            
            left++;
            right--;
        }
        
        return totalChemistry;
    }
}