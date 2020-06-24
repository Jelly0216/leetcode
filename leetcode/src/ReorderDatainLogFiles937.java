import java.util.Arrays;
import java.util.Comparator;

public class ReorderDatainLogFiles937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<>(){
            @Override
            public int compare(String str1, String str2) {
                String[] strs1 = str1.split(" ", 2);
                String[] strs2 = str2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(strs1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(strs2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int compare = strs1[1].compareTo(strs2[1]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}
