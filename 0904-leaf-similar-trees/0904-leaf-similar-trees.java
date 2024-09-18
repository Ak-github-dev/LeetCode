/*
Approach:

Find the Leaf Sequence:

Traverse both trees and collect the leaf nodes (nodes with no children) in left-to-right order.

Compare the Sequences:

Once the leaf nodes from both trees are collected, compare the two sequences. If they are the same, the trees are leaf-similar.
8?
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Collect the leaf sequences from both trees
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Get leaves from both trees
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        // Compare both leaf sequences
        return leaves1.equals(leaves2);
    }
    
    // Helper function to collect leaves from a tree
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        
        // If it's a leaf node, add its value to the list
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        
        // Recursively collect leaves from left and right children
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}