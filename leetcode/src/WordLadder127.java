import java.util.*;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < sb.length(); j++) {
                    char ori = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == ori) {
                            continue;
                        }
                        sb.setCharAt(j, k);
                        String temp = sb.toString();
                        if (endWord.equals(temp)) {
                            res++;
                            return res;
                        }
                        if (set.contains(temp) && visited.add(temp)) {
                            q.offer(temp);
                        }
                    }
                    sb.setCharAt(j, ori);
                }
            }
        }
        return 0;
    }
}
