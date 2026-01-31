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
// class Solution {

//     public void flatten(TreeNode root) {
//         if (root == null) return;

//         flatten(root.left);
//         flatten(root.right);

//         TreeNode rightSubtree = root.right;

//         root.right = root.left;
//         root.left = null;

//         TreeNode curr = root;
//         while (curr.right != null) {
//             curr = curr.right;
//         }

//         curr.right = rightSubtree;
//     }
// }

class Solution{
    public void flatten(TreeNode root){
        if(root ==null)
        return;
        while(root != null){
            if(root.left != null){
                TreeNode left = root.left;
                TreeNode current = left;

                while(current.right != null)
                current = current.right;
                current.right = root.right;
                root.left = null;
                root.right = left;
            }
            root = root.right;
        }
    }
}