class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        // Sort by width ascending.
        // If width is same, sort height descending.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // Find LIS of heights
        int[] dp = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            // Binary search
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (dp[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = height;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}