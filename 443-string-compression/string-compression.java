class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;

        while (i < n) {
            char current = chars[i];
            int count = 0;

            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}