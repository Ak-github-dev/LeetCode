/*
Approach:

Maximize Usage of the Highest Frequency Letters:

Since we want the longest string possible, we should try to use the letter with the highest available count as much as possible.

Greedy Approach:

Always choose the letter with the highest count that does not result in three consecutive occurrences of that letter.
After choosing that letter, reduce its available count and repeat the process.

Handle Different Letters:

At each step, if the current most frequent letter can't be used (due to the "three consecutive" rule), use the second most frequent letter and update the available counts accordingly.

Terminate:

Stop when no more valid letters can be added without violating the rules.
*/
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Priority Queue to always pick the letter with the highest count
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        // Add counts for 'a', 'b', and 'c' to the queue
        if (a > 0) pq.add(new int[]{'a', a});
        if (b > 0) pq.add(new int[]{'b', b});
        if (c > 0) pq.add(new int[]{'c', c});
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            // First, pick the character with the most remaining count
            int[] first = pq.poll();
            
            // Check if the last two characters are the same as this one
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first[0] && result.charAt(result.length() - 2) == first[0]) {
                // If we can't use this character, pick the next one if available
                if (pq.isEmpty()) break;  // No other options, terminate
                
                int[] second = pq.poll();
                result.append((char) second[0]);
                second[1]--;
                
                // Put the second character back into the queue if there's any left
                if (second[1] > 0) pq.add(second);
                
                // Put the first one back to consider for future
                pq.add(first);
            } else {
                // If it's safe to use the first character, add it to the result
                result.append((char) first[0]);
                first[1]--;
                
                // Put it back to the queue if there's any left
                if (first[1] > 0) pq.add(first);
            }
        }
        
        return result.toString();
    }
}