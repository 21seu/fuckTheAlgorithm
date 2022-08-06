import java.util.Arrays;

/**
 * Created by fengtj on 2022/8/6 16:47
 */
public class LC_135Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int res = left[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
            res += Math.max(right[i], left[i]);
        }
        return res;
    }
}
