/*
Two main steps:

Reduce the Problem Space:

First, calculate the total amount of chalk used in one full round (i.e., one iteration through all students).
Use this sum to reduce the value of k by taking the remainder of k divided by the total sum of chalk. This step helps reduce unnecessary iterations and simplifies the problem.

Find the Student:

After reducing k, iterate through the students and decrement k by each student's chalk usage. The first student whose chalk usage exceeds the remaining k is the one who will need to replace the chalk.
*/
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        
        // Calculate the total amount of chalk used in one round
        for (int ch : chalk) {
            totalChalk += ch;
        }
        
        // Reduce k to the remainder after full rounds
        k %= totalChalk;
        
        // Find the student who will replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        // This line should never be reached because we will find the student in the loop
        return -1;
    }
}