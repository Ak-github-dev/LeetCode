/*
Approach:

Sort the Folders: 
Start by sorting the folders lexicographically. Sorting helps because parent folders will come before their sub-folders.

Iterate and Filter: 
After sorting, we can go through each folder and use a simple check:
    If the current folder is not a sub-folder of the last added folder in the result, add it to the result.
    To check if a folder is a sub-folder of another, verify if the current folder starts with the last folder in the result, followed by a /.

Return the Filtered List: 
This will contain only top-level folders without any sub-folders.
*/
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the array lexicographically
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        
        // Step 2: Iterate and add only non-subfolders
        for (String f : folder) {
            // Check if f is not a subfolder of the last added folder in the result
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);
            }
        }
        
        return result;
    }
}