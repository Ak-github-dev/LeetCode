/*
Approach:

Two Pointers: Use two pointers to traverse through both strings simultaneously.
One pointer will traverse word1 and the other will traverse word2.

Merge Characters: At each step, append one character from word1 followed by one character from word2 to the result.

Handle Remaining Characters: If one string is longer than the other, append the remaining characters from the longer string to the result after the alternating merge is complete.

Return Result: Finally, return the merged string.
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        
        // Alternate between characters of word1 and word2
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                merged.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                merged.append(word2.charAt(j));
                j++;
            }
        }
        
        return merged.toString();
    }
}