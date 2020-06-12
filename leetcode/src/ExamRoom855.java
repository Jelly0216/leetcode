import java.util.TreeSet;

class ExamRoom855 {
    private int N;
    private TreeSet<Interval> room;
    private TreeSet<Integer> students;
    public ExamRoom855(int N) {
        this.N = N;
        this.room = new TreeSet<>();
        this.students = new TreeSet<>();
        room.add(new Interval(-1, N));
        students.add(-1);
        students.add(N);
    }

    public int seat() {
        Interval toSeat = room.pollFirst();
        int res = -1;
        if (toSeat.left == -1) {
            room.add(new Interval(0, toSeat.right));
            students.add(0);
            res = 0;
        }
        else if (toSeat.right == N) {
            room.add(new Interval(toSeat.left, N - 1));
            students.add(N - 1);
            res = N - 1;
        }
        else {
            res = toSeat.left + toSeat.distance;
            room.add(new Interval(toSeat.left, res));
            room.add(new Interval(res, toSeat.right));
            students.add(res);
        }
        return res;
    }

    public void leave(int p) {
        students.remove(p);
        int left = students.floor(p);
        int right = students.ceiling(p);
        Interval lInterval = new Interval(left, p);
        Interval rInterval = new Interval(p, right);
        room.remove(lInterval);
        room.remove(rInterval);
        room.add(new Interval(left, right));
    }

    private class Interval implements Comparable<Interval> {
        int left;
        int right;
        int distance;
        Interval(int left, int right) {
            this.left = left;
            this.right = right;
            this.distance = this.getDistance();
        }

        @Override
        public int compareTo(Interval another) {
            if (this.left == another.left && this.right == another.right) {
                return 0;
            }
            if (this.distance != another.distance) {
                return another.distance - this.distance;
            }
            else {
                return this.left - another.left;
            }
        }

        private int getDistance() {
            if (this.left == -1) {
                return this.right;
            }
            else if (this.right == N) {
                return N - this.left - 1;
            }
            else {
                return (this.right - this.left) / 2;
            }
        }
    }

    public static void main(String[] args) {
        ExamRoom855 er = new ExamRoom855(10);
        er.seat();
        er.seat();
        er.seat();
        er.seat();
        er.leave(4);
        er.seat();
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */