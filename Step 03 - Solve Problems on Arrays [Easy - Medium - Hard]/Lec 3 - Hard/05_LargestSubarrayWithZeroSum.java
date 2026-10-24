// Qusetion Link: https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany%5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum


class GfG {
    /*
    // 1st Approach: Brute Force Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    int maxLen(int arr[], int n) {

        // Initialize a variable to store the maximum length of subarray with sum 0
        int maxi = 0;
    
        // Iterate through each element in the array as a starting point for the subarray
        for (int i = 0; i < n; i++) {
    
            // Initialize sum to 0 for the new subarray starting at index 'i'
            int sum = 0;
    
            // Iterate from the current starting index 'i' to the end of the array
            for (int j = i; j < n; j++) {
    
                // Add the current element to the sum
                sum += arr[j];
    
                // Check if the sum of the subarray from 'i' to 'j' is 0
                if (sum == 0) {
                    // Update the maximum length of subarray if the current subarray is longer
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
    
        // Return the maximum length of subarray with sum 0 found
        return maxi;
    }
    */
    
    // 2nd Approach: Better Approach (Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    int maxLen(int arr[], int n) {
        // HashMap to store the prefix sum and its index
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        int sum = 0;  // Initialize sum of elements
        int maxi = 0; // Initialize the maximum length of subarray with sum 0

        for (int i = 0; i < n; i++) {
            sum += arr[i];  // Add the current element to the sum

            // If the sum is 0, update maxi to be the current index + 1
            if (sum == 0) {
                maxi = i + 1;
            }

            // If this sum has been seen before, it means the subarray between
            // the previous index where this sum was found and the current index
            // has a sum of 0.
            if (prefixSumMap.containsKey(sum)) {
                maxi = Math.max(maxi, i - prefixSumMap.get(sum));
            } else {
                // Otherwise, store the current sum with its index
                prefixSumMap.put(sum, i);
            }
        }

        return maxi;  // Return the length of the longest subarray with sum 0
    }
}
