
import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null) {
                flag = true;
            }
            else if (flag) {
                return false;
            }
            else {
                q.offer(curr.left);
            }

            if (curr.right == null) {
                flag = true;
            }
            else if (flag) {
                return false;
            }
            else {
                q.offer(curr.right);
            }
        }
        return true;
    }
}
