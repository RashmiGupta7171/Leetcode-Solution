class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int length = 0;
        boolean hasOdd = false;

        for (int n : count) {
            length += (n / 2) * 2;

            if (n % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }

        return length;
    }
}