public class LongestHappyString1045 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count) {
                    return 0;
                }
                return p1.count > p2.count ? -1 : 1;
            }
        });
        if (a > 0) {
            maxHeap.offer(new Pair('a', a));
        }
        if (b > 0) {
            maxHeap.offer(new Pair('b', b));
        }
        if (c > 0) {
            maxHeap.offer(new Pair('c', c));
        }
        while (maxHeap.size() > 1) {
            Pair curr1 = maxHeap.poll();
            if (curr1.count >= 2) {
                sb.append(curr1.ch);
                sb.append(curr1.ch);
                curr1.count -= 2;
            }
            else {
                sb.append(curr1.ch);
                curr1.count -= 1;
            }

            Pair curr2 = maxHeap.poll();
            if (curr2.count >= 2 && curr1.count < curr2.count) {
                sb.append(curr2.ch);
                sb.append(curr2.ch);
                curr2.count -= 2;
            }
            else {
                sb.append(curr2.ch);
                curr2.count -= 1;
            }

            if (curr1.count > 0) {
                maxHeap.offer(curr1);
            }
            if (curr2.count > 0) {
                maxHeap.offer(curr2);
            }
        }

        if (!maxHeap.isEmpty()) {
            if (sb.charAt(sb.length() - 1) != maxHeap.peek().ch) {
                if (maxHeap.peek().count >= 2) {
                    sb.append(maxHeap.peek().ch);
                    sb.append(maxHeap.peek().ch);
                }
                else {
                    sb.append(maxHeap.peek().ch);
                }
            }
        }
        return sb.toString();
    }


    static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
