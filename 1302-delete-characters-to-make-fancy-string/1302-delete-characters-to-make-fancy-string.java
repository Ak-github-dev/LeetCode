class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            int n = result.length();
            // Check if adding the current character would result in three consecutive characters
            if (n >= 2 && result.charAt(n - 1) == s.charAt(i) && result.charAt(n - 2) == s.charAt(i)) {
                continue; // Skip adding the character
            }
            // Append the character as it doesn't violate the rule
            result.append(s.charAt(i));
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    }
}