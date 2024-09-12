/*
Approach:

Create a Set of Allowed Characters:

First, convert the allowed string into a set of characters for quick lookup.

Check Consistency:

For each word in the words array, check if every character in the word exists in the allowed set.
If all characters of a word are present in the allowed set, the word is consistent.

Count the Consistent Words:

Count the number of consistent words.
*/
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a set of allowed characters for fast lookup
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;

        // Check each word for consistency
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}