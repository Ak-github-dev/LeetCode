/*
Key Concept:

Each vowel ('a', 'e', 'i', 'o', 'u') can either have an even or odd count. By tracking the parity (even or odd) of the number of occurrences of each vowel, we can use a bitmask where each bit represents whether the count of a specific vowel is even or odd.

Bitmask Representation:

We can represent the state of vowels using a bitmask. For example:
If 'a' has an odd count, set the first bit.
If 'e' has an odd count, set the second bit.
Similarly for 'i', 'o', and 'u'.
A 5-bit bitmask (binary number) will be sufficient to track the parity of all five vowels.

Use a HashMap to Track States:

We use a map to store the first occurrence of each bitmask.
If we encounter the same bitmask at two different positions in the string, it means that the vowels between these two positions have even counts.


Steps:

Initialize Variables:

A bitmask variable to track the current state of vowels.
A map to store the first occurrence of each bitmask. Initialize it with the bitmask 0 at index -1.

Traverse the String:

For each character, update the bitmask based on whether it is a vowel.
If the bitmask has been seen before, calculate the length of the substring between the first occurrence of this bitmask and the current position.
Track the maximum length of such substrings.
*/
import java.util.HashMap;
class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initial state with no vowels seen (bitmask 0) at index -1
        map.put(0, -1);

        int bitmask = 0;
        int maxLength = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Update the bitmask based on the current character
            if (c == 'a') {
                bitmask ^= (1 << 0); // Toggle the first bit for 'a'
            } else if (c == 'e') {
                bitmask ^= (1 << 1); // Toggle the second bit for 'e'
            } else if (c == 'i') {
                bitmask ^= (1 << 2); // Toggle the third bit for 'i'
            } else if (c == 'o') {
                bitmask ^= (1 << 3); // Toggle the fourth bit for 'o'
            } else if (c == 'u') {
                bitmask ^= (1 << 4); // Toggle the fifth bit for 'u'
            }

            // If this bitmask was seen before, calculate the length of the substring
            if (map.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - map.get(bitmask));
            } else {
                // Otherwise, store the first occurrence of this bitmask
                map.put(bitmask, i);
            }
        }

        return maxLength;
    }
}