public class AddBoldTaginString616 {
    public String addBoldTag(String s, String[] dict) {
        boolean[] array = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String str : dict) {
                if (s.startsWith(str, i)) {
                    end = Math.max(end, i + str.length());
                }
            }
            array[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!array[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && array[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }
}
