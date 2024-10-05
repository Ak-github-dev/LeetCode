/*
Key Observations:

A permutation of a string is just another arrangement of its characters. Hence, the frequency of characters in a permutation of s1 must be the same as the frequency of those characters in the substring of s2.
Therefore, we can move a window of length equal to s1.length across s2 and check if the character frequency of the current window matches the character frequency of s1.

Steps:
Use an array of size 26 (representing each character from 'a' to 'z') to store the frequency of characters for both s1 and the current window in s2.
Slide a window of size s1.length across s2. For each position, update the window by removing the frequency of the character that is left behind and adding the frequency of the new character that enters the window.
If the character frequency of the current window matches that of s1, return true.
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, s2 can't contain any permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays for s1 and for the current window in s2
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // Fill the frequency array for s1 and the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        // Sliding window starts after the first window
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // If the current window matches s1 frequency, return true
            if (matches(s1Freq, s2Freq)) {
                return true;
            }

            // Slide the window: remove the leftmost character and add the next one
            s2Freq[s2.charAt(i) - 'a']--;  // Remove the leftmost character
            s2Freq[s2.charAt(i + s1.length()) - 'a']++;  // Add the next character
        }

        // Check the last window after the loop ends
        return matches(s1Freq, s2Freq);
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }
}