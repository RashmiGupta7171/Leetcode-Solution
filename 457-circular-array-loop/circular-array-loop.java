class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, slow, forward);
                if (slow == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);
                if (fast == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

            // Mark visited elements as zero
            int j = i;
            while (nums[j] != 0 && (nums[j] > 0) == forward) {
                int next = ((j + nums[j]) % n + n) % n;
                nums[j] = 0;
                j = next;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int i, boolean forward) {
        int n = nums.length;

        if (nums[i] == 0 || (nums[i] > 0) != forward) {
            return -1;
        }

        int next = ((i + nums[i]) % n + n) % n;

        if (next == i) {
            return -1;
        }

        return next;
    }
}