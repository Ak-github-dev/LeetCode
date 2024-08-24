/*
Approach:

Understanding the Problem:

The complement of a number is obtained by flipping all bits in its binary representation. For example, the binary representation of 5 is 101, and its complement is 010, which is 2.

Algorithm:

Calculate the number of bits required to represent the integer.
Create a bitmask that has all bits set to 1 for the length of the binary representation of the number.
XOR the number with this bitmask to flip all its bits.
*/
class Solution {
    public int bitwiseComplement(int n) {
        // Calculate the bit length of num
        int bitLength = Integer.toBinaryString(n).length();
        
        // Create a bitmask with all bits set to 1 of the same length as num
        int bitmask = (1 << bitLength) - 1;
        
        // XOR num with the bitmask to get the complement
        return n ^ bitmask;
    }
}