
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(toList(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip duplicates
            if (!canPermutate(start, i, nums))
                continue;

            swap(start, i, nums);
            backtrack(result, nums, start + 1);
            swap(start, i, nums);
        }
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        return list;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean canPermutate(int start, int cur, int[] nums) {
        for (int i = start; i < cur; i++) {
            if (nums[i] == nums[cur]) {
                return false;
            }
        }
        return true;
    }
}
