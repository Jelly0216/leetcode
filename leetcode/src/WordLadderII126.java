import java.util.*;

public class WordLadderII126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!set.contains(endWord)) {
            return res;
        }
        Queue<List<String>> q = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.offer(list);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> subSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> currList = q.poll();
                String currWord = currList.get(currList.size() - 1);
                StringBuilder sb = new StringBuilder(currWord);
                for (int j = 0; j < sb.length(); j++) {
                    char ori = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        List<String> currCopy = new ArrayList<>(currList);
                        if (k == ori) {
                            continue;
                        }
                        sb.setCharAt(j, k);
                        String temp = sb.toString();
                        currCopy.add(temp);
                        if (temp.equals(endWord)) {
                            res.add(currCopy);
                        }
                        if (set.contains(temp) && !visited.contains(temp)) {
                            subSet.add(temp);
                            q.offer(currCopy);
                        }
                    }
                    sb.setCharAt(j, ori);
                }
            }
            visited.addAll(subSet);
            if (res.size() > 0) {
                return res;
            }
        }
        return res;
    }
}
