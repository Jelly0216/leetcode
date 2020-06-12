public class LowestCommonAncestorofDeepestLeaves1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode[] res = new TreeNode[1];
        int[] deepest = new int[1];
        helper(root, 0, res, deepest);
        return res[0];
    }

    private int helper(TreeNode root, int depth, TreeNode[] res, int[] deepest) {
        deepest[0] = Math.max(deepest[0], depth);
        if (root == null) {
            return depth;
        }
        int left = helper(root.left, depth + 1, res, deepest);
        int right = helper(root.right, depth + 1, res, deepest);
        if (left == deepest[0] && right == deepest[0]) {
            res[0] = root;
        }
        return Math.max(left, right);
    }
}
