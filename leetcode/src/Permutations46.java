public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] array, int index, List<List<Integer>> res) {
        if (index == array.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : array) {
                curr.add(num);
            }
            res.add(curr);
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, res);
            swap(array, index, i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
