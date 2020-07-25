package gs;

public class doesCircleExist1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int i = 0;
        final int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int j = 0; j < instructions.length(); j++) {
            if (instructions.charAt(j) == 'R') {
                i = (i + 1) % 4;
            }
            else if (instructions.charAt(j) == 'L') {
                i = (i + 3) % 4;
            }
            else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        return x == 0 && y == 0 || i > 0;
    }
}
