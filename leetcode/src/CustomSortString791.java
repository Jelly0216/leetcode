public class CustomSortString791 {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            while (count[S.charAt(i) - 'a']-- > 0) {
                sb.append(S.charAt(i));
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (count[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
