 class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (sum < desiredTotal) {
            return false;
        }
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }

        int[] memo = new int[1 << maxChoosableInteger];

        return dfs(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean dfs(int max, int remaining, int used, int[] memo) {

        if (memo[used] != 0) {
            return memo[used] == 1;
        }
        for (int i = 1; i <= max; i++) {

            int mask = 1 << (i - 1);

            if ((used & mask) != 0) {
                continue;
            }

            if (i >= remaining ||
                !dfs(max, remaining - i, used | mask, memo)) {

                memo[used] = 1;
                return true;
            }
        }
        memo[used] = -1;
        return false;
    }
}