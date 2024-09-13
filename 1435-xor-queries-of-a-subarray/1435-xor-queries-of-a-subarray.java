/*
Approach:

Use Prefix XOR:

Instead of recomputing the XOR for every query from scratch (which could be inefficient), we can use a prefix XOR array.
The prefix XOR array stores the XOR of elements from the start of the array up to the current index.
With this prefix XOR, the XOR of a subarray from left to right can be computed as:
XOR(left, right) = prefixXOR[right] ^ prefixXOR[left - 1] (if left > 0)
If left == 0, then XOR(left, right) = prefixXOR[right].

Steps:

Create the Prefix XOR Array:

For each index i, prefixXOR[i] is the XOR of all elements from arr[0] to arr[i].

Answer the Queries:

For each query [left, right], use the prefix XOR to compute the XOR of the subarray in constant time.
*/
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Step 1: Create the prefix XOR array
        int n = arr.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }

        // Step 2: Answer each query using the prefix XOR array
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            if (left == 0) {
                result[i] = prefixXOR[right];
            } else {
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }

        return result;
    }
}