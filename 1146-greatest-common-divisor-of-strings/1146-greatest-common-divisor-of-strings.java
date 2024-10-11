/*
Approach:

Checking if str1 and str2 have a common pattern:

If str1 + str2 is equal to str2 + str1, it means both strings share a common structure. This ensures that there exists some string x that can divide both str1 and str2.

Finding the GCD of lengths:

Once we know that str1 and str2 have a common structure, the largest possible common string x that can divide both str1 and str2 will have a length that is the greatest common divisor (GCD) of the lengths of str1 and str2.
The string x would be the prefix of either str1 or str2 with the length equal to the GCD of the lengths of the two strings.

Algorithm:
Check if str1 + str2 is equal to str2 + str1.
If true, compute the GCD of the lengths of str1 and str2.
Return the prefix of either str1 or str2 up to the GCD length.
*/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 equals str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; // No common divisor string
        }
        
        // Find the greatest common divisor of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Return the substring of str1 from 0 to gcdLength
        return str1.substring(0, gcdLength);
    }

    // Helper function to compute the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}