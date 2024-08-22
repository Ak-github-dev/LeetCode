/*
Approach:

Understanding the Problem:

The maximum depth of a binary tree is the length of the longest path from the root node to a leaf node.
A leaf node is a node with no children.

Recursive Approach:

You can solve this problem using a simple recursive approach.
The idea is to explore the depth of the left and right subtrees and take the maximum of the two. Then, add 1 to account for the current node.
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
    public int maxDepth(TreeNode root) {
        // Base case: If the tree is empty, the depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The depth of the tree is the maximum of the two depths plus 1 (for the root node)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}