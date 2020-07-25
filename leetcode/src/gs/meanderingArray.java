package gs;

import java.util.Arrays;

public class meanderingArray {
    public int[] meanderingArray(int[] unsorted) {
        Arrays.sort(unsorted);
        int i = 0;
        int j = unsorted.length - 1;
        int[] res = new int[j + 1];
        int index = 0;
        while (i <= j) {
            res[index++] = unsorted[i++];
            res[index++] = unsorted[j--];
        }
        return res;
    }
}
