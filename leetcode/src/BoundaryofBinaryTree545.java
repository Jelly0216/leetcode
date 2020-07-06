public class BoundaryofBinaryTree545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        if (root == null) {
            return leftView;
        }
        if (root.left == null && root.right == null) {
            leftView.add(root.val);
            return leftView;
        }
        List<Integer> rightView = new ArrayList<>();
        List<Integer> leaves = new ArrayList<Integer>();
        leftView.add(root.val);
        getLeft(root.left, leftView);
        getRight(root.right, rightView);
        getLeaves(root, leaves);
        Collections.reverse(rightView);
        leftView.addAll(leaves);
        leftView.addAll(rightView);
        return leftView;
    }

    private void getLeft(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
        if (root.left != null) {
            getLeft(root.left, res);
        }
        else {
            getLeft(root.right, res);
        }
    }
    private void getRight(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
        if (root.right != null) {
            getRight(root.right, res);
        }
        else {
            getRight(root.left, res);
        }
    }
    private void getLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        getLeaves(root.left, res);
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        getLeaves(root.right, res);
    }
}
