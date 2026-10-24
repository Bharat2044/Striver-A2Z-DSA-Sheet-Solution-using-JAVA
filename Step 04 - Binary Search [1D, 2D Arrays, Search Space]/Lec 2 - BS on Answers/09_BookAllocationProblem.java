// Question Link: https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries


import java.util.*;

public class Solution {
    // Method to count how many students are required if each student can be allocated at most 'pages' number of pages.
    public static int countStudents(ArrayList<Integer> arr, int pages) {

        // Start with one student
        int students = 1; 

        // Tracks the current number of pages allocated to a student
        long pagesStudent = 0; 

        // Iterate through each book in the array
        for (int i = 0; i < arr.size(); i++) {

            // If adding the current book to the student's allocation doesn't exceed the limit
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i); // Add the book to the current student's allocation
            } else {
                // If the limit is exceeded, allocate the book to a new student
                students++;
                pagesStudent = arr.get(i); // Start counting pages for the new student
            }
        }
        
        // Return the total number of students required
        return students;
    }

    /*
    // 1st Approach: Brute Force Approach: Time Complexity = O(n * (sum(arr[]) - max(arr[])+1)), Space Complexity = O(1)
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        
        // If there are more students than books, allocation is impossible
        if (m > n)
            return -1;

        // The minimum number of pages any student has to read is the maximum pages in a single book
        int low = Collections.max(arr);
        
        // The maximum number of pages any student has to read is the sum of all book pages
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        // Iterate over possible maximum pages from low to high to find the minimum feasible solution
        for (int pages = low; pages <= high; pages++) {
            
            // Check if the current maximum pages is sufficient to allocate all books to 'm' students
            if (countStudents(arr, pages) == m) {
                return pages; // If yes, return this as the answer
            }
        }

        // If no allocation is possible, return the lower bound (edge case)
        return low;
    }
    */


    // 2nd Approach: Optimal Approach (Using Binary Search): Time Complexity = O(n * log(sum(arr[]) - max(arr[])+1)), Space Complexity = O(1)
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        
        // If there are more students than books, it's impossible to allocate, so return -1
        if (m > n)
            return -1;

        // Determine the lower bound for binary search (maximum pages in a single book)
        int low = Collections.max(arr);
        
        // Determine the upper bound for binary search (sum of all pages in the array)
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        // Implement binary search to find the minimum feasible 'maximum pages' that can be allocated
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Middle point between low and high
            
            int requiredStudents = countStudents(arr, mid);  // Calculate required students for current mid

            if (requiredStudents <= m) {
                // If the required students are less than or equal to available students, try for a smaller value
                high = mid - 1;
            } else {
                // If more students are required, increase the minimum feasible pages
                low = mid + 1;
            }
        }
        
        // Return the minimum number of pages that allows all students to get books
        return low;
    }
}
