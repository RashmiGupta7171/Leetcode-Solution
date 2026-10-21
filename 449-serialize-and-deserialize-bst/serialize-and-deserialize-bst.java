/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Serialize the tree into a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize the string back into a tree
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        int[] index = {0};

        return build(values, index, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private TreeNode build(String[] values, int[] index, long min, long max) {
        if (index[0] >= values.length) {
            return null;
        }

        int val = Integer.parseInt(values[index[0]]);

        if (val <= min || val >= max) {
            return null;
        }

        index[0]++;

        TreeNode root = new TreeNode(val);
        root.left = build(values, index, min, val);
        root.right = build(values, index, val, max);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;