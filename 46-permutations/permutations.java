 class Solution {

    public void getPerms(List<Integer> nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.size()) {
            ans.add(new ArrayList<>(nums)); // push current permutation
            return;
        }

        for (int i = idx; i < nums.size(); i++) {
            // swap nums[idx] with nums[i]
            int temp = nums.get(idx);
            nums.set(idx, nums.get(i));
            nums.set(i, temp);

            getPerms(nums, idx + 1, ans);

            // swap back (backtrack)
            temp = nums.get(idx);
            nums.set(idx, nums.get(i));
            nums.set(i, temp);
        }
    }

    public List<List<Integer>> permute(int[] numsArray) {
        List<Integer> nums = new ArrayList<>();
        for (int n : numsArray) nums.add(n);

        List<List<Integer>> ans = new ArrayList<>();
        getPerms(nums, 0, ans);
        return ans;
    }
}
