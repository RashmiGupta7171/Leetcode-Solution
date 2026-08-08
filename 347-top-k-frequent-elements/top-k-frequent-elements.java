
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap: stores elements based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Add elements to heap
        for (int num : map.keySet()) {
            pq.add(num);

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Store result
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}