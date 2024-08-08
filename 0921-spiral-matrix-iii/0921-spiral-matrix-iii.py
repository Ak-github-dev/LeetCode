"""
Steps:

Initialize Variables:

Directions array to represent the four possible movements: right, down, left, and up.
Result list to store the coordinates visited.
Starting position (rStart, cStart).

Iterate in Spiral Order:

Use a while loop to keep track of the number of steps in the current direction.
For each direction, move a certain number of steps, and then change direction.
Increment the number of steps after every two changes in direction (this handles the increasing spiral size).

Boundary Check:

Each time a new coordinate is generated, check if it falls within the grid boundaries.
If it is within the grid, add it to the result list.

Termination:

The loop continues until the result list contains all the cells in the grid.
"""
class Solution(object):
    def spiralMatrixIII(self, rows, cols, rStart, cStart):
        """
        :type rows: int
        :type cols: int
        :type rStart: int
        :type cStart: int
        :rtype: List[List[int]]
        """
        # Directions are right, down, left, up
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        result = []
        steps = 1  # Initial step size
        x, y = rStart, cStart  # Starting position
        d = 0  # Start with the direction 'right'
        
        while len(result) < rows * cols:
            for _ in range(2):  # We need to change direction twice before increasing steps
                for _ in range(steps):
                    # Check if the current position is within the grid boundaries
                    if 0 <= x < rows and 0 <= y < cols:
                        result.append([x, y])
                    # Move in the current direction
                    x += directions[d][0]
                    y += directions[d][1]
                # Change direction
                d = (d + 1) % 4
            # Increase the step size after two direction changes
            steps += 1

        return result