public class StrobogrammaticNumber246 {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (!"00 11 69 96 88".contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
