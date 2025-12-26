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
    private boolean isValidBSTHelper(TreeNode node , long min , long max){
        if(node == null){
            return true;
        }
        if(!isValidBSTHelper(node.left , min , node.val)){
            return false;
        }
         if(!isValidBSTHelper(node.right , node.val , max)){
            return false;
        }
        if(!(node.val < max && node.val > min)){
            return false;
        }
        return true;
    }
     private boolean isValidBSTHelper(TreeNode root){
        if(root == null){
            return false;
        }
        if(!isValidBSTHelper(root.left , (long)(Integer.MIN_VALUE) - 1 , root.val)){
            return false;
        }
        if(!isValidBSTHelper(root.right , root.val , (long)(Integer.MAX_VALUE) + 1)){
            return false;
        }
        return true;
     }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root);
    }
}