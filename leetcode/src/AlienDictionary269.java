public class AlienDictionary269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> dict = new HashSet<>();
        for (char i = 'a'; i <= 'z'; i++) {
            graph.put(i, new HashSet<>());
        }
        int[] incoming = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                dict.add(words[i].charAt(j));
            }
            if (i > 0) {
                int test = compare(words[i - 1], words[i], graph, incoming);
                if (test == -1) {
                    return "";
                }
            }
        }
        Queue<Character> q = new ArrayDeque<>();
        for (char ch : graph.keySet()) {
            if (incoming[ch - 'a'] == 0 && dict.contains(ch)) {
                q.offer(ch);
            }
        }
        String res = "";
        while (!q.isEmpty()) {
            char curr = q.poll();
            dict.remove(curr);
            res += curr;
            for (char next : graph.get(curr)) {
                if (!dict.contains(next)) {
                    return "";
                }
                incoming[next - 'a']--;
                if (incoming[next - 'a'] == 0) {
                    q.offer(next);
                }
            }
        }
        return dict.size() == 0 ? res : "";
    }


    private int compare(String word1, String word2, Map<Character, Set<Character>> graph, int[] incoming) {
        int i = 0;
        while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) {
            i++;
        }
        if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return -1;
        }
        if (i == word1.length() || i == word2.length()) {
            return 0;
        }
        char x = word1.charAt(i);
        char y = word2.charAt(i);
        if (x != y && graph.get(x).add(y)) {
            incoming[y - 'a']++;
        }
        return 0;
    }
}
