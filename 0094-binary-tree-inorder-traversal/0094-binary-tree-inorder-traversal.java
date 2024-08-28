/*
Approach:

Inorder Traversal:

In an inorder traversal, you visit the left subtree first, then the root node, and finally the right subtree.

Iterative Approach using a Stack:

Use a stack to simulate the recursive call stack.
Start from the root and push all the left nodes onto the stack until you reach the leftmost node.
Pop nodes from the stack, add their values to the result, and move to their right subtree.
Repeat the process until the stack is empty and all nodes are processed.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Current must be null at this point
            current = stack.pop();
            result.add(current.val); // Add the node value to the result
            
            // We have visited the node and its left subtree, now go to the right subtree
            current = current.right;
        }
        
        return result;
    }
}