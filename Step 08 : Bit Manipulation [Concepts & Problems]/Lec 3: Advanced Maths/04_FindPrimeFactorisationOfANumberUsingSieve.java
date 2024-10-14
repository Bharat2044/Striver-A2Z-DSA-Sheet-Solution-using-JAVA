// Question Link: https://www.geeksforgeeks.org/problems/prime-factorization-using-sieve/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prime-factorization-using-sieve


class Solution {
    // Declare an array to store whether a number is prime or not (1 if not prime, 0 if prime)
    static int[] prime = new int[200001]; // Prime array size up to 200001
    
    // Function to apply the Sieve of Eratosthenes algorithm to mark non-prime numbers
    static void sieve() {
        // Iterate through numbers starting from 2 up to the square root of the array length
        for (int i = 2; i * i <= prime.length - 1; i++) {
            
            // If the current number i is prime (prime[i] is 0)
            if (prime[i] == 0) {
                
                // Mark all multiples of i as non-prime starting from i^2
                for (int j = i * i; j <= prime.length - 1; j += i) {
                    prime[j] = 1; // Mark j as non-prime
                }
            }
        }
    }

    // Time Complexity = O(n * log(log(n))), Space Complexity = O(n)
    static List<Integer> findPrimeFactors(int N) {
        // Create a list to store the prime factors of N
        List<Integer> list = new ArrayList<>();
        
        // Iterate from 2 to N to check for prime factors
        for (int i = 2; i <= N; i++) {
            // If i is prime (prime[i] is 0) and divides N
            if (prime[i] == 0 && N % i == 0) {
                
                // While i divides N, add i to the list and divide N by i
                while (N % i == 0) {
                    list.add(i); // Add i to the prime factors list
                    N = N / i;   // Divide N by i to reduce it
                }
            }
        }
        
        // Return the list of prime factors
        return list;
    }
}
