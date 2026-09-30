class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';
            count[index]++;

            maxFreq = Math.max(maxFreq, count[index]);

            // Characters that need to be replaced
            int replacements = (right - left + 1) - maxFreq;

            // If replacements exceed k, shrink window
            while (replacements > k) {
                count[s.charAt(left) - 'A']--;
                left++;

                replacements = (right - left + 1) - maxFreq;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}