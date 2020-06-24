import java.util.HashMap;
import java.util.Map;

public class VerifyinganAlienDictionary953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        search:
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (map.get(word1.charAt(j)) > map.get(word2.charAt(j))) {
                        return false;
                    }
                    continue search;
                }
            }
            if (word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
