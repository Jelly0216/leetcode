import java.util.ArrayDeque;

public class BinarySearchTreeIterator173 {
    Deque<TreeNode> stack;
    public BinarySearchTreeIterator173(TreeNode root) {
        this.stack = new ArrayDeque<>();
        pushLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode node = stack.pollFirst();
        pushLeft(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}
