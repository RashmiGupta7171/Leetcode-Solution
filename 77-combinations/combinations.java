class Solution {
    public void backtrack(List<List<Integer>> res , int n , int k , int start , List<Integer> comb){
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i = start  ; i <= n ; i++){
            comb.add(i);
            backtrack(res , n , k , i+1 , comb);
            comb.remove(comb.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res , n , k , 1 , new ArrayList<>());
        return res;
    }
}