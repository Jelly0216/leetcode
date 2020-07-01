public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int val = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || val > 0) {
            if (i >= 0) {
                val += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                val += num2.charAt(j) - '0';
                j--;
            }

            sb.append(val % 10);
            val /= 10;
        }
        return sb.reverse().toString();
    }
}
