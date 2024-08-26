/*
Approach:

Postorder Traversal:

In postorder traversal for an N-ary tree, you visit all the children of a node before visiting the node itself. The order is children -> root.

Iterative Approach using a Stack:

You can use a single stack to simulate the postorder traversal.
To achieve postorder traversal, we can process the nodes similarly to a reverse preorder traversal (Root -> Children). We push nodes onto a stack in the order: Root -> Last Child -> First Child. After processing, we reverse the result.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            // Push children to the stack
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        
        // Reverse the result to get the postorder sequence
        Collections.reverse(result);
        return result;
    }
}