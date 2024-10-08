class Solution {
    public int minSwaps(String s) {
        int imbalance = 0;  // To track unbalanced closing brackets ']'
        int swaps = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance++;  // A balanced opening bracket
            } else {
                imbalance--;  // A closing bracket might cause imbalance
            }
            
            if (imbalance < 0) {
                swaps++;  // We need a swap
                imbalance = 1;  // After the swap, assume we fix one imbalance
            }
        }
        
        return swaps;
    }
}