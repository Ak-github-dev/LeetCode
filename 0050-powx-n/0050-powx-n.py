"""
Approach:

Handle Special Cases:

If n is 0, the result is 1 (any number raised to the power 0 is 1).
If x is 0 and n is positive, the result is 0 (0 raised to any positive power is 0).

Handle Negative Exponent:

If n is negative, convert the problem to a positive exponent by using the property 
x^(-n)=1/(x^(n))

Exponentiation by Squaring:

If n is even,x^n= (x^2)^(n/2) 
If n is odd, x^n=x* x ^(n-1)
"""
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        def quickMul(x, n):
            if n == 0:
                return 1.0
            half = quickMul(x, n // 2)
            if n % 2 == 0:
                return half * half
            else:
                return half * half * x
        
        if n < 0:
            x = 1 / x
            n = -n
        return quickMul(x, n)