// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();
//         return ans;
//     }
//     private void solve(String curr , int open , int closed , int total ,List<String> ans){
//         if(curr.length() == 2 * total){
//             ans.add(curr);
//             return;
//         }
//         if(open < total){
//             solve(curr + "(" , open+1 , closed, total ,ans);
//         }
//         if(closed < open){
//             solve(curr + ")" , open , closed+1 , total , ans);
//         }
//     }
// }


import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve("", 0, 0, n, ans);
        return ans;
    }

    private void solve(String curr, int open, int closed, int total, List<String> ans) {
        // Base case: if the current string length equals 2 * total, it's a valid combination
        if (curr.length() == 2 * total) {
            ans.add(curr);
            return;
        }

        // Add an opening bracket if we still have some left
        if (open < total) {
            solve(curr + "(", open + 1, closed, total, ans);
        }

        // Add a closing bracket if we can (only if open > closed)
        if (closed < open) {
            solve(curr + ")", open, closed + 1, total, ans);
        }
    }
}
