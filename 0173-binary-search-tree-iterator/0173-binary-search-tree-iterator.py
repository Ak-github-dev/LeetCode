"""
Approach:
In-order Traversal:

In-order traversal of a BST gives nodes in sorted (ascending) order.
The idea is to simulate this traversal using an iterative approach with a stack.
Stack Usage:

A stack is used to keep track of nodes. The stack simulates the recursive call stack of an in-order traversal.
Initially, all the leftmost nodes from the root down to the smallest node are pushed onto the stack.
For each next() call, the top node is popped from the stack (this is the next smallest node), and if this node has a right child, all of its left descendants are pushed onto the stack.
Operations:

next(): Pops the top element from the stack and returns its value. Then processes its right subtree.
hasNext(): Checks if there are any nodes left in the stack.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, root):
        # Add all leftmost nodes to the stack
        while root:
            self.stack.append(root)
            root = root.left

    def next(self):
        """
        :rtype: int
        """
        # Node at the top of the stack is the next smallest element
        topmost_node = self.stack.pop()
        # If the node has a right child, process the leftmost nodes of the right subtree
        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)
        return topmost_node.val

    def hasNext(self):
        """
        :rtype: bool
        """
        # If stack is not empty, we have a next element
        return len(self.stack) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()