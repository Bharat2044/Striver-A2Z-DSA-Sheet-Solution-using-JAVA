// Question Link: https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401


import java.util.*;
import java.io.*;

public class Solution {
  // Time Complexity = O(log(n)), Space Complexity = O(1)
  public static int[] getFloorAndCeil(int[] a, int n, int x) {
    // Find the floor and ceiling using helper methods
    int floor = findFloor(a, x);
    int ceil = findCeil(a, x);

    // Return the floor and ceiling as an array
    return new int[] { floor, ceil };
  }

  // Helper method to find the floor of x using binary search
  public static int findFloor(int[] arr, int x) {
    int left = 0, right = arr.length - 1;

    int floor = -1; // Initialize floor as -1, assuming no valid floor exists

    // Binary search loop
    while (left <= right) {
      int mid = left + (right - left) / 2;

      // If mid element is less than or equal to x, it could be a valid floor
      if (arr[mid] <= x) {
        floor = arr[mid]; // Update floor to the current mid element
        left = mid + 1; // Search in the right half for a potentially larger floor
      } else {
        right = mid - 1; // Search in the left half if the mid element is greater than x
      }
    }

    // Return the found floor value or -1 if not found
    return floor;
  }

  // Helper method to find the ceiling of x using binary search
  public static int findCeil(int[] arr, int x) {
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
        left = mid + 1; // Search in the right half if the mid element is less than x
      }
    }

    // Return the found ceil value or -1 if not found
    return ceil;
  }
}
