"""
Approach:

Initialize Counters: Start by initializing two counters, five and ten, to keep track of the number of $5 and $10 bills you have.

Iterate through the Bills: Loop through each bill in the bills array.
If a customer pays with a $5 bill, increase the five counter.
If a customer pays with a $10 bill, you need to give them $5 as change:
    Check if you have a $5 bill. If you do, decrease the five counter and increase the ten counter. If not, return false because you can't provide the correct change.
If a customer pays with a $20 bill, you need to give them $15 as change:
Prefer giving one $10 bill and one $5 bill as change (if you have both).
If you don't have a $10 bill but have three $5 bills, give three $5 bills as change.
If you can't provide the correct change, return false.

Final Check: If you manage to go through the entire array without issues, return true.
"""
class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        five, ten = 0, 0
    
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five == 0:
                    return False
                five -= 1
                ten += 1
            else:  # bill == 20
                if ten > 0 and five > 0:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        
        return True