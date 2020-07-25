public class BinarySearchTreetoGreaterSumTree1038 {
    int prev = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        if (prev != 0) {
            root.val += prev;
        }
        prev = root.val;
        helper(root.left);
    }
}
