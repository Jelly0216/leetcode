import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemovetoMakeValidParentheses1249 {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerFirst(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                }
                else {
                    stack.pollFirst();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pollFirst());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
