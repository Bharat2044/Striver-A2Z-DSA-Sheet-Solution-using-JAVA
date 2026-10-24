// Question Link: https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor


class Solution {
    // 1st Approach: Brute Force Approach (Using Sorting & Linear Search) Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Sort the array to ensure it is in ascending order
        // This sorting step is necessary to apply binary search logic for floor and ceiling
        Arrays.sort(arr);
    
        // Initialize variables to store the floor and ceiling values
        // Default values are set to -1, indicating no floor or ceiling is found initially
        int floor = -1;
        int ceil = -1;
    
        // Iterate through the array to find the floor value
        // The floor is defined as the greatest element in the array that is less than or equal to x
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                floor = arr[i];  // Update the floor as we find closer values to x
            }
        }
    
        // Iterate through the array in reverse to find the ceiling value
        // The ceiling is defined as the smallest element in the array that is greater than or equal to x
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= x) {
                ceil = arr[i];  // Update the ceiling as we find closer values to x
            }
        }
    
        // Return the floor and ceiling values as an array
        // The first element is the floor, and the second element is the ceiling
        return new int[]{floor, ceil};
    }
    
    
    /*
    // 2nd Approach: Bwttwr Approach (Using Sorting & Binary Search) Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Sort the array to apply binary search
        Arrays.sort(arr);

        // Find the floor and ceiling using helper methods
        int floor = findFloor(arr, x);
        int ceil = findCeil(arr, x);

        // Return the floor and ceiling as an array
        return new int[]{floor, ceil};
    }

    // Helper method to find the floor of x using binary search
    private int findFloor(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int floor = -1; // Initialize floor as -1, assuming no valid floor exists

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If mid element is less than or equal to x, it could be a valid floor
            if (arr[mid] <= x) {
                floor = arr[mid]; // Update floor to the current mid element
                left = mid + 1;   // Search in the right half for a potentially larger floor
            } else {
                right = mid - 1;  // Search in the left half if the mid element is greater than x
            }
        }

        // Return the found floor value or -1 if not found
        return floor;
    }

    // Helper method to find the ceiling of x using binary search
    private int findCeil(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int ceil = -1; // Initialize ceil as -1, assuming no valid ceil exists

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than or equal to x, it could be a valid ceil
            if (arr[mid] >= x) {
                ceil = arr[mid]; // Update ceil to the current mid element
                right = mid - 1; // Search in the left half for a potentially smaller ceil
            } else {
                left = mid + 1;  // Search in the right half if the mid element is less than x
            }
        }

        // Return the found ceil value or -1 if not found
        return ceil;
    }
    */
    

    /*    
    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Initialize floor and ceil to -1, assuming they might not exist.
        int floor = -1;
        int ceil = -1;

        // Iterate through the array to find the floor and ceiling values.
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is a valid floor.
            if (arr[i] <= x && (floor == -1 || arr[i] > floor)) {
                floor = arr[i];
            }
            
            // Check if the current element is a valid ceiling.
            if (arr[i] >= x && (ceil == -1 || arr[i] < ceil)) {
                ceil = arr[i];
            }
        }

        // Return the array containing the floor and ceiling values.
        return new int[]{floor, ceil};
    }
    */
}
