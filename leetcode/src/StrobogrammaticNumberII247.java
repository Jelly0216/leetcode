import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*   there are n / 2 levels
*   each level represents 5 branchs that we should add to the string
*   base case is if only one character left, wee add 1, 8 or 0
*   otherwise return null
*/
public class StrobogrammaticNumberII247 {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("1", "8", "0"));
        }
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (String str : list) {
            if (n != m) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        return res;
    }
}
