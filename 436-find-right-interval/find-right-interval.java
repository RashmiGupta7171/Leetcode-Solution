import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        // Store start value and its original index
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < n; i++) {
            // Find the smallest start >= current interval's end
            Integer key = map.ceilingKey(intervals[i][1]);

            if (key == null)
                ans[i] = -1;
            else
                ans[i] = map.get(key);
        }

        return ans;
    }
}