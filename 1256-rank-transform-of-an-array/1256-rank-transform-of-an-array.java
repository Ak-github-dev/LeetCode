/*
Approach:

Sorting and Ranking:

First, sort the unique elements of the array in ascending order. By doing this, we can determine the rank of each unique element in the sorted order.
For example, the smallest element gets rank 1, the second smallest gets rank 2, and so on.

Mapping Elements to Ranks:

After sorting the unique elements, we can map each element to its rank. For instance, if the sorted array is [5, 9, 12], the mapping would be:
5 -> rank 1
9 -> rank 2
12 -> rank 3

Replacing Elements in the Original Array:

Once we have the ranks for each unique element, we can replace each element in the original array with its rank.


Steps:
Create a sorted list of the unique elements.
Create a dictionary that maps each element to its rank.
Iterate over the original array and replace each element with its corresponding rank using the dictionary.
*/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a sorted list of unique elements
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Step 2: Create a map to assign ranks to each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        // Step 3: Replace elements in the original array with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}