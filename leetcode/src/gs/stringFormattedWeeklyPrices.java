package gs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class stringFormattedWeeklyPrices {
    public List<String> stringFormattedWeeklyPrices(List<Integer> dailyPrice) {
        int n = dailyPrice.size();
        //double[] res = new double[n - 6];
        List<String> res = new ArrayList<>();
        int sum = 0;
        DecimalFormat f = new DecimalFormat("##.00");
        for (int i = 0; i <= n; i++) {
            if (i >= 7) {
                String avg = f.format(sum / 7.0);
                res.add(avg);
                sum -= dailyPrice.get(i - 7);
            }
            if (i < n) {
                sum += dailyPrice.get(i);
            }
        }
        return res;
    }
}
