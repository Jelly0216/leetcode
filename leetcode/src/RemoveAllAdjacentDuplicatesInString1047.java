public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] array = S.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
            else if (array[fast] == array[slow - 1]) {
                slow--;

            }
        }
        return new String(array, 0, slow);
    }
}
