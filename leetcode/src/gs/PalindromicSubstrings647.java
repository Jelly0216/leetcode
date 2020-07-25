package gs;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings647 {
    public int palindromicSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i, set);
            helper(s, i, i + 1, set);
        }
        return set.size();
    }

    private void helper(String s, int left, int right, Set<String> set) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            set.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }
}
