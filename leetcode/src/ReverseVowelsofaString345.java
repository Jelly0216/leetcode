public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !set.contains(array[left])) {
                left++;
            }
            while (right > left && !set.contains(array[right])) {
                right--;
            }
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
