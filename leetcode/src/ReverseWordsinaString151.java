public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            }
            array[slow++] = array[fast];
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        reverse(array, 0, slow - 1);
        int start = 0;
        for (int i = 0; i < slow; i++) {
            if (i == 0 || array[i - 1] == ' ') {
                start = i;
            }
            else if (i == slow - 1 || array[i + 1] == ' ') {
                reverse(array, start, i);
            }
        }
        return new String(array, 0, slow);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
