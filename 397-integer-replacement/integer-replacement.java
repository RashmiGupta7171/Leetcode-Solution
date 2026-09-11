class Solution {
    public int integerReplacement(int n) {
        long num = n; // Use long to avoid integer overflow
        int count = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                // If even, divide by 2
                num /= 2;
            } else {
                // If odd, choose +1 or -1
                if (num == 3 || num % 4 == 1) {
                    num--;
                } else {
                    num++;
                }
            }

            count++;
        }

        return count;
    }
}

