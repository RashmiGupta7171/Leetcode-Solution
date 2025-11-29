class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty()) {
                ans.add(intervals[i]);
            } else {
                int[] last = ans.get(ans.size() - 1);  
                int y = last[1];

                if (intervals[i][0] <= y) {
                    last[1] = Math.max(y, intervals[i][1]);
                } 
                else {
                    ans.add(intervals[i]);
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
