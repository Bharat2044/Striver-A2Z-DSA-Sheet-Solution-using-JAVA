// Question Link: https://www.geeksforgeeks.org/problems/prime-factors5052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=Prime-Factors


class Solution {
    /*
    // Function to check if a number is prime
    private boolean isPrime(int num) {
        // If the number is less than or equal to 1, it's not prime
        if (num <= 1) {
            return false;
        }
    
        // Iterate from 2 to the square root of num
        // We only check up to sqrt(num) because any factor larger than sqrt(num) 
        // would have a corresponding smaller factor
        for (int i = 2; i * i <= num; i++) {
            // If num is divisible by i, it's not prime
            if (num % i == 0) {
                return false;
            }
        }
    
        // If no factors were found, num is prime
        return true;
    }
    
    // 1st Approach: Brute Force Solution - Time Complexity = O(N * sqrt(N)), Space Complexity = O(N)
    public int[] AllPrimeFactors(int N) {
        // Create a list to store the prime factors
        List<Integer> list = new ArrayList<>();
        
        // Iterate through all numbers from 2 to N
        for (int i = 2; i <= N; i++) {
            // If i divides N perfectly and i is prime, it's a prime factor
            if (N % i == 0 && isPrime(i)) {
                list.add(i); // Add i to the list of prime factors
            }
        }
    
        // Create an array to store the prime factors from the list
        int[] arr = new int[list.size()];
    
        // Copy all elements from the list to the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    
        // Return the array containing all prime factors
        return arr;
    }
    */
    
    
    // 2nd Approach: Optimal Solution - Time Complexity = O(sqrt(N)), Space Complexity = O(logN)
    public int[] AllPrimeFactors(int N) {
        // Create a list to store the prime factors
        List<Integer> list = new ArrayList<>();
        
        // Loop through all numbers from 2 to sqrt(N)
        for (int i = 2; i * i <= N; i++) {
            
            // If i divides N perfectly, it's a prime factor
            if (N % i == 0) {
                list.add(i);
            }
            
            // Divide N by i as long as i divides N to remove all multiples of i
            while (N % i == 0) {
                N /= i;
            }
        }
        
        // If N is still greater than 1, it means N itself is a prime number
        if (N != 1) {
            list.add(N);
        }
        
        // Create an array to store the prime factors from the list
        int[] arr = new int[list.size()];
        
        // Copy all elements from the list to the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        // Return the array containing all prime factors
        return arr;
    }
}
