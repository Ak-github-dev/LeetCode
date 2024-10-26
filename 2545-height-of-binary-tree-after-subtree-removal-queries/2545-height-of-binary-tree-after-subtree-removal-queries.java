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

    private Map<Integer, Integer> heightMap = new HashMap<>();
    private Map<Integer, Integer> levelMaxHeight = new HashMap<>();
    private Map<Integer, Integer> levelSecondMaxHeight = new HashMap<>();
    private Map<Integer, Integer> nodeLevelMap = new HashMap<>();


    public int[] treeQueries(TreeNode root, int[] queries) {
        List<Integer> result = new ArrayList<>();
        
        // Precompute subtree heights and node levels
        computeHeights(root, 0);
        
        // Handle each query
        for (int query : queries) {
            int level = nodeLevelMap.get(query);
            int subtreeHeight = heightMap.get(query);
            
            // Determine max height after removing subtree rooted at 'query'
            int newHeight;
            if (levelMaxHeight.get(level) == subtreeHeight) {
                newHeight = levelSecondMaxHeight.get(level);
            } else {
                newHeight = levelMaxHeight.get(level);
            }
            result.add(newHeight + level);
        }
        
        // Convert the List<Integer> result to an int[] array and return
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private int computeHeights(TreeNode node, int level) {
        if (node == null) return -1;
        
        nodeLevelMap.put(node.val, level);
        
        int leftHeight = computeHeights(node.left, level + 1);
        int rightHeight = computeHeights(node.right, level + 1);
        
        int currentHeight = 1 + Math.max(leftHeight, rightHeight);
        heightMap.put(node.val, currentHeight);
        
        if (!levelMaxHeight.containsKey(level) || currentHeight > levelMaxHeight.get(level)) {
            levelSecondMaxHeight.put(level, levelMaxHeight.getOrDefault(level, -1));
            levelMaxHeight.put(level, currentHeight);
        } else if (!levelSecondMaxHeight.containsKey(level) || currentHeight > levelSecondMaxHeight.get(level)) {
            levelSecondMaxHeight.put(level, currentHeight);
        }
        
        return currentHeight;
    }
}