/*
Approach:

Level-Order Traversal (BFS): Perform a level-order traversal (Breadth-First Search) of the tree. This allows us to process nodes level by level.
Sum the Values for Each Level: While traversing the tree, sum the values of nodes at each level.
Store Level Sums: Store the sum of each level in a data structure.
Sort the Level Sums: Sort the sums of the levels in descending order and return the Kth largest sum.
Handle Edge Case: If there are fewer than k levels, return -1.

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        
        // Step 1: Perform a BFS to compute level sums
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Long> levelSums = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                // Add child nodes to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            // Store the level sum
            levelSums.add(levelSum);
        }
        
        // Step 2: Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());
        
        // Step 3: Return the kth largest level sum, or -1 if there are fewer than k levels
        return k <= levelSums.size() ? levelSums.get(k - 1) : -1;
    }
}