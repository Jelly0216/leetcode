public class DiameterofBinaryTree543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[]{1};
        helper(root, res);
        return res[0] - 1;
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int currMax = left + right + 1;
        res[0] = Math.max(res[0], currMax);
        return Math.max(left, right) + 1;
    }
}
