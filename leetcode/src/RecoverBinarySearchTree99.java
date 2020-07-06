public class RecoverBinarySearchTree99 {
    TreeNode one;
    TreeNode two;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        if (one != null && two != null) {
            int temp = one.val;
            one.val = two.val;
            two.val = temp;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev == null) {
            prev = root;
        }
        else {
            if (prev.val > root.val) {
                if (one == null) {
                    one = prev;
                }
                two = root;
            }
            prev = root;
        }
        helper(root.right);
    }
}
