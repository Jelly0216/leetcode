import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(k, n, 1, curr, res);
        return res;
    }

    private void helper(int k, int n, int start, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() > k) {
            return;
        }
        if (curr.size() == k && n == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n && i <= 9; i++) {
            curr.add(i);
            helper(k, n - i, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
