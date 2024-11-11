class Solution {
    // Precompute all prime numbers up to 1000 (maximum value in nums)
    private List<Integer> primes = generatePrimes(1000);
    
    public boolean primeSubOperation(int[] nums) {
        // Iterate from the end of the array to the beginning to ensure each element can be made smaller if needed
        for (int i = nums.length - 1; i > 0; i--) {
            // Check if the current element is already greater than the previous
            if (nums[i] > nums[i - 1]) continue;
            
            // Try to make nums[i - 1] smaller by subtracting a prime less than its value
            boolean canReduce = false;
            for (int prime : primes) {
                if (prime >= nums[i - 1]) break;
                if (nums[i - 1] - prime < nums[i]) {
                    nums[i - 1] -= prime;
                    canReduce = true;
                    break;
                }
            }
            
            // If we couldn't reduce nums[i - 1] enough, return false
            if (!canReduce) return false;
        }
        return true;
    }

    // Helper function to generate primes up to max using the Sieve of Eratosthenes
    private List<Integer> generatePrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primesList.add(i);
        }
        return primesList;
    }
}