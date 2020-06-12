import java.util.ArrayList;
import java.util.List;

/*
use dfs traverse graph and use int[] array to store result.
 */
public class NestedListWeightSum339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int[] res = new int[1];
        helper(nestedList, 1, res);
        return res[0];
    }

    private void helper(List<NestedInteger> nestedList, int depth, int[] res) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res[0] = res[0] + n.getInteger() * depth;
            }
            else {
                helper(n.getList(), depth + 1, res);
            }
        }
    }

    private class NestedInteger {

        boolean isInteger() {
            return true;
        }

        List<NestedInteger> getList(){
            return new ArrayList<>();
        }

        int getInteger() {
            return 1;
        }
    }
}
