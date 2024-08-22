/*
Approach:

Understanding the Problem:

The problem requires finding a contiguous subarray within an array that has the largest product.
The presence of negative numbers complicates the problem because multiplying two negative numbers results in a positive product.

Dynamic Programming Approach:

Use two variables maxProduct and minProduct to keep track of the maximum and minimum products up to the current element.
The reason for tracking both is that a negative number could turn the smallest product into the largest if multiplied.

Algorithm:

Initialize maxProduct, minProduct, and result with the first element of the array.
Iterate through the array starting from the second element:
If the current element is negative, swap maxProduct and minProduct.
Update maxProduct to be the maximum of the current element or maxProduct * current element.
Update minProduct to be the minimum of the current element or minProduct * current element.
Update the result to be the maximum of result and maxProduct.
Return result as the maximum product subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
       if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            // If current number is negative, swap max and min
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            // Calculate max and min product up to the current index
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);
            
            // Update result with the maximum product found so far
            result = Math.max(result, maxProduct);
        }
        
        return result; 
    }
}