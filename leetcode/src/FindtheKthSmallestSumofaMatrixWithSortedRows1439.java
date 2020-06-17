import java.util.*;

public class FindtheKthSmallestSumofaMatrixWithSortedRows1439 {
    public int kthSmallest(int[][] mat, int k) {
        if (mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Ele> minHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Ele e1, Ele e2) {
                int sum1 = getSum(mat, e1.array);
                int sum2 = getSum(mat, e2.array);
                if (sum1 == sum2) {
                    return 0;
                }
                return sum1 < sum2 ? -1 : 1;
            }
        });

        int[] array = new int[m];
        Ele curr = new Ele(array);
        minHeap.offer(curr);
        Set<Ele> visited = new HashSet<>();
        visited.add(curr);
        while (k > 1) {
            curr = minHeap.poll();
            for (int i = 0; i < m; i++) {
                Ele copyEle = new Ele(curr.array);
                copyEle.array[i]++;
                if (copyEle.array[i] < n && visited.add(copyEle)) {
                    minHeap.offer(copyEle);
                }
            }
            k--;
        }
        Ele res = minHeap.peek();
        return getSum(mat, res.array);
    }

    private int getSum(int[][] nums, int[] index) {
        int sum = 0;
        for (int i = 0; i < index.length; i++) {
            sum += nums[i][index[i]];
        }
        return sum;
    }



    private static class Ele {
        int[] array;
        Ele(int[] arr) {
            this.array = Arrays.copyOf(arr, arr.length);
        }



        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(!(obj instanceof Ele)) {
                return false;
            }
            Ele another = (Ele) obj;
            return Arrays.equals(array, another.array);
        }

        @Override
        public int hashCode() {
            int hash = 0;
            int m = array.length - 1;
            for (int i = 0; i <= m; i++) {
                int code = array[i];
                for (int j = 0; j <= m; j++) {
                    code = code * 31;
                }
                hash += code;
            }
            return hash;
        }
    }
}
