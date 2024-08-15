"""
Steps:
Start with an empty string and recursively try to add ( or ).
Maintain counters for the number of ( and ) added so far.
Stop the recursion when the length of the current string is 2 * n (because there will be exactly n opening and n closing parentheses).
"""
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
    
        def backtrack(current_string, open_count, close_count):
            # If the current string length equals 2 * n, we have a valid combination
            if len(current_string) == 2 * n:
                result.append(current_string)
                return
            
            # If we can add an opening parenthesis, do it
            if open_count < n:
                backtrack(current_string + "(", open_count + 1, close_count)
            
            # If we can add a closing parenthesis without unbalancing, do it
            if close_count < open_count:
                backtrack(current_string + ")", open_count, close_count + 1)
        
        # Start the backtracking process with an empty string
        backtrack("", 0, 0)
        
        return result