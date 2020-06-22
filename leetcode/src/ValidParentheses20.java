import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (!stack.isEmpty() && stack.peekFirst() == map.get(ch)) {
                    stack.pollFirst();
                }
                else {
                    return false;
                }
            }
            else {
                stack.offerFirst(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
