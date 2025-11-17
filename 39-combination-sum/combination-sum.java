class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> ans) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remaining) {
                current.add(candidates[i]);
                backtrack(candidates, remaining - candidates[i], i, current, ans); // i (not i+1) because repetition allowed
                current.remove(current.size() - 1);
            }
        }
    }
}
