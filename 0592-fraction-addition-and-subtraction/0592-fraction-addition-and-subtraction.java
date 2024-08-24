/*
Approach:

Parsing the Expression:

The expression contains fractions separated by + or -. Each fraction is in the format numerator/denominator.
We need to parse each fraction and apply the addition or subtraction accordingly.

LCM for Addition/Subtraction:

When adding or subtracting fractions, the key step is to find a common denominator (Least Common Multiple, LCM) for the fractions.

Simplification:

After performing the addition or subtraction, the resulting fraction should be simplified to its irreducible form. This can be done by dividing the numerator and the denominator by their Greatest Common Divisor (GCD).
*/
/*
Explanation:

Sign Handling:

The sign variable determines whether the current fraction is added or subtracted. It is set based on whether the current character is + or -.

Parsing Numerator and Denominator:

The numerator and denominator are extracted from the string by iterating through the characters.

LCM Calculation:

For each new fraction, update the current numerator and denominator using the formula:
new numerator=numerator×denominator of new fraction+sign×numerator of new fraction×denominator

new denominator=denominator×denominator of new fraction

Then simplify the result using the GCD.

Final Result:

After processing all the fractions, the resulting numerator and denominator form the irreducible fraction.
*/
class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int i = 0, n = expression.length();
        
        while (i < n) {
            // Read the sign
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            // Read the numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Skip the '/'
            i++;
            
            // Read the denominator
            int den = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Update the current numerator and denominator
            numerator = numerator * den + sign * num * denominator;
            denominator *= den;
            
            // Simplify the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}