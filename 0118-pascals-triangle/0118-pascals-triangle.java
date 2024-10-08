/*
Approach:

Understanding Pascal's Triangle:

The first row is [1].
Each subsequent row is generated by adding the two numbers directly above each position, with 1 added at the start and end of each row.

Algorithm:

Initialize a list to hold the rows of the triangle.
For each row, create a list starting with 1.
Use the values from the previous row to compute the new values.
Append 1 at the end of each row.
Add the row to the triangle list.
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case; first row is always [1]
        if (numRows == 0) return triangle;
        
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        // Build the triangle row by row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);
            
            // The first element in each row is always 1
            row.add(1);
            
            // Each triangle element is equal to the sum of the elements
            // directly above it from the previous row
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // The last element in each row is always 1
            row.add(1);
            
            triangle.add(row);
        }
        
        return triangle;
    }
}