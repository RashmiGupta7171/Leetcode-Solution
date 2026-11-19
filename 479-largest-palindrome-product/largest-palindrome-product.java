class Solution {
    public int largestPalindrome(int n) {

        if (n == 1) {
            return 9;
        }

        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);

        for (int i = upper; i >= lower; i--) {

            long palindrome = i;
            long x = i;

            // Generate palindrome by reversing digits
            while (x > 0) {
                palindrome = palindrome * 10 + x % 10;
                x /= 10;
            }

            // Check whether palindrome can be divided
            for (long j = upper; j * j >= palindrome; j--) {

                if (palindrome % j == 0) {

                    long other = palindrome / j;

                    if (other <= upper && other >= lower) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return 0;
    }
}