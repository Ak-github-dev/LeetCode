/*
Algorithm:

Initialize a min-heap with the first element from each list and set current_max to the maximum of those first elements.
Pop the smallest element from the heap, and compute the current range.
Update the smallest range if the current range is better.
Push the next element from the list of the popped element into the heap.
Repeat steps 2-4 until one of the lists is exhausted.
*/
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap to track the smallest current element
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;

        // Initialize the heap with the first element from each list and find the initial currentMax
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }

        // To store the best range
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // Process the heap
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();  // Get the smallest element from the heap
            int currentMin = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            // Update the smallest range if the current range is better
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }

            // If the current list has more elements, push the next element into the heap
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                currentMax = Math.max(currentMax, nextVal);  // Update the current maximum
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}