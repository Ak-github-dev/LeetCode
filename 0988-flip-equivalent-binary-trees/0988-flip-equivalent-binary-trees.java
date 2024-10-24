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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: if both nodes are null, they are equivalent
        if (root1 == null && root2 == null) {
            return true;
        }
        // If one is null and the other is not, or if the values are different, they are not equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // Recursively check two possibilities:
        // 1. No flip: left with left and right with right
        // 2. With flip: left with right and right with left
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        // Return true if either of the possibilities is true
        return noFlip || flip;
    }
}