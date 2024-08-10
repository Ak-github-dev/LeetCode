"""
Approach
Initialization:

Create a Union-Find data structure to manage the connections between regions. Since the grid is n x n, we consider n+1 x n+1 points to account for the boundaries and diagonals.
Connect the Boundaries:

Initialize the boundaries of the grid by connecting all outer points to a common root. This ensures that any region that touches the boundary will be connected.
Connect Regions Based on Slashes:

For each cell, determine the regions that are divided by slashes:
A \ slash connects the lower left to the upper right.
A / slash connects the upper left to the lower right.
Use Union-Find to connect the corresponding regions.
Count Regions:

After processing all cells, the number of independent regions in the grid will be the count of unions formed when trying to connect already connected regions.
"""
"""
Complexity
Time Complexity:

The Union-Find operations (union and find) are nearly constant time, i.e., (O(α(n))), where (\alpha) is the inverse Ackermann function.
Since we process each cell and potentially connect two regions per cell, the overall time complexity is (O(n2⋅α(n))), where (n) is the size of the grid.
Space Complexity:

We use an extra array to represent the union-find structure, which has a size proportional to the number of points, i.e., (O((n+1)^2)).
"""
class Solution(object):
    """
    """
    def __init__(self):
        self.parent = []
        self.rank = []
        self.count = 0

    def regionsBySlashes(self, grid):
        n = len(grid)
        dots = n + 1
        self.parent = [i for i in range(dots * dots)]
        self.rank = [1] * (dots * dots)

        # Connect boundaries to the top-left corner (0,0)
        for i in range(dots):
            for j in range(dots):
                if i == 0 or j == 0 or i == n or j == n:
                    cell = i * dots + j
                    self.union(0, cell)

        # Process each cell and connect regions based on slashes
        for i in range(n):
            for j in range(n):
                if grid[i][j] == '\\':
                    cell1 = i * dots + j
                    cell2 = (i + 1) * dots + (j + 1)
                    self.union(cell1, cell2)
                elif grid[i][j] == '/':
                    cell1 = (i + 1) * dots + j
                    cell2 = i * dots + (j + 1)
                    self.union(cell1, cell2)

        return self.count

    def union(self, a, b):
        parentA = self.find(a)
        parentB = self.find(b)
        if parentA == parentB:
            self.count += 1
        else:
            if self.rank[parentA] > self.rank[parentB]:
                self.parent[parentB] = parentA
            elif self.rank[parentA] < self.rank[parentB]:
                self.parent[parentA] = parentB
            else:
                self.parent[parentB] = parentA
                self.rank[parentA] += 1

    def find(self, a):
        if self.parent[a] == a:
            return a
        self.parent[a] = self.find(self.parent[a])
        return self.parent[a]