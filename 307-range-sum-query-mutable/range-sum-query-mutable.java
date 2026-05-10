class NumArray {

    int[] bit;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    private void add(int index, int val) {
        index++;

        while (index <= n) {
            bit[index] += val;
            index += index & -index;
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        add(index, diff);
    }

    private int prefixSum(int index) {
        index++;
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */