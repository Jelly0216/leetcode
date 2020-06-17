public class BinaryTreeLongestConsecutiveSequenceII549 {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int[] helper(TreeNode root, int[] res) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int increase = 1;
        int decrease = 1;
        if (root.left != null) {
            int[] left = helper(root.left, res);
            if (root.val == root.left.val - 1) {
                increase = left[0] + 1;
            }
            else if (root.val == root.left.val + 1) {
                decrease = left[1] + 1;
            }
        }

        if (root.right != null) {
            int[] right = helper(root.right, res);
            if (root.val == root.right.val - 1) {
                increase = Math.max(increase, right[0] + 1);
            }
            else if (root.val == root.right.val + 1) {
                decrease = Math.max(decrease, right[1] + 1);
            }
        }

        res[0] = Math.max(res[0], increase + decrease - 1);
        return new int[]{increase, decrease};

    }


}
