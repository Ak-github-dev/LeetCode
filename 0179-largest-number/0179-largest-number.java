/*
Approach:

Custom Sorting:

Instead of sorting the numbers based on their numeric values, we should sort them based on their concatenated string values.
For example, given two numbers x and y, if xy (x concatenated with y) is larger than yx, then x should come before y in the final result.

Edge Case:

If the input consists only of zeros (e.g., [0, 0, 0]), the result should be "0" instead of multiple zeros.
*/
class Solution {
    public String largestNumber(int[] nums) {
        // Convert the numbers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array with a custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join the sorted numbers into a single string
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }
}