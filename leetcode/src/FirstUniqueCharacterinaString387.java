public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            }
            else {
                map.put(c, count + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
