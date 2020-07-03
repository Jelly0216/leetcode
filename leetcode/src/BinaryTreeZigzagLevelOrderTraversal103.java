import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode curr = deque.pollLast();
                    currLevel.add(curr.val);
                    if (curr.left != null) {
                        deque.offerFirst(curr.left);
                    }
                    if (curr.right != null) {
                        deque.offerFirst(curr.right);
                    }
                }
                else {
                    TreeNode curr = deque.pollFirst();
                    currLevel.add(curr.val);
                    if (curr.right != null) {
                        deque.offerLast(curr.right);
                    }
                    if (curr.left != null) {
                        deque.offerLast(curr.left);
                    }
                }
            }
            level++;
            res.add(currLevel);
        }
        return res;
    }
}
