class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {

            int[] rowSum = new int[m];

            for (int right = left; right < n; right++) {

                for (int row = 0; row < m; row++) {
                    rowSum[row] += matrix[row][right];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int prefixSum = 0;

                for (int sum : rowSum) {
                    prefixSum += sum;

                    Integer target = set.ceiling(prefixSum - k);

                    if (target != null) {
                        maxSum = Math.max(maxSum, prefixSum - target);
                    }

                    set.add(prefixSum);
                }

                if (maxSum == k) {
                    return k;
                }
            }
        }

        return maxSum;
    }
}