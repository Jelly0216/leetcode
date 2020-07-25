public class SumofNodeswithEvenValuedGrandparent1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        int res = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                    if (curr.val % 2 == 0) {
                        if (curr.left.left != null) {
                            res += curr.left.left.val;
                        }
                        if (curr.left.right != null) {
                            res += curr.left.right.val;
                        }
                    }
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    if (curr.val % 2 == 0) {
                        if (curr.right.left != null) {
                            res += curr.right.left.val;
                        }
                        if (curr.right.right != null) {
                            res += curr.right.right.val;
                        }
                    }
                }
            }
        }
        return res;
    }
}
