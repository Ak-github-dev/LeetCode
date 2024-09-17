/*
Approach:

Split Sentences:

Split both sentences into words using the space character as a delimiter.

Count Word Frequencies:

Use a HashMap to count how many times each word appears across both sentences.

Find Uncommon Words:

After counting the frequencies, traverse the map and collect words that have a frequency of 1.
*/
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Create a map to store word frequencies
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Step 2: Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        // Step 3: Count frequencies of words in both sentences
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Step 4: Collect words with frequency 1 (uncommon words)
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        // Step 5: Convert the list to an array and return
        return result.toArray(new String[0]);
    }
}