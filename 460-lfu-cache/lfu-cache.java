class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Increase frequency
        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Update existing key
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            updateFrequency(node);
            return;
        }

        // Remove LFU key when cache is full
        if (cache.size() == capacity) {

            LinkedHashSet<Integer> keys = freqMap.get(minFreq);

            // Remove least recently used key among minimum frequency
            int evictKey = keys.iterator().next();

            keys.remove(evictKey);
            cache.remove(evictKey);

            if (keys.isEmpty()) {
                freqMap.remove(minFreq);
            }
        }

        // Insert new key with frequency 1
        Node newNode = new Node(key, value);

        cache.put(key, newNode);

        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>())
                .add(key);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        LinkedHashSet<Integer> keys = freqMap.get(oldFreq);
        keys.remove(node.key);

        // If this was the minimum frequency and no keys remain
        if (oldFreq == minFreq && keys.isEmpty()) {
            minFreq++;
        }

        // Increase frequency
        node.freq++;

        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>())
                .add(node.key);
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */