import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, res);
        return res;
    }

    private void helper(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left + right == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            helper(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(')');
            helper(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
