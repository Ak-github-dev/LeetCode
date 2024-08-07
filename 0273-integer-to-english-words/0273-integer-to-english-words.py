"""
Steps to Approach:

Define Words for Basic Units:

Create mappings for basic units like ones, tens, and teens.

Define Words for Larger Units:

Define the words for thousand, million, and billion.

Helper Function for Small Numbers:

Write a helper function to convert numbers less than 1000 into words.
Iterate Through the Number:

Break down the number into chunks of thousands and use the helper function to convert each chunk into words.
"""
"""
Complexity Analysis:
Time Complexity: 
O(log base(1000) n), which simplifies to O(1) because the number of chunks (up to billions) is constant and small.

Space Complexity: 
O(1), because we are using a fixed amount of extra space for storing words and the result string.
"""
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"

        # Words for basic units
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]
        
        def helper(num):
            if num == 0:
                return ""
            elif num < 20:
                return below_20[num] + " "
            elif num < 100:
                return tens[num // 10] + " " + helper(num % 10)
            else:
                return below_20[num // 100] + " Hundred " + helper(num % 100)
        
        result = ""
        for i in range(len(thousands)):
            if num % 1000 != 0:
                result = helper(num % 1000) + thousands[i] + " " + result
            num //= 1000
        
        return result.strip()