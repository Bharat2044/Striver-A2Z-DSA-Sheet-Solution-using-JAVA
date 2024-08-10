// Question Link: https://www.interviewbit.com/problems/subarray-with-given-xor/


public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;  // Get the length of the array
        
        int xr = 0;  // Initialize variable to store the XOR of elements
        
        // HashMap to store the frequency of prefix XOR values
        Map<Integer, Integer> map = new HashMap<>();
        map.put(xr, 1);  // Initial condition to handle subarrays starting from the beginning
        
        int count = 0;  // Initialize the count of subarrays with XOR equal to B

        for (int i = 0; i < n; i++) {
            // Calculate the prefix XOR till index i
            xr = xr ^ A[i];

            // By the formula: x = xr ^ B, where xr is the current prefix XOR
            int x = xr ^ B;

            // If x exists in the map, it means there's a subarray with XOR equal to B
            if (map.containsKey(x)) {
                count += map.get(x);  // Add the occurrences of this XOR value to the count
            }

            // Update the frequency of the current prefix XOR in the map
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        
        return count;  // Return the total count of subarrays with XOR equal to B
    }
}
