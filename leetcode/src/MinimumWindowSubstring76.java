public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            }
            else {
                map.put(ch, count + 1);
            }
        }
        int begin = 0;
        int min = Integer.MAX_VALUE;
        int k = map.size();
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count - 1);
                if (count - 1 == 0) {
                    k--;
                }
            }
            fast++;
            while (k == 0) {
                char h = s.charAt(slow);
                if (map.containsKey(h)) {
                    int count = map.get(h);
                    map.put(h, count + 1);
                    if (count + 1 > 0) {
                        k++;
                    }
                }
                if (fast - slow < min) {
                    min = fast - slow;
                    begin = slow;
                }
                slow++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(begin, begin + min);
    }
}
