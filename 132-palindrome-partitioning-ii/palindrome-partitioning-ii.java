class Solution {
    public int minCut(String s) {
        int n = s.length();

        // isPalindrome[i][j] = true if s[i...j] is a palindrome
        boolean[][] isPalindrome = new boolean[n][n];

        // Precompute palindrome substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        // dp[i] = minimum cuts needed for s[0...i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i; // maximum cuts
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}