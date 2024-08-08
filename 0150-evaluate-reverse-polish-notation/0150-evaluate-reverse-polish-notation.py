"""
Steps:

Initialization: Use a stack to keep track of the numbers.

Process Tokens:
Iterate through each token in the input list.
If the token is a number, push it onto the stack.
If the token is an operator, pop the necessary number of operands from the stack, perform the operation, and push the result back onto the stack.

Operators: Handle the four basic arithmetic operators (+, -, *, /).

Final Result: The final result will be the only remaining element in the stack.
"""
"""
Correction:

use int(a / b) for division can result in incorrect results for negative numbers because it truncates towards zero. The correct approach is to use the // operator, which performs floor division and is more consistent with the problem's requirement to truncate towards zero.
"""
class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
    
        for token in tokens:
            if token in {"+", "-", "*", "/"}:
                # Pop the last two operands
                b = stack.pop()
                a = stack.pop()
                if token == "+":
                    result = a + b
                elif token == "-":
                    result = a - b
                elif token == "*":
                    result = a * b
                elif token == "/":
                    # Division should truncate towards zero
                    result = int(a / b) if a * b >= 0 else -(-a // b)
                stack.append(result)
            else:
                # If it's a number, push onto the stack
                stack.append(int(token))
        
        # The final result will be the only element left in the stack
        return stack[0]