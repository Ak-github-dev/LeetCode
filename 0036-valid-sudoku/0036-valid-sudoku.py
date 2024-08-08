class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # Use hash sets to keep track of the digits we've seen
        rows = [set() for _ in range(9)]
        columns = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        
        for r in range(9):
            for c in range(9):
                num = board[r][c]
                if num == '.':
                    continue
                # Calculate box index
                box_index = (r // 3) * 3 + (c // 3)
                
                if num in rows[r] or num in columns[c] or num in boxes[box_index]:
                    return False
                
                rows[r].add(num)
                columns[c].add(num)
                boxes[box_index].add(num)
        
        return True