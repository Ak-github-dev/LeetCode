/*
Approach:

Find Longest Palindromic Prefix:

The key part of the string is its longest palindromic prefix. Once we identify that, the remaining part of the string (the non-palindromic suffix) can be reversed and added to the front.

Efficient Palindrome Check with KMP Algorithm:

The challenge is efficiently finding the longest palindromic prefix. This can be done using a variation of the Knuth-Morris-Pratt (KMP) algorithm by concatenating the original string and its reverse, with a special character between them to avoid overlap.

Steps:

Reverse the string s and concatenate it with the original string using a separator (e.g., s + "#" + reverse(s)).
Build a KMP table for this concatenated string to find the longest prefix that is also a suffix.
The result will be the reverse of the remaining part of s plus the original string.
*/
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // Create a new string by concatenating s + "#" + reverse(s)
        String reversed = new StringBuilder(s).reverse().toString();
        String newString = s + "#" + reversed;

        // Create a KMP table for the new string
        int[] kmpTable = createKMPTable(newString);

        // Length of the longest palindromic prefix
        int longestPalindromicPrefixLength = kmpTable[newString.length() - 1];

        // Add the non-palindromic part of the reversed string to the front of the original string
        return reversed.substring(0, s.length() - longestPalindromicPrefixLength) + s;
    }

    // Helper function to create the KMP table
    private int[] createKMPTable(String s) {
        int[] table = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            table[i] = j;
        }

        return table;
    }
}