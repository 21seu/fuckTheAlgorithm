import java.util.Arrays;

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2
 * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出：4.00000
 * 输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * 输出：4.77778
 *
 * 20 <= arr.length <= 1000
 * arr.length 是 20 的 倍数
 * 0 <= arr[i] <= 105
 */
public class LC_1619MeanOfArrayAfterRemovingSomeElements {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int minIndex = (int) Math.floor(len * 0.05);
        int maxIndex = (int) (len - Math.floor(len * 0.05) - 1);
        int sum = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            sum += arr[i];
        }
        double ans = Double.valueOf(sum);
        return ans / (maxIndex - minIndex + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        new LC_1619MeanOfArrayAfterRemovingSomeElements().trimMean(arr);
    }
}
