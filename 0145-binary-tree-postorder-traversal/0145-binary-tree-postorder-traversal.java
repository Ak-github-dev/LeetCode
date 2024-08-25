/*
Approach:

Postorder Traversal:

In postorder traversal, you visit the left subtree, then the right subtree, and finally the root node. The sequence is Left -> Right -> Root.

Iterative Approach using Two Stacks:

To simulate the postorder traversal iteratively, you can use two stacks:
The first stack is used to process the nodes.
The second stack is used to store the nodes in reverse order (like root -> right -> left).
By popping from the second stack, you achieve the desired postorder traversal.
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
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        
        return result;
    }
}