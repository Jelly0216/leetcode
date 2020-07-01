public class SubtreeofAnotherTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t) ;
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return helper(node1.left, node2.left) && helper(node1.right, node2.right);
    }
}
