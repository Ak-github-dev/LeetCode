/*
Approach:

DFS Traversal:

For each node in the binary tree, we check whether the path starting from that node corresponds to the linked list.
We can use a depth-first search (DFS) to explore each potential starting point in the binary tree.

Match the Linked List:

Once we find a node in the tree that matches the head of the linked list, we need to recursively check whether the subsequent nodes in the linked list correspond to the children of the current tree node.

Backtracking:

If at any point the node in the tree doesn't match the corresponding node in the linked list, we backtrack and try other nodes.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        
        // Check if the current tree node is the start of a valid path
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean dfs(TreeNode root, ListNode head) {
        if (head == null) return true; // We've matched the entire list
        if (root == null) return false; // Reached the end of a tree path without matching the list
        
        // If the current tree node matches the current list node, continue checking
        if (root.val == head.val) {
            return dfs(root.left, head.next) || dfs(root.right, head.next);
        }
        
        return false; // The current node doesn't match, so this path is invalid
    }
}