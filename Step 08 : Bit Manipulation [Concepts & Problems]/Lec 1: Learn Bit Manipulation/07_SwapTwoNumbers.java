// Question Link: https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1


class Solution{
    /*
    // 1st Approach - Time Complexity = O(1), Space Complexity = O(1)
    static List<Integer> get(int a, int b) {
        // Swap using temparory variable
        int temp = a;
        a = b;
        b = temp;
    
        // Return the swapped values
        return Arrays.asList(a, b);
    }
    */
    
    /*
    // 2nd Approach - Time Complexity = O(1), Space Complexity = O(1)
    static List<Integer> get(int a, int b) {
        // Swap using addition and subtraction
        a = a + b;  // a now becomes sum of a and b
        b = a - b;  // b becomes original a (a + b - b = a)
        a = a - b;  // a becomes original b (a - (a - b) = b)
    
        // Return the swapped values
        return Arrays.asList(a, b);
    }
    */

    // 3rd Approach - Time Complexity = O(1), Space Complexity = O(1)
    static List<Integer> get(int a, int b) {
        // Swap using XOR operator
        a = a ^ b;  
        b = a ^ b;  
        a = a ^ b; 
    
        // Return the swapped values
        return Arrays.asList(a, b);
    }
}
