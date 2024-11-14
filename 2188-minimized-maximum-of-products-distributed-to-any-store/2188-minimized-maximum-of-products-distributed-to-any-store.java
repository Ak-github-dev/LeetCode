class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt(); // Max quantity as initial high bound
        int result = high;
        
        // Binary search on possible values of x (max products per store)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if we can distribute with maximum `mid` products per store
            if (canDistribute(n, quantities, mid)) {
                result = mid; // If possible, try for a smaller x
                high = mid - 1;
            } else {
                low = mid + 1; // Otherwise, increase x
            }
        }
        
        return result;
    }

    // Helper function to check if we can distribute with maximum `maxPerStore` products per store
    private boolean canDistribute(int n, int[] quantities, int maxPerStore) {
        int requiredStores = 0;
        
        for (int quantity : quantities) {
            // Calculate stores needed for this product type with `maxPerStore` limit
            requiredStores += (quantity + maxPerStore - 1) / maxPerStore;
            if (requiredStores > n) return false; // Too many stores needed
        }
        
        return requiredStores <= n;
    
    }
}