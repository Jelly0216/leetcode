public class EmployeeFreeTime759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        for (List<Interval> jobs : schedule) {
            for (Interval job : jobs) {
                list.add(job);
            }
        }
        Collections.sort(list, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return 0;
                }
                return i1.start < i2.start ? -1 : 1;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if (curr.start > temp.end) {
                res.add(new Interval(temp.end, curr.start));
                temp = curr;
            }
            else {
                temp = curr.end > temp.end ? curr : temp;
            }
        }
        return res;
    }
}
