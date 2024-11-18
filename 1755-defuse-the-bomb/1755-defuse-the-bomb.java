class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            // If k == 0, all elements become 0
            return result; // All elements are 0 by default in a new array
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            if (k > 0) {
                // Sum of the next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else { // k < 0
                // Sum of the previous |k| elements
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}