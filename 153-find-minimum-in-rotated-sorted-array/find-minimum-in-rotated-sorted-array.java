
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum is in the right part
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Minimum is in the left part including mid
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}