class Solution {

    PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> large =
        new PriorityQueue<>();

    HashMap<Integer, Integer> delayed = new HashMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] result = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        result[0] = getMedian(k);

        for (int i = k; i < n; i++) {

            add(nums[i]);
            remove(nums[i - k]);

            result[i - k + 1] = getMedian(k);
        }

        return result;
    }

    private void add(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    private void remove(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;

            if (num == small.peek()) {
                prune(small);
            }
        } else {
            largeSize--;

            if (!large.isEmpty() && num == large.peek()) {
                prune(large);
            }
        }

        balance();
    }

    private void balance() {

        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } 
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (delayed.containsKey(num)) {

                delayed.put(num, delayed.get(num) - 1);

                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }

                heap.poll();
            } else {
                break;
            }
        }
    }

    private double getMedian(int k) {

        if (k % 2 == 1) {
            return (double) small.peek();
        }

        return ((double) small.peek() + (double) large.peek()) / 2.0;
    }
}
