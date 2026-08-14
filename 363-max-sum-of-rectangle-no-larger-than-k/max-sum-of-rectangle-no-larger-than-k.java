
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        // Fix left column
        for (int left = 0; left < n; left++) {

            int[] rowSum = new int[m];

            // Fix right column
            for (int right = left; right < n; right++) {

                // Add current column to rowSum
                for (int row = 0; row < m; row++) {
                    rowSum[row] += matrix[row][right];
                }

                // Find max subarray sum <= k
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int prefixSum = 0;

                for (int sum : rowSum) {
                    prefixSum += sum;

                    // Need previous prefix >= prefixSum - k
                    Integer target = set.ceiling(prefixSum - k);

                    if (target != null) {
                        maxSum = Math.max(maxSum, prefixSum - target);
                    }

                    set.add(prefixSum);
                }

                // If we found k, this is the best possible answer
                if (maxSum == k) {
                    return k;
                }
            }
        }

        return maxSum;
    }
}