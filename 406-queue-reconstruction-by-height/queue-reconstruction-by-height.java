class Solution {
    public int[][] reconstructQueue(int[][] people) {

   java.util.Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            return a[1] - b[1];
        });

        java.util.List<int[]> queue = new java.util.ArrayList<>();
 
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}