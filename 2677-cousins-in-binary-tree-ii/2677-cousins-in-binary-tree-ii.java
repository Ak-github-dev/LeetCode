/*
Approach:

Level-Order Traversal (BFS):

Traverse the tree level by level.
At each level, compute the sum of all node values.
For each node, subtract the values of its sibling(s) from the total sum at that level. This will give us the sum of the node's cousins.
Replace the node's value with this computed cousin sum.

Edge Case:

If the root node is alone, it has no cousins, so its value should be set to 0.
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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        // BFS traversal to get the sum of cousin nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;  // Root node has no cousins, so set it to 0

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Map<TreeNode, Integer> parentSumMap = new HashMap<>();  // Map for parent -> sum of its children's values
            int levelSum = 0;

            // First pass: Calculate the total sum for the level and fill the parentSumMap
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int childrenSum = 0;
                
                if (node.left != null) {
                    childrenSum += node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    childrenSum += node.right.val;
                    queue.offer(node.right);
                }

                parentSumMap.put(node, childrenSum);
                levelSum += childrenSum;
            }

            // Second pass: Assign the cousin sum for each child
            for (Map.Entry<TreeNode, Integer> entry : parentSumMap.entrySet()) {
                TreeNode parent = entry.getKey();
                int siblingSum = entry.getValue();

                if (parent.left != null) {
                    parent.left.val = levelSum - siblingSum;
                }
                if (parent.right != null) {
                    parent.right.val = levelSum - siblingSum;
                }
            }
        }

        return root;
    }
}