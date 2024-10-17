/*
Approach:

Convert the number into a list of digits.

Traverse the digits, and for each digit, check if there is a larger digit that occurs later in the number. If found, swap these two digits.

If no swap improves the number, return the original number.
*/
class Solution {
    public int maximumSwap(int num) {
        // Convert the number to a character array (array of digits)
        char[] digits = Integer.toString(num).toCharArray();
        
        // Create an array to store the last occurrence index of each digit
        int[] lastIndex = new int[10];  // digits range from 0 to 9
        
        // Fill the lastIndex array with the index of each digit in the number
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }
        
        // Try to find the first digit that can be swapped to maximize the number
        for (int i = 0; i < digits.length; i++) {
            // Check from digit 9 down to (current digit + 1)
            for (int d = 9; d > digits[i] - '0'; d--) {
                // If a larger digit exists after the current digit, swap them
                if (lastIndex[d] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;
                    
                    // Return the result as an integer
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap was done, return the original number
        return num;
    }
}