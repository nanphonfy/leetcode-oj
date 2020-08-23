import java.util.ArrayList;
import java.util.List;

/**
 * @author nanphonfy(南风zsr)
 * @date 2020/8/23
 */
public class KidsWithCandies1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = candies[i] > max ? candies[i] : max;
        }

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
