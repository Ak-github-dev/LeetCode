/*
Approach:

Stack-Based Approach:

Use a stack to keep track of the characters in the string as you iterate through it.
When you encounter a non-star character, push it onto the stack.
When you encounter a star *, pop the top element from the stack (which represents removing the closest non-star character to the left).

Final String Construction:

After processing the entire string, the stack will contain the remaining characters in the correct order.
Convert the stack to a string to get the final result.
*/
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the closest non-star character
                }
            } else {
                stack.push(c); // Add non-star characters to the stack
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}