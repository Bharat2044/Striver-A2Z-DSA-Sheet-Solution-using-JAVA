// Question Link: https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution {
    //Function to return a list containing the union of the two arrays.
    /*
    // 1st Approach: Using TreeMap - Time Complexity = O((n + m)log(n + m)), Space Complexity = O((n + m))
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // Create a TreeMap to store elements in sorted order with their counts (though counts are not used in this case)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Create an ArrayList to store the result (union of the two arrays)
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // Add all elements from the first array to the TreeMap
        for (int i = 0; i < n; i++) {
            // map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
            
            // Alternative approach: Check if the element exists in the map
            if (map.containsKey(arr1[i])) {
                // Increment the frequency if the element is already present
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                // Initialize frequency to 1 if the element is not present
                map.put(arr1[i], 1);
            }
        }
        
        // Add all elements from the second array to the TreeMap
        for (int i = 0; i < m; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        
        // Iterate over the keys in the TreeMap and add each key to the result list
        for (int key : map.keySet()) {
            result.add(key);
        }
        
        // Return the result list containing the union of the two arrays
        return result;
    }
    */

    
    /*
    // 2nd Approach: Using TreeSet - Time Complexity = O((n + m)log(n + m)), Space Complexity = O((n + m))
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // Create a TreeSet to store unique elements in sorted order
        TreeSet<Integer> set = new TreeSet<>();
        
        // Create an ArrayList to store the result (union of the two arrays)
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // Add all elements from the first array to the TreeSet
        for(int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        
        // Add all elements from the second array to the TreeSet
        for(int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        
        // Iterate over the TreeSet and add each element to the result list
        for (int it : set) {
            result.add(it);
        }
        
        // Return the result list containing the union of the two arrays
        return result;
    }
    */

    /*
    // 3rd Approach: Using 2 Pointers & If-Else - Time Complexity = O((n + m)), Space Complexity = O((n + m))
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // Create an ArrayList to store the result (union of the two arrays)
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        // Traverse both arrays and add unique elements to the result
        while (i < n && j < m) {
            // Compare elements from both arrays
            if (arr1[i] <= arr2[j]) {
                // Add arr1[i] to result if it's not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                // Move to the next element in arr1
                i++;
            } else {
                // Add arr2[j] to result if it's not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                // Move to the next element in arr2
                j++;
            }
        }

        // Process any remaining elements in arr1
        while (i < n) {
            // Add arr1[i] to result if it's not a duplicate
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            // Move to the next element in arr1
            i++;
        }

        // Process any remaining elements in arr2
        while (j < m) {
            // Add arr2[j] to result if it's not a duplicate
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            // Move to the next element in arr2
            j++;
        }

        // Return the result list containing the union of the two arrays
        return result;
    }
    */
    
    
    // 4th Approach: Using 2 Pointers & While Loop - Time Complexity = O((n + m)), Space Complexity = O((n + m))
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // Create an ArrayList to store the result (union of the two arrays)
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        // Traverse both arrays until the end of one of them
        while (i < n && j < m) {
            int x = arr1[i];
            int y = arr2[j];

            // If the current element of arr1 is smaller, add it to the result
            if (arr1[i] < arr2[j]) {
                result.add(x);

                // Skip all duplicate elements in arr1
                while (i < n && arr1[i] == x) {
                    i++;
                }
            } 
            // If the current element of arr2 is smaller, add it to the result
            else if (arr1[i] > arr2[j]) {
                result.add(y);

                // Skip all duplicate elements in arr2
                while (j < m && arr2[j] == y) {
                    j++;
                }
            } 
            // If both elements are equal, add either to the result
            else {
                result.add(x);

                // Skip all duplicate elements in arr1
                while (i < n && arr1[i] == x) {
                    i++;
                }
                // Skip all duplicate elements in arr2
                while (j < m && arr2[j] == y) {
                    j++;
                }
            }
        }

        // Process any remaining elements in arr1
        while (i < n) {
            int x = arr1[i];
            result.add(x);

            // Skip all duplicate elements in arr1
            while (i < n && arr1[i] == x) {
                i++;
            }
        }

        // Process any remaining elements in arr2
        while (j < m) {
            int y = arr2[j];
            result.add(y);

            // Skip all duplicate elements in arr2
            while (j < m && arr2[j] == y) {
                j++;
            }
        }

        // Return the result list containing the union of the two arrays
        return result;
    }
}
