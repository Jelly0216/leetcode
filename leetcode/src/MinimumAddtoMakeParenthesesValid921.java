public class MinimumAddtoMakeParenthesesValid921 {
    public int minAddToMakeValid(String S) {
        int res = 0;
        int balance = 0;
        for (int i = 0; i < S.length(); i++) {
            balance += S.charAt(i) == '(' ? 1 : -1;
            if (balance == -1) {
                res++;
                balance++;
            }
        }
        return res + balance;
    }
}
