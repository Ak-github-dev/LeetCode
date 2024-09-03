/*
Steps to Implement:

Convert String to Numbers:

Iterate over the string, convert each character to its respective numeric position, and concatenate these numbers.

Sum of Digits:

Convert the large number (from step 1) into its individual digits and sum them.
Repeat this step k times.
*/
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numStr = new StringBuilder();
        
        // Convert the string to its corresponding numeric position
        for (char c : s.toCharArray()) {
            numStr.append(c - 'a' + 1);
        }
        
        // Sum the digits and repeat k times
        int result = 0;
        for (char c : numStr.toString().toCharArray()) {
            result += c - '0';
        }
        
        // Perform the sum operation k-1 more times
        for (int i = 1; i < k; i++) {
            result = sumDigits(result);
        }
        
        return result;
    }
    
    // Helper function to sum digits of an integer
    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}