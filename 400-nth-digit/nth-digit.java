class Solution {
    public int findNthDigit(int n) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Find the range containing the nth digit
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number
        long num = start + (n - 1) / digitLength;

        // Find the digit inside that number
        int index = (int) ((n - 1) % digitLength);

        String s = String.valueOf(num);

        return s.charAt(index) - '0';
    }
}