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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    return preOrder(root, new ArrayList<>());
    }
    public List<Integer>preOrder(TreeNode node , List<Integer>ans){
        if(node == null){
            return ans;
        }
        ans.add(node.val);
        preOrder(node.left,ans);
        preOrder(node.right,ans);
        return ans;
    }
}