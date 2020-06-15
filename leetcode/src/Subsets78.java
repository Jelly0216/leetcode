import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null){
            throw new IllegalArgumentException();
        }
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, curr, res);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (nums.length == index) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        helper(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);

        helper(nums, index + 1, curr ,res);
    }
}

