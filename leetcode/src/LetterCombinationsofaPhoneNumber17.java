public class LetterCombinationsofaPhoneNumber17 {
    private final String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(digits, 0, sb, res);
        return res;
    }

    private void helper(String digits, int index, StringBuilder sb, List<String> res) {
        if (digits.length() != index && strs[digits.charAt(index) - '0'].equals("")) {
            index++;
        }
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < strs[digit].length(); i++) {
            sb.append(strs[digit].charAt(i));
            helper(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
