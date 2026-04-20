class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit
        int diff = xor & (-xor);

        int x = 0, y = 0;

        // Step 3: Divide into two groups and XOR
        for (int num : nums) {
            if ((num & diff) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }
}