/*
Approach:

Trie Construction:

We'll use a Trie where each node will store the number of words that pass through it. This will help count how many words have a particular prefix as we insert the words into the Trie.

Insert Operation:

When inserting a word into the Trie, we'll increment a count for every prefix of that word (as we traverse through the characters of the word).

Prefix Score Calculation:

Once all words are inserted, for each word, we can compute its prefix score by traversing through the characters of the word in the Trie and summing the counts along the way.


Steps:
Insert each word into the Trie, updating the count for each prefix along the way.
For each word, calculate the sum of scores for all its prefixes by traversing the Trie.
*/
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0; // To store how many words pass through this node
    }

    private TrieNode root = new TrieNode();

    // Function to insert a word into the Trie and update the prefix counts
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++; // Increment count for this prefix
        }
    }

    // Function to compute the sum of prefix scores for a given word
    private int getPrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            score += node.count; // Sum the prefix scores for each character
        }
        return score;
    }


    public int[] sumPrefixScores(String[] words) {
        // Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Compute the prefix score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getPrefixScore(words[i]);
        }

        return result;
    }
}