class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distance = dx * dx + dy * dy;

                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (int freq : map.values()) {
                count += freq * (freq - 1);
            }
        }

        return count;
    }
}