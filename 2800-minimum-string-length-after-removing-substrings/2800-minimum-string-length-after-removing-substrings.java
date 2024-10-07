/*
Approach:

Stack-Based Simulation: The string can be processed character by character while using a stack. This allows us to keep track of characters that haven't been processed yet and allows efficient removal of "AB" and "CD" as they are encountered.

Why Use a Stack?: A stack provides a way to simulate the operations where we remove a substring if we see a pattern that fits "AB" or "CD". For example, if we see "A" followed by "B" (or "C" followed by "D"), we can remove both and continue processing the rest of the string.


Detailed Steps:

Iterate through the string.

For each character, check the top of the stack.

If the current character forms the substrings "AB" or "CD" with the top of the stack, pop the stack.

Otherwise, push the current character onto the stack.

After processing the entire string, the remaining characters in the stack are the ones that couldn't be removed.
*/
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Traverse the string character by character
        for (char c : s.toCharArray()) {
            // Check if we can remove a substring
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    // Pop the stack as we found a removable pair
                    stack.pop();
                } else {
                    // Otherwise, push the current character
                    stack.push(c);
                }
            } else {
                // If the stack is empty, just push the character
                stack.push(c);
            }
        }
        
        // The size of the stack is the minimum length of the resulting string
        return stack.size();
    }
}