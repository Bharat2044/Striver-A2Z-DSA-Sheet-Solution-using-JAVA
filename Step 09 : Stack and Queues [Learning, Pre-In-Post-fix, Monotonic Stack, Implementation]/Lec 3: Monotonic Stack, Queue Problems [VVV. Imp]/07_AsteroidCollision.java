// Question Link: https://leetcode.com/problems/asteroid-collision/


class Solution {
    /*
    private int[] removeExplodedAsteroids(int[] asteroids) {
        // Count non-zero elements (surviving asteroids)
        int count = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) count++;
        }

        // Collect surviving asteroids in a new array
        int[] result = new int[count];
        int index = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) result[index++] = asteroid;
        }

        // return the result
        return result;
    }

    // 1st Approach: Brute Force Solution - Time Complexity = O(n^2), Space Complexity = O(n)
    public int[] asteroidCollision(int[] asteroids) {
        // Keep checking for collisions until no collisions remain
        boolean collisionOccurred;
        do {
            collisionOccurred = false;

            for (int i = 0; i < asteroids.length - 1; i++) {
                // Check for collision when the right asteroid is moving left
                if (asteroids[i] > 0 && asteroids[i + 1] < 0) {
                    if (Math.abs(asteroids[i]) == Math.abs(asteroids[i + 1])) {
                        // Both asteroids explode
                        asteroids[i] = 0;
                        asteroids[i + 1] = 0;
                    } else if (Math.abs(asteroids[i]) > Math.abs(asteroids[i + 1])) {
                        // Right-moving asteroid survives
                        asteroids[i + 1] = 0;
                    } else {
                        // Left-moving asteroid survives
                        asteroids[i] = 0;
                    }
                    collisionOccurred = true;
                }
            }
            // Remove all exploded asteroids
            asteroids = removeExplodedAsteroids(asteroids);
        } while (collisionOccurred);

        return asteroids;
    }
    */

     // 2nd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(n)
     public int[] asteroidCollision(int[] asteroids) {
         
        // Initialize a stack to track the surviving asteroids
        Stack<Integer> stack = new Stack<>();

        // Loop through each asteroid in the input array
        for (int asteroid : asteroids) {
            // Flag to track if the current asteroid is destroyed in a collision
            boolean destroyed = false;

            // Check for possible collisions only if there is a right-moving asteroid on the stack
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    // Right-moving asteroid is smaller, so it gets destroyed; pop it from the stack
                    stack.pop();
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    // Both asteroids are of equal size, so both are destroyed
                    stack.pop();
                    destroyed = true;  // Mark the current asteroid as destroyed
                    break;              // Exit the loop as both are destroyed
                } else {
                    // Right-moving asteroid is larger, so the left-moving asteroid is destroyed
                    destroyed = true;  // Mark the current asteroid as destroyed
                    break;              // Exit the loop as the current asteroid is destroyed
                }
            }

            // If the current asteroid was not destroyed, push it onto the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to an array to return the result
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            // Pop each element from the stack to place it in the result array
            result[i] = stack.pop();
        }

        // Return the final state of the asteroids after all collisions
        return result; 
    }
}
