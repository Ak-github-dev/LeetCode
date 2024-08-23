/*
Approach:

Understanding the Problem:

Positive asteroids move to the right, and negative asteroids move to the left.
When a right-moving asteroid and a left-moving asteroid collide, the one with the smaller size explodes. If they are of equal size, both explode.

Stack-Based Approach:

You can use a stack to simulate the asteroid collisions.

As you iterate through the array:
If the current asteroid is moving to the right (> 0), push it onto the stack.
If the current asteroid is moving to the left (< 0), check for collisions:
While the stack is not empty and the top of the stack is a right-moving asteroid, compare their sizes.
If the right-moving asteroid is larger, the left-moving asteroid explodes.
If the right-moving asteroid is smaller, pop the stack (the right-moving asteroid explodes).
If they are the same size, both explode, so pop the stack and skip the current asteroid.
After processing all asteroids, the stack will contain the remaining asteroids.
*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop(); // Right-moving asteroid explodes
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // Both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}