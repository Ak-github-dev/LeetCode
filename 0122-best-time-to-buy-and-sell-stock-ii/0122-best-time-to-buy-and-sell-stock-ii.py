"""
Steps:
Initialize a Variable for Total Profit: Start with total_profit set to 0.
Loop Through Prices:
From the first day to the second to last day, check if the price of the next day is higher than the current day.
If true, add the difference to total_profit.
"""
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        total_profit = 0
    
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                total_profit += prices[i] - prices[i - 1]
        
        return total_profit