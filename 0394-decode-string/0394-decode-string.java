/*
Approach:

Stack-Based Approach:

Use two stacks: one to store numbers (countStack) and another to store strings (stringStack).
As you traverse the input string, you push numbers and strings onto the stacks.
When you encounter a closing bracket ], you start to pop from the stacks, decode the string inside the brackets, and repeat it as many times as indicated by the number before the brackets.

Traversal and Decoding:

Traverse through each character in the string:
If the character is a digit, calculate the complete number.
If the character is [, push the current number to countStack and the current string to stringStack, then reset the current string.
If the character is ], pop the number from countStack, pop the string from stringStack, and append the repeated current string to the popped string.
If the character is a letter, simply append it to the current string.
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // Construct the number k
            } else if (ch == '[') {
                countStack.push(k); // Push the number to countStack
                stringStack.push(currentString); // Push the current string to stringStack
                currentString = new StringBuilder(); // Reset currentString
                k = 0; // Reset k
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString); // Repeat the string currentK times
                }
                currentString = decodedString; // Update the current string
            } else {
                currentString.append(ch); // Append the character to currentString
            }
        }

        return currentString.toString();
    }
}