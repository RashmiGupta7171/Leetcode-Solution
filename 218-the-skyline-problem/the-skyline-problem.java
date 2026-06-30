class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]});  
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        pq.offer(0);
        map.put(0, 1);

        int prevHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                h = -h;
                pq.offer(h);
                map.put(h, map.getOrDefault(h, 0) + 1);
            } else {
                map.put(h, map.get(h) - 1);
            }

            while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }

            int currHeight = pq.peek();

            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}