"""
Approach:

Iterate Through the String:

We traverse the string character by character.
We handle numbers, operators (+ or -), and parentheses differently.

Handling Numbers:

If we encounter a digit, we build the number (since the number may be more than one digit long).
Once we finish reading the number, we apply the current sign (+ or -) and add the number to the result.

Handling Signs:

The + sign means add the next number directly to the result.
The - sign means subtract the next number from the result.
Handling Parentheses:

When encountering a (, push the current result and the current sign onto the stack, then reset the result and sign for the new sub-expression.
When encountering a ), finish the current sub-expression by adding the result to the top value on the stack.

Final Calculation:

After iterating through the string, the final result will be the evaluated expression.
"""
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        result = 0
        number = 0
        sign = 1  # 1 means positive, -1 means negative

        for char in s:
            if char.isdigit():
                number = number * 10 + int(char)
            elif char == '+':
                result += sign * number
                number = 0
                sign = 1
            elif char == '-':
                result += sign * number
                number = 0
                sign = -1
            elif char == '(':
                stack.append(result)
                stack.append(sign)
                result = 0
                sign = 1
            elif char == ')':
                result += sign * number
                number = 0
                result *= stack.pop()  # pop the sign before the parenthesis
                result += stack.pop()  # pop the result calculated before the parenthesis
            # we ignore spaces
        result += sign * number  # add the last number to the result
        return result