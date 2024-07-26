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
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("Bharat", 21);
        map.put("Deepak", 25);
        map.put("Raj", 28);

        // Retrieve a value using a key
        System.out.println("Age of Bharat: " + map.get("Bharat"));

        // Check if key is present or not
        System.out.println(map.containsKey("Bharat"));

        // Display the hash codes of the keys
        for (String key : map.keySet()) {
            System.out.println("Hash code for " + key + ": " + key.hashCode());
        }

        // Iterate over the map
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        
        // Iterate over the map
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            System.out.println(it.getKey() + ": " + it.getValue());
        }

        // Handle a hash collision example
        String key1 = "FB"; // Example of hash collision with key2
        String key2 = "Ea";

        System.out.println("Hash code for " + key1 + ": " + key1.hashCode());
        System.out.println("Hash code for " + key2 + ": " + key2.hashCode());

        // Add the keys to the map
        map.put(key1, 50);
        map.put(key2, 60);

        // Retrieve the values
        System.out.println("Value for " + key1 + ": " + map.get(key1));
        System.out.println("Value for " + key2 + ": " + map.get(key2));
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
