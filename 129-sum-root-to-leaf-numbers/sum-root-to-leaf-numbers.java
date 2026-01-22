/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//  class Solution {

//     public int sumNumbers(TreeNode root) {
//         return dfs(root, 0);
//     }

//     private int dfs(TreeNode node, int current) {
//         if (node == null) {
//             return 0;
//         }

//         // Build the number along the path
//         current = current * 10 + node.val;

//         // If it's a leaf, return the number formed
//         if (node.left == null && node.right == null) {
//             return current;
//         }

//         // Recurse for left and right subtrees
//         return dfs(node.left, current) + dfs(node.right, current);
//     }
// }
class Solution{
    int sum = 0;
    public void sumNum(TreeNode node , int num){
        num = num*10 + node.val;
        if(node.left == null && node.right == null){
            sum = sum + num;
            return ;
        }
        if(node.left != null)
        sumNum(node.left , num);
        if(node.right != null)
        sumNum(node.right , num);
    }
    public int sumNumbers(TreeNode root){
        sumNum(root , 0);
        return sum;
    }
}