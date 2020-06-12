public class ValidParenthesisString678 {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            }
            else if (c == ')') {
                max--;
                min = Math.max(min - 1, 0);
            }
            else {
                max++;
                min = Math.max(min - 1, 0);
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }
}
