import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorldBreakII140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String>[] M = new ArrayList[s.length() + 1];
        List<String> initial = new ArrayList<>();
        initial.add("");
        M[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (M[j].size() > 0 && set.contains(s.substring(j, i))) {
                    for (String l : M[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            M[i] = list;
        }
        return M[s.length()];
    }
}
