/*
Approach:

Split the sentences into words: First, split both sentences into arrays of words.
Two-pointer technique: Start comparing the words from the beginning of both sentences (prefix) and from the end (suffix).

Check if they match:
Move the pointers from the beginning as long as the words match.
Move the pointers from the end as long as the words match.
Determine if similar: After processing, the two sentences will be similar if the remaining unprocessed words (in the middle) can fit into one sentence. This happens if the total number of unmatched words is less than or equal to the length of the longer sentence.
*/
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split the sentences into words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0; // pointer for the beginning
        int j = 0; // pointer for the end

        // Check matching prefix
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        // Check matching suffix
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // If all words from one sentence can fit into the other
        return i + j >= Math.min(words1.length, words2.length);
    }
}