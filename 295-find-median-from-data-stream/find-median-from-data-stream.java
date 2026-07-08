class MedianFinder {

    // Max Heap (stores smaller half)
    private PriorityQueue<Integer> small;

    // Min Heap (stores larger half)
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to max heap
        small.offer(num);

        // Move the largest from small to large
        large.offer(small.poll());

        // Balance the heaps
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */