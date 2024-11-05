class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int n = s.length();
        
        // Iterate through the string in pairs
        for (int i = 0; i < n; i += 2) {
            // Get characters at positions i and i+1
            char firstChar = s.charAt(i);
            char secondChar = s.charAt(i + 1);
            
            // If the characters are different, increment changes
            if (firstChar != secondChar) {
                changes++;
            }
        }
        
        return changes;
    }
}