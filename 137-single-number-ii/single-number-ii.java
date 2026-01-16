
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Check each bit position
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }

            // If count is not multiple of 3, set this bit
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
