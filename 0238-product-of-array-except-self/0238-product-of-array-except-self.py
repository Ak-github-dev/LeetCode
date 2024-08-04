"""
Steps:

Calculate Prefix Products:

Create an array left_products where each element at index i contains the product of all the elements to the left of i.

Calculate Suffix Products and Final Result:

Use a variable to keep track of the suffix product as we iterate from the end of the array to the beginning. Multiply this suffix product with the corresponding prefix product to get the final result.


Detailed Implementation:

Prefix Product Calculation:

Initialize an array left_products with the same length as the input array nums.
Set left_products[0] to 1 (since there are no elements to the left of the first element).
Iterate through the array from left to right, calculating the cumulative product of all elements to the left of the current index.

Suffix Product Calculation and Result Construction:

Initialize a variable right_product to 1.
Iterate through the array from right to left. For each element, multiply the right_product with the corresponding left_product to get the final product for that index.
Update the right_product by multiplying it with the current element.
"""
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        if n == 0:
            return []

        # Initialize the left_products array
        left_products = [1] * n

        # Calculate the prefix products
        for i in range(1, n):
            left_products[i] = left_products[i - 1] * nums[i - 1]

        # Initialize the right_product variable
        right_product = 1

        # Calculate the suffix products and final result
        for i in range(n - 1, -1, -1):
            left_products[i] = left_products[i] * right_product
            right_product *= nums[i]

        return left_products
