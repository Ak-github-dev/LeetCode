class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        # Dictionary to hold the matching pairs
        matching_bracket = {')': '(', '}': '{', ']': '['}

        for char in s:
            if char in matching_bracket.values():  # If it's an opening bracket
                stack.append(char)
            elif char in matching_bracket.keys():  # If it's a closing bracket
                if stack and stack[-1] == matching_bracket[char]:
                    stack.pop()
                else:
                    return False
            else:
                return False  # In case of any other characters which should not be present

        return len(stack) == 0