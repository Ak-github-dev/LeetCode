/*
Approach:

Use a Stack:

The stack will store indices of the heights array.
We will iterate through each bar and calculate the area of the largest rectangle possible with the bar at the top of the stack as the smallest (height) bar.

Calculate Area:

For each bar, if it is shorter than the bar at the top of the stack, we keep popping from the stack, calculating the area for each popped bar as the smallest bar in a rectangle.
The width of the rectangle is determined by the difference between the current index and the index of the new top of the stack after popping.

Final Step:

After processing all bars, we may still have bars left in the stack. We continue to pop them out and calculate the area in the same way.
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // If the current bar is shorter than the bar at the stack's top
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Calculate area for bars left in the stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}