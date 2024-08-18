"""
Approach:

Greedy Word Packing:

Start by grouping words together to form a line such that the total length of the words plus the number of spaces between them does not exceed maxWidth.
For each line, calculate the total number of spaces that need to be inserted to make the line length equal to maxWidth.

Space Distribution:

If the line contains more than one word, distribute the spaces evenly among the words.
If the number of spaces does not divide evenly, the extra spaces are added to the leftmost slots.
For the last line, or any line that contains only one word, the words should be left-justified and the remaining spaces should be added at the end of the line.

Final Output:

The result should be a list of strings, where each string is a fully justified line of text.
"""
class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        result = []
        line = []
        line_length = 0
        
        for word in words:
            # If adding the next word would exceed the maxWidth, process the current line
            if line_length + len(word) + len(line) > maxWidth:
                for i in range(maxWidth - line_length):
                    line[i % (len(line) - 1 or 1)] += ' '  # distribute spaces
                result.append(''.join(line))
                line, line_length = [], 0
            
            # Add the current word to the line
            line.append(word)
            line_length += len(word)
        
        # Process the last line, left-justified
        result.append(' '.join(line).ljust(maxWidth))
        
        return result