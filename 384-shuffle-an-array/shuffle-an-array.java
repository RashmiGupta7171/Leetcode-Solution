class Solution {
    private int[] original;
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.nums = nums.clone();
        this.random = new Random();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */