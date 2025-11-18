class Solution {
    public void solve(int[] candidates , int target , List<Integer> curr , int idx , List<List<Integer>> result){
        if(target < 0)
        return;

        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx ; i < candidates.length ; i++){
            if(i > idx && candidates[i] == candidates[i - 1])
            continue;
            curr.add(candidates[i]);
            solve(candidates , target-candidates[i] , curr , i+1 , result);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);
        solve(candidates , target , curr , 0 , result);

        return result;
        
    }
}