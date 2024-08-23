/*
Approach:

Understanding the Problem:

The diameter of a binary tree is the length of the longest path between any two nodes in the tree.
The path may pass through the root or not.
The length of the path is measured by the number of edges between nodes.

Recursive Depth-First Search (DFS) Approach:

Use a recursive function to calculate the depth of each subtree.
While calculating the depth, compute the diameter as the sum of the left and right subtree depths.
The final diameter will be the maximum value encountered during these calculations.

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
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    }
    
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        
        // Update the diameter if the path through the current node is larger
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        // Return the depth of the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}