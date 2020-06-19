public class StringCompression443 {
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        while (fast < chars.length) {
            int begin = fast;
            while (fast < chars.length && chars[fast] == chars[begin]) {
                fast++;
            }
            chars[slow++] = chars[begin];
            int length = fast - begin;
            if (length != 1) {
                slow += helper(chars, slow, length);
            }
        }
        return slow;
    }

    private int helper(char[] chars, int slow, int count) {
        int len = 0;
        for (int i = count; i > 0; i /= 10) {
            len++;
            slow++;
        }

        for (int i = count; i > 0; i /= 10) {
            int digit = i % 10;
            chars[--slow] = (char)(digit + '0');
        }
        return len;
    }
}
