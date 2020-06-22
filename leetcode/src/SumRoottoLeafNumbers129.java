public class SumRoottoLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, 0, res);
        return res[0];
    }

    private void helper(TreeNode root, int currSum, int[] res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currSum += root.val;
            res[0] += currSum;
            return;
        }
        currSum += root.val;
        helper(root.left, currSum * 10, res);
        helper(root.right, currSum * 10, res);
    }
}
