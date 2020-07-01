import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] M = new boolean[s.length() + 1];
        M[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && set.contains(s.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[s.length() ];
    }
}
