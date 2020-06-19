public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
    }

    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.left = null;
        root.right = prev[0];
        prev[0] = root;
    }
}
