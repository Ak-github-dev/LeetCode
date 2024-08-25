/*
Approach:

Recursive Depth-First Search (DFS):

Use a recursive approach to traverse the tree.
At each node, consider all possible paths ending at that node and calculate if any of them sum to the target sum.
Use a helper function to calculate the path sum starting from the current node.

Optimized Approach using a HashMap:

Use a HashMap to store the cumulative sum up to each node during the DFS traversal.
The idea is to find if there exists a subpath (between two nodes) that sums up to the targetSum.
The HashMap stores the number of times a particular cumulative sum has occurred.
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: A sum of 0 occurs once
        return dfs(root, 0, targetSum, prefixSumCount);
    }
    
    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }
        
        // Update the current sum
        currentSum += node.val;
        
        // Get the number of valid paths that end at the current node
        int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        // Update the map with the current sum
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // Recurse through the left and right children
        int result = numPathsToCurr + dfs(node.left, currentSum, targetSum, prefixSumCount) 
                                   + dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // Restore the map, as the current path is done processing
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return result;
    }
}
/*
Explanation:

Cumulative Sum and HashMap:

The idea is to maintain the cumulative sum of the path from the root to the current node.
The prefixSumCount HashMap stores the frequency of each cumulative sum encountered during the DFS traversal.
For a given node, you check if there exists a cumulative sum that, when subtracted from the current cumulative sum, equals targetSum.

Recursive DFS:

Traverse the tree using DFS.
At each node, update the cumulative sum and check if there are any paths that sum to targetSum by checking prefixSumCount.
After processing the current node and its children, backtrack by decrementing the count of the current cumulative sum in the HashMap.

Example Walkthrough:
For the input tree [10,5,-3,3,2,null,11,3,-2,null,1] and targetSum = 8:

The paths that sum to 8 are [5, 3], [5, 2, 1], and [-3, 11].

Time Complexity:
The solution runs in O(n) time, where n is the number of nodes in the tree, as each node is visited once.
Space Complexity:
The space complexity is O(n) due to the HashMap used to store the cumulative sums and the recursion stack.
*/