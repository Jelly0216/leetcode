package gs;

public class maxSubstring1163 {
    public String maxSubstring(String s) {
        int i = 0;
        int j = 1;
        int k = 0;
        int n = s.length();
        while (j + k < n) {
            char ch1 = s.charAt(i + k);
            char ch2 = s.charAt(j + k);
            if (ch1 == ch2) {
                k++;
                continue;
            }
            else if (ch1 < ch2) {
                i = Math.max(i + k + 1, j);
                j = i + 1;
            }
            else {
                j += k + 1;
            }
            k = 0;
        }
        return s.substring(i);
    }
}
