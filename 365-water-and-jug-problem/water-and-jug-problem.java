class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // Total capacity is less than target
        if (x + y < target) {
            return false;
        }

        // If target is 0, it is always possible
        if (target == 0) {
            return true;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}