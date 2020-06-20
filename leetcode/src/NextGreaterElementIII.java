/*
    1. find the first descending number from tail: i
    2. find the last number greater than num[i] one the right hand of i: j
    3. swap(i, j)
    4. reverse from i + 1 to the end of array
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] array = ("" + n).toCharArray();
        int i = array.length - 2;
        while (i >= 0 && array[i + 1] <= array[i]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = i + 1;
        while (j + 1< array.length && array[j + 1] > array[i]) {
            j++;
        }
        swap(array, i, j);
        reverse(array, i + 1, array.length - 1);
        long val = Long.valueOf(new String(array));
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }
}
