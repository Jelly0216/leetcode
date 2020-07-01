public class ConcatenatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if(helper(word, set)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean helper(String word, Set<String> set) {
        for (int i = 1; i < word.length(); i++) {
            if (set.contains(word.substring(0, i))) {
                String right = word.substring(i);
                if (set.contains(right) || helper(right, set)) {
                    return true;
                }
            }
        }
        return false;
    }
}
