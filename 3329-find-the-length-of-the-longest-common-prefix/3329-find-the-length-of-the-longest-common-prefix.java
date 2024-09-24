/*
Optimized Approach: Using Trie for Efficient Common Prefix Comparison

Use a Trie (Prefix Tree):

We can insert all numbers from arr2 into a Trie structure as strings. This allows us to quickly search for the longest common prefix between any number in arr1 and the numbers in arr2.

Trie Insertion and Searching:

Insert each number from arr2 into the Trie.
For each number in arr1, check how many characters match with any number in the Trie by walking through the Trie.

Time Complexity:

Trie insertion and searching both run in linear time with respect to the length of the numbers (number of digits). So, the time complexity is significantly reduced compared to the brute-force comparison.
*/
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[10]; // For digits 0-9
        boolean isEndOfNumber;
    }
    
    TrieNode root;
    
    public void insert(String number) {
        TrieNode node = root;
        for (char c : number.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfNumber = true;
    }
    public int searchCommonPrefixLength(String number) {
        TrieNode node = root;
        int commonLength = 0;
        for (char c : number.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                break;
            }
            node = node.children[index];
            commonLength++;
        }
        return commonLength;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        
        // Insert all numbers from arr2 into the Trie
        for (int num : arr2) {
            insert(String.valueOf(num));
        }

        int maxLength = 0;
        
        // For each number in arr1, find the longest common prefix with numbers in arr2
        for (int num : arr1) {
            maxLength = Math.max(maxLength, searchCommonPrefixLength(String.valueOf(num)));
        }

        return maxLength;
    }
}