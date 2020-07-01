import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator224 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0;
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (ch - '0');
            }
            else if (ch == '+') {
                res += sign * operand;
                sign = 1;
                operand = 0;
            }
            else if (ch == '-') {
                res += sign * operand;
                sign = -1;
                operand = 0;
            }
            else if (ch == '(') {
                stack.offerFirst(res);
                stack.offerFirst(sign);
                sign = 1;
                res = 0;
            }
            else if (ch == ')') {
                res += sign * operand;
                res *= stack.pollFirst();
                res += stack.pollFirst();
                operand = 0;
            }
        }
        return res + sign * operand;
    }
}
