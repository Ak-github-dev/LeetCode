/*
Approach:

Split the Sentence: Use the space as a delimiter to split the sentence into individual words.

Check Conditions:
Iterate through the words, checking that the last character of each word matches the first character of the following word.
Additionally, ensure that the last character of the last word matches the first character of the first word.

Return the Result: If all conditions are met, return true; otherwise, return false.
*/
class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Check each consecutive word pair
        for (int i = 0; i < words.length; i++) {
            // Find the current and next word (wrap around to the first word for the last word's next word)
            String currentWord = words[i];
            String nextWord = words[(i + 1) % words.length];
            
            // Check if the last character of current word matches the first character of next word
            if (currentWord.charAt(currentWord.length() - 1) != nextWord.charAt(0)) {
                return false;
            }
        }
        
        // All checks passed, the sentence is circular
        return true;
    }
}