/*
Approach:

Push: Add elements to the stack only if the stack size is less than the maxSize.

Pop: Return the top of the stack if the stack is not empty, and apply any 
increments to the topmost element before popping it.

Increment: Update the auxiliary array (increment[]) to track the increment operations efficiently. This avoids needing to iterate over the stack repeatedly when applying increments.
*/
class CustomStack {
    private int[] stack;
    private int[] increment;
    private int size;
    private int maxSize;

    // Constructor to initialize the stack with the given max size.
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.size = 0;
    }
    
    // Method to push an element to the top of the stack if not full.
    public void push(int x) {
        if (size < maxSize) {
            stack[size] = x;
            size++;
        }
    }
    
    // Method to pop the top of the stack. It also applies any pending increments.
    public int pop() {
        if (size == 0) {
            return -1;
        }
        size--; // Decrement size to pop the top element.
        int result = stack[size] + increment[size]; // Apply the pending increment.
        if (size > 0) {
            increment[size - 1] += increment[size]; // Carry over the increment to the next lower element.
        }
        increment[size] = 0; // Reset increment for this position.
        return result;
    }
    
    // Method to increment the bottom k elements by val.
    public void increment(int k, int val) {
        int limit = Math.min(k, size); // Only increment the first k elements or up to the current stack size.
        if (limit > 0) {
            increment[limit - 1] += val; // Accumulate the increment for the lowest relevant element.
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */