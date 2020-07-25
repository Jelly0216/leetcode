public class TwoSumBSTs1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        helper1(root1, set);
        if (helper2(root2, set, target)) {
            return true;
        }
        return false;
    }

    private void helper1(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        helper1(root.left, set);
        set.add(root.val);
        helper1(root.right, set);
    }

    private boolean helper2(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        return helper2(root.left, set, target) || helper2(root.right, set, target);
    }
}
