// Question Link: https://www.geeksforgeeks.org/problems/java-switch-case-statement3529/1


class Solution{
    
    // Time Complexity = O(1), Space Complexity = O(1)
    static double switchCase(int choice, List<Double> arr) {
        // Check the user's choice to determine the shape
        switch (choice) {
            case 1: // Choice 1: Calculate area of a circle
                return Math.PI * arr.get(0) * arr.get(0);
            case 2: // Choice 2: Calculate area of a rectangle
                return arr.get(0) * arr.get(1);
        }
        
        // Default return value if choice is neither 1 nor 2
        return 0;
    }
}
