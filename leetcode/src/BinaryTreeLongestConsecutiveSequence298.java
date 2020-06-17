public class BinaryTreeLongestConsecutiveSequence298 {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res) + 1;
        int right = helper(root.right, res) + 1;
        if (root.left != null && root.left.val - 1 != root.val) {
            left = 1;
        }
        if (root.right != null && root.right.val - 1 != root.val) {
            right = 1;
        }
        int currMax = Math.max(left, right);
        res[0] = Math.max(res[0], currMax);
        return currMax;
    }
}
