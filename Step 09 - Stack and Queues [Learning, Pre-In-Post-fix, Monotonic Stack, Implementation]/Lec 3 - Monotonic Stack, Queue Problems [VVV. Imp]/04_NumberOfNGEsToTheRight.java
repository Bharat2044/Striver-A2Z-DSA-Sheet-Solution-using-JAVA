// Question Link: https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-nges-to-the-right


class Solution {
    
    // Time Complexity = O(queries * n), Space Complexity = O(queries)
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {        
        // Result array to store the NGE counts for each query index
        int[] res = new int[queries];

        // Iterate through each query index
        for (int i = 0; i < queries; i++) {
            // Get the element at the current query index
            int num = arr[indices[i]];
            
            // Initialize the count of elements greater than arr[indices[i]] to 0
            int count = 0;

            // Loop through elements to the right of the current index
            for (int j = indices[i] + 1; j < N; j++) {
                
                // If the current element arr[j] is greater than num, increment count
                if (arr[j] > num) {
                    count++;
                }
            }

            // Store the count of greater elements for the current query index
            res[i] = count;
        }

        // Return the result array containing counts for all queries
        return res;
    }
}
