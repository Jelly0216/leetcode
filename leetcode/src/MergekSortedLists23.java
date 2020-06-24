import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val) {
                    return 0;
                }
                return l1.val < l2.val ? -1 : 1;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode currNode = minHeap.poll();
            curr.next = currNode;
            curr = curr.next;
            if (currNode.next != null) {
                minHeap.offer(currNode.next);
            }
        }
        return dummy.next;
    }
}
