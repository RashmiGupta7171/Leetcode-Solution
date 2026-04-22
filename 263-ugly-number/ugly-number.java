class Solution {
    public boolean isUgly(int n) {
        // Edge case
        if (n <= 0) return false;

        // Divide by 2, 3, and 5
        int[] factors = {2, 3, 5};

        for (int f : factors) {
            while (n % f == 0) {
                n = n / f;
            }
        }

        // If reduced to 1 → ugly number
        return n == 1;
    }
}