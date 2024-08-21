/*
Approach:

Two-Pointer Technique:

You use two pointers: i and j.
i is used to track the position to place the next non-zero element.
j is used to traverse the array.

Algorithm:

Traverse the array using j.
Whenever a non-zero element is encountered, swap the elements at indices i and j, then increment i.
After the loop, all the non-zero elements are at the beginning, and all the zeros are at the end.
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; // Pointer to place the next non-zero element
        
        // Traverse through all elements in the array
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not zero
            if (nums[j] != 0) {
                // Swap the elements at indices i and j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                // Move the pointer i to the next position
                i++;
            }
        }
    }
}