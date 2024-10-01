/*
Approach:
Remainders when divided by k: For each element arr[i] in the array, the key property to check is the remainder when arr[i] is divided by k. This can be obtained using arr[i] % k. This remainder tells us how far arr[i] is from being a multiple of k.

Pairing Strategy: For two elements to form a valid pair whose sum is divisible by k, their remainders must add up to k (or 0, in the case of elements that are already divisible by k). Specifically:

If an element has a remainder r when divided by k, it needs a counterpart with remainder k - r to form a pair.
Special case: If the remainder is 0, the element can only be paired with another element with remainder 0.
Frequency Counting: We count the frequency of each remainder using an array remCount of size k. For example, if remCount[r] gives the count of elements that have a remainder of r when divided by k.

Validating Pairing: After computing the remainders, we check if the frequency of elements with remainder r matches the frequency of elements with remainder k - r for all r.

Algorithm:
Compute the remainder of each element in arr when divided by k and maintain a count of these remainders in the remCount array.
For each remainder r from 0 to k//2, check the following:
If r == 0: The count of elements with remainder 0 should be even since they can only pair among themselves.
For other values of r: The count of elements with remainder r should match the count of elements with remainder k - r.
*/
class Solution {
    public boolean canArrange(int[] arr, int k) {
         int[] remCount = new int[k];

        // Count the remainders when elements of arr are divided by k
        for (int num : arr) {
            int rem = num % k;
            if (rem < 0) {
                rem += k;  // Ensure the remainder is non-negative
            }
            remCount[rem]++;
        }

        // Now, check if the counts match for valid pairing
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                // Elements with remainder 0 must pair with themselves, so the count must be even
                if (remCount[i] % 2 != 0) {
                    return false;
                }
            } else {
                // Elements with remainder i must have a matching count with remainder k - i
                if (remCount[i] != remCount[k - i]) {
                    return false;
                }
            }
        }

        return true;
    }
}