public class EmployeeImportance690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> q = new ArrayDeque<>();
        q.offer(map.get(id));
        int res = 0;
        while (!q.isEmpty()) {
            Employee employee = q.poll();
            res += employee.importance;
            for (int sub : employee.subordinates) {
                q.offer(map.get(sub));
            }
        }
        return res;
    }
}
