class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 1) return nums[0];
        
        // Case 1: exclude last house
        int case1 = robLinear(nums, 0, n - 2);
        
        // Case 2: exclude first house
        int case2 = robLinear(nums, 1, n - 1);
        
        return Math.max(case1, case2);
    }
    
    // Helper function for normal House Robber (linear)
    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0; // max till previous house
        int prev2 = 0; // max till house before previous
        
        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            
            int curr = Math.max(pick, notPick);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}