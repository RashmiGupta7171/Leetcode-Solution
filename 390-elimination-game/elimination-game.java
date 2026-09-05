class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;

        while (n > 1) {
            // Head changes when eliminating from left
            // or when eliminating from right with odd count
            if (left || n % 2 == 1) {
                head += step;
            }

            n /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}