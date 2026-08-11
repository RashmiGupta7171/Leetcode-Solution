

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */


class SummaryRanges {

    private TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        if (set.isEmpty()) {
            return new int[0][0];
        }

        int[][] temp = new int[set.size()][2];
        int index = 0;

        Integer start = null;
        Integer prev = null;

        for (int num : set) {
            if (start == null) {
                start = num;
            } 
            else if (num != prev + 1) {
                temp[index][0] = start;
                temp[index][1] = prev;
                index++;

                start = num;
            }

            prev = num;
        }

        // Add the last interval
        temp[index][0] = start;
        temp[index][1] = prev;
        index++;

        // Return only the required intervals
        int[][] result = new int[index][2];

        for (int i = 0; i < index; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }

        return result;
    }
}