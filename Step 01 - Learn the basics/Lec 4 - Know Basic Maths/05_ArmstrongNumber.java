// Question Link: https://leetcode.com/problems/armstrong-number/description/


import java.util.Scanner;

public class ArmstrongNumber {

    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int num) {
        // Calculate the number of digits in the number
        // int count = String.valueOf(num).length();
        int count = (int)Math.log10(num) + 1;
        
        // Initialize sum to 0
        int sum = 0;
        
        // Temporary variable to hold the original number
        int temp = num;
        
        // Loop through each digit of the number
        while (temp > 0) {
            // Get the last digit
            int ld = temp % 10;
            
            // Add the power of the digit to the sum
            sum += Math.pow(ld, count); 
            
            // Remove the last digit from temp
            temp /= 10;
        }
        
        // Return true if sum is equal to the original number, false otherwise
        return (sum == num);
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Prompt user to enter a number
        System.out.print("Enter a Number: ");
        int num = sc.nextInt();
        
        // Check if the number is an Armstrong number and print the result
        if (isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
        
        // Close the scanner
        sc.close();
    }
}


/*
An Armstrong number (also known as a narcissistic number) is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

For example:
- 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.
- 9474 is an Armstrong number because 9^4 + 4^4 + 7^4 + 4^4 = 9474.

The `isArmstrong` function determines if a number is an Armstrong number by calculating the sum of its digits each raised to the power of the total number of digits.

Time Complexity: O(d), where d is the number of digits in the number.
Space Complexity: O(1), since the function uses a constant amount of space regardless of the input size.
*/
