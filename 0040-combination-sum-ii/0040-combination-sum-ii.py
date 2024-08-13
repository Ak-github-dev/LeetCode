"""
Approach:

Sort the Candidates:

First, sort the candidates array. Sorting helps to easily skip duplicates and also allows us to terminate early when the current candidate exceeds the remaining target.

Backtracking:

Use backtracking to explore all possible combinations. The idea is to start from the first candidate and try to form a combination by recursively adding candidates to the current combination.
Each time we add a candidate, reduce the target by the value of that candidate.
If the target becomes zero, the current combination is valid, so we add it to the result list.
If the target becomes negative, we backtrack because further additions won't make a valid combination.
Skip duplicate candidates during the backtracking process to avoid duplicate combinations in the result.

Pruning:

Since the array is sorted, if the current candidate is greater than the remaining target, we can stop further exploration (pruning).
"""
class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def backtrack(start, target, path):
            if target == 0:
                result.append(path)
                return
            if target < 0:
                return

            for i in range(start, len(candidates)):
                # Skip duplicates
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                # Prune the search space
                if candidates[i] > target:
                    break

                # Recurse with the updated parameters
                backtrack(i + 1, target - candidates[i], path + [candidates[i]])

        candidates.sort()
        result = []
        backtrack(0, target, [])
        return result