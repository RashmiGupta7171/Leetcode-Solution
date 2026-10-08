import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // Sort intervals by their ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int remove = 0;
        int end = intervals[0][1];

        // Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            
            // Overlapping interval
            if (intervals[i][0] < end) {
                remove++;
            } 
            else {
                // Non-overlapping, update end
                end = intervals[i][1];
            }
        }

        return remove;
    }
}