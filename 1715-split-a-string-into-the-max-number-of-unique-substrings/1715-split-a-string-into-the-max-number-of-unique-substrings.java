/*
Approach:

We will use a HashSet to store unique substrings as we recursively try splitting the string.

At each step, we will attempt to form a new substring starting from the current index and check if it has already been used.

If not, we add the substring to the set and continue splitting the rest of the string recursively, while keeping track of the maximum number of unique substrings.
We backtrack by removing the last substring added from the set before trying new substrings.

*/
class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    private int backtrack(int start, String s, HashSet<String> seen) {
        // If we've reached the end of the string, return the size of the set (number of unique substrings)
        if (start == s.length()) {
            return seen.size();
        }

        int maxCount = 0;
        
        // Try every possible substring starting from 'start' index
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            
            // If this substring is not already used, proceed
            if (!seen.contains(substring)) {
                seen.add(substring);  // Add the substring to the set of used substrings
                // Recursively try to split the rest of the string
                maxCount = Math.max(maxCount, backtrack(end, s, seen));
                seen.remove(substring);  // Backtrack: remove the substring from the set
            }
        }
        return maxCount;
    }
}