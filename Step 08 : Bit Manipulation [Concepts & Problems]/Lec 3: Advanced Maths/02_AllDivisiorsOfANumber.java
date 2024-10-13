// Question Link: https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1?utm_source=youtube&amp%3Butm_medium=collab_striver_ytdescription&amp%3Butm_campaign=all-divisors-of-a-number


class Solution {
    /*
    // 2nd Approach: Brute Force Solution Solution - Time Complexity = O(n), Space Complexity = O(1)
    public static void print_divisors1(int n) {
        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if i divides n perfectly (i is a divisor)
            if (n % i == 0) {
                // Print i if it's a divisor of n
                System.out.print(i + " ");
            }
        }
    }
    */
    
    /*
    // 2nd Approach: Better Solution - Time Complexity = O(sqrt(n) * log(k)), Space Complexity = O(k)
    public static void print_divisors(int n) {
        // Create a TreeSet to store the divisors in sorted order
        Set<Integer> set = new TreeSet<>();
        
        // Loop through numbers from 1 to sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            // If i is a divisor of n
            if (n % i == 0) {
                // Add i to the set (divisor)
                set.add(i);
                // If the quotient n/i is not the same as i, add it as well
                if (n / i != i) {
                    set.add(n / i);
                }
            }
        }
        
        // Print all divisors stored in the set (which is automatically sorted)
        for (int i : set) {
            System.out.print(i + " ");
        }
    }
    */
    
    // 3rd Approach: Optimal Solution - Time Complexity = O(sqrt(n)), Space Complexity = O(1)
    public static void print_divisors(int n) {
        // print divisors <= sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            // Print the smaller divisor
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        
        // print divisors > sqrt(n) in reverse order
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            
            // Print the larger divisor  (n / i) only if it's different from i
            if (n % i == 0 && n / i != i) {
                System.out.print((n / i) + " ");
            }
        }
    }
}
