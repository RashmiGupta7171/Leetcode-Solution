
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int remain, int start) {
        // Base case
        if (temp.size() == k && remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Pruning
        if (temp.size() > k || remain < 0) return;

        for (int i = start; i <= 9; i++) {
            temp.add(i); // choose
            backtrack(result, temp, k, remain - i, i + 1); // explore
            temp.remove(temp.size() - 1); // undo (backtrack)
        }
    }
}