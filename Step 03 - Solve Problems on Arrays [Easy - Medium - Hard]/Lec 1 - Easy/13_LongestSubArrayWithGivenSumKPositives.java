// Question Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k


class Solution{
   
    // Function for finding maximum and value pair
    /*
    // 1st Approach: Brute Force Approach (Using 3 Loops) - Time Complexity = O(N^3), Space Complexity = O(1)
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Initialize the variable to keep track of the maximum length of sub-arrays found
        int maxi = 0;
    
        // Iterate over each possible starting index of the sub-array
        for (int i = 0; i < N; i++) {
            // Iterate over each possible ending index of the sub-array starting from index i
            for (int j = i; j < N; j++) {
                // Initialize the sum for the current sub-array
                int sum = 0;
                
                // Compute the sum of the sub-array from index i to j
                for (int k = i; k <= j; k++) {
                    sum += A[k];
                }
    
                // Check if the current sum equals the target sum K
                if (sum == K) {
                    // Update the maximum length found if the current sub-array is longer
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
    
        // Return the length of the longest sub-array with the sum equal to K
        return maxi;
    }
    */
    
    /*
    // 2nd Approach: Brute Force Approach (Using 2 Loops) - Time Complexity = O(N^2), Space Complexity = O(1)
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Initialize the variable to keep track of the maximum length of sub-arrays found
        int maxi = 0;
    
        // Iterate over each possible starting index of the sub-array
        for (int i = 0; i < N; i++) {
            // Initialize variables to keep track of the current sub-array's length and sum
            int count = 0;
            int sum = 0;
    
            // Iterate over each possible ending index of the sub-array starting from index i
            for (int j = i; j < N; j++) {
                // Add the current element to the sum
                sum += A[j];
                // Increment the count of elements in the current sub-array
                count++;
    
                // Check if the current sum equals the target sum K
                if (sum == K) {
                    // Update the maximum length found if the current sub-array is longer
                    // maxi = Math.max(maxi, count);
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
    
        // Return the length of the longest sub-array with the sum equal to K
        return maxi;
    }
    */
    
    // 3rd Approach: Better Approach (Using Hashing) - Time Complexity = O(N), Space Complexity = O(N)
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Create a hashmap to store the first occurrence of cumulative sums
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        
        // Initialize the cumulative sum and the maximum length found
        int currentSum = 0;
        int maxi = 0;
        
        // Iterate through the array
        for (int i = 0; i < N; i++) {
            // Update the cumulative sum with the current element
            currentSum += A[i];
            
            // Check if the cumulative sum equals the target sum K
            if (currentSum == K) {
                // If the sum from the start to the current index is K, update the maximum length
                maxi = i + 1;
            }
            
            // Calculate the required cumulative sum that would make the sub-array sum equal to K
            int requiredSum = currentSum - K;
            
            // Check if the required cumulative sum exists in the hashmap
            if (preSumMap.containsKey(requiredSum)) {
                // If it exists, calculate the length of the sub-array with the sum K
                int length = i - preSumMap.get(requiredSum);
                // Update the maximum length found if the current sub-array is longer
                maxi = Math.max(maxi, length);
            }
            
            // Store the first occurrence of the cumulative sum in the hashmap if it's not already present
            if (!preSumMap.containsKey(currentSum)) {
                preSumMap.put(currentSum, i);
            }
        }
        
        // Return the length of the longest sub-array with the sum equal to K
        return maxi;
    }

    /*
    // 4th Approach: Optimal Approach (Using 2 Pointers) - Time Complexity = O(N), Space Complexity = O(1)
    // This will work only for positive integers
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Initialize two pointers for the sliding window
        int left = 0; // Left pointer
        int right = 0; // Right pointer
        int sum = 0; // Initialize the sum of the current window
        int maxi = 0; // Initialize the maximum length of sub-array found
        
        // Iterate with the right pointer
        while (right < N) {
            // Expand the window by including the element at the right pointer
            sum += A[right];
            
            // If the current sum exceeds K, reduce the window from the left
            while (left <= right && sum > K) {
                sum -= A[left];
                left++;
            }
            
            // Check if the current sum equals K
            if (sum == K) {
                // Update the maximum length found if the current sub-array is longer
                maxi = Math.max(maxi, right - left + 1);
            }
            
            // Move the right pointer to the right to expand the window
            right++;
        }
        
        // Return the length of the longest sub-array with the sum equal to K
        return maxi;
    }
    */
}
