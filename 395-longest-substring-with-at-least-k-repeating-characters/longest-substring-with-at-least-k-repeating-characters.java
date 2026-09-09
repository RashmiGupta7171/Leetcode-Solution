class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }

        return solve(s, 0, s.length() - 1, k);
    }

    private int solve(String s, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }

        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = left; i <= right; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find a character whose frequency is less than k
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);

            if (freq[c - 'a'] < k) {

                // Split around this invalid character
                int leftPart = solve(s, left, i - 1, k);
                int rightPart = solve(s, i + 1, right, k);

                return Math.max(leftPart, rightPart);
            }
        }

        // Every character appears at least k times
        return right - left + 1;
    }
}