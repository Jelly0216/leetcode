import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeandDeserializeBST449 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(',');
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        return helper1(list);
    }

    private TreeNode helper1(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = helper1(list);
        root.right = helper1(list);
        return root;
    }
}
