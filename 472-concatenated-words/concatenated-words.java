class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {

            if (word.length() == 0) {
                continue;
            }
            if (canForm(word, set)) {
                result.add(word);
            }

            // Add current word to the set
            set.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> set) {

        int n = word.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
