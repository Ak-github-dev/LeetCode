/*
Algorithm:

Traverse through the string.

For each character:
    If it's an opening parenthesis (, increment open.
    If it's a closing parenthesis ), check:
        If there are unmatched opening parentheses (open > 0), match it with an opening parenthesis (i.e., decrement open).
        If there are no unmatched opening parentheses (open == 0), increment the close counter because this closing parenthesis doesn't have a match and will need an extra opening parenthesis to balance it.

After traversing the string, the number of unmatched opening parentheses (open) will tell us how many closing parentheses are needed to balance the unmatched opening parentheses.

The result is the sum of open and close, which tells us the minimum number of parentheses that need to be added to make the string valid.
*/
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // to track unmatched '('
        int close = 0; // to track unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;  // Increment for every opening parenthesis
            } else if (c == ')') {
                if (open > 0) {
                    open--;  // Match with an opening parenthesis
                } else {
                    close++;  // Increment for unmatched closing parenthesis
                }
            }
        }

        // Return total unmatched parentheses (both open and close)
        return open + close;
    }
}