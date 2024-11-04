class Solution {
    public String compressedString(String word) {
        // Initialize the result string builder for efficient concatenation
        StringBuilder comp = new StringBuilder();
        
        // Index to traverse the word
        int i = 0;
        
        while (i < word.length()) {
            char currentChar = word.charAt(i);  // Current character we're counting
            int count = 0;                      // Count for consecutive characters
            
            // Count up to 9 consecutive characters of the same type
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            
            // Append the count and character to the result
            comp.append(count).append(currentChar);
        }
        
        // Convert StringBuilder to String and return the result
        return comp.toString();
    }
}