import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long ans = 0;

        Map<Long, Long>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                long count = dp[j].getOrDefault(diff, 0L);

                ans += count;

                dp[i].put(diff,
                    dp[i].getOrDefault(diff, 0L) + count + 1);
            }
        }

        return (int) ans;
    }
}