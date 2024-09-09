/*
Approach:

Initialize the Matrix:

Create an m x n matrix and fill it initially with -1.

Spiral Traversal:

Start from the top-left of the matrix and move in a spiral pattern: right, down, left, and up, until we fill the entire matrix or exhaust the linked list.
Use four boundary pointers (top, bottom, left, right) to manage the spiral traversal.

Fill the Matrix:

As we traverse the matrix in a spiral order, fill each position with the current value from the linked list.
Move to the next node in the linked list until the list is exhausted.

Handle Remaining Spaces:

If the linked list is exhausted but there are still empty spaces, leave them filled with -1 (which is already the default value).
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
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the m x n matrix with -1
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Boundaries for the spiral traversal
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;

        // Fill the matrix in a spiral order
        while (current != null && top <= bottom && left <= right) {
            // Move from left to right
            for (int i = left; i <= right && current != null; i++) {
                matrix[top][i] = current.val;
                current = current.next;
            }
            top++; // Move the top boundary down

            // Move from top to bottom
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--; // Move the right boundary left

            // Move from right to left
            for (int i = right; i >= left && current != null; i--) {
                matrix[bottom][i] = current.val;
                current = current.next;
            }
            bottom--; // Move the bottom boundary up

            // Move from bottom to top
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++; // Move the left boundary right
        }

        return matrix;
    }
}