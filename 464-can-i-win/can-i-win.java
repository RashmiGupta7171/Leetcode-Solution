 class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        // If desired total is 0, first player wins
        if (desiredTotal <= 0) {
            return true;
        }

        // Sum of all available numbers
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        // If total sum is less than desired total, impossible to win
        if (sum < desiredTotal) {
            return false;
        }

        // If maximum number itself can reach the target
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }

        int[] memo = new int[1 << maxChoosableInteger];

        return dfs(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean dfs(int max, int remaining, int used, int[] memo) {

        // If this state was already calculated
        if (memo[used] != 0) {
            return memo[used] == 1;
        }

        // Try choosing every unused number
        for (int i = 1; i <= max; i++) {

            int mask = 1 << (i - 1);

            // Skip already used numbers
            if ((used & mask) != 0) {
                continue;
            }

            // If this number wins immediately
            // OR opponent cannot win after this move
            if (i >= remaining ||
                !dfs(max, remaining - i, used | mask, memo)) {

                memo[used] = 1;
                return true;
            }
        }

        // No winning move exists
        memo[used] = -1;
        return false;
    }
}