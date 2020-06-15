import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        helper(candidates, target, 0, curr, res);
        return res;
    }

    private void helper(int[] num, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = start; i < num.length; i++) {
            curr.add(num[i]);
            helper(num, target - num[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
