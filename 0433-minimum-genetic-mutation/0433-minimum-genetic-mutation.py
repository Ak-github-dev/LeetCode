"""
Approach:

BFS Setup:

Treat each gene string as a node in a graph, and an edge exists between two nodes if they differ by exactly one character.
Use BFS to explore all possible mutations starting from the startGene until the endGene is found.

Valid Mutations:

A mutation is valid if it results in a gene string that exists in the gene bank.

Edge Cases:

If endGene is not in the gene bank, return -1 immediately since it's impossible to reach the endGene.
If startGene is the same as endGene, return 0 as no mutation is needed.
"""
from collections import deque
class Solution(object):
    def minMutation(self, startGene, endGene, bank):
        """
        :type startGene: str
        :type endGene: str
        :type bank: List[str]
        :rtype: int
        """
        if endGene not in bank:
            return -1
        
        bank_set = set(bank)
        queue = deque([(startGene, 0)])  # (current gene, number of mutations)
        possible_genes = ['A', 'C', 'G', 'T']
        
        while queue:
            current_gene, mutations = queue.popleft()
            
            # If the current gene is the target gene, return the number of mutations
            if current_gene == endGene:
                return mutations
            
            # Try all possible single mutations
            for i in range(len(current_gene)):
                for gene in possible_genes:
                    # Skip mutation to the same character
                    if gene == current_gene[i]:
                        continue
                    
                    # Create a new mutation by changing the i-th character
                    mutated_gene = current_gene[:i] + gene + current_gene[i+1:]
                    
                    # If the mutated gene is in the bank, it's a valid mutation
                    if mutated_gene in bank_set:
                        queue.append((mutated_gene, mutations + 1))
                        bank_set.remove(mutated_gene)  # Remove to prevent revisiting
                        
        return -1  # If no mutation sequence leads to the endGene