import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        pushLeft(root1, stack1);
        pushLeft(root2, stack2);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack2.isEmpty() || !stack1.isEmpty() && stack1.peekFirst().val <= stack2.peekFirst().val) {
                root1 = stack1.pollFirst();
                res.add(root1.val);
                root1 = root1.right;
                pushLeft(root1, stack1);
            }
            else {
                root2 = stack2.pollFirst();
                res.add(root2.val);
                root2 = root2.right;
                pushLeft(root2, stack2);
            }
        }
        return res;
    }

    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}
