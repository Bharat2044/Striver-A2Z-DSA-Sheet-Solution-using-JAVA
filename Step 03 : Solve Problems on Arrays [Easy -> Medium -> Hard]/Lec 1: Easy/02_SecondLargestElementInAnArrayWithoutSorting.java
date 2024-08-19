// Question Link: https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Sorting) - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int print2largest(List<Integer> arr) {
        // Get the length of the List
        int n = arr.size(); 
        
        // If the list has less than 2 elements, a second largest element cannot exist
        if (n < 2) {
            return -1; 
        }
    
        // Sort the list in ascending order to make finding distinct elements easier
        Collections.sort(arr);
        
        // The largest element in the sorted list is at the end
        int largest = arr.get(n - 1);
        
        // Initialize the second largest value as -1, which will be updated if a valid second largest is found
        // Traverse the list from the second-to-last element backwards
        for (int i = n - 2; i >= 0; i--) {
            // Find the first element that is distinct from the largest element
            if (arr.get(i) != largest) {
                // Return this element as it is the second largest distinct element
                return arr.get(i);
            }
        }
        
        // If no distinct element was found that is smaller than the largest element, return -1
        return -1; 
    }
    */
    
    /*
    // 2nd Approach: Better Approach (Using Loops 2 Iteration) - Time Complexity = O(n), Space Complexity = O(1)
    public int print2largest(List<Integer> arr) {
        // Get the length of the array
        int n = arr.size(); 
        
        // If array has less than 2 elements, no second largest element exists
        if (n < 2) {
            return -1; 
        }
        
        int largest = Integer.MIN_VALUE;
        
        // Find the largest element in the array
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > largest) {
                largest = arr.get(i);
            }
        }

        // Initialize with the largest possible integer value
        int secondLargest = Integer.MIN_VALUE; 
        
        // Find the second largest element by comparing with the largest element
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > secondLargest && arr.get(i) != largest) {
                secondLargest = arr.get(i);
            }
        }

        // Return secondLargest or -1 if not found
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest; 
    }
    */
    
    
    // 3rd Approach: Optimal Approach (Using 1 Iteration) - Time Complexity = O(n), Space Complexity = O(1)
    public int print2largest(List<Integer> arr) {
        // Get the length of the array
        int n = arr.size(); 
        
        // If array has less than 2 elements, no second largest element exists
        if (n < 2) {
            return -1; 
        }
        
        // Initialize largest and secondLargest to the smallest possible integer value
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE; 
        
        // Iterate through the array to find the largest and second largest elements
        for (int i = 0; i < n; i++) {
            // Update largest and secondLargest if current element is greater than largest
            if (arr.get(i) > largest) {
                secondLargest = largest;
                largest = arr.get(i);
            }
            
            // Update secondLargest if current element is between largest and secondLargest
            if (arr.get(i) > secondLargest && arr.get(i) != largest) {
                secondLargest = arr.get(i);
            }
        }
    
        // Return secondLargest or -1 if no valid second largest element was found
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest; 
    }
}
