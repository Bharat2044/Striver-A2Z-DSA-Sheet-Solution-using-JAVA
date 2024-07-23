// Question Link: https://www.geeksforgeeks.org/problems/count-digits5716/1

 
class Solution{

    // Time Complexity = O(logn) or O(no. of digits), Space Complexity = O(1)
    static int evenlyDivides(int N) {
        // Initialize temporary variable with the original number
        int temp = N;
        // Initialize counter for digits that evenly divide N
        int count = 0;
        
        // Loop through each digit of the number
        while (temp != 0) {
            // Get the last digit
            int rem = temp % 10;
            
            // Check if remainder is not 0 and the digit divides the number evenly
            if (rem != 0 && N % rem == 0) {
                // Increment count if it divides evenly
                count++;
            }
            
            // Remove the last digit from the number
            temp /= 10;
        }
        
        // Return the count of digits that evenly divide the number
        return count;
    }
}
