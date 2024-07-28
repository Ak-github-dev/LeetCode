"""
Implementation Strategy:

Two Stacks:

Main Stack (stack): This will function like a regular stack, holding all the pushed elements.
Min Stack (minStack): This stack will keep track of the minimum elements. Each element in minStack will be the minimum of all elements in the stack from the bottom up to that point.

Operations:

push(int val): Push val onto the main stack. If minStack is empty or val is less than or equal to the top of minStack, also push val onto minStack.
pop(): Pop the top element from the main stack. If the popped element is the same as the top of minStack, also pop from minStack.
top(): Return the top element of the main stack.
getMin(): Return the top element of minStack, which represents the current minimum element of the stack.
"""

class MinStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []
        self.minStack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        """
        Push element val onto stack.
        """
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        """
        Removes the element on top of the stack.
        """
        if self.stack:
            val = self.stack.pop()
            if val == self.minStack[-1]:
                self.minStack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        """
        Get the top element.
        """
        return self.stack[-1] if self.stack else None
        

    def getMin(self):
        """
        :rtype: int
        """
        """
        Retrieve the minimum element in the stack.
        """
        return self.minStack[-1] if self.minStack else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()