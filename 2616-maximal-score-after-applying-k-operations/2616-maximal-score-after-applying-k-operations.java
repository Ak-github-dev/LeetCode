/*
Approach:

Greedy Strategy:

Since we want to maximize the score, we should always pick the largest available number in the array for each operation.
After picking the largest number, we update it by replacing it with ceil(nums[i] / 3).
Continue this process for k operations.

Efficient Selection:

Since we need to repeatedly pick the largest number, a max-heap (priority queue) is ideal. However, Java's PriorityQueue implements a min-heap by default, so we can use negative values to simulate a max-heap.

Updating the Element:

After selecting the largest element, we calculate ceil(nums[i] / 3). This is the next value that should be pushed back into the heap.


Algorithm:
Initialize a max-heap by pushing negative values of the elements (to simulate max-heap).
For each of the k operations:
Pop the largest element from the heap.
Add it to the score.
Calculate the new value by applying ceil(nums[i] / 3) and push the updated value back into the heap.
Return the accumulated score after k operations.
*/
class Solution {
    public long maxKelements(int[] nums, int k) {
        // Max-heap to store the largest elements (simulated by using negative values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements to the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0;

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Pop the largest element
            int current = maxHeap.poll();
            // Add the current largest element to the score
            score += current;

            // Update the value (ceil of division by 3)
            int updatedValue = (current + 2) / 3; // This is equivalent to ceil(current / 3)
            
            // Push the updated value back into the max-heap
            maxHeap.add(updatedValue);
        }
        
        return score;
    }
}