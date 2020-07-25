public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, sum, curr, res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                curr.add(root.val);
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }

        curr.add(root.val);
        helper(root.left, sum - root.val, curr, res);
        helper(root.right, sum - root.val, curr, res);
        curr.remove(curr.size() - 1);
    }
}
