// Question Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/


class Solution {

    /*
    // 1st Approach: Brute Force Approach (Using TreeSet) - Time Complexity = O(n * log(n)), Space Complexity = O(n)
    public int removeDuplicates(int[] nums) {
        // Initialize a TreeSet to store unique elements in sorted order.
        TreeSet<Integer> set = new TreeSet<>(); 

        // Loop through the array.
        for (int i = 0; i < nums.length; i++) { 
            set.add(nums[i]); // Add each element to the TreeSet. Duplicates will be automatically removed.
        }

        // Initialize a pointer j to track the position in the array where unique elements will be placed.
        int j = 0; 

        // Enhanced for-loop to traverse the TreeSet.
        // for (Integer x: set) {
        //     nums[j++] = x; // Copy each unique element back to the array nums.
        // }

        // Create an iterator to traverse the TreeSet.
        Iterator<Integer> itr = set.iterator(); 

        // Loop through the TreeSet using the iterator.
        while (itr.hasNext()) { 
            nums[j++] = itr.next(); // Copy each unique element back to the array nums.
        }

        // Return the number of unique elements, which is the size of the TreeSet.
        return set.size(); 
    }
    */

    /*
    // 2nd Approach: Brute Force Approach (Using TreeMap) - Time Complexity = O(n * log(n)), Space Complexity = O(n)
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); 

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int j = 0;

        // for (Integer key : map.keySet()) {
        //     nums[j++] = key;
        // }

        for (Map.Entry<Integer, Integer> entry :  map.entrySet()) {
            nums[j++] = entry.getKey();
        }

        return map.size(); 
    }
    */


    // 3rd Approach: Optimal Approach (Using Two Pointers) - Time Complexity = O(n), Space Complexity = O(1)
    public int removeDuplicates(int[] nums) {
        // Initialize a pointer i to keep track of the index of the last unique element.
        int i = 0; 

        // Loop through the array starting from the second element.
        for (int j = 1; j < nums.length; j++) { 

            // Check if the current element nums[j] is different from the last unique element nums[i].
            if (nums[i] != nums[j]) { 
                i++; // Increment the index i to place the next unique element.

                // Update the position of the next unique element.
                nums[i] = nums[j]; 
            }
        }
        
        // Return the count of unique elements, which is index i + 1.
        return i + 1; 
    }
}
