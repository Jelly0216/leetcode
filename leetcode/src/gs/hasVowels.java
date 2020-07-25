package gs;

import java.util.*;

public class hasVowels {
    public int[] hasVowels(String[] strArr, String[] query) {
        int[] M = new int[strArr.length + 1];
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> set = new HashSet<>(list);
        for (int i = 0; i < strArr.length; i++) {
            if (set.contains(strArr[i].charAt(0))) {
                M[i + 1] = M[i] + 1;
            }
            else {
                M[i + 1] = M[i];
            }
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] strs = query[i].split("-");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            res[i] = M[end] - M[start - 1];
        }
        return res;
    }
}
