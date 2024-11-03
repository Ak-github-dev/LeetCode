class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are different; if so, s cannot be rotated to match goal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself to include all possible rotations
        String doubled = s + s;
        
        // Check if goal is a substring of the concatenated result
        return doubled.contains(goal);
    }
}