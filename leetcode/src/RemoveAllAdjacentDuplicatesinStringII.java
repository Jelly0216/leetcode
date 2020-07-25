public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast <s.length(); fast++, slow++) {
            array[slow] = array[fast];
            if (slow == 0 || array[slow] != array[slow - 1]) {
                stack.offerFirst(1);
            }
            else {
                int curr = stack.pollFirst();
                if (curr + 1 == k) {
                    slow -= k;
                }
                else {
                    stack.offerFirst(curr + 1);
                }
            }
        }
        return new String(array, 0, slow);
    }
}
