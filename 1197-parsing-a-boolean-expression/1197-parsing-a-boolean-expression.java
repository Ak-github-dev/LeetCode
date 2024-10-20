class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                // Process the expression inside the parentheses
                Stack<Character> temp = new Stack<>();
                
                // Pop elements until '(' is found
                while (stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                
                // Pop the '('
                stack.pop();
                
                // Get the operator before '('
                char operator = stack.pop();
                
                // Evaluate the sub-expression based on the operator
                char result = evaluate(operator, temp);
                
                // Push the result back onto the stack
                stack.push(result);
                
            } else if (c != ',') {
                // Push all non-comma characters onto the stack
                stack.push(c);
            }
        }
        
        // The final result should be on the stack
        return stack.pop() == 't';
    }
    
    private char evaluate(char operator, Stack<Character> operands) {
        if (operator == '!') {
            // NOT operation, only one operand is expected
            return operands.pop() == 't' ? 'f' : 't';
        } else if (operator == '&') {
            // AND operation, evaluate all operands
            while (!operands.isEmpty()) {
                if (operands.pop() == 'f') {
                    return 'f'; // If any operand is false, the result is false
                }
            }
            return 't'; // All operands are true
        } else if (operator == '|') {
            // OR operation, evaluate all operands
            while (!operands.isEmpty()) {
                if (operands.pop() == 't') {
                    return 't'; // If any operand is true, the result is true
                }
            }
            return 'f'; // All operands are false
        }
        
        // This should never happen
        return 'f';
    }
}