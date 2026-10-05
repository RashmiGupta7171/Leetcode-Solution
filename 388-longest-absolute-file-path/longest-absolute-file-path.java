class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");

        int[] length = new int[lines.length + 1];
        int max = 0;

        for (String line : lines) {
            int level = 0;

            while (line.startsWith("\t")) {
                level++;
                line = line.substring(1);
            }

            if (line.contains(".")) {
                max = Math.max(max, length[level] + line.length());
            } else {
                length[level + 1] = length[level] + line.length() + 1;
            }
        }

        return max;
    }
}