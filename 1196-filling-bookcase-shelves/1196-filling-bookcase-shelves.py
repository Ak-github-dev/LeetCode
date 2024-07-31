"""
Initialization:

Create an array dp where dp[i] will store the minimum height to arrange the first i books.
Initialize dp[0] to 0 since no books require zero height.
Dynamic Programming Transition:

For each book i, we consider placing it on a new shelf or the current shelf.
We need to determine the minimum height if the current book and some previous books are placed on the same shelf without exceeding the shelfWidth.
We loop backward from the current book to determine the maximum height for books on the current shelf and sum up their widths. If the sum of widths does not exceed shelfWidth, we update dp[i] with the minimum possible height.
Final Answer:

The answer will be stored in dp[n], where n is the number of books.
"""
class Solution(object):
    def minHeightShelves(self, books, shelfWidth):
        """
        :type books: List[List[int]]
        :type shelfWidth: int
        :rtype: int
        """
        n = len(books)
        dp = [0] * (n + 1)
        
        for i in range(1, n + 1):
            width = 0
            height = 0
            dp[i] = float('inf')
            
            # Try to place the current book and some previous books on the same shelf
            for j in range(i, 0, -1):
                width += books[j-1][0]
                if width > shelfWidth:
                    break
                height = max(height, books[j-1][1])
                dp[i] = min(dp[i], dp[j-1] + height)
        
        return dp[n]