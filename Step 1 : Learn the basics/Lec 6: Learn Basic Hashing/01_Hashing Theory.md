### Hashing in Java

Hashing is a technique used to uniquely identify objects and store them in data structures like hash tables. It involves converting an input (or 'key') into a fixed-size string of bytes using a hash function. The output is typically a hash code, which is used to quickly find data.

#### Key Concepts:

- **Hash Function:** Maps data of arbitrary size to fixed-size values.
- **Hash Code:** The result of the hash function.
- **Hash Collision:** Occurs when two different inputs produce the same hash code.

Java provides built-in hashing through the `hashCode()` method in the `Object` class. Collections like `HashMap` and `HashSet` use hash codes for fast data retrieval.

### Example

Here's an example of how to use hashing in Java:

```java
import java.util.HashMap;
import java.util.Map;

public class HashingExample {
    public static void main(String[] args) {
        // Initialize a new HashMap to store names and ages
        // Time complexity: O(1)
        HashMap<String, Integer> map = new HashMap<>();
        
        // Get the size of the HashMap
        // Time complexity: O(1)
        System.out.println("Initial HashMap: " + map);
        System.out.println("Initial HashMap size: " + map.size());

        // Add key-value pairs to the HashMap
        // Time complexity: O(1) on average
        map.put("Bharat", 21);
        map.put("Deepak", 25);
        map.put("Raj", 28);
        
        // Get the size of the HashMap after adding elements
        // Time complexity: O(1)
        System.out.println("HashMap after adding elements: " + map);
        System.out.println("HashMap size after adding elements: " + map.size());

        // Retrieve a value using a key
        // Time complexity: O(1) on average
        System.out.println("Age of Bharat: " + map.get("Bharat"));
        System.out.println("Age of Mohan (not present): " + map.get("Mohan"));

        // Check if a key is present
        // Time complexity: O(1) on average
        System.out.println("Is Bharat present? " + map.containsKey("Bharat"));
        System.out.println("Is Mohan present? " + map.containsKey("Mohan"));

        // Display the hash codes of the keys
        // Time complexity: O(n)
        for (String key : map.keySet()) {
            System.out.println("Hash code for " + key + ": " + key.hashCode());
        }
        
        // Print all keys in the HashMap
        // Time complexity: O(n)
        System.out.println("All keys in the HashMap: ");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        
        // Print all values in the HashMap
        // Time complexity: O(n)
        System.out.println("All values in the HashMap: ");
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        // Iterate over the map and print each key-value pair
        // Time complexity: O(n)
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        
        // Alternative iteration over the map using entrySet
        // Time complexity: O(n)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Adding a duplicate key updates the value
        // Time complexity: O(1) on average
        map.put("Bharat", 33);
        System.out.println("HashMap after adding duplicate key: " + map);
        System.out.println("HashMap size after adding duplicate key: " + map.size());
        System.out.println("Updated age of Bharat: " + map.get("Bharat"));
        
        // Remove an element from the map
        // Time complexity: O(1) on average
        map.remove("Raj");
        System.out.println("HashMap after removing 'Raj': " + map);
        System.out.println("HashMap size after removal: " + map.size());

        // Demonstrate hash collision handling
        String key1 = "FB"; // Example keys with the same hash code
        String key2 = "Ea";

        System.out.println("Hash code for " + key1 + ": " + key1.hashCode());
        System.out.println("Hash code for " + key2 + ": " + key2.hashCode());

        // Add the keys to the map
        // Time complexity: O(1) on average
        map.put(key1, 50);
        map.put(key2, 60);

        // Retrieve the values for the colliding keys
        // Time complexity: O(1) on average
        System.out.println("Value for " + key1 + ": " + map.get(key1));
        System.out.println("Value for " + key2 + ": " + map.get(key2));
        
        // Clear all entries in the HashMap
        // Time complexity: O(n)
        map.clear();
        System.out.println("HashMap after clear operation: " + map);
        System.out.println("HashMap size after clear operation: " + map.size());
    }
}
```

### Explanation

- **HashMap:** A collection that stores key-value pairs. It uses hashing to efficiently locate a key-value pair.
- **hashCode():** Method that returns an integer hash code for an object. Different objects might have the same hash code, leading to hash collisions.
- **Handling Collisions:** `HashMap` handles collisions using separate chaining or open addressing (internally managed).

### Key Points

- Hash functions should distribute hash codes uniformly.
- Collisions are inevitable but should be minimized.
- Good hash functions reduce the chance of collisions and enhance performance.


## References
- **Videos**
  - [Striver](https://www.youtube.com/watch?v=KEs5UyBJ39g)
  - [Kunal Kushwaha](https://www.youtube.com/watch?v=XLbvmMz8Fr8&t=3983s)
  - [Dinesh Varani](https://www.youtube.com/watch?v=44A_jk4_Rx8&list=PL6Zs6LgrJj3uyNihSkIq9QcNMylpR_9ba)
    
- **Documentation**
  - [Striver](https://takeuforward.org/hashing/hashing-maps-time-complexity-collisions-division-rule-of-hashing-strivers-a2z-dsa-course/)
  - [Bealdund Article](https://www.baeldung.com/sha-256-hashing-java) - **Recommended**
  - [Medium Article](https://medium.com/@alexthedev/hashing-in-java-f0436cd4284b) - **Recommended**
  - [JavaTPoint](https://www.javatpoint.com/hashing-algorithm-in-java)
  - [GFG](https://www.geeksforgeeks.org/hashing-in-java/)
