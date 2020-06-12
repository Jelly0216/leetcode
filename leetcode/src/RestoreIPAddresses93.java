import java.util.ArrayList;
import java.util.List;

/**
 * There are 4 levels and each level represents 3 branches that we can add 1, 2 or 3 number to res
 *
 * base case: if index == 4, if we used all the number, add to the res, otheerwise no
 * recursion rule: each time try to add 1, 2 or 3 numbers,
 */

public class RestoreIPAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(s, sb, res, 0, 0);
        return res;
    }

    private void helper(String s, StringBuilder sb, List<String> res, int index, int offset) {
        if (index == 4) {
            if (sb.length() == s.length() + 4) {
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        if (offset < s.length()) {
            sb.append(s.charAt(offset)).append(".");
            helper(s, sb, res, index + 1, offset + 1);
            sb.delete(sb.length() - 2, sb.length());
        }

        if (offset + 1 < s.length()) {
            char a = s.charAt(offset);
            char b = s.charAt(offset + 1);
            if (a != '0') {
                sb.append(a).append(b).append(".");
                helper(s, sb, res, index + 1, offset + 2);
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        if (offset + 2 < s.length()) {
            char a = s.charAt(offset);
            char b = s.charAt(offset + 1);
            char c = s.charAt(offset + 2);
            if (a == '1' || a == '2' && b >= '0' && b < '5' || a == '2' && b == '5' && c >= '0' && c <= '5') {
                sb.append(a).append(b).append(c).append(".");
                helper(s, sb, res, index + 1, offset + 3);
                sb.delete(sb.length() - 4, sb.length());
            }
        }

    }
}
