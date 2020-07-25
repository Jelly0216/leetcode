public class LongestStringChain1048 {
    public int longestStrChain(String[] words) {
        int res = 0;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            res = Math.max(res, helper(word, set, map));
        }
        return res;
    }

    private int helper(String word, Set<String> set, Map<String, Integer> map) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            String next = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(next)) {
                count = Math.max(count, helper(next, set, map));
            }
        }
        map.put(word, count + 1);
        return count + 1;
    }
}
