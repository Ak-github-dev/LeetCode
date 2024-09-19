/*
Approach:

Recursive Splitting:

For every operator in the expression, split the expression into two parts: the left side (before the operator) and the right side (after the operator).
Recursively evaluate both sides and combine their results using the operator.

Base Case:

If the expression is a single number, return that number as the result.

Combine Results:

For each operator, combine the results of the left and right parts using that operator and collect all the possible results.
*/
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Iterate through the expression to find an operator
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // When we find an operator, we split the expression
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into left and right parts
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);
                
                // Recursively compute all the possible results for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);
                
                // Combine the results from the left and right using the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // If there were no operators, the expression is a single number, so add it to the result
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}