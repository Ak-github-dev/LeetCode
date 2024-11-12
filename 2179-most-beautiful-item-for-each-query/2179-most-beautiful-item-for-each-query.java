class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price to allow binary search on prices
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Process items to get maximum beauty at each price point
        TreeMap<Integer, Integer> priceToMaxBeauty = new TreeMap<>();
        int maxBeautySoFar = 0;
        
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            // Update max beauty so far
            maxBeautySoFar = Math.max(maxBeautySoFar, beauty);
            // Record the highest beauty seen up to this price point
            priceToMaxBeauty.put(price, maxBeautySoFar);
        }
        
        // Prepare the answer array
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int queryPrice = queries[i];
            // Find the highest price less than or equal to queryPrice
            Map.Entry<Integer, Integer> entry = priceToMaxBeauty.floorEntry(queryPrice);
            // If such an entry exists, set the max beauty for this query; otherwise, set it to 0
            answer[i] = entry != null ? entry.getValue() : 0;
        }
        
        return answer;
    }
}