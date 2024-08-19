// Question Link: find-the-highest-lowest-frequency-element


import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FindTheHighestLowestFrequencyElement {
    
    // Method to find the element with the highest and lowest frequency
    // Time Complexity = O(n), Space Complexity = O(n)
    static void findAndPrintFrequencyDetails(int[] arr) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        
        // Populate the HashMap with frequencies of each element
        for (int i = 0; i < arr.length; i++) {
            // Update the frequency count of the current element
            // Using getOrDefault to simplify frequency count logic
            // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            // Alternative approach: Check if the element exists in the map
            if (map.containsKey(arr[i])) {
                // Increment the frequency if the element is already present
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                // Initialize frequency to 1 if the element is not present
                map.put(arr[i], 1);
            }
        }
        
        // Initialize variables to keep track of the highest and lowest frequencies
        int maxFreq = Integer.MIN_VALUE; // Smallest possible value to ensure any frequency is higher
        int minFreq = Integer.MAX_VALUE; // Largest possible value to ensure any frequency is lower
        int maxEle = 0, minEle = 0;

        /*
        // Traverse the HashMap to find the elements with the highest and lowest frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();  // Frequency of the current element
            int element = entry.getKey();  // The current element

            // Check if the current element has a higher frequency than the previous maximum
            if (count > maxFreq) {
                maxEle = element;  // Update the element with the highest frequency
                maxFreq = count;   // Update the highest frequency
            }
            // Check if the current element has a lower frequency than the previous minimum
            if (count < minFreq) {
                minEle = element;  // Update the element with the lowest frequency
                minFreq = count;   // Update the lowest frequency
            }
        }
        */

        // Traverse the HashMap to find the elements with the highest and lowest frequencies
        for (Integer key : map.keySet()) {
            int element = key;           // The current element
            int count = map.get(key);    // Frequency of the current element

            // Check if the current element has a higher frequency than the previous maximum
            if (count > maxFreq) {
                maxEle = element;  // Update the element with the highest frequency
                maxFreq = count;   // Update the highest frequency
            }
            // Check if the current element has a lower frequency than the previous minimum
            if (count < minFreq) {
                minEle = element;  // Update the element with the lowest frequency
                minFreq = count;   // Update the lowest frequency
            }
        }

        // Print the element with the highest frequency
        System.out.println("The highest frequency element is: " + maxEle);
        // Print the element with the lowest frequency
        System.out.println("The lowest frequency element is: " + minEle);
    }

    public static void main(String args[]) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();  // Read the number of elements

        // Initialize the array with the size provided by the user
        int[] arr = new int[n];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();  // Read each element into the array
        }

        // Call the method to find and print the highest and lowest frequency elements
        findAndPrintFrequencyDetails(arr);

        // Close the scanner to free up resources
        scanner.close();
    }
}
