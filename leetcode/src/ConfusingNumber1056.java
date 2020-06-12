import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber1056 {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap();
        map.put(1,1);
        map.put(0,0);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        int temp = N;
        int res = 0;
        while(temp > 0){
            int mod = temp % 10;
            Integer rev = map.get(mod);
            if(rev == null) {
                return false;
            }
            res = 10 * res + rev;
            temp /= 10;
        }

        return res != N;
    }
}
