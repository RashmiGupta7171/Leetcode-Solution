class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] dp = new int[n];
        dp[0] = 1;

        int[] index = new int[k];
        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                next = Math.min(next, (long) dp[index[j]] * primes[j]);
            }

            dp[i] = (int) next;
            for (int j = 0; j < k; j++) {
                if ((long) dp[index[j]] * primes[j] == next) {
                    index[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}