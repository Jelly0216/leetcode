public class ReorganizeString767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            }
            else {
                map.put(ch, count + 1);
            }
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count) {
                    return 0;
                }
                return p1.count > p2.count ? -1 : 1;
            }
        });
        for (char key : map.keySet()) {
            if (map.get(key) > (S.length() + 1) / 2) {
                return "";
            }
            maxHeap.offer(new Pair(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            Pair p1 = maxHeap.poll();
            Pair p2 = maxHeap.poll();
            sb.append(p1.ch);
            sb.append(p2.ch);

            if (p1.count - 1 > 0) {
                p1.count--;
                maxHeap.offer(p1);
            }
            if (p2.count - 1 > 0) {
                p2.count--;
                maxHeap.offer(p2);
            }
        }
        if (maxHeap.size() > 0) {
            sb.append(maxHeap.poll().ch);
        }
        return sb.toString();
    }

    private static class Pair {
        int count;
        char ch;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
