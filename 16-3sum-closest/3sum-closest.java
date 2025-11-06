class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); 
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total == target) {
                    return total;
                }
                if (Math.abs(total - target) < Math.abs(closestSum - target)) {
                    closestSum = total;
                }
                if (total < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
