class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;

        for (int digit : b) {
            result = (pow(result, 10) * pow(a, digit)) % MOD;
        }

        return result;
    }

    private int pow(int a, int n) {
        int result = 1;
        a %= MOD;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            n >>= 1;
        }

        return result;
    }
}