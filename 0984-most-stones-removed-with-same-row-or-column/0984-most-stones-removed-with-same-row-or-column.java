/*
Approach:

Union-Find (Disjoint Set Union - DSU) Method:

The problem can be thought of as finding connected components in a graph where each stone is a node, and there is an edge between two nodes if they share the same row or column.
We can use the Union-Find data structure to group stones that are in the same row or column.
The number of stones that can be removed is the total number of stones minus the number of connected components.

Key Idea:

Treat each row and column as part of a unique "space" in the union-find structure.
When unioning, you can treat the row index and column index as parts of the same space by using an offset for columns.
*/
/*
Explanation:

Union-Find Structure:

The UnionFind class manages the connected components. Each stone is connected based on its row and column.
The find method includes path compression to optimize the structure, making future queries faster.
The union method merges two components together, considering their rank (or size).

Handling Rows and Columns:

Columns are offset by 10000 to ensure they don't overlap with row indices in the union-find structure.
Each stone connects a row and a column, which effectively connects all stones that share the same row or column.

Counting Unique Components:

After processing all stones, count the number of unique components by finding the root of each stone's row.

Result:

The number of stones that can be removed is equal to the total number of stones minus the number of unique connected components.

Time Complexity:
The solution runs in O(n * α(n)) time, where n is the number of stones and α is the inverse Ackermann function, which is very slow-growing and nearly constant.
*/
/*
Wrong Answer
68 / 69 testcases passed

Editorial
Input
stones =
[[0,0],[2,2],[10000,2]]

Use Testcase
Output
2
Expected
1*/
/*
The issue arises from how the Union-Find structure handles the row and column indices, particularly the offset used for columns. In the problematic test case, two stones share a column but not a row, and the column index overlaps with row indices after adding the offset, causing an incorrect union.

To fix this, you should use a map to handle the union of row and column indices, ensuring that each index is treated uniquely regardless of overlap between row and column ranges.*/
/*
Changes:

Map-Based Union-Find:

Instead of using a fixed array size, a HashMap is used to store the parent and rank information. This allows the Union-Find structure to handle large and varied row/column indices without overlap issues.
Each row and column index is uniquely represented within the map, ensuring no unintended collisions.

Offset for Columns:

The offset is still used to differentiate row and column indices but is now managed within the map structure to prevent overlap.

Example Walkthrough:
For the input [[0,0],[2,2],[10000,2]]:

The correct output should be 1, as only one stone can be removed (either stone at [2,2] or [10000,2]).*/
/*Not working 69th testcase
class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10000; // Offset column to ensure uniqueness
            uf.union(row, col);
        }

        // Count unique components (roots)
        Map<Integer, Integer> uniqueRoots = new HashMap<>();
        for (int[] stone : stones) {
            int root = uf.find(stone[0]);
            uniqueRoots.put(root, uniqueRoots.getOrDefault(root, 0) + 1);
        }

        // Number of stones that can be removed is the total number minus the number of unique components
        return stones.length - uniqueRoots.size();
    }

    class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> rank;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 1);
            }
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x))); // Path compression
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank.get(rootX) > rank.get(rootY)) {
                    parent.put(rootY, rootX);
                } else if (rank.get(rootX) < rank.get(rootY)) {
                    parent.put(rootX, rootY);
                } else {
                    parent.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
            }
        }
    }
}
*/
/*
Intuition
To maximize the number of stones removed such that each removed stone shares either the same row or column with another stone that remains, we adopt a greedy strategy. We identify connected components of stones, where each stone is connected to others either by row or column. For each connected component, we can ensure maximum removal by leaving only one stone untouched—since this stone won't share a row or column with any other stone that remains.*/
class Solution {
    public int numOfIslands = 0;
    public int removeStones(int[][] stones) {
        int[] parent = new int[20003];
        for(int[] stone:stones) {
            unionSets(stone[0]+1, stone[1] + 10002, parent);
        }
        return stones.length - numOfIslands;
    }
    public void unionSets(int a, int b, int[] parent) {
        int parA = findParent(a, parent), parB = findParent(b, parent);
        if(parA != parB) {
            parent[parB] = parA;
            numOfIslands--;
        }
        return;
    }
    public int findParent(int node, int[] parent) {
        if(parent[node] == 0) {
            parent[node] = node;
            numOfIslands++;
        }
        if(parent[node] == node) {
            return node;
        }
        int par = findParent(parent[node], parent);
        parent[node] = par;
        return par;
    }
}