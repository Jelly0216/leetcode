public class LargestBSTSubtree333 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private Pair helper(TreeNode root, int[] res) {
        if (root == null) {
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Pair left = helper(root.left, res);
        Pair right = helper(root.right, res);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Pair(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        res[0] = Math.max(res[0], size);
        return new Pair(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
    private static class Pair {
        int size;
        int lower;
        int upper;
        Pair (int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
