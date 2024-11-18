// Question Link: https://leetcode.com/problems/lfu-cache/


class LFUCache {

    // Maximum capacity of the cache
    private int capacity;

    // Minimum frequency of keys currently in cache
    private int minFreq = 0; 

    // Maps key to its value
    private Map<Integer, Integer> keyToVal = new HashMap<>(); 

    // Maps key to its frequency
    private Map<Integer, Integer> keyToFreq = new HashMap<>(); 

    // Maps frequency to an ordered set of keys
    private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>(); 

    // Constructor to initialize the LFUCache with given capacity
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    // Get the value associated with a key, updating its frequency
    public int get(int key) {
        // If key not present, return -1
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        // Get current frequency of the key
        final int freq = keyToFreq.get(key); 

        // Remove key from current frequency list
        freqToLRUKeys.get(freq).remove(key); 
        
         // If no more keys at minFreq
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq); // Remove empty list
            ++minFreq; // Increment minFreq
        }

        // Increase key's frequency by 1 and add to next frequency's list
        putFreq(key, freq + 1);

        // Return the value associated with the key
        return keyToVal.get(key); 
    }

    // Put key-value pair in the cache, managing capacity and frequency
    public void put(int key, int value) {
        
        if (capacity == 0) // If capacity is zero, do nothing
            return;

        if (keyToVal.containsKey(key)) { // If key exists, update value and frequency
            keyToVal.put(key, value); // Update value
            get(key); // Update key's frequency using get method
            
            return;
        }

        // If cache is at capacity
        if (keyToVal.size() == capacity) { 
            // Evict least recently used key from minFreq list
            final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();

            freqToLRUKeys.get(minFreq).remove(keyToEvict); // Remove from minFreq list
            keyToVal.remove(keyToEvict); // Remove from keyToVal map
            keyToFreq.remove(keyToEvict); // Remove from keyToFreq map
        }

        minFreq = 1; // Reset minFreq for new key
        putFreq(key, minFreq); // Set new key's frequency to 1
        keyToVal.put(key, value); // Add new key-value pair
    }

    // Helper function to update the frequency of a key
    private void putFreq(int key, int freq) {
        keyToFreq.put(key, freq); // Update key's frequency
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>()); // Create freq list if absent
        
        freqToLRUKeys.get(freq).add(key); // Add key to its new frequency list
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
