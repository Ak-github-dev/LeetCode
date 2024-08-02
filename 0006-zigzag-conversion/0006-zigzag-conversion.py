"""
Steps:
Initialize an array of empty strings for each row.
Iterate through each character in the input string, appending it to the current row.
Change the direction when reaching the top or bottom row.
Concatenate all rows to get the final converted string.
"""
class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s

        # Create an array for each row
        rows = [''] * numRows
        current_row = 0
        going_down = False

        # Iterate through each character in the string
        for char in s:
            rows[current_row] += char
            
            # Change direction when reaching the top or bottom row
            if current_row == 0 or current_row == numRows - 1:
                going_down = not going_down
            
            # Move to the next row
            current_row += 1 if going_down else -1

        # Concatenate all rows to get the final result
        return ''.join(rows)