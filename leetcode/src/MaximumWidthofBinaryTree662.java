public class MaximumWidthofBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        int res = 0;
        while (!q.isEmpty()) {
            Pair head = q.peek();
            int size = q.size();
            Pair curr = null;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                TreeNode currNode = curr.key;
                if (currNode.left != null) {
                    q.offer(new Pair(currNode.left, 2 * curr.value));
                }
                if (currNode.right != null) {
                    q.offer(new Pair(currNode.right, 2 * curr.value + 1));
                }
            }
            res = Math.max(res, curr.value - head.value + 1);
        }
        return res;
    }

    private class Pair {
        Integer value;
        TreeNode key;
        Pair(TreeNode key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
