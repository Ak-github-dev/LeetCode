"""
Steps:

Define Mappings:

Create a list of tuples that map specific integer values to their Roman numeral representations, ordered from the highest to the lowest value.

Iterate and Construct the Roman Numeral:

Iterate through the mappings, subtracting the value from the input number and appending the corresponding Roman numeral to the result string until the number is reduced to zero.
"""
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # Define the mappings of integer values to Roman numerals
        value_to_roman = [
            (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'),
            (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
            (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'),
            (1, 'I')
        ]
        
        # Initialize the result string
        result = ""
        
        # Iterate through the mappings
        for value, roman in value_to_roman:
            while num >= value:
                result += roman
                num -= value
        
        return result